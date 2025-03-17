package org.example;

import java.util.List;

public class App
{
    public static void main(String[] args) {
        // Read data from MySQL
        List<Double> averages = DatabaseUtils.getAverageValues();

        if (averages.isEmpty()) {
            System.out.println("No data found in MySQL.");
            return;
        }

        // Calculate statistics
        double max = StatisticsCalculator.getMax(averages);
        double median = StatisticsCalculator.getMedian(averages);
        double min = StatisticsCalculator.getMin(averages);

        // Store results in MongoDB
        MongoDBUtils.saveResults(max, median, min);
    }
}
