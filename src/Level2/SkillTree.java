package Level2;

import java.util.Arrays;

public class SkillTree { //스킬트리
    public static void main(String[] args) {
        String skill ="CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(solution(skill,skill_trees));

    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String regex = "[^"+skill+"]";
        for(int i=0; i< skill_trees.length;i++){
            skill_trees[i] = skill_trees[i].replaceAll(regex,"");
            if(skill.startsWith(skill_trees[i])){
                answer++;
            }
        }
        return answer;
    }
}
