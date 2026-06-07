import java.util.*;

public class MinimumCostToConnect {
    static class Info implements Comparable<Info> {
        int n;
        int cost;

        public Info(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }

        @Override
        public int compareTo(Info i2){
            return this.cost - i2.cost;//ascending
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {  { 0, 1, 2, 3, 4 },
                            { 1, 0, 5, 0, 7 },
                            { 2, 5, 0, 6, 0 },
                            { 3, 0, 6, 0, 0 },
                            { 4, 7, 0, 0, 0 } };

    
      System.out.println(getMinCostToConnect(matrix));

    }
    public static int getMinCostToConnect(int [][] graph){
        //as you know the cell i,j represent the cost of i ---j = cost[i][j]
        //here we do prim algo to find mst
        Set<Integer> visit = new HashSet<>();
        PriorityQueue<Info> pq = new PriorityQueue<>();

        pq.add(new Info(0,0));
        int cost = 0;
        while(!pq.isEmpty()){
            Info curr = pq.remove();

            if(!visit.contains(curr.n)){
                visit.add(curr.n);
                cost+=curr.cost;
               for(int i = 0;i < graph[0].length;i++){
                  if(graph[curr.n][i] != 0){
                    pq.add(new Info(i, graph[curr.n][i]));
                  }
               }
            }
        }
        return cost;

    }
}