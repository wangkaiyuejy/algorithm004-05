/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？



 网格中的障碍物和空位置分别用 1 和 0 来表示。

 说明：m 和 n 的值均不超过 100。

 示例 1:

 输入:
 [
   [0,0,0],
   [0,1,0],
   [0,0,0]
 ]
 输出: 2
 解释:
 3x3 网格的正中间有一个障碍物。
 从左上角到右下角一共有 2 条不同的路径：
 1. 向右 -> 向右 -> 向下 -> 向下
 2. 向下 -> 向下 -> 向右 -> 向右

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/unique-paths-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    [[0,0],
     [1,1],
     [0,0]]
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] dp = new int[obstacleGrid[0].length];
        for (int i = 0 ; i<obstacleGrid.length;i++){
            for (int j = 0; j<obstacleGrid[i].length;j++){
                if (i == 0 && j == 0){
                    if (obstacleGrid[i][j] == 0){
                        dp[j] = 1;
                    }else {
                        dp[j] = 0;
                        i = obstacleGrid[i].length;
                        break;
                    }

                }else if (i == 0 && obstacleGrid[i][j] ==1){
                    break;
                }else if (i == 0 && obstacleGrid[i][j] !=1){
                    dp[j] = 1;
                }else if (j == 0 && obstacleGrid[i][j] ==1){
                    dp[j] = 0;
                }else if (j == 0 && obstacleGrid[i][j] !=1){
                    if (dp[j] == 0){
                        dp[j] = 0;
                    }else {
                        dp[j] = 1;
                    }

                }else {
                    if (obstacleGrid[i][j] ==1){
                        dp[j] = 0;
                    }else {
                        dp[j] = dp[j-1]+dp[j];
                    }
                }
            }
        }

        return dp[obstacleGrid[0].length-1];

    }
}