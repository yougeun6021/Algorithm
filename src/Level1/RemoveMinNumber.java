package Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveMinNumber { //제일 작은 수 제거하기
    public static void main(String[] args) {
        int [] arr = {4,3,2,1};
        System.out.println(solution(arr));
    }

    public static List<Integer> solution(int[] arr) {
        List<Integer> arrList =new ArrayList<>();
        if(arr.length>1){
            arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
            Object min = Collections.min(arrList);
            arrList.remove(min);
        }else{
            arrList.add(-1);
        }
        return arrList;
    }
}
