/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

 说明：每次只能向下或者向右移动一步。

 示例:

 输入:
 [
 [1,3,1],
 [1,5,1],
 [4,2,1]
 ]
 输出: 7
 解释: 因为路径 1→3→1→1→1 的总和最小。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/minimum-path-sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    /**
     * 暴力法递归
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        return caculate(grid[0][0]+Math.min(caculate([0][1],0,1),caculate([1][0],1,0)));

    }

    public int caculate(int[][] grid,int i,int j){
        if (i == grid[0].length-1 && j == grid.length-1)return grid[i][j];
        if (i > grid[0].length-1 || j > grid.length-1) return Integer.MAX_VALUE;
        return  grid[i][j]+Math.min(caculate([i][j+1],i,j+1),caculate([i+1][j],i+1,j));
    }
}

/**
 * 动态规划
 */
class Solution {
    /**
     *  二维动态规划
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int[][] caculateRes = new int[grid.length][grid[0].length];
        for (int i = grid.length-1 ; i>=0 ; i--){
            for (int j = grid[i].length-1 ; j >=0;j-- ){
                int t = 0;
                if (i == grid.length-1 && j == grid[i].length-1 ){
                    t = grid[i][j];
                }else if (j == grid[i].length-1){
                    t = grid[i][j]+caculateRes[i+1][j];
                }else if ( i == grid.length-1 ){
                    t = grid[i][j]+caculateRes[i][j+1];
                }else {
                    t = grid[i][j] + Math.min(caculateRes[i][j+1],caculateRes[i+1][j]);
                }

                caculateRes[i][j] = t;
            }
        }
        return caculateRes[0][0];
    }


}

class Solution {
    /**
     * 一维动态规划
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int[] caculateRes = new int[grid[0].length];
        int k = grid[0].length - 1;
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[i].length - 1; j >= 0; j--) {
                int t = 0;
                if (i == grid.length - 1 && j == grid[i].length - 1) {
                    t = grid[i][j];
                } else if (j == grid[i].length - 1) {
                    t = grid[i][j] + caculateRes[j];
                } else if (i == grid.length - 1) {
                    t = grid[i][j] + caculateRes[j + 1];
                } else {
                    t = grid[i][j] + Math.min(caculateRes[j], caculateRes[j + 1]);
                }
                caculateRes[j] = t;
            }
        }
        return caculateRes[0];
    }
}