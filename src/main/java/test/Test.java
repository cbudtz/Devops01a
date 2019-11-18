package test;

public class Test {
    public static void main(String[] args) {
        char[] chars = new char[]{'a','b'};
        System.out.println(chars);
        char[] krypts = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            krypts[i] = (char) (c ^ 'd');
        }
        char[] dechars = new char[krypts.length];
        System.out.println(krypts);
        for (int i = 0; i < krypts.length; i++) {
            char c = krypts[i];
            dechars[i] = (char) (c^'d');
        }
        System.out.println(dechars);

    }
}
