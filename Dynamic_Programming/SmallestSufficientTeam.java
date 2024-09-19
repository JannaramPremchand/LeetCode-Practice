package Dynamic_Programming;

import java.util.*;

public class SmallestSufficientTeam {

  public static void main(String[] args) {
    String[] req = {"java", "nodejs", "reactjs"};
    List<List<String>> people = new ArrayList<>();
    people.add(Arrays.asList("java"));
    people.add(Arrays.asList("nodejs"));
    people.add(Arrays.asList("nodejs", "reactjs"));
    int[] R = new SmallestSufficientTeam().smallestSufficientTeam(req, people);
    for (int r : R) {
      System.out.print(r + " ");
    }
    System.out.println();
  }

  private int allSkills;
  Map<Integer, Integer> peopleSkillSet;
  Map<String, Integer> skillMap;
  final int MAX_SKILLS = 63;
  final int CHOOSE_PEOPLE = 64;

  public int[] smallestSufficientTeam(String[] reqSkills, List<List<String>> people) {
    skillMap = new HashMap<>();
    peopleSkillSet = new HashMap<>();
    int i = 0;
    for (String s : reqSkills) {
      skillMap.put(s, i++);
    }
    for (i = 0; i < people.size(); i++) {
      for (String s : people.get(i)) {
        int skillIndex = skillMap.get(s);
        int skills = peopleSkillSet.getOrDefault(i, 0);
        skills = (skills | (1 << skillIndex));
        peopleSkillSet.put(i, skills);
      }
    }
    int S = ((int) (Math.pow(2, reqSkills.length)) + 1);
    int[][] DP = new int[S][people.size()];
    allSkills = (1 << reqSkills.length) - 1;
    for (i = 0; i < DP.length; i++) {
      for (int j = 0; j < DP[0].length; j++) {
        DP[i][j] = -1;
      }
    }
    int n = dp(0, 0, DP);
    n &= MAX_SKILLS;
    if (n == Integer.MAX_VALUE) return new int[0];
    List<Integer> answer = new ArrayList<>();
    i = 0;
    for (int j = 0; j < people.size(); j++) {
      if (((DP[i][j] & MAX_SKILLS) == n) && (DP[i][j] & CHOOSE_PEOPLE) > 0) {
        i |= (peopleSkillSet.getOrDefault(j, 0));
        answer.add(j);
        n--;
      }
      if (n == 0) break;
    }
    int[] result = new int[answer.size()];
    for (int a = 0; a < result.length; a++) {
      result[a] = answer.get(a);
    }
    return result;
  }

  private int dp(int i, int skill, int[][] DP) {
    if (i >= DP[0].length) {
      if (skill >= allSkills) {
        return 0;
      } else return Integer.MAX_VALUE;
    }
    if (skill == allSkills) return 0;
    else if (DP[skill][i] != -1) return DP[skill][i];
    else {
      int withOut = dp(i + 1, skill, DP);
      int with = dp(i + 1, (skill | peopleSkillSet.getOrDefault(i, 0)), DP);
      with += with != Integer.MAX_VALUE ? 1 : 0;
      if (Math.min(with, withOut) == Integer.MAX_VALUE) {
        DP[skill][i] = Integer.MAX_VALUE;
      } else
        DP[skill][i] =
            ((with & MAX_SKILLS) < (withOut & MAX_SKILLS))
                ? ((with & MAX_SKILLS) | CHOOSE_PEOPLE)
                : (withOut & MAX_SKILLS);
      return DP[skill][i];
    }
  }
}
