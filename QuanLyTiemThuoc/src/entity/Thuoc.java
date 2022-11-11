package entity;

import java.sql.Date;

public class Thuoc {
	private String maThuoc;
	private String tenThuoc;
	private String nhaCungCap;
	private double giaThuoc;
	private String congDung;
	private int soLuong;
	private String donViTinh;
	private Date ngaySanXuat;
	private Date ngayHetHan;
	
	
	public Thuoc(String tenThuoc, String nhaCungCap, int soLuong, String donViTinh, Date ngaySanXuat, Date ngayHetHan) {
		super();
		this.tenThuoc = tenThuoc;
		this.nhaCungCap = nhaCungCap;
		this.soLuong = soLuong;
		this.donViTinh = donViTinh;
		this.ngaySanXuat = ngaySanXuat;
		this.ngayHetHan = ngayHetHan;
	}
	public Thuoc(double giaThuoc) {
		super();
		this.giaThuoc = giaThuoc;
	}
	public Thuoc(String maThuoc, String s, String s2, String s3, String s4, String s5) {
		super();
		this.maThuoc = maThuoc;
	}
	public Thuoc(String donViTinh, String s, String s2, String s3, String s4) {
		super();
		this.donViTinh = donViTinh;
	}
	public Thuoc(String tenThuoc, String s, String s2, String s3) {
		super();
		this.tenThuoc = tenThuoc;
	}
	public Thuoc(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	public Thuoc() {
		super();
	}
	public Thuoc(String nhaCungCap, String string) {
		super();
		this.nhaCungCap = nhaCungCap;
	}
	
	public Thuoc(String congDung, String string, String string1) {
		super();
		this.congDung = congDung;
	}
	public Thuoc(String maThuoc, String tenThuoc, String nhaCungCap, double giaThuoc, String congDung, int soLuong,
			 String donViTinh, Date ngaySanXuat, Date ngayHetHan) {
		super();
		this.maThuoc = maThuoc;
		this.tenThuoc = tenThuoc;
		this.nhaCungCap = nhaCungCap;
		this.giaThuoc = giaThuoc;
		this.congDung = congDung;
		this.soLuong = soLuong;
		this.donViTinh = donViTinh;
		this.ngaySanXuat = ngaySanXuat;
		this.ngayHetHan = ngayHetHan;
	}
	public String getMaThuoc() {
		return maThuoc;
	}
	public void setMaThuoc(String maThuoc) {
		this.maThuoc = maThuoc;
	}
	public String getTenThuoc() {
		return tenThuoc;
	}
	public void setTenThuoc(String tenThuoc) {
		this.tenThuoc = tenThuoc;
	}
	public String getNhaCungCap() {
		return nhaCungCap;
	}
	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}
	public double getGiaThuoc() {
		return giaThuoc;
	}
	public void setGiaThuoc(double giaThuoc) {
		this.giaThuoc = giaThuoc;
	}
	public String getCongDung() {
		return congDung;
	}
	public void setCongDung(String congDung) {
		this.congDung = congDung;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	public Date getNgaySanXuat() {
		return ngaySanXuat;
	}
	public void setNgaySanXuat(Date ngaySanXuat) {
		this.ngaySanXuat = ngaySanXuat;
	}
	public Date getNgayHetHan() {
		return ngayHetHan;
	}
	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}
	@Override
	public String toString() {
		return "Thuoc [maThuoc=" + maThuoc + ", tenThuoc=" + tenThuoc + ", nhaCungCap=" + nhaCungCap + ", giaThuoc="
				+ giaThuoc + ", congDung=" + congDung + ", soLuongTon=" + soLuong + ", soLuongHetHan="
				+ ", donViTinh=" + donViTinh + ", ngaySanXuat=" + ngaySanXuat + ", ngayHetHan="
				+ ngayHetHan + "]";
	}
	
}
