package codedream.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author alice
 * @time 2023-07-17 14:56
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
class Book implements Comparable<Book> {
    Long id;
    String name;
    String intro;
    String category;
    Integer score;

    @Override
    public int compareTo(Book o) {
        return this.getId().compareTo(o.getId());
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", intro='" + intro + '\'' +
                ", category='" + category + '\'' +
                ", score=" + score +
                '}';
    }
}
