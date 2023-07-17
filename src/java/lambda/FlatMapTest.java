package lambda;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static lambda.Author.getGenAuthors;

/**
 * @author alice
 * @time 2023-07-17 13:30
 **/
public class FlatMapTest {
    @Test
    public void printObjToMultiObj() {
        //打印出所有作家的所有书籍
        List<Author> authors = getGenAuthors();
        authors.stream().flatMap(author -> author.getBooks().stream()).distinct().forEach(System.out::println);
    }

    @Test
    public void printObjToMultiObj2() {
        //打印出所有作家的所有书籍中的所有分类
        List<Author> authors = getGenAuthors();
        authors.stream().flatMap(author -> author.getBooks().stream()).distinct().
                flatMap(book -> Arrays.stream(book.getCategory().split(","))).distinct().
                collect(Collectors.toList()).forEach(System.out::println);
    }

    @Test
    public void printAuthorNames() {
        //打印出所有作家的姓名
        List<Author> authors = getGenAuthors();
        authors.stream().distinct().forEach(author -> System.out.println(author.getName()));
    }

    @Test
    public void pringCount(){
        //获取所有作家中的所有书籍总数量
        List<Author> authors = getGenAuthors();
        System.out.println(authors.stream().distinct().flatMap(author -> author.getBooks().stream()).distinct().count());
    }
    @Test
    public void pringMaxOrMin(){
        //分别获取所有作家中的所有书籍的最高分和最低分
        List<Author> authors = getGenAuthors();
        System.out.println(authors.stream().distinct().flatMap(author -> author.getBooks().stream()).
                max(Comparator.comparingInt(Book::getScore)).get());
        System.out.println(authors.stream().distinct().flatMap(author -> author.getBooks().stream()).
                min((o1, o2) -> o1.getScore()-o2.getScore()).get());

        Integer max = authors.stream().distinct().flatMap(author -> author.getBooks().stream()).map(book->book.getScore()).
                max((o1, o2) -> o1-o2).get();
        Integer min = authors.stream().distinct().flatMap(author -> author.getBooks().stream()).map(book->book.getScore()).
                min(Comparator.comparingInt(o -> o)).get();
        System.out.println(max);
        System.out.println(min);
    }

    @Test
    public void pringAuthorNameList(){
        //获取一个存放所有作者名字的 List 集合
        List<Author> authors = getGenAuthors();
        List<String> list = authors.stream().map(author -> author.getName()).distinct().collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    public void pringAllBookSet(){
        //获取所有书的 set 集合
        List<Author> authors = getGenAuthors();
        Set<Book> books =  authors.stream().flatMap(author -> author.getBooks().stream()).collect(Collectors.toSet());
        System.out.println(books);
    }

    @Test
    public void pringAuthorMapInfo(){
        //获取一个 map 集合，map 的 key 作者名，value 为 list<Book>
        List<Author> authors = getGenAuthors();
        Map<String,List<Book>> map = authors.stream().distinct().
                collect(Collectors.toMap(author -> author.getName(), author -> author.getBooks()));
        System.out.println(map);
    }
}


