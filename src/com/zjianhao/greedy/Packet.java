package com.zjianhao.greedy;

/**
 * Created by 张建浩（Clarence) on 2016-5-20 11:00.
 * the author's website:http://www.zjianhao.cn
 * the author's github: https://github.com/zhangjianhao
 */

public class Packet {
    private double maxCapacity = 120;
    private double N = 10;
    private Goods [] goods = new Goods[10];

    public static void main(String[] args) {
        Packet packet = new Packet();
        packet.input();
//        double v1 = packet.getMaxValueByValue();
//        System.out.println(v1);
//        double v2 = packet.getMaxValueByWeight();
//        System.out.println(v2);
        double v3 = packet.getMaxValueByRate();
        System.out.println(v3);

    }

    public void input(){
        //50,60,70,80,90,80,70,60,50,40
        //17,30,25,41,80,70,64,56,47,38
        goods[0] = new Goods(50,17);
        goods[1] = new Goods(60,30);
        goods[2] = new Goods(70,25);
        goods[3] = new Goods(80,41);
        goods[4] = new Goods(90,80);
        goods[5] = new Goods(80,70);
        goods[6] = new Goods(70,64);
        goods[7] = new Goods(60,56);
        goods[8] = new Goods(50,47);
        goods[9] = new Goods(40,38);
//        System.out.println(goods.length);
    }

    public double getMaxValueByValue(){
        for (int i=0; i<goods.length; i++)
            for (int j=goods.length-1; j>i; j--){
                if (goods[j].value > goods[j-1].value){
                    Goods good = goods[j];
                    goods[j] = goods[j-1];
                    goods[j-1] = good;
                }
            }
        double sumValue = 0;
        double sumWeight= 0;
        int n = 0;
        for (int i=0; i<goods.length; i++){
            if (sumWeight+goods[i].weight <= maxCapacity && n<N){
                sumValue += goods[i].value;
                sumWeight += goods[i].weight;
                n++;
            }else if (sumWeight+goods[i].weight > maxCapacity && n<N){
                sumValue += goods[i].value*((maxCapacity-sumWeight)/goods[i].weight);
                sumWeight += goods[i].weight;
                n++;
                break;
            }
        }
        return sumValue;
    }

    public double getMaxValueByWeight(){
        for (int i=0; i<goods.length; i++)
            for (int j=goods.length-1; j>i; j--){
                if (goods[j].weight <  goods[j-1].weight){
                    Goods good = goods[j];
                    goods[j] = goods[j-1];
                    goods[j-1] = good;
                }
            }
        double sumValue = 0;
        double sumWeight= 0;
        int n = 0;
        for (int i=0; i<goods.length; i++){
            if (sumWeight+goods[i].weight <= maxCapacity && n<N){
                sumValue += goods[i].value;
                sumWeight += goods[i].weight;
                n++;
            }else if (sumWeight+goods[i].weight > maxCapacity && n<N){
                sumValue += goods[i].value*((maxCapacity-sumWeight)/goods[i].weight);
                sumWeight += goods[i].weight;
                n++;
                break;
            }
        }
        return sumValue;
    }


    public double getMaxValueByRate(){
        for (int i=0; i<goods.length; i++)
            for (int j=goods.length-1; j>i; j--){
                if (goods[j].value/goods[j].weight > goods[j-1].value/goods[j-1].weight){
                    Goods good = goods[j];
                    goods[j] = goods[j-1];
                    goods[j-1] = good;
                }
            }
        double sumValue = 0;
        double sumWeight= 0;
        int n = 0;
        for (int i=0; i<goods.length; i++){
            if (sumWeight+goods[i].weight <= maxCapacity && n<N){
                sumValue += goods[i].value;
                sumWeight += goods[i].weight;
                n++;
            }else if (sumWeight+goods[i].weight > maxCapacity && n<N){
                sumValue += goods[i].value*((maxCapacity-sumWeight)/goods[i].weight);
                sumWeight += goods[i].weight;
                n++;
                break;
            }
        }
        return sumValue;
    }


}
