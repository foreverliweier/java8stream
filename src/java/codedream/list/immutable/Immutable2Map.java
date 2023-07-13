package codedream.list.immutable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author alice
 * @time 2023-07-13 11:57
 **/
public class Immutable2Map {
    public static void main(String[] args) {
        Map<String,Integer> params = new HashMap<>();
        params.put("丽可", 22);
        params.put("王阳",30);
        params.put("李颖",20);
        params.put("秦岚",28);
        params.put("李阳",38);
        params.put("王一一",25);

//      Map.Entry[] arr1 = new Map.Entry[0];
//      Map.Entry[] entries = params.entrySet().toArray(arr1);
//      Map<String,Integer> actorMap = Map.ofEntries(entries);
        //jdk 9
     //   Map<String,Integer> actorMap = Map.ofEntries(params.entrySet().toArray(new Map.Entry[0]));
        //jdk 10
        Map<String,Integer> actorMap =  Map.copyOf(params);

        Set<String> keyMap = actorMap.keySet();
        for (String key : keyMap) {
            System.out.println(key+","+actorMap.get(key));
        }

    }
}
