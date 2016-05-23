package com.zjianhao.tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by 张建浩（Clarence) on 2016-5-21 21:21.
 * the author's website:http://www.zjianhao.cn
 * the author's github: https://github.com/zhangjianhao
 */

public class Tree {

    private static int [] L = {4,1,8,3,2,6,5,7};
    private int [] V = {8,1,2,3,4,5,6,7};
    private static int [] R = {8,2,3,1,5,7,6,4};
    public static void main(String[] args) {
        Tree tree = new Tree();
//        tree.solvePostOrder(0,0,L.length);
        tree.solvePreOrder(R.length-1,0,R.length);
//        tree.solveLevelOrder(R.length-1,0,R.length);
    }



    private class Node<E>{
         E data;
         Node left;
         Node right;
    }

    /**
     *
     * @param preStart
     * @param inStart
     * @param length
     */
    public Node<Integer> solvePostOrder(int preStart,int inStart,int length){
        if (length<=0)
            return null;
//        System.out.println("L:"+preStart+":"+(preStart+length-1)+"---"+"V:"+inStart+":"+(inStart+length-1)+"  Length:"+length);
        int v = L[preStart];
        int len = getLength(inStart,length,v);
        solvePostOrder(preStart+1,inStart,len);
        solvePostOrder(preStart+len+1,inStart+len+1,length-len-1);
        System.out.print(v+" ");
        return null;

    }

    public Node<Integer> solvePreOrder(int post,int inStart,int length){
        if (length<=0)
            return null;
        int v = R[post];
        Node<Integer> root = new Node<>();
        root.data = v;
        int len = getLength(inStart,length,v);//left tree length
        root.left = solvePreOrder(post-(length-len),inStart,len);//solve left tree
        root.right = solvePreOrder(post-1,inStart+len+1,length-len-1);//solve right tree
        return root;
    }

//    public void solvePreOrder(int post,int inStart,int length){
//        if (length<=0)
//            return ;
//        int v = R[post];
//        System.out.print(v+" ");//
//        int len = getLength(inStart,length,v);//left tree length
//        solvePreOrder(post-(length-len),inStart,len);//solve left tree
//        solvePreOrder(post-1,inStart+len+1,length-len-1);//solve right tree
//    }

    public void solveLevelOrder(int post,int inStart,int length){
        //
        Node<Integer> root = solvePreOrder(post,inStart,length);
        Queue<Node> queue = new LinkedList<>();
        System.out.println(root.left.data+":"+root.right.data);
        queue.add(root);
        while (!queue.isEmpty()){
            Node<Integer> rt = queue.poll();
            System.out.print(rt.data+" ");
            if (rt.left != null){
                queue.add(rt.left);
            }
            if (rt.right != null){
                queue.add(rt.right);
            }
        }
    }
//



    public int getLength(int start,int length,int v){
        for (int i = start,count = 0; count<length; i++,count++){
            if (V[i] == v)
                return count;
        }
        return 0;
    }

}
