package Level3;

import java.util.*;

public class JewelShopping { //보셕 쇼핑
    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(Arrays.toString(solution3(gems)));
    }

    public static int[] solution(String[] gems) {
        HashSet<String> set = new HashSet<>(Arrays.asList(gems));
        HashSet<String> gemSet = new HashSet<>();
        PriorityQueue<startEnd> queue = new PriorityQueue<>();
        for(int i=0; i< gems.length;i++){
            for(int j=i; j< gems.length;j++){
                String gem = gems[j];
                gemSet.add(gem);
                if(gemSet.size()==set.size()){
                    queue.add(new startEnd(i,j));
                    break;
                }
            }
            gemSet.clear();
        }
        startEnd startEnd = queue.poll();
        return new int[]{startEnd.getStart()+1,startEnd.getEnd()+1};
    }

    public static int[] solution2(String[] gems) {
        HashSet<String> set = new HashSet<>(Arrays.asList(gems));
        HashMap<String,Integer> map = new HashMap<>();
        int k = set.size();
        int start = 0;
        int end = 0;
        boolean solve = false;
        while(!solve){
            for(int i=0; i<k;i++){
                map.put(gems[i],map.getOrDefault(gems[i],0)+1);
            }
            if(set.size()==map.size()){
                end = k-1;
                break;
            }
            for(int j=k;j< gems.length;j++){

                String removeGem = gems[j-k];
                String putGem = gems[j];
                map.put(removeGem,map.get(removeGem)-1);
                if(map.get(removeGem)==0){
                    map.remove(removeGem);
                }
                map.put(putGem,map.getOrDefault(putGem,0)+1);
                if(set.size()==map.size()){
                    start = j-k+1;
                    end = j;
                    solve = true;
                    break;
                }

            }
            map.clear();
            k++;
        }
        return new int[]{start+1,end+1};
    }

    public static int[] solution3(String[] gems) {
        HashSet<String> set = new HashSet<>(Arrays.asList(gems));
        HashMap<String,Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int length = 100001;
        int index = 0;


        for(int i=0; i< gems.length;i++){
            String gem = gems[i];
            map.put(gem,map.getOrDefault(gem,0)+1);
            while(map.size()==set.size()){
                if(i-index+1<length){
                    start= index;
                    end = i;
                    length = end-start+1;
                }
                String removeGem = gems[index];
                if(map.get(removeGem)==1){
                    map.remove(removeGem);
                }else{
                    map.put(removeGem,map.get(removeGem)-1);
                }
                index++;
            }
        }

        return new int[]{start+1,end+1};
    }


    static class startEnd implements Comparable<startEnd>{
        int start;
        int end;
        int length;

        public startEnd(int start,int end){
            this.start = start;
            this.end =end;
            this.length = end-start;

        }

        @Override
        public int compareTo(startEnd o) {
            return this.length!=o.length ? this.length-o.length:this.start-o.start;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            startEnd startEnd = (startEnd) o;
            return start == startEnd.start && end == startEnd.end && length == startEnd.length;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end, length);
        }
    }
}
