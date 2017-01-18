import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by karthik on 10/26/2016.
 */
public class QuickSort<T extends Comparable<T>> {

    public QuickSort(){
        //List<Integer> myList = Stream.of(10,9,8,7,6,5,4,3,2,1).collect(Collectors.toList());
        //myList.forEach(x -> System.out.println(x));
        //quickSort(myList);
        //myList.forEach(x -> System.out.println(x));
    }

    public void quickSort(List<T> A)
    {
       if( A.size() > 1)
       {
           int s = partition(A);
           quickSort(A.subList(0,s));
           quickSort(A.subList(s+1,A.size()));
       }
    }

    private int partition(List<T> A) {
        T p = A.get(0);
        int i = 1 , j = A.size() - 1;
        while(i < j) {
            while (A.get(i).compareTo(p) < 0 && i < A.size() - 1) i++;
            while (A.get(j).compareTo(p) > 0 && j > 0) j--;
            if (i < j) {
                T temp = A.get(i);
                A.set(i, A.get(j));
                A.set(j, temp);
            }
            else
            {
                T temp = A.get(0);
                A.set(0, A.get(j));
                A.set(j, temp);
            }
        }
        return j;
    }
}
