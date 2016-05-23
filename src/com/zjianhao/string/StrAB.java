package com.zjianhao.string;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 张建浩（Clarence) on 2016-5-21 13:25.
 * the author's website:http://www.zjianhao.cn
 * the author's github: https://github.com/zhangjianhao
 */

public class StrAB {
    private char [] a;
    private int [] b;
    public static void main(String[] args) {
        new StrAB().solve();

    }
    public void solve(){
        Scanner scanner  = new Scanner(System.in);
        a = scanner.nextLine().toCharArray();
        char [] temp = scanner.nextLine().toCharArray();
        b = new int[200];
        Arrays.fill(b,0);
        for (int i=0; i<temp.length; i++){
            b[temp[i]] = 1;
        }
        for (int i=0; i<a.length;i++){
            if (b[a[i]] == 0)
                System.out.print(a[i]);
        }

    }
}
