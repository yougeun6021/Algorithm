package Level1.October4;

import java.util.Arrays;
import java.util.List;

public class FindKim { //서울에서 김서방 찾기
    public static void main(String[] args) {
        String[] seoul = {"Jane","Kim"};
        System.out.println(solution(seoul));
    }

    public static String solution(String[] seoul) {
        List<String> seoulList = Arrays.asList(seoul);
        int index = seoulList.indexOf("Kim");
        return "김서방은 "+index+"에 있다";
    }
}
