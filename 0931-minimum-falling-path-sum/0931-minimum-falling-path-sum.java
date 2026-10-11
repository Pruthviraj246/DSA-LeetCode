class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = -1;
            }
        }
        // int mini = Integer.MAX_VALUE;
        // for (int j = 0; j < col; j++) {
        //     mini = Math.min(mini, mem(row - 1, j, matrix, dp));
        // }
        // return mini;

        return tab(matrix,dp);
    }

    static int mem(int n, int m, int[][] matrix, int[][] dp) {
        // n=row
        // m=col
        int row = matrix.length;
        int col = matrix[0].length;
        if (m < 0 || m >= col)
            return (int) (1e9);
        if (n == 0)
            return matrix[0][m];
        if (dp[n][m] != -1)
            return dp[n][m];
        int up = matrix[n][m] + mem(n - 1, m, matrix, dp);
        int left = matrix[n][m] + mem(n - 1, m - 1, matrix, dp);
        int right = matrix[n][m] + mem(n - 1, m + 1, matrix, dp);
        dp[n][m] = Math.min(up, Math.min(left, right));
        return dp[n][m];
    }

    static int tab(int[][] matrix, int[][] dp) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int j = 0; j < col; j++) {
            dp[0][j] = matrix[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int up = matrix[i][j] + dp[i - 1][j];
                int left = (int) 1e9;
                int right = (int) 1e9;
                if (j > 0)
                    left = matrix[i][j] + dp[i - 1][j - 1];
                if (j < col - 1)
                    right = matrix[i][j] + dp[i - 1][j + 1];
                dp[i][j] = Math.min(up, Math.min(left, right));
            }
        }
        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < col; j++) {
            mini = Math.min(mini, dp[row - 1][j]);
        }
        return mini;
    }
}