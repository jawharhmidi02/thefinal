package bigdata.project;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AppMapper extends Mapper<Object, Text, Text, DoubleWritable> {

    private Text restaurantName = new Text();
    private DoubleWritable rating = new DoubleWritable();

    @Override
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {

        String line = value.toString();
        if (line.startsWith("order_id")) {
            return;
        }

        String[] fields = line.split(",");

        if (fields.length == 4) {
            try {
                restaurantName.set(fields[2]);
                rating.set(Double.parseDouble(fields[3]));
                context.write(restaurantName, rating);
            } catch (NumberFormatException e) {

            }
        }
    }
}
