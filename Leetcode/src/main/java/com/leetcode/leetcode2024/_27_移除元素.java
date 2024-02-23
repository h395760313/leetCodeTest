package com.leetcode.leetcode2024;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/remove-element/description/
 *
 * @author xiehongyu
 * @date 2024/2/23 19:54
 */
public class _27_移除元素 {


    public int removeElement(int[] nums, int val) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        int index = 0;
        boolean flag = false;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == val) {
                index = mid;
                flag = true;
                break;
            } else if (nums[mid] < val) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (!flag) {
            return nums.length;
        }
        int fIndex = index;
        int lIndex = index;
        while (fIndex > 0 && nums[fIndex - 1] == nums[fIndex]) {
            fIndex--;
        }
        while (lIndex < nums.length - 1 && nums[lIndex + 1] == nums[lIndex]) {
            lIndex++;
        }
        lIndex++;
        while (lIndex < nums.length) {
            nums[fIndex++] = nums[lIndex++];
        }
        return fIndex;
    }



    public int removeElement2(int[] nums, int val) {
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == val) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return nums.length;
        }
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }        return index;
    }


    @Test
    public void test() {
        System.out.println(JSON.toJSONString(removeElement2(new int[]{2,3,3}, 2)));
    }
}
