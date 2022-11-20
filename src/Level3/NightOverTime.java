package Level3;

import java.util.Arrays;

public class NightOverTime { //야근 지수
    public static void main(String[] args) {
        int n =3;
        int[] works = {1};
        System.out.println(solution(n,works));

    }

    public static long solution(int n, int[] works) {
        long answer = 0;
        Arrays.sort(works);
        int index =works.length-1;
        int count = 1;
        boolean ans = false;
        while(index!=0){
            if(n-count*(works[index]-works[index-1])>0){
                n -= count*(works[index]-works[index-1]);
                index--;
                count++;
            }else{
                ans = true;
                answer = getAnswer(n,count,index,works);
                break;
            }
        }

        if(ans){
            for(int i=0; i<index;i++){
                answer+=Math.pow(works[i],2);
            }
        }else{
            answer = getAnswer(n,count,index,works);
        }


        return answer;
    }

    public static long  getAnswer(int n,int count,int index,int[] works){
        int a = n/count;
        int b = n%count;
        int value = works[index]-a;
        if(value<=0){
            return 0;
        }
        return (long) (Math.pow(value,2)*(count-b)+Math.pow(value-1,2)*b);
    }
}
