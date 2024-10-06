package model.DAO;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import model.DTO.Phong;
import model.MongoDBConnection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.conversions.Bson;

public class PhongDAO {

    private MongoCollection<Document> phongCollection;
    private DonDatPhongDAO donDatPhongDAO;
    public PhongDAO(MongoDatabase database) {
        phongCollection = database.getCollection("Phong");
        donDatPhongDAO = new DonDatPhongDAO(database);
    }

    public boolean createPhong(Phong phong) {
        try {
            Document doc = new Document()
                    .append("maPhong", phong.getMaPhong())
                    .append("trangThai", phong.getTrangThai())
                    .append("soPhong", phong.getSoPhong())
                    .append("tang", phong.getTang())
                    .append("loaiPhong", phong.getLoaiPhong());

            InsertOneResult result = phongCollection.insertOne(doc);
            return result.wasAcknowledged();
        } catch (Exception e) {
            System.out.println("Lỗi xảy ra trong quá trình tạo phòng: " + e.getMessage());
            return false;
        }
    }

    public Document getPhongByMaPhong(int maPhong) {
        return phongCollection.find(new Document("maPhong", maPhong)).first();
    }

    public ArrayList<Phong> getAllPhongs() {
        ArrayList<Phong> phongs = new ArrayList<>();
        try (MongoCursor<Document> cursor = phongCollection.find().iterator()) {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                Phong phong = Phong.fromDocument(document);
                phongs.add(phong);
            }
        }
        return phongs;
    }

    public void updatePhong(int maPhong, int trangThai) {
        phongCollection.updateOne(new Document("maPhong", maPhong),
                new Document("$set", new Document("trangThai", trangThai)));
        System.out.println("Updated Phong successfully");
    }

    public void deletePhong(int maPhong) {
        phongCollection.deleteOne(new Document("maPhong", maPhong));
        System.out.println("Deleted Phong successfully");
    }
    
    public boolean updateTraPhong(int maPhong) {
        // Cập nhật trangThai = 3 cho Phong với điều kiện maPhong
        Bson filter = Filters.eq("maPhong", maPhong);
        Bson update = new Document("$set", new Document("trangThai", 3));
        UpdateResult result = phongCollection.updateOne(filter, update);

        // Kiểm tra kết quả cập nhật
        return result.getMatchedCount() > 0 && result.getModifiedCount() > 0;
    }
    
    public List<Phong> getPhongCoSan(Date start, Date end) {
        List<Phong> availableRooms = new ArrayList<>();
        
        // Lấy danh sách phòng
        List<Phong> allRooms = getAllPhongs();
        
        // Lấy danh sách phòng đã bị đặt trong khoảng thời gian
        List<Integer> bookedRoomIds = donDatPhongDAO.getBookedRoomIds(start, end);
        
        // Kiểm tra các phòng còn lại
        for (Phong room : allRooms) {
            if (!bookedRoomIds.contains(room.getMaPhong())) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }
}

