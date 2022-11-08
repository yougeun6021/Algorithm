package Level2.November5;

import java.util.*;

public class Printer { // 프린터
    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(solution2(priorities,location));

    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> indexQueue  = new LinkedList<>();
        Queue<Integer> priorityQueue = new LinkedList<>();

        for(int i=0; i< priorities.length;i++){
            indexQueue.add(i);
            priorityQueue.add(priorities[i]);
        }

        while(!priorityQueue.isEmpty()){
            int index = indexQueue.poll();
            int priority = priorityQueue.poll();
            boolean contain = false;
            for(int i=priority+1; i<=9;i++){
                if(priorityQueue.contains(i)){
                    priorityQueue.add(priority);
                    indexQueue.add(index);
                    contain =true;
                    break;
                }
            }
            if(!contain){
                answer++;
                if(index==location){
                    break;
                }
            }
        }
        return answer;
    }

    public static int solution2(int[] priorities, int location) {
        int answer = 0;
        Queue<Document> documentQueue  = new LinkedList<>();

        for(int i=0; i< priorities.length;i++){
            documentQueue.add(new Document(i,priorities[i]));
        }

        while(!documentQueue.isEmpty()){
            Document document = documentQueue.poll();
            int priority = document.getPriority();
            int index = document.getIndex();
            boolean contain = false;

            for (Document doc : documentQueue) {
                if (priority < doc.getPriority()) {
                    documentQueue.add(document);
                    contain = true;
                    break;
                }
            }

            if(!contain){
                answer++;
                if(index==location){
                    break;
                }
            }

        }

        return answer;
    }

    static class Document{
        int index;

        int priority;

        public Document(int index,int priority){
            this.index = index;
            this.priority = priority;
        }

        public int getIndex(){
            return this.index;
        }

        public int getPriority(){
            return this.priority;
        }

    }




}
