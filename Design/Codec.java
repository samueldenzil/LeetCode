// https://leetcode.com/problems/encode-and-decode-tinyurl/
package Design;

import java.util.Map;
import java.util.HashMap;

public class Codec {

    Map<String, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = "http://tinyurl.com/" + map.size();
        map.put(key, longUrl);
        return key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }

    public static void main(String[] args) {
        Codec obj = new Codec();
        String url = "https://leetcode.com/problems/design-tinyurl";
        String shortUrl = obj.encode(url);
        System.out.println(obj.decode(shortUrl));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));