import sun.security.provider.certpath.Vertex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by karthik on 10/26/2016.
 */
public class Dijkstras {

    private class Vertex
    {
        public Vertex(int n , Integer dist , boolean v)
        {
            num = n;
            distance = dist;
            isVisited = v;
        }
        public int num;
        public Integer distance;
        public boolean isVisited;
    }

    public Dijkstras(){

        int x = Integer.MAX_VALUE - 1000;
        int [][]c = {
                {x,3,x,7,x},
                {3,x,4,2,x},
                {x,4,x,5,6},
                {7,2,5,x,4},
                {x,x,6,4,x}};


        int n = c.length , src = 0;
        List<Vertex> vertices = Stream.iterate(0, k -> k+1).limit(n).map(k -> new Vertex(k, c[src][k], false)).collect(Collectors.toList());
        vertices.stream().filter(v -> v.num == src).findFirst().ifPresent(v -> {v.isVisited = true; v.distance = 0;});
        singleSourceShortestPath(c, vertices);
        vertices.stream().forEach(v -> System.out.println(src+"---------->"+v.num+" = "+v.distance));
    }

    public void singleSourceShortestPath(int[][] cost , List<Vertex> vertices)
    {
        int count = 1;
        while (count != vertices.size())
        {
            Vertex minDistVertex = vertices.stream().filter(v -> !v.isVisited).min(Comparator.comparing(v -> v.distance)).get();
            minDistVertex.isVisited = true;
            int u = minDistVertex.num;
            int min = minDistVertex.distance;
            count++;
            vertices.stream().filter(v -> !v.isVisited && (min + cost[u][v.num]) < v.distance).forEach(v -> v.distance = min + cost[u][v.num]);
        }
    }


}
