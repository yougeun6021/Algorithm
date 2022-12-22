package Level1;

public class SmallPartString { //작은 부분 문자열
    public static void main(String[] args) {
        String t = "3141592";
        String p = "123";
        System.out.println(solution(t,p));

    }

    public static int solution(String t, String p) {
        int answer = 0;
        long ip = Long.parseLong(p);
        int pLength = p.length();

        for(int i=0;i<=t.length()-p.length();i++){
            if(Long.parseLong(t.substring(i,i+pLength))<=ip){
                answer++;
            }
        }

        return answer;
    }
}
