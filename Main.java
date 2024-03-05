import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String str = Main.cypherWord("HelloWorld");
        System.out.println(str);
    }
    public static String cypherWord(String phrase){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        Map<Integer,String>mp = new HashMap<>();
        List<Integer>num = new ArrayList<>();
        StringBuilder str2 = new StringBuilder();

        for (int i = 0; i < alph.length(); i++) {
            mp.put(i+1, String.valueOf(alph.charAt(i)));
        }
        for (int i = 0; i < phrase.length(); i++) {
            
            for (Map.Entry<Integer,String> key: mp.entrySet()) {
                if(key.getValue().equals(String.valueOf(phrase.charAt(i)).toLowerCase())){
                     int count = key.getKey()+13;
                     if(count>26){
                        count = count-26;
                     }
                     num.add(count);
                }
            }
        }
        for (int i=0;i<num.size();i++) {
            //System.out.print(mp.get(num.get(i)));
            str2.append(mp.get(num.get(i)));
        }
        return str2.toString();
    }
}
