package codedream.stream.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author alice
 * @time 2023-07-14 10:46
 **/
public class StreamHandDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "张靓影", "赵丽颖", "蔡依林", "周杰伦", "蔡文姬", "马超", "貂蝉", "张朝", "马超");
        System.out.println("---------------------------");
        list.stream().filter(s -> s.startsWith("张")).forEach(s -> System.out.println(s));
        System.out.println("---------------------------");
        list.forEach(s -> System.out.println(s));
        //list 集合可以直接打印
        System.out.println(list);
        System.out.println("---------------------------");
        list.stream().skip(2).forEach(s-> System.out.println(s));
        System.out.println("---------------------------");
        list.stream().limit(3).forEach(s-> System.out.println(s));
        System.out.println("---------------------------");
        list.stream().distinct().forEach(s-> System.out.println(s));
        System.out.println("---------------------------");

        List<String> list2 = new ArrayList<>();
        Collections.addAll(list2,  "张超", "马汉","蔡文姬");
        System.out.println("---------------------------");
        Stream.concat(list.stream(),list2.stream()).forEach(s-> System.out.println(s));
        System.out.println("---------------------------");

        List<String> list3 = new ArrayList<>();
        Collections.addAll(list3, "张靓影-38", "赵丽颖-35", "蔡依林-42", "周杰伦-42", "蔡文姬-1500", "马超-1800", "貂蝉-500", "张朝-32", "马超-991");
        System.out.println("---------------------------");
        list3.stream().map(s->Integer.parseInt(s.split("-")[1])).forEach(s-> System.out.println(s));




    }



}
