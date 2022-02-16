package com.bigcow.cn.code.shopee;

import java.util.Random;

public class ImplementRand10UsingRand7_470Solution extends SolBase {

    /**
     * https://note.youdao.com/web/#/file/recent/note/caf437f6c3640cda9b69e4967bb02c53/
     * @return
     */
    public int rand10() {
        while (true) {
            int val = (rand7()-1)*7 + rand7();
            if (val <= 10) {
                return val;
            }
        }
    }
}

class SolBase {

    public int rand7() {
        Random r = new Random();
        int val = r.nextInt(7);
        return val;
    };
}
