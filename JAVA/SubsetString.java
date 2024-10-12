import java.util.ArrayList;

class SubsetString{
    public static void main(String[] args) {
        System.out.println(SString("","BSDK"));
    }

    private static ArrayList<String> SString(String p, String up) {
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char c =up.charAt(0);
        ArrayList<String> wc = SString(c+p,up.substring(1));
        ArrayList<String> wwc = SString(p,up.substring(1));
        wc.addAll(wwc);
       return wc;
    }
}