package codedream.stream.immutable;

import java.util.Iterator;
import java.util.Set;

/**
 *
 *  jdk 9
 * @author alice
 * @time 2023-07-13 11:54
 **/
public class ImmutableSet {
    public static void main(String[] args) {
        Set<Integer> ageSet = Set.of(32,20,22,18,26);
        for (Integer integer : ageSet) {
            System.out.println(integer);
        }

        Iterator<Integer> iterator =  ageSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator);
        }
        //没有这种方法
//        for (int i = 0; i < ageSet.size(); i++) {
//        }

    }
}
