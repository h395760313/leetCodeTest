package msbalgorithm.sort;

public class ArraySort {

    /**
     * 01.选择排序
     * 循环遍历选最小放前面 指针指向最小数
     *
     * @Author: xiehy
     * @Date: 2021/3/5
     */
    public int[] selectionSort1(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int point = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[point] > arr[j]) {
                    point = j;
                }
            }
            if (point != i) swap(arr,point,i);
        }
        return arr;
    }

    /**
     * 01.选择排序
     * 循环遍历选最大放后面 指针指向最大数
     *
     * @Author: xiehy
     * @Date: 2021/3/5
     */
    public int[] selectionSort2(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int point = i;
            for (int j = 0; j < i; j++) {
                if (arr[point] < arr[j]){
                   point = j;
                }
                swap(arr,point,i);
            }
        }
        return arr;
    }


    /**
     * 02.冒泡排序
     * 思路：每轮遍历将最大的放到最后，并在下次遍历中忽略此数
     * @Author: xiehy
     * @Date: 2021/3/5
     */
    public int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]){
                    swap(arr,j,j + 1);
                    flag = false;
                }
            }
            if (flag) break;
        }
        return arr;
    }

    /**
     * 03.插入排序
     *
     * @Author: xiehy
     * @Date: 2021/3/5
     */
    public int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j >= 1 && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
        return arr;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    /**
     * 04.堆排序
     *
     * @Author: xiehy
     * @Date: 2021/3/5
     */
    public int[] heapSort(int[] arr) {
        // todo
        return arr;
    }

    /**
     * 05.希尔排序
     * <p>
     * knuth 序列 h = h * 3 + 1
     *
     * @Author: xiehy
     * @Date: 2021/3/5
     */
    public int[] shellSort(int[] arr) {
        int h = 1;
        while (h < arr.length / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < arr.length; i++) {
                for (int j = i; j > h - 1; j -= h) {
                    if (arr[j] < arr[j - 1]) {
                        swap(arr, j, j - 1);
                    }
                }
            }
            h = (h - 1) / 3;
        }
        return arr;
    }

    /**
     * 06.归并排序
     *
     * @Author: xiehy
     * @Date: 2021/3/5
     */

    public int[] mergeSort1(int[] arr) {
        int mid = arr.length >> 1;
        int i = 0;
        int j = mid + 1;
        int k = 0;
        int[] newArr = new int[arr.length];
        while (i <= mid && j < arr.length) {
            newArr[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) newArr[k++] = arr[i++];
        while (j < arr.length) newArr[k++] = arr[j++];
        return newArr;
    }

    public int[] mergeSort2(int[] arr) {
        int mid = arr.length >> 1;
        int i = 0;
        int j = mid + 1;
        int k = 0;
        int[] newArr = new int[arr.length];
        while (i <= mid && j < arr.length) {
            newArr[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) newArr[k++] = arr[i++];
        while (j < arr.length) newArr[k++] = arr[j++];
        return newArr;
    }

    public int[] mergeSort3(int[] arr) {
        int mid = arr.length >> 1;
        int i = 0;
        int j = mid + 1;
        int k = 0;
        int[] newArr = new int[arr.length];
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
    public int[] quickSort(int[] arr) {

        return arr;
    }

    /**
     * 08.桶排序
     *
     * @Author: xiehy
     * @Date: 2021/3/5
     */
    public int[] bucketSort(int[] arr) {

        return arr;
    }

    /**
     * 09.计数排序
     *
     * @Author: xiehy
     * @Date: 2021/3/5
     */
    public int[] countingSort(int[] arr) {

        return arr;
    }

    /**
     * 10.基数排序
     *
     * @Author: xiehy
     * @Date: 2021/3/5
     */
    public int[] radixSort(int[] arr) {

        return arr;
    }
}
