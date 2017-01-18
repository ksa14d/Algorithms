import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by karthik on 10/26/2016.
 */
public class BinarySearch {

    public BinarySearch() {
        List<Integer> myList = Stream.iterate(1, x -> x+1).limit(10).collect(Collectors.toList());
        System.out.println(binarySearch(myList, 1));
    }

    public int binarySearch(List<Integer> A, Integer key)
    {
        int low  = 0, high = A.size();

        while(low < high)
        {
            int mid = (int)Math.floor((low + high)/2);
            if(key == A.get(mid))return mid;
            else if(key > A.get(mid))low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
