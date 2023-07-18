package codedream.quote;

import codedream.lambda.Author;
import org.junit.Test;

import java.util.List;

import static codedream.lambda.Author.getGenAuthors;

/**
 * @author alice
 * @time 2023-07-18 13:18
 **/
public class QuoteTest {
    @Test
    public void test1(){
        List<Author> authors = getGenAuthors();
        StringBuilder sb =  new StringBuilder();
        authors.forEach(author -> sb.append(author.getName()).append(","));
        System.out.println(sb);
        System.out.println(authors.stream().mapToLong(Author::getAge).sum());
    }
    @Test
    public void constructorQuoteTest(){
        List<Author> authors = getGenAuthors();
        authors.stream().map(Author::getName).map(StringBuilder::new).map(sb->sb.append("-测试").toString()).forEach(System.out::println);
    }
}
