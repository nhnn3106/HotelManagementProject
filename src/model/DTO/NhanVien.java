package model.DTO;

public class NhanVien {
    private int maNhanVien;
    private String tenNhanVien;
    private String anhDaiDien;
    private String soDienThoai;
    private String CCCD;
    private String diaChi;
    private int chucVu;
    private String tenTaiKhoan;
    private String matKhau;
    private int trangThai;

    public NhanVien() {
    }

    public NhanVien(int trangThai, String matKhau, String tenTaiKhoan, int chucVu, String diaChi, String CCCD, String soDienThoai, String anhDaiDien, String tenNhanVien, int maNhanVien) {
        this.trangThai = trangThai;
        this.matKhau = matKhau;
        this.tenTaiKhoan = tenTaiKhoan;
        this.chucVu = chucVu;
        this.diaChi = diaChi;
        this.CCCD = CCCD;
        this.soDienThoai = soDienThoai;
        this.anhDaiDien = anhDaiDien;
        this.tenNhanVien = tenNhanVien;
        this.maNhanVien = maNhanVien;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getAnhDaiDien() {
        return anhDaiDien;
    }

    public void setAnhDaiDien(String anhDaiDien) {
        this.anhDaiDien = anhDaiDien;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getChucVu() {
        return chucVu;
    }

    public void setChucVu(int chucVu) {
        this.chucVu = chucVu;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
