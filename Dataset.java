package sheet01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dataset {


	private List<Row> rows;


    public Dataset() {
        this.rows = new ArrayList<>(10);
    }

    public void addRow(String[] row) {
        this.rows.add(new Row(row));
    }

    public List<Row> getRows() {
        return rows;
    }

    public class Row {
        public String[] values;

        public Row(String[] values) {
            this.values = values;
        }

        public String[] getValues() {
            return values;
        }

        @Override
        public String toString() {
            return "Row{" +
                    "values=" + Arrays.toString(values) +
                    "}\n";
        }
    }


    @Override
    public String toString() {
        return "Table{" +
                "rows=" + rows +
                '}';
    }

}
