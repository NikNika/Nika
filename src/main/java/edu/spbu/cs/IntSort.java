package edu.spbu.cs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by artemaliev on 07/09/15.
 */
public class IntSort {
  public static void sort (int array[]) {
    //Arrays.sort(array);
    mergeSort(array);
  }

  public static void sort (List<Integer> list) {
    Collections.sort(list);
  }
   private static int[] mergeSort(int[] a) {
        if (a.length > 1) {
            int left = a.length / 2;
            int right = a.length - left;
            int[] up = mergeSort(Arrays.copyOf(a, left));
            int[] down = mergeSort(Arrays.copyOfRange(a, left, a.length));
            int i = 0, j = 0, n = 0;
            while (i < up.length || j < down.length) {
                if (i < left && j < right) {
                    if (up[i] < down[j]) {
                        a[n] = up[i];
                        i++;
                    } else {
                        a[n] = down[j];
                        j++;
                    }
                } else if (i < left) {
                    a[n] = up[i];
                    i++;
                } else {
                    a[n] = down[j];
                    j++;
                }
                n++;
            }
        }
        return a;
    }
}
