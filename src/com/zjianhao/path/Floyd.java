package com.zjianhao.path;

/**
 * Created by 张建浩（Clarence) on 2016-5-20 11:40.
 * the author's website:http://www.zjianhao.cn
 * the author's github: https://github.com/zhangjianhao
 */

public class Floyd {
    /**
     * 0    99     8     7     6     5     4     3     2     1
     99    0     99    8     7     6     5     4     3     2
     8    99     0     99   8      7     6     5     4     3
     7     8     99    0    99     8     7     6     5     4
     C＝  6    7      8     99   0      99    8     7     6     5
     5    6      7     8    99     0     99    8     7     6
     4    5      6     7    8      99    0     99    8     7
     3    4      5     6    7      8     99     0    99    8
     */
    private int [][] d = {
            {0  ,  99,     8 ,    7 ,    6  ,   5 ,    4 ,    3  ,   2   ,  1 },
            {99 ,   0,     99,    8 ,    7  ,   6 ,    5 ,    4  ,   3   ,  2},
            {8  ,  99,     0 ,    99,   8   ,   7 ,    6 ,    5  ,   4   ,  3},
            {7  ,   8,     99,    0 ,   99  ,   8 ,    7 ,    6  ,   5   ,  4},
            {6  ,  7 ,     8 ,    99,   0   ,   99,    8 ,    7  ,   6   ,  5},
            {5  ,  6 ,     7 ,    8 ,   99  ,   0 ,    99,    8  ,   7   ,  6},
            {4  ,  5 ,     6 ,    7 ,   8   ,   99,    0 ,    99 ,   8   ,  7},
            {3  ,  4 ,     5 ,    6 ,   7   ,   8 ,    99,     0 ,   99  ,  8},
            {2  ,  3 ,     4 ,    5 ,   6   ,   7 ,    8 ,     99,   0   ,  99},
            {1  ,  2 ,     3 ,    4 ,   5   ,   6 ,    7 ,     8 ,   99  ,  0},
    };
    public static void main(String[] args) {
        Floyd floyd = new Floyd();
        floyd.floyd();
        floyd.printpath();



    }


    public void floyd(){
        for (int k=0; k<d.length; k++)
            for (int i=0; i<d.length; i++)
                for (int j=0; j<d.length; j++)
                    d[i][j] = Math.min(d[i][j],d[i][k]+d[k][j]);

    }

    public void printpath(){
        for (int i=0; i<d.length; i++){
            for (int j=0; j<d.length; j++)
                System.out.print(d[i][j]+" ");
            System.out.println();
        }
    }

}
