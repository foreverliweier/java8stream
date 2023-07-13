package codedream.list.immutable;

import java.util.Map;
import java.util.Set;

/**
 *  jdk 9
 * @author alice
 * @time 2023-07-13 11:57
 **/
public class ImmutableMap {
    public static void main(String[] args) {
        Map<String,Integer> actorMap = Map.of("王阳",32,"秦岚",42);
        Set<Map.Entry<String,Integer>> entrySet = actorMap.entrySet();
        for (Map.Entry<String, Integer> stringIntegerEntry : entrySet) {
            System.out.println(stringIntegerEntry.getKey()+","+stringIntegerEntry.getValue());
        }

        Set<String> keyMap = actorMap.keySet();
        for (String key : keyMap) {
            System.out.println(key+","+actorMap.get(key));
        }
    }
}
