package models;

import java.util.ArrayList;

public class FreezingCompartment extends Compartment {

    @Override
    public void addFood(Food food) {
        if (super.getFoods().isEmpty() && (food.isFreeze()==true)){
            super.getFoods().add(food);
            food.setAddTime(super.getTime());
            super.setTime(super.getTime()+1);
//            time+=1;
        }
        else {
            if (food.equals(super.getFoods().get(0)) && (food.isFreeze()==true)){
//                System.out.println("same type");
                super.getFoods().add(food);
                food.setAddTime(super.getTime());
                super.setTime(super.getTime()+1);
            }
            else {
//                System.out.println("not your type");
            }
        }
    }
}
