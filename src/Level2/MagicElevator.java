package Level2;

public class MagicElevator { // 마법의 엘리베이터
    public static void main(String[] args) {
        int storey = 9984;
        System.out.println(solution(storey));
    }

    public static int solution(int storey) {

        return getAnswer(storey,0);
    }

    static int getAnswer(int storey,int count){
        if( storey==0){
            return count;
        }

        int answer = Integer.MAX_VALUE;
        int value = storey%10;
        if(value>5){
            answer  = Math.min(answer,getAnswer(storey/10+1,count+10-value));
        } else if (value==5) {
            answer = Math.min(answer,getAnswer(storey/10+1,count+10-value));
            answer = Math.min(answer,getAnswer(storey/10,count+value));
        }else{
            answer = Math.min(answer,getAnswer(storey/10,count+value));
        }

        return answer;
    }
}
