package com.bigcow.cn.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams49Solution {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    // ["eat", "tea", "tan", "ate", "nat", "bat"]
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> flattenSortStrMap = new HashMap<>();
        //给每个字符串转换成chars
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sortedStr = getString(chars);
            if (flattenSortStrMap.containsKey(sortedStr)) {
                List<String> list = flattenSortStrMap.get(sortedStr);
                list.add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                flattenSortStrMap.put(sortedStr, list);
            }
        }
        // 遍历 flattenSortStrMap
        for (String key : flattenSortStrMap.keySet()) {
            res.add(flattenSortStrMap.get(key));
        }
        return res;
    }

    private static String getString(char[] chars) {
        String str = "";
        for (int i = 0; i < chars.length; i++) {
            str += chars[i];
        }
        return str;
    }
}
