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
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;

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

    public void addPatients(String name, String id, String medicalhis, String phone_no, String age, String BloodGrp) {
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("patient_record");
            MongoCollection<Document> collection = database.getCollection("patient");
            try {
                collection.insertOne(new Document()
                        .append("_id", new ObjectId())
                        .append("name", name)
                        .append("id", id)
                        .append("medical_histroy", medicalhis)
                        .append("phone_no", phone_no)
                        .append("age", age)
                        .append("blood_grp", BloodGrp)
                        .append("password", phone_no));
                mongoClient.close();
            } catch (MongoException me) {
                System.err.println(me);
            }

        } catch (MongoException me) {
            System.out.println(me.getMessage());
        }

    }

    public void MakeAppointment(String id, String symptoms) {
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("patient_record");
            MongoCollection<Document> collection = database.getCollection("patient");
            Bson query = eq("id", id);
            Bson updates = Updates.combine(Updates.set("symptoms", symptoms));
            UpdateOptions options = new UpdateOptions().upsert(true);
            try {
                UpdateResult result = collection.updateOne(query, updates, options);
                System.out.println("Modified document count: " + result.getModifiedCount());
                System.out.println("Upserted id: " + result.getUpsertedId());
            } catch (MongoException me) {
                System.err.println("Unable to update due to an error: " + me);
            }
        } finally {
        }

    }

    public Document getPatient(String id) {
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("patient_record");
            Bson projectionFields = Projections.fields(
                    Projections.include("name", "id", "symptoms", "medical_histroy"),
                    Projections.excludeId());
            MongoCollection<Document> collection = database.getCollection("patient");
            try {
                Document patient = collection.find(eq("id", id)).projection(projectionFields).first();
                System.err.println(patient);
                return patient;
            } catch (MongoException me) {
                System.err.println(me.getMessage());
            }
        } catch (MongoException me) {
            System.err.println(me.getMessage());
        }
        return null;
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

    public Boolean book(airline Airline, String noOfPassangers, int price) {
        MongoClient mongoClient = MongoClients.create(uri);
        MongoDatabase database = mongoClient.getDatabase("alirline_data");
        MongoCollection<Document> collection = database.getCollection("booking");
        try {
            collection.insertOne(new Document()
                    .append("_id", new ObjectId())
                    .append("Airline", Airline.getAirline())
                    .append("Flight_no", Airline.getFight_number())
                    .append("Dep_time", Airline.getDepature_time())
                    .append("No_of_Passanger", noOfPassangers)
                    .append("Total_Price", price));
            mongoClient.close();
            return true;
        } catch (MongoException me) {
            System.err.println(me);
            return false;
        }
    }

    public MongoCursor<Document> findAir(String depat, String dest) {
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("alirline_data");
            MongoCollection<Document> collection = database.getCollection("airline");
            Bson projectionFields = Projections.fields(
                    Projections.include("fight_number", "Airline", "depature_time", "travel_time", "Price"),
                    Projections.excludeId());
            Bson filter = Filters.and(Filters.eq("Depature", depat), Filters.eq("Destination", dest));
            MongoCursor<Document> cursor = collection.find(filter)
                    .projection(projectionFields)
                    .sort(Sorts.ascending("Airline")).iterator();
            return cursor;
        }
    }
}