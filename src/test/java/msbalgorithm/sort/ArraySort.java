package msbalgorithm.sort;

public class ArraySort {

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

    public Integer[] mergeSort1(Integer[] arr) {
        int mid = arr.length >> 1;
        int i = 0;
        int j = mid + 1;
        int k = 0;

        Integer[] res = new Integer[arr.length];
        while (i <= mid || j < arr.length) {
            if (i > mid) {
                res[k++] = arr[j++];
            }else if (j >= arr.length) {
                res[k++] = arr[i++];
            }else {
                res[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
            }
        }
        return res;
    }

    public Integer[] mergeSort2(Integer[] arr) {
        Integer mid = arr.length >> 1;
        Integer i = 0;
        Integer j = mid + 1;
        Integer k = 0;
        Integer[] newArr = new Integer[arr.length];
        while (i <= mid && j < arr.length) {
            newArr[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) newArr[k++] = arr[i++];
        while (j < arr.length) newArr[k++] = arr[j++];
        return newArr;
    }

    /**
     * 07.快速排序
     *
     * @Author: xiehy
     * @Date: 2021/3/5
     */
    public void quickSort(Integer[] arr) {

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
