package lambda;

import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static lambda.Author.getGenAuthors;

/**
 * reduce 归并
 *
 * @author alice
 * @time 2023-07-17 15:16
 **/
public class ReduceTest {
    @Test
    public void printSumAgeOfAllAuthor() {
        //统计所有作者年龄之和
        List<Author> authors = getGenAuthors();
        Integer sum = authors.stream().distinct().map(author -> author.getAge()).reduce(0, (integer, integer2) -> integer + integer2).intValue();
        System.out.println(sum);
    }

    @Test
    public void printMaxAgeAllAuthor() {
        //统计所有作者中年龄最大值
        List<Author> authors = getGenAuthors();
        Integer max = authors.stream().distinct().map(author -> author.getAge()).reduce(Integer.MIN_VALUE, (integer, integer2) -> integer > integer2 ? integer : integer2);
        System.out.println(max);
    }

    @Test
    public void printMinAgeAllAuthor() {
        //统计所有作者中年龄最小值
        List<Author> authors = getGenAuthors();
        Integer min = authors.stream().distinct().map(author -> author.getAge()).reduce(Integer.MAX_VALUE, (integer, integer2) -> integer < integer2 ? integer : integer2);
        System.out.println(min);
    }

    @Test
    public void printMaxAgeAllAuthorSingleParam() {
        //统计所有作者中年龄最大值
        List<Author> authors = getGenAuthors();
        Optional<Integer> max = authors.stream().distinct().map(author -> author.getAge()).reduce((integer, integer2) -> integer > integer2 ? integer : integer2);
        max.ifPresent(System.out::println);
    }


}
