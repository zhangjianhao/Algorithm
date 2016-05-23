package com.zjianhao.path;

import java.util.Scanner;

/**
 * Created by 张建浩（Clarence) on 2016-5-13 19:20.
 * the author's website:http://www.zjianhao.cn
 * the author's github: https://github.com/zhangjianhao
 */


public class Dijstra {
    private int[] d;//从v0到各个定点的距离
    private boolean[] v;//是否访问过标志位
    private int n = 0;
    private int inf = 1000;
    private int[][] weight;//边权矩阵
    private static int source = 0;

    public static void main(String[] args) {
        Dijstra dijstra = new Dijstra();
        dijstra.input();
        dijstra.dijstra(source);
        dijstra.printResult();
    }


    public void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int m = scanner.nextInt();
        d = new int[n];
        v = new boolean[n];
        weight = new int[n][n];
        for (int i = 0; i < n; i++)//初始化边权矩阵
            for (int j = 0; j < n; j++)
                weight[i][j] = inf;
        for (int i = 0; i < m; i++) {//为边权矩阵赋值
            int vx = scanner.nextInt();
            int vy = scanner.nextInt();
            int w = scanner.nextInt();
            weight[vx][vy] = w;
            weight[vy][vx] = w;

        }
        source = scanner.nextInt();//输入起点

    }

    /**
     * @param s 单源起时点 source
     */
    public void dijstra(int s) {

        for (int i = 0; i < n; i++) {
            d[i] = weight[s][i];
            v[i] = false;
        }
        d[s] = 0;//起点到起点距离为0
        v[s] = true;//未访问过
        for (int i = 0; i < n; i++) {
            int x = 0, m = inf;
            for (int y = 0; y < n; y++) {
                if (!v[y] && d[y] <= m) {//查找距离s最短的点x
                    x = y;
                    m = d[y];
                }
            }
            v[x] = true;//标记已经访问过
            for (int y = 0; y < n; y++)//更新s到各个顶点的距离
                d[y] = Math.min(d[y], d[x] + weight[x][y]);
        }
    }

    public void printResult(){
        for (int i = 0; i < n; i++)
            System.out.print(d[i]+" ");
        System.out.println();
    }

}
