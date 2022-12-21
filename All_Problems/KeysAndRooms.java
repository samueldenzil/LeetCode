// https://leetcode.com/problems/keys-and-rooms/
package All_Problems;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class KeysAndRooms {

    public static void main(String[] args) {
        int[][] roomsArr = {{1}, {2}, {3}, {}};
        List<List<Integer>> rooms = new ArrayList<>();
        for (int i = 0; i < roomsArr.length; i++) {
            rooms.add(new ArrayList<>());
        }
        for (int u = 0; u < roomsArr.length; u++) {
            for (int j = 0; j < roomsArr[u].length; j++) {
                int v = roomsArr[u][j];
                rooms.get(u).add(v);
            }
        }
        System.out.println(canVisitAllRooms(rooms));
    }

    // DFS Solution
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];

        dfs(0, rooms, vis);

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                return false;
            }
        }
        return true;
    }

    private static void dfs(int node, List<List<Integer>> rooms, boolean[] vis) {
        vis[node] = true;
        for (int it : rooms.get(node)) {
            if (!vis[it]) {
                dfs(it, rooms, vis);
            }
        }
    }


    // BFS Solution
    /* public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        vis[0] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int it : rooms.get(node)) {
                if (!vis[it]) {
                    queue.add(it);
                    vis[it] = true;
                }
            }
        }

        for (boolean it : vis) {
            if (!it) {
                return false;
            }
        }
        return true;
    } */
}
