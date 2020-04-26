package models;

import javafx.print.Collation;

import java.util.ArrayList;
import java.util.Collections;

public class Compartment {
    private ArrayList<Food> foods = new ArrayList<>(); // เก็บอาหารหลายๆอย่างไว้ในช่อง
    private int time=0; // เอาไว้เช็ค แช่ก่อนหลัง
    private ArrayList<Food> sortFoods = new ArrayList<>();

    public Compartment() {
    }

    public void addFood(Food food){
        if (foods.isEmpty() && (food.isFreeze()==false)){
            foods.add(food);
            food.setAddTime(time);
            time+=1;
        }
        else {
            if (food.equals(foods.get(0)) && (food.isFreeze()==false)){
//                System.out.println("same type");
                foods.add(food);
                food.setAddTime(time);
                time+=1;
            }
            else {
//                System.out.println("not your type");
            }
        }
    }

    public void delete(){
        if (foods.get(0).getQuantity()<=0){
            foods.remove(0);
        }
    }

    public void pickedOut(int quantity){
        foods.get(0).setQuantity(foods.get(0).getQuantity()-quantity);
    }


    public void sortFood() {

        for (int j = 0 ; j<foods.size() ; j++){
            for (int i = 0; i < foods.size(); i++) {
                if(i==foods.size()-1){

                }
                else{
                    if (foods.get(j).getExdYear()>foods.get(i).getExdYear()){
                        Collections.swap(foods, j, i);
                    }


                    if (foods.get(j).getExdYear()==foods.get(i).getExdYear()){
//                        System.out.println("this step");
                        if (foods.get(j).getExdMonth()>foods.get(i).getExdMonth()){
                            Collections.swap(foods, j, i);
//                            System.out.println("this step 2");
                        }
                        if (foods.get(j).getExdMonth()==foods.get(i).getExdMonth()){
                            if (foods.get(j).getExdDay()>foods.get(i).getExdDay()){
                                Collections.swap(foods, j, i);
                            }

                        }
                    }



                }

            }
        }

        Collections.reverse(foods);
    }


    public Food getFirstFood(){
        return foods.get(0);
    }


    public ArrayList<Food> getFoods() {
        return foods;
    }

    public ArrayList<Food> getSortFoods() {
        return sortFoods;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Compartment{" +
                "foods=" + foods +
                '}';
    }
}
