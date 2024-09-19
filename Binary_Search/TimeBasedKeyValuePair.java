package Binary_Search;

import java.util.*;

public class TimeBasedKeyValuePair {

  private Map<String, TreeMap<Integer, String>> map;

  public TimeBasedKeyValuePair() {
    map = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    map.putIfAbsent(key, new TreeMap<>());
    TreeMap<Integer, String> treeMap = map.get(key);
    treeMap.put(timestamp, value);
  }

  public String get(String key, int timestamp) {
    if (!map.containsKey(key)) {
      return "";
    } else {
      TreeMap<Integer, String> treeMap = map.get(key);
      Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);
      if (entry == null) {
        return "";
      } else {
        return entry.getValue();
      }
    }
  }

  public static void main(String[] args) {
    TimeBasedKeyValuePair task = new TimeBasedKeyValuePair();
    task.set("foo", "bar", 1);
    System.out.println(task.get("foo", 1));
    System.out.println(task.get("foo", 3));
    System.out.println(task.get("foo", 0));
    task.set("foo", "bar2", 4);
    System.out.println(task.get("foo", 3));
    System.out.println(task.get("foo", 4));
    System.out.println(task.get("foo", 5));
  }
}
