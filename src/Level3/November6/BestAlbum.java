package Level3.November6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BestAlbum { //베스트 앨범
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays ={500, 600, 150, 800, 2500};
        System.out.println(solution(genres, plays));

    }

    public static List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answerList = new ArrayList<>();
        HashMap<String,Integer> hashMap = new HashMap<>();

        for(int i=0; i< genres.length;i++){
            hashMap.put(genres[i],hashMap.getOrDefault(genres[i],0)+plays[i]);
        }

        List<String> genresList = new ArrayList<>(hashMap.keySet());
        genresList.sort((o1, o2) -> hashMap.get(o2)-hashMap.get(o1));
        System.out.println(genresList);

        for (String genre : genresList) {
            HashMap<Integer, Integer> genreMap = new HashMap<>();
            for (int j = 0; j < genres.length; j++) {
                if (genre.equals(genres[j])) {
                    genreMap.put(j, plays[j]);
                }
            }
            List<Integer> indexList = new ArrayList<>(genreMap.keySet());
            if (indexList.size() == 1) {
                answerList.add(indexList.get(0));
                continue;
            }
            indexList.sort((o1, o2) -> genreMap.get(o2) - genreMap.get(o1));
            answerList.add(indexList.get(0));
            answerList.add(indexList.get(1));

        }

        return answerList;
    }

}
