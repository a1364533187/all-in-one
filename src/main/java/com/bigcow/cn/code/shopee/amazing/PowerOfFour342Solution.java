package com.bigcow.cn.code.shopee.amazing;

public class PowerOfFour342Solution {

    public static void main(String[] args) {
        System.out.println(4&3);
        System.out.println(isPowerOfFour(4));
        System.out.println(isPowerOfFour(8));
    }

    /**
     * https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247491591&idx=1&sn=173f4ec5a15e79ec22e122ffe4585934&chksm=fb427327cc35fa3158dfe1f7af2a06ac1bda83d88fff452c24f2002ebf588777874a45b2780e&mpshare=1&scene=1&srcid=0217UBfnGkpcQLVG9Ad0Vprz&sharer_sharetime=1645101639884&sharer_shareid=f03c4319346a005bf50732273ea98e4c&exportkey=AeuzCGa9rviBOpZ5B4Xekw4%3D&acctmode=0&pass_ticket=UbDeonkG6O5RcXL9YjZBjcboBhUBL0Mf8CLuQX17%2B3FzTcIBgvta31n5eeGd4Ds1&wx_header=0#rd
     * @param n
     * @return
     */
    public static boolean isPowerOfFour(int n) {
        return n > 0 && ((n & (n-1)) == 0) && (n & 0xaaaaaaaa) == 0;
    }
}
