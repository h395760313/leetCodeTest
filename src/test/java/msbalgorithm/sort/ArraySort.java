package msbalgorithm.sort;

import sun.awt.geom.AreaOp;

import java.util.Arrays;

public class ArraySort {

    private static Integer[] arr;

    /**********************************------01.选择排序.start------**********************************/

    //循环遍历选最小放前面 指针指向最小数
    public void selectionSort1(Integer[] arr) {
        for (Integer i = 0; i < arr.length - 1; i++) {
            Integer poInteger = i;
            for (Integer j = i + 1; j < arr.length; j++) {
                if (arr[poInteger] > arr[j]) {
                    poInteger = j;
                }
            }
            if (poInteger != i) swap(arr, poInteger, i);
        }
    }

    //循环遍历选最大放后面 指针指向最大数
    public void selectionSort2(Integer[] arr) {
        for (Integer begin = 0, end = arr.length - 1; end >= 0; end--) {
            Integer maxIndex = 0;
            for (Integer j = begin; j <= end; j++) {
                if (arr[j] >= arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != end) swap(arr, maxIndex, end);
        }
    }
    /**********************************------01.选择排序.end------**********************************/


    /**********************************------02.冒泡排序.start------**********************************/

    // 思路：每轮遍历将最大的放到最后，并在下次遍历中忽略此数
    public void bubbleSort(Integer[] arr) {
        for (Integer i = 0; i < arr.length; i++) {
            for (Integer j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
    /**********************************------02.冒泡排序.end------**********************************/


    /**********************************------03.插入排序.start------**********************************/
    // 思路：可看做是手抓一副扑克牌
    // 待插入数每次与前者比较，如果大于前者则交换，直到不大于前者停止，继续下一个元素
    public void insertionSort1(Integer[] arr) {
        for (Integer i = 1; i < arr.length; i++) {
            Integer j = i;
            while (j >= 1 && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }

    /**
     * 插入排序优化
     * 思路：
     * 先将待插入的数据备份
     * 前面有比待插入数大的向后挪动一个位置
     * 将待插入数插入合适的位置
     */
    public void insertionSort2(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int cmp = arr[i];
            while (j > 0 && cmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j --;
            }
            arr[j] = cmp;
        }
    }

    public void insertionSort(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int index = i;
            int cmp = arr[i];
            int begin = 0, end = i;
            while (begin < end) {
                int mid = (begin + end) >> 1;
                if (arr[mid] < cmp) {
                    end = mid;
                } else {
                     begin = end + 1;
                }
            }
            // 找到比cmp小
            while (j > 0 && cmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j --;
            }
            arr[j] = cmp;
        }
    }
    /**********************************------03.插入排序.end------**********************************/

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
     * 以步长做插入排序e
     *
     * @Author: xiehy
     * @Date: 2021/3/5
     */
    public Integer[] shellSort(Integer[] arr1) {
        arr = Arrays.copyOfRange(arr1, 0, arr1.length);
        int step = 1;
        while (step < arr1.length / 3) {
            step = step * 3 + 1;
        }
        while (step >= 1) {
            for (int col = 0; col < step; col++) {
                for (int begin = col + step; begin < arr.length; begin += step)  {
                    int cur = begin;
                    while (cur > col && arr[cur] < arr[cur - step]){
                        swap(arr, cur, cur - step);
                        cur -= step;
                    }
                }
            }
            step = (step - 1) / 3;
        }
        return arr;
    }

    public void shellSort2(Integer[] arr) {
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
            if (ri < re && leftArr[li] > arr[ri]) {
                arr[ai++] = arr[ri++];
            } else {
                arr[ai++] = leftArr[li++];
            }
        }

    }

    /**
     * 07.快速排序
     * 思路：找到一个轴点，将小于轴点的元素放到轴点左边，大于轴点的元素放到轴点右边。
     * 覆盖一次变一次方向。再根据轴点将序列分割为两个子序列继续进行快速排序
     *
     * @Author: xiehy
     * @Date: 2021/3/5
     */
    public Integer[] quickSort(Integer[] arr1) {
        arr = Arrays.copyOfRange(arr1, 0, arr1.length);

        int begin = 0;
        int end = arr1.length;

        quickSort(begin, end);
        return arr;
    }

    /**
     * 对序列进行快速排序
     */
    private void quickSort(int begin, int end) {
        if (end - begin < 2) return;

        // 找到轴点位置
        int mid = pivotIndex(begin, end);
        // 对子序列进行快速排序
        quickSort(begin, mid);
        quickSort(mid + 1, end);
    }

    private int pivotIndex(int begin, int end) {
        // 随机选择一个元素与begin交换位置
        swap(arr, begin, begin + (int) Math.random() * (end - begin));
        // 备份轴点元素
        int pivot = arr[begin];
        // end指向最后一个元素
        end--;
        while (begin < end) {
            while (begin < end) {
                if (pivot < arr[end]) { // 右边元素大于轴点元素
                    end--;
                } else { // 右边元素小于轴点元素，需要覆盖，变向
                    arr[begin++] = arr[end];
                    break;
                }
            }

            while (begin < end) {
                if (pivot > arr[begin]) { // 左边元素小于轴点元素
                    begin++;
                } else { // 左边元素大于轴点元素，需要覆盖，变向
                    arr[end--] = arr[begin];
                    break;
                }
            }
        }

        arr[begin] = pivot;
        return begin;
    }


    /**
     * 08.桶排序
     *
     * @Author: xiehy
     * @Date: 2021/3/5
     */
    public void bucketSort(Integer[] arr1) {
        arr = Arrays.copyOfRange(arr1, 0, arr1.length);

    }

    /**
     * 09.计数排序
     *
     * @Author: xiehy
     * @Date: 2021/3/5
     */
    public Integer[] countingSort1(Integer[] arr1) {
        arr = Arrays.copyOfRange(arr1, 0, arr1.length);
        // 构建用于存放每个元素出现次数的新数组
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        int[] counts = new int[1 + max];


        for (int i = 0; i < arr.length; i++) {
            counts[arr[i]]++;
        }

        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i]-- > 0) {
                arr[index++] = counts[i];
            }
        }
        return arr;
    }

    public Integer[] countingSort2(Integer[] arr1) {
        arr = Arrays.copyOfRange(arr1, 0, arr1.length);
        // 构建新数组
        int min = arr[0], max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return arr;
    }

    /**
     * 10.基数排序
     *
     * @Author: xiehy
     * @Date: 2021/3/5
     */
    public void radixSort(Integer[] arr1) {
        arr = Arrays.copyOfRange(arr1, 0, arr1.length);

    }

}
