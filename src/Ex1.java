import java.io.*;
import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String firstWord = scanner.next();
        String secondWord = scanner.next();
        StringBuilder text = new StringBuilder();

        try(Scanner reader = new Scanner(new BufferedReader(new FileReader("TextInput.txt")))){
            while (reader.hasNext()){
                text.append(reader.nextLine() + "\n");
            }
        }
        catch (IOException e){
            System.out.println("File not found");
            e.printStackTrace();
        }

        String processedText = text.toString().replaceAll(firstWord,secondWord);

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("TextInput.txt"))){
                writer.write(processedText);
        }
        catch (IOException e){
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
}
