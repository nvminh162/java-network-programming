package bufferedstream;

import java.util.ArrayList;

import io.FileHandler;
import path.Constant;

public class SachList {
    private ArrayList<Sach> sachList;

    public SachList() {
        this.sachList = new ArrayList<Sach>();
    }

    public void DocDuLieuTuFile() {
//      this.sachList = Storage.ReadFile(Constant.PATH_BUFFERED);
        this.sachList = FileHandler.BufferedInputStreamFromFile(line -> {
            String[] a = line.split(";");
            return new Sach(
                    a[0], a[1], a[2], Integer.parseInt(a[3]),
                    a[4], Integer.parseInt(a[5]),
                    Double.parseDouble(a[6]), a[7]
            );
        }, Constant.PATH_BUFFERED);
    }

    public ArrayList<Sach> getSachList() {
        return sachList;
    }

    public void setSachList(ArrayList<Sach> sachList) {
        this.sachList = sachList;
    }

    //methods
    public int count() {
        return sachList.size();
    }

    public boolean themSach(Sach s) {
        if (sachList.contains(s)) {
            return false;
        }
        return sachList.add(s);
    }

    public boolean xoaMotSach(int index) {
        if (index >= 0 && index < sachList.size()) {
            sachList.remove(index);
            return true;
        }
        return false;
    }

    public Sach timKiem(String maSach) {
        Sach s = new Sach(maSach);
        if (sachList.contains(s)) {
            return sachList.get(sachList.indexOf(s));
        }
        return null;
    }

    public boolean capNhatSach(String maSachCu, Sach sachMoi) {
        Sach sachCu = new Sach(maSachCu);
        if (sachList.contains(sachCu)) {
            sachCu = sachList.get(sachList.indexOf(sachCu));
            sachCu.setTuaSach(sachMoi.getTuaSach());
            sachCu.setTacGia(sachMoi.getTacGia());
            sachCu.setNamXuatBan(sachMoi.getNamXuatBan());
            sachCu.setNhaXuatBan(sachMoi.getNhaXuatBan());
            sachCu.setSoTrang(sachMoi.getSoTrang());
            sachCu.setDonGia(sachMoi.getDonGia());
            sachCu.setiSBN(sachMoi.getiSBN());
            return true;
        }

        return false;
    }

}
