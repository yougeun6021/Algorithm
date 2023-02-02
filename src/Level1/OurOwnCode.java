package Level1;

import java.util.ArrayList;
import java.util.List;

public class OurOwnCode { // 둘만의 암호
    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;
        System.out.println(solution(s,skip,index));
    }

    public static String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        List<Character> list = new ArrayList<>();
        for(char ch = 'a'; ch<='z';ch++){
            list.add(ch);
        }

        for(int i=0; i<skip.length();i++){
            Object ob = skip.charAt(i);
            list.remove(ob);
        }

        for(int i=0; i<s.length();i++){
            Object ob = s.charAt(i);
            int listIndex = (list.indexOf(ob)+index)%list.size();
            sb.append(list.get(listIndex));
        }

        return sb.toString();
    }
}
