package msbalgorithm.sort;

import com.tools.Asserts;
import com.tools.Integers;
import com.tools.Times;
import org.junit.Test;

public class SortTest {

    Integer[] arr = Integers.random(1000000,10000,10000000);
    ArraySort arraySort = new ArraySort();

    @Test
    public void selectionSortTest(){
        Times.test("测试选择排序", ()-> arraySort.selectionSort2(arr));
        Asserts.test(Integers.isAscOrder(arr));
    }

    @Test
    public void bubbleSortTest(){
        Times.test("测试冒泡排序", ()-> arraySort.bubbleSort(arr));
        Asserts.test(Integers.isAscOrder(arr));
    }

    @Test
    public void insertionSortTest(){
        Times.test("测试插入排序", ()-> arraySort.insertionSort(arr));
        Asserts.test(Integers.isAscOrder(arr));
    }


    @Test
    public void shellSortTest() {
        Times.test("测试希尔排序", ()-> arraySort.shellSort(arr));
        Asserts.test(Integers.isAscOrder(arr));
    }

    @Test
    public void mergeSortTest() {
        Integer[] copy = Integers.copy(arr);
        Times.test("测试归并排序1", ()-> arraySort.mergeSort1(arr));
        Asserts.test(Integers.isAscOrder(arraySort.mergeSort1(arr)));
        Times.test("测试归并排序2", ()-> arraySort.mergeSort2(copy));
        Asserts.test(Integers.isAscOrder(arraySort.mergeSort2(copy)));
    }










    private void sout(Integer[] ints) {
        for (Integer i : ints) {
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
