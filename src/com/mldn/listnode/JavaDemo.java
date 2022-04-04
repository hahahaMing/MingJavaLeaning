package com.mldn.listnode;

public class JavaDemo {
    public static void main(String[] args) {
        ILink<String> all = new LinkImpl<String>();
        all.add("0");
        all.add("1");
        all.add("2");
        System.out.println(all.size());
        System.out.println(all.isEmpty());
        for(Object obj:all.toArray()){
            System.out.println(obj);
        }
        System.out.println(all.get(2));
        all.set(2,"a");
        System.out.println(all.get(2));
        System.out.println(all.contains("b"));
        System.out.println(all.contains("1"));
        all.remove("1");
        for(Object obj:all.toArray()){
            System.out.println(obj);
        }

    }
}
