package com.bigcow.cn.code.shopee;

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyurl535Solution {

    // url hash + base64编码 变短

    int count = 0;
    Map<Integer, String> map = new HashMap<Integer, String>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        count++;
        map.put(count, longUrl);
        return "http://tinyurl.com/" + count;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int count = Integer.parseInt(shortUrl.replace("http://tinyurl.com/", ""));
        return map.get(count);
    }
}
