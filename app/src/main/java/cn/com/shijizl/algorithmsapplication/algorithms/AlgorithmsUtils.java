package cn.com.shijizl.algorithmsapplication.algorithms;


import android.text.TextUtils;
import android.util.Log;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 数据结构是以某种形式将数据组织在一起的集合，它不仅存储数据，还支持访问和处理数据的操作。
 * 算法是为求解一个问题需要遵循的、被清楚指定的简单指令的集合。
 *
 * 线性表:线性表是最常用且最简单的一种数据结构，它是n个数据元素的有限序列。
 * 实现线性表的方式一般有两种，一种是使用数组存储线性表的元素，即用一组连续的存储单元依次存储线性表的数据元素。
 * 另一种是使用链表存储线性表的元素，即用一组任意的存储单元存储线性表的数据元素（存储单元可以是连续的，也可以是不连续的）。
 *
 * 数组实现:
 * 数组是一种大小固定的数据结构，对线性表的所有操作都可以通过数组来实现。
 * 虽然数组一旦创建之后，它的大小就无法改变了，但是当数组不能再存储线性表中的新元素时，
 * 我们可以创建一个新的大的数组来替换当前数组。这样就可以使用数组实现动态的数据结构。
 *
 * 链表实现：
 * 链表是一种物理存储单元上非连续、非顺序的存储结构，数据元素的逻辑顺序是通过链表中的指针链接次序实现的。
 * 链表由一系列节点组成，这些节点不必在内存中相连。
 * 每个节点由数据部分Data和链部分Next，Next指向下一个节点，这样当添加或者删除时，只需要改变相关节点的Next的指向，效率很高。
 *
 * 栈和队列：
 * 栈和队列也是比较常见的数据结构，它们是比较特殊的线性表，
 * 因为对于栈来说，访问、插入和删除元素只能在栈顶进行，
 * 对于队列来说，元素只能从队列尾插入，从队列头访问和删除。
 * 栈：
 * 栈是限制插入和删除只能在一个位置上进行的表，该位置是表的末端，叫作栈顶，
 * 对栈的基本操作有push(进栈)和pop(出栈)，前者相当于插入，后者相当于删除最后一个元素。
 * 栈有时又叫作LIFO(Last In First Out)表，即后进先出。
 * 队列：
 * 队列是一种特殊的线性表，特殊之处在于它只允许在表的前端（front）进行删除操作，
 * 而在表的后端（rear）进行插入操作，和栈一样，队列是一种操作受限制的线性表。
 * 进行插入操作的端称为队尾，进行删除操作的端称为队头。
 *
 * 树与二叉树
 * 树型结构是一类非常重要的非线性数据结构，其中以树和二叉树最为常用。
 *
 */
public class AlgorithmsUtils {

    //============数组实现线性表===================
    /**
     * 使用大的数组替换老的数组（小的）
     */
    public static void fill() {
        int[] a = new int[]{0,1,2,3,4,5,6,7,8,9};
        int[] b = new int[20];

//        b = Arrays.copyOf(a, a.length);

        int j = 0;
        for (int i : a) {
            b[j] = i;
            j ++;
        }

//        System.arraycopy(a, 0, b, 0, a.length);

        for (int i : b) {
            Log.e("====", "====" + i);
        }
        Log.e("===", "===" + b.length);
        a = b;
    }

    /**
     * 给数组的某个位置插入某个值
     *
     * @param position insert position
     * @param e insert data
     * @param a old values
     */
    public static void insert(int position, int e, int[] a) {
        int size = a.length;
        if (position > size && position < 0) {
            Log.e("====", "====" + "位置不合法");
            return;
        }

        // 如何判断数组已满
        // 默认将数组扩容一位
        int[] b = new int[size + 1];
        System.arraycopy(a, 0, b, 0, size);
        a = b;

        for (int i = size; i >= position; i--) {
            a[i] = a[i - 1];
        }
        // 同上
//        System.arraycopy(a, position, a, position + 1, size - position);

        a[position] = e;

        for (int i : a) {
            Log.e("====", "====" + i);
        }
    }

    //============数组实现线性表===================

    //============链表实现线性表===================
    static class Node<E> {
        E item;
        Node<E> next;

        Node(E element) {
            this.item = element;
            this.next = null;
        }
    }

    public static void creat() {
        Node<String> head = null;
        Node<String> tail = null;

        head = new Node<>("head");
        tail = head;

        tail.next = new Node<>("node2");
        tail = tail.next;

        Node<String> current = head;
        while (current != null) {
            Log.e("===", "====" + current.item);
            current = current.next;
        }

        printListRev(head);
    }

    /**
     * 倒序打印链表
     *
     * @param node
     */
    private static void printListRev(Node<String> node) {
        if (node != null) {
            printListRev(node.next);
            Log.e("====", "====" + node.item);
        }
    }

    //customer
    public static void create() {
        Node<String> node1 = new Node<>("node1");
        Node<String> node2 = new Node<>("node2");
        Node<String> node3 = new Node<>("node3");

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        Node<String> current = node1;
        while (current != null) {
            Log.e("=11==", "====" + current.item);
            current = current.next;
        }

//        printListRev(node1);
//        revList(node1);
        deleteNode(node1, "node2");

        Node<String> current1 = node1;
        while (current1 != null) {
            Log.e("=22==", "====" + current1.item);
            current1 = current1.next;
        }
     }

    public static void revList(Node<String> node) {
        if (node == null) {
            return;
        }

        Node<String> nodePre = null;
        Node<String> nodeCurrent = node;
        while (nodeCurrent != null) {
            Node<String> next = nodeCurrent.next;// 先取出下一个节点保存，最后一个为null

            nodeCurrent.next = nodePre;//将先一个节点的指引赋值，将下一个节点的指引替换为当前，第一个为null
            nodePre = nodeCurrent;// 保存当前节点
            nodeCurrent = next;// 将下一个节点赋值给当前节点，走到下一个节点
        }
    }

    public static void deleteNode(Node<String> node, String item) {
        if (node == null) {
            return;
        }
        if (TextUtils.isEmpty(item)) {
            return;
        }

        Node<String> nodeNext = node.next;

        Node<String> current = node;
        while (current != null) {
            String item1 = current.item;
            Node<String> next = current.next;

            if (item.equals(item1)) {
                nodeNext = next;
                break;
            } else {
                nodeNext = current.next;

                current = next;
            }
        }
    }

    static class TwoNode2<E> {
        TwoNode2<E> head;
        E item;
        TwoNode2<E> next;

        TwoNode2(TwoNode2<E> head, E e, TwoNode2<E> next) {
            this.head = head;
            this.item = e;
            this.next = next;
        }
    }

    //双向链表
    static class TwoNode<E> {
        TwoNode<E> head;
        E item;
        TwoNode<E> next;

        TwoNode(E e) {
            this.item = e;
        }
    }

    public static void creatTwo() {
        TwoNode<String> one = new TwoNode<>("one");
        TwoNode<String> two = new TwoNode<>("two");
        TwoNode<String> three = new TwoNode<>("three");

        one.head = null;
        one.next = two;

        two.head = one;
        two.next = three;

        three.head = two;
        three.next = null;

//        three.next = one;
//        one.head = three;
    }

    //============链表实现线性表===================


    //============栈与队列===================

    //LinkedList实现栈
    class MyZhan<E> {

        LinkedList<E> linkedList = new LinkedList<>();

        public void addFirst(E e) {
            linkedList.add(e);
        }

        public void deleteFirst() {
            linkedList.removeFirst();
        }

        public E getFirst() {
            return linkedList.getFirst();
        }
    }

    //LinkedList实现队列
    class MyDuiLie<E> {

        LinkedList<E> linkedList = new LinkedList<>();

        public void enqueue(E e) {
            linkedList.addLast(e);
        }

        public E dequeue() {
            return linkedList.removeFirst();
        }

    }
    /**
     *
     * PriorityQueue:具有优先级的队列，内部实现是通过二叉树进行排序的原理，比较和调整使当前节点比其子节点都小，重复操作
     * siftDown:将大的元素与子节点的小的元素进行调换
     * siftUp:将小的元素与其根节点大的元素进行调换
     * 最终形成最小堆：小的总在上面
     */
    PriorityQueue priorityQueue;

    //================栈与队列=========================

    //================链表实现二叉树=========================

    /**
     *
     * Comparable:是一个对象本身就已经支持自比较所需要实现的接口，实现Comparable接口
     * 只提供了compareTo()方法
     * a.compareTo(b);
     *
     * Comparator 是策略模式（strategy design pattern），就是不改变对象自身，而用一个策略对象（strategy object）来改变它的行为
     * 集成Comparator实现一个比较器
     * 提供了compare()和equals()方法
     * compare(a,b);
     *
     * @param <E>
     */
    //二叉树
    class ErChaShu<E extends Comparable<E>>{
        E e;
        ErChaShu<E> left;
        ErChaShu<E> right;

        ErChaShu(E e, ErChaShu<E> left, ErChaShu<E> right) {
            this.e = e;
            this.left = left;
            this.right = right;
        }
    }

    //二叉查找树
    class ErChaShuSearch<E extends Comparable<E>> {
        ErChaShu<E> root;

        ErChaShuSearch() {
        }

        public boolean search(E e) {
            ErChaShu<E> current = root;
            while (current != null) {
                if (e.compareTo(current.e) < 0) {
                    current = current.left;
                } else if (e.compareTo(current.e) > 0) {
                    current = current.right;
                } else {
                    return true;
                }
            }
            return false;
        }

        // 二叉查找树的插入
        public boolean insert(E e) {
            // 如果之前是空二叉树 插入的元素就作为根节点
            if (root == null) {
                root = createNewNode(e);
            } else {
                // 否则就从根节点开始遍历 直到找到合适的父节点
                ErChaShu<E> parent = null;
                ErChaShu<E> current = root;
                while (current != null) {
                    if (e.compareTo(current.e) < 0) {
                        parent = current;
                        current = current.left;
                    } else if (e.compareTo(current.e) > 0) {
                        parent = current;
                        current = current.right;
                    } else {
                        return false;
                    }
                }
                // 插入
                if (e.compareTo(parent.e) < 0) {
                    parent.left = createNewNode(e);
                } else {
                    parent.right = createNewNode(e);
                }
            }
            return true;
        }

        // 创建新的节点
        protected ErChaShu<E> createNewNode(E e) {
            return new ErChaShu(e, null, null);
        }

    }

    public int count = 0;
    public int foo(int x) {
        count ++;

        Log.e("====", "====" + count);
        if (x <= 2)
            return 1;
        return foo(x - 2) + foo(x - 4) + 1;
    }

}
