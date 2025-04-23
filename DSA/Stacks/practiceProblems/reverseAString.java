
import java.util.Stack;

public class reverseAString {

    public static void main(String args[]) {
        Stack<Character> stack = new Stack<>();
        String str = "Dhanush";
        int i = 0;
        System.out.println(str);
        do {
            stack.push(str.charAt(i));
            i++;
        } while (i < str.length());
        str="";
        for (int n = 0; !stack.isEmpty(); n++) {
            str += stack.pop();
        }
        System.out.println(str);

    }
}
