import java.security.cert.PKIXRevocationChecker;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Created by karthik on 10/26/2016.
 */
public class Prims {

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
    public Prims()
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

        for(int i = 0 ; i < c.length ; i++ )
            for(int j = 0 ; j < c[i].length ; j++)
            {
                costs.add(new Cost(i, j, c[i][j]));
            }
        minSpanningTree(costs, c.length);
    }

    public void minSpanningTree(List<Cost> costs, int n)
    {
        int edgeCount =0, minCost =0 ;
        List<Integer> elec = new ArrayList<Integer>();
        elec.add(0);
        while (edgeCount != n-1)
        {
            Cost min = costs.stream().filter(c -> elec.contains(c.src) && !elec.contains(c.dst)).min(Comparator.comparing(c -> c.cost)).get();
            System.out.println(min.src+"--->"+ min.dst +" = "+ min.cost);
            elec.add(min.dst);
            edgeCount++;
            minCost+= min.cost;
        }
        System.out.println("Min Cost --->"+minCost);
    }
}
