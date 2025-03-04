import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;


public class Main {
    static Vector<Vector<Integer>> v = new Vector<Vector<Integer>>();

    public static void  addEdge(int x , int y){
        v.get(x).add(y);
        v.get(y).add(x);
    }
    public static void bfs(boolean[] vis , int x , int y , Queue<Integer> queue){


        if(queue.contains(y)){
            System.out.println("goal found");
            return;
        }

        vis[x] = true;


        if(v.get(x).size() > 0){
            for(int i = 0 ; i < v.get(x).size() ; i++){
              int node =  v.get(x).get(i);
              if(!vis[node]){
                  queue.add(node);
                  System.out.println(node + "was added.");
                  vis[node] = true;
              }
            }
            System.out.println(queue.poll() + " was removed form queue");
        }
        if(queue.isEmpty()){
            System.out.println("goal not found.");
            return;
        }
        int newX = queue.peek();
        System.out.println(newX + " is what we are checking");
        System.out.println(queue);
        bfs(vis,newX,y,queue);


    }


    public static void bfsCall(int n , int x , int y , Queue<Integer> queue){
        boolean[] vis = new boolean[n+1];
        Arrays.fill(vis , false);




        bfs(vis,x,y,queue);
    }




    public static void main(String[] args) {
        for(int i = 0; i < 100; i++)
        {
            v.add(new Vector<Integer>());
        }


        addEdge(1,2);//             1
        addEdge(1,3);//            /  \
        addEdge(2,4);//           2    3
        addEdge(2,5);//          / |
        addEdge(5,6);//         4  5
        addEdge(6,7);//            |
                           //            6
                           //            |
                           //            7
        int start = 4;
        int goal = 7;
        Queue<Integer> queue
                = new LinkedList<Integer>();
        queue.add(start);

        bfsCall(10,start,goal,queue);

    }
}