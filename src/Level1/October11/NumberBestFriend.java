package Level1.October11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberBestFriend { //숫자 짝꿍
    public static void main(String[] args) {
        String X=  "100";
        String Y = "203045";
        System.out.println(solution(X,Y));

    }

    public static String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        List<String> stringList = new ArrayList<>();
        String replaceX;
        String replaceY;
        int number;

        for(int i=0; i<=9; i++){
            replaceX = X.replace(String.valueOf(i),"");
            replaceY = Y.replace(String.valueOf(i),"");
            number = Math.min(X.length()-replaceX.length(),Y.length()-replaceY.length());
            for(int j=0; j<number;j++){
                stringList.add(String.valueOf(i));
            }

        }


        if(stringList.size()==0){
            return "-1";
        }

        stringList.sort(Collections.reverseOrder());

        for (String string : stringList) {
            answer.append(string);
        }

        if(answer.charAt(0)=='0'){
            return "0";
        }

        return answer.toString();
    }
}
