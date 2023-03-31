package Level1;

import java.util.Arrays;
import java.util.HashMap;

public class MemoryScore { // 추억 점수
    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
        System.out.println(Arrays.toString(solution(name, yearning, photo)));
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String,Integer> map = new HashMap<>();

        for(int i=0; i< name.length;i++){
            map.put(name[i],yearning[i]);
        }

        for(int i=0; i< photo.length;i++){
            int sum = 0;
            for(int j=0; j<photo[i].length;j++){
                String personName = photo[i][j];
                if(map.containsKey(personName)){
                    sum+=map.get(personName);
                }
            }
            answer[i] = sum;
        }

        return answer;
    }
}
