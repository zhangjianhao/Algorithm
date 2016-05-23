package com.zjianhao.dynamic;

/**
 * Created by 张建浩（Clarence) on 2016-5-18 11:19.
 * the author's website:http://www.zjianhao.cn
 * the author's github: https://github.com/zhangjianhao
 */

public class LCS2 {
    String x = "abdba";
    char [] m = x.toCharArray();
    String y = "dbaaba";
    char [] n = y.toCharArray();
    int [][] a = new int[x.length()+1][y.length()+1];//save the state
    char[][] flag = new char[x.length()+1][y.length()+1];
    public static void main(String[] args) {
        LCS2 lcs = new LCS2();
        int result = lcs.lcs();

        System.out.println(result);
//        lcs.printPath();



    }

    public void init(){
        for (int i = 0; i < a.length; i++) {
            for (int j=0; j<a[0].length; j++)
                a[i][j] = 0;
        }
    }


    /**
     * 递推法计算最长公共子序列
     * @return 最长公共子序列长度
     */
    public int lcs(){
        for (int i=0; i<m.length; i++){//0行0列初始化为0
            a[i][0] = 0;
            a[0][i] = 0;
        }
        for (int i=1; i<=m.length; i++)
            for (int j=1; j<=n.length; j++){
                if (m[i-1] == n[j-1])
                    a[i][j] = a[i-1][j-1] + 1;
                else
                    a[i][j] = Math.max(a[i][j-1],a[i-1][j]);
            }
        return a[m.length][n.length];
    }



//    public void printPath(){
////        for (int i=1; i<=m.length; i++){
////
////            for (int j=1; j<=n.length; j++){
////                System.out.print(flag[i][j]);
////            }
////            System.out.println();
////        }
//        int x = m.length;
//        int y = n.length;
//
//        while (x>0 && y>0){
//            if (flag[x][y] == '↖'){
//                x--;
//                y--;
//                System.out.println(m[a[x][y]]);
//            }else if ( flag[x][y] == '↑'){
//                y--;
//            }else
//                x--;
//
//        }
//
//    }



}
