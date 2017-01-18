import sun.security.provider.certpath.Vertex;

import java.util.*;

/**
 * Created by karthik on 11/1/2016.
 */
public class Graph {

    private class Vertex
    {
        int num;

        List<Vertex> edges;

        boolean isVisited;

        public List<Vertex> getEdges() {
            return edges;
        }

        public void setEdges(List<Vertex> edges) {
            this.edges = edges;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public boolean isVisited() {
            return isVisited;
        }

        public void setVisited(boolean visited) {
            isVisited = visited;
        }

        public void print()
        {
            System.out.println(num);
        }
    }

    public Graph()
    {
        List<Vertex> graph = new LinkedList<>();
        Vertex v0 = new Vertex();
        v0.num = 0;

        Vertex v1 = new Vertex();
        v1.num = 1;

        Vertex v2 = new Vertex();
        v2.num = 2;

        Vertex v3 = new Vertex();
        v3.num = 3;

        v0.setEdges(Arrays.asList(v1,v2));
        v1.setEdges(Arrays.asList(v2));
        v2.setEdges(Arrays.asList(v0,v3));
        v3.setEdges(Arrays.asList(v3));

        graph.addAll(Arrays.asList(v0,v1,v2,v3));

    }

    public void bfs(Vertex src)
    {
        Queue<Vertex> que = new LinkedList<>();
        que.offer(src);
        src.isVisited = true;
        while (!que.isEmpty())
        {
            Vertex n = que.poll();
            n.print();
            if(n.edges != null)
            n.edges.stream().filter(v -> !v.isVisited()).forEach(v -> {
                v.setVisited(true);
                que.add(v);
            });
        }
    }

    public void  dfs(Vertex src)
    {
        Stack<Vertex> memory = new Stack<>();
        memory.push(src);
        while (!memory.isEmpty())
        {
            Vertex u = memory.pop();
            if(!u.isVisited()) {
                u.setVisited(true);
                u.print();
                if(u.edges != null)
                u.edges.stream().filter(v -> !v.isVisited()).forEach(v -> memory.push(v));
            }

        }
    }


}
