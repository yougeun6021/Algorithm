package Level2.November13;

import java.util.Arrays;

public class SortFileName { //파일명 정렬
    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        System.out.println(Arrays.toString(solution(files)));

    }

    public static String[] solution(String[] files) {
        String[] answer = new String[files.length];
        String[][] arr = new String[files.length][3];
        for (int i = 0; i < files.length; i++) {
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            StringBuilder tail = new StringBuilder();
            boolean isNumber = false;
            boolean isTail = false;
            for (int j = 0; j < files[i].length(); j++) {
                char ch = files[i].charAt(j);

                if (Character.isDigit(ch) && !isTail) {
                    isNumber = true;
                    number.append(ch);
                }

                if (!isNumber) {
                    head.append(ch);
                }

                if (!Character.isDigit(ch) && isNumber) {
                    isTail = true;
                }


                if (isTail) {
                    tail.append(ch);
                }

            }
            arr[i][0] = head.toString();
            arr[i][1] = number.toString();
            arr[i][2] = tail.toString();
        }
        Arrays.sort(arr, (o1, o2) -> !o1[0].equalsIgnoreCase(o2[0]) ? o1[0].toUpperCase().compareTo(o2[0].toUpperCase()) : Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]));

        for (int i = 0; i < answer.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(arr[i][0]);
            sb.append(arr[i][1]);
            sb.append(arr[i][2]);
            answer[i] = sb.toString();
        }

        return answer;
    }


}

