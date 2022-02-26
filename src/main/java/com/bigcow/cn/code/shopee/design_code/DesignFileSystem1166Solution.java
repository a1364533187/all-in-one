package com.bigcow.cn.code.shopee.design_code;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/design-file-system/solution/ha-xi-biao-fen-chi-fu-lu-jing-by-shi-huo-de-xia-ti/
 */
public class DesignFileSystem1166Solution {

    Map<String, Integer> pathMap;

    public DesignFileSystem1166Solution() {
        pathMap = new HashMap<>();
        // 缓存根节点路径
        pathMap.put("", -1);
    }

    public boolean createPath(String path, int value) {
        // 没有删除的文件的情况，path只要存在，就一直存在
        if (pathMap.containsKey(path)) {
            return false;// 文件已经存在了，返回false
        }
        // 获取父路径
        int lastIndex = path.lastIndexOf("/");
        String parentPath = path.substring(0, lastIndex);
        // 父路径不存在，则返回false
        if (!pathMap.containsKey(parentPath)) {
            return false;
        }
        // 文件记录
        pathMap.put(path, value);
        return true;
    }

    public int get(String path) {
        return pathMap.getOrDefault(path, -1);
    }
}
