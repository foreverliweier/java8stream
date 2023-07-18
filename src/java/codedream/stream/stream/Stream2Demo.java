package codedream.stream.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author alice
 * @time 2023-07-14 12:17
 **/
public class Stream2Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "张靓影-30-女", "赵丽颖-30-女", "蔡依林-30-女", "周杰伦-30-男", "蔡文姬-310-女", "马超-30-男", "貂蝉-20-女", "张朝-33-男", "马超-30-男");
        list.stream().forEach(s -> System.out.println(s));

        Map<String ,Integer> map = list.stream().filter(s -> "男".equals(s.split("-")[2])).distinct().
                collect(Collectors.toMap(s -> s.split("-")[0], s -> Integer.parseInt(s.split("-")[1])));
        System.out.println(map);

        List<String> list2 = list.stream().filter(s -> s.startsWith("张")).collect(Collectors.toList());
        System.out.println(list2);

        System.out.println("-----------");
        List<String> list3 = list.stream().filter(s -> s.split("-")[1].equals("30")).collect(Collectors.toList());
        System.out.println(list3);

        System.out.println("-----------");
        List<String> list4 = list.stream().filter(s -> "女".equals(s.split("-")[2])).collect(Collectors.toList());
        System.out.println(list4);


    }
}
