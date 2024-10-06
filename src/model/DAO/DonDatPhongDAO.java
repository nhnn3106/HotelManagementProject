package model.DAO;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.time.LocalDate;
import model.DTO.DonDatPhong;
import org.bson.Document;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.ZoneId;
import org.bson.conversions.Bson;

public class DonDatPhongDAO {

    private MongoCollection<Document> donDatPhongCollection;

    public DonDatPhongDAO(MongoDatabase database) {
        donDatPhongCollection = database.getCollection("DonDatPhong");
    }

    public List<DonDatPhong> getAllDonDatPhong() {
        List<DonDatPhong> donDatPhongs = new ArrayList<>();
        try (MongoCursor<Document> cursor = donDatPhongCollection.find().iterator()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                DonDatPhong donDatPhong = DonDatPhong.fromDocument(doc);
                donDatPhongs.add(donDatPhong);
            }
        }
        return donDatPhongs;
    }

    public List<DonDatPhong> getDonDatPhongToDay() {
        List<DonDatPhong> result = new ArrayList<>();

        // Lấy ngày hôm nay
        LocalDate today = LocalDate.now();
        Date todayStart = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date todayEnd = Date.from(today.plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant());

        System.out.println(todayStart);
        System.out.println(todayEnd);

        // Tạo bộ lọc cho truy vấn
        Bson filter = Filters.and(
                Filters.eq("trangThai", 1), // trangThai = 1
                Filters.gte("ngayNhanPhong", todayStart), // ngayNhanPhong >= hôm nay
                Filters.lt("ngayNhanPhong", todayEnd) // ngayNhanPhong < ngày mai
        );

        // Thực hiện truy vấn
        for (Document doc : donDatPhongCollection.find(filter)) {
            DonDatPhong donDatPhong = DonDatPhong.fromDocument(doc);
            result.add(donDatPhong);
        }

        return result;
    }

    public boolean updateTraPhong(int maPhong) {
        // Cập nhật trangThai = 3 cho DonDatPhong với điều kiện trangThai = 2 và maPhong
        Bson filter = Filters.and(
                Filters.eq("Phong", maPhong),
                Filters.eq("trangThai", 2)
        );
        Bson update = new Document("$set", new Document("trangThai", 3));
        UpdateResult result = donDatPhongCollection.updateOne(filter, update);

        // Kiểm tra kết quả cập nhật
        return result.getMatchedCount() > 0 && result.getModifiedCount() > 0;
    }
    
    public List<Integer> getBookedRoomIds(Date start, Date end) {
        List<Integer> bookedRoomIds = new ArrayList<>();

        // Lọc các đơn đặt phòng có trạng thái 1 hoặc 2
        for (Document doc : donDatPhongCollection.find(Filters.or(
                Filters.eq("trangThai", 1),
                Filters.eq("trangThai", 2)
        ))) {
            Date ngayNhanPhong = doc.getDate("ngayNhanPhong");
            Date ngayTraPhong = doc.getDate("ngayTraPhong");

            // Kiểm tra xem ngày nhận và ngày trả có nằm trong khoảng không
            if (ngayNhanPhong.before(end) && ngayTraPhong.after(start)) {
                bookedRoomIds.add(doc.getInteger("Phong")); // Giả sử "Phong" là trường ID của phòng
            }
        }

        return bookedRoomIds;
    }
    
    public boolean createDonDatPhong(DonDatPhong donDatPhong) {
        try {
            Document doc = new Document()
                    .append("maDonDat", donDatPhong.getMaDonDat())
                    .append("ngayDatPhong", donDatPhong.getNgayDatPhong())
                    .append("ngayNhanPhong", donDatPhong.getNgayNhanPhong())
                    .append("ngayTraPhong", donDatPhong.getNgayTraPhong())
                    .append("trangThai", donDatPhong.getTrangThai())
                    .append("KhachO", donDatPhong.getKhachO())
                    .append("dichVuSuDung", donDatPhong.getDichVuSuDung())
                    .append("Phong", donDatPhong.getPhong())
                    .append("HoaDon", donDatPhong.getHoaDon());

            InsertOneResult result = donDatPhongCollection.insertOne(doc);
            return result.wasAcknowledged();
        } catch (Exception e) {
            System.out.println("Lỗi xảy ra trong quá trình tạo đơn đặt phòng: " + e.getMessage());
            return false;
        }
    }

}
