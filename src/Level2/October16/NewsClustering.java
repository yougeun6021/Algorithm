package Level2.October16;

import java.util.ArrayList;
import java.util.List;

public class NewsClustering { //뉴스 클러스터링
    public static void main(String[] args) {
        String str1 ="handshake";
        String str2 ="shake hands";
        System.out.println(solution(str1,str2));

    }

    public static int solution(String str1, String str2) {
        int intersectionSize =0;
        int unionSize =0;

        List<String> str1List= new ArrayList<>();
        List<String> str2List = new ArrayList<>();

        for(int i=0; i<str1.length()-1;i++){
            if(str1.substring(i,i+2).replaceAll("[^A-Za-z]","").length()==2){
                str1List.add(str1.substring(i,i+2).toLowerCase());
            }
        }

        for(int i=0; i<str2.length()-1;i++){
            if(str2.substring(i,i+2).replaceAll("[^A-Za-z]","").length()==2){
                str2List.add(str2.substring(i,i+2).toLowerCase());
            }
        }

        if(str1List.size() ==0 && str2List.size()==0){
            return 65536;
        }


        for (String s : str1List) {
            if (str2List.contains(s)) {
                intersectionSize++;
                str2List.remove(s);
            }
        }

        unionSize = str1List.size()+str2List.size();
        return (int) Math.floor(intersectionSize/(double)unionSize*65536);
    }
}
