package Five;

import java.io.*;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class five {

    public static void main(String[] args) throws IOException {

        try (PrintWriter writer = new PrintWriter(new File("file.csv"))) {

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 5; i++) {
                String val = "Value";
                sb.append(val + (i +1) + ";");
            } sb.append('\n');

            for (int i = 0; i < 5; i++) {
                double ran = Math.random() * 100;
                int ran1 = (int) ran;
                sb.append(ran1 + ";");
                for (int j = 0; j < 5; j++) {
                    ran = Math.random() * 100;
                    ran1 = (int) ran;
                    sb.append(ran1 + ";");
                } sb.append('\n');
            } sb.append('\n');


            writer.write(sb.toString());
            writer.close();
            System.out.println("done!");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        five testCSV =  new five();
        testCSV.readCSVFile();
    }

    public void readCSVFile(){
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("file.csv"));) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(records.toString());
    }
    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(";");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }
//        try (BufferedReader reader = new BufferedReader(new FileReader("file"))) {
//            String str;
//            String[] strMass;
//            while ((str = reader.readLine()) != null){
//                strMass = str.split(";");
//                System.out.println(Arrays.toString(strMass));
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//
}