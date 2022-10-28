package Level1.October17;

public class babble { //옹알이
    public static void main(String[] args) {
        String[] babbling = {"aya", "yee", "u", "maa"};
        System.out.println(solution(babbling));

    }

    public static int solution(String[] babbling) {
        int answer = 0;
        for(String s:babbling){
            if(s.contains("ayaaya") || s.contains("yeye")|| s.contains("woowoo") || s.contains("mama")){
                continue;
            }

            s = s.replaceAll("aya","").replaceAll("ye","")
                    .replaceAll("woo","").replaceAll("ma","");
            if(s.isEmpty()){
                answer++;
            }
        }
        return answer;
    }
}
