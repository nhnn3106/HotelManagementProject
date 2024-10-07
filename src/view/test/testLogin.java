/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.test;

import com.mongodb.client.MongoDatabase;
import model.DAO.NhanVienDAO;
import model.MongoDBConnection;

/**
 *
 * @author datba
 */
public class testLogin {
    
    public static void main(String[] args) {
         MongoDBConnection connection = new MongoDBConnection();
        MongoDatabase database = connection.getDatabase();
        NhanVienDAO nhanVienDAO = new NhanVienDAO(database);
        System.out.println(nhanVienDAO.checkAccount("nva", "password123"));
    }
    
}
