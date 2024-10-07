/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import com.mongodb.client.MongoDatabase;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
    import java.util.Date;
import java.util.List;
import model.DAO.DichVuDAO;
import model.DAO.DonDatPhongDAO;
import model.DAO.KhachHangDAO;
import model.DAO.KhuyenMaiDAO;
import model.DAO.LoaiPhongDAO;
import model.DAO.NhanVienDAO;
import model.DAO.PhongDAO;
import model.DAO.TienNghiDAO;
import model.MongoDBConnection;

import model.DAO.DichVuDAO;
import model.DAO.DonDatPhongDAO;
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

/**
 *
 * @author datba
 */
public class GODMOD {
    private MongoDBConnection connection = new MongoDBConnection();
    private MongoDatabase database = database = connection.getDatabase();
    private DichVuDAO dichVuDAO = new DichVuDAO(database);
    private DonDatPhongDAO donDatPhongDAO = new DonDatPhongDAO(database);
    private KhachHangDAO khachHangDAO = new KhachHangDAO(database);
    private KhuyenMaiDAO khuyenMaiDAO = new KhuyenMaiDAO(database);
    private LoaiPhongDAO loaiPhongDAO = new LoaiPhongDAO(database);
    private NhanVienDAO nhanVienDAO = new NhanVienDAO(database);
    private PhongDAO phongDAO = new PhongDAO(database);
    private TienNghiDAO tienNghiDAO = new TienNghiDAO(database);
    
    
    
    public static void main(String[] args) {
        GODMOD god = new GODMOD();
//        god.createDichVu("Xong hoi", "Sang khoaii", 100000);
        god.createDonDatPhong();
        
        
        
    }
    
    public void getDonDatPhongNgayHomNay(){
        List<DonDatPhong> toDay = donDatPhongDAO.getDonDatPhongToDay();
        for (DonDatPhong donDatPhong : toDay) {
            System.out.println(donDatPhong);
        }
    }
    
    
    public void traPhongByMaPhong(){
//cập nhập trạng thái đơn hàng về 3 - Đã tả phòng
//Cập nhập trạng thái phòng về 2: không có ai ở
//Cập nhập ngày tạo hóa đơn của HoaDon thành ngày hôm nay
        int maPhong = 101;
        if (donDatPhongDAO.updateTraPhong(maPhong) && phongDAO.updateTraPhong(maPhong)){
            System.out.println("Tra Phong Thanh Cong");
        }
        else{
            System.out.println("Tra Phong That Bai");
        }
    }
    
    public void datPhong(){
        
        DonDatPhong donMoi = new DonDatPhong();
        KhachHang khachO = new KhachHang();
        HoaDon hd = new HoaDon();
        List<KhachHang> list = new ArrayList<>();
        
        // Kiểm tra khách hàng đã tồn tại hay chưa.
        String cccd = "0912345678";
        String sdt = "";
        khachO = khachHangDAO.isKhachHangCu(sdt, cccd);
        if (khachO != null){
            
        }
        else{
            // create 1 document trong collection KhachHang
            khachO = new KhachHang(3, "Nguyen Thi B", sdt, cccd, "Viet Nam");
            list.add(khachO);
            donMoi.setKhachO(list);
        }
        // Tạo hóa đơn mới
        hd = new HoaDon(4, 0, null, null);
        
        // Tạo đơn đặt mới
        LocalDate today = LocalDate.now();
        Date todayStart = Date.from(today.plusDays(2).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date todayEnd = Date.from(today.plusDays(4).atStartOfDay(ZoneId.systemDefault()).toInstant());
        donMoi.setHoaDon(4);
        donMoi.setNgayNhanPhong(todayStart);
        donMoi.setNgayTraPhong(todayEnd);
        donMoi.setNgayDatPhong(Date.from(today.plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        donMoi.setMaDonDat(4);
        donMoi.setTrangThai(1);
        donMoi.setDichVuSuDung(null);
    }
    
    public void createDichVu(String tenDV, String moTa, int donGia){
        DichVu dichVu = new DichVu();
        dichVu.setMaDV(dichVuDAO.getLastIdDocument() + 1);
        dichVu.setTenDV(tenDV);
        dichVu.setMoTa(moTa);
        dichVu.setDonGia(donGia);
        System.out.println(dichVu);
        if (dichVuDAO.createDichVu(dichVu)){
            System.out.println("them dich vu thanh cong");
            System.out.println(dichVu);
        }
        else
        {
           System.out.println("them dich vu that bai"); 
        }
    }
    
    public void createDonDatPhong(){
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        Date yesterday = calendar.getTime();

        // Ngày hôm sau
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime(); 
        
        
        
        DonDatPhong donDatPhong = new DonDatPhong();
        donDatPhong.setMaDonDat(donDatPhongDAO.getLastIdDocument() + 1);
        donDatPhong.setNgayDatPhong(yesterday);
        donDatPhong.setNgayNhanPhong(today);
        donDatPhong.setNgayTraPhong(tomorrow);
        donDatPhong.setTrangThai(1);
        donDatPhong.setKhachO(new ArrayList<KhachHang>());
        donDatPhong.setDichVuSuDung(new ArrayList<DichVu>());
        
        if (donDatPhongDAO.createDonDatPhong(donDatPhong)){
            System.out.println("them don dat phong thanh cong");
            System.out.println(donDatPhong);
        }
        else
        {
           System.out.println("them don dat phong that bai");
        }
    }  
}
