import java.util.ArrayList;
import java.util.List;

public class numrcharacter {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23456789"));
    }



        public static List<String> letterCombinations(String digits) {
            ArrayList<String> D = new ArrayList<>();
            
            D.addAll(solve("", digits));
            return D;
        }
        public static List<String> solve(String ans, String ip) {

            if(ip.isEmpty()) {
                ArrayList<String> list = new ArrayList<>();
                list.add(ans);
                return list;
            }

            int digit = ip.charAt(0) - '0';
            int i=(digit-2)*3;
            if(digit > 7) {
                i+=1;
            }
            int len = i+3;
            if(digit == 7 || digit == 9) {
                len+=1;
            }

            ArrayList<String> list = new ArrayList<>();

            for(; i<len; i++) {
                char ch = (char)('a' + i);
                list.addAll(solve(ans+ch, ip.substring(1)));
            }

            return list;




    }
}
