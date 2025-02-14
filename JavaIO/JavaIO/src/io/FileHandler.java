package io;

import bufferedstream.Sach;

import java.io.*;
import java.util.ArrayList;
import java.util.function.Function;

public class FileHandler {
    public static boolean ObjectOutputStreamToFile(Object obj, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(obj);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static Object ObjectInputStreamFromFile(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }

    public static <T> boolean BufferedOutputStreamToFile(ArrayList<T> list, String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (T obj : list) {
                bw.write(obj.toString());
                bw.newLine();
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static <T> ArrayList<T> BufferedInputStreamFromFile(Function<String, T> mapper, String filePath) {
        ArrayList<T> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    result.add(mapper.apply(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
