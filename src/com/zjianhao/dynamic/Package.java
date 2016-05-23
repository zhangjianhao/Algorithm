package com.zjianhao.dynamic;

/**
 * Created by 张建浩（Clarence) on 2016-5-23 12:58.
 * the author's website:http://www.zjianhao.cn
 * the author's github: https://github.com/zhangjianhao
 */

public class Package {
    private int[] weight = {0,2, 2, 6, 5, 4};//重量,0号元素不用
    private int[] v = {0,6, 3, 5, 4, 6};//体积
    private int maxV = 10;//最大体积限制
    private int N = weight.length-1;
    private int[][] d = new int[N+1][maxV+1];

    public static void main(String[] args) {
            new Package().solve();
    }

    public void solve() {
        for (int i = 1; i <=N; i++) {
            for (int j = 0; j <=maxV; j++) {//j为容量
                d[i][j] = (i == 0 ? 0 : d[i - 1][j]);
                if (j >= v[i]) {//如果剩余体积可以放下该物品
                    d[i][j] = Math.max(d[i][j], d[i-1][j - v[i]] + weight[i]);
                }
            }
        }
        System.out.println(d[N][maxV]);
    }
}
