package codedream.stream.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alice
 * @time 2023-07-13 13:42
 **/
public class ListStreamDemo {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("李霄鹏");
        list.add("张靓影");
        list.add("张三");
        list.add("张无极");
        list.add("王宝强");

        //.所有以张开头的存放到新的集合中
        List<String> list2 = new ArrayList();
        for (String s : list) {
            if (s.startsWith("张")){
                list2.add(s);
            }
        }

        //所有以张开头，长度为 3 的元素再存储到新集合中
        List<String> list3 = new ArrayList();
        for (String s : list2) {
            if (s.length()==3){
                list3.add(s);
            }
        }
        //遍历打印最终结果
        for (String s : list2) {
            System.out.println(s);
        }
        System.out.println("---------");

        for (String s : list3) {
            System.out.println(s);
        }

        System.out.println("#######");

        list.stream().filter(name->name.startsWith("张")).filter(name->name .length()==3).forEach(name-> System.out.println(name));
        System.out.println("#######");
        list.stream().filter(name->name.startsWith("王")).filter(name->name.length()==3).forEach(name-> System.out.println(name));

    }
}
