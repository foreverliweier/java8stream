package codedream.lambda;

import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static codedream.lambda.Author.getGenAuthors;

/**
 * Find 返回的都是 Optional<T>
 *     
 * @author alice
 * @time 2023-07-17 15:08
 **/
public class FindTest {
    @Test
    public void printAgeMore50AnyAuthor() {
        //获取任意一个大于 50 的作家
        List<Author> authors = getGenAuthors();
        Optional<Author> optionalAuthor = authors.stream().filter(author -> author.getAge() > 50).findAny();
        optionalAuthor.ifPresent(System.out::println);
        optionalAuthor.ifPresent(author -> System.out.println(author.getName()));
    }

    @Test
    public void printAgeMore50FirstAuthor() {
        //获取第一个一个大于 50 的作家
        List<Author> authors = getGenAuthors();
        Optional<Author> authorOptional = authors.stream().sorted().filter(author -> author.getAge() > 50).findFirst();
        authorOptional.ifPresent(author -> System.out.println(author.getName()));
        authorOptional.ifPresent(System.out::println);
    }


}
