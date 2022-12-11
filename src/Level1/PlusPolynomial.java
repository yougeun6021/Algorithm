package Level1;

public class PlusPolynomial { //다항식 더하기
    public static void main(String[] args) {
        String polynomial = "3x + 7 + x";
        System.out.println(solution(polynomial));

    }

    public static String solution(String polynomial) {
        String answer;
        int x = 0;
        int number = 0;
        String[] arr = polynomial.split(" \\+ ");
        for(String str: arr){
            if(str.endsWith("x")){
                if(str.length()==1){
                    x++;
                }else{
                    x+= Integer.parseInt(str.substring(0,str.length()-1));
                }
            }else{
                number+= Integer.parseInt(str);
            }
        }
        if(x==1){
            if(number==0){
                answer = "x";
            }else{
                answer = "x + "+number;
            }
        }else if (x==0){
            answer= Integer.toString(number);
        }else{
            if(number==0){
                answer= x+"x";
            }else{
                answer = x+"x"+" + "+number;
            }
        }


        return answer;
    }
}
