package com.mldn.shopping;

public interface IShopCar {
    public void add(IGoods goods); //添加商品信息
    public void delete(IGoods goods); //删除商品
    public Object [] getAll(); //获得购物车中全部的商品信息
}
