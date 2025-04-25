
import java.util.*;

public class FirstNonRepeated {

    public static void main(String[] args) {
        String str = "I am Getting Bored";
        System.out.println(check(str));
    }

    public static Character check(String str) {
        str = str.trim().toLowerCase().strip();
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : str.toCharArray()) {
            if (map.containsKey(ch)) {
                // get value of the key 'ch',
                // increment it
                map.put(ch, map.get(ch) + 1);
                continue;
            }
            map.put(ch, 1);
        }

        if(map.containsValue(1))
            for(Character key : map.keySet())
                if (map.get(key) == 1) return key;

        return ' ';
    }
}
