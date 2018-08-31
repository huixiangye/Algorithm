package leetcode.HashMap.基于HashMap的各种系统设计;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yehuixiang on 8/30/18.
 * Note: This is a companion problem to the System Design problem: Design TinyURL.
 TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

 Design the encode and decode methods for the TinyURL service.
 There is no restriction on how your encode/decode algorithm should work.
 You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 */
public class Encode_and_DecodeTinyURL_535 {
    Map<Integer, String> map = new HashMap<>();
    int i = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(i, longUrl);
        return "http://tinyurl.com/" + i++;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }
}
