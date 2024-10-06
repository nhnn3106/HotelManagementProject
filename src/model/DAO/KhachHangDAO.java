package model.DAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import model.MongoDBConnection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class KhachHangDAO {

    private MongoCollection<Document> khachHangCollection;

    public KhachHangDAO(MongoDBConnection connection) {
        MongoDatabase database = connection.getDatabase();
        khachHangCollection = database.getCollection("KhachHang");
    }

    public void addKhachHang(int maKhachHang, String tenKhachHang, String soDienThoai, int diemTichLuy, String email) {
        Document khachHang = new Document("maKhachHang", maKhachHang)
                .append("tenKhachHang", tenKhachHang)
                .append("soDienThoai", soDienThoai)
                .append("DiemTichLuy", diemTichLuy)
                .append("email", email);

        khachHangCollection.insertOne(khachHang);
        System.out.println("Added KhachHang successfully");
    }

    public Document getKhachHangByMaKhachHang(int maKhachHang) {
        return khachHangCollection.find(new Document("maKhachHang", maKhachHang)).first();
    }

    public List<Document> getAllKhachHangs() {
        List<Document> khachHangs = new ArrayList<>();
        try (MongoCursor<Document> cursor = khachHangCollection.find().iterator()) {
            while (cursor.hasNext()) {
                khachHangs.add(cursor.next());
            }
        }
        return khachHangs;
    }

    public void updateKhachHang(int maKhachHang, String tenKhachHang) {
        khachHangCollection.updateOne(new Document("maKhachHang", maKhachHang),
                new Document("$set", new Document("tenKhachHang", tenKhachHang)));
        System.out.println("Updated KhachHang successfully");
    }

    public void deleteKhachHang(int maKhachHang) {
        khachHangCollection.deleteOne(new Document("maKhachHang", maKhachHang));
        System.out.println("Deleted KhachHang successfully");
    }
}
