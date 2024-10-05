package model.DTO;

import org.bson.Document;

public class PhongConverter {

    // Method to convert Document to Phong
    public static Phong documentToPhong(Document doc) {
        Phong phong = new Phong();

        if (doc.containsKey("maPhong")) {
            phong.setMaPhong(doc.getInteger("maPhong"));
        }

        if (doc.containsKey("trangThai")) {
            phong.setTrangThai(doc.getInteger("trangThai"));
        }

        if (doc.containsKey("soPhong")) {
            phong.setSoPhong(doc.getString("soPhong"));
        }

        if (doc.containsKey("tang")) {
            phong.setTang(doc.getInteger("tang"));
        }

        if (doc.containsKey("loaiPhong")) {
            phong.setLoaiPhong(doc.getInteger("loaiPhong"));
        }

        return phong;
    }
}
