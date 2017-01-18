import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by karthik on 10/28/2016.
 */
public class ConvexHull {

    public ConvexHull()
    {
        int[][] p = {{0, 3}, {1, 1}, {2, 2}, {4, 4},
                        {0, 0}, {1, 2}, {3, 1}, {3, 3}};

       List<Point> points = new ArrayList<>();
        for (int[] x : p)
            points.add(new Point(x[0], x[1]));
        convexHull(points);

    }
    private class Point implements Comparable<Point>
    {
       public int x;
       public int y;
        public Point(int p , int q)
        {
            x=p;y=q;
        }

        @Override
        public int compareTo(Point p2) {
            int o = orientation(p0 , this, p2);
            if (o == 0)
                return (distSq(p0, p2) >= distSq(p0, this))? -1 : 1;
            return (o == 2)? -1: 1;
        }
    }



    Point p0;

    int distSq(Point p1, Point p2)
    {
        //(x+y)^2 > x^2 + y^2  > x+y abs
        return (p1.x - p2.x)*(p1.x - p2.x) +
                (p1.y - p2.y)*(p1.y - p2.y);
    }

    int orientation(Point p, Point q, Point r)
    {
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if (val == 0) return 0;  // colinear
        return (val > 0)? 1: 2; // clock or counterclock wise
    }



    void convexHull(List<Point> points)
    {

        if (points.size() < 3) return;
        // Initialize Result
        Queue<Point> hull = null;

        // Find the bottom most point
        p0 = points.stream().min(Comparator.comparing(p -> p.y)).get();
        p0 = points.stream().filter(p -> p.y == p0.y).min(Comparator.comparing(p -> p.x)).get();
        points.remove(p0);

        //sort the points with respect to the polar angle or slope of the line wrt x - axis
       // points.sort(Point::compareTo);
        new QuickSort<Point>().quickSort(points);

        //filter redundant points from hull
        hull = Stream.iterate(0, x -> x+1)
                .limit(points.size())
                .filter(i -> ( (i+1 < points.size() && orientation(p0, points.get(i),points.get(i+1)) != 0) || i == points.size()-1 ))
                .map(i -> points.get(i))
                .collect(Collectors.toCollection(LinkedList::new));

        if (hull.size() < 3) return;

        // Create an empty stack and push first three points
        // to it.
        Stack<Point> S = new Stack<>();
        S.push(p0);
        S.push(hull.poll());
        S.push(hull.poll());

        hull.stream().forEach(h -> {
                              //    prev           curr      next
            while (orientation(S.get(S.size()-2), S.peek(), h) != 2)  // keep popping till top of stack is comfortable with hull
                S.pop();
            S.push(h);
        });

        while (!S.isEmpty())
        {
            Point p = S.pop();
            System.out.println("("+p.x+","+p.y+")");
        }
    }
}
