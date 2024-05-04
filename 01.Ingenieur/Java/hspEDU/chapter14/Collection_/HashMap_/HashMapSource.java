package chapter14.Collection_.HashMap_;

import java.util.HashSet;

/**
 * @author myry
 * @date 2024-49-31 21:49
 * 前方高能 底层源码
 */

@SuppressWarnings({"all"})
public class HashMapSource {
    public static void main(String[] args) {

        HashSet hashSet = new HashSet();
        hashSet.add("java");
        hashSet.add("php");
        hashSet.add("java");
        System.out.println(hashSet);

        /**
         * 源码解读
         *
         * 1. HashSet hashSet = new HashSet();
         * 执行一个简单的构造器
         *
         * public HashSet() {
         *         map = new HashMap<>();
         *     }
         *
         * 2.hashSet.add("java");
         * 执行一个简单的add方法
         *
         * public boolean add(E e) { // e = "java"
         *         return map.put(e, PRESENT)==null;
         *     }
         *
         *     PRESENT -> static final Object PRESENT = new Object();
         *
         *     e = "java"
         *
         * 2.1 put(e, PRESENT)方法
         * 该方法 会执行hash(key) 得到key对应的hash值
         *
         * public V put(K key, V value) {
         *         return putVal(hash(key), key, value, false, true);
         *     }
         *
         *     key = e = "java"
         *
         *
         * 2.2 putVal(hash(key), key, value, false, true)方法
         * final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
         *                    boolean evict) {
         *         Node<K,V>[] tab; Node<K,V> p; int n, i;
         *
         *         //定义辅助变量
         *         //table就是HashMap的一个数组 类型是Node[]
         *
         *         if ((tab = table) == null || (n = tab.length) == 0)
         *             n = (tab = resize()).length;
         *         if ((p = tab[i = (n - 1) & hash]) == null)
         *             tab[i] = newNode(hash, key, value, null);
         *         else {
         *             Node<K,V> e; K k;
         *             if (p.hash == hash &&
         *                 ((k = p.key) == key || (key != null && key.equals(k))))
         *                 e = p;
         *             else if (p instanceof TreeNode)
         *                 e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
         *             else {
         *                 for (int binCount = 0; ; ++binCount) {
         *                     if ((e = p.next) == null) {
         *                         p.next = newNode(hash, key, value, null);
         *                         if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
         *                             treeifyBin(tab, hash);
         *                         break;
         *                     }
         *                     if (e.hash == hash &&
         *                         ((k = e.key) == key || (key != null && key.equals(k))))
         *                         break;
         *                     p = e;
         *                 }
         *             }
         *             if (e != null) { // existing mapping for key
         *                 V oldValue = e.value;
         *                 if (!onlyIfAbsent || oldValue == null)
         *                     e.value = value;
         *                 afterNodeAccess(e);
         *                 return oldValue;
         *             }
         *         }
         *         ++modCount;
         *         if (++size > threshold)
         *             resize();
         *         afterNodeInsertion(evict);
         *         return null;
         *     }
         */


    }
}
