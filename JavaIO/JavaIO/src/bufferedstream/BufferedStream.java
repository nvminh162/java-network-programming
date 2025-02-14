package bufferedstream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BufferedStream {
    public static void WriteFile(ArrayList<Sach> thuVien, String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Sach s : thuVien) {
                bw.write(s.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Sach> ReadFile(String filePath) {
        ArrayList<Sach> thuVien = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] a = line.split(";");
                    thuVien.add(new Sach(
                            a[0], a[1], a[2], Integer.parseInt(a[3]),
                            a[4], Integer.parseInt(a[5]),
                            Double.parseDouble(a[6]), a[7]
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return thuVien;
    }
}
