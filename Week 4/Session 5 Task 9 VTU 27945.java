class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {

        int m = mat.length;
        int n = mat[0].length;

        int[][] answer = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int sum = 0;

                int r1 = Math.max(0, i - k);
                int r2 = Math.min(m - 1, i + k);

                int c1 = Math.max(0, j - k);
                int c2 = Math.min(n - 1, j + k);

                for (int r = r1; r <= r2; r++) {
                    for (int c = c1; c <= c2; c++) {
                        sum += mat[r][c];
                    }
                }

                answer[i][j] = sum;
            }
        }

        return answer;
    }
}
