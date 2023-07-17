package codedream.list.stream;


import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author alice
 * @time 2023-07-14 10:53
 **/
public class ArrayStreamDemo {
    public static void main(String[] args) {
        int[] arr1 = {12,22,14,1,2,1,443,55};
        String[] arr2 = {"a","v","c","d"};

        Arrays.stream(arr1).forEach(s-> System.out.println(s));
        System.out.println("#############");
        Arrays.stream(arr2).forEach(s-> System.out.println(s));
        System.out.println("#############");
        //基本类型不可以使用 Stream.of
        Stream.of(arr1).forEach(s-> System.out.println(s));
        System.out.println("#############");
        Stream.of(arr2).forEach(s-> System.out.println(s));
    }
}
