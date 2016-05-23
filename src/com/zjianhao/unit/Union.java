package com.zjianhao.unit;


/**
 * Created by 张建浩（Clarence) on 2016-5-15 23:00.
 * the author's website:http://www.zjianhao.cn
 * the author's github: https://github.com/zhangjianhao
 */

import java.util.Scanner;

public class Union {

    public static int find(int [] parent,int x){
        int proxy = x;
        while (parent[proxy] != proxy)
            proxy = parent[proxy];
        //路径压缩
        int i = x,j;
        while (parent[i] != proxy){
            j = parent[i];
            parent[i] = proxy;
            i = j;
        }
        return proxy;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n ,p1=0,p2=0,f1,f2,total = 0;
        while (scanner.hasNextInt() && (n=scanner.nextInt())>0){
            total = n-1;//一共需要修n-1条路
            int[] parent = new int[n+1];
            for (int i = 1; i <=n; i++) {
                parent[i] = i;
            }
            int m = scanner.nextInt();
            for (int i=0; i<m; i++){
                p1= scanner.nextInt();
                p2= scanner.nextInt();
                f1 = find(parent,p1);
                f2 = find(parent,p2);
                if (f1 != f2){
                    total--;
                    parent[f1] = f2;
                }
            }
            System.out.println(total);

        }


    }
}
