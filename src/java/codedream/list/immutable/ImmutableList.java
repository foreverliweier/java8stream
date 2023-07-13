package codedream.list.immutable;


import java.util.Iterator;
import java.util.List;

/**
 *   jdk 9
 *
 * @author alice
 * @time 2023-07-13 11:40
 **/
public class ImmutableList {
    public static void main(String[] args) {
        //java 9 以上版本新增加方法 List.of,创建不可变的列表
        List<String> nameList = List.of("方大同","赵丽颖","李明");
        Iterator it = nameList.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        for (String s : nameList) {
            System.out.println(s);
        }

        for (int i = 0; i < nameList.size(); i++) {
            System.out.println(nameList.get(i));
        }
        //会报运行错误
//        nameList.remove(1);
//        nameList.add("黄小米");
    }
}
