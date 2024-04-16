/**
 * Name: Annanya Jain
 * Pledge: I pledge my honor that I have abided by the Stevens Honor System
 */
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TreapTest {

    @Test
    public void testConstructorTreap(){
        Treap treap = new Treap();
        assertNull(treap.getRoot());
        assertNotNull(treap.getPriorityGenerator());
    }
    @Test
    public void testadd() {
        Treap<String> testStrTree = new Treap <>();
        assertTrue(testStrTree.add("p",99));
        assertTrue(testStrTree.add("g",80));
        assertFalse(testStrTree.add("g",80));
        assertTrue(testStrTree.add("u",75));
        assertTrue(testStrTree.add("a",60));
        assertTrue(testStrTree.add("j",65));
        assertTrue(testStrTree.add("r",40));
        assertTrue(testStrTree.add("z",47));
        assertFalse(testStrTree.add(null,2));
        assertTrue(testStrTree.add("w",32));
        assertTrue(testStrTree.add("v",21));
        assertTrue(testStrTree.add("x",25));
        assertTrue(testStrTree.add("i",93));

        Treap<Integer> testTree = new Treap <Integer >();
        assertTrue(testTree.add(4,19));
        assertFalse(testTree.add(4,19));
        assertTrue(testTree.add(2,31));
        assertTrue(testTree.add(6,70));
        assertTrue(testTree.add(1,84));
        assertFalse(testTree.add(null,19));
        assertTrue(testTree.add(3,12));
        assertTrue(testTree.add(5,83));
        assertTrue(testTree.add(7,26));
    }

    @Test
    public void delete() {

        Treap<Integer> testTree = new Treap <Integer >();
        testTree.add(4,19);
        testTree.add(2,31);
        testTree.add(6,70);
        testTree.add(1,84);
        testTree.add(3,12);
        testTree.add(5,83);
        testTree.add(7,26);

        assertTrue(testTree.delete(4));
        assertFalse(testTree.delete(4));
        assertTrue(testTree.delete(2));
        assertTrue(testTree.delete(6));
        assertTrue(testTree.delete(1));
        assertFalse(testTree.delete(null));
        assertTrue(testTree.delete(3));
        assertTrue(testTree.delete(5));
        assertTrue(testTree.delete(7));

        Treap<String> testStrTree = new Treap <>();
        testStrTree.add("p",99);
        testStrTree.add("g",80);
        testStrTree.add("u",75);
        testStrTree.add("a",60);
        testStrTree.add("j",65);
        testStrTree.add("r",40);
        testStrTree.add("z",47);
        testStrTree.add("w",32);
        testStrTree.add("v",21);
        testStrTree.add("x",25);
        testStrTree.add("i",93);

        assertTrue(testStrTree.delete("g"));
        assertFalse(testStrTree.delete("g"));
        assertTrue(testStrTree.delete("u"));
        assertTrue(testStrTree.delete("a"));
        assertTrue(testStrTree.delete("j"));
        assertTrue(testStrTree.delete("r"));
        assertTrue(testStrTree.delete("z"));
        assertFalse(testStrTree.delete(null));
        assertTrue(testStrTree.delete("w"));
        assertTrue(testStrTree.delete("v"));
        assertFalse(testStrTree.delete("q"));
        assertTrue(testStrTree.delete("x"));
        assertTrue(testStrTree.delete("i"));

    }

    @Test
    public void find() {
        Treap<String> testStrTree = new Treap <>();
        testStrTree.add("p",99);
        testStrTree.add("g",80);
        testStrTree.add("u",75);
        testStrTree.add("a",60);
        testStrTree.add("j",65);
        testStrTree.add("r",40);
        testStrTree.add("z",47);
        testStrTree.add("w",32);
        testStrTree.add("v",21);
        testStrTree.add("x",25);
        testStrTree.add("i",93);

        assertTrue(testStrTree.find("p"));
        assertTrue(testStrTree.find("j"));
        testStrTree.delete("u");
        assertFalse(testStrTree.find("u"));
        assertTrue(testStrTree.find("j"));
        assertTrue(testStrTree.find("w"));
        assertTrue(testStrTree.find("v"));
        assertFalse(testStrTree.find("q"));
        assertFalse(testStrTree.find(null));
        assertTrue(testStrTree.find("i"));
        assertTrue(testStrTree.find("x"));
        assertTrue(testStrTree.find("z"));
    }
    @Test
    public void testToString() {

        Treap<Integer> testTree = new Treap<Integer>();
        testTree.add(4,19);
        testTree.add(2,31);
        testTree.add(6,70);
        testTree.add(1,84);
        testTree.add(3,12);
        testTree.add(5,83);
        testTree.add(7,26);

        String expected = "(key=1, priority=84)\n" +
                "  null\n" +
                "  (key=5, priority=83)\n" +
                "    (key=2, priority=31)\n" +
                "      null\n" +
                "      (key=4, priority=19)\n" +
                "        (key=3, priority=12)\n" +
                "          null\n" +
                "          null\n" +
                "        null\n" +
                "    (key=6, priority=70)\n" +
                "      null\n" +
                "      (key=7, priority=26)\n" +
                "        null\n" +
                "        null\n";

        String actual = testTree.toString();
        assertEquals(expected, actual);

        Treap<String> testStrTree = new Treap <>();
        testStrTree.add("p",99);
        testStrTree.add("g",80);
        testStrTree.add("u",75);
        testStrTree.add("a",60);
        testStrTree.add("j",65);
        testStrTree.add("r",40);
        testStrTree.add("z",47);
        testStrTree.add("w",32);
        testStrTree.add("v",21);
        testStrTree.add("x",25);
        testStrTree.add("i",93);

        String expected_output = "(key=p, priority=99)\n" +
                "  (key=i, priority=93)\n" +
                "    (key=g, priority=80)\n" +
                "      (key=a, priority=60)\n" +
                "        null\n" +
                "        null\n" +
                "      null\n" +
                "    (key=j, priority=65)\n" +
                "      null\n" +
                "      null\n" +
                "  (key=u, priority=75)\n" +
                "    (key=r, priority=40)\n" +
                "      null\n" +
                "      null\n" +
                "    (key=z, priority=47)\n" +
                "      (key=w, priority=32)\n" +
                "        (key=v, priority=21)\n" +
                "          null\n" +
                "          null\n" +
                "        (key=x, priority=25)\n" +
                "          null\n" +
                "          null\n" +
                "      null\n";

        String actual_output = testStrTree.toString();
        assertEquals(expected_output, actual_output);
    }
}