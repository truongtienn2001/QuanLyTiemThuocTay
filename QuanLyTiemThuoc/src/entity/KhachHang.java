package entity;

import java.sql.Date;

public class KhachHang {
	private String maKH;
	private String hoTenKH;
	private Date ngaySinhKH;
	private boolean gioiTinhKH;
	private String diaChi;
	
	public KhachHang() {
		super();
	}
	
	public KhachHang(Date ngaySinhKH) {
		super();
		this.ngaySinhKH = ngaySinhKH;
	}

	public KhachHang(String diaChi, String s) {
		super();
		this.diaChi = diaChi;
	}

	public KhachHang(boolean gioiTinhKH) {
		super();
		this.gioiTinhKH = gioiTinhKH;
	}

	public KhachHang(String hoTenKH) {
		super();
		this.hoTenKH = hoTenKH;
	}
	
	public KhachHang(String maKH, String s, String s1) {
		super();
		this.maKH = maKH;
	}

	public KhachHang(String maKH, String hoTenKH, Date ngaySinhKH, boolean gioiTinhKH, String diaChi) {
		super();
		this.maKH = maKH;
		this.hoTenKH = hoTenKH;
		this.ngaySinhKH = ngaySinhKH;
		this.gioiTinhKH = gioiTinhKH;
		this.diaChi = diaChi;
	}

	public KhachHang(String hoTenKH, Date ngaySinhKH, String diaChi) {
		super();
		this.hoTenKH = hoTenKH;
		this.ngaySinhKH = ngaySinhKH;
		this.diaChi = diaChi;
	}

	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getHoTenKH() {
		return hoTenKH;
	}
	public void setHoTenKH(String hoTenKH) {
		this.hoTenKH = hoTenKH;
	}
	public Date getNgaySinhKH() {
		return ngaySinhKH;
	}
	public void setNgaySinhKH(Date ngaySinhKH) {
		this.ngaySinhKH = ngaySinhKH;
	}
	public boolean isGioiTinh() {
		return gioiTinhKH;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinhKH = gioiTinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", hoTenKH=" + hoTenKH + ", ngaySinhKH=" + ngaySinhKH + ", gioiTinh="
				+ gioiTinhKH + ", diaChi=" + diaChi + "]";
	}
}
