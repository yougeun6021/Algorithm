package Level1;

public class CardBundle {
    public static void main(String[] args) {
        String[] cards1 = {"i","a", "want", "drink"};
        String[] cards2 = {"to","water"};
        String[] goal = {"i", "want","to", "drink","water"};
        System.out.println(solution(cards1,cards2,goal));

    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        int index1 = 0;
        int index2 = 0;
        int length1 = cards1.length;
        int length2 = cards2.length;

        for (String value : goal) {
            if (index1 < length1 && cards1[index1].equals(value)) {
                index1++;
            } else if (index2 < length2 && cards2[index2].equals(value)) {
                index2++;
            } else {
                return "No";
            }
        }


        return "Yes";
    }
}
