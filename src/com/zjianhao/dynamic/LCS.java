package com.zjianhao.dynamic;

/**
 * Created by 张建浩（Clarence) on 2016-5-15 22:30.
 * the author's website:http://www.zjianhao.cn
 * the author's github: https://github.com/zhangjianhao
 */

public class LCS {
     String x = "122f35624";
     char [] m = x.toCharArray();
     String y = "2135ff4";
    char [] n = y.toCharArray();


    int [][] a = new int[x.length()][y.length()];//用来保存中间计算的状态
    public static void main(String[] args) {

       LCS lcs = new LCS();
        lcs.init();
        int result = lcs.solve(0,0);
        System.out.println();
        System.out.println(result);
        lcs.resolvePath(result);
    }

    public void init(){
        for (int i=0; i<x.length(); i++)
            for (int j=0; j<y.length(); j++){
                a[i][j] = -1;
            }
    }

    public  int solve(int i,int j){//记忆化搜索
        if (i==x.length()|| j==y.length())
            return 0;
        if (a[i][j] >=0)//
            return a[i][j];
        if (m[i]==n[j]){
            return a[i][j] = solve(i+1,j+1)+1;
        }
        else
        return a[i][j] = Math.max(solve(i+1,j),solve(i,j+1));
    }

    /**
     * 打印最长公共字串
     * @param result
     */
    public void resolvePath(int result){
        int x = 0;
        int y = 0;
        char [] path = new char[result];
        int count = 0;
        while (x <m.length && y <n.length) {
            if (m[x] == n[y]) {
                path[count++] = m[x];
                x++;
                y++;
            }
            else if (x<m.length-1&&a[x][y] == a[x+1][y]){
                x++;
            }else if (y<n.length-1 &&a[x][y] == a[x][y+1])
                y++;
        }
        for (int i=0; i<path.length; i++)
            System.out.print(path[i]);
    }


}
