package Level1.October11;


public class PersonalityTypeTest { //성격 유형 검사
    public static void main(String[] args) {
        String[] survey ={"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        System.out.println(solution(survey,choices));

    }

    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] point = {-3,-2,-1,0,1,2,3};
        int RTPoint =0;
        int CFPoint =0;
        int JMPoint =0;
        int ANPoint =0;
        survey = String.join("",survey).split("");
        for(int i=0; i<choices.length;i++){
            switch (survey[2*i]){
                case "A":
                    ANPoint -= point[choices[i]-1];
                    break;
                case "N":
                    ANPoint += point[choices[i]-1];
                    break;
                case "C":
                    CFPoint -= point[choices[i]-1];
                    break;
                case "F":
                    CFPoint += point[choices[i]-1];
                    break;
                case "J":
                    JMPoint -= point[choices[i]-1];
                    break;
                case "M":
                    JMPoint += point[choices[i]-1];
                    break;
                case "R":
                    RTPoint -= point[choices[i]-1];
                    break;
                case "T":
                    RTPoint += point[choices[i]-1];
                    break;
            }
        }
        answer += RTPoint>=0 ? "R":"T";
        answer += CFPoint>=0 ? "C":"F";
        answer += JMPoint>=0 ? "J":"M";
        answer += ANPoint>=0 ? "A":"N";

        return answer;
    }
}
