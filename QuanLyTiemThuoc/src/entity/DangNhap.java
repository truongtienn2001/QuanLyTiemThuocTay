package entity;

public class DangNhap {
	private String taikhoan = "3T";
	private String matKhau = "123456789";
	
	
	public DangNhap(String taikhoan, String matKhau) {
		super();
		this.taikhoan = taikhoan;
		this.matKhau = matKhau;
	}
	
	public DangNhap() {
		super();
	}


	public String getTaikhoan() {
		return taikhoan;
	}
	public void setTaikhoan(String taikhoan) {
		this.taikhoan = taikhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}


	@Override
	public String toString() {
		return "DangNhap [taikhoan=" + taikhoan + ", matKhau=" + matKhau + "]";
	}
	
}
