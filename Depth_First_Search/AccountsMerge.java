package Depth_First_Search;

import java.util.*;

public class AccountsMerge {

  private class Account {
    String email, name;

    Account(String email, String name) {
      this.email = email;
      this.name = name;
    }
  }

  private Map<Integer, Account> numMap; // for simplicity mapping each email to a unique integer
  private Map<String, Integer> emailMap;
  private Map<Integer, List<Integer>> graph;
  private BitSet done;
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    List<String> account1 = new ArrayList<>();
    List<List<String>> accounts = new ArrayList<>();
    account1.add("John");
    account1.add("johnsmith@mail.com");
    account1.add("john00@mail.com");
    accounts.add(account1);

    List<String> account2 = new ArrayList<>();
    account2.add("John");
    account2.add("johnnybravo@mail.com");
    accounts.add(account2);

    List<String> account3 = new ArrayList<>();
    account3.add("John");
    account3.add("johnsmith@mail.com");
    account3.add("john_newyork@mail.com");
    accounts.add(account3);

    List<String> account4 = new ArrayList<>();
    account4.add("Mary");
    account4.add("mary@mail.com");
    accounts.add(account4);

    List<List<String>> result = new AccountsMerge().accountsMerge(accounts);
    System.out.println(result);
  }

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    done = new BitSet();
    numMap = new HashMap<>();
    emailMap = new HashMap<>();
    graph = new HashMap<>();
    int index = -1;
    for (List<String> account : accounts) {
      String name = account.get(0);
      int prev = -1;
      for (int i = 1, l = account.size(); i < l; i++) {
        String email = account.get(i);
        int vertex;
        if (!emailMap.containsKey(email)) {
          vertex = ++index;
          emailMap.put(email, vertex);
          numMap.put(vertex, new Account(email, name));
        } else {
          vertex = emailMap.get(email);
        }
        graph.putIfAbsent(vertex, new ArrayList<>());
        if (i != 1) {
          // make bi-directional link
          graph.get(prev).add(vertex);
          graph.get(vertex).add(prev);
        }
        prev = vertex;
      }
    }
    List<List<String>> result = new ArrayList<>();
    for (int i : graph.keySet()) {
      if (!done.get(i)) {
        List<Integer> list = new ArrayList<>();
        List<String> account = new ArrayList<>();
        dfs(i, list);
        list.stream().forEach(x -> account.add(numMap.get(x).email));
        account.sort(String::compareTo);

        // Add account user name
        Account acc = numMap.get(list.get(0));
        account.add(0, acc.name);
        result.add(account);
      }
    }
    return result;
  }

  private void dfs(int i, List<Integer> list) {
    done.set(i);
    list.add(i);
    List<Integer> children = graph.get(i);
    if (children != null) {
      for (int c : children) {
        if (!done.get(c)) {
          dfs(c, list);
        }
      }
    }
  }
}
