
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Lab12 {
    public static void main(String[] args) throws IOException {

        String s = readFile(args[0]);

        tokenizer(s);

    }

    public static void tokenizer(String s) {
        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (isPsedoOpCode(token)) {

                System.out.println(token + " is pseduo-OP code");
            } else if (isOpCode(token)) {

                System.out.println(token + " is OP code");
            } else if (isNumber(token)) {
                System.out.println(token + " is a number");
            }

            else if (isOperand(token)) {
                System.out.println(token + " is Operand");
            }

            else if (isLabel(token)) {
                System.out.println(token + " is Labele");
            }

        }

    }

    public static String readFile(String a) throws IOException {
        File f = new File(a);
        int size = (int) f.length();
        char[] data = new char[size];
        FileReader in = new FileReader(f);
        in.read(data);
        in.close();
        return new String(data);
    }

    public static boolean isPsedoOpCode(String a) {

        if (a.equals(".begin") || a.equals(".end") || a.equals(".data")) {

            return true;
        }
        return false;

    }

    public static boolean isOpCode(String a) {

        if (a.equals("LOAD") || a.equals("STORE") || a.equals("CLEAR") || a.equals("ADD") || a.equals("INCREMENT")
                || a.equals("SUBTRACT") || a.equals("DECREMENT") || a.equals("COMPARE") || a.equals("JUMP")
                || a.equals("JUMPGT") || a.equals("JUMPEQ") || a.equals("JUMPLT") || a.equals("JUMPNEQ")
                || a.equals("IN") || a.equals("OUT") || a.equals("HALT")) {

            return true;
        }
        return false;

    }

    public static boolean isOperand(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isLetter(c))
                return false;
        }
        return true;
    }

    public static boolean isLabel(String s) {
        int a = s.length();
        for (int i = a - 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ':')
                return true;
        }
        return false;
    }

    public static boolean isNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

}
