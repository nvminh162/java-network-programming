package objectStream;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NhanVienList implements Serializable {
	private ArrayList<NhanVien> nhanVienList;

	public NhanVienList() {
		this.nhanVienList = new ArrayList<NhanVien>();
	}

	public ArrayList<NhanVien> getArrayListNV() {
		return nhanVienList;
	}

	public void setArrayListNV(ArrayList<NhanVien> nhanVienList) {
		this.nhanVienList = nhanVienList;
	}

	@Override
	public String toString() {
		return "NhanVienList [nhanVienList=" + nhanVienList + "]";
	}

	// Methods

	public int getSize() {
		return nhanVienList.size();
	}
	
	public NhanVien getElement(int index) {
		if(index < 0 || index >= nhanVienList.size()) {
			return null;
		}
		return nhanVienList.get(index);
	}
	
	public boolean themNhanVien(NhanVien nv) {
		if (nhanVienList.contains(nv)) {
			return false;
		}
		nhanVienList.add(nv);
		return true;
	}
	
	public boolean xoaNhanVien(String maNV) {
		NhanVien nv = new NhanVien(maNV);
		if(nhanVienList.contains(nv)) {
			nhanVienList.remove(nv);
			return true;
		}
		return false;
	}
	
	public NhanVien timKiemNhanVien(String maNV) {
		NhanVien nv = new NhanVien(maNV);
		if(nhanVienList.contains(nv)) {
			return nhanVienList.get(nhanVienList.indexOf(nv));
		}
		return null;
	}
	
	//bo sung
	public void sapXepTangDanLuongNV() {
		Collections.sort(nhanVienList, new Comparator<NhanVien>() {
			@Override
			public int compare(NhanVien o1, NhanVien o2) {
				if(o1.getLuongNV() > o2.getLuongNV() ) {
					return 1;
				}else if(o1.getLuongNV() < o2.getLuongNV() ) {
					return -1;
				}else {
					return 0;
				}
			}
		});
	}
	
	public void sapXepTangDanMaNV(){
        Collections.sort(nhanVienList, new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien o1, NhanVien o2) {

                return o1.getMaNV().compareTo(o2.getMaNV()); //them âm giảm dần
            }
        });
    }
}
