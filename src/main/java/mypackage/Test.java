package mypackage;

import org.bson.Document;

public class Test {
    public static void main(String[] args) {
        String s = "4";

        Double d = new Double(s);
        Double d2 = Double.parseDouble(s);
        System.out.println(d);
        System.out.println(d2);
    }
}
