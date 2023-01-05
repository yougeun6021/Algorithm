package Level1;

import java.util.*;

public class PersonalInformation { // 개인정보 수집 유효기간
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        System.out.println(Arrays.toString(solution(today, terms, privacies)));

    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String,Integer> expireMap = new HashMap<>();
        List<Integer> answerList = new ArrayList<>();

        getExpireMap(today,terms,expireMap);

        for(int i=0;i<privacies.length;i++){
            String[] privacy = privacies[i].split(" ");
            String name = privacy[1];
            String date = privacy[0];
            int day = getDay(date);
            if(day<=expireMap.get(name)){
                answerList.add(i+1);
            }
        }

        int[] answer = new int[answerList.size()];

        for(int i=0; i<answer.length;i++){
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    static void getExpireMap(String today,String[] terms,HashMap<String,Integer> expireMap){
        int day = getDay(today);

        for(String term: terms){
            String[] termArr = term.split(" ");
            String name = termArr[0];
            int t = Integer.parseInt(termArr[1]);
            expireMap.put(name,day-28*t);
        }

    }

    static int getDay(String date){
        String[] arr = date.split("\\.");

        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);

        return year*(28*12)+month*28+day;

    }


}
