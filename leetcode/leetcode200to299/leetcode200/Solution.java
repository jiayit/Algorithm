package leetcode200to299.leetcode200;

// UnionFind O(4 * n2)
class Island {
    int[] father;
    public void UnionFind (int m, int n) {
        father = new int[m * n];
        for (int i = 0; i < father.length; i++) {
            father[i] = i; 
        }
    }
    public int find (int x) {
        if (x == father[x]) {
            return x;
        }
        return father[x] = find(father[x]);
    }
    public void union (int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        if (root1 != root2) {
            father[root1] = root2;
        }
    }
    public int convertId (int x, int y, int n) {
        return x * n + y;
    }
    public int numIslands(String[][] grid) {
        if (grid.length == 0) return 0; 
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] flag = new boolean[m][n];
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};
        UnionFind(m, n);
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!flag[i][j] && grid[i][j].equals("1")) {
                    count++;
                    flag[i][j] = true;
                    for (int h = 0; h < 4; h++) {
                        int nx = i + dx[h];
                        int ny = j + dy[h];
                        if (nx >= 0 && nx < m && ny >= 0 && ny < n && flag[nx][ny]) {
                            int id1 = convertId(i, j, n);
                            int id2 = convertId(nx, ny, n);
                            if (find(id1) != find(id2)) {
                                union(id1, id2);
                                count--;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
//dfs(n2) 
class DFS {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0; 
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] flag = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !flag[i][j]) {
                    dfs(i, j, m, n, grid, flag); 
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs (int a, int b, int m, int n, char[][] grid,boolean[][] flag) {
        if (a < 0 || a >= m || b < 0 || b >= n) return;

        if (grid[a][b] == '1' && !flag[a][b]) {
            flag[a][b] = true;
            dfs(a + 1, b, m, n, grid, flag);
            dfs(a, b + 1, m, n, grid, flag);
            dfs(a - 1, b, m, n, grid, flag);
            dfs(a, b - 1, m, n, grid, flag);
        }
    }
}
public class Solution {

    public static void main (String[] args) {
        String[][] nums = {{"1","1","1","1","0"},{"1","1","0","1","0"},{"1","1","0","0","0"},{"0","0","0","1","1"}};
        String[][] nums1 = {{"1"},{"1"}};
        Island island = new Island();
        System.out.println(island.numIslands(nums));
        System.out.println(4>3.5);
    }
}
