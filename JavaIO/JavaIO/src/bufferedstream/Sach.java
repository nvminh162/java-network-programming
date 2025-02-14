package bufferedstream;

import java.util.Objects;

public class Sach {

    private String maSach, tuaSach, tacGia;
    private int namXuatBan;
    private String nhaXuatBan;
    private int soTrang;
    private double donGia;
    private String iSBN;

    public Sach() {

    }

    public Sach(String maSach) {
        this.maSach = maSach;
    }

    public Sach(String maSach, String tuaSach, String tacGia, int namXuatBan, String nhaXuatBan, int soTrang,
            double donGia, String iSBN) {
        this.maSach = maSach;
        this.tuaSach = tuaSach;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.nhaXuatBan = nhaXuatBan;
        this.soTrang = soTrang;
        this.donGia = donGia;
        this.iSBN = iSBN;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTuaSach() {
        return tuaSach;
    }

    public void setTuaSach(String tuaSach) {
        this.tuaSach = tuaSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getiSBN() {
        return iSBN;
    }

    public void setiSBN(String iSBN) {
        this.iSBN = iSBN;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maSach);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Sach other = (Sach) obj;
        return Objects.equals(maSach, other.maSach);
    }

    @Override
    public String toString() {
//		return "Sach [maSach=" + maSach + ", tuaSach=" + tuaSach + ", tacGia=" + tacGia + ", namXuatBan=" + namXuatBan
//				+ ", nhaXuatBan=" + nhaXuatBan + ", soTrang=" + soTrang + ", donGia=" + donGia + ", iSBN=" + iSBN + "]";
        return maSach + ";" + tuaSach + ";" + tacGia + ";" + namXuatBan + ";" + nhaXuatBan + ";" + soTrang + ";" + donGia + ";" + iSBN;
    }

}
