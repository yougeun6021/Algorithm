package Level1;


public class CalString { // 문자열 계산하기
    public static void main(String[] args) {
        String my_string = "3 + 4";
        System.out.println(solution(my_string));

    }

    public static int solution(String my_string) {
        int answer = 0;
        boolean sign = true;
        String[] sarr = my_string.split(" ");;
        for(int i=0; i<sarr.length; i++){
            if(i%2==0){
                answer += sign? Integer.parseInt(sarr[i]):-Integer.parseInt(sarr[i]);
            }else{
                sign = sarr[i].equals("+");
            }
        }
        return answer;
    }
}
