package com.mldn.listnode;

public interface ILink<E> {
    public void add(E e);
    public int size(); //获取数据的个数
    public boolean isEmpty(); //判断是否为空集合
    public Object [] toArray(); //将集合元素以数组形式返回
    public E get(int index); //根据索引获取数据
    public void set(int index,E data);//修改索引数据
    public boolean contains(E data); //判断数据是否存在
    public void remove(E e); //数据删除
    public void clean(); //清空链表
}
