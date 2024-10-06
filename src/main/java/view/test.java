package view;

import com.mongodb.client.MongoDatabase;
import model.DAO.PhongDAO;
import model.DTO.Phong;
import model.MongoDBConnection;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        MongoDBConnection connection = new MongoDBConnection();
        MongoDatabase database = connection.getDatabase();
        PhongDAO pDAO = new PhongDAO(database);
        ArrayList<Phong> pl = pDAO.getAllPhongs();
        for (Phong p : pl) {
            System.out.println(p);
        }


    }
}
