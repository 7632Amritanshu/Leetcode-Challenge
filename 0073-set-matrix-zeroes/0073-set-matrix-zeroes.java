class Solution {
    public void setZeroes(int[][] matrix) {
        int n= matrix.length;
        int m = matrix[0].length;
        boolean[][] flag = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    flag[i][j]=true;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(flag[i][j]){
                    set(matrix,i,j);
                }
            }
        }
        
    }
    public void set(int[][] matrix,int i,int j){
        int m = matrix.length;
        int n = matrix[0].length;
        for(int a =0;a<m;a++){
            matrix[a][j]=0;
        }
        for(int b=0;b<n;b++){
            matrix[i][b]=0;
        }
    }

}