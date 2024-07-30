package Graphs;

import java.util.*;

public class AccountsMerge {

    static List<List<String>> accountsMerge(List<List<String>> details)
    {
        int n = details.size();
        DisjointSet1 ds = new DisjointSet1(n);
        HashMap<String, Integer> mapMailNode = new HashMap<>();

        for(int i=0; i<n; i++)
        {
            for(int j=1; j<details.get(i).size(); j++)
            {
                String mail = details.get(i).get(j);
                if(!mapMailNode.containsKey(mail))
                {
                    mapMailNode.put(mail ,i);
                }
                else
                {
                    ds.unionBySize(i, mapMailNode.get(mail));
                }
            }
        }

        ArrayList[] mergedMail = new ArrayList[n];
        for(int i=0; i<n; i++) mergedMail[i] = new ArrayList<String>();
        for(Map.Entry<String, Integer> it : mapMailNode.entrySet())
        {
            String mail = it.getKey();
            int node = ds.findUPar(it.getValue());
            mergedMail[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            if(mergedMail[i].isEmpty()) continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(details.get(i).getFirst());
            temp.addAll(mergedMail[i]);
            ans.add(temp);
        }

        return ans;
    }


    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList() {
            {
                add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j2@com", "j3@com")));
                add(new ArrayList<String>(Arrays.asList("John", "j4@com")));
                add(new ArrayList<String>(Arrays.asList("Raj", "r1@com", "r2@com")));
                add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j5@com")));
                add(new ArrayList<String>(Arrays.asList("Raj", "r2@com", "r3@com")));
                add(new ArrayList<String>(Arrays.asList("Mary", "m1@com")));

            }
        };

        List<List<String>> ans = accountsMerge(accounts);
        int n = ans.size();
        for (List<String> an : ans) {
            System.out.print(an.getFirst() + ": ");
            int size = an.size();
            for (int j = 1; j < size; j++) {
                System.out.print(an.get(j) + " ");
            }

            System.out.println();
        }
    }
}
