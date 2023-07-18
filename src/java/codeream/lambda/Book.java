package codeream.lambda;

/**
 * @author alice
 * @time 2023-07-17 14:56
 **/
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

    public Book(Long id, String name, String intro, String category, Integer score) {
        this.id = id;
        this.name = name;
        this.intro = intro;
        this.category = category;
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book(String name, String intro) {
        this.name = name;
        this.intro = intro;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
