package objectStream;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import io.FileHandler;
import path.Constant;

public class View extends JFrame implements ActionListener, MouseListener {
    public NhanVienList nhanVienList;
    public JLabel jLabel_maNhanVien;
    public JLabel jLabel_hoNV;
    public JLabel jLabel_tenNV;
    public JLabel jLabel_tuoiNV;
    public JLabel jLabel_gioiTinhNV;
    public JLabel jLabel_timKiem;
    public JLabel jLabel_luongNV;
    public JLabel jLabel_header;
    public JTextField jTextField_timKiem;
    public JButton jButton_timKiem;
    public JButton jButton_thoat;
    public JButton jButton_them;
    public JButton jButton_sapXep;
    public JButton jButton_xoaTrang;
    public JButton jButton_xoa;
    public JButton jButton_sua;
    public JButton jButton_luu;
    public JTextField jTextField_maNhanVien;
    public JTextField jTextField_hoNV;
    public JTextField jTextField_tenNV;
    public JTextField jTextField_tuoiNV;
    public JRadioButton jRadioButton_gioiTinhNV;
    public JTextField jTextField_luongNV;
    public DefaultTableModel defaultTableModel;
    public JTable jTable_NV;
    public FileHandler fileHandler;

    //Tien Te Chung
    Locale localeVN = new Locale("vi", "VN");
    NumberFormat numf = NumberFormat.getCurrencyInstance(localeVN);

    public View() throws Exception {
        this.nhanVienList = new NhanVienList();

        this.setTitle("Quản Lí Nhân Viên");
        this.setSize(1000, 800);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        // common

        JPanel jPanel_header = new JPanel();
        jPanel_header.add(jLabel_header = new JLabel("thông tin nhân viên".toUpperCase()));
        jLabel_header.setFont(new Font("Arial", Font.BOLD, 25));
        jLabel_header.setForeground(Color.RED);

        JPanel jPanel_center = new JPanel(new BorderLayout(10, 50));

        JPanel jPanel_center_form = new JPanel();
        jPanel_center_form.setLayout(new BoxLayout(jPanel_center_form, BoxLayout.Y_AXIS));

        JPanel jPanel_center_form_1 = new JPanel();
        jPanel_center_form_1.setLayout(new BoxLayout(jPanel_center_form_1, BoxLayout.X_AXIS));
        jPanel_center_form_1.add(jLabel_maNhanVien = new JLabel("Mã nhân viên"));
        jPanel_center_form_1.add(Box.createRigidArea(new Dimension(5, 0)));
        jPanel_center_form_1.add(jTextField_maNhanVien = new JTextField());
        JPanel jPanel_center_form_2 = new JPanel();
        jPanel_center_form_2.setLayout(new BoxLayout(jPanel_center_form_2, BoxLayout.X_AXIS));
        jPanel_center_form_2.add(jLabel_hoNV = new JLabel("Họ"));
        jPanel_center_form_2.add(Box.createRigidArea(new Dimension(55, 0)));
        jPanel_center_form_2.add(jTextField_hoNV = new JTextField());
        jPanel_center_form_2.add(Box.createRigidArea(new Dimension(5, 0)));
        jPanel_center_form_2.add(jLabel_tenNV = new JLabel("Tên nhân viên"));
        jPanel_center_form_2.add(Box.createRigidArea(new Dimension(5, 0)));
        jPanel_center_form_2.add(jTextField_tenNV = new JTextField());

        JPanel jPanel_center_form_3 = new JPanel();
        jPanel_center_form_3.setLayout(new BoxLayout(jPanel_center_form_3, BoxLayout.X_AXIS));
        jPanel_center_form_3.add(jLabel_tuoiNV = new JLabel("Tuổi"));
        jPanel_center_form_3.add(Box.createRigidArea(new Dimension(46, 0)));
        jPanel_center_form_3.add(jTextField_tuoiNV = new JTextField());
        jPanel_center_form_3.add(Box.createRigidArea(new Dimension(10, 0)));
        jPanel_center_form_3.add(jLabel_gioiTinhNV = new JLabel("Phái"));
        jPanel_center_form_3.add(Box.createRigidArea(new Dimension(45, 0)));
        jPanel_center_form_3.add(jRadioButton_gioiTinhNV = new JRadioButton("Nữ"));

        JPanel jPanel_center_form_4 = new JPanel();
        jPanel_center_form_4.setLayout(new BoxLayout(jPanel_center_form_4, BoxLayout.X_AXIS));
        jPanel_center_form_4.add(jLabel_luongNV = new JLabel("Tiền lương"));
        jPanel_center_form_4.add(Box.createRigidArea(new Dimension(17, 0)));
        jPanel_center_form_4.add(jTextField_luongNV = new JTextField());

        jPanel_center_form.add(Box.createRigidArea(new Dimension(0, 15)));
        jPanel_center_form.add(jPanel_center_form_1);
        jPanel_center_form.add(Box.createRigidArea(new Dimension(0, 15)));
        jPanel_center_form.add(jPanel_center_form_2);
        jPanel_center_form.add(Box.createRigidArea(new Dimension(0, 15)));
        jPanel_center_form.add(jPanel_center_form_3);
        jPanel_center_form.add(Box.createRigidArea(new Dimension(0, 15)));
        jPanel_center_form.add(jPanel_center_form_4);
        jPanel_center_form.add(Box.createRigidArea(new Dimension(0, 15)));

        JPanel jPanel_center_table = new JPanel(new GridLayout());
        String[] headerRow = {"Mã nhân viên", "Họ", "Tên", "Phái", "Tuổi", "Tiền lương"};
        defaultTableModel = new DefaultTableModel(headerRow, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0;
            }
        };

        jTable_NV = new JTable(defaultTableModel);
        jTable_NV.addMouseListener(this);
        jPanel_center_table.add(new JScrollPane(jTable_NV));

        int colCount = jTable_NV.getColumnCount();
        for (int i = 0; i < colCount; i++) {
            this.jTable_NV.getColumnModel().getColumn(i).setCellRenderer(new DefaultTableCellRenderer() {
                {
                    setHorizontalAlignment(SwingConstants.RIGHT);
                }
            });
        }

        fileHandler = new FileHandler();
        try {
            this.nhanVienList = (NhanVienList) fileHandler.ObjectInputStreamFromFile(Constant.PATH_OBJECT);
        } catch (Exception e) {
            NhanVien nv1 = new NhanVien("NV01", "Nguyễn", "Minh", true, 20, 20000000);
            NhanVien nv2 = new NhanVien("NV02", "Trần", "Huy", true, 18, 10000000);
            NhanVien nv3 = new NhanVien("NV03", "Lê", "Kiệt", true, 19, 5000000);
            nhanVienList.themNhanVien(nv1);
            nhanVienList.themNhanVien(nv2);
            nhanVienList.themNhanVien(nv3);
            JOptionPane.showMessageDialog(this, "Không tìm thấy file", "NOT FOUND", JOptionPane.ERROR_MESSAGE);
        }

        ReadArrayListToModel();

        jPanel_center.add(jPanel_center_form, BorderLayout.NORTH);
        jPanel_center.add(jPanel_center_table, BorderLayout.CENTER);

        JPanel jPanel_footer = new JPanel(new GridLayout(1, 2, 10, 10));
        JPanel jPanel_footer_search = new JPanel();
        jPanel_footer_search.setBorder(BorderFactory.createEtchedBorder());
        jPanel_footer_search.add(jLabel_timKiem = new JLabel("Nhập thông tin cần tìm"));
        jPanel_footer_search.add(jTextField_timKiem = new JTextField(15));
        jPanel_footer_search.add(jButton_timKiem = new JButton("Tìm"));
        jButton_timKiem.addActionListener(this);
        jPanel_footer_search.add(jButton_thoat = new JButton("Thoát"));
        jButton_thoat.addActionListener(this);
        JPanel jPanel_footer_control = new JPanel();
        jPanel_footer_control.setBorder(BorderFactory.createEtchedBorder());
        jPanel_footer_control.add(jButton_them = new JButton("Thêm"));
        jButton_them.addActionListener(this);
        jPanel_footer_control.add(jButton_sapXep = new JButton("Sắp xếp")); // sapxep
        jButton_sapXep.addActionListener(this);
        jPanel_footer_control.add(jButton_xoaTrang = new JButton("Xoá trắng"));
        jButton_xoaTrang.addActionListener(this);
        jPanel_footer_control.add(jButton_xoa = new JButton("Xoá"));
        jButton_xoa.addActionListener(this);
        jPanel_footer_control.add(jButton_sua = new JButton("Sửa"));
        jButton_sua.addActionListener(this);
        jPanel_footer_control.add(jButton_luu = new JButton("Lưu"));
        jButton_luu.addActionListener(this);

        jPanel_footer.add(jPanel_footer_search);
        jPanel_footer.add(jPanel_footer_control);

        this.add(jPanel_header, BorderLayout.NORTH);
        this.add(jPanel_center, BorderLayout.CENTER);
        this.add(jPanel_footer, BorderLayout.SOUTH);
        this.getRootPane().setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setVisible(true);
    }

    public void ReadArrayListToModel() {
        for (int i = 0; i < nhanVienList.getSize(); i++) {
            NhanVien nv = nhanVienList.getElement(i);
            this.defaultTableModel.addRow(new Object[]{nv.getMaNV(), nv.getHoNV(), nv.getTenNV(),
                nv.isGioiTinhNV() ? "Nữ" : "Nam", nv.getTuoiNV(), numf.format(nv.getLuongNV())});
        }
    }

    public void deleteDataOnTable() {
        DefaultTableModel table = (DefaultTableModel) this.jTable_NV.getModel();
        table.getDataVector().removeAllElements();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int rowIndex = this.jTable_NV.getSelectedRow();
        this.jTextField_maNhanVien.setText(this.defaultTableModel.getValueAt(rowIndex, 0).toString());
        this.jTextField_hoNV.setText(this.defaultTableModel.getValueAt(rowIndex, 1).toString());
        this.jTextField_tenNV.setText(this.defaultTableModel.getValueAt(rowIndex, 2).toString());
        this.jRadioButton_gioiTinhNV.setSelected(this.defaultTableModel.getValueAt(rowIndex, 3).toString() == "Nữ" ? true : false);
        this.jTextField_tuoiNV.setText(this.defaultTableModel.getValueAt(rowIndex, 4).toString());
        this.jTextField_luongNV.setText(this.defaultTableModel.getValueAt(rowIndex, 5).toString().replace(" ₫", "").replace(".", "").trim());
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

    @Override
    public void actionPerformed(ActionEvent e) { // fix
        Object obj = e.getSource();
        if (obj.equals(jButton_timKiem)) {
            System.out.println("TÌM KIẾM : CLICKED");
            String maNV = this.jTextField_timKiem.getText();

            if (maNV.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng điền mã nhân viên", "WARNING", JOptionPane.WARNING_MESSAGE);
                return;
            }

            NhanVien nv = nhanVienList.timKiemNhanVien(maNV);
            if (nv != null) {
                deleteDataOnTable();
                this.defaultTableModel.addRow(new Object[]{nv.getMaNV(), nv.getHoNV(), nv.getTenNV(),
                    nv.isGioiTinhNV() ? "Nữ" : "Nam", nv.getTuoiNV(), nv.getLuongNV()});
            } else {
                JOptionPane.showMessageDialog(this, "Dữ liệu không tìm thấy", "Không tìm thấy",
                        JOptionPane.INFORMATION_MESSAGE);
                this.jTextField_timKiem.requestFocus();
                this.jTextField_timKiem.selectAll();
            }
        }
        if (obj.equals(jButton_thoat)) {
            System.out.println("THOÁT : CLICKED");
            int option = JOptionPane.showOptionDialog(this, "Bạn có muốn thoát chương trình ?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Có", "Không"}, "Không");
            if (option == JOptionPane.YES_OPTION) {
                System.exit(1);
            } else {
                return;
            }
        }
        if (obj.equals(jButton_them)) {
            System.out.println("THÊM : CLICKED");
            String maNV = this.jTextField_maNhanVien.getText();
            String hoNV = this.jTextField_hoNV.getText();
            String tenNV = this.jTextField_tenNV.getText();
            boolean gioiTinhNV = this.jRadioButton_gioiTinhNV.isSelected();

            // rang buoc dau vao
            if (maNV.isEmpty() || hoNV.isEmpty() || tenNV.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin nhân viên", "Cảnh báo",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            int tuoiNV;
            try {
                tuoiNV = Integer.parseInt(this.jTextField_tuoiNV.getText());
                if (tuoiNV < 18 || tuoiNV > 60) {
                    JOptionPane.showMessageDialog(this, "Tuổi không hợp lệ\nTừ 18 đến 60");
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Tuổi phải là một số", "WARNING", JOptionPane.WARNING_MESSAGE);
                return;
            }

            double luongNV;
            try {
                luongNV = Double.parseDouble(this.jTextField_luongNV.getText());
                if (luongNV < 0) {
                    JOptionPane.showMessageDialog(this, "Lương không hợp lệ\nLương là số không âm", "WARNING",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Lương phải là một số", "WARNING", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //
            try {
                NhanVien nv = new NhanVien(maNV, hoNV, tenNV, gioiTinhNV, tuoiNV, luongNV);
                if (this.nhanVienList.themNhanVien(nv)) {
                    this.defaultTableModel.addRow(new Object[]{nv.getMaNV(), nv.getHoNV(), nv.getTenNV(),
                        nv.isGioiTinhNV() ? "Nữ" : "Nam", nv.getTuoiNV(), numf.format(nv.getLuongNV())});
                    JOptionPane.showMessageDialog(this, "Đã thêm nhân viên : '" + nv.getMaNV() + "'  thành công",
                            "Success", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Thêm nhân viên '" + nv.getMaNV() + "' không thành công\nTrùng MÃ NHÂN VIÊN", "Try Again",
                            JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception e1) { // rang buoc trong get set Model
                JOptionPane.showMessageDialog(this, "Nhập ràng buộc dữ liệu đầu vào sai\nTry Again", "ERORR",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        if (obj.equals(jButton_sapXep)) {
            System.out.println("SẮP XẾP : CLICKED");
            int option = JOptionPane.showOptionDialog(this, "Lựa chọn sắp xếp", "Your Choice", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Mã nhân viên", "Lương"}, "Mã nhân viên");
            if (option == JOptionPane.YES_OPTION) {
                this.nhanVienList.sapXepTangDanMaNV();
            } else {
                this.nhanVienList.sapXepTangDanLuongNV();
            }
            deleteDataOnTable();
            ReadArrayListToModel();
        }

        if (obj.equals(jButton_xoaTrang)) {
            System.out.println("XOÁ TRẮNG : CLICKED");
            this.jTextField_timKiem.setText("");
            this.jTextField_maNhanVien.setText("");
            this.jTextField_hoNV.setText("");
            this.jTextField_tenNV.setText("");
            this.jRadioButton_gioiTinhNV.setSelected(false);
            this.jTextField_tuoiNV.setText("");
            this.jTextField_luongNV.setText("");
            this.jTextField_maNhanVien.requestFocus();
            JOptionPane.showMessageDialog(this, "Đã xoá dữ liệu đầu vào trong form");
        }
        if (obj.equals(jButton_xoa)) {
            System.out.println("XOÁ : CLICKED");
            try {
                int rowIndex = jTable_NV.getSelectedRow();
                this.defaultTableModel.removeRow(rowIndex);
                NhanVien nhanVien = nhanVienList.getElement(rowIndex);
                nhanVienList.xoaNhanVien(nhanVien.getMaNV());
                JOptionPane.showMessageDialog(
                        this,
                        "Đã xoá nhân viên : '" + nhanVien.getMaNV() + "' ra khỏi danh sách",
                        "Deleted",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(
                        this,
                        "Vui lòng chọn nhân viên cần xoá danh sách",
                        "WARNING",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        }
        if (obj.equals(jButton_sua)) {
            System.out.println("SỬA : CLICKED");
            JOptionPane.showMessageDialog(this, "Chức năng đang phát triển", "Excuse Me", JOptionPane.INFORMATION_MESSAGE);
        }
        if (obj.equals(jButton_luu)) {
            System.out.println("LƯU : CLICKED");
            boolean isSaved = FileHandler.ObjectOutputStreamToFile(nhanVienList, Constant.PATH_OBJECT);

            if (isSaved) {
                deleteDataOnTable();
                ReadArrayListToModel();
                JOptionPane.showMessageDialog(this, "Đã lưu vào file", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Lỗi lưu vào file", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new View();
    }
}
