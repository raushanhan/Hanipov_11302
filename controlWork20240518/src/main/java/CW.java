import java.io.*;
import java.util.*;
import java.util.zip.GZIPOutputStream;

public class CW {

    public static void main(String[] args) {
        List<Birth> births = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\infa\\Hanipov_11302\\controlworks\\" +
                "controlWork20240518\\src\\main\\java\\BirthsKingCounty2001.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                births.add(parseLine(line));
            }

            Map<Byte, Double> childrenAndEducation = countChildrenAndEducationStats(births);

            System.out.println(childrenAndEducation);

            System.out.println("the answer is " + computeAvgGestationOfMarriedStats(births));

            createNewFile(births, "D:\\infa\\Hanipov_11302\\controlworks\\controlWork20240518\\src\\main\\java\\reorganizedFile.bin");

            readNewFile(births, "D:\\infa\\Hanipov_11302\\controlworks\\controlWork20240518\\src\\main\\java\\reorganizedFile.bin");

            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void createNewFile(List<Birth> births, String fileName) {
        try (FileOutputStream fosWriter = new FileOutputStream(fileName)) {
            BufferedOutputStream writer = new BufferedOutputStream(fosWriter);

            for (Birth b : births) {
                char gender = b.getGender();
                byte isMarried = b.isMarried() ? (byte) 1 : (byte) 0;
                byte gestation = b.getGestation();

                writer.write(gender);
                writer.write(isMarried);
                writer.write(gestation);
            }

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void readNewFile(List<Birth> births, String fileName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            int data;
            while ((data = fileInputStream.read()) != -1) {
                System.out.println((char) data + " " + (fileInputStream.read() == 1) + " " + fileInputStream.read());
            }
            fileInputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean computeAvgGestationOfMarriedStats(List<Birth> births) {
        OptionalDouble avgGestationOfMarried = births.stream()
                .filter(Birth::isMarried)
                .mapToInt(Birth::getGestation)
                .average();

        OptionalDouble avgGestationOfNotMarried = births.stream()
                .filter(x -> !x.isMarried())
                .mapToInt(Birth::getGestation)
                .average();

        if (avgGestationOfMarried.isPresent() && avgGestationOfNotMarried.isPresent()) {
            System.out.println("married: " + avgGestationOfMarried + "\n" +
                    "not married: " + avgGestationOfNotMarried);
            return avgGestationOfMarried.getAsDouble() < avgGestationOfNotMarried.getAsDouble();
        } else {
            System.out.println("the data is incomplete");
            return false;
        }
    }

    private static Map<Byte, Double> countChildrenAndEducationStats(List<Birth> births) {
        Map<Byte, Short> ChildrenAmountCount = new HashMap<>();
        Map<Byte, Short> ChildrenAndTotalEducation = new HashMap<>();
        for (Birth birth : births) {
            Byte parity = birth.getParity();
            Byte education = birth.getEducation();

            ChildrenAmountCount.computeIfAbsent(parity, k -> (short) 1);
            ChildrenAndTotalEducation.computeIfAbsent(parity, k -> (short) education);
            ChildrenAmountCount.put(parity, (short) (ChildrenAmountCount.get(parity) + 1));
            ChildrenAndTotalEducation.put(parity, (short) (ChildrenAndTotalEducation.get(parity) + education));
        }

        Map<Byte, Double> result = new HashMap<>();
        for (byte key : ChildrenAmountCount.keySet()) {
            result.put(key, (ChildrenAndTotalEducation.get(key) / (double) ChildrenAmountCount.get(key)));
        }
        return result;
    }

    public static Birth parseLine(String line) {
        String[] splittedLine = line.split("\\s+");

        char gender = splittedLine[0].charAt(0);
        byte plural = Byte.parseByte(splittedLine[1]);
        byte age = Byte.parseByte(splittedLine[2]);
        String race = splittedLine[3];
        byte parity = Byte.parseByte(splittedLine[4]);
        boolean married = splittedLine[5].equals("1");
        short bwt = Short.parseShort(splittedLine[6]);
        byte smokeN = Byte.parseByte(splittedLine[7]);
        byte drinkN = Byte.parseByte(splittedLine[8]);
        boolean firstep = splittedLine[9].equals("1");
        boolean welfare = splittedLine[10].equals("1");
        boolean smoker = splittedLine[11].equals("Y");
        boolean drinker = splittedLine[12].equals("Y");
        short wpre = Short.parseShort(splittedLine[13]);
        short wgain = Short.parseShort(splittedLine[14]);
        byte education = Byte.parseByte(splittedLine[15]);
        byte gestation = Byte.parseByte(splittedLine[16]);

        return new Birth(gender, plural, age, race, parity, married, bwt, smokeN, drinkN,
                firstep, welfare, smoker, drinker, wpre, wgain, education, gestation);
    }
}
