package model.DTO;

import java.util.List;

public class LoaiPhong {
    private int maLoaiPhong;
    private String tenLoaiPhong;
    private double dienTich;
    private double donGia;
    private String moTa;
    private int soKhachToiDa;
    private int khuyenMai;
    private List<TienNghi> tienNghis;

    public LoaiPhong() {
    }

    public LoaiPhong(int maLoaiPhong, String tenLoaiPhong, double dienTich, double donGia, String moTa, int soKhachToiDa, int khuyenMai, List<TienNghi> tienNghis) {
        this.maLoaiPhong = maLoaiPhong;
        this.tenLoaiPhong = tenLoaiPhong;
        this.dienTich = dienTich;
        this.donGia = donGia;
        this.moTa = moTa;
        this.soKhachToiDa = soKhachToiDa;
        this.khuyenMai = khuyenMai;
        this.tienNghis = tienNghis;
    }

    public int getMaLoaiPhong() {
        return maLoaiPhong;
    }

    public void setMaLoaiPhong(int maLoaiPhong) {
        this.maLoaiPhong = maLoaiPhong;
    }

    public String getTenLoaiPhong() {
        return tenLoaiPhong;
    }

    public void setTenLoaiPhong(String tenLoaiPhong) {
        this.tenLoaiPhong = tenLoaiPhong;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoKhachToiDa() {
        return soKhachToiDa;
    }

    public void setSoKhachToiDa(int soKhachToiDa) {
        this.soKhachToiDa = soKhachToiDa;
    }

    public int getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(int khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public List<TienNghi> getTienNghis() {
        return tienNghis;
    }

    public void setTienNghis(List<TienNghi> tienNghis) {
        this.tienNghis = tienNghis;
    }
}
