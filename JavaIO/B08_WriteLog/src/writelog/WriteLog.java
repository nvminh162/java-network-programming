/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/Application.java to edit this template
 */
package writelog;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author nvmin
 */
public class WriteLog extends javax.swing.JFrame {

    private File logFile;

    /**
     * Creates new form BaiTapIO_01
     */
    public WriteLog() {
        openLog();
        initComponents();
        setResizable(false);
    }

    private void openLog() {
        try {
            String fileName = "E:\\Workspace\\Course\\LapTrinhMangJava\\B08_WriteLog\\src\\log\\write.log";
            this.logFile = new File(fileName);
            if (!logFile.exists()) {
                this.logFile.createNewFile();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void writeLog(String msg) {
        try {
            FileOutputStream fos = new FileOutputStream(this.logFile, true);
            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            BufferedWriter bw = new BufferedWriter(osw);

            LocalDateTime current_ldt = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
            String time = current_ldt.format(dtf);
            String user = "nvminh162";
            bw.append(time + " " + user + " " + msg);
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_folder = new javax.swing.JLabel();
        folderPath = new javax.swing.JTextField();
        btn_open = new javax.swing.JButton();
        lbl_fileName = new javax.swing.JLabel();
        fileName = new javax.swing.JTextField();
        btn_create = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextArea = new javax.swing.JTextArea();
        btn_delete = new javax.swing.JButton();
        btn_rename = new javax.swing.JButton();
        btn_copy = new javax.swing.JButton();
        btn_log = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_folder.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_folder.setText("Folder");

        folderPath.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        folderPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                folderPathActionPerformed(evt);
            }
        });

        btn_open.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_open.setText("Open");
        btn_open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_openActionPerformed(evt);
            }
        });

        lbl_fileName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_fileName.setText("File Name");

        fileName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        fileName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileNameActionPerformed(evt);
            }
        });

        btn_create.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_create.setText("Create");
        btn_create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_createActionPerformed(evt);
            }
        });

        TextArea.setColumns(20);
        TextArea.setRows(5);
        jScrollPane1.setViewportView(TextArea);

        btn_delete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_rename.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_rename.setText("Rename");
        btn_rename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_renameActionPerformed(evt);
            }
        });

        btn_copy.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_copy.setText("Copy");
        btn_copy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_copyActionPerformed(evt);
            }
        });

        btn_log.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_log.setText("Log");
        btn_log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logActionPerformed(evt);
            }
        });

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Edit");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentsMenuItem.setMnemonic('c');
        contentsMenuItem.setText("Contents");
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_fileName)
                            .addComponent(lbl_folder))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(folderPath, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                            .addComponent(fileName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_create, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_open, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_log, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_copy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_rename, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_open, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_folder)
                        .addComponent(folderPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_create, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_fileName)
                        .addComponent(fileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_rename, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_copy))
                    .addComponent(btn_log, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void folderPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_folderPathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_folderPathActionPerformed

    private String listAllFiles(String path, int level) {
        String result = "";
        File file = new File(path);

        if (!file.exists()) {
            return result;
        }

        for (int i = 0; i < level; i++) {
            result += "\t";
        }

        result += ((level == 0 ? "" : "|___") + file.getName() + "\n");

        if (file.isFile()) {
            return result;
        }

        for (File f : file.listFiles()) {
            result += listAllFiles(f.getAbsolutePath(), level + 1);
        }
        return result;
    }

    private void btn_openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_openActionPerformed
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = jfc.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String path = jfc.getSelectedFile().getAbsolutePath();
            folderPath.setText(path);
            TextArea.setText(listAllFiles(path, 0));
        }
        writeLog("Mở " + folderPath.getText());
    }//GEN-LAST:event_btn_openActionPerformed

    private void fileNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fileNameActionPerformed

    private void btn_createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createActionPerformed
        String pathFolder = folderPath.getText().trim();
        String fileName = this.fileName.getText().trim();
        String filePath = pathFolder + "/" + fileName;
        File file = new File(filePath);
        if (pathFolder.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thư mục!");
            return;
        }
        if (fileName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhập tệp tin!");
            return;
        }
        if (file.exists()) {
            JOptionPane.showMessageDialog(this, "Tệp tin đã tồn tại!");
            return;
        }
        try {
            file.createNewFile();
            TextArea.setText(listAllFiles(pathFolder, 0));
            JOptionPane.showMessageDialog(this, "Đã tạo thành công: " + fileName);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Tạo file không thành công: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_createActionPerformed

    private void deleteHandler(String path) {
        try {
            File file = new File(path);
            if (file.isDirectory()) {
                for (File f : file.listFiles()) {
                    deleteHandler(f.getAbsolutePath());
                }
            }
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        String pathFolder = folderPath.getText().trim();
        int choose = JOptionPane.showConfirmDialog(this, "Are u sure delete all items?");
        if (choose == JOptionPane.NO_OPTION) {
            return;
        }

        String path = folderPath.getText();
        deleteHandler(path);
        TextArea.setText(listAllFiles(pathFolder, 0));
        JOptionPane.showMessageDialog(this, "Xoá thành công!");
        writeLog("Xoá " + folderPath.getText());
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_renameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_renameActionPerformed
        String newFileName = JOptionPane.showInputDialog(this, "Nhập tên file mới: ");

        try {
            String path = folderPath.getText().trim();
            File oldFile = new File(path);

            String newPath = oldFile.getParent() + "/" + newFileName;
            File newFile = new File(newPath);

            if (oldFile.renameTo(newFile)) {
                writeLog("Đổi tên thành công " + folderPath.getText());
                JOptionPane.showMessageDialog(this, "Đã đổi tên file thành công!");
            } else {
                writeLog("Đổi tên không thành công " + folderPath.getText());
                JOptionPane.showMessageDialog(this, "Đã đổi tên file không thành công!");
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_renameActionPerformed

    private void btn_copyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_copyActionPerformed
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = jfc.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String source = folderPath.getText();
            String destination = jfc.getSelectedFile().getAbsolutePath();
            copy(source, destination);
        }
        writeLog("Sao chép: " + folderPath.getText());
    }//GEN-LAST:event_btn_copyActionPerformed

    private void btn_logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logActionPerformed
        try {
            FileInputStream fis = new FileInputStream(logFile);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);

            String rs = "";
            String line = "";
            while((line = br.readLine()) != null) {
                rs += line;
                rs += "\n";
            }
            TextArea.setText(rs);
        } catch (Exception e) {
            e.printStackTrace();
            writeLog(e.getMessage());
        }

    }//GEN-LAST:event_btn_logActionPerformed

    private void copy(String source, String destination) {
        try {
            Path sourcePath = Path.of(source);
            Path destinationPath = Path.of(destination);
            Path newPath = destinationPath.resolve(sourcePath.getFileName());

            Files.copy(sourcePath, newPath, StandardCopyOption.COPY_ATTRIBUTES);
            File f = new File(source);
            if (f.isDirectory()) {
                for (File f_fe : f.listFiles()) {
                    copy(f_fe.getAbsolutePath(), destination + "/" + sourcePath.getFileName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
            * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
             */
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(WriteLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(WriteLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(WriteLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(WriteLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName()
            );

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {

                    new WriteLog().setVisible(true);

                }
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WriteLog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(WriteLog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(WriteLog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(WriteLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TextArea;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton btn_copy;
    private javax.swing.JButton btn_create;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_log;
    private javax.swing.JButton btn_open;
    private javax.swing.JButton btn_rename;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JTextField fileName;
    private javax.swing.JTextField folderPath;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_fileName;
    private javax.swing.JLabel lbl_folder;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

}
