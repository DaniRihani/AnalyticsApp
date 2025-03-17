package org.example;

import java.util.Collections;
import java.util.List;

public class StatisticsCalculator {
    public static double getMax(List<Double> values) {

        if(!values.isEmpty()) {
            return Collections.max(values);
        }else {
            return 0;
        }

    }

    public static double getMin(List<Double> values) {
        if(!values.isEmpty()) {
            return Collections.min(values);
        }else {
            return 0;
        }
    }

    public static double getMedian(List<Double> values) {
        if (values.isEmpty()) {
            return 0;
        }
        Collections.sort(values);
        int size = values.size();
        if (size % 2 == 0) {
            return (values.get(size / 2 - 1) + values.get(size / 2)) / 2.0;
        } else {
            return values.get(size / 2);
        }
    }
}
