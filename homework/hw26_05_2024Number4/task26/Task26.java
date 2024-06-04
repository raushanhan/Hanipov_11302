package hw26_05_2024Number4.task26;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task26 {

    public static void main(String[] arr) {

        rewriteFile("D:\\infa\\Hanipov_11302\\HomeWorks\\src\\main\\java" +
                "\\hw26_05_2024Number4\\task26\\maglumatlar.txt",
                "D:\\infa\\Hanipov_11302\\HomeWorks\\src\\main\\java" +
                "\\hw26_05_2024Number4\\task26\\rewritten.txt");
    }

    public static void rewriteFile(String readFilePath, String writeFilePath) {
        try (
                FileInputStream reader = new FileInputStream(readFilePath);
                FileOutputStream writer = new FileOutputStream(writeFilePath);
        ) {
            int firstByte;
            while ((firstByte = reader.read()) != -1) {
                if (firstByte == 208) // cyrillic symbols in utf-8 are coded by two bytes, first of which
                    // can be 208 or 209
                {
                    int secondByte = reader.read();
                    if (144 <= secondByte && secondByte <= 191) {
                        writer.write(secondByte + 48);
                    } else if (secondByte == 129) { // Ё
                        writer.write(secondByte + 39);
                    } else {
                        writer.write(firstByte);
                        writer.write(secondByte);
                    }
                } else if (firstByte == 209) {
                    int secondByte = reader.read();
                    if (128 <= secondByte && secondByte <= 143) {
                        writer.write(secondByte + 112);
                    } else if (secondByte == 145) { // ё
                        writer.write(secondByte + 39);
                    } else {
                        writer.write(firstByte);
                        writer.write(secondByte);
                    }
                } else {
                    writer.write(firstByte); // if the symbol is a number or from "-,:" range, then it is
                    // coded similarly to windows 1251
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
