package Level1.October11;

import java.util.*;

public class ReportResult { //신고 결과 받기
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k =2;
        System.out.println(Arrays.toString(solution(id_list, report, k)));

    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        LinkedHashMap<String,Integer> reportMap = new LinkedHashMap<>();
        LinkedHashMap<String,Integer> mailMap = new LinkedHashMap<>();
        List<String> stop_list = new ArrayList<>();

        for (String s : id_list) {
            reportMap.put(s, 0);
            mailMap.put(s,0);
        }

        report = new HashSet<>(Arrays.asList(report)).toArray(new String[0]);

        report = String.join(" ",report).split(" ");

        for(int i=1; i< report.length; i=i+2){
            reportMap.put(report[i],reportMap.get(report[i])+1);
        }

        for (String s : id_list) {
            if (reportMap.get(s) >= k) {
                stop_list.add(s);
            }
        }

        for(int i=0; i< report.length;i=i+2){
            if(stop_list.contains(report[i+1])){
                mailMap.put(report[i],mailMap.get(report[i])+1);
            }
        }

        for(int i=0; i< id_list.length;i++){
            answer[i] = mailMap.get(id_list[i]);
        }

        return answer;
    }
}
