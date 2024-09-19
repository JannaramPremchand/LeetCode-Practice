package Hashing;

import java.util.*;

public class AnalyzeUserWebsiteVisitPattern {
  private class VisitCount {
    String site;
    int count;

    VisitCount(String site, int count) {
      this.site = site;
      this.count = count;
    }

    public String getSite() {
      return site;
    }

    public int getCount() {
      return count;
    }
  }

  private class WebsiteTime {
    String website;
    int time;

    WebsiteTime(String website, int time) {
      this.website = website;
      this.time = time;
    }

    public int getTime() {
      return time;
    }
  }

  Map<String, Set<String>> userVisitCount;

  public static void main(String[] args) {
    String[] userName = {
      "joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"
    };
    int[] time = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    String[] website = {
      "home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"
    };
    List<String> result =
        new AnalyzeUserWebsiteVisitPattern().mostVisitedPattern(userName, time, website);
    System.out.println(result);
  }

  public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
    userVisitCount = new HashMap<>();
    for (int i = 0; i < username.length; i++) {
      for (int j = i + 1; j < username.length; j++) {
        if (username[i].equals(username[j])) {
          for (int k = j + 1; k < username.length; k++) {
            if (username[i].equals(username[j]) && username[j].equals(username[k])) {
              List<WebsiteTime> visits =
                  Arrays.asList(
                      new WebsiteTime(website[i], timestamp[i]),
                      new WebsiteTime(website[j], timestamp[j]),
                      new WebsiteTime(website[k], timestamp[k]));
              visits.sort(Comparator.comparingInt(WebsiteTime::getTime));
              String concatinatedWebsite =
                  String.join(
                      "-", visits.get(0).website, visits.get(1).website, visits.get(2).website);
              userVisitCount.putIfAbsent(concatinatedWebsite, new HashSet<>());
              userVisitCount.get(concatinatedWebsite).add(username[i]);
            }
          }
        }
      }
    }
    List<VisitCount> visitCounts = new ArrayList<>();
    for (String k : userVisitCount.keySet()) {
      visitCounts.add(new VisitCount(k, userVisitCount.get(k).size()));
    }
    visitCounts.sort(
        Comparator.comparingInt(VisitCount::getCount)
            .reversed()
            .thenComparing(VisitCount::getSite));
    VisitCount visitCount = visitCounts.get(0);
    String[] result = visitCount.getSite().split("-");
    return Arrays.asList(result[0], result[1], result[2]);
  }
}
