package com.moso;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
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
                    Projections.include("fight_number", "Airline", "depature_time", "travel_time", "Price"),
                    Projections.excludeId());
            Bson filter = Filters.and(Filters.eq("Depature", "MAA"), Filters.eq("Destination", "IXM"));
            MongoCursor<Document> cursor = collection.find(filter)
                    .projection(projectionFields)
                    .sort(Sorts.ascending("Airline")).iterator();
            try {
                while (cursor.hasNext()) {
                    Object c = cursor.next().get("Price");
                    System.out.println();
                }
            } finally {
                cursor.close();
            }
        }
    }
}
