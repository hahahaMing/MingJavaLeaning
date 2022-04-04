package com.mldn.shopping;

public class JavaDemo {
    public static void main(String[] args){
        IShopCar car = new ShopCarImpl();
        car.add(new Book("b1",7.7));
        car.add(new Book("b2",7.8));
        car.add(new Bag("bag1",8.7));
        Cashier cas = new Cashier(car);
        System.out.println("Total Price: "+cas.allPrice()+" Buy Amount: "+cas.allCount());
    }
}
