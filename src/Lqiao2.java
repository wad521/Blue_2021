import java.util.*;

public class Lqiao2 {
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
        s3.add("johnsmith@mail.com");
        s3.add("john_newyork@mail.com");
        accounts.add(s3);
        List<String> s4 = new ArrayList<>();
        s4.add("Mary");
        s4.add("mary@mail.com");
        accounts.add(s4);
        List<List<String>> sss = accountsMerge(accounts);
        for(List<String> s :sss){
            System.out.println(s);
        }
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> EmailInIndex = new HashMap<String, Integer>();
        Map<String, String> EmailOfName = new HashMap<String, String>();
        int count_email = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            int size = account.size();
            for (int i = 1; i < size; i++) {
                String email = account.get(i);
                if (!EmailInIndex.containsKey(email)) {
                    EmailInIndex.put(email, count_email++);
                    EmailOfName.put(email, name);
                }
            }
            //System.out.println(EmailInIndex);
            //System.out.println(EmailOfName);
        }
        UnionFind3 u3 = new UnionFind3(count_email);
        for (List<String> account : accounts) {
            String fist_email = account.get(1);
            int size = account.size();
            for (int i = 2; i < size; i++) {
                String next_email = account.get(i);
                int first_idx = EmailInIndex.get(fist_email);
                int next_idx = EmailInIndex.get(next_email);
                u3.union(first_idx, next_idx);
            }
        }

        Map<Integer, List<String>> IndexToEmail = new HashMap<Integer, List<String>>();
        for (String email : EmailInIndex.keySet()) {
            int index = u3.find(EmailInIndex.get(email));
            List<String> acco = IndexToEmail.getOrDefault(index, new ArrayList<String>());
            acco.add(email);
            IndexToEmail.put(index, acco);
            //System.out.println(IndexToEmail);
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for (List<String> emails : IndexToEmail.values()) {
            Collections.sort(emails);
            String name = EmailOfName.get(emails.get(0));
            List<String> r1 = new ArrayList<String>();
            r1.add(name);
            r1.addAll(emails);
            result.add(r1);
        }
        return result;
    }
}

class UnionFind3 {
    int[] parent;

    public UnionFind3(int len) {
        parent = new int[len];
        for (int i = 0; i < len; i++) {
            parent[i] = i;
        }
    }

    public void union(int idx1, int idx2) {
        int idx = find(idx1);
        int sdx = find(idx2);
        parent[sdx] = idx;
//        for (int i = 0; i < parent.length; i++) {
//            System.out.print(parent[i] + " ");
//        }
//        System.out.println();
    }

    public int find(int idx) {
        if (parent[idx] != idx) {
            parent[idx] = find(parent[idx]);
        }
        return parent[idx];
    }
}
