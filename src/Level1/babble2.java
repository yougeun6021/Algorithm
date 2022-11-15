package Level1;

public class babble2 {
    public static void main(String[] args) {
        String[] babbling = {"ayaaya", "myea", "u", "maa", "wyeoo"};
        System.out.println(solution(babbling));

    }

    public static int  solution(String[] babbling) {
        int answer = 0;
        for(String s:babbling){
            if(s.contains("ayaaya") || s.contains("yeye")|| s.contains("woowoo") || s.contains("mama")){
                continue;
            }

            s = s.replaceAll("aya"," ").replaceAll("ye"," ")
                    .replaceAll("woo"," ").replaceAll("ma"," ");
            if(s.trim().isEmpty()){
                answer++;
            }
        }
        return answer;
    }
}
