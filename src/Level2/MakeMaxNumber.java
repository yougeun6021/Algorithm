package Level2;

public class MakeMaxNumber { // 큰 수 만들기
    public static void main(String[] args) {
        String number = "4321";
        int k =1;
        System.out.println(solution(number,k));

    }

    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int answerLength = number.length()-k;
        while(k!=0){
            int index =0;
            int max =0;
            for(int i=0; i<=k;i++){
                int value = number.charAt(i)-'0';
                if(max<value){
                    max = value;
                    index =i;
                }
                if(value==9){
                    break;
                }
            }
            number = number.substring(index+1);
            k = k-index;
            answer.append(max);
            if(answer.length()==answerLength){
                break;
            }
        }

        if(k==0){
            answer.append(number);
        }


        return answer.toString();
    }
}
