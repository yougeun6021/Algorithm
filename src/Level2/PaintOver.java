package Level2;

public class PaintOver { //덧칠하기
    public static void main(String[] args) {
        int n = 8;
        int m = 4;
        int[] section = {2,3,6};
        System.out.println(solution(n,m,section));

    }

    public static int solution(int n, int m, int[] section) {
        int answer = 1;
        int start = section[0];
        for(int i=1; i<section.length;i++){
            if(section[i]>start+m-1){
                answer++;
                start = section[i];
            }
        }
        return answer;
    }
}
