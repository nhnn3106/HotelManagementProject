package model.DAO;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import model.MongoDBConnection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO {

    private MongoCollection<Document> nhanVienCollection;

    public NhanVienDAO(MongoDBConnection connection) {
        MongoDatabase database = connection.getDatabase();
        nhanVienCollection = database.getCollection("NhanVien");
    }

    public void addNhanVien(int maNhanVien, String tenNhanVien, String anhDaiDien, String soDienThoai, String cccd, String diaChi, int chucVu, int maTaiKhoan, String tenTaiKhoan, String matKhau) {
        Document nhanVien = new Document("maNhanVien", maNhanVien)
                .append("tenNhanVien", tenNhanVien)
                .append("anhDaiDien", anhDaiDien)
                .append("SoDienThoai", soDienThoai)
                .append("CCCD", cccd)
                .append("diaChi", diaChi)
                .append("chucVu", chucVu)
                .append("maTaiKHoan", maTaiKhoan)
                .append("tenTaiKhoan", tenTaiKhoan)
                .append("matKhau", matKhau);

        nhanVienCollection.insertOne(nhanVien);
        System.out.println("Added NhanVien successfully");
    }

    public Document getNhanVienByMaNhanVien(int maNhanVien) {
        return nhanVienCollection.find(new Document("maNhanVien", maNhanVien)).first();
    }

    public List<Document> getAllNhanViens() {
        List<Document> nhanViens = new ArrayList<>();
        try (MongoCursor<Document> cursor = nhanVienCollection.find().iterator()) {
            while (cursor.hasNext()) {
                nhanViens.add(cursor.next());
            }
        }
        return nhanViens;
    }

    public void updateNhanVien(int maNhanVien, String tenNhanVien) {
        nhanVienCollection.updateOne(new Document("maNhanVien", maNhanVien),
                new Document("$set", new Document("tenNhanVien", tenNhanVien)));
        System.out.println("Updated NhanVien successfully");
    }

    public void deleteNhanVien(int maNhanVien) {
        nhanVienCollection.deleteOne(new Document("maNhanVien", maNhanVien));
        System.out.println("Deleted NhanVien successfully");
    }
}
