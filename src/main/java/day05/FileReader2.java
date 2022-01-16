package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReader2 {

    public static void main(String[] args) {
        int min = new FileReader2().findSmallestTemperatureSpread("weather.dat");
        System.out.println(min);
        String name = new FileReader2().findSmallestTeamDifferent("football.dat");
        System.out.println(name);
    }

    public int findSmallestTemperatureSpread(String filename) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/main/resources/day04/" + filename));

            int minSpread = 1000;
            int minDay = 0;

            for (int i = 2; i < lines.size() - 1; i++) {
                int day = Integer.parseInt(lines.get(i).substring(2, 4).trim());
                int max = Integer.parseInt(lines.get(i).substring(6, 8).trim());
                int min = Integer.parseInt(lines.get(i).substring(12, 14).trim());

                int spread = max-min;
                if (minSpread > spread) {
                    minSpread = spread;
                    minDay = day;
                }
            }
            return minDay;
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public String findSmallestTeamDifferent(String filename){
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/main/resources/day04/" + filename));

            int minDifference = 1000;
            String minName = null;

            for (int i = 1; i < lines.size(); i++) {
                if (i != 18) {
                    String name = lines.get(i).substring(7, 22).trim();
                    int max = Integer.parseInt(lines.get(i).substring(43, 45).trim());
                    int min = Integer.parseInt(lines.get(i).substring(50, 52).trim());

                    int spread = Math.abs(max - min);
                    if (minDifference > spread) {
                        minDifference = spread;
                        minName = name;
                    }
                }
            }
            return minName;
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}
