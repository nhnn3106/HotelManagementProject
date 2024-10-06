package model.DTO;

import java.util.Date;

public class KhuyenMai {
    private int maKhuyenMai;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private int tiLeKhuyenMai;
    private String moTa;

    public int getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(int maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getTiLeKhuyenMai() {
        return tiLeKhuyenMai;
    }

    public void setTiLeKhuyenMai(int tiLeKhuyenMai) {
        this.tiLeKhuyenMai = tiLeKhuyenMai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
