import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String str = Main.cypherWord("Guvf vf zl svefg EBG13 rkprepvfr!");
        System.out.println(str);
       String st2 = Main.cypherWord(str);
        System.out.println(st2);

    }
    public static String cypherWord(String phrase){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        String specials =" @#$%^&*()_+{}[]|\\:;\"',.<>?/`~-=¨";
        String numbers ="1234567890";
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
                }
            }
            for (int j = 0; j < specials.length(); j++) {
                if(String.valueOf(phrase.charAt(i)).equals(String.valueOf(specials.charAt(j)))){
                    str2.append(phrase.charAt(i));
                }
            }
            for (int k = 0; k < numbers.length(); k++) {
                if(String.valueOf(phrase.charAt(i)).equals(String.valueOf(numbers.charAt(k)))){
                    str2.append(phrase.charAt(i));
                }
            }
        }
        return str2.toString();
    }
}
