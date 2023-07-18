package codedream.stream.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author alice
 * @time 2023-07-17 11:01
 **/
public class Test01 {
    @Test
    public void printEvenNumber(){
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> list2 = list.stream().filter(integer -> 0 == (integer & 1)).collect(Collectors.toList());
        System.out.println(list2);
    }
    @Test
    public  void printAge24Person() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "zhangsan,23", "lisi,24", "wangwu,25");
        Map<String, Integer> map = list.stream().filter(s -> Integer.parseInt(s.split(",")[1]) >= 24).
                collect(Collectors.toMap(s -> s.split(",")[0], s -> Integer.parseInt(s.split(",")[1])));
        System.out.println(map);
    }
    @Test
    public  void printMapActors() {
        List<String> actors = new ArrayList<>();
        Collections.addAll(actors, "雷佳音,41", "郭麒麟,26", "白敬亭,30", "付辛博,33", "张国立,60");

        List<String> actress = new ArrayList<>();
        Collections.addAll(actress, "赵丽颖,35", "殷桃, 43", "杨幂,38", "赵露思,25", "宋祖儿, 25");

        Stream<String> stream1 = actors.stream().filter(s -> s.split(",")[0].length() == 3).limit(2);
        Stream<String> stream2 = actress.stream().filter(s -> s.startsWith("赵")).skip(1);
        Stream<String> stream3 = Stream.concat(stream1,stream2);

        List<Actor> reList = stream3.map(s -> new Actor(s.split(",")[0],Integer.parseInt(s.split(",")[1]))).collect(Collectors.toList());
        System.out.println(reList);
    }
    class Actor {
        String name;
        Integer age;

        public Actor(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Actor{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }


}
