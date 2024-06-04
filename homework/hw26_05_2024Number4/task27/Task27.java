package hw26_05_2024Number4.task27;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Task27 {

    public static void main(String[] args) {
        try {
            URL fileURL = new URL("https://encrypted-tbn0.gstatic.com/" +
                    "images?q=tbn:ANd9GcSp8x8XFGE4TJKiIfWZpzo64e_HZjFJCV_Z4HppGJzQYg&s");
            download(fileURL, "D:\\infa\\Hanipov_11302\\HomeWorks\\src\\main\\java\\hw26_05_2024Number4\\task27" +
                    "\\photo.jpg");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void download(URL fileURL, String path) {
        try (InputStream iS = fileURL.openStream();
            FileOutputStream oS = new FileOutputStream(path)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = iS.read(buffer)) != -1) {
                oS.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
