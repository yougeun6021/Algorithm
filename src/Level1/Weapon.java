package Level1;

public class Weapon { //기사단원의 무기
    public static void main(String[] args) {
        int number =10;
        int limit = 3;
        int power = 2;
        System.out.println(solution(number,limit,power));


    }

    public static int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i=1; i<=number;i++){
            int wp = getDivisorNumber(i);
            answer += wp>limit ? power:wp;
        }
        return answer;
    }

    public static int getDivisorNumber(int n){
        int number =0;


        if(Math.sqrt(n)%1==0){
            number++;
        }

        for(int i=1; i<Math.sqrt(n);i++){
            if(n%i==0){
                number+=2;
            }
        }

        return number;

    }
}
