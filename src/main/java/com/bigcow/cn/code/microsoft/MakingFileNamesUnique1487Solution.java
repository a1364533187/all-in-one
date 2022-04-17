package com.bigcow.cn.code.microsoft;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingFileNamesUnique1487Solution {

    public static void main(String[] args) {
        //        String[] names = { "pes", "fifa", "gta", "pes(2019)" };
        //        String[] res = getFolderNames(names);

        //        String[] names = { "gta","gta(1)","gta","avalon" };
        //        String[] res = getFolderNames(names);

        //        String[] names = { "onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece" };
        //        String[] res = getFolderNames(names);

        //        String[] names = { "kaido", "kaido(1)", "kaido", "kaido(1)" };
        //        String[] res = getFolderNames(names);

        String[] names = { "kaido", "kaido(1)", "kaido", "kaido(1)", "kaido(2)" };
        String[] res = getFolderNames(names);

    }

    public static String[] getFolderNames(String[] names) {
        String[] res = new String[names.length];
        Set<String> normalSet = new HashSet<>();
        Set<String> resSet = new HashSet<>();
        Map<String, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            // 判断文件是否存在
            if (normalSet.contains(names[i]) || resSet.contains(names[i])) {
                int k = freqMap.getOrDefault(names[i], 1);
                while (true) {
                    String newName = names[i] + "(" + k + ")";
                    if (!resSet.contains(newName)) {
                        freqMap.put(names[i], k);
                        resSet.add(newName);
                        res[i] = newName;
                        break;
                    }
                    k++;
                }
            } else {
                res[i] = names[i];
                resSet.add(names[i]);
            }
            normalSet.add(names[i]);
        }
        return res;
    }
}
