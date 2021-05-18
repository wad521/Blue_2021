import java.util.*;


public class email_name {
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<List<String>>();
        List<String> s1 = new ArrayList<>();
        s1.add("John");
        s1.add("johnsmith@mail.com");
        s1.add("john00@mail.com");
        accounts.add(s1);
        List<String> s2 = new ArrayList<>();
        s2.add("John");
        s2.add("johnnybravo@mail.com");
        accounts.add(s2);
        List<String> s3 = new ArrayList<>();
        s3.add("John");
        s3.add("john_newyork@mail.com");
        s3.add("johnsmith@mail.com");
        accounts.add(s3);
        List<String> s4 = new ArrayList<>();
        s4.add("Mary");
        s4.add("mary@mail.com");
        accounts.add(s4);
        Solution1   so = new Solution1();

        List<List<String>> s7 = so.accountsMerge(accounts);
        for(List<String> account :s7){
            System.out.println(account);
        }
    }
}
class Solution1 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToIndex = new HashMap<String, Integer>();
        Map<String, String> emailToName = new HashMap<String, String>();
        //邮箱编号  从0开始
        int emailsCount = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            int size = account.size();
            for (int i = 1; i < size; i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, emailsCount++);
                    emailToName.put(email, name);
                }
            }
            System.out.println("邮箱-编号："+emailToIndex);
            System.out.println("邮箱-姓名"+emailToName);
        }
        UnionFind2 uf = new UnionFind2(emailsCount);
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            int firstIndex = emailToIndex.get(firstEmail);
            int size = account.size();
            for (int i = 2; i < size; i++) {
                String nextEmail = account.get(i);
                int nextIndex = emailToIndex.get(nextEmail);
                uf.union(firstIndex, nextIndex);
            }
        }
        Map<Integer, List<String>> indexToEmails = new HashMap<Integer, List<String>>();
        for (String email : emailToIndex.keySet()) {
            int index = uf.find(emailToIndex.get(email));
            List<String> account = indexToEmails.getOrDefault(index, new ArrayList<String>());
            account.add(email);
            indexToEmails.put(index, account);
            System.out.println(indexToEmails);
        }
        List<List<String>> merged = new ArrayList<List<String>>();
        for (List<String> emails : indexToEmails.values()) {
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<String>();
            account.add(name);
            account.addAll(emails);
            merged.add(account);
        }
        return merged;
    }
}

class UnionFind2 {
    int[] parent;

    public UnionFind2(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void union(int index1, int index2) {
        parent[find(index2)] = find(index1);

        for(int i :parent){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public int find(int index) {
        if (parent[index] != index) {
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }
}