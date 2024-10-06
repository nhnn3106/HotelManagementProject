/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Date;
import model.DAO.DichVuDAO;
import model.DAO.DonDatPhongDAO;
import model.DAO.HoaDonDAO;
import model.DAO.KhachHangDAO;
import model.DAO.KhuyenMaiDAO;
import model.DAO.LoaiPhongDAO;
import model.DAO.NhanVienDAO;
import model.DAO.PhongDAO;
import model.DAO.TienNghiDAO;
import model.DTO.DichVu;
import model.DTO.DonDatPhong;
import model.DTO.HoaDon;
import model.DTO.KhachHang;
import model.DTO.KhuyenMai;
import model.DTO.LoaiPhong;
import model.DTO.NhanVien;
import model.DTO.Phong;
import model.DTO.TienNghi;
import model.MongoDBConnection;

/**
 *
 * @author datba
 */
public class testCreate {
    public static void main(String[] args) {
        MongoDBConnection connection = new MongoDBConnection();
        MongoDatabase database = connection.getDatabase();
        
        NhanVienDAO nhanVienDAO = new NhanVienDAO(database);
        KhachHangDAO khachHangDAO = new KhachHangDAO(database);
        PhongDAO phongDAO = new PhongDAO(database);
        LoaiPhongDAO loaiPhongDAO = new LoaiPhongDAO(database);
        TienNghiDAO tienNghiDAO = new TienNghiDAO(database);
        KhuyenMaiDAO khuyenMaiDAO = new KhuyenMaiDAO(database);
        DonDatPhongDAO donDatPhongDAO = new DonDatPhongDAO(database);
        HoaDonDAO hoaDonDAO = new HoaDonDAO(database);
        DichVuDAO dichVuDAO = new DichVuDAO(database);

        // Test NhanVien creation
        NhanVien nhanVien = new NhanVien(6, "Nguyen Van A", null, "0123456789", "123456789", "Ha Noi", 1, "user", "pass", 1);
        boolean isNhanVienCreated = nhanVienDAO.createNhanVien(nhanVien);
        System.out.println("NhanVien created: " + isNhanVienCreated);

        // Test KhachHang creation
        KhachHang khachHang = new KhachHang(6, "Tran Thi B", "0987654321", "987654321", "Viet Nam");
        boolean isKhachHangCreated = khachHangDAO.createKhachHang(khachHang);
        System.out.println("KhachHang created: " + isKhachHangCreated);

        // Test Phong creation
        Phong phong = new Phong(6, 1, "104", 1, 1);
        boolean isPhongCreated = phongDAO.createPhong(phong);
        System.out.println("Phong created: " + isPhongCreated);

        // Test LoaiPhong creation
        LoaiPhong loaiPhong = new LoaiPhong(6, "Deluxe", 50, 1000000, "Phong sang trong", 2, 0, null);
        boolean isLoaiPhongCreated = loaiPhongDAO.createLoaiPhong(loaiPhong);
        System.out.println("LoaiPhong created: " + isLoaiPhongCreated);

//        // Test TienNghi creation
//        TienNghi tienNghi = new TienNghi(1, "Wifi", "Kết nối internet miễn phí", null,null);
//        boolean isTienNghiCreated = tienNghiDAO.createTienNghi(tienNghi);
//        System.out.println("TienNghi created: " + isTienNghiCreated);
//
//        // Test KhuyenMai creation
//        KhuyenMai khuyenMai = new KhuyenMai(1, new Date(), new Date(System.currentTimeMillis() + 86400000), 20, "Giảm giá 20%");
//        boolean isKhuyenMaiCreated = khuyenMaiDAO.createKhuyenMai(khuyenMai);
//        System.out.println("KhuyenMai created: " + isKhuyenMaiCreated);

        // Test DonDatPhong creation
        DonDatPhong donDatPhong = new DonDatPhong(1, new Date(), new Date(), new Date(), 1, new ArrayList<>(), new ArrayList<>(), 1, 1);
        boolean isDonDatPhongCreated = donDatPhongDAO.createDonDatPhong(donDatPhong);
        System.out.println("DonDatPhong created: " + isDonDatPhongCreated);

        // Test HoaDon creation
        HoaDon hoaDon = new HoaDon(6, 1000000, new Date(), new NhanVien(1, "Nguyen Van A", null, "0123456789", "123456789", "Ha Noi", 1, "user", "pass", 1));
        boolean isHoaDonCreated = hoaDonDAO.createHoaDon(hoaDon);
        System.out.println("HoaDon created: " + isHoaDonCreated);

        // Test DichVu creation
        DichVu dichVu = new DichVu(6, "Room Service", "Dịch vụ phòng", 200000);
        boolean isDichVuCreated = dichVuDAO.createDichVu(dichVu);
        System.out.println("DichVu created: " + isDichVuCreated);
        
    }
}
