/**
 * Name: Annanya Jain
 * I pledge my honor that I have abided by the Stevens Honor System
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Anagrams {
    final Integer[] primes =
            {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                    31, 37, 41, 43, 47, 53, 59, 61, 67,
                    71, 73, 79, 83, 89, 97, 101};
    Map<Character, Integer> letterTable;
    Map<Long, ArrayList<String>> anagramTable;

    /**
     * This method buildLetterTable() is invoked by the constructor for the class Anagrams.
     * It builds the hash table letterTable which will associate each letter in the alphabet with a prime number.
     */

    public void buildLetterTable() {
        letterTable = new HashMap<>();
        char letter = 'a';
        int ind = 0;
        for (int i = 0; i < 26; i++) {
            letterTable.put(letter, primes[ind]);
            letter++;
            ind++;
        }
    }

    /**
     * A constructor Anagrams() which calls the buildLetterTable method.
     * An instance variable anagramTable will hold the main working hash table which will store key and value.
     * Key (of type Long): the hash code of the word.
     * Value (of type ArrayList<String>): a list of the words that have Key as hash code
     */
    public Anagrams() {
        buildLetterTable();
        anagramTable = new HashMap<Long, ArrayList<String>>();
    }

    /**
     * This method addWord() should compute the hash code of the string s passed as argument using myHashCode(), and should
     * add this word to the hash table anagramTable.
     * @param s
     */

    public void addWord(String s) {
        long hash_code= myHashCode(s.toLowerCase());
        if (!anagramTable.containsKey(hash_code)) {
            anagramTable.put(hash_code, new ArrayList<>());
        }
        anagramTable.get(hash_code).add(s);
    }

    /**
     * This method myHashCode(), given a string s, should compute its hash code. All the anagrams of a word have the same hash code.
     * The concept used to calculate is : unique-prime-factorization theorem, which states that every integer greater than 0 either is prime itself or is the product of a
     * unique combination of prime numbers. Thus, for calculating hashcode of a string, unique-prime-factorization theorem is used.
     * @param s
     * @return the hashcode of the string which is given as input.
     */
    public long myHashCode(String s) {
        if(s.isEmpty()){
            throw new IllegalArgumentException("String is Empty");
        }
        long hashcode = 1;
        String lower_string = s.toLowerCase();
        for(char i: lower_string.toCharArray()){
            Integer unique_factorization = letterTable.get(i);
            hashcode *= unique_factorization;
        }
        return hashcode;
    }

    /**
     * The main method is processFile which receives the name of a text file containing words, one per line, and builds the hash table anagramTable.
     * @param s
     * @throws IOException
     */
    public void processFile(String s) throws IOException {
        FileInputStream fstream = new FileInputStream(s);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        while ((strLine = br.readLine()) != null) {
            this.addWord(strLine);
        }
        br.close();
    }

    /**
     * This method getMaxEntries should return the entries in the anagramTable that have the largest number of anagrams.
     * If there are more than one list of anagrams with a maximal size, it returns all those list of anagrams.
     */

    public ArrayList<Map.Entry<Long, ArrayList<String>>> getMaxEntries() {
        ArrayList<Map.Entry<Long, ArrayList<String>>> array = new ArrayList<>();
        int max_entry = 0;
        for (Map.Entry<Long, ArrayList<String>> i : anagramTable.entrySet()) {
            if (i.getValue().size() < max_entry) ;
            else if (i.getValue().size() > max_entry) {
                array.clear();
                array.add(i);
                max_entry = i.getValue().size();
            } else {
                array.add(i);
            }
        }
        return array;
    }

    /**
     * The main method will read all the strings in a file, place them in the hash table of anagrams
     * and then iterate over the hash table to report which words have the largest number of anagrams.
     * @param args
     */
    public static void main(String[] args) {
        Anagrams a = new Anagrams();
        final long startTime = System.nanoTime();
             try {
                 a.processFile("words_alpha.txt");
             } catch (IOException e1) {
                 e1.printStackTrace();
             }
             ArrayList<Map.Entry<Long, ArrayList<String>>> maxEntries = a.getMaxEntries();
             final long estimatedTime = System.nanoTime() - startTime;
             final double seconds = ((double) estimatedTime / 1000000000);
             System.out.println("Time: " + seconds);
             System.out.println("List of max anagrams: " + maxEntries);
    }
}