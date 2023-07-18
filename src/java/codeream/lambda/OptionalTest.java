package codeream.lambda;

import org.junit.Test;

import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static codeream.lambda.Author.getGenAuthors;

/**
 * @author alice
 * @time 2023-07-18 08:54
 **/
public class OptionalTest {
    @Test
    public void optionalTest1() {
        Optional<Author> optionalAuthor = getAuthor();
        optionalAuthor.ifPresent(System.out::println);
        optionalAuthor.ifPresent(author -> System.out.println(author.getName()));
    }

    @Test
    public void optionalNullAbleTest() {
        Optional<Author> optionalAuthor = getNullAuthor();
        optionalAuthor.ifPresent(System.out::println);
    }

    @Test
    public void optionalNullTest() {
        //抛异常
        Optional<Author> optionalAuthor = getNullAuthor();
        optionalAuthor.ifPresent(System.out::println);
    }

    @Test
    public void optionalOGetElse() {
        Optional<Author> optionalAuthor = getNullAbleAuthor();
        //若optionalAuthor value 为空则默认返回一个对象
        optionalAuthor.orElseGet(() -> new Author());
        optionalAuthor.ifPresent(author -> System.out.println(author.getName()));
    }
    @Test
    public void optionalOGetElseThrow() throws Throwable {
        Optional<Author> optionalAuthor = getNullAbleAuthor();
        //若optionalAuthor value 为空则默认返回一个对象
        optionalAuthor.orElseThrow((Supplier<Throwable>) () -> new RuntimeException("数据为空"));
    }
    @Test
    public void optionalFilter(){
        Optional<Author> optionalAuthor = getAuthor();
        optionalAuthor.ifPresent(System.out::println);
        System.out.println("----------");
        //过滤不会改变optionalAuthor value 对应的对象
        optionalAuthor.filter(author -> author.getName().startsWith("张")).ifPresent(System.out::println);
        System.out.println("----------");
        optionalAuthor.ifPresent(System.out::println);
    }

    @Test
    public void optionalIsPresent(){
        Optional<Author> optionalAuthor = getAuthor();
        if (optionalAuthor.isPresent()) {
            System.out.println(optionalAuthor.get());
        }
    }

    @Test
    public void optionalMap(){
        Optional<Author> optionalAuthor = getAuthor();
        optionalAuthor.stream().flatMap(author -> author.getBooks().stream()).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("-------");
        optionalAuthor.map(author -> author.getBooks()).ifPresent(System.out::println);
    }


    public Optional<Author> getAuthor() {
        Random random = new Random();
        return Optional.ofNullable(getGenAuthors().get(random.nextInt(getGenAuthors().size()-1)));
    }

    public Optional<Author> getNullAbleAuthor(){
        return Optional.ofNullable(null);
    }

    public Optional<Author> getNullAuthor(){
        return Optional.of(null);
    }


}
