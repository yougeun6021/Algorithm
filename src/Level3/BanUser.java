package Level3;

import java.util.*;

public class BanUser { //불량사용자
    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
        System.out.println(solution(user_id,banned_id));

    }

    public static int solution(String[] user_id, String[] banned_id) {
        HashMap<String, List<String>> map = new HashMap<>();
        HashSet<String> set= new HashSet<>();
        for (String ban : banned_id) {
            if(map.containsKey(ban)){
                continue;
            }
            for (String user : user_id) {
                if (equal(ban,user)) {
                    List<String> list = map.getOrDefault(ban, new ArrayList<>());
                    list.add(user);
                    map.put(ban, list);
                }
            }
        }
        dfs(map,banned_id,0,new ArrayList<>(),set);

        return set.size();
    }

    public static void dfs(HashMap<String, List<String>> map,String[] banned_id,int depth,List<String> userList,HashSet<String> set){
        if(depth==banned_id.length){
            set.add(getUserString(userList));
            return;
        }
        List<String> list = map.get(banned_id[depth]);
        for(String user: list){
            if(!userList.contains(user)){
                userList.add(user);
                dfs(map,banned_id,depth+1,userList,set);
                userList = userList.subList(0,depth);
            }
        }
    }

    public static boolean equal(String ban,String user){
        if (ban.length() == user.length()) {
            for (int k = 0; k < ban.length(); k++) {
                char banCh = ban.charAt(k);
                char userCh = user.charAt(k);
                if (banCh == '*') {
                    continue;
                }
                if (banCh != userCh) {
                    return false;
                }
            }
        }else{
            return false;
        }
        return true;
    }

    public static String getUserString(List<String> list){
        List<String> copyList = new ArrayList<>(list);
        Collections.sort(copyList);

        return String.join("",copyList);
    }
}
