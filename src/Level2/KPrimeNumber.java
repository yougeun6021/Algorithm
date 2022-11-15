package Level2;

import java.util.ArrayList;
import java.util.List;

public class KPrimeNumber { //k진수에서 소수 개수 구하기
    public static void main(String[] args) {
        int n = 437674;
        int k = 3;
        System.out.println(solution2(n,k));
    }

    public static int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        List<String> list =new ArrayList<>();
        String bit = Integer.toString(n,k);
        for(int i=0; i<bit.length();i++){
            char ch = bit.charAt(i);
            if(ch!='0'){
                sb.append(ch);
            }else{
                if(!sb.toString().equals("")) {
                    list.add(sb.toString());
                    sb.setLength(0); // new StringBuilder(),delete(0,sb.length())함수로 초기화가능
                }
            }
        }

        if(!sb.toString().equals("")) {
            list.add(sb.toString());
        }

        for (String s : list) {
            if (isPrime(Long.parseLong(s))) {
                answer++;
            }
        }

        return answer;
    }

    public static int solution2(int n, int k) {
        int answer = 0;

        String bit = Integer.toString(n,k);
        bit = bit.replace("0"," ");
        while (bit.contains("  ")){
            bit = bit.replace("  "," ");
        }
        String[] arr = bit.split(" ");

        for (String s : arr) {
            if (isPrime(Long.parseLong(s))) {
                answer++;
            }
        }

        return answer;
    }

    public static boolean isPrime(Long n){
        if(n==2){
            return true;
        }
        if(n==1 || n%2==0){
            return false;
        }
        for(int i=3; i<=Math.sqrt(n);i=i+2){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
