package org.example;

import com.mongodb.client.*;
import org.bson.Document;



public class MongoDBUtils {
    private static final String CONNECTION_STRING = "mongodb://admin:admin@mongodb:27017";
    private static final String DATABASE_NAME = "analyticsDB";
    private static final String COLLECTION_NAME = "averages";

    public static void saveResults(double max, double median, double min) {
        try (MongoClient mongoClient = MongoClients.create(CONNECTION_STRING)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

            Document document = new Document("max", max)
                    .append("median", median)
                    .append("min", min);

            collection.insertOne(document);
            System.out.println("Results saved to MongoDB!");
        }
    }
}
