package models;

import java.util.Calendar;
import java.util.TimeZone;

public class Food {
    private String name;
    private String type;
    private String unit;
    private int exdDay; //06/05/2999
    private int exdMonth;
    private int exdYear;
    private int quantity;
    private boolean freeze; // true = ต้องแช่เย็นเท่านั้น false = แช่ช่องใดก็ได้
    private int addDay; // แช่อันดับที่เท่าไหร่
    private int addMonth;
    private int addYear;
    private int addTime;

    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    //getTime() returns the current date in default time zone
    private int toDay = calendar.get(Calendar.DATE);
    //Note: +1 the month for current month
    private int thisMonth = calendar.get(Calendar.MONTH) + 1;
    private int thisYear = calendar.get(Calendar.YEAR);

    public Food(String name, String type, String unit, int exdDay, int exdMonth, int exdYear, int quantity, boolean freeze) {
        this.name = name;
        this.type = type;
        this.unit = unit;
        this.exdDay = exdDay;
        this.exdMonth = exdMonth;
        this.exdYear = exdYear;
        this.quantity = quantity;
        this.freeze = freeze;
        this.addTime =0;
        this.addDay = toDay;
        this.addMonth = thisMonth;
        this.addYear = thisYear;
    }


    public void pickedOut(int quantity){
        this.quantity -= quantity;
    }

    public String getType() {
        return type;
    }

    public boolean isFreeze() {
        return freeze;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getAddTime() {
        return addTime;
    }

    public int getExdDay() {
        return exdDay;
    }

    public int getExdMonth() {
        return exdMonth;
    }

    public int getExdYear() {
        return exdYear;
    }

    public void setAddTime(int addTime) {
        this.addTime = addTime;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override   //เปรียบเทียบ type ว่าเป็นประเปทเดียวกันไหม
    public boolean equals(Object obj) {
        Food s1 = (Food) obj;
        if(this.type.equals(s1.getType())){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", unit='" + unit + '\'' +
                ", exdDay=" + exdDay +
                ", exdMonth=" + exdMonth +
                ", exdYear=" + exdYear +
                ", quantity=" + quantity +
                ", freeze=" + freeze +
                ", addTime=" + addTime +
                '}';
    }
}
