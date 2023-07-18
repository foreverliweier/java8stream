package codedream.stream.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author alice
 * @time 2023-07-14 12:17
 **/
public class StreamEndDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "张靓影", "赵丽颖", "蔡依林", "周杰伦", "蔡文姬", "马超", "貂蝉", "张朝", "马超");
        list.stream().forEach(s -> System.out.println(s));
        System.out.println(list.stream().count());

        Object[] arr1 = list.stream().toArray();
        System.out.println(Arrays.toString(arr1));

        String[] arr2 = list.stream().toArray(value -> new String[value]);
        System.out.println(Arrays.toString(arr2));

        List<String> list1 = list.stream().filter(name->name.startsWith("张")).collect(Collectors.toList());
        System.out.println(list1);

        Set<String> list2 = list.stream().filter(name->name.length()==3).collect(Collectors.toSet());
        System.out.println(list2);




    }
}
