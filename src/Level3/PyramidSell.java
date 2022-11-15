package Level3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class PyramidSell { //다단계 칫솔 판매
    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        System.out.println(Arrays.toString(solution(enroll, referral, seller, amount)));

    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<String,String> referMap = new HashMap<>();
        LinkedHashMap<String,Double> resultMap = new LinkedHashMap<>();
        for(int i=0; i<enroll.length;i++){
            referMap.put(enroll[i],referral[i]);
            resultMap.put(enroll[i],0.0);
        }

        for(int i=0; i<seller.length;i++){
            String person = seller[i];
            double result = amount[i]*100.0;
            while(!person.equals("-")){
                if(result*0.1<1){
                    resultMap.put(person,resultMap.getOrDefault(person,0.0)+result);
                    break;
                }else{
                    resultMap.put(person,resultMap.getOrDefault(person,0.0)+Math.ceil(result*0.9));
                    result = result-Math.ceil(result*0.9);
                }
                person = referMap.get(person);
            };
        }


        int index =0;
        for(String s:resultMap.keySet()){
            answer[index++] = resultMap.get(s).intValue();
        }

        return answer;
    }
}
