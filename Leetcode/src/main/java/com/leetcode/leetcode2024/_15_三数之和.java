package com.leetcode.leetcode2024;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;

/**
 * https://leetcode.cn/problems/3sum/
 *
 * @Author: xiehongyu
 * @Date: 2024/2/22 20:59
 */
public class _15_三数之和 {

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        int i = 0;
        while (i < nums.length - 2) {
            while (i < nums.length - 2 && i > 0 && nums[i] == nums[i - 1]) {
                i++;
            }
            if (nums[i] > 0) {
                break;
            }
            int j = i + 1;
            int k = nums.length - 1;

            while (k > j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    if (nums[k] + nums[k - 1] < 0) {
                        break;
                    }
                    j++;
                } else if (sum > 0) {
                    if (nums[i] + nums[j] > 0) {
                        break;
                    }
                    k--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
                while (j < k && j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                }
                while (j < k && k < nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                }
            }
            i++;
        }

        return res;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 2) {
            if (nums[i] > 0) {
                break;
            }
            while (i < nums.length - 2 && i > 0 && nums[i] == nums[i - 1]) {
                i++;
            }
            int j = i + 1;

            while (j < nums.length - 1) {
                while (j < nums.length - 1 && j > i + 1 && nums[j] == nums[j-1]) {
                    j++;
                }
                int flag = -(nums[i] + nums[j]);
                int l = j+1;
                int r = nums.length - 1;
                while (l <= r) {
                    int mid = (l + r) / 2;
                    if (nums[mid] < flag) {
                        l = mid + 1;
                    }else if (nums[mid] > flag) {
                        r = mid - 1;
                    }else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[mid]));
                        break;
                    }
                }
                j++;
            }
            i++;
        }
        return res;
    }

    // TODO 未完成
    public List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 2) {
            if (nums[i] > 0) {
                break;
            }
            while (i < nums.length - 2 && i > 0 && nums[i] == nums[i - 1]) {
                i++;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (map.containsKey(nums[j])) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[map.get(nums[j])]));
                    continue;
                }
                map.put(-nums[i] - nums[j], j);
            }
            i++;
        }
        return res;
    }

    @Test
    public void test() {
//        System.out.println(JSON.toJSONString(threeSum(new int[]{0,0,0,0})));

//        Random random1 = new Random();
//        Random random2 = new Random();
//        int num[] = new int[100];
//        for (int i = 0; i < 100; i++) {
//            num[i] = random1.nextInt(100) + -random2.nextInt(100);
//        }
//        System.out.println(JSON.toJSONString(num));

        System.out.println(JSON.toJSONString(threeSum3(new int[]{23,-21,0,28,-24,-18,-86,85,-71,-5,-14,38,-38,31,15,-51,-11,3,-41,60,-91,6,17,18,-31,-5,1,-24,17,-90,-16,-36,-19,26,-33,3,-77,-1,19,-49,52,14,-37,-3,-62,-37,10,-69,3,21,24,-51,35,53,22,11,-68,0,21,-12,37,-27,-6,29,69,-53,63,-24,4,75,-33,-17,-39,50,-43,-11,-36,-38,32,7,-11,45,16,32,-22,-33,89,7,33,-8,18,63,-6,39,91,7,19,70,-33,-46})));
        // -4, -1, -1, 0, 1, 2
    }


  /**
   * 以下是最优解，供参考
   * @Author: xiehongyu
   * @Date: 2024/2/22 23:01
   */
    public List<List<Integer>> threeSum(int[] nums) {
        return nSum(nums, 3, 0);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        return nSum(nums, 4, target);
    }

    public List<List<Integer>> nSum(int[] nums, int k, int target) {
        return new AbstractList<List<Integer>>() {
            final List<List<Integer>> res = new ArrayList<>();
            final List<Integer> path = new ArrayList<>();
            long min;

            @Override
            public List<Integer> get(int index) {
                init();
                return res.get(index);
            }

            @Override
            public int size() {
                init();
                return res.size();
            }

            public void init() {
                if (res.isEmpty()) {
                    int n = nums.length;
                    long[] Arr = new long[n];
                    Arrays.sort(nums);
                    min = nums[0];
                    for (int i = 0; i < n; i++) {
                        Arr[i] = nums[i] - min;
                    }
                    long NewTarget = (long)target - (long)k * min;
                    C(false, Arr, n, k, NewTarget);
                }
            }

            //C(n, k) = C(n - 1, k) + C(n - 1, k - 1)
            public void C(boolean T, long[] a, int n, int k, long target) {
                if (n == 0 || k == 0) {
                    if (target == 0 && k == 0) {
                        res.add(new ArrayList<>(path));
                    }
                    return;
                }
                if (k == 2) {
                    if (!T && n != a.length && a[n] == a[n - 1]) {
                        return;
                    }
                    //两数之和模板
                    twoSum(a, 0, n - 1, target);
                    return;
                }
                if (n == k) {
                    if (!T && n != a.length && a[n] == a[n - 1]) {
                        return;
                    }
                    //数组中元素和是否等于target
                    sumArr(a, n, target);
                    return;
                }
                if (check(a, n, k, target)) {
                    return;
                }
                C(false, a, n - 1, k, target);
                if (!T && n != a.length && a[n] == a[n - 1]) {
                    return;
                }
                if (target - a[n - 1] >= 0) {
                    path.add((int) (a[n - 1] + min));
                    C(true, a, n - 1, k - 1, target - a[n - 1]);
                    path.remove(path.size() - 1);
                }
            }

            void twoSum(long[] a, int l, int r, long target) {
                if (l >= r || a[r - 1] + a[r] < target || a[l] + a[l + 1] > target) {
                    return;
                }
                while (r > l) {
                    long sum = a[l] + a[r];
                    if (sum < target) {
                        l++;
                    } else if (sum > target) {
                        r--;
                    } else {
                        path.add((int) (a[l] + min));
                        path.add((int) (a[r] + min));
                        res.add(new ArrayList<>(path));
                        path.remove(path.size() - 1);
                        path.remove(path.size() - 1);
                        while (r > l && a[l] == a[l + 1]) {
                            l++;
                        }
                        while (r > l && a[r] == a[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    }
                }
            }

            void sumArr(long[] a, int n, long target) {
                for (int i = n - 1; i > -1; i--) {
                    target -= a[i];
                    path.add((int) (a[i] + min));
                }
                if (target == 0) {
                    res.add(new ArrayList<>(path));
                }
                for (int i = n - 1; i > -1; i--) {
                    target += a[i];
                    path.remove(path.size() - 1);
                }
            }

            boolean check(long[] a, int n, int k, long target) {
                if (n - k < 0) {
                    return true;
                }
                long max = 0;
                long min = 0;
                for (int i = 0; i < k; i++) {
                    min += a[i];
                    max += a[n - i - 1];
                }
                if (target < min || target > max) {
                    return true;
                }
                return false;
            }
        };
    }
}
