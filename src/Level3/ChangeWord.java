package Level3;

import java.util.LinkedList;
import java.util.Queue;

public class ChangeWord { //단어 변환
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log"};
        System.out.println(solution(begin,target,words));


    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<Word> queue = new LinkedList<>();
        queue.add(new Word(begin,0));
        boolean[] visited = new boolean[words.length];

        while (!queue.isEmpty()){
            Word start = queue.poll();
            String w = start.getWord();
            int count = start.getCount();
            if(w.equals(target)){
                return count;
            }
            for(int i=0; i< words.length;i++){
                if(!visited[i]){
                    int equal = 0;
                    for(int j=0; j< words[i].length();j++){
                        if(w.charAt(j)==words[i].charAt(j)){
                            equal++;
                        }
                    }
                    if(equal==w.length()-1){
                        queue.add(new Word(words[i],count+1));
                        visited[i] =true;
                    }
                }
            }
        }
        return answer;
    }

    public static class Word{
        String word;
        int count;

        public Word(String word, int count){
            this.word = word;
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        public String getWord() {
            return word;
        }
    }
}
