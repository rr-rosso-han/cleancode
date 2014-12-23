package facetoface;

public class Solution {
   int randomM() {
       return 1;
   }
    /*
    * give a randomM
    * write a randomN
    * */
   int randomN(int n, int m) {
       int k = (int) Math.ceil(Math.log((double)n));
       int ex = (int)Math.pow(m,k);
       int high = ex - ex % n;
       int val = 0;
       do {
           val = 0;
           for (int i = 0; i < k; i++) {
               val = val * m + (randomM() - 1);
           }
       } while(val >= high);
       return val % n + 1;
   }

    /*
    * give a random5();
    * write a random7();
    * */

    /*
    * 给一个int stream, 每次读一个数，求中位数
    * 1， 2, 3, 4, 5
    * 1, 1, 2, 2, 3
    *
    * 小的数放到大顶堆
    * 大的数放到小顶堆
    * 每次平衡两个堆
    *
    * 平衡树可以用一个
    * 平衡bst == 红黑树， 应对删除的场景。
    * leetcode medium two
    * */

    /*
    * 有个树n 求n/2
    * 维持一个平衡二叉树，二叉树保存树节点的数量。
    * 左旋堆
    *
    * treap：树堆的概念
    * 堆和树的结合
    * BST
    * 把一个二叉树编程概率上是平衡的树， 在数以外给一个随机权重，这个权重符合堆的性质
    *
    * 多模匹配
    *
    * 给一个整数数组求连续和为0的最长的一段。返回长度。
    * 前缀和为零，定界。
    * N个元素的数组，求连续的子数组的和能整除N
    * N个前缀和。
    * O(n)
    *
    * 有串中值，滑动窗口，m种颜色，
    * M数组，
    * 剑指Offer有这道题
    *
    * 两个排好序的数组，怎么求交集
    * 归并排序，的时候把相等的数打印出来。
    *
    * 两个有序数组，找两个有序数组差的绝对值最小的。
    * 归并排序。需要看看
    *
    * 数据库
    * inner join
    * 分桶，开根号分桶，hash
    *
    * 求两个有序数组的中间值，求交集
    * A|————————|
    * B|------------------|
    * 取A 的中值，找到B中的位置，然后把B分成两部分，分别求两部分的值。
    *
    * 给一堆螺钉，螺母，你可以知道，螺母比这个螺钉大还是小。怎么把螺钉，螺母都匹配。
    * 顺序输出。
    *
    * NLP自然语言，ngram算法 bigram trigram
    * 有一堆专有名词
    * 和专有名词的query
    * 找到query的包含这些名词
    *
    * —————B————A———————
    * left
    * right
    * if_at_A_or_B
    * goto
    *
    * 0 left
    * 1 left
    * 2 right
    * 3 if_at_A_or_B
    * 4 goto 6
    * 5 goto 0
    * 6 left
    * 7 goto 6
    *
    * 给一个数组[8, 23, 14, 6]
    * 求连起来最大
    * 当作字符串合并，然后比较大小，大的放前面
    * 然后用sort
    * 传递性证明不知道怎么证明。
    *
    * 死锁的判定
    *
    * KV hashmap 放到硬盘上。
    * 每个节点的文件结构是什么样的。
    * B数的格式。
    *
    * 判断链表，回文，O(n) 时间。
    * 反转链表再比较
    *
    * reverse integer 二进制
    * 110 -> 011
    *
    * 5亿个数求中位数，内存400M
    *
    *
    *
    * */
}