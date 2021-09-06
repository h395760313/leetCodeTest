package msbalgorithm.sort;

import org.junit.Test;

public class SortTest {

//    int[] arr = {9, 3, 1, 4, 6, 8, 7, 5, 2};
    int[] arr = {9,6,11,3,5,12,8,7,10,15,14,4,1,13,2};
//    int[] arr = {10,2,3,4,5,6,7,8,9,1};
    ArraySort arraySort = new ArraySort();

    @Test
    public void selectionSortTest(){
        int[] ints = arraySort.selectionSort2(arr);
        sout(ints);
    }

    @Test
    public void bubbleSortTest(){
        int[] ints = arraySort.bubbleSort(arr);
        sout(ints);
    }

    @Test
    public void insertionSortTest(){
        int[] ints = arraySort.insertionSort(arr);
        sout(ints);
    }


    @Test
    public void shellSortTest() {
        int[] ints = arraySort.shellSort(arr);
        sout(ints);
    }

    @Test
    public void mergeSortTest() {
        int[] arr1 = new int[]{2, 4, 7, 8, 3, 6, 9};

//        int[] ints = arraySort.mergeSort1();
        int[] ints = arraySort.mergeSort2(arr1);
//        int[] ints = arraySort.mergeSort3();
        sout(ints);
    }










    private void sout(int[] ints) {
        for (int i : ints) {
            System.out.print(i + "\t");
        }
    }

    @Test
    public void test() {
        int a = 3;
        int b = 5;
        a = a ^ b;
        System.out.println(a);
        b = a ^ b;
        System.out.println(b);
        a = a ^ b;
        System.out.println(a);
    }

}
