package sort;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class QuickSortTest {

  @Test
  public void testCase1() {
    int[] arr = {3, 10, 2, 7, 1, 8, 5, 9, 4, 6};
    new QuickSort().quickSort(arr, 0, arr.length - 1);

    assertEquals(arr[0], 1);
    assertEquals(arr[1], 2);
    assertEquals(arr[2], 3);
    assertEquals(arr[3], 4);
    assertEquals(arr[4], 5);
    assertEquals(arr[5], 6);
    assertEquals(arr[6], 7);
    assertEquals(arr[7], 8);
    assertEquals(arr[8], 9);
    assertEquals(arr[9], 10);
  }
}
