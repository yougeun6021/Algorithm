package Level1.October5;

public class Subak { //수박수박수?
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solution(n));
    }

    public static String solution(int n) {
        StringBuilder answer = new StringBuilder();
        for(int i=1; i<=n; i++){
            answer.append(i % 2 == 1 ? "수" : "박");
        }
        return answer.toString();
    }
}
