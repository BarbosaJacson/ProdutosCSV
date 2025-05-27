import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fr = null;
        Scanner scanner = new Scanner(System.in);
        BufferedReader br = null;
        //Diretório = "C:\\Users\\Jackson\\Desktop\\exerciciosJava\\lista.csv";
        List<Device> list = new ArrayList<>();

        System.out.print("Enter the file path: ");
        String path = scanner.nextLine();
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                System.out.println(line);
                line = br.readLine();
                Device device = new Device(fields[0], Double.parseDouble(fields[1]), Integer.parseInt(fields[2]));
                list.add(device);
                   }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.print("Enter the output path of the file: ");
        File outFolder = new File(scanner.nextLine());
        //diretório = "C:\\Users\\Jackson\\Desktop\\exerciciosJava\\out");
        if (!outFolder.exists()) {
            outFolder.mkdir();}

        String summaryPath = "C:\\Users\\Jackson\\Desktop\\exerciciosJava\\out\\summary.csv";
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(summaryPath));
            for (Device e : list) {
                System.out.println(e.getName() + ": " + e.total());
                bw.write(e.getName() + ": " + e.total());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

