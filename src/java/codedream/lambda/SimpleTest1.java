package codedream.lambda;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author alice
 * @time 2023-07-17 11:27
 **/
interface MyInterface {
    void doSomething(String a);
}

public class SimpleTest1 {

    @Test
    public void testTraverse() {
        List<String> list = Arrays.asList("apple", "banana", "orange");
        list.forEach(System.out::println);
        System.out.println("-------------");
        list.forEach(s -> System.out.println(s + ","));
    }

    @Test
    public void testSort() {
        List<String> list = Arrays.asList("apple", "banana", "orange");
        Collections.sort(list, ((o1, o2) -> o1.compareTo(o2)));
        list.forEach(System.out::println);
        Collections.sort(list, (String::compareTo));
        list.forEach(System.out::println);
        Collections.sort(list, (Comparator.naturalOrder()));
        list.forEach(System.out::println);
    }

    @Test
    public void testFilter() {
        List<String> list = Arrays.asList("apple", "banana", "orange");
        list.stream().filter(s -> s.startsWith("a")).forEach(System.out::println);
        list.stream().map(s -> s.length()).collect(Collectors.toList()).forEach(System.out::print);
    }

    @Test
    public void testSum() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Integer sum = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);
    }

    @Test
    public void testGroup() {
        List<String> list = Arrays.asList("apple", "banana", "orange");
        Map<Integer, List<String>> groups = list.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(groups);
    }

    @Test
    public void interfaceTest() {
        MyInterface myi = System.out::println;
        myi.doSomething("hello world");
        MyInterface myi2 = s -> System.out.println("this context is " + s + "");
        myi2.doSomething("hi");
    }

    @Test
    public void threadGenerate() {
        Thread t = new Thread(() -> System.out.println("thread start"));
        t.start();
    }

    @Test
    public void stringTest() {
        String hello = "hello world";
        Optional.ofNullable(hello).map(String::toUpperCase).ifPresent(System.out::println);
    }

    @Test
    public void listOpr(){
        List<String> list = Arrays.asList("apple", "banana", "orange","ab");
        List<String> list2 = list.stream().filter(s->s.startsWith("a")).map(String::toUpperCase).sorted().collect(Collectors.toList());
        System.out.println(list2);
    }

}
