package Level2;

public class Countries { //124나라
    public static void main(String[] args) {
        int n =21;
        System.out.println(solution(n));
    }

    public static String solution(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while(n!=0){
            if(n%3==0){
                stringBuilder.append("4");
                n=(n/3)-1;
            }
            if(n%3==1){
                stringBuilder.append("1");
                n=n/3;
            }
            if(n%3==2){
                stringBuilder.append("2");
                n=n/3;
            }
        }

        return stringBuilder.reverse().toString();
    }
}
