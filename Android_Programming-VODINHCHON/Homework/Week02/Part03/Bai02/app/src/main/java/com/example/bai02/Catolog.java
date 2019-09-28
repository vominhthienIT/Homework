package com.example.bai02;

import java.util.ArrayList;

public class Catolog extends Goods{
    private ArrayList<Product> listSp = null;

    public Catolog(String id, String name) {
        super(id, name);
        this.listSp = new ArrayList<Product>();
    }

    public Catolog() {
        super();
        this.listSp = new ArrayList<Product>();
    }

    public boolean isDuplicate(Product p){
        for (Product p1 : listSp){
            if(p1.getId().trim().equalsIgnoreCase(p.getId().trim()))
                return true;
        }
        return false;
    }

    public boolean addProduct(Product p){
        boolean isDup = isDuplicate(p);
        if(!isDup){
            p.setDmuc(this);
            listSp.add(p);
            return true;
        }
        return false;
    }

    public ArrayList<Product> getListProduct(){
        return this.listSp;
    }

    public int size(){
        return listSp.size();
    }

    public Product get(int i){
        return listSp.get(i);
    }
}
