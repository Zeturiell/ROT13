import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String str = Main.cypherWord("Hello World");
        System.out.println(str);
       String st2 = Main.cypherWord(str);
        System.out.println(st2);

    }
    public static String cypherWord(String phrase){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        String specials =" @#$%^&*()_+{}[]|\\:;\"',.<>?/`~-=";
        Map<Integer,String>mp = new HashMap<>();
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
                     str2.append(mp.get(count));
                }else if(specials.contains(key.getValue())){
                            str2.append(key.getValue());
                        }
            }
        }
        return str2.toString();
    }
}
