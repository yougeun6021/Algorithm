package Level2;

public class NowSong { //방금 그곡
    public static void main(String[] args) {
        String m = "ABC";
        String[] musicinfos ={"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution(m,musicinfos));

    }

    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = replace(m);
        int length =0;
        for (String musicinfo : musicinfos) {
            StringBuilder sb = new StringBuilder();
            String[] musicArr = musicinfo.split(",");
            String[] startArr = musicArr[0].split(":");
            String[] endArr = musicArr[1].split(":");
            int startTime = Integer.parseInt(startArr[0]) * 60 + Integer.parseInt(startArr[1]);
            int endTime = Integer.parseInt(endArr[0]) * 60 + Integer.parseInt(endArr[1]);
            int time = endTime - startTime;
            String music = musicArr[3];
            int musicLength = music.replace("#", "").length();
            int musicRest = time % musicLength;
            int r = 0;

            for (int j = 0; j < time / musicLength; j++) {
                sb.append(music);
            }

            for (int j = 0; j < music.length(); j++) {
                char ch = music.charAt(j);
                if (ch != '#') {
                    r++;
                }

                sb.append(ch);

                if (r == musicRest) {
                    break;
                }
            }

            String str = replace(sb.toString());

            if (str.contains(m) && length < time) {
                answer = musicArr[2];
                length = time;
            }

        }
        return answer;
    }

    public static String replace(String str){
        str = str.replace("C#","1")
                .replace("D#","2")
                .replace("F#","3")
                .replace("G#","4")
                .replace("A#","5");

        return str;

    }

}
