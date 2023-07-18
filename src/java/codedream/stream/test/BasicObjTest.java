package codedream.stream.test;

import codedream.lambda.Author;
import org.junit.Test;

import java.util.List;

import static codedream.lambda.Author.getGenAuthors;

/**
 * @author alice
 * @time 2023-07-18 13:30
 **/
public class BasicObjTest {
    @Test
    public void testMapToInt() {
        List<Author> authors = getGenAuthors();
        authors.stream().mapToInt(Author::getAge).map(age -> age + 10).filter(age -> age > 18).map(age -> age + 2).forEach(System.out::println);
    }
}
