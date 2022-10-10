package Level1.October10;

import java.util.Arrays;

public class Player { //완주하지 못한 선수
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        System.out.println(solution(participant,completion));

    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        for(int i=0; i< participant.length-1; i++){
            if(!participant[i].equals(completion[i])){
                answer =participant[i];
                break;
            }

        }
        if(answer.equals("")){
            return  participant[participant.length-1];
        }
        return answer;
    }
}
