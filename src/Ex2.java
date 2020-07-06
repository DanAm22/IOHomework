import java.io.*;
import java.util.Scanner;

public class Ex2 {

    public static void main(String[] args) {

        try (Scanner scanner1 = new Scanner(new BufferedReader(new FileReader("Numbers1.txt")));
             Scanner scanner2 = new Scanner(new BufferedReader(new FileReader("Numbers2.txt")));
             BufferedWriter writer = new BufferedWriter(new FileWriter("NumbersMerge.txt"))) {
            if (!scanner1.hasNext()) {
                while (scanner2.hasNext()) {
                    writer.write(scanner2.nextInt() + " ");
                }
            }
            if (!scanner2.hasNext()) {
                while (scanner1.hasNext()) {
                    writer.write(scanner1.nextInt() + " ");
                    writer.write(" ");
                }
            }

            int number1 = scanner1.nextInt();
            int number2 = scanner2.nextInt();
            while (scanner1.hasNext() && scanner2.hasNext()) {
                if (number1 > number2) {
                    writer.write(number2 + " ");
                    number2 = scanner2.nextInt();
                } else {
                    writer.write(number1 + " ");
                    number1 = scanner1.nextInt();
                }
            }

            while (scanner1.hasNext()){
                if(number2 > number1){
                    writer.write(number1 + " ");
                    number1 = scanner1.nextInt();
                }
                else{
                    break;
                }
            }

            while (scanner2.hasNext()){
                if(number1 > number2){
                    writer.write(number2 + " ");
                    number2 = scanner2.nextInt();
                }
                else{
                    break;
                }
            }

            if(number1 > number2){
                writer.write(number2 + " ");
                writer.write(number1 + " ");
            }
            else{
                writer.write(number1 + " ");
                writer.write(number2 + " ");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Input file not found...");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Something went wrong...");
            e.printStackTrace();
        }
    }
}
