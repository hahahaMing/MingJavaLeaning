package com.mldn.shopping;

public class Cashier {
    private IShopCar shopCar;
    public Cashier(IShopCar shopCar){
        this.shopCar = shopCar;
    }
    public double allPrice(){
        Object result[] = this.shopCar.getAll();
        double all = 0.0;
        for(Object obj : result){
            IGoods goods = (IGoods) obj;
            all+=goods.getPrice();
        }
        return all;
    }
    public int allCount(){
        return this.shopCar.getAll().length;
    }
}
