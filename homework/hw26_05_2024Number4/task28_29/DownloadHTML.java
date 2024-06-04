package hw26_05_2024Number4.task28_29;

import java.net.MalformedURLException;
import java.net.URL;

import static hw26_05_2024Number4.task27.Task27.download;

public class DownloadHTML {

    public static void main(String[] args) {
        try {
            URL fileURL = new URL("https://cs1.htmlacademy.ru/content/blog/1331/index.html");
            download(fileURL, "D:\\infa\\Hanipov_11302\\HomeWorks\\src\\main\\java\\hw26_05_2024Number4\\task28_29" +
                    "\\html.txt");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
