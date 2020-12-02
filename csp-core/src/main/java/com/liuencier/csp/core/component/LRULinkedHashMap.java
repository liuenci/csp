package com.liuencier.csp.core.component;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: csp
 * @description: LRU实现
 * @author: liuenci
 * @create: 2020-12-02 17:36
 **/
public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    private int initialCapacity;

    public LRULinkedHashMap(int initialCapacity) {
        // 初始大小，0.75是装载因子，true是表示按照访问时间排序
        super(initialCapacity, 0.75F, true);
        // 传入指定的缓存最大容量
        this.initialCapacity = initialCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // 实现LRU的关键方法，如果map里面的元素个数大于了缓存最大容量，则删除链表的顶端元素
        return size() > initialCapacity;
    }

    public static void main(String[] args) {
        LRULinkedHashMap<String, String> map = new LRULinkedHashMap<>(3);
        map.put("疾风剑豪","HASAKI");
        map.put("放逐之刃","HASAKI");
        map.put("光辉女郎","HASAKI");
        map.get("疾风剑豪");
        map.put("无极剑圣","HASAKI");

    }

}
