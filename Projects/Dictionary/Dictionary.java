//Name : Annanya Jain
//Section : CS 284 - C
//Pledge : I pledge my honor that I have abided by the Stevens Honor System.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
    // Two Data fields
    // "wordList" - an arraylist that stores words
    // "dictArrayList" - stores DictionaryItems (word-count pairs)
    ArrayList<DictionaryItem> dictArrayList;
    ArrayList<String> wordList;

    public Dictionary() { // constructor for initialising two arraylist data fields.
        wordList = new ArrayList<>(1300);
        dictArrayList = new ArrayList<>(1300);
        File name = new File("ionDictionary.txt");
        readFile("ionDictionary.txt");


    }

    public Dictionary(String filename) {   // constructor for initialising two arraylist data fields
        wordList = new ArrayList<>(1300);
        dictArrayList = new ArrayList<>(1300);
        readFile(filename);
    }

    public void readFile(String filename) {
        // This method stores the words in wordList and the word-count pair in dictArrayList fields.
        Scanner c;
        try {
            File name = new File(filename);
            c = new Scanner(name);
            while (c.hasNextLine()) {
                splitStoreLine(c);
            }
            c.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        }
    }

    private void splitStoreLine(Scanner scan) {
        //This helper method splits the line read from the file and store the word-count pairs in the defined arraylist.
        String str = "";
        int l = 0;
        String[] sr;
        scan.nextLine();
        scan.nextLine();
        scan.nextLine();
        scan.nextLine();
        while (scan.hasNextLine()) {
            str = scan.nextLine();
            try {
                sr = str.split(" | ");
                dictArrayList.add(new DictionaryItem(sr[0], Integer.parseInt(sr[sr.length - 1])));
                wordList.add(sr[0]);

            } catch (NumberFormatException e) {
                continue;
            }
        }
    }

    public void printMenu() {
        //It prints 3 menu items and receives a number from the user which indicates the operation user chooses.
        Scanner scan = new Scanner(System.in);
        // Scanner object is used to read text input from the user or from a file.
        int choice=0;
        // the input received from user is stored in the choice variable
        boolean Cond = true;
        System.out.println("Welcome to the Ion Dictionary! This dictionary is created from the book Ion by Plato!");
        while (Cond) {
            System.out.println("Please choose one of the following menu items indicated with 1-3");
            System.out.println("1: To print all the words in the dictionary, choose 1");
            System.out.println("2: To search a word in the dictionary, choose 2");
            System.out.println("3: To quit the program, choose 3");
            try {
                choice = Integer.parseInt(scan.nextLine());
                if (choice > 3 || choice < 1) {
                    throw new IllegalArgumentException();
                }

            } catch (IllegalArgumentException e) {
                System.out.println("ERROR! Please enter a number between 1 and 3.");
                continue;
            }
            Cond = processMenuItem(choice, scan);
        }
    }

    private boolean processMenuItem(int menuItem, Scanner scan) {
        // Helper method that takes two inputs :
        // 1. operation that user chose (menuItem)
        // 2. Scanner object to read the word from the user for searching a word in dictionary.
        // It calls the appropriate functions for each operation.

        if (menuItem == 1) {
            System.out.println("All the words mentioned in the Ion book!\nWords\n-----");
            printDictionary();
            return true;

        } else if (menuItem == 2) {
            System.out.println("Please enter the word you would like to search:");
            String word = scan.nextLine();
            // nextLine() is a methods that Scanner object provides for reading an entire line of text.
            if ((searchDictionary(word) == 0)) {
                System.out.println("The word '" + word + "' does not exist in the Ion dictionary!");
            } else {
                System.out.println("The word '" + word + "' occurred " + searchDictionary(word) + " times in the book!");
            }
            return true;
        } else if (menuItem == 3) {
            System.out.println("Thanks for using Ion Dictionary! Bye!");
            return false;

        } else {
            System.out.println("ERROR! Please enter a number between 1 and 3.");
            return true;
        }
    }

    public void printDictionary() {
        // This method prints the word list that we created from the dictionary text file.
        for (int i = 0; i < wordList.size(); i++) {
            System.out.println(wordList.get(i));
        }
    }

    public int searchDictionary(String word) {
        // This method calls the binarySearch() method to search the word in the wordList
        // Using the index of the word in wordList, it returns the count of that word from dictArrayList.
        if (binarySearch(word, 0, wordList.size() - 1) != -1) {
            return dictArrayList.get(binarySearch(word, 0, wordList.size() - 1)).getCount();
        } else {
            return 0;
        }
    }

    private int binarySearch(String word, int low, int high) {
        // This helper method performs the binary search algorithm on the sorted wordlist arraylist that we created.
        int mid = 0;
        while (high >= low) {
            mid = (high + low) / 2;
            if (word.compareTo(wordList.get(mid)) > 0) {
                low = mid + 1;
            } else if (word.compareTo(wordList.get(mid)) < 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
