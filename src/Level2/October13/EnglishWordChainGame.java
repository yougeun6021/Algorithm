package Level2.October13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class EnglishWordChainGame { //영어 끝말 잇기
    public static void main(String[] args) {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.println(Arrays.toString(solution(n, words)));

    }

    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        char lastCh = words[0].charAt(words[0].length()-1);
        List<String> wordList = new ArrayList<>();
        wordList.add(words[0]);
        for(int i=1;i< words.length;i++){
            if(lastCh!=words[i].charAt(0) || wordList.contains(words[i])){
                answer = new int[]{i % n+1,i/n+1};
                break;
            }
            wordList.add(words[i]);
            lastCh = words[i].charAt(words[i].length()-1);
        }

        return answer;
    }

    public static int[] solution2(int n, String[] words) {
        int[] answer = new int[2];
        char lastCh = words[0].charAt(words[0].length()-1);
        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put(words[0],1);
        for(int i=1;i< words.length;i++){
            if(lastCh!=words[i].charAt(0) || hashMap.containsKey(words[i])){
                answer = new int[]{i % n+1,i/n+1};
                break;
            }
            hashMap.put(words[i],1);
            lastCh = words[i].charAt(words[i].length()-1);
        }

        return answer;
    }
}
