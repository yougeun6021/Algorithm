package Level2.October13;

import java.util.*;

public class LifeBoat { //구명 보트
    public static void main(String[] args) {
        int[] people ={100,500,500,900,950};
        int limit = 1000;
        System.out.println(solution(people,limit));
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;
        int allWeight = limit;
        int peopleNumber =0;
        List<Integer> peopleList  = new ArrayList<>();
        for(int p: people){
            peopleList.add(p);
        }
        Collections.sort(peopleList);
        while (peopleList.size()!=0){
            for(int i=peopleList.size()-1;i>=0;i--){
                if(allWeight-peopleList.get(i)>=0){
                    allWeight -=peopleList.get(i);
                    peopleList.remove(peopleList.get(i));
                    peopleNumber++;
                }
                if(peopleNumber==2){
                    break;
                }
            }
            answer++;
            allWeight = limit;
            peopleNumber =0;
        }
        return answer;
    }

    public static int solution2(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int min = 0;

        for (int max = people.length - 1; min <= max; max--){
            if (people[min] + people[max] <= limit){
                min++;
            }
            answer++;
        }

        return answer;

    }

}
