import java.io.*;
import java.util.Scanner;

public class Ex11 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String firstWord = scanner.next();
        String secondWord = scanner.next();

        try (Scanner reader = new Scanner(new BufferedReader(new FileReader("TextInput.txt"))); BufferedWriter writer = new BufferedWriter(new FileWriter("TextOutput.txt"))) {
            while (reader.hasNext()) {
                String nextLine = reader.nextLine();
                nextLine = nextLine.replaceAll(firstWord, secondWord);
                writer.write(nextLine + "\n");
            }
        }catch (FileNotFoundException e){
            System.out.println("Input file doesn't exist");
        }
        catch (IOException e) {
            System.out.println("An error has occured");
            e.printStackTrace();
        }
    }
}
