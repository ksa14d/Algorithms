import sun.reflect.generics.tree.Tree;

import javax.jnlp.PersistenceService;
import java.awt.peer.CanvasPeer;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import   java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by karthik on 10/23/2016.
 */
public class MainClass
{

    public static void main(String[] args)
    {
        // Set<Person> set = new HashSet<>()  -> un ordered   :: containsAll AddAll retainsAll removeAll : Subset union  intersection set diff
        // or TreeSet<>()  -> sorted
        // or LinkedHashSet<>() -> maintains insertion order

        // List<Person> list = new ArrayList<>() or LinkedList<> :: add remove

        // Queue<Person> que = new LinkedList<>() or PriorityQueue() :: offer poll peek

        // Deque<Person> deq = new LinkedList<>() or ArrayDeque<>() :: que first last

        // Map<k,v> kvmap = new HashMap<k,v>() or new TreeMap<k,v>() or new LinkedHashMap<k,v>()  :: get put
        // kvmap.stream().forEach( (k,v) -> { // doOps } );
        List<Person> people = new ArrayList<Person>();
        Person karthik = new Person();
        karthik.setAddress("Tallahassee");
        karthik.setAge(27);
        karthik.setName("karthik");
        people.add(karthik);

        Person shankar = new Person();
        shankar.setAddress("Bangalore");
        shankar.setAge(57);
        shankar.setName("shankar");
        people.add(shankar);

        Person suvarna = new Person();
        suvarna.setAddress("Bangalore");
        suvarna.setAge(57);
        suvarna.setName("suvarna");
        people.add(suvarna);

        Person vikas = new Person();
        vikas.setAddress("SFO");
        vikas.setAge(37);
        vikas.setName("vikas achalkar");
        people.add(vikas);

        Person akshatha = new Person();
        akshatha.setAddress("SFO");
        akshatha.setAge(1);
        akshatha.setName("akshatha");
        people.add(akshatha);

        Person suresh = new Person();
        suresh.setAddress("SFO");
        suresh.setAge(57);
        suresh.setName("suresh");
        people.add(suresh);
        people.forEach(p -> System.out.println(p.getName().contains("achalkar")));
        vikas.setDependents(Arrays.asList(suresh,akshatha));
        suresh.setDependents(Arrays.asList(vikas,akshatha));
        shankar.setDependents(Arrays.asList(suvarna,karthik,vikas));
        karthik.setDependents(Arrays.asList(shankar, suvarna));




        List<String> depOfKarthik = people.stream()
                .filter(x -> x.getName().contains("achalkar") && x.getDependents() != null)
                .map(x -> x.getDependents())
                .flatMap(x -> x.stream())
                .sorted(Comparator.comparing(Person::getName))
                .map(s ->  s.getName())
                .collect(Collectors.toList());

        depOfKarthik.forEach(name -> System.out.println(name));

        Map<Person,Integer> depCount = people.stream()
                .filter(s -> s.dependents != null)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.summingInt(s -> s.getDependents().size())));

        depCount.entrySet().forEach(x -> System.out.println(x.getKey().getName()+" "+x.getValue()));

        String[] myArray = { "this", "is", "a", "sentence" };
        String result = Arrays.stream(myArray)
                .reduce("Now !", (a,b) -> a +" "+ b);


        System.out.println(result);

        String join = Arrays.stream(myArray)
                .collect(Collectors.joining("-","Now !! "," joined"));

        List<String> Strings = new ArrayList<String>();
        for(int i =0 ; i < 10  ; i++)
        {
            Strings.add(new String(join));
        }

        List<String[]> spl  =  Strings.stream().map(s -> s.split("[ -]")).collect(Collectors.toList());

        List<String> joint = spl.stream().map(s -> Arrays.stream(s).collect(Collectors.joining(" $ "))).collect(Collectors.toList());

        System.out.println(join);

        Stream.iterate(1 , x -> x +  1).skip(2).limit(10).forEach(System.out::println);

        Stream.generate(new Random()::nextInt).skip(2).limit(10).forEach(System.out::println);

        Map<Person,String> personToDeps = people.stream().filter(p -> p.dependents != null).collect(Collectors.toMap(p -> p ,p -> p.getAddress()));

        Map<Integer,String> AgeToNames = people.stream().collect(Collectors.toMap(p -> p.getAge(), p -> p.getName(),(s,a) -> s+ ", "+ a)); // reduction for names

        TreeMap<String,Set<String>> l = people.stream().collect(Collectors.groupingBy(p -> p.getAddress(),TreeMap::new,Collectors.mapping(p -> p.name, Collectors.toSet())));

        TreeMap<String,TreeSet<String>> m = people.stream().collect(Collectors.groupingBy(Person::getAddress,TreeMap::new,Collectors.mapping(Person::getName,Collectors.toCollection(TreeSet::new))));

  //QuickSort ms = new QuickSort();
        //BinarySearch sr = new BinarySearch();
        //TreeTraversal tr = new TreeTraversal();
       // Prims pr = new Prims();
        //Kruskals k = new Kruskals();
        //Dijkstras d = new Dijkstras();
        //HeapSort h = new HeapSort();
       // Fibbonacci f = new Fibbonacci();
       // Factorial f = new Factorial(5);
       //ConvexHull h = new ConvexHull();
       // RegularExpress x = new RegularExpress();

        

    }

}
