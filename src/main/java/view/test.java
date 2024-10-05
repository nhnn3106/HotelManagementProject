package view;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import model.DAO.PhongDAO;
import model.DTO.Phong;
import model.DTO.PhongConverter;
import model.MongoDBConnection;
import org.bson.Document;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        MongoDBConnection connection = new MongoDBConnection();
//
//        MongoDatabase database = connection.getDatabase();
//        MongoCollection<Document> PhongColl = database.getCollection("Phong");
//
//        // Fetch a single document (for example)
//        Document doc = PhongColl.find().first();
//
//        // Convert the document to a Phong object
//        if (doc != null) {
//            Phong phong = PhongConverter.documentToPhong(doc);
//            System.out.println(phong);
//        }

        PhongDAO pDAO = new PhongDAO(connection);
        ArrayList<Phong> pl = pDAO.getAllPhongs();
        for (Phong p : pl) {
            System.out.println(p);
        }


    }
}
