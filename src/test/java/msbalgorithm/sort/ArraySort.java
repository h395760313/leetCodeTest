package msbalgorithm.sort;

import sun.awt.geom.AreaOp;

import java.util.Arrays;

public class ArraySort {

    private static Integer[] arr;

    /**
     * 01.选择排序
     * 循环遍历选最小放前面 指针指向最小数
     *
     * @Author: xiehy
     * @Date: 2021/3/5
     */
    public void selectionSort1(Integer[] arr) {
        for (Integer i = 0; i < arr.length - 1; i++) {
            Integer poInteger = i;
            for (Integer j = i + 1; j < arr.length; j++) {
                if (arr[poInteger] > arr[j]) {
                    poInteger = j;
                }
            }
            if (poInteger != i) swap(arr,poInteger,i);
        }
    }

    /**
     * 01.选择排序
     * 循环遍历选最大放后面 指针指向最大数
     *
     * @Author: xiehy
     * @Date: 2021/3/5
     */
    public void selectionSort2(Integer[] arr) {
        for (Integer begin = 0,end = arr.length - 1; end >= 0; end--) {
            Integer maxIndex = 0;
            for (Integer j = begin; j <= end; j++) {
                if (arr[j] >= arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != end) swap(arr,maxIndex,end);
        }
    }


    /**
     * 02.冒泡排序
     * 思路：每轮遍历将最大的放到最后，并在下次遍历中忽略此数
     * @Author: xiehy
     * @Date: 2021/3/5
     */
    public void bubbleSort(Integer[] arr) {
        for (Integer i = 0; i < arr.length; i++) {
            for (Integer j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 03.插入排序
     *
     * @Author: xiehy
     * @Date: 2021/3/5
     */
    public void insertionSort(Integer[] arr) {
        for (Integer i = 1; i < arr.length; i++) {
            Integer j = i;
            while (j >= 1 && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }

    private void swap(Integer[] arr, Integer a, Integer b) {
        Integer temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    /**
     * 04.堆排序
     *
     * @Author: xiehy
     * @Date: 2021/3/5
     */
    public void heapSort(Integer[] arr) {
        // todo
    }

    /**
     * 05.希尔排序
     * <p>
     * knuth 序列 h = h * 3 + 1
     *
     * @Author: xiehy
     * @Date: 2021/3/5
     */
    public void shellSort(Integer[] arr) {
        Integer h = 1;
        while (h < arr.length / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (Integer i = h; i < arr.length; i++) {
                for (Integer j = i; j > h - 1; j -= h) {
                    if (arr[j] < arr[j - 1]) {
                        swap(arr, j, j - 1);
                    }
                }
            }
            h = (h - 1) / 3;
        }
    }

    /**
     * 06.归并排序
     *
     * @Author: xiehy
     * @Date: 2021/3/5
     */
    public Integer[] mergeSort1(Integer[] arr1) {
        int begin = 0;
        int end = arr1.length;
        arr = Arrays.copyOfRange(arr1, begin, end);
        sort1(begin, end);
        return arr;
    }

    private void sort1(int begin, int end) {

        if (end - begin < 2) return;

        int mid = (begin + end) >> 1;
        sort1(begin, mid);
        sort1(mid, end);
        merge1(begin, mid, end);
    }

    private void merge1(int begin, int mid, int end) {
        int li = 0, le = mid - begin,
                ri = mid, re = end,
                ai = begin;

        int[] leftArr = new int[arr.length >> 1];

        for (int i = li; i < le; i++) {
            leftArr[i] = arr[begin + i];
        }

        while (li < le) {
            if (ri < re && leftArr[li] > arr[ri]){
                arr[ai++] = arr[ri++];
            }else {
                arr[ai++] = leftArr[li++];
             }
        }

    }

    /**
     * 07.快速排序
     *
     * @Author: xiehy
     * @Date: 2021/3/5
     */
    public Integer[] quickSort(Integer[] arr1) {
        int begin = 0;
        int end = arr1.length - 1;
        arr = Arrays.copyOfRange(arr1, begin, end + 1);

        quickSort(0, end);

        return arr;
    }

    private void quickSort(int begin, int end) {
        int p = begin, q = end;
        int mid = (begin + end) >> 1;
        // 方向  true为从左往右  false为从右往左
        boolean dire = false;
        int temp = arr[0];

        while (begin < end) {

            if (dire) {
                // 从左往右
                if (arr[begin] >= temp) {
                    arr[end--] = arr[begin];
                    dire = !dire;
                }else {
                    begin++;
                }
            }else {
                // 从右往左
                if (arr[end] <= temp) {
                    arr[begin++] = arr[end];
                    dire = !dire;
                }else {
                    end--;
                }
            }
        }
        arr[begin] = temp;
        quickSort(begin, begin - 1);
        quickSort(begin + 1, q);
    }

    /**
     * 08.桶排序
     *
     * @Author: xiehy
     * @Date: 2021/3/5
     */
    public void bucketSort(Integer[] arr) {

    }

    /**
     * 09.计数排序
     *
     * @Author: xiehy
     * @Date: 2021/3/5
     */
    public void countingSort(Integer[] arr) {

    }

    /**
     * 10.基数排序
     *
     * @Author: xiehy
     * @Date: 2021/3/5
     */
    public void radixSort(Integer[] arr) {

    }

}
