package objectStream;

import java.io.Serializable;
import java.util.Objects;

public class NhanVien implements Serializable {
	private String maNV, hoNV, tenNV;
	private boolean gioiTinhNV;
	private int tuoiNV;
	private double luongNV;

	public NhanVien() {

	}

	public NhanVien(String maNV) {
		this.maNV = maNV;
	}

	public NhanVien(String maNV, String hoNV, String tenNV, boolean gioiTinhNV, int tuoiNV, double luongNV)
			throws Exception {
		setMaNV(maNV);
		setHoNV(hoNV);
		setTenNV(tenNV);
		this.gioiTinhNV = gioiTinhNV;
		setTuoiNV(tuoiNV);
		setLuongNV(luongNV);
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) throws Exception {
		if (maNV != null && !maNV.isEmpty()) {
			this.maNV = maNV;
		} else {
			throw new Exception("Mã nhân viên không được rỗng");
		}
	}

	public String getHoNV() {
		return hoNV;
	}

	public void setHoNV(String hoNV) throws Exception {
		if (hoNV != null && !hoNV.isEmpty()) {
			this.hoNV = hoNV;
		} else {
			throw new Exception("Họ nhân viên không được rỗng");
		}
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) throws Exception {
		this.tenNV = tenNV;
		if (tenNV != null && !tenNV.isEmpty()) {
			this.tenNV = tenNV;
		} else {
			throw new Exception("Tên nhân viên không được rỗng");
		}
	}

	public boolean isGioiTinhNV() {
		return gioiTinhNV;
	}

	public void setGioiTinhNV(boolean gioiTinhNV) {
		this.gioiTinhNV = gioiTinhNV;
	}

	public int getTuoiNV() {
		return tuoiNV;
	}

	public void setTuoiNV(int tuoiNV) throws Exception {
		if (tuoiNV < 18 || tuoiNV > 60) {
			throw new Exception("Nhập tuổi từ 18 đến 60");
		} else {
			this.tuoiNV = tuoiNV;
		}
	}

	public double getLuongNV() {
		return luongNV;
	}

	public void setLuongNV(double luongNV) throws Exception {
		if(luongNV < 0) {
			throw new Exception("Lương phải > 0");
		}else {
			this.luongNV = luongNV;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNV, other.maNV);
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", hoNV=" + hoNV + ", tenNV=" + tenNV + ", gioiTinhNV=" + gioiTinhNV
				+ ", tuoiNV=" + tuoiNV + ", luongNV=" + luongNV + "]";
	}
}
