package Level1;

public class MonthDay { //2016년
    public static void main(String[] args) {
        int a = 5;
        int b = 24;
        System.out.println(solution(a,b));

    }

    public static String solution(int a, int b) {
        int[] monthDay = {31,29,31,30,31,30,31,31,30,31,30,31};
        String[] Day = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int sumDay = b;
        for(int i=0; i<a-1;i++){
            sumDay +=  monthDay[i];
        }
        if(sumDay%7==0){
            return "THU";
        }
        return Day[sumDay%7-1];
    }
}
