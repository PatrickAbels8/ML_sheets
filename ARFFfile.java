package sheet01;

import java.util.ArrayList;
import java.util.List;

public class ARFFfile {


    private String relation;

    private List<NominalAttribute> attributes;

    private  Dataset data;

    public ARFFfile(String relation) {
        this.relation = relation;
        attributes = new ArrayList<>(5);
        data = new Dataset();
    }

    public String getRelation() {
        return relation;
    }

    public List<NominalAttribute> getAttributes() {
        return attributes;
    }

    public void addAttribute(NominalAttribute att)
    {
        this.attributes.add(att);
    }

    public Dataset getData() {
        return data;
    }

    @Override
    public String toString() {
        return "ARFFfile{" +
                "relation='" + relation + '\n' +
                ", attributes=" + attributes +
                ",\n data=" + data +
                '}';
    }
}
