package com.bigcow.cn.code.bytedance.bfs;

public class CorporateFlightBookings1109Solution {

    // 暴力解法
    //    public int[] corpFlightBookings(int[][] bookings, int n) {
    //        int[] answer = new int[n];
    //        for (int i = 0; i < bookings.length; i++) {
    //            int first = bookings[i][0] - 1;
    //            int last = bookings[i][1] - 1;
    //            int seats = bookings[i][2];
    //            for (int j = first; j <= last; j++) {
    //                answer[j] += seats;
    //            }
    //        }
    //        return answer;
    //    }

    // 差分数组
    // 在first 位置 置为 seats, 在last + 1 的位置设置-seats
    // https://mp.weixin.qq.com/s?__biz=Mzg4OTYzODM4Mw==&mid=2247486996&idx=1&sn=b19efe632df2fecb34e55efc4c20e3f6&chksm=cfe99294f89e1b824ee4500c437e0666f336a8b8b59fd2c411fc1b502d18de1c9c93ebdd4cd7&mpshare=1&scene=1&srcid=0408zbkdIyWzS7BfWGlDTvP3&sharer_sharetime=1649561337491&sharer_shareid=d49745f49939a9aa83741bd80a279ea6&exportkey=AXgGboeRuPXIBjvUaQBtGmY%3D&acctmode=0&pass_ticket=sD6lsV2%2FKSxmX1klPc6P4d7OPxWez8P9Aq%2FUjVLKJ1Z1m1fqKkCz6daZFpJTfAI0&wx_header=0#rd
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diffArr = new int[n + 1];
        for (int i = 0; i < bookings.length; i++) {
            int first = bookings[i][0] - 1;
            int last = bookings[i][1] - 1;
            int seats = bookings[i][2];
            diffArr[first] += seats;
            diffArr[last + 1] -= seats;
        }

        int[] answer = new int[n];
        answer[0] = diffArr[0];
        for (int i = 1; i < n; i++) {
            answer[i] = diffArr[i] + answer[i - 1];
        }
        return answer;
    }

}
