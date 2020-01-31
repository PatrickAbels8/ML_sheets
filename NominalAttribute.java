package sheet01;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NominalAttribute {
    private String name;
    private Set<String> values;


    public NominalAttribute(String name) {
        this.name = name;
        values= new HashSet<>(4);
    }

    public String getName() {
        return name;
    }

    public void addValue(String name) {
        values.add(name);
    }

    public Set<String> getValues() {
        return values;
    }
    

    @Override
    public String toString() {
        return "@NominalAttribute " +
                name +
                "{ " + values +
                '}';
    }

}
