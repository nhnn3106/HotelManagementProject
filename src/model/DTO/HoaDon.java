package model.DTO;

import java.util.Date;

public class HoaDon {
    private int maHoaDon;
    private double tongTien;
    private Date ngayTaoHoaDon;
    private NhanVien nhanVien;

    public HoaDon() {
    }

    public HoaDon(int maHoaDon, double tongTien, Date ngayTaoHoaDon, NhanVien nhanVien) {
        this.maHoaDon = maHoaDon;
        this.tongTien = tongTien;
        this.ngayTaoHoaDon = ngayTaoHoaDon;
        this.nhanVien = nhanVien;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayTaoHoaDon() {
        return ngayTaoHoaDon;
    }

    public void setNgayTaoHoaDon(Date ngayTaoHoaDon) {
        this.ngayTaoHoaDon = ngayTaoHoaDon;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }
}
