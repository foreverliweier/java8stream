package codedream.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author alice
 * @time 2023-07-17 14:56
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Author implements Comparable<Author> {
    Long id;
    String name;
    String intro;
    Integer age;
    List<Book> books;
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Author author = (Author) o;
        return id.equals(author.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Author o) {
        return this.getAge().compareTo(o.getAge());
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", intro='" + intro + '\'' +
                ", age=" + age +
                ", books=" + books +
                '}';
    }

    public static List<Author> getGenAuthors() {
        List<Author> list = new ArrayList<>();
        List<Book> b1 = new ArrayList<>();
        Collections.addAll(b1, new Book(1L, "活着", "", "人文",99),
                new Book(3L, "湖畔", "", "人文",100));
        List<Book> b2 = new ArrayList<>();
        Collections.addAll(b2, new Book(22L, "Java快速编程", "", "科技",95),
                new Book(6L, "金字塔", "", "教育,科学",90),
                new Book(112L, "金线法", "", "人文",91),
                new Book(1L, "活着", "", "人文",99));
        List<Book> b3 = new ArrayList<>();
        Collections.addAll(b3, new Book(12L, "Python 快速入门", "", "科技",91),
                new Book(11L, "曾国藩全集", "", "历史,人文",69),
                new Book(34L, "脑科学", "", "教育,科学",79));

        Collections.addAll(list, new Author(1L, "张爱玲", "上海", 38, b1),
                new Author(2L, "余华", "安徽", 58, b2),
                new Author(3L, "莫言", "河南", 56, b3),
                new Author(3L, "莫言", "河南", 56, b3));
        return list;
    }

}
