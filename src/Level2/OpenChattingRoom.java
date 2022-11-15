package Level2;

import java.util.Arrays;
import java.util.HashMap;

public class OpenChattingRoom { //오픈 채팅방
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(record)));

    }

    public static String[] solution(String[] record) {
        HashMap<String,String> hashMap = new HashMap<>();
        int count =0;
        for(String str:record){
            String[] arr = str.split(" ");
            String action = arr[0];
            String userId = arr[1];
            if(action.equals("Enter")){
                hashMap.put(userId,arr[2]);
                count++;
            }
            if(action.equals("Leave")){
                count++;
            }
            if(action.equals("Change")){
                hashMap.put(userId,arr[2]);
            }
        }

        String[] answer = new String[count];
        count =0;

        for (String str : record) {
            String[] arr = str.split(" ");
            String action = arr[0];
            String userId = arr[1];
            if (action.equals("Enter")) {
                answer[count] = hashMap.get(userId) + "님이 들어왔습니다.";
                count++;
            }
            if (action.equals("Leave")) {
                answer[count] = hashMap.get(userId) + "님이 나갔습니다.";
                count++;
            }
        }

        return answer;
    }
}
