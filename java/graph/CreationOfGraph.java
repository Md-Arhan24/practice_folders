import java.util.*;
import java.util.LinkedList;
class CreationOfGraph{
    static class Edge{
        int src,des,weight;

        public Edge(int s,int d,int w){
            this.src = s;
            this.des = d;
            this.weight = w;
        }
    }

    public static void printneigbours(int vertex,ArrayList<Edge> graph []){
        System.out.println("the neighbours are :");
        for(Edge e : graph[vertex]){
            System.out.print(e.des+" ");
        }
    }
    public static void bfs(ArrayList<Edge> graph [],int vertex){
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();//instead of an boolean array

        q.add(vertex);
        while(!q.isEmpty()){
            int ver = q.remove();
            if(!set.contains(ver)){
                System.out.println(ver);
                for(Edge e : graph[ver]){
                    q.add(e.des);
                }
                set.add(ver);
            }
        }

    }

    //DFS
    public static void dfs(ArrayList<Edge> graph [],int vertex,Set<Integer> set){
                   //add it 
            System.out.print(vertex+" ");
            set.add(vertex);//mark as visited
            //cal for neighbour
            for(Edge e: graph[vertex]){
                //we have call for only those are not visisted
                if(!set.contains(e.des)){
                    dfs(graph,e.des,set);
                }
            }
    }

    //hasPath
    public static boolean hasPath(ArrayList<Edge> graph[],int src,int des,Set<Integer> set){
        if(src == des){
            return true;
        }
        set.add(src);
        for(Edge e : graph[src]){
            if(!set.contains(e.des) && hasPath(graph, e.des, des, set))return true;
        }
        return false;
    }


    //disconnect components
    //main dfs
    public static void mainDfs(ArrayList<Edge> graph []){
        Set<Integer> visited = new HashSet<>();

        for(int i = 0;i < graph.length;i++){
            if(!visited.contains(i)){

                mainDfsUtil(graph,i,visited);
            }
        }
       
    }

    public static void mainDfsUtil(ArrayList<Edge> graph [],int src,Set<Integer> visited){
        //first makr as visited
        visited.add(src);
        System.out.println(src +" ");
        for(int k = 0;k < graph[src].size();k++){
            Edge e = graph[src].get(k);
            if(!visited.contains(e.des)){
                mainDfsUtil(graph, e.des, visited);
            }
        }

    }

    public static void mainBfs(ArrayList<Edge> graph []){
        Set<Integer> visit = new HashSet<>();

        for(int i = 0;i < graph.length;i++){
            if(!visit.contains(i)){
                bfsUtil(graph,i,visit);
            }
        }
    }
    public static void bfsUtil(ArrayList<Edge> graph [],int src,Set<Integer> visit){
         Queue<Integer> q = new LinkedList<>();
         q.add(src);

         while(!q.isEmpty()){
            int curr = q.remove();
            if(!visit.contains(curr)){
                System.out.println(curr+" ");
                for(Edge e : graph[src]){
                    q.add(e.des);

                }
                visit.add(curr);
            }
         }
    }

    public static void main(String[] args) {
        int v = 11;
        //dont write -- ArrayList<Edge> graph [] = new ArrayList<Edge>[v];
        
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph [] = new ArrayList[v];

        //now,at every index there is null, so lets make intilize them with aray list
        for(int i = 0; i < v;i++){
            graph[i] = new ArrayList<>();
        }

        /*add this graph manually
        the graph is
 
0        2------2----4
 \      / \                   6---7
  5    1   1                   |
   \ /        \                9---10
    1------3----3
        
        
        */

        //idx.add(src,des,wei)
        graph[0].add(new Edge(0, 1, 5));

        //vertex 1
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
        graph[1].add(new Edge(1, 0, 5));
        //vertex 2
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        //vertex 3
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        //vertex 4
        graph[4].add(new Edge(4, 2, 2));


        //vertex 6
        graph[6].add(new Edge(6, 7, 1));
        graph[6].add(new Edge(6, 9, 1));

        //vertex 7
        graph[7].add(new Edge(7,6,1));

        //verted 9
        graph[9].add(new Edge(9,6, 1));
        graph[9].add(new Edge(9, 10, 1));

        //vertex 10
        graph[10].add(new Edge(10,9,1));
        




        // printneigbours(2,graph);
        // System.out.println();
        // bfs(graph,0);//0 1 2 3 4
        // dfs(graph,0,new HashSet<>());//0 1 2 3 4
        // System.out.println(hasPath(graph, 0, 10, new HashSet<>()));

        // mainDfs(graph);
        mainBfs(graph);

        
    }
}