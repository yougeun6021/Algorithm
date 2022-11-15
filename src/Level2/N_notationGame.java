package Level2;

public class N_notationGame { // N 진수 게임
    public static void main(String[] args) {
        int n = 16;
        int t = 16;
        int m = 2;
        int p = 1;
        System.out.println(solution(n,t,m,p));

    }

    public static String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int number =0;

        while (sb.length() <t*m){
            sb.append(Integer.toString(number++,n));
        }


        for(int i=p-1; i<p-1+t*m;i=i+m){
                answer.append(sb.charAt(i));
        }

        return answer.toString().toUpperCase();
    }
}
