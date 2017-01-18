import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by karthik on 10/27/2016.
 */
public class Fibbonacci
{

    public Fibbonacci() {
        List<Integer> H = new ArrayList<>();
        H.add(0); H.add(1);
        Stream.iterate(H , x -> {int i = H.size(); H.add(H.get(i-1) + H.get(i-2)); return H;}).limit(30).collect(Collectors.toList());
        String s = H.stream().map(x -> x.toString()).collect(Collectors.joining(" "));
        System.out.println(s);
    }
}
