package Level1.October5;

public class MiddleLetter { //가운데 글자 가져오기
    public static void main(String[] args) {
        String s = "abcde";
        String s2 = "qwer";
        System.out.println(solution(s));


    }

    public static String solution(String s) {
        int length = s.length();
        if(length%2==0){
            return s.substring(length/2-1,length/2+1);
        }else{
            return s.substring(length/2,length/2+1);
        }
    }
}
