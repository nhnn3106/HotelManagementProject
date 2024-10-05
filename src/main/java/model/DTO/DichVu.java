package model.DTO;

public class DichVu {
    private int maDV;
    private String tenDV;
    private String moTa;
    private double donGia;

    public DichVu() {
    }

    public DichVu(int maDV, String tenDV, String moTa, double donGia) {
        this.maDV = maDV;
        this.tenDV = tenDV;
        this.moTa = moTa;
        this.donGia = donGia;
    }

    public int getMaDV() {
        return maDV;
    }

    public void setMaDV(int maDV) {
        this.maDV = maDV;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
}
