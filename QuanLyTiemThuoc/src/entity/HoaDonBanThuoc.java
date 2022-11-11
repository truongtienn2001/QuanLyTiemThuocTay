package entity;

import java.sql.Date;

public class HoaDonBanThuoc {
	private String maHoaDon;
	private KhachHang maKH;
	private KhachHang hoTenKH;
	private KhachHang ngaySinhKH;
	private KhachHang gioiTinhKH;
	private KhachHang diaChiKH;
	private NhanVien maNV;
	private NhanVien tenNV;
	private Thuoc maThuoc;
	private Thuoc tenThuoc;
	private Thuoc donViTinh;
	private int soLuong;
	private Date ngayLap;
	private double thanhTien;
	
	public HoaDonBanThuoc(double thanhTien) {
		super();
		this.thanhTien = thanhTien;
	}

	public HoaDonBanThuoc(Date ngayLap) {
		super();
		this.ngayLap = ngayLap;
	}

	public HoaDonBanThuoc(String maHoaDon, KhachHang hoTenKH, KhachHang ngaySinhKH, KhachHang gioiTinhKH,
			KhachHang diaChiKH, NhanVien tenNV, Thuoc tenThuoc, Thuoc donViTinh, int soLuong, Date ngayLap) {
		super();
		this.maHoaDon = maHoaDon;
		this.hoTenKH = hoTenKH;
		this.ngaySinhKH = ngaySinhKH;
		this.gioiTinhKH = gioiTinhKH;
		this.diaChiKH = diaChiKH;
		this.tenNV = tenNV;
		this.tenThuoc = tenThuoc;
		this.donViTinh = donViTinh;
		this.soLuong = soLuong;
		this.ngayLap = ngayLap;
	}

	public HoaDonBanThuoc(String maHoaDon, KhachHang maKH, KhachHang hoTenKH, KhachHang ngaySinhKH,
			KhachHang gioiTinhKH, KhachHang diaChiKH, NhanVien maNV, NhanVien tenNV, Thuoc maThuoc, Thuoc tenThuoc,
			Thuoc donViTinh, int soLuong, Date ngayLap, double thanhTien) {
		super();
		this.maHoaDon = maHoaDon;
		this.maKH = maKH;
		this.hoTenKH = hoTenKH;
		this.ngaySinhKH = ngaySinhKH;
		this.gioiTinhKH = gioiTinhKH;
		this.diaChiKH = diaChiKH;
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.maThuoc = maThuoc;
		this.tenThuoc = tenThuoc;
		this.donViTinh = donViTinh;
		this.soLuong = soLuong;
		this.ngayLap = ngayLap;
		this.thanhTien = thanhTien;
	}



	public double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}

	public KhachHang getMaKH() {
		return maKH;
	}

	public void setMaKH(KhachHang maKH) {
		this.maKH = maKH;
	}

	public NhanVien getMaNV() {
		return maNV;
	}

	public void setMaNV(NhanVien maNV) {
		this.maNV = maNV;
	}

	public Thuoc getMaThuoc() {
		return maThuoc;
	}

	public void setMaThuoc(Thuoc maThuoc) {
		this.maThuoc = maThuoc;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public KhachHang getHoTenKH() {
		return hoTenKH;
	}
	public void setHoTenKH(KhachHang hoTenKH) {
		this.hoTenKH = hoTenKH;
	}
	public KhachHang getNgaySinhKH() {
		return ngaySinhKH;
	}
	public void setNgaySinhKH(KhachHang ngaySinhKH) {
		this.ngaySinhKH = ngaySinhKH;
	}
	public KhachHang getGioiTinhKH() {
		return gioiTinhKH;
	}
	public void setGioiTinhKH(KhachHang gioiTinhKH) {
		this.gioiTinhKH = gioiTinhKH;
	}
	public KhachHang getDiaChiKH() {
		return diaChiKH;
	}
	public void setDiaChiKH(KhachHang diaChiKH) {
		this.diaChiKH = diaChiKH;
	}
	public NhanVien getTenNV() {
		return tenNV;
	}
	public void setTenNV(NhanVien tenNV) {
		this.tenNV = tenNV;
	}
	public Thuoc getTenThuoc() {
		return tenThuoc;
	}
	public void setTenThuoc(Thuoc tenThuoc) {
		this.tenThuoc = tenThuoc;
	}
	public Thuoc getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(Thuoc donViTinh) {
		this.donViTinh = donViTinh;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	@Override
	public String toString() {
		return "HoaDonBanThuoc [maHoaDon=" + maHoaDon + ", maKH=" + maKH + ", hoTenKH=" + hoTenKH + ", ngaySinhKH="
				+ ngaySinhKH + ", gioiTinhKH=" + gioiTinhKH + ", diaChiKH=" + diaChiKH + ", maNV=" + maNV + ", tenNV="
				+ tenNV + ", maThuoc=" + maThuoc + ", tenThuoc=" + tenThuoc + ", donViTinh=" + donViTinh + ", soLuong="
				+ soLuong + ", ngayLap=" + ngayLap + ", thanhTien=" + thanhTien + "]";
	}
	
}
