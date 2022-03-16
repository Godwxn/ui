package com.moso;

import static com.mongodb.client.model.Filters.eq;

import com.mongodb.MongoException;
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
import org.bson.types.ObjectId;

public class db {

    static String uri = "mongodb+srv://god:ruimhxySin99ayPq@godcul.trkie.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";

    public boolean Login(String email, String password) {
        MongoClient mongoClient = MongoClients.create(uri);
        MongoDatabase database = mongoClient.getDatabase("sample_mflix");
        MongoCollection<Document> collection = database.getCollection("users");
        Document user = collection.find(eq("email", email)).first();
        if (user != null) {
            if (user.getString("password").equals(password)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public String[] find(String Title) {
        String[] result = new String[2];
        MongoClient mongoClient = MongoClients.create(uri);
        MongoDatabase database = mongoClient.getDatabase("sample_mflix");
        MongoCollection<Document> collection = database.getCollection("movies");
        Document movie = collection.find(eq("title", Title)).first();
        result[0] = movie.getString("title");
        result[1] = movie.getString("plot");
        return result;

    }

    public void prescribe(String name, String id, String condition, String days) {
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("patient_record");
            MongoCollection<Document> collection = database.getCollection("patient");
            try {
                collection.insertOne(new Document()
                        .append("_id", new ObjectId())
                        .append("Name", name)
                        .append("id", id)
                        .append("condition", condition)
                        .append("days", days));
                mongoClient.close();
            } catch (MongoException me) {
                System.err.println(me);
            }

        } catch (MongoException me) {
            System.out.println(me.getMessage());
        }

    }

    public String findMed(String name, String id) {
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("patient_record");
            MongoCollection<Document> collection = database.getCollection("patient");
            try {
                Document patient = collection.find(eq("id", id)).first();
                return patient.getString("prescribe");
            } catch (MongoException me) {
                System.err.println(me.getMessage());
            }
        } catch (MongoException me) {
            System.err.println(me.getMessage());
        }
        return id;
    }

    public MongoCursor<Document> findAir(String depat, String dest) {
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("alirline_data");
            MongoCollection<Document> collection = database.getCollection("airline");
            Bson projectionFields = Projections.fields(
                    Projections.include("fight_number", "Airline", "depature_time", "travel_time"),
                    Projections.excludeId());
            Bson filter = Filters.and(Filters.eq("Depature", depat), Filters.eq("Destination", dest));
            MongoCursor<Document> cursor = collection.find(filter)
                    .projection(projectionFields)
                    .sort(Sorts.ascending("Airline")).iterator();
            return cursor;
        }
    }

    public boolean update(String Title, String genres) {
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("sample_mflix");
            MongoCollection<Document> collection = database.getCollection("movies");
            try {
                collection.insertOne(new Document()
                        .append("_id", new ObjectId())
                        .append("title", Title)
                        .append("genres", genres));
                return true;
            } catch (MongoException me) {
                return false;
            }
        }
    }
}
