import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CountingSortTest {
    @Test
    public void testsort() {
        CountingSort countsorting = new CountingSort();
        int[] ar = { 2, 5, 3, 0, 2, 3,0, 3 };
        countsorting.sort(ar);
        assertArrayEquals(new int [] {0, 0, 2, 2, 3, 3, 3, 5}, ar);
    }

    @Test
    public void single_test_sort() {
        CountingSort countsorting = new CountingSort();
        int[] ar = {2};
        countsorting.sort(ar);
        assertArrayEquals(new int [] {2}, ar);
    }

    @Test
    public void null_testing_sort() {
        CountingSort countsorting = new CountingSort();
        int[] ar = {};
        countsorting.sort(ar);
        assertArrayEquals(new int [] {}, ar);
    }

    @Test
    public void count_sort() {
        CountingSort countsorting = new CountingSort();
        int[] ar = {5,3,3,3,2,2,0,0};
        countsorting.sort(ar);
        assertArrayEquals(new int [] {0, 0, 2, 2, 3, 3, 3, 5}, ar);
    }

    @Test
    public void count_test_sort() {
        CountingSort countsorting = new CountingSort();
        int[] ar = {2,9,8,4,2,4,9,12,8,12,8};
        countsorting.sort(ar);
        assertArrayEquals(new int [] {2,2,4,4,8,8,8,9,9,12,12,}, ar);
    }
}