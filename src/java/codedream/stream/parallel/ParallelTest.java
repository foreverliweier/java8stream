package codedream.stream.parallel;

import codedream.lambda.Author;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static codedream.lambda.Author.getGenAuthors;

/**
 * 并行流
 *
 * @author alice
 * @time 2023-07-18 13:35
 **/
public class ParallelTest {
    @Test
    public void serialStreamTest1() {
        Stream<Integer> streams = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = streams.
                filter(s -> s > 5).
                reduce(0, Integer::sum);
        System.out.println(sum);
    }

    @Test
    public void serialStreamTest2() {
        Stream<Integer> streams = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = streams.
                filter(i -> i > 5).
                reduce((i, j) -> i + j).
                get();
        System.out.println(sum);
    }

    @Test
    public void parallelTest() {
        Stream<Integer> streams = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = streams.
                parallel().
                peek(integer -> System.out.println(integer + Thread.currentThread().getName())).
                filter(s -> s > 5).
                reduce(0, Integer::sum);
        System.out.println(sum);
    }

    @Test
    public void parallelStreamTest() {
        List<Author> authors = getGenAuthors();
        int sum = authors.
                parallelStream().
                peek(author -> System.out.println(author.getName() + "," + Thread.currentThread().getName())).
                mapToInt(Author::getAge).
                filter(age -> age > 50).
                map(age -> age + 10).
                reduce(0, Integer::sum);
        System.out.println(sum);
    }


}
