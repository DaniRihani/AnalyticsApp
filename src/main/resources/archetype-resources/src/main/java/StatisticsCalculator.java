import java.util.Collections;
import java.util.List;

public class StatisticsCalculator {
    public static double getMax(List<Double> values) {
        return Collections.max(values);
    }

    public static double getMin(List<Double> values) {
        return Collections.min(values);
    }

    public static double getMedian(List<Double> values) {
        Collections.sort(values);
        int size = values.size();
        if (size % 2 == 0) {
            return (values.get(size / 2 - 1) + values.get(size / 2)) / 2.0;
        } else {
            return values.get(size / 2);
        }
    }
}
