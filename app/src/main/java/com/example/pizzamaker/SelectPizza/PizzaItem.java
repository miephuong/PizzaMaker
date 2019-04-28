package com.example.pizzamaker.SelectPizza;

public class PizzaItem {
    private String name;
    private int picId;

    PizzaItem(String name, int picId){
        this.name = name;
        this.picId = picId;
    }

    public String getName(){
        return name;
    }

    public int getPicId(){
        return picId;
    }

}
