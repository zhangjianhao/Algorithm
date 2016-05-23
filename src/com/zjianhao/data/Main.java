package com.zjianhao.data;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by 张建浩（Clarence) on 2016-5-15 21:11.
 * the author's website:http://www.zjianhao.cn
 * the author's github: https://github.com/zhangjianhao
 */

public class Main {
    private static int currentIndex = 3;
    private static BigInteger [] dp = new BigInteger[201];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("2");
        while (scanner.hasNextInt()){
              int a = scanner.nextInt();
              if (currentIndex<=a)
                  resolve(a);
                  System.out.println(dp[a].toString());
        }
    }

    public static void resolve(int a){

        for (; currentIndex<=a; currentIndex++){
            dp[currentIndex] = dp[currentIndex-1].add(dp[currentIndex-2]);
        }
    }
}
