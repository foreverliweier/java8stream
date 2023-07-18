package codedream.stream.stream;

import java.util.HashMap;
import java.util.Map;

/**
 * @author alice
 * @time 2023-07-14 10:50
 **/
public class MapStreamDemo {
    public static void main(String[] args) {
        Map<String,String> hm = new HashMap<>();
        hm.put("a","1");
        hm.put("b","2");
        hm.put("c","3");
        hm.put("d","4");
        hm.put("e","5");
        hm.put("f","6");

        hm.keySet().stream().forEach(key-> System.out.println(key));
        System.out.println("###################");
        hm.keySet().stream().forEach(key-> System.out.println(key+"-"+hm.get(key)));
        System.out.println("###################");
        hm.entrySet().stream().forEach(entry-> System.out.println(entry.getKey()+":"+entry.getValue()));
    }
}
