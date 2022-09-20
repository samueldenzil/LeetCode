// https://leetcode.com/problems/find-duplicate-file-in-system/
package All_Problems;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class FindDuplicateFileInSystem {

    public static void main(String[] args) {
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        System.out.println(findDuplicate(paths));
    }

    public static List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();

        for (String path : paths) {
            String[] pathDir = path.split(" ");
            String dir = pathDir[0];
            for (int i = 1; i < pathDir.length; i++) {
                storeInHash(dir, pathDir[i], map);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for (String content : map.keySet()) {
            List<String> list = map.get(content);
            if (list.size() > 1) {
                ans.add(new ArrayList<>(map.get(content)));
            }
        }
        return ans;
    }

    private static void storeInHash(String dir, String fileName, Map<String, List<String>> map) {
        StringBuilder sb = new StringBuilder(dir);
        if (dir.charAt(dir.length() - 1) != '/') {
            sb.append('/');
        }
        StringBuilder content = new StringBuilder();
        int i = 0;
        while (i < fileName.length()) {
            char c = fileName.charAt(i);
            if (c == '(') {
                while (c != ')') {
                    c = fileName.charAt(i);
                    content.append(c);
                    i++;
                }
            } else {
                sb.append(c);
            }
            i++;
        }
        if (!map.containsKey(content.toString())) {
            map.put(content.toString(), new ArrayList<>());
        }
        List<String> list = map.get(content.toString());
        list.add(sb.toString());
        map.put(content.toString(), list);
    }
}
