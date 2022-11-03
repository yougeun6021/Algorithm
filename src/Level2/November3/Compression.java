package Level2.November3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Compression { //압축
    public static void main(String[] args) {
        String msg = "KAKAO";
        System.out.println((solution(msg)));

    }

    public static List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        List<String> dic = new ArrayList<>();
        for(char i='A'; i<='Z';i++){
            dic.add(String.valueOf(i));
        }

        for(int i=0; i<msg.length();i++){

            String word = String.valueOf(msg.charAt(i));
            int index =i;

            while(dic.contains(word)){
                if(index==msg.length()-1){
                    break;
                }
                word += msg.charAt(++index);
            }


            if(dic.contains(word)){
                answer.add(dic.indexOf(word)+1);
                i = index;
            }
            else{
                answer.add(dic.indexOf(word.substring(0,word.length()-1))+1);
                dic.add(word);
                i = index-1;
            }

        }

        return answer;
    }

    public static List<Integer> solution2(String msg) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String,Integer> hashMap = new HashMap<>();
        int count =1;
        for(char i='A'; i<='Z';i++){
            hashMap.put(String.valueOf(i),count++);
        }

        for(int i=0; i<msg.length();i++){

            String word = String.valueOf(msg.charAt(i));
            int index =i;

            while(hashMap.containsKey(word)){
                if(index==msg.length()-1){
                    break;
                }
                word += msg.charAt(++index);
            }


            if(hashMap.containsKey(word)){
                answer.add(hashMap.get(word));
                i = index;
            }
            else{
                answer.add(hashMap.get(word.substring(0,word.length()-1)));
                hashMap.put(word,count++);
                i = index-1;
            }

        }

        return answer;
    }
}
