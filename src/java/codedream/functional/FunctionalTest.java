package codedream.functional;

import codedream.lambda.Author;
import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;

import static codedream.lambda.Author.getGenAuthors;

/**
 * 1.FunctionalInterface 注解
 * 2.或仅有一个抽象方法的接口
 *
 * @author alice
 * @time 2023-07-18 10:58
 **/
public class FunctionalTest {
    @Test
    public void predicateAnd() {
        List<Author> authorList = getGenAuthors();
        //authorList.stream().filter(author -> author.getAge() > 50).filter(author -> author.getName().length() >= 2).forEach(System.out::println);
        authorList.stream().filter(author -> author.getAge() > 50 && author.getName().length() >= 2).forEach(System.out::println);
        authorList.stream().filter(((Predicate<Author>) author -> author.getAge() > 50).and(author -> author.getName().length() >= 2)).forEach(System.out::println);
    }

    @Test
    public void predicateAnd2() {
        //打印偶数，并且大于 10
        predicateDefinedAnd(o -> o > 10, o -> (o & 1) == 0);
    }

    @Test
    public void predicateOr() {
        //打印偶数，或大于 10
        predicateDefinedOr(o -> o > 10, o -> (o & 1) == 0);
    }

    @Test
    public void predicateNo() {
        //打印作家不大于 50 岁的作家
        //一般不用这种方式
        List<Author> authorList = getGenAuthors();
        authorList.stream().filter(((Predicate<Author>) author -> author.getAge() > 50).negate()).forEach(System.out::println);
    }


    public void predicateDefinedOr(Predicate<Integer> predicate1, Predicate<Integer> predicate2) {
        int[] arrs = {12, 1, 30, 21, 13, 0, 10};
        for (int i = 0; i < arrs.length; i++) {
            if (predicate1.or(predicate2).test(arrs[i])) {
                System.out.println(arrs[i]);
            }
        }
    }

    public void predicateDefinedAnd(Predicate<Integer> predicate1, Predicate<Integer> predicate2) {
        int[] arrs = {12, 1, 30, 21, 13, 0, 10};
        for (int i = 0; i < arrs.length; i++) {
            if (predicate1.and(predicate2).test(arrs[i])) {
                System.out.println(arrs[i]);
            }
        }

    }
}
