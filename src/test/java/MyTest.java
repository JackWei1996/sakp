import org.assertj.core.data.MapEntry;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class MyTest {
    @Test
    public void test(){
        List<String> words = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        long start = System.currentTimeMillis();

        String content = "a,b,c,d,a,c,d,b,cd,ad,aa,cc,aab,,ccadd,,ada,,cad,,ad,,ada.,d,akakd,,";
        content = content.replaceAll("\\.", "");
        content = content.replaceAll("，", ",");
        content = content.replaceAll("。", "");
        System.out.println(content);
        for (int i=0; i<100; i++){
            String[] ws = content.split(",");
            for (String key: ws){
                key = key.trim();
                if (!"".equals(key)){
                    Integer integer = map.get(key);
                    if (integer == null){
                        map.put(key, 0);
                    }else {
                        map.put(key, ++integer);
                    }
                }
            }
        }
        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new)).forEach((k, v)->{
            words.add(k);
            counts.add(v);
        });
        long end = System.currentTimeMillis();
        System.out.println("time========="+(start - end));
    }
}
