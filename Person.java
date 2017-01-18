import java.util.List;

/**
 * Created by karthik on 10/23/2016.
 */
public class Person
{
    String name ;
    int age ;
    String address;
    List<Person> dependents;

    public Person()
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Person> getDependents() {
        return dependents;
    }

    public void setDependents(List<Person> dependents) {
        this.dependents = dependents;
    }
}
