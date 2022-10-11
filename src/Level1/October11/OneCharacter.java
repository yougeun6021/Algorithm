package Level1.October11;

import java.util.Arrays;
import java.util.LinkedHashMap;

public class OneCharacter { //한 번만 등장한 문자
    public static void main(String[] args) {
        String s ="a";
        System.out.println(solution(s));

    }

    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] sarr = s.split("");
        Arrays.sort(sarr);

        if(s.length()==1){
            return s;
        }

        for(int i=0; i< sarr.length;i++){
            if(i==0){
                if(!sarr[i].equals(sarr[i + 1])){
                    answer.append(sarr[i]);
                }
            }
            else if (i== sarr.length-1) {
                if(!sarr[i].equals(sarr[i - 1])){
                    answer.append(sarr[i]);
                }
            }else{
                if(!sarr[i].equals(sarr[i + 1])&&!sarr[i].equals(sarr[i - 1])){
                    answer.append(sarr[i]);
                }
            }
        }

        return answer.toString();
    }

    public static String solution2(String s) {
        StringBuilder answer = new StringBuilder();
        LinkedHashMap<String,Integer> hashMap = new LinkedHashMap<>();
        String[] sarr = s.split("");
        Arrays.sort(sarr);

        for (String value : sarr) {
            hashMap.put(value, hashMap.getOrDefault(value, 0) + 1);
        }

        for(String key : hashMap.keySet()){
            if(hashMap.get(key)==1){
                answer.append(key);
            }
        }

        return answer.toString();
    }

}
