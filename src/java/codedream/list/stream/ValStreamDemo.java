package codedream.list.stream;

import java.util.stream.Stream;

/**
 * @author alice
 * @time 2023-07-14 10:56
 **/
public class ValStreamDemo {
    public static void main(String[] args) {
        System.out.println("#############");
        Stream.of("a","b","c","d","e").forEach(s-> System.out.println(s));
        System.out.println("#############");
        Stream.of(1,33,89,100,36,12).forEach(s-> System.out.println(s));


    }
}
