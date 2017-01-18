import sun.security.provider.certpath.Vertex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by karthik on 10/26/2016.
 */
public class Kruskals {

    private class Cost
    {
        public Cost(int x , int y , int c)
        {
            src = x;
            dst = y;
            cost = c;
        }
        public int src;
        public int dst;

        public int cost;


    }

    private int[] parent;

    public Kruskals()
    {
        int n =10;
        int x = Integer.MAX_VALUE;
        int [][]c = {
                {x,3,x,x,6,5},
                {3,x,1,x,x,4},
                {x,1,x,6,x,4},
                {x,x,6,x,8,5},
                {6,x,x,8,x,2},
                {5,4,4,5,2,x}} ;
        List<Cost> costs = new ArrayList<Cost>();

        parent = new int[c.length];

        for(int i = 0 ; i < c.length ; i++ ) {
            parent[i] = -1;
            for (int j = 0; j < c[i].length; j++) {
                costs.add(new Cost(i, j, c[i][j]));
            }
        }
        minSpanningTree(costs, c.length);
    }

    public void minSpanningTree(List<Cost> costs, int n)
    {
        int edgeCount =0, minCost =0 ;

        while (edgeCount != n-1)
        {
            Cost min = costs.stream().filter(c -> rootParent(c.src) != rootParent(c.dst)).min(Comparator.comparing(c -> c.cost)).get();
            System.out.println(min.src +1 +"--->"+ (1+min.dst) +" = "+ min.cost);
            parent[rootParent(min.dst)] = rootParent(min.src);
            edgeCount++;
            minCost+= min.cost;
            min.cost = Integer.MAX_VALUE;
            costs.stream().filter(c -> c.src == min.dst && c.dst == min.src).findFirst().get().cost = Integer.MAX_VALUE;
        }
        System.out.println("Min Cost --->"+minCost);
    }

    private int rootParent(int vertex) {

        while(parent[vertex] != -1)vertex = parent[vertex];
        return vertex;
    }


}
