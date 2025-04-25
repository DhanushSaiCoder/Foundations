import java.util.*;
public class FirstRepeatedCharacter{
    public static void main(String[] args) {
        String str = "Dhanush Sai Nayak";
        System.out.println("First repeated character: " + check(str));
    }
    public static Character check(String str){
        Set<Character> set = new HashSet<>();
        for(char ch: str.toCharArray()){
            if(set.contains(ch)) return ch;
            set.add(ch);
        }
        return ' ';
    }
}