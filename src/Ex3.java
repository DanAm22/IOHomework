import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ex3 {

    public static String[] getWords(){
        StringBuilder text = new StringBuilder();
        try (Scanner scanner = new Scanner(System.in)){
            while (true) {
                String word = scanner.next().toLowerCase();
                if(word.equals("quit")){
                    break;
                }
                text.append(word + " ");
            }
        }
        return text.toString().split("\\W+");
    }

    public static String maxLength(String[] words){
        int count = Integer.MIN_VALUE;
        String maxWord = "";
        for(String word : words){
            if(word.length() > count){
                maxWord = word;
                count = word.length();
            }
        }
        return maxWord;
    }


    public static String minLength(String[] words){
        int count = Integer.MAX_VALUE;
        String minWord = "";
        for(String word : words){
            if(word.length() < count){
                minWord = word;
                count = word.length();
            }
        }
        return minWord;
    }


    public static void main(String[] args) {

        String[] words = getWords();
        Arrays.sort(words);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("OutputEx3.txt"))) {
            writer.write("Longest word is: " + maxLength(words) + "\n");
            writer.write("Shortest word is: " + minLength(words) + "\n");
            writer.write("First alphabetic word is: " + words[0] + "\n");
            writer.write("Last alphabetic word is: " + words[words.length - 1] + "\n");
            writer.write("Number of words is: " + words.length + "\n");

        } catch (IOException e) {
            System.out.println("Something went wrong...");
            e.printStackTrace();
        }
    }
}
