package Level1;

import java.util.Arrays;
import java.util.List;

public class NumberOfpy { // 문자열 내 p y의 개수
    public static void main(String[] args) {
        String s = "pPoooyY";
        System.out.println(solution(s));
    }

    static boolean solution(String s) {
        List<String> stringList = Arrays.asList(s.toLowerCase().split("")) ;
        long pCount = stringList.stream().filter(l->l.contains("p")).count();
        long yCount = stringList.stream().filter(l->l.contains("y")).count();
        return pCount==yCount;
    }
}
