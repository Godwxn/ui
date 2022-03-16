package com.moso;

import static com.mongodb.client.model.Filters.eq;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;

import org.bson.Document;
import org.bson.conversions.Bson;

public class testdb {
    static String uri = "mongodb+srv://god:ruimhxySin99ayPq@godcul.trkie.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";

    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("alirline_data");
            MongoCollection<Document> collection = database.getCollection("airline");
            Bson projectionFields = Projections.fields(
                    Projections.include("fight_number", "Airline", "depature_time", "travel_time"),
                    Projections.excludeId());
            MongoCursor<Document> cursor = collection.find(eq("Airline", "Jetblue"))
                    .projection(projectionFields)
                    .sort(Sorts.ascending("Airline")).iterator();
            try {
                while (cursor.hasNext()) {
                    System.out.println(cursor.next().toJson());
                }
            } finally {
                cursor.close();
            }
        }
    }
}
