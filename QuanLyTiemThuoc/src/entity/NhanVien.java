package entity;

import java.sql.Date;

public class NhanVien {
	private String maNV;
	private String hoTenNV;
	private Date ngaySinhNV;
	private boolean gioiTinhNV;
	private String diaChiNV;
	private String SDTNV;
	private String CMND;
	
	public NhanVien(String maNV, String s) {
		super();
		this.maNV = maNV;
	}
	public NhanVien(String hoTenNV) {
		super();
		this.hoTenNV = hoTenNV;
	}
	public NhanVien(String maNV, String hoTenNV, Date ngaySinhNV, boolean gioiTinhNV, String diaChiNV, String sDTNV,
			String cMND) {
		super();
		this.maNV = maNV;
		this.hoTenNV = hoTenNV;
		this.ngaySinhNV = ngaySinhNV;
		this.gioiTinhNV = gioiTinhNV;
		this.diaChiNV = diaChiNV;
		SDTNV = sDTNV;
		CMND = cMND;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getHoTenNV() {
		return hoTenNV;
	}
	public void setHoTenNV(String hoTenNV) {
		this.hoTenNV = hoTenNV;
	}
	public Date getNgaySinhNV() {
		return ngaySinhNV;
	}
	public void setNgaySinhNV(Date ngaySinhNV) {
		this.ngaySinhNV = ngaySinhNV;
	}
	public boolean isGioiTinhNV() {
		return gioiTinhNV;
	}
	public void setGioiTinhNV(boolean gioiTinhNV) {
		this.gioiTinhNV = gioiTinhNV;
	}
	public String getDiaChiNV() {
		return diaChiNV;
	}
	public void setDiaChiNV(String diaChiNV) {
		this.diaChiNV = diaChiNV;
	}
	public String getSDTNV() {
		return SDTNV;
	}
	public void setSDTNV(String sDTNV) {
		SDTNV = sDTNV;
	}
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", hoTenNV=" + hoTenNV + ", ngaySinhNV=" + ngaySinhNV + ", gioiTinhNV="
				+ gioiTinhNV + ", diaChiNV=" + diaChiNV + ", SDTNV=" + SDTNV + ", CMND=" + CMND + "]";
	}
	
}
