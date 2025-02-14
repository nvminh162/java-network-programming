package bufferedstream;

import io.FileHandler;
import path.Constant;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.io.*;

public class View extends JFrame implements ActionListener, MouseListener {

    private SachList sachList;
    private JLabel jLabel_maSach;
    private JLabel jLabel_tuaSach;
    private JLabel jLabel_namXuatBan;
    private JLabel jLabel_soTrang;
    private JLabel jLabel_iSBN;
    private JTextField jTextField_maSach;
    private JTextField jTextField_tuaSach;
    private JTextField jTextField_namXuatBan;
    private JTextField jTextField_soTrang;
    private JTextField jTextField_iSBN;
    private JLabel jLabel_tacGia;
    private JLabel jLabel_nhaXuatBan;
    private JLabel jLabel_donGia;
    private JTextField jTextField_tacGia;
    private JTextField jTextField_nhaXuatBan;
    private JTextField jTextField_donGia;
    private JLabel jLabel_empty1;
    private JLabel jLabel_empty5;
    private JButton jButton_them;
    private JButton jButton_xoaRong;
    private JButton jButton_sua;
    private JButton jButton_xoa;
    private JButton jButton_luu;
    private JButton jButton_loc;
    private JButton jButton_thoat;
    private JLabel jLabel_timKiemSach;
    private DefaultTableModel defaultTableModel;
    private JTable jTable_thuVien;
    private JComboBox<String> jComboBox_timKiemSach;
    private JLabel jLabel_txtMessage;
    private JLabel jLabel_empty6;

    //Tien Te Chung
    Locale localeVN = new Locale("vi", "VN");
    NumberFormat numf = NumberFormat.getCurrencyInstance(localeVN);

    public View() {
        this.setTitle("@paul");
        this.setSize(1000, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(10, 10));

        //header
        JPanel jPanel_header = new JPanel(new GridLayout(1, 2, 35, 10));
        jPanel_header.setBorder(BorderFactory.createTitledBorder("Records Editor"));
        JPanel jPanel_header_west = new JPanel();
        jPanel_header_west.setLayout(new BoxLayout(jPanel_header_west, BoxLayout.Y_AXIS));
        JPanel jPanel_header_west_1 = new JPanel();
        jPanel_header_west_1.setLayout(new BoxLayout(jPanel_header_west_1, BoxLayout.X_AXIS));
        jPanel_header_west_1.add(jLabel_maSach = new JLabel("Mã sách:"));
        jPanel_header_west_1.add(Box.createRigidArea(new Dimension(35, 0)));
        jPanel_header_west_1.add(jTextField_maSach = new JTextField());
        JPanel jPanel_header_west_2 = new JPanel();
        jPanel_header_west_2.setLayout(new BoxLayout(jPanel_header_west_2, BoxLayout.X_AXIS));
        jPanel_header_west_2.add(jLabel_tuaSach = new JLabel("Tựa sách:"));
        jPanel_header_west_2.add(Box.createRigidArea(new Dimension(30, 0)));
        jPanel_header_west_2.add(jTextField_tuaSach = new JTextField());
        JPanel jPanel_header_west_3 = new JPanel();
        jPanel_header_west_3.setLayout(new BoxLayout(jPanel_header_west_3, BoxLayout.X_AXIS));
        jPanel_header_west_3.add(jLabel_namXuatBan = new JLabel("Năm xuất bản:"));
        jPanel_header_west_3.add(Box.createRigidArea(new Dimension(10, 0)));
        jPanel_header_west_3.add(jTextField_namXuatBan = new JTextField());
        JPanel jPanel_header_west_4 = new JPanel();
        jPanel_header_west_4.setLayout(new BoxLayout(jPanel_header_west_4, BoxLayout.X_AXIS));
        jPanel_header_west_4.add(jLabel_soTrang = new JLabel("Số trang:"));
        jPanel_header_west_4.add(Box.createRigidArea(new Dimension(35, 0)));
        jPanel_header_west_4.add(jTextField_soTrang = new JTextField());
        JPanel jPanel_header_west_5 = new JPanel();
        jPanel_header_west_5.setLayout(new BoxLayout(jPanel_header_west_5, BoxLayout.X_AXIS));
        jPanel_header_west_5.add(jLabel_iSBN = new JLabel("International Standard Book Number (ISBN):"));
        jPanel_header_west_5.add(jTextField_iSBN = new JTextField());
        JPanel jPanel_header_west_6 = new JPanel();
        jPanel_header_west_6.setLayout(new BoxLayout(jPanel_header_west_6, BoxLayout.X_AXIS));
        jPanel_header_west_6.add(jLabel_txtMessage = new JLabel());
        jLabel_txtMessage.setFont(new Font("Arial", Font.BOLD, 15));
        jLabel_txtMessage.setForeground(Color.RED);

        jPanel_header_west.add(Box.createRigidArea(new Dimension(0, 30)));
        jPanel_header_west.add(jPanel_header_west_1);
        jPanel_header_west.add(Box.createRigidArea(new Dimension(0, 10)));
        jPanel_header_west.add(jPanel_header_west_2);
        jPanel_header_west.add(Box.createRigidArea(new Dimension(0, 10)));
        jPanel_header_west.add(jPanel_header_west_3);
        jPanel_header_west.add(Box.createRigidArea(new Dimension(0, 10)));
        jPanel_header_west.add(jPanel_header_west_4);
        jPanel_header_west.add(Box.createRigidArea(new Dimension(0, 10)));
        jPanel_header_west.add(jPanel_header_west_5);
        jPanel_header_west.add(Box.createRigidArea(new Dimension(0, 10)));
        jPanel_header_west.add(jPanel_header_west_6);
        jPanel_header_west.add(Box.createRigidArea(new Dimension(0, 30)));

        JPanel jPanel_header_east = new JPanel();
        jPanel_header_east.setLayout(new BoxLayout(jPanel_header_east, BoxLayout.Y_AXIS));
        JPanel jPanel_header_east_1 = new JPanel();
        jPanel_header_east_1.setLayout(new BoxLayout(jPanel_header_east_1, BoxLayout.X_AXIS));
        jPanel_header_east_1.add(jLabel_empty1 = new JLabel("\n"));
        JPanel jPanel_header_east_2 = new JPanel();
        jPanel_header_east_2.setLayout(new BoxLayout(jPanel_header_east_2, BoxLayout.X_AXIS));
        jPanel_header_east_2.add(jLabel_tacGia = new JLabel("Tác giả:"));
        jPanel_header_east_2.add(Box.createRigidArea(new Dimension(34, 0)));
        jPanel_header_east_2.add(jTextField_tacGia = new JTextField());
        JPanel jPanel_header_east_3 = new JPanel();
        jPanel_header_east_3.setLayout(new BoxLayout(jPanel_header_east_3, BoxLayout.X_AXIS));
        jPanel_header_east_3.add(jLabel_nhaXuatBan = new JLabel("Nhà xuất bản:"));
        jPanel_header_east_3.add(Box.createRigidArea(new Dimension(7, 0)));
        jPanel_header_east_3.add(jTextField_nhaXuatBan = new JTextField());
        JPanel jPanel_header_east_4 = new JPanel();
        jPanel_header_east_4.setLayout(new BoxLayout(jPanel_header_east_4, BoxLayout.X_AXIS));
        jPanel_header_east_4.add(jLabel_donGia = new JLabel("Đơn giá:"));
        jPanel_header_east_4.add(Box.createRigidArea(new Dimension(31, 0)));
        jPanel_header_east_4.add(jTextField_donGia = new JTextField());
        JPanel jPanel_header_east_5 = new JPanel();
        jPanel_header_east_5.setLayout(new BoxLayout(jPanel_header_east_5, BoxLayout.X_AXIS));
        jPanel_header_east_5.add(jLabel_empty5 = new JLabel("\n"));
        JPanel jPanel_header_east_6 = new JPanel();
        jPanel_header_east_6.setLayout(new BoxLayout(jPanel_header_east_6, BoxLayout.X_AXIS));
        jPanel_header_east_6.add(jLabel_empty6 = new JLabel("\n"));

        jPanel_header_east.add(Box.createRigidArea(new Dimension(0, 30)));
        jPanel_header_east.add(jPanel_header_east_1);
        jPanel_header_east.add(Box.createRigidArea(new Dimension(0, 10)));
        jPanel_header_east.add(jPanel_header_east_2);
        jPanel_header_east.add(Box.createRigidArea(new Dimension(0, 10)));
        jPanel_header_east.add(jPanel_header_east_3);
        jPanel_header_east.add(Box.createRigidArea(new Dimension(0, 10)));
        jPanel_header_east.add(jPanel_header_east_4);
        jPanel_header_east.add(Box.createRigidArea(new Dimension(0, 10)));
        jPanel_header_east.add(jPanel_header_east_5);
        jPanel_header_east.add(Box.createRigidArea(new Dimension(0, 10)));
        jPanel_header_east.add(jPanel_header_east_6);
        jPanel_header_east.add(Box.createRigidArea(new Dimension(0, 30)));

        jPanel_header.add(jPanel_header_west);
        jPanel_header.add(jPanel_header_east);

        //center
        JPanel jPanel_center = new JPanel(new BorderLayout(10, 10));
        //Button
        JPanel jPanel_center_north = new JPanel(new GridLayout(1, 2, 30, 10));

        JPanel jPanel_center_north_btnArea = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        jPanel_center_north_btnArea.add(jButton_them = new JButton("Thêm"));
        jPanel_center_north_btnArea.add(jButton_xoaRong = new JButton("Xoá rỗng"));
        jPanel_center_north_btnArea.add(jButton_sua = new JButton("Sửa"));
        jPanel_center_north_btnArea.add(jButton_xoa = new JButton("Xoá"));
        jPanel_center_north_btnArea.add(jButton_luu = new JButton("Lưu"));
        jPanel_center_north_btnArea.add(jButton_thoat = new JButton("Thoát"));
        JPanel jPanel_center_north_searchArea = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jPanel_center_north_searchArea.add(jLabel_timKiemSach = new JLabel("Tìm theo mã sách:"));
        jPanel_center_north_searchArea.add(jComboBox_timKiemSach = new JComboBox<String>());
        jComboBox_timKiemSach.setPreferredSize(new Dimension(100, 20));
        jPanel_center_north_searchArea.add(jButton_loc = new JButton("Lọc"));

        jPanel_center_north.add(jPanel_center_north_btnArea);
        jPanel_center_north.add(jPanel_center_north_searchArea);

        //Table
        JPanel jPanel_center_center = new JPanel(new GridLayout());
        jPanel_center_center.setBorder(BorderFactory.createTitledBorder("Danh sách các cuốn sách"));
        String[] colHeader = {"Mã sách", "Tựa sách", "Tác giả", "Năm xuất bản", "Nhà xuất bản", "Số trang", "Đơn giá", "ISBN"};
        defaultTableModel = new DefaultTableModel(colHeader, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0;
            }
        };
        jTable_thuVien = new JTable(defaultTableModel);
        jPanel_center_center.add(new JScrollPane(jTable_thuVien));

        for (int i = 0; i < jTable_thuVien.getColumnCount(); i++) {
            this.jTable_thuVien.getColumnModel().getColumn(i).setCellRenderer(new DefaultTableCellRenderer() {
                {
                    setHorizontalAlignment(SwingConstants.CENTER);
                }
            });
        }

        sachList = new SachList();
        sachList.DocDuLieuTuFile();

        updateTableData();
        updateComboBoxData();

        jTable_thuVien.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = jTable_thuVien.getSelectedRow();
                fillForm(row);
            }
        });

        jPanel_center.add(jPanel_center_north, BorderLayout.NORTH);
        jPanel_center.add(jPanel_center_center, BorderLayout.CENTER);

        this.jComboBox_timKiemSach.addActionListener(this);
        this.jButton_them.addActionListener(this);
        this.jButton_xoaRong.addActionListener(this);
        this.jButton_sua.addActionListener(this);
        this.jButton_xoa.addActionListener(this);
        this.jButton_luu.addActionListener(this);
        this.jButton_thoat.addActionListener(this);
        this.jButton_loc.addActionListener(this);

        this.add(jPanel_header, BorderLayout.NORTH);
        this.add(jPanel_center, BorderLayout.CENTER);
        this.getRootPane().setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setVisible(true);
    }

    public void fillForm(int row) {
        if (row != -1) {
            String maSach = (String) jTable_thuVien.getValueAt(row, 0);
            Sach s = new Sach(maSach);
            ArrayList<Sach> dsSach = sachList.getSachList();
            if (sachList.getSachList().contains(s)) {
                s = dsSach.get(dsSach.indexOf(s));
                jTextField_maSach.setText(s.getMaSach());
                jTextField_tuaSach.setText(s.getTuaSach());
                jTextField_tacGia.setText(s.getTacGia());
                jTextField_namXuatBan.setText(s.getNamXuatBan() + "");
                jTextField_nhaXuatBan.setText(s.getNhaXuatBan());
                jTextField_soTrang.setText(s.getSoTrang() + "");
                jTextField_donGia.setText(s.getDonGia() + "");
                jTextField_iSBN.setText(s.getiSBN());
                jTextField_maSach.setEditable(false);
            }
        }
    }

    public void updateComboBoxData() {
        int n = sachList.count();
        String[] items = new String[n];
        int i = 0;
        for (Sach s : sachList.getSachList()) {
            items[i] = s.getMaSach();
            i++;
        }
        jComboBox_timKiemSach.setModel(new DefaultComboBoxModel<String>(items));
    }

    public void updateTableData() {
        defaultTableModel.setRowCount(0);
        ArrayList<Sach> sachList = this.sachList.getSachList();

        for (Sach sach : sachList) {
            Object[] rowData = {
                    sach.getMaSach(),
                    sach.getTuaSach(),
                    sach.getTacGia(),
                    sach.getNamXuatBan(),
                    sach.getNhaXuatBan(),
                    sach.getSoTrang(),
                    numf.format(sach.getDonGia()),
                    sach.getiSBN()
            };
            defaultTableModel.addRow(rowData);
        }
    }

    public void showMessage(String message, JTextField txt) {
        txt.requestFocus();
        jLabel_txtMessage.setText(message);
    }

    public boolean validData() {
        String maSach = jTextField_maSach.getText().trim();
        String tuaSach = jTextField_tuaSach.getText().trim();
        String tacGia = jTextField_tacGia.getText().trim();
        String namXuatBan = jTextField_namXuatBan.getText().trim();
        String nhaXuatBan = jTextField_nhaXuatBan.getText().trim();
        String donGia = jTextField_donGia.getText().trim();
        String iSBN = jTextField_iSBN.getText().trim();
        String soTrang = jTextField_soTrang.getText().trim();

        if (!(!maSach.isEmpty() && maSach.matches("[A-Z]\\d{3}"))) {
            JOptionPane.showMessageDialog(this, "Mã sách không được để trống và có 4 ký tự\nBao gồm ký tự đầu là ký tự viết hoa và 3 số", "Erorr", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!(!tuaSach.isEmpty() && tuaSach.matches("[a-zA-Z' ]+"))) {
            JOptionPane.showMessageDialog(this, "Tựa sách không được để trống, không chứa số và ký tự đặc biệt ngoại từ ' ' ", "Erorr", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!(!tacGia.isEmpty() && tacGia.matches("[a-zA-Z' ]+"))) {
            JOptionPane.showMessageDialog(this, "Tác giả không được để trống, không chứa số và ký tự đặc biệt ngoại từ ' ' ", "Erorr", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!(!nhaXuatBan.isEmpty() && nhaXuatBan.matches("[a-zA-Z' ]+"))) {
            JOptionPane.showMessageDialog(this, "Nhà xuất bản không được để trống, không chứa số và ký tự đặc biệt ngoại từ ' ' ", "Erorr", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if ((!namXuatBan.isEmpty())) {
            try {
                int x = Integer.parseInt(namXuatBan);
                int namHienTai = Calendar.getInstance().get(Calendar.YEAR);
                if (!(x >= 1900 && x < namHienTai)) {
                    JOptionPane.showMessageDialog(this, "Năm không hợp lệ\nKiểm tra lại từ 1900 đến hiện tại", "Erorr", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Năm không hợp lệ\nKiểm tra lại năm không được để trống & phải là số", "Erorr", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        if (!soTrang.isEmpty()) {
            try {
                int x = Integer.parseInt(soTrang);
                if (x <= 0) {
                    JOptionPane.showMessageDialog(this, "Số trang không hợp lệ\nKiểm tra lại, số trang là số dương", "Erorr", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Số trang không hợp lệ\nKiểm tra lại số trang phải là số", "Erorr", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        if (!donGia.isEmpty()) {
            try {
                double y = Double.parseDouble(soTrang);
                if (y < 0) {
                    JOptionPane.showMessageDialog(this, "Giá phải lớn hơn không", "ERORR", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Giá phải nhập số", "ERORR", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        if ((!iSBN.isEmpty())) {
            if (!iSBN.matches("\\d+(-\\d+){3,4}")) {
                JOptionPane.showMessageDialog(this, "Mã ISBN phải có dạng X-X-X-X\nTrong đó X gồm các ký tự số, ít nhất 1 số", "ERORR", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Mã ISBN không được để trống", "ERORR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public void clearTextField() {
        jTextField_maSach.setText("");
        jTextField_tuaSach.setText("");
        jTextField_tacGia.setText("");
        jTextField_namXuatBan.setText("");
        jTextField_nhaXuatBan.setText("");
        jTextField_soTrang.setText("");
        jTextField_donGia.setText("");
        jTextField_iSBN.setText("");
        jTextField_maSach.setEditable(true);
        jTextField_maSach.requestFocus();
    }

    public Sach revertSachFromTextFields() {
        String maSach = jTextField_maSach.getText().trim();
        String tuaSach = jTextField_tuaSach.getText().trim();
        String tacGia = jTextField_tacGia.getText().trim();
        String nam = jTextField_namXuatBan.getText().trim();
        int namXuatBan = nam.length() == 0 ? 0 : Integer.parseInt(nam);
        String nhaXuatBan = jTextField_nhaXuatBan.getText().trim();
        String trang = jTextField_soTrang.getText().trim();
        int soTrang = trang.length() == 0 ? 0 : Integer.parseInt(trang);
        String gia = jTextField_donGia.getText().trim();
        double donGia = gia.equals("") ? 0 : Double.parseDouble(gia);
        String iSBN = jTextField_iSBN.getText().trim();
        return new Sach(maSach, tuaSach, tacGia, namXuatBan, nhaXuatBan, soTrang, donGia, iSBN);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(jComboBox_timKiemSach)) {
            System.out.println("TIM KIEM");
            String maSach = (String) jComboBox_timKiemSach.getSelectedItem();
            Sach s = sachList.timKiem(maSach);
            if (s != null) {
                int index = sachList.getSachList().indexOf(s);
                fillForm(index);
                jTable_thuVien.getSelectionModel().setSelectionInterval(index, index);
                jTable_thuVien.scrollRectToVisible(jTable_thuVien.getCellRect(index, index, true));
            }
        }

        if (o.equals(jButton_them)) {
            System.out.println("THEM");
//            //validData
//            if (validData()) {
//                Sach s = revertSachFromTextFields();
//                if (thuVien.themSach(s)) {
//                    jLabel_txtMessage.setText("Thêm thành công 1 sách");
//                    updateTableData();
//                    updateComboBoxData();
//                } else {
//                    showMessage("Error : trùng mã sách", jTextField_donGia);
//                }
//            }
            //!validData
            Sach s = revertSachFromTextFields();
            if (sachList.themSach(s)) {
                jLabel_txtMessage.setText("Thêm thành công 1 sách");
                updateTableData();
                updateComboBoxData();
            } else {
                showMessage("Error : trùng mã sách", jTextField_donGia);
            }
        }

        if (o.equals(jButton_xoaRong)) {
            System.out.println("XOA RONG");
            clearTextField();
        }

        if (o.equals(jButton_sua)) {
            System.out.println("SUA");
            String maSachCu = jTextField_maSach.getText().trim();
            if (validData()) {
                Sach sachMoi = revertSachFromTextFields();
                if (sachList.capNhatSach(maSachCu, sachMoi)) {
                    jLabel_txtMessage.setText("Cập nhật thành công");
                    updateTableData();
                    int index = sachList.getSachList().indexOf(sachMoi);
                    jTable_thuVien.setRowSelectionInterval(index, index);
                } else {
                    jLabel_txtMessage.setText("Cần chọn cuốn sách để cập nhật");
                }
            }
        }
        if (o.equals(jButton_xoa)) {
            System.out.println("XOA");
            int row = jTable_thuVien.getSelectedRow();
            if (row != -1) {
                int hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn không?", "Chú ý", JOptionPane.YES_NO_OPTION);
                if (hoiNhac == JOptionPane.YES_OPTION) {
                    if (sachList.xoaMotSach(row)) {
                        jLabel_txtMessage.setText("Đã xoá một cuốn sách");
                        updateTableData();
                        updateComboBoxData();
                        clearTextField();
                    }
                }
            } else {
                jLabel_txtMessage.setText("Bạn phải chọn một cuốn sách cần xoá!");
            }
        }
        if (o.equals(jComboBox_timKiemSach)) {
            System.out.println("COMBOBOX");
        }

        if (o.equals(jButton_luu)) {
            System.out.println("LUU");
            boolean isSaved = FileHandler.BufferedOutputStreamToFile(sachList.getSachList(), Constant.PATH_BUFFERED);
            if (isSaved) {
                jLabel_txtMessage.setText("Lưu thành công");
            } else {
                jLabel_txtMessage.setText("Lưu không thành công");
            }
        }

        if (o.equals(jButton_thoat)) {
            System.out.println("THOÁT");
            int ask = JOptionPane.showOptionDialog(this, "Bạn có muốn thoát chương trình ?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Có", "Không"}, "Không");
            if (ask == JOptionPane.YES_OPTION) {
                System.exit(1);
            }
        }

        if (o.equals(jButton_loc)) {
            System.out.println("LỌC");
            JOptionPane.showMessageDialog(this, "Chức năng đang phát triển", "Try Again", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new View();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
