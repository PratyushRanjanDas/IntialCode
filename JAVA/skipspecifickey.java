public class skipspecifickey {

    public static void main(String[] args) {
        skip("","guguzaza");
        System.out.println(skipchar("do oyor die"));
    }

    private static String skipchar(String up) {
        if(up.isEmpty()){
            return "";
        }
        if (up.startsWith("yo")) {
            return  skipchar(up.substring(2));
        }else{
            return up.charAt(0) + skipchar(up.substring(1));
        }
    }

    static void skip(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char c =up.charAt(0);
        if (c == 'z') {
            skip(p,up.substring(1));
        }else{
            skip(p+c,up.substring(1));
        }
    }

}
