import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by karthik on 10/25/2016.
 */
public class MergeSort {

    public MergeSort(){
        List<Integer> myList = Stream.of(10,9,8,7,6,5,4,3,2,1).collect(Collectors.toList());
        //myList.forEach(x -> System.out.println(x));
        mergeSort(myList);
        myList.forEach(x -> System.out.println(x));
    }

    private void mergeSort(List<Integer> A)
    {
        if (A.size() > 1) {
            try {
                int mid = (int)Math.floor(A.size()/2);
                List<Integer> B = A.subList(0, mid ).stream().map(x -> (int)x).collect(Collectors.toList());
                List<Integer> C = new ArrayList<Integer>(A.subList(mid,A.size()));//.stream().map(x -> (int)x).collect(Collectors.toList());
                mergeSort(B);
                mergeSort(C);
                merge(A,B,C);
            }
            catch (Exception e)
            {
                System.out.println(e.toString());

            }

        }
    }

    private void merge(List<Integer> A, List<Integer> B, List<Integer> C) {
        int i=0 ,j=0;
        A.clear();
        while(i < B.size() && j < C.size())
        {
            if(B.get(i) <= C.get(j) )
            {
                A.add(B.get(i));
                i++;
            }
            else
            {
                A.add(C.get(j));
                j++;
            }
        }
        if(i == B.size()) A.addAll(C.subList(j,C.size()));
        else              A.addAll(B.subList(i,B.size()));

    }

}
