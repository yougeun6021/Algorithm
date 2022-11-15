package Level1;

import java.util.Arrays;

public class StrangeString { // 수상한 문자 만들기
    public static void main(String[] args) {
        String s = "try hello world";
        System.out.println(solution(s));

    }

    public static String solution(String s) {
        String[] stringArray = s.split("");
        int index = 1;
        for(int i=0; i<stringArray.length;i++){
            stringArray[i] = index%2==0 ? stringArray[i].toLowerCase():stringArray[i].toUpperCase();
            if(stringArray[i].equals(" ")){
                index =1;
                continue;
            }
            index++;
        }
        return String.join("",stringArray);
    }
}
