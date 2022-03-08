package com.bigcow.cn.hot100;

public class MedianOfTwoSortedArrays4Solution {

    public static void main(String[] args) {
        int[] nums1 = { 1, 3 };
        int[] nums2 = { 2 };
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    /**
     * https://www.yinxiang.com/everhub/note/3b91bf89-894f-49be-be84-fb303de515ec
     * @param nums1
     * @param nums2
     * @return
     */
    /**
     * 1、A[i-1]  <=B[j] && B[j-1] <= A[i] 符合条件
     * 2、iMin 右移  B[j-1] > A[i]
     * 3、iMax 左移 A[i-1]  > B[j]
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (i < iMax && nums2[j - 1] > nums1[i]) {
                iMin = i + 1;
            } else if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            } else {
                // 计算leftMax
                int leftMax;
                if (i == 0) {
                    leftMax = nums2[j - 1];
                } else if (j == 0) {
                    leftMax = nums1[i - 1];
                } else {
                    leftMax = Math.max(nums2[j - 1], nums1[i - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return leftMax;
                }
                int rightMin;
                // 计算rightMin
                if (i == m) {
                    rightMin = nums2[j];
                } else if (j == n) {
                    rightMin = nums1[i];
                } else {
                    rightMin = Math.min(nums1[i], nums2[j]);
                }
                return (leftMax + rightMin) / 2.0;
            }
        }
        return 0.0;
    }

}
