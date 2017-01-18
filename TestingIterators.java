import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by karthik on 11/1/2016.
 */
public class TestingIterators {

    public TestingIterators()
    {
        String [][]arr = {{"a1" ,"a2" ,"a3"},{"b1" ,"b2" ,"b3"},{"c1" ,"c2" ,"c3"}};

        Iterator<Iterator<String>> itr = Arrays.asList(arr).stream().map(s -> Arrays.asList(s).iterator()).collect(Collectors.toList()).iterator();
        Flatten(itr);
    }

    public Iterator<String> Flatten(Iterator<Iterator<String>> outer)
    {
        int i = 0;
        String [] results = new String[10];
        while (outer.hasNext())
        {
            int j = 0;
            Iterator<String> inner = outer.next();
            while (inner.hasNext())
            {
                int idx = i + 3 * j;
                results[idx] = inner.next();
                j++;
            }
            i++;
        }
        return Arrays.asList(results).iterator();
    }

}
