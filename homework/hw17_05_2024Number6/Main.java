package hw17_05_2024Number6;


import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        String[] cities = new String[]{"Kazan", "Elabuga", "Moskva", "Menzelinsk", "Washington", "Almetyevsk", "Seoul"};

        String outputPath = "D:\\infa\\Hanipov_11302\\classwork\\classWorks\\src\\main\\java\\cw20240511\\weather.csv";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));

            Map<String, Object> map;

            writer.write("city, temperature, date\n");
            for (String city : cities) {
                try {
                    URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" +
                            city + "&appid=403f63e43fe6d3a233ae9e12ff883fe6");
                    URLConnection connection = url.openConnection();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                    String json = reader.readLine();
                    //System.out.println(json);
                    map = (Map<String, Object>) parseJson(json);

                    //printMap(map);

                    Map<String, Object> weather = (Map<String, Object>) map.get("\"main\"");
                    //System.out.println(map.get("\"main\""));
                    double temp = Double.parseDouble((String) weather.get("\"temp\""));

                    //int dateInMillis = Integer.parseInt((String) map.get("\"dt\""));
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                    String dateString = sdf.format(new Date(System.currentTimeMillis()));

                    writer.write(city + ", " + ((int) ((temp - 273.15) * 10)) / (double) 10 + ", " + dateString + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static Object parseJson(String json) {
        Map<String, Object> res = new LinkedHashMap<>();

        char first = json.charAt(0);
        char last = json.charAt(json.length() - 1);

        if (first == '{' && last == '}') {
            List<String> parsing = splitByASymbol(json.substring(1, json.length() - 1), ',');
            for (String elem : parsing) {
                List<String> splitted = splitByASymbol(elem, ':');
                String key = splitted.get(0);
                String value = splitted.get(1);
                res.put(key, parseJson(value));
            }
        } else if (first == '[' && last == ']') {
            String parsing = json.substring(1, json.length() - 1);
            return parseJson(parsing);
        } else {
            return json;
        }
        return res;
    }
    
    public static List<String> splitByASymbol(String line, char symbol) {
        List<String> res = new ArrayList<>();
        int newStart = 0;
        boolean bracketIsOpened = false;
        for (int i = 0; i < line.length(); i++) {
            char currChar = line.charAt(i);
            if (currChar == '{' || currChar == '[') {
                bracketIsOpened = true;
            } else if (currChar == '}' || currChar == ']') {
                bracketIsOpened = false;
            }
            if (currChar == symbol && !bracketIsOpened) {
                res.add(line.substring(newStart, i));
                newStart = i + 1;
            }
        }
        res.add(line.substring(newStart));
        return res;
    }

    public static void printMap(Map<String, Object> map) {

        System.out.println(map.keySet());

    }
}

/*{"coord":{"lon":49.1242,"lat":55.7824},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],
        "base":"stations","main":{"temp":286.47,"feels_like":286.16,"temp_min":284.17,"temp_max":286.55,"pressure":1014,
        "humidity":88,"sea_level":1014,"grnd_level":1001},"visibility":10000,"wind":{"speed":4.54,"deg":356,"gust":8.38},
        "rain":{"1h":0.24},"clouds":{"all":99},"dt":1715962356,"sys":{"type":1,"id":9038,"country":"RU","sunrise":1715905674,
        "sunset":1715964728},"timezone":10800,"id":551487,"name":"Kazan","cod":200}*/
