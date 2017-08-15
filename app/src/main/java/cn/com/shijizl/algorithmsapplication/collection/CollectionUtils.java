package cn.com.shijizl.algorithmsapplication.collection;


import android.os.Handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Collection:List,Set,Queue
 * Map:HashMap,LinkedHashMap,TreeMap
 * Collections：
 * Arrays：
 *
 * List:ArrayList, LinkedList
 * ArrayList:数组实现，查询快，插入和删除慢，根据添加的数据的大小来创建数组，然后将原来的数组复制到新数组中
 * LinkedList:链表实现，查询慢，插入和删除快
 *
 * Set:散列集HashSet, 链式散列集LinkedHashSet, 树形集TreeSet
 * 散列集HashSet：HashMap实现(利用Map键不能重复的原理)，存储的都为不重复的元素，存入和输出时的顺序不一致，应该是根据equals判断
 * 链式散列集LinkedHashSet：链表实现来扩展HashSet类，支持对规则集内的元素排序，是有序的
 * 树形集TreeSet：有序的Set，其底层是一颗树，可以给TreeSet指定一个比较器Comparator来指定树形集中的元素顺序
 *
 * Queue:先进先出的数据结构，元素在队列末尾添加，在队列头部删除
 * Deque:扩展自Queue的双端队列，LinkedList类实现了Deque接口，所以通常我们可以使用LinkedList来创建一个队列
 * PriorityQueue:实现了一个优先队列
 *
 * Map:图，是一种存储键值对映射的容器类，在Map中键可以是任意类型的对象，但不能有重复的键，
 * 每个键都对应一个值，真正存储在图中的是键值构成的条目
 * HashMap：基于哈希表的Map接口的非同步实现，HashMap中条目是没有顺序的
 * 在之前的版本中，HashMap采用数组+链表实现，即使用链表处理冲突，同一hash值的链表都存储在一个链表里。
 * 但是当链表中的元素较多，即hash值相等的元素较多时，通过key值依次查找的效率较低
 * 而JDK1.8中，HashMap采用数组+链表+红黑树实现，当链表长度超过阈值（8）时，将链表转换为红黑树，这样大大减少了查找时间
 * 在HashMap中要找到某个元素，需要根据key的hash值来求得对应数组中的位置
 *
 * LinkedHashMap:LinkedHashMap继承自HashMap，它主要是用链表实现来扩展HashMap类，
 * LinkedHashMap中元素既可以按照它们插入图的顺序排序，也可以按它们最后一次被访问的顺序排序
 *
 * TreeMap:基于红黑树数据结构的实现，键值可以使用Comparable或Comparator接口来排序，可以确保图中的条目是排好序的
 * 如果更新图时不需要保持图中元素的顺序，就使用HashMap，
 * 如果需要保持图中元素的插入顺序或者访问顺序，就使用LinkedHashMap，
 * 如果需要使图按照键值排序，就使用TreeMap。
 *
 * Vector:Vector与ArrayList基本一致，不同之处在于Vector使用了关键字synchronized将访问和修改向量的方法都变成同步的了，
 * 所以对于不需要同步的应用程序来说，类ArrayList比类Vector更高效
 *
 * Stack:栈类，是Java2之前引入的，继承自类Vector
 *
 * HashTable:散列表，存储的内容是键值对映射，HashTable中的函数都是同步的，这意味着它也是线程安全的，
 * 另外，HashTable中key和value都不可以为null，与HashMap不同
 * HashMap传入null的key和value时是可以的putForNullKey()
 * HashTable传入null的key和value时NullPointerException异常
 *
 * ConcurrentHashMap：HashMap的线程安全版，不仅保证了访问的线程安全性，而且在效率上与HashTable相比，也有较大的提高
 *
 * CopyOnWriteArrayList：是一个线程安全的List接口的实现，它使用了ReentrantLock（可重入锁）锁来保证在并发情况下提供高性能的并发读取
 *
 * 总结：
 * Java集合框架主要包括Collection和Map两种类型。其中Collection又有3种子类型，分别是List、Set、Queue。Map中存储的主要是键值对映射。
 * 规则集Set中存储的是不重复的元素，线性表中存储可以包括重复的元素，Queue队列描述的是先进先出的数据结构，可以用LinkedList来实现队列。
 * 效率上，规则集比线性表更高效。
 * ArrayList主要是用数组来存储元素，LinkedList主要是用链表来存储元素，HashMap的底层实现主要是借助数组+链表+红黑树来实现。
 * Vector、HashTable等集合类效率比较低但都是线程安全的。包java.util.concurrent下包含了大量线程安全的集合类，效率上有较大提升。
 *
 */

/**
 *
 * Collections: 是一个包装类。它包含有各种有关集合操作的静态多态方法。此类不能实例化，就像一个工具类，服务于Java的Collection框架。
 * sort()排序方法
 * binarySearch()二分查找方法
 * reverse()反转方法
 * shuffle()改组方法,使用随机源对指定列表进行置换
 * swap()交换方法
 * fill()替换方法
 * copy()复制方法
 * min()最小值法
 * max()最大值方法
 * rotate()轮换方法
 * replaceAll()替换所有函数
 *
 */
public class CollectionUtils {
    Collection collection;
    List list;
    ArrayList arrayList;
    LinkedList linkedList;
    Set set;
    HashSet hashSet;
    TreeSet treeSet;
    Collections collections;
    HashMap<String, String> hashMap = new HashMap<>();
    Hashtable<String, String> hashtable = new Hashtable<>();
    Arrays arrays;

    public void test() {
        hashMap.put(null, null);

        hashtable.put(null, null);

        Handler handler;
    }

}
