import java.util.stream.Stream;

/**
 * Created by karthik on 10/27/2016.
 */
public class Factorial {

    public Factorial(int n)
    {
        long factorial =  Stream.iterate(n, x -> x -1).limit(n).reduce(1, (x,y) -> x*y);
        System.out.println("factorial of n : "+ factorial);
    }
}
