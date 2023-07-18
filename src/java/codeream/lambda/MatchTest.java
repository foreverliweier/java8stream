package codeream.lambda;

import org.junit.Test;

import java.util.List;

import static codeream.lambda.Author.getGenAuthors;

/**
 * 返回的是 true/false
 *
 * @author alice
 * @time 2023-07-17 14:56
 **/
public class MatchTest {
    @Test
    public void printAgeMore50Author() {
        List<Author> authors = getGenAuthors();
        //anyMatch 判断是否存在年龄在 50 岁及以上的作家
        System.out.println(authors.stream().distinct().anyMatch(author -> author.getAge().compareTo(50) >= 0));
    }

    @Test
    public void printAllAuthorAreAdults() {
        //allMatch 判断是否所有的作者都是成年人
        List<Author> authors = getGenAuthors();
        System.out.println(authors.stream().allMatch(author -> author.getAge() >= 18));
    }
    @Test
    public void printAllAuthorAreAdults3() {
        //noneMatch 判断所有的作家是否都没有超过 60 岁
        List<Author> authors = getGenAuthors();
        System.out.println(authors.stream().noneMatch(author -> author.getAge() > 60));
    }





}
