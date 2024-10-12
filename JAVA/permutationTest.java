import java.util.ArrayList;

public class permutationTest {
     

    public static void main(String[] args) {
        System.out.println(permute("", "AC"));
        System.out.println(permutecount("","ABC"));
    }

    private static ArrayList permute(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char c = up.charAt(0);
        ArrayList<String> howl = new ArrayList<>();
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i,p.length());
             howl.addAll(permute(f + c + s, up.substring(1)));
        }
        return howl;
    }
    private static int permutecount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        char c = up.charAt(0);
        int count = 0;
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i,p.length());
             count= count + permutecount(f + c + s, up.substring(1));
        }
        return count;
    }
}
