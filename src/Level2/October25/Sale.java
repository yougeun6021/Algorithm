package Level2.October25;

import java.util.HashMap;

public class Sale { //할인 행사
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(solution(want,number,discount));

    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String,Integer> saleMap = new HashMap<>();
        HashMap<String,Integer> wantMap = new HashMap<>();
        for(int i=0; i< want.length;i++){
            wantMap.put(want[i],number[i]);
        }
        for(int i=0; i<= discount.length-10;i++){

            for(int j=i; j<i+10;j++){
                saleMap.put(discount[j],saleMap.getOrDefault(discount[j],0)+1);
            }

            if(saleMap.equals(wantMap)){
                answer++;
            }

            saleMap.clear();;
        }
        return answer;
    }
}
