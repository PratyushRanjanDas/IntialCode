import java.util.ArrayList;

public class subsetAscii {
    public static void main(String[] args) {
        System.out.println(AsciiSString("", "BSDK"));
    }


    private static ArrayList<String> AsciiSString(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char c = up.charAt(0);
        ArrayList<String> wc = AsciiSString(c + p, up.substring(1));
        ArrayList<String> wwc = AsciiSString(p, up.substring(1));
        ArrayList<String> wwwc = AsciiSString(p + (c + 0), up.substring(1));
        wc.addAll(wwc);
        wc.addAll(wwwc);
        return wc;
    }
}