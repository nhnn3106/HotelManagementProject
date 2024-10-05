package model.DTO;

import java.util.Date;
import java.util.List;

public class DonDatPhong {
    private int maDonDat;
    private Date ngayDatPhong;
    private Date ngayNhanPhong;
    private Date ngayTraPhong;
    private int trangThai;
    private List<KhachHang> khachO;
    private List<DichVu> dichVuSuDung;
    private int phong;
    private int hoaDon;

    public DonDatPhong(int maDonDat, Date ngayDatPhong, Date ngayNhanPhong, Date ngayTraPhong, int trangThai, List<KhachHang> khachO, List<DichVu> dichVuSuDung, int phong, int hoaDon) {
        this.maDonDat = maDonDat;
        this.ngayDatPhong = ngayDatPhong;
        this.ngayNhanPhong = ngayNhanPhong;
        this.ngayTraPhong = ngayTraPhong;
        this.trangThai = trangThai;
        this.khachO = khachO;
        this.dichVuSuDung = dichVuSuDung;
        this.phong = phong;
        this.hoaDon = hoaDon;
    }

    public DonDatPhong() {
    }

    public int getMaDonDat() {
        return maDonDat;
    }

    public void setMaDonDat(int maDonDat) {
        this.maDonDat = maDonDat;
    }

    public Date getNgayDatPhong() {
        return ngayDatPhong;
    }

    public void setNgayDatPhong(Date ngayDatPhong) {
        this.ngayDatPhong = ngayDatPhong;
    }

    public Date getNgayNhanPhong() {
        return ngayNhanPhong;
    }

    public void setNgayNhanPhong(Date ngayNhanPhong) {
        this.ngayNhanPhong = ngayNhanPhong;
    }

    public Date getNgayTraPhong() {
        return ngayTraPhong;
    }

    public void setNgayTraPhong(Date ngayTraPhong) {
        this.ngayTraPhong = ngayTraPhong;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public List<KhachHang> getKhachO() {
        return khachO;
    }

    public void setKhachO(List<KhachHang> khachO) {
        this.khachO = khachO;
    }

    public List<DichVu> getDichVuSuDung() {
        return dichVuSuDung;
    }

    public void setDichVuSuDung(List<DichVu> dichVuSuDung) {
        this.dichVuSuDung = dichVuSuDung;
    }

    public int getPhong() {
        return phong;
    }

    public void setPhong(int phong) {
        this.phong = phong;
    }

    public int getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(int hoaDon) {
        this.hoaDon = hoaDon;
    }
}
