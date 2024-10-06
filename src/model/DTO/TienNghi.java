package model.DTO;

import java.util.Date;

public class TienNghi {
    private int maTienNghi;
    private String tenTienNghi;
    private String moTa;
    private int soLuong;
    private Date ngayLapDat;
    private Date ngayBaoTriGanNhat;

    public TienNghi() {
    }

    public TienNghi(int maTienNghi, String tenTienNghi, String moTa, int soLuong, Date ngayLapDat, Date ngayBaoTriGanNhat) {
        this.maTienNghi = maTienNghi;
        this.tenTienNghi = tenTienNghi;
        this.moTa = moTa;
        this.soLuong = soLuong;
        this.ngayLapDat = ngayLapDat;
        this.ngayBaoTriGanNhat = ngayBaoTriGanNhat;
    }

    public int getMaTienNghi() {
        return maTienNghi;
    }

    public void setMaTienNghi(int maTienNghi) {
        this.maTienNghi = maTienNghi;
    }

    public String getTenTienNghi() {
        return tenTienNghi;
    }

    public void setTenTienNghi(String tenTienNghi) {
        this.tenTienNghi = tenTienNghi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Date getNgayLapDat() {
        return ngayLapDat;
    }

    public void setNgayLapDat(Date ngayLapDat) {
        this.ngayLapDat = ngayLapDat;
    }

    public Date getNgayBaoTriGanNhat() {
        return ngayBaoTriGanNhat;
    }

    public void setNgayBaoTriGanNhat(Date ngayBaoTriGanNhat) {
        this.ngayBaoTriGanNhat = ngayBaoTriGanNhat;
    }
}
