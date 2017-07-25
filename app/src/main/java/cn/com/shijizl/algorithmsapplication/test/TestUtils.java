package cn.com.shijizl.algorithmsapplication.test;


import android.util.Log;

public class TestUtils {

    // 二分查找法
    public static int funBinSearch(int[] array, int data) {
        int low = 0;
        int heigh = array.length - 1;

        while (low <= heigh) {
            int middle = (low + heigh) / 2;

            if (data == array[middle]) {
                return 1;
            } else if (data < array[middle]) {
                heigh = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    //============排序算法================

    public static void print(String string, int[] array) {
        for (int a : array) {
            Log.e("===" + string + "==", "====" + a);
        }
    }

    //=========交换排序==============
    /**
     * 冒泡排序
     * 比较前后两个数的大小，进行排序，每一次都能讲此次比较的最大值移动最末尾
     *
     * 最好情况下时间复杂度O(n)
     * 最坏情况下为O(n*n)
     *
     *
     * @param array
     */
    public static void bobble(int[] array) {
        boolean flag = true;// 避免是顺序数组
        for (int i = 0; i < array.length - 1 && flag; i++) {
            flag = false;
            for (int j = 0; j < array.length- 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    flag = true;
                }
            }
        }
    }

    /**
     * 快速排序
     * 在待排序的序列中选择一个称为主元的元素，将数组分为两部分，使得第一部分中的所有元素都小于或等于主元，
     * 而第二部分中的所有元素都大于主元，然后对两部分递归地应用快速排序算法。
     *
     * @param array
     * @param start
     * @param end
     */
    public static void funQuickSort(int[] array, int start, int end) {
        if (end > start) {
            int partition = quickSortPartition(array, start, end);
            funQuickSort(array, start, partition - 1);
            funQuickSort(array, partition + 1, end);
        }

    }

    private static int quickSortPartition(int[] array, int first, int last) {
        int pivot = array[0];
        int low = first + 1;
        int heigh = last;

        while (heigh > low) {
            while (low <= heigh && array[low] <= pivot) {
                low ++;
            }

            while (low <= heigh && array[low] >= pivot) {
                heigh --;
            }

            if (heigh > low) {
                int temp = array[heigh];
                array[heigh] = array[low];
                array[low] = temp;
            }
        }

        while (heigh > first && array[heigh] >= pivot) {
            heigh --;
        }

        if (pivot > array[heigh]) {
            array[first] = array[heigh];
            array[heigh] = pivot;
            return heigh;
        } else {
            return first;
        }
    }

    //==========选择排序==============

    /**
     * 简单选择排序
     * 选择其中最小的与第一个进行交换位置，下一次从第二个开始，以此类推
     *
     * 简单选择排序过程中需要进行的比较次数与初始状态下待排序的记录序列的排列情况无关
     * 进行比较操作的时间复杂度为 O(n*2)
     * 进行移动操作的时间复杂度为 O(n)
     * 总的时间复杂度为 O(n*2)
     *
     * @param array
     */
    public static void funSelectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int mink = i;

            // 每次从未排序数组中找到最小值的坐标
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[mink]) {
                    mink = j;
                }
            }
            // 将最小值放到最前面
            if (mink != i) {
                int temp = array[mink];
                array[mink] = array[i];
                array[i] = temp;
            }
        }
    }

    //========插入排序=============

    /**
     * 直接插入排序
     * 将一个记录插入到已排好序的有序表中，从而得到一个新的、记录数增1的有序表。
     *
     * 最好情况下，当待排序序列中记录已经有序时，则需要n-1次比较，不需要移动，时间复杂度为 O(n)
     * 最差情况下，当待排序序列中所有记录正好逆序时，则比较次数和移动次数都达到最大值，时间复杂度为 O(n^2)
     * 平均情况下，时间复杂度为 O(n^2)
     *
     *
     * @param array
     */
    public static void funDInsertSort(int[] array) {
        int j;
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            j = i - 1;

            while (j > -1 && temp < array[j]) {
                array[j + 1] = array[j];
                j --;
            }
            array[j + 1] = temp;
        }
    }

    /**
     * 希尔排序（缩小增量法）
     * 将直接插入法的1替换为了h
     *
     * 时间开销估计在O(N*3/2)~O(N*7/6)之间
     *
     * @param array
     */
    public static void shell(int[] array) {
        //计算出h的最大值
        int h = 1;
        while (h <= array.length / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {
            for (int i = h; i < array.length; i += h) {
                Log.e("====", "====" + h + "===" + i);
                if (array[i] < array[i - h]) {
                    int temp = array[i];
                    int j = i - h;
                    while (j >= 0 && array[j] > temp) {
                        array[j + h] = array[j];
                        j -= h;
                    }
                    array[j + h] = temp;
                }
            }
            h = (h - 1) / 3;
        }
    }

    //=========归并排序===========

    /**
     * 归并排序
     * 归并排序是分治法的一个典型应用
     * 将待排序序列分为两部分，对每部分递归地应用归并排序，在两部分都排好序后进行合并
     *
     * 归并排序的时间复杂度为O(nlogn)，它是一种稳定的排序，
     * java.util.Arrays类中的sort方法就是使用归并排序的变体来实现的。
     *
     * @param array
     */
    public static void funMergeSort(int[] array) {
        if (array.length > 1) {
            int length1 = array.length / 2;
            int[] array1 = new int[length1];
            System.arraycopy(array, 0, array1, 0, length1);
            funMergeSort(array1);

            int length2 = array.length - length1;
            int[] array2 = new int[length2];
            System.arraycopy(array, length1, array2, 0, length2);
            funMergeSort(array2);

            int[] merge = merge(array1, array2);
            System.arraycopy(merge, 0, array, 0, merge.length);
        }
    }

    private static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        while (count1 < a.length && count2 < b.length) {
            if (a[count1] < b[count2]) {
                c[count3 ++] = a[count1 ++];
            } else {
                c[count3 ++] = b[count2 ++];
            }
        }

        while (count1 < a.length) {
            c[count3 ++] = a[count1 ++];
        }

        while (count2 < b.length) {
            c[count3 ++] = b[count2 ++];
        }

        return c;
    }

    //============斐波那契数列=========
    public static long funFib(long index) {
        if (index == 0) {
            return 0;
        } else if (index == 1) {
            return 1;
        } else {
            return funFib(index - 2) + funFib(index - 1);
        }
    }

    public static long funFib2(long index) {
        int f0 = 0;
        int f1 = 1;
        int f2 = 1;
        if (index == 0) {
            return f0;
        } else if (index == 1) {
            return f1;
        } else if (index == 2) {
            return f2;
        }

        for (int i = 3; i < index; i++) {
            f0 = f1;
            f1 = f2;
            f2 = f0 + f1;
        }
        return f2;
    }

    //=============不使用临时变量交换两个数========
    public static void funSwapTwo(int a, int b) {
        a = a ^ b;
        Log.e("====", "====" + a + "===" + b);
        b = b ^ a;
        Log.e("====", "====" + a + "===" + b);
        a = a ^ b;

        Log.e("=====", "=====" + a + "===" + b);
    }

    //==========判断一个数是否为素数===========
    public static boolean funIsPrime(int a) {
        boolean flag = false;
        if (a <= 0) {
            return false;
        }
        if (a == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    //===========合并排序，将两个已经排序的数组合并成一个数组，其中一个数组能容下两个数组的所有元素===

    /**
     * 因为长数组后面几位是空的
     * 因此从后往前进行插入即可
     *
     * @param a
     * @param aLen
     * @param b
     * @param bLen
     */
    public static void mergyArray(int[] a, int aLen, int[] b, int bLen) {
        int len = aLen + bLen - 1;
        aLen --;
        bLen --;
        while (aLen >= 0 && bLen >= 0) {
            if(a[aLen] > b[bLen]) {
                a[len --] = a[aLen --];
            } else {
                a[len --] = b[bLen --];
            }
        }
        while (aLen >= 0) {
            a[len --] = a[aLen --];
        }
        while (bLen >= 0) {
            a[len --] = b[bLen --];
        }
    }

    //===========合并两个单链表=========
    static class Node<E>{
        E e;
        Node<E> next;
        Node(E e, Node<E> next) {
            this.e = e;
            this.next = next;
        }
    }

    public static Node<Integer> createNode(int a) {
        Node<Integer> node = new Node<>(a, null);
        Node<Integer> node1 = new Node<>(a + 2, null);
        Node<Integer> node2 = new Node<>(a + 4, null);
        node.next = node1;
        node1.next = node2;
        return node;
    }

    public static void printNode(Node<Integer> node) {
        while (node != null) {
            Log.e("===", "====" + node.e);
            node = node.next;
        }
    }

    public static Node<Integer> mergeNode(Node<Integer> head1, Node<Integer> head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node<Integer> head = null;
        if (head1.e < head2.e) {
            head = head1;
            head1 = head1.next;
        } else {
            head = head2;
            head2 = head2.next;
        }

        Node<Integer> temp = head;
        while (head1 != null && head2 != null) {
            if (head1.e < head2.e) {
                head.next = head1;
                head1 = head1.next;
            } else {
                head.next = head2;
                head2 = head2.next;
            }
            head = head.next;
        }
        if (head1 != null) {
            head.next = head1;
        }
        if (head2 != null) {
            head.next = head2;
        }
        return temp;
    }

    //============倒序打印一个单链表===========
    /**
     * 使用递归调用实现
     * @param node
     */
    public static void reversePrint(Node<Integer> node) {
        if (node != null) {
            reversePrint(node.next);
            Log.e("=====", "=====" + node.e);
        }
    }

    //===========给定一个单链表的头指针和一个指定节点的指针，在O(1)时间删除该节点====
    public static void deleteNode(Node<Integer> node, Node<Integer> deleteNode) {
        if (node == null && deleteNode == null) {
            return;
        }
        if (deleteNode.next != null) {
            Node<Integer> next = deleteNode.next;
            deleteNode.next = next.next;
            deleteNode.e = next.e;

        }

    }

    //========找到链表倒数第K个节点========

    /**
     * 通过两个指针，两个指针都指向链表的开始，
     * 一个指针先向前走K个节点，然后再以前向前走，当先走的那个节点到达末尾时，
     * 另一个节点就刚好与末尾节点相差K个节点
     */
    public static Node<Integer> findNode(Node<Integer> node, int k) {
        if (node == null || k == 0) {
            return null;
        }

        Node<Integer> head = node;
        for (int i = 0; i < k; i++) {
            if (head != null) {
                head = head.next;
            } else {
                return null;
            }
        }
        Node<Integer> kHead = node;
        while (head != null) {
            kHead = kHead.next;
            head = head.next;
        }

        Log.e("====", "====" + kHead.e);
        return kHead;
    }

    //==========通过两个栈实现一个队列===========

    //==========获得一个int型的数中二进制中的个数=====

    /**
     * 核心实现就是while (num= num & (num-1))，
     * 通过这个数和比它小1的数的二进制进行&运算，
     * 将二进制中1慢慢的从后往前去掉，直到没有。
     *
     * @param a
     * @return
     */
    public static int findCount(int a) {
        if (a == 0) {
            return 0;
        }

        int count = 1;
        while ((a = a & (a - 1)) > 0) {
            count ++;
        }
        return count;
    }

    //=========输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有的偶数位于数组的后半部分===
    public static void recordArray(int[] array) {
        if (array == null) {
            return;
        }

        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            if (isEven(array[i]) && !isEven(array[j])) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            } else if (!isEven(array[i]) && isEven(array[j])) {
                i ++;
            } else if (isEven(array[i]) && isEven(array[j])) {
                j --;
            } else {
                i ++;
                j --;
            }
        }
    }

    public static boolean isEven(int num) {
        if (num % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    //========判断一个字符串是否是另一个字符串的子串========
    //========把一个int型数组中的数字拼成一个串，这个串代表的数字最小======
    //========输入一颗二叉树，输出它的镜像（每个节点的左右子节点交换位置）=====
    //========输入两个链表，找到它们第一个公共节点====
}
