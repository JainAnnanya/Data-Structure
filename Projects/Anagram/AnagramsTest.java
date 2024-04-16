/**
 * Name: Annanya Jain
 * I pledge my honor that I have abided by the Stevens Honor System
 */

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
public class AnagramsTest {

    @Test
    public void buildLetterTable() {
        Anagrams anagram = new Anagrams();
        anagram.buildLetterTable();
        HashMap<Character, Integer> testing = new HashMap<>();
        testing.put('a', 2);
        testing.put('b', 3);
        testing.put('c', 5);
        testing.put('d', 7);
        testing.put('e', 11);
        testing.put('f', 13);
        testing.put('g', 17);
        testing.put('h', 19);
        testing.put('i', 23);
        testing.put('j', 29);
        testing.put('k', 31);
        testing.put('l', 37);
        testing.put('m', 41);
        testing.put('n', 43);
        testing.put('o', 47);
        testing.put('p', 53);
        testing.put('q', 59);
        testing.put('r', 61);
        testing.put('s', 67);
        testing.put('t', 71);
        testing.put('u', 73);
        testing.put('v', 79);
        testing.put('w', 83);
        testing.put('x', 89);
        testing.put('y', 97);
        testing.put('z', 101);
        assertEquals(testing, anagram.letterTable);
    }

    @Test
    public void addWord() {
        Anagrams anagram = new Anagrams();
        anagram.addWord("alerts");
        anagram.addWord("alters");
        anagram.addWord("artels");
        anagram.addWord("estral");
        anagram.addWord("laster");
        anagram.addWord("lastre");
        anagram.addWord("rastle");
        anagram.addWord("ratels");
        anagram.addWord("heart");
        anagram.addWord("earth");
        ArrayList<String> output = new ArrayList<>();
        output.add("alerts");
        output.add("alters");
        output.add("artels");
        output.add("estral");
        output.add("laster");
        output.add("lastre");
        output.add("rastle");
        output.add("ratels");
        ArrayList<String> out = new ArrayList<>();
        out.add("heart");
        out.add("earth");
        long hash = anagram.myHashCode("alerts");
        long ha = anagram.myHashCode("heart");
        assertEquals(output, anagram.anagramTable.get(hash));
        assertEquals(out, anagram.anagramTable.get(ha));
    }

    @Test
    public void myHashCode() {
        Anagrams a = new Anagrams();
        assertEquals(236204078L, a.myHashCode("alerts"));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> a.addWord(""));
        assertEquals("String is Empty", exception.getMessage());
        assertEquals(236204078L, a.myHashCode("atlers"));
        assertEquals(236204078L, a.myHashCode("estral"));
        assertEquals(a.myHashCode("Annanya"), a.myHashCode("aynanna"));
        assertNotEquals(a.myHashCode("Trail"), a.myHashCode("icetr"));
    }
    @Test
    public void testGetMaxEntries() {
        Anagrams a = new Anagrams();
        a.addWord("alerts");
        a.addWord("alters");
        a.addWord("artels");
        a.addWord("estral");
        a.addWord("laster");
        a.addWord("lastre");
        a.addWord("rastle");
        a.addWord("ratels");
        a.addWord("relast");
        a.addWord("resalt");
        a.addWord("heart");
        a.addWord("earth");
        a.addWord("a");
        a.addWord("bd");
        a.addWord("db");
        Anagrams b = new Anagrams();
        b.addWord("brag");
        b.addWord("grab");
        b.addWord("garb");
        b.addWord("heart");
        b.addWord("earth");
        b.addWord("rthae");
        b.addWord("lost");
        b.addWord("solt");
        ArrayList<String> anagrams = new ArrayList<>(Arrays.asList("alerts", "alters", "artels", "estral", "laster", "lastre", "rastle", "ratels", "relast", "resalt"));
        assertEquals(anagrams, a.getMaxEntries().get(0).getValue());
        assertEquals(236204078L, a.getMaxEntries().get(0).getKey());
        ArrayList<String> anagram1 = new ArrayList<>(Arrays.asList("brag","grab", "garb"));
        ArrayList<String> anagram2 = new ArrayList<>(Arrays.asList("heart","earth", "rthae"));
        assertEquals(anagram1, b.getMaxEntries().get(1).getValue());
        assertEquals(anagram2, b.getMaxEntries().get(0).getValue());
        assertEquals(6222L, b.getMaxEntries().get(1).getKey());
        assertEquals(1810358L, b.getMaxEntries().get(0).getKey());
    }
}