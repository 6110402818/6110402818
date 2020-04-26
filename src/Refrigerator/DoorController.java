package Refrigerator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import models.*;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DoorController {
//    public void addBtn(ActionEvent actionEvent) throws IOException {
//        Parent connector = (Parent) FXMLLoader.load(this.getClass().getResource("RefrigeratorAdd.fxml"));
//        Scene scene = new Scene(connector);
//        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();
//    }

//    ArrayList<Compartment> compartment = new ArrayList<>();

    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    //getTime() returns the current date in default time zone
    private int toDay = calendar.get(Calendar.DATE);
    //Note: +1 the month for current month
    private int thisMonth = calendar.get(Calendar.MONTH) + 1;
    private int thisYear = calendar.get(Calendar.YEAR);

    Compartment compartment1 = new Compartment();
    Compartment compartment2 = new Compartment();
    Compartment compartment3 = new Compartment();
    Compartment compartment4= new Compartment();
    Compartment compartment5 = new Compartment();
    Compartment compartment6 = new Compartment();

    FreezingCompartment freezingCompartment1 = new FreezingCompartment();
    FreezingCompartment freezingCompartment2 = new FreezingCompartment();
    //สร้างตู้
    Refrigerator refrigerator = new Refrigerator();

    public DoorController() {
    }

    public Compartment getCompartment1() {
        return compartment1;
    }
    public void DoorControllerSetCompartment1(Compartment compartment1) {
        this.compartment1 = compartment1;
    }

    public void DoorControllerSetCompartment2(Compartment compartment2) {
        this.compartment2 = compartment2;
    }

    public void DoorControllerSetCompartment3(Compartment compartment3) {
        this.compartment3 = compartment3;
    }

    public void DoorControllerSetCompartment4(Compartment compartment4) {
        this.compartment4 = compartment4;
    }

    public void DoorControllerSetCompartment5(Compartment compartment5) {
        this.compartment5 = compartment5;
    }

    public void DoorControllerSetCompartment6(Compartment compartment6) {
        this.compartment6 = compartment6;
    }

    public void DoorControllerSetFreezingCompartment1(FreezingCompartment freezingCompartment1) {
        this.freezingCompartment1 = freezingCompartment1;
    }

    public void DoorControllerSetFreezingCompartment2(FreezingCompartment freezingCompartment2) {
        this.freezingCompartment2 = freezingCompartment2;
    }

    private MyFile file;
    private String name;
    private String type;
    private String unit;
    private int exdDay;
    private int exdMonth;
    private int exdYear;
    private int quantity;
    private boolean freeze;
    Food food = new Food(name,type,unit,exdDay,exdMonth,exdYear,quantity,freeze);


    @FXML
    void initialize() {
        this.file = new MyFile(System.getProperty("user.dir") + File.separator + "resources" + File.separator + "files", "RefrigeratorData.csv");
        //file = new MyFile(System.getProperty("user.dir")+ fs +"resources" + fs + "files", "RefrigeratorData.csv");


        String fs = File.separator;
        if(file == null){
            file = new MyFile(System.getProperty("user.dir") + fs + "resources" + fs + "files", "RefrigeratorData.csv");
        }
        if(file.getContent().equals("")) {
            file.setContent("");
        }
        file.save();



    }








    public void creditBtn(ActionEvent actionEvent) throws IOException {
        Parent connector = (Parent) FXMLLoader.load(this.getClass().getResource("Info.fxml"));
        Scene scene = new Scene(connector);
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void openBtn(ActionEvent actionEvent) throws IOException {


        String fs = File.separator;


        File file = new File(System.getProperty("user.dir") + fs + "resources" + fs + "files"  , "RefrigeratorData.csv");
        FileReader fileReader;
        fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);


        String line;
        String[] userInfo = new String[9];
        while ((line = reader.readLine()) != null) {
            userInfo = line.split(",");

            if(userInfo[0].equals("compartment1")) {
                name = userInfo[1];
                type = userInfo[2];
                unit = userInfo[3];
                exdDay = Integer.parseInt(userInfo[4]);
                exdMonth = Integer.parseInt(userInfo[5]);
                exdYear = Integer.parseInt(userInfo[6]);
                quantity = Integer.parseInt(userInfo[7]);
                freeze = false;
                Food food = new Food(name,type,unit,exdDay,exdMonth,exdYear,quantity,freeze);
                this.compartment1.addFood(food);
            }


            if(userInfo[0].equals("compartment2")) {
                name = userInfo[1];
                type = userInfo[2];
                unit = userInfo[3];
                exdDay = Integer.parseInt(userInfo[4]);
                exdMonth = Integer.parseInt(userInfo[5]);
                exdYear = Integer.parseInt(userInfo[6]);
                quantity = Integer.parseInt(userInfo[7]);
                freeze = false;
                Food food = new Food(name,type,unit,exdDay,exdMonth,exdYear,quantity,freeze);
                this.compartment2.addFood(food);
            }

            if(userInfo[0].equals("compartment3")) {
                name = userInfo[1];
                type = userInfo[2];
                unit = userInfo[3];
                exdDay = Integer.parseInt(userInfo[4]);
                exdMonth = Integer.parseInt(userInfo[5]);
                exdYear = Integer.parseInt(userInfo[6]);
                quantity = Integer.parseInt(userInfo[7]);
                freeze = false;
                Food food = new Food(name,type,unit,exdDay,exdMonth,exdYear,quantity,freeze);
                this.compartment3.addFood(food);
            }


            if(userInfo[0].equals("compartment4")) {
                name = userInfo[1];
                type = userInfo[2];
                unit = userInfo[3];
                exdDay = Integer.parseInt(userInfo[4]);
                exdMonth = Integer.parseInt(userInfo[5]);
                exdYear = Integer.parseInt(userInfo[6]);
                quantity = Integer.parseInt(userInfo[7]);
                freeze = false;
                Food food = new Food(name,type,unit,exdDay,exdMonth,exdYear,quantity,freeze);
                this.compartment4.addFood(food);
            }


            if(userInfo[0].equals("compartment5")) {
                name = userInfo[1];
                type = userInfo[2];
                unit = userInfo[3];
                exdDay = Integer.parseInt(userInfo[4]);
                exdMonth = Integer.parseInt(userInfo[5]);
                exdYear = Integer.parseInt(userInfo[6]);
                quantity = Integer.parseInt(userInfo[7]);
                freeze = false;
                Food food = new Food(name,type,unit,exdDay,exdMonth,exdYear,quantity,freeze);
                this.compartment5.addFood(food);
            }

            if(userInfo[0].equals("compartment6")) {
                name = userInfo[1];
                type = userInfo[2];
                unit = userInfo[3];
                exdDay = Integer.parseInt(userInfo[4]);
                exdMonth = Integer.parseInt(userInfo[5]);
                exdYear = Integer.parseInt(userInfo[6]);
                quantity = Integer.parseInt(userInfo[7]);
                freeze = false;
                Food food = new Food(name,type,unit,exdDay,exdMonth,exdYear,quantity,freeze);
                this.compartment6.addFood(food);
            }


            if(userInfo[0].equals("freezer1")) {
                name = userInfo[1];
                type = userInfo[2];
                unit = userInfo[3];
                exdDay = Integer.parseInt(userInfo[4]);
                exdMonth = Integer.parseInt(userInfo[5]);
                exdYear = Integer.parseInt(userInfo[6]);
                quantity = Integer.parseInt(userInfo[7]);
                freeze = true;
                Food food = new Food(name,type,unit,exdDay,exdMonth,exdYear,quantity,freeze);
                this.freezingCompartment1.addFood(food);
            }


            if(userInfo[0].equals("freezer2")) {
                name = userInfo[1];
                type = userInfo[2];
                unit = userInfo[3];
                exdDay = Integer.parseInt(userInfo[4]);
                exdMonth = Integer.parseInt(userInfo[5]);
                exdYear = Integer.parseInt(userInfo[6]);
                quantity = Integer.parseInt(userInfo[7]);
                freeze = true;
                Food food = new Food(name,type,unit,exdDay,exdMonth,exdYear,quantity,freeze);
                this.freezingCompartment2.addFood(food);
            }
        }

        reader.close();



























        Button b = (Button)actionEvent.getSource();
        Stage stage = (Stage)b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("RefrigeratorCompartment.fxml"));
        stage.setScene(new Scene((Parent)loader.load(), 650, 950));


        RefrigeratorCompartmentController LoadCompartment1 = (RefrigeratorCompartmentController)loader.getController();
        LoadCompartment1.refrigeratorCompartmentControllerSetCompartment1(this.compartment1);


        RefrigeratorCompartmentController LoadCompartment2 = (RefrigeratorCompartmentController)loader.getController();
        LoadCompartment2.refrigeratorCompartmentControllerSetCompartment2(this.compartment2);

        RefrigeratorCompartmentController LoadCompartment3 = (RefrigeratorCompartmentController)loader.getController();
        LoadCompartment3.refrigeratorCompartmentControllerSetCompartment3(this.compartment3);

        RefrigeratorCompartmentController LoadCompartment4 = (RefrigeratorCompartmentController)loader.getController();
        LoadCompartment4.refrigeratorCompartmentControllerSetCompartment4(this.compartment4);

        RefrigeratorCompartmentController LoadCompartment5 = (RefrigeratorCompartmentController)loader.getController();
        LoadCompartment5.refrigeratorCompartmentControllerSetCompartment5(this.compartment5);

        RefrigeratorCompartmentController LoadCompartment6 = (RefrigeratorCompartmentController)loader.getController();
        LoadCompartment6.refrigeratorCompartmentControllerSetCompartment6(this.compartment6);

        RefrigeratorCompartmentController LoadFreezingCompartment1 = (RefrigeratorCompartmentController)loader.getController();
        LoadFreezingCompartment1.refrigeratorCompartmentControllerSetFreezingCompartment1(this.freezingCompartment1);

        RefrigeratorCompartmentController LoadFreezingCompartment2 = (RefrigeratorCompartmentController)loader.getController();
        LoadFreezingCompartment2.refrigeratorCompartmentControllerSetFreezingCompartment2(this.freezingCompartment2);
    }





    public void saveAndCloseBtn(ActionEvent event) throws IOException {
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

        String fs = File.separator;
        file = new MyFile(System.getProperty("user.dir")+ fs +"resources" + fs + "files", "RefrigeratorData.csv");

        file.clear();
        file.setContent("");

        for (int i = 0 ; i < compartment1.getFoods().size() ; i++){
            name = compartment1.getFoods().get(i).getName();
            type = compartment1.getFoods().get(i).getType();
            unit = compartment1.getFoods().get(i).getUnit();
            exdDay = compartment1.getFoods().get(i).getExdDay();
            exdMonth = compartment1.getFoods().get(i).getExdMonth();
            exdYear = compartment1.getFoods().get(i).getExdYear();
            quantity = compartment1.getFoods().get(i).getQuantity();
            freeze = false;
            file.append("compartment1"+","+ name + "," + type + "," + unit + "," + exdDay + "," + exdMonth + "," + exdYear + "," + quantity + "," + freeze + "," + toDay + "," + thisMonth + "," + thisYear);
            file.append(System.lineSeparator());
            file.save();
        }

        for (int i = 0 ; i < compartment2.getFoods().size() ; i++){
            name = compartment2.getFoods().get(i).getName();
            type = compartment2.getFoods().get(i).getType();
            unit = compartment2.getFoods().get(i).getUnit();
            exdDay = compartment2.getFoods().get(i).getExdDay();
            exdMonth = compartment2.getFoods().get(i).getExdMonth();
            exdYear = compartment2.getFoods().get(i).getExdYear();
            quantity = compartment2.getFoods().get(i).getQuantity();
            freeze = false;
            file.append("compartment2"+","+ name + "," + type + "," + unit + "," + exdDay + "," + exdMonth + "," + exdYear + "," + quantity + "," + freeze + "," + toDay + "," + thisMonth + "," + thisYear);
            file.append(System.lineSeparator());
            file.save();
        }

        for (int i = 0 ; i < compartment3.getFoods().size() ; i++){
            name = compartment3.getFoods().get(i).getName();
            type = compartment3.getFoods().get(i).getType();
            unit = compartment3.getFoods().get(i).getUnit();
            exdDay = compartment3.getFoods().get(i).getExdDay();
            exdMonth = compartment3.getFoods().get(i).getExdMonth();
            exdYear = compartment3.getFoods().get(i).getExdYear();
            quantity = compartment3.getFoods().get(i).getQuantity();
            freeze = false;
            file.append("compartment3"+","+ name + "," + type + "," + unit + "," + exdDay + "," + exdMonth + "," + exdYear + "," + quantity + "," + freeze + "," + toDay + "," + thisMonth + "," + thisYear);
            file.append(System.lineSeparator());
            file.save();
        }


        for (int i = 0 ; i < compartment4.getFoods().size() ; i++){
            name = compartment4.getFoods().get(i).getName();
            type = compartment4.getFoods().get(i).getType();
            unit = compartment4.getFoods().get(i).getUnit();
            exdDay = compartment4.getFoods().get(i).getExdDay();
            exdMonth = compartment4.getFoods().get(i).getExdMonth();
            exdYear = compartment4.getFoods().get(i).getExdYear();
            quantity = compartment4.getFoods().get(i).getQuantity();
            freeze = false;
            file.append("compartment4"+","+ name + "," + type + "," + unit + "," + exdDay + "," + exdMonth + "," + exdYear + "," + quantity + "," + freeze + "," + toDay + "," + thisMonth + "," + thisYear);
            file.append(System.lineSeparator());
            file.save();
        }

        for (int i = 0 ; i < compartment5.getFoods().size() ; i++){
            name = compartment5.getFoods().get(i).getName();
            type = compartment5.getFoods().get(i).getType();
            unit = compartment5.getFoods().get(i).getUnit();
            exdDay = compartment5.getFoods().get(i).getExdDay();
            exdMonth = compartment5.getFoods().get(i).getExdMonth();
            exdYear = compartment5.getFoods().get(i).getExdYear();
            quantity = compartment5.getFoods().get(i).getQuantity();
            freeze = false;
            file.append("compartment5"+","+ name + "," + type + "," + unit + "," + exdDay + "," + exdMonth + "," + exdYear + "," + quantity + "," + freeze + "," + toDay + "," + thisMonth + "," + thisYear);
            file.append(System.lineSeparator());
            file.save();
        }

        for (int i = 0 ; i < compartment6.getFoods().size() ; i++){
            name = compartment6.getFoods().get(i).getName();
            type = compartment6.getFoods().get(i).getType();
            unit = compartment6.getFoods().get(i).getUnit();
            exdDay = compartment6.getFoods().get(i).getExdDay();
            exdMonth = compartment6.getFoods().get(i).getExdMonth();
            exdYear = compartment6.getFoods().get(i).getExdYear();
            quantity = compartment6.getFoods().get(i).getQuantity();
            freeze = false;
            file.append("compartment6"+","+ name + "," + type + "," + unit + "," + exdDay + "," + exdMonth + "," + exdYear + "," + quantity + "," + freeze + "," + toDay + "," + thisMonth + "," + thisYear);
            file.append(System.lineSeparator());
            file.save();
        }

        for (int i = 0 ; i < freezingCompartment1.getFoods().size() ; i++){
            name = freezingCompartment1.getFoods().get(i).getName();
            type = freezingCompartment1.getFoods().get(i).getType();
            unit = freezingCompartment1.getFoods().get(i).getUnit();
            exdDay = freezingCompartment1.getFoods().get(i).getExdDay();
            exdMonth = freezingCompartment1.getFoods().get(i).getExdMonth();
            exdYear = freezingCompartment1.getFoods().get(i).getExdYear();
            quantity = freezingCompartment1.getFoods().get(i).getQuantity();
            freeze = false;
            file.append("freezer1"+","+ name + "," + type + "," + unit + "," + exdDay + "," + exdMonth + "," + exdYear + "," + quantity + "," + freeze + "," + toDay + "," + thisMonth + "," + thisYear);
            file.append(System.lineSeparator());
            file.save();
        }

        for (int i = 0 ; i < freezingCompartment2.getFoods().size() ; i++){
            name = freezingCompartment2.getFoods().get(i).getName();
            type = freezingCompartment2.getFoods().get(i).getType();
            unit = freezingCompartment2.getFoods().get(i).getUnit();
            exdDay = freezingCompartment2.getFoods().get(i).getExdDay();
            exdMonth = freezingCompartment2.getFoods().get(i).getExdMonth();
            exdYear = freezingCompartment2.getFoods().get(i).getExdYear();
            quantity = freezingCompartment2.getFoods().get(i).getQuantity();
            freeze = false;
            file.append("freezer2"+","+ name + "," + type + "," + unit + "," + exdDay + "," + exdMonth + "," + exdYear + "," + quantity + "," + freeze + "," + toDay + "," + thisMonth + "," + thisYear);
            file.append(System.lineSeparator());
            file.save();
        }
    }










}
