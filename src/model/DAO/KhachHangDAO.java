package model.DAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import model.DTO.KhachHang;
import model.MongoDBConnection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class KhachHangDAO {

    private MongoCollection<Document> khachHangCollection;

    public KhachHangDAO(MongoDatabase database) {
        khachHangCollection = database.getCollection("KhachHang");
    }

    public List<KhachHang> getAllKhachHang() {
        List<KhachHang> khachHangs = new ArrayList<>();
        try (MongoCursor<Document> cursor = khachHangCollection.find().iterator()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                KhachHang khachHang = KhachHang.fromDocument(doc);
                khachHangs.add(khachHang);
            }
        }
        return khachHangs;
    }

    public boolean createKhachHang(KhachHang khachHang) {
        try {
            Document doc = new Document()
                    .append("maKhachHang", khachHang.getMaKhachHang())
                    .append("tenKhachHang", khachHang.getTenKhachHang())
                    .append("soDienThoai", khachHang.getSoDienThoai())
                    .append("CCCD", khachHang.getCCCD());

            InsertOneResult result = khachHangCollection.insertOne(doc);
            return result.wasAcknowledged(); // Kiểm tra xem insert có được xác nhận không
        } catch (Exception e) {
            System.out.println("Lỗi xảy ra trong quá trình tạo khách hàng: " + e.getMessage());
            return false; // Trả về false nếu có lỗi
        }
    }
    
//    public boolean createKhachHang(KhachHang khachHang) {
//        try {
//            Document doc = new Document()
//                    .append("maKhachHang", khachHang.getMaKhachHang())
//                    .append("tenKhachHang", khachHang.getTenKhachHang())
//                    .append("soDienThoai", khachHang.getSoDienThoai())
//                    .append("CCCD", khachHang.getCCCD())
//                    .append("quocTich", khachHang.getQuocTich())
//                    .append("diaChi", khachHang.getDiaChi())
//                    .append("gioiTinh", khachHang.getGioiTinh());
//
//            InsertOneResult result = khachHangCollection.insertOne(doc);
//            return result.wasAcknowledged();
//        } catch (Exception e) {
//            System.out.println("Lỗi xảy ra trong quá trình tạo khách hàng: " + e.getMessage());
//            return false;
//        }
//    }

    public Document getKhachHangByMaKhachHang(int maKhachHang) {
        return khachHangCollection.find(new Document("maKhachHang", maKhachHang)).first();
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
    public KhachHang isKhachHangCu(String sdt, String cccd) {
        // Tạo bộ lọc để kiểm tra xem có khách hàng nào có số điện thoại hoặc CCCD trùng không
        Document doc = khachHangCollection.find(
                Filters.or(
                        Filters.eq("soDienThoai", sdt),
                        Filters.eq("CCCD", cccd)
                )
        ).first();

        // Nếu tìm thấy tài liệu, chuyển đổi nó thành đối tượng KhachHang
        if (doc != null) {
            return KhachHang.fromDocument(doc);
        }
        
        // Nếu không tìm thấy, trả về null
        return null;
    }
}
