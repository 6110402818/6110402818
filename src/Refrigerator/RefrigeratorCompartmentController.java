package Refrigerator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Compartment;
import models.FreezingCompartment;
import models.MyFile;

import java.io.*;
import java.util.Calendar;
import java.util.TimeZone;

public class RefrigeratorCompartmentController {
    @FXML
    ImageView photo1;

    @FXML
    AnchorPane pane;

    @FXML TextField nameTf1,quantityTf1,unitTf1,exdDTf1,exdMTf1,exdYTF1;

    @FXML TextField nameTf2,quantityTf2,unitTf2,exdDTf2,exdMTf2,exdYTF2;

    @FXML TextField nameTf3,quantityTf3,unitTf3,exdDTf3,exdMTf3,exdYTF3;

    @FXML TextField nameTf4,quantityTf4,unitTf4,exdDTf4,exdMTf4,exdYTF4;

    @FXML TextField nameTf5,quantityTf5,unitTf5,exdDTf5,exdMTf5,exdYTF5;

    @FXML TextField nameTf6,quantityTf6,unitTf6,exdDTf6,exdMTf6,exdYTF6;

    @FXML TextField nameTf7,quantityTf7,unitTf7,exdDTf7,exdMTf7,exdYTF7;

    @FXML TextField nameTf8,quantityTf8,unitTf8,exdDTf8,exdMTf8,exdYTF8;


    @FXML TextField pickOutTf1,pickOutTf2,pickOutTf3,pickOutTf4;
    @FXML TextField pickOutTf5,pickOutTf6,pickOutTf7,pickOutTf8;





    Compartment compartment1 = new Compartment();
    Compartment compartment2 = new Compartment();
    Compartment compartment3 = new Compartment();
    Compartment compartment4= new Compartment();
    Compartment compartment5 = new Compartment();
    Compartment compartment6 = new Compartment();

    FreezingCompartment freezingCompartment1 = new FreezingCompartment();
    FreezingCompartment freezingCompartment2 = new FreezingCompartment();

    public RefrigeratorCompartmentController() {
    }

    public void refrigeratorCompartmentControllerSetCompartment1(Compartment compartment1) {
        this.compartment1 = compartment1;
    }

    public void refrigeratorCompartmentControllerSetCompartment2(Compartment compartment2) {
        this.compartment2 = compartment2;
    }

    public void refrigeratorCompartmentControllerSetCompartment3(Compartment compartment3) {
        this.compartment3 = compartment3;
    }

    public void refrigeratorCompartmentControllerSetCompartment4(Compartment compartment4) {
        this.compartment4 = compartment4;
    }

    public void refrigeratorCompartmentControllerSetCompartment5(Compartment compartment5) {
        this.compartment5 = compartment5;
    }

    public void refrigeratorCompartmentControllerSetCompartment6(Compartment compartment6) {
        this.compartment6 = compartment6;
    }

    public void refrigeratorCompartmentControllerSetFreezingCompartment1(FreezingCompartment freezingCompartment1) {
        this.freezingCompartment1 = freezingCompartment1;
    }

    public void refrigeratorCompartmentControllerSetFreezingCompartment2(FreezingCompartment freezingCompartment2) {
        this.freezingCompartment2 = freezingCompartment2;
    }

    public Compartment getCompartment1() {
        return compartment1;
    }
    //    nameTf1.setText(compartment1.getFirstFood().getName());
//            quantityTf1.setText(String.valueOf(compartment1.getFirstFood().getQuantity()));

    public void initialize() {
//        System.out.println("test1");
//        System.out.println(compartment1.getFoods());
//        System.out.println(this.compartment1);
//        System.out.println(compartment1);

        compartment1.sortFood();
        compartment2.sortFood();
        compartment3.sortFood();
        compartment4.sortFood();
        compartment5.sortFood();
        compartment6.sortFood();
        freezingCompartment1.sortFood();
        freezingCompartment2.sortFood();



        if (this.compartment1.getFoods().isEmpty()==false){
            nameTf1.setText(compartment1.getFoods().get(0).getName());
            quantityTf1.setText(String.valueOf(compartment1.getFirstFood().getQuantity()));
            unitTf1.setText(compartment1.getFoods().get(0).getUnit());
            exdDTf1.setText(String.valueOf(compartment1.getFoods().get(0).getExdDay()));
            exdMTf1.setText(String.valueOf(compartment1.getFoods().get(0).getExdMonth()));
            exdYTF1.setText(String.valueOf(compartment1.getFoods().get(0).getExdYear()));
        }


        if (this.compartment2.getFoods().isEmpty()==false){
            nameTf2.setText(compartment2.getFoods().get(0).getName());
            quantityTf2.setText(String.valueOf(compartment2.getFirstFood().getQuantity()));
            unitTf2.setText(compartment2.getFoods().get(0).getUnit());
            exdDTf2.setText(String.valueOf(compartment2.getFoods().get(0).getExdDay()));
            exdMTf2.setText(String.valueOf(compartment2.getFoods().get(0).getExdMonth()));
            exdYTF2.setText(String.valueOf(compartment2.getFoods().get(0).getExdYear()));
        }

        if (this.compartment3.getFoods().isEmpty()==false){
            nameTf3.setText(compartment3.getFoods().get(0).getName());
            quantityTf3.setText(String.valueOf(compartment3.getFirstFood().getQuantity()));
            unitTf3.setText(compartment3.getFoods().get(0).getUnit());
            exdDTf3.setText(String.valueOf(compartment3.getFoods().get(0).getExdDay()));
            exdMTf3.setText(String.valueOf(compartment3.getFoods().get(0).getExdMonth()));
            exdYTF3.setText(String.valueOf(compartment3.getFoods().get(0).getExdYear()));
        }

        if (this.compartment4.getFoods().isEmpty()==false){
            nameTf4.setText(compartment4.getFoods().get(0).getName());
            quantityTf4.setText(String.valueOf(compartment4.getFirstFood().getQuantity()));
            unitTf4.setText(compartment4.getFoods().get(0).getUnit());
            exdDTf4.setText(String.valueOf(compartment4.getFoods().get(0).getExdDay()));
            exdMTf4.setText(String.valueOf(compartment4.getFoods().get(0).getExdMonth()));
            exdYTF4.setText(String.valueOf(compartment4.getFoods().get(0).getExdYear()));
        }

        if (this.compartment5.getFoods().isEmpty()==false){
            nameTf5.setText(compartment5.getFoods().get(0).getName());
            quantityTf5.setText(String.valueOf(compartment5.getFirstFood().getQuantity()));
            unitTf5.setText(compartment5.getFoods().get(0).getUnit());
            exdDTf5.setText(String.valueOf(compartment5.getFoods().get(0).getExdDay()));
            exdMTf5.setText(String.valueOf(compartment5.getFoods().get(0).getExdMonth()));
            exdYTF5.setText(String.valueOf(compartment5.getFoods().get(0).getExdYear()));
        }

        if (this.compartment6.getFoods().isEmpty()==false){
            nameTf6.setText(compartment6.getFoods().get(0).getName());
            quantityTf6.setText(String.valueOf(compartment6.getFirstFood().getQuantity()));
            unitTf6.setText(compartment6.getFoods().get(0).getUnit());
            exdDTf6.setText(String.valueOf(compartment6.getFoods().get(0).getExdDay()));
            exdMTf6.setText(String.valueOf(compartment6.getFoods().get(0).getExdMonth()));
            exdYTF6.setText(String.valueOf(compartment6.getFoods().get(0).getExdYear()));
        }

        if (this.freezingCompartment1.getFoods().isEmpty()==false){
            nameTf7.setText(freezingCompartment1.getFoods().get(0).getName());
            quantityTf7.setText(String.valueOf(freezingCompartment1.getFirstFood().getQuantity()));
            unitTf7.setText(freezingCompartment1.getFoods().get(0).getUnit());
            exdDTf7.setText(String.valueOf(freezingCompartment1.getFoods().get(0).getExdDay()));
            exdMTf7.setText(String.valueOf(freezingCompartment1.getFoods().get(0).getExdMonth()));
            exdYTF7.setText(String.valueOf(freezingCompartment1.getFoods().get(0).getExdYear()));
        }

        if (this.freezingCompartment2.getFoods().isEmpty()==false){
            nameTf8.setText(freezingCompartment2.getFoods().get(0).getName());
            quantityTf8.setText(String.valueOf(freezingCompartment2.getFirstFood().getQuantity()));
            unitTf8.setText(freezingCompartment2.getFoods().get(0).getUnit());
            exdDTf8.setText(String.valueOf(freezingCompartment2.getFoods().get(0).getExdDay()));
            exdMTf8.setText(String.valueOf(freezingCompartment2.getFoods().get(0).getExdMonth()));
            exdYTF8.setText(String.valueOf(freezingCompartment2.getFoods().get(0).getExdYear()));
        }

    }
    public void reBtn(ActionEvent event) {
        compartment1.sortFood();
        compartment2.sortFood();
        compartment3.sortFood();
        compartment4.sortFood();
        compartment5.sortFood();
        compartment6.sortFood();
        freezingCompartment1.sortFood();
        freezingCompartment2.sortFood();



        if (this.compartment1.getFoods().isEmpty()==false){
            nameTf1.setText(compartment1.getFoods().get(0).getName());
            quantityTf1.setText(String.valueOf(compartment1.getFirstFood().getQuantity()));
            unitTf1.setText(compartment1.getFoods().get(0).getUnit());
            exdDTf1.setText(String.valueOf(compartment1.getFoods().get(0).getExdDay()));
            exdMTf1.setText(String.valueOf(compartment1.getFoods().get(0).getExdMonth()));
            exdYTF1.setText(String.valueOf(compartment1.getFoods().get(0).getExdYear()));
        }


        if (this.compartment2.getFoods().isEmpty()==false){
            nameTf2.setText(compartment2.getFoods().get(0).getName());
            quantityTf2.setText(String.valueOf(compartment2.getFirstFood().getQuantity()));
            unitTf2.setText(compartment2.getFoods().get(0).getUnit());
            exdDTf2.setText(String.valueOf(compartment2.getFoods().get(0).getExdDay()));
            exdMTf2.setText(String.valueOf(compartment2.getFoods().get(0).getExdMonth()));
            exdYTF2.setText(String.valueOf(compartment2.getFoods().get(0).getExdYear()));
        }

        if (this.compartment3.getFoods().isEmpty()==false){
            nameTf3.setText(compartment3.getFoods().get(0).getName());
            quantityTf3.setText(String.valueOf(compartment3.getFirstFood().getQuantity()));
            unitTf3.setText(compartment3.getFoods().get(0).getUnit());
            exdDTf3.setText(String.valueOf(compartment3.getFoods().get(0).getExdDay()));
            exdMTf3.setText(String.valueOf(compartment3.getFoods().get(0).getExdMonth()));
            exdYTF3.setText(String.valueOf(compartment3.getFoods().get(0).getExdYear()));
        }

        if (this.compartment4.getFoods().isEmpty()==false){
            nameTf4.setText(compartment4.getFoods().get(0).getName());
            quantityTf4.setText(String.valueOf(compartment4.getFirstFood().getQuantity()));
            unitTf4.setText(compartment4.getFoods().get(0).getUnit());
            exdDTf4.setText(String.valueOf(compartment4.getFoods().get(0).getExdDay()));
            exdMTf4.setText(String.valueOf(compartment4.getFoods().get(0).getExdMonth()));
            exdYTF4.setText(String.valueOf(compartment4.getFoods().get(0).getExdYear()));
        }

        if (this.compartment5.getFoods().isEmpty()==false){
            nameTf5.setText(compartment5.getFoods().get(0).getName());
            quantityTf5.setText(String.valueOf(compartment5.getFirstFood().getQuantity()));
            unitTf5.setText(compartment5.getFoods().get(0).getUnit());
            exdDTf5.setText(String.valueOf(compartment5.getFoods().get(0).getExdDay()));
            exdMTf5.setText(String.valueOf(compartment5.getFoods().get(0).getExdMonth()));
            exdYTF5.setText(String.valueOf(compartment5.getFoods().get(0).getExdYear()));
        }

        if (this.compartment6.getFoods().isEmpty()==false){
            nameTf6.setText(compartment6.getFoods().get(0).getName());
            quantityTf6.setText(String.valueOf(compartment6.getFirstFood().getQuantity()));
            unitTf6.setText(compartment6.getFoods().get(0).getUnit());
            exdDTf6.setText(String.valueOf(compartment6.getFoods().get(0).getExdDay()));
            exdMTf6.setText(String.valueOf(compartment6.getFoods().get(0).getExdMonth()));
            exdYTF6.setText(String.valueOf(compartment6.getFoods().get(0).getExdYear()));
        }

        if (this.freezingCompartment1.getFoods().isEmpty()==false){
            nameTf7.setText(freezingCompartment1.getFoods().get(0).getName());
            quantityTf7.setText(String.valueOf(freezingCompartment1.getFirstFood().getQuantity()));
            unitTf7.setText(freezingCompartment1.getFoods().get(0).getUnit());
            exdDTf7.setText(String.valueOf(freezingCompartment1.getFoods().get(0).getExdDay()));
            exdMTf7.setText(String.valueOf(freezingCompartment1.getFoods().get(0).getExdMonth()));
            exdYTF7.setText(String.valueOf(freezingCompartment1.getFoods().get(0).getExdYear()));
        }

        if (this.freezingCompartment2.getFoods().isEmpty()==false){
            nameTf8.setText(freezingCompartment2.getFoods().get(0).getName());
            quantityTf8.setText(String.valueOf(freezingCompartment2.getFirstFood().getQuantity()));
            unitTf8.setText(freezingCompartment2.getFoods().get(0).getUnit());
            exdDTf8.setText(String.valueOf(freezingCompartment2.getFoods().get(0).getExdDay()));
            exdMTf8.setText(String.valueOf(freezingCompartment2.getFoods().get(0).getExdMonth()));
            exdYTF8.setText(String.valueOf(freezingCompartment2.getFoods().get(0).getExdYear()));
        }

        pickOutTf1.clear();
        pickOutTf2.clear();
        pickOutTf3.clear();
        pickOutTf4.clear();
        pickOutTf5.clear();
        pickOutTf6.clear();
        pickOutTf7.clear();
        pickOutTf8.clear();
    }

    public void addBtn(ActionEvent event) throws IOException {
//        Parent connector = (Parent) FXMLLoader.load(this.getClass().getResource("RefrigeratorAdd.fxml"));
//        Scene scene = new Scene(connector);
//        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();

        Button b = (Button)event.getSource();
        Stage stage = (Stage)b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("RefrigeratorAdd.fxml"));
        stage.setScene(new Scene((Parent)loader.load(), 650, 950));

        RefrigeratorAddController LoadCompartment1 = (RefrigeratorAddController)loader.getController();
        LoadCompartment1.setCompartment1(this.compartment1);

        RefrigeratorAddController LoadCompartment2 = (RefrigeratorAddController)loader.getController();
        LoadCompartment2.setCompartment2(this.compartment2);

        RefrigeratorAddController LoadCompartment3 = (RefrigeratorAddController)loader.getController();
        LoadCompartment3.setCompartment3(this.compartment3);

        RefrigeratorAddController LoadCompartment4 = (RefrigeratorAddController)loader.getController();
        LoadCompartment4.setCompartment4(this.compartment4);


        RefrigeratorAddController LoadCompartment5 = (RefrigeratorAddController)loader.getController();
        LoadCompartment5.setCompartment5(this.compartment5);

        RefrigeratorAddController LoadCompartment6 = (RefrigeratorAddController)loader.getController();
        LoadCompartment6.setCompartment6(this.compartment6);

        RefrigeratorAddController LoadFreezingCompartment1 = (RefrigeratorAddController)loader.getController();
        LoadFreezingCompartment1.setFreezingCompartment1(this.freezingCompartment1);

        RefrigeratorAddController LoadFreezingCompartment2 = (RefrigeratorAddController)loader.getController();
        LoadFreezingCompartment2.setFreezingCompartment2(this.freezingCompartment2);




    }


    public void backBtn(ActionEvent event) throws IOException {
//        Parent connector = (Parent) FXMLLoader.load(this.getClass().getResource("Door.fxml"));
//        Scene scene = new Scene(connector);
//        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();

        Button b = (Button)event.getSource();
        Stage stage = (Stage)b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Door.fxml"));
        stage.setScene(new Scene((Parent)loader.load(), 650, 950));

        DoorController LoadCompartment1 = (DoorController)loader.getController();
        LoadCompartment1.DoorControllerSetCompartment1(this.compartment1);

        DoorController LoadCompartment2 = (DoorController)loader.getController();
        LoadCompartment2.DoorControllerSetCompartment2(this.compartment2);

        DoorController LoadCompartment3 = (DoorController)loader.getController();
        LoadCompartment3.DoorControllerSetCompartment3(this.compartment3);

        DoorController LoadCompartment4 = (DoorController)loader.getController();
        LoadCompartment4.DoorControllerSetCompartment4(this.compartment4);

        DoorController LoadCompartment5 = (DoorController)loader.getController();
        LoadCompartment5.DoorControllerSetCompartment5(this.compartment5);

        DoorController LoadCompartment6 = (DoorController)loader.getController();
        LoadCompartment6.DoorControllerSetCompartment6(this.compartment6);

        DoorController LoadFreezingCompartment1 = (DoorController)loader.getController();
        LoadFreezingCompartment1.DoorControllerSetFreezingCompartment1(this.freezingCompartment1);

        DoorController LoadFreezingCompartment2 = (DoorController)loader.getController();
        LoadFreezingCompartment2.DoorControllerSetFreezingCompartment2(this.freezingCompartment2);

    }


    public void pickOutBtn1(ActionEvent event) {
        int quantity1;
        if (pickOutTf1.getText().isEmpty()){
            Alert al =new Alert(Alert.AlertType.WARNING);
            al.setTitle("ผิดพลาด");
            al.setContentText("กรุณาใส่จำนวนที่ต้องการนำออก");
            al.setHeaderText(null);
            al.showAndWait();
        }
        else{
            quantity1 =  Integer.parseInt(pickOutTf1.getText());
            if(quantity1<=0){
                Alert al =new Alert(Alert.AlertType.WARNING);
                al.setTitle("ผิดพลาด");
                al.setContentText("จำนวนที่ต้องการนำออกผิดพลาด กรุณาใส่ค่าที่มากกว่า 0");
                al.setHeaderText(null);
                al.showAndWait();
            }
            else {
                if (compartment1.getFoods().isEmpty()){
                    nameTf1.clear();
                    quantityTf1.clear();
                    unitTf1.clear();
                    exdDTf1.clear();
                    exdMTf1.clear();
                    exdYTF1.clear();
                }
                else {
                    if (compartment1.getFoods().get(0).getQuantity() - quantity1 < 0){
                        Alert al =new Alert(Alert.AlertType.WARNING);
                        al.setTitle("ผิดพลาด");
                        al.setContentText("จำนวนที่นำออกมากกว่าจำนวนที่มีอยู่ในช่องแช่");
                        al.setHeaderText(null);
                        al.showAndWait();
                    }
                    else {
                        compartment1.pickedOut(quantity1);
                        compartment1.delete();
                        if (compartment1.getFoods().isEmpty()) {
                            nameTf1.clear();
                            quantityTf1.clear();
                            unitTf1.clear();
                            exdDTf1.clear();
                            exdMTf1.clear();
                            exdYTF1.clear();
                        }



                        pickOutTf1.clear();


                        compartment1.sortFood();
                        compartment2.sortFood();
                        compartment3.sortFood();
                        compartment4.sortFood();
                        compartment5.sortFood();
                        compartment6.sortFood();
                        freezingCompartment1.sortFood();
                        freezingCompartment2.sortFood();



                        if (this.compartment1.getFoods().isEmpty()==false){
                            nameTf1.setText(compartment1.getFoods().get(0).getName());
                            quantityTf1.setText(String.valueOf(compartment1.getFirstFood().getQuantity()));
                            unitTf1.setText(compartment1.getFoods().get(0).getUnit());
                            exdDTf1.setText(String.valueOf(compartment1.getFoods().get(0).getExdDay()));
                            exdMTf1.setText(String.valueOf(compartment1.getFoods().get(0).getExdMonth()));
                            exdYTF1.setText(String.valueOf(compartment1.getFoods().get(0).getExdYear()));
                        }


                        if (this.compartment2.getFoods().isEmpty()==false){
                            nameTf2.setText(compartment2.getFoods().get(0).getName());
                            quantityTf2.setText(String.valueOf(compartment2.getFirstFood().getQuantity()));
                            unitTf2.setText(compartment2.getFoods().get(0).getUnit());
                            exdDTf2.setText(String.valueOf(compartment2.getFoods().get(0).getExdDay()));
                            exdMTf2.setText(String.valueOf(compartment2.getFoods().get(0).getExdMonth()));
                            exdYTF2.setText(String.valueOf(compartment2.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment3.getFoods().isEmpty()==false){
                            nameTf3.setText(compartment3.getFoods().get(0).getName());
                            quantityTf3.setText(String.valueOf(compartment3.getFirstFood().getQuantity()));
                            unitTf3.setText(compartment3.getFoods().get(0).getUnit());
                            exdDTf3.setText(String.valueOf(compartment3.getFoods().get(0).getExdDay()));
                            exdMTf3.setText(String.valueOf(compartment3.getFoods().get(0).getExdMonth()));
                            exdYTF3.setText(String.valueOf(compartment3.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment4.getFoods().isEmpty()==false){
                            nameTf4.setText(compartment4.getFoods().get(0).getName());
                            quantityTf4.setText(String.valueOf(compartment4.getFirstFood().getQuantity()));
                            unitTf4.setText(compartment4.getFoods().get(0).getUnit());
                            exdDTf4.setText(String.valueOf(compartment4.getFoods().get(0).getExdDay()));
                            exdMTf4.setText(String.valueOf(compartment4.getFoods().get(0).getExdMonth()));
                            exdYTF4.setText(String.valueOf(compartment4.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment5.getFoods().isEmpty()==false){
                            nameTf5.setText(compartment5.getFoods().get(0).getName());
                            quantityTf5.setText(String.valueOf(compartment5.getFirstFood().getQuantity()));
                            unitTf5.setText(compartment5.getFoods().get(0).getUnit());
                            exdDTf5.setText(String.valueOf(compartment5.getFoods().get(0).getExdDay()));
                            exdMTf5.setText(String.valueOf(compartment5.getFoods().get(0).getExdMonth()));
                            exdYTF5.setText(String.valueOf(compartment5.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment6.getFoods().isEmpty()==false){
                            nameTf6.setText(compartment6.getFoods().get(0).getName());
                            quantityTf6.setText(String.valueOf(compartment6.getFirstFood().getQuantity()));
                            unitTf6.setText(compartment6.getFoods().get(0).getUnit());
                            exdDTf6.setText(String.valueOf(compartment6.getFoods().get(0).getExdDay()));
                            exdMTf6.setText(String.valueOf(compartment6.getFoods().get(0).getExdMonth()));
                            exdYTF6.setText(String.valueOf(compartment6.getFoods().get(0).getExdYear()));
                        }

                        if (this.freezingCompartment1.getFoods().isEmpty()==false){
                            nameTf7.setText(freezingCompartment1.getFoods().get(0).getName());
                            quantityTf7.setText(String.valueOf(freezingCompartment1.getFirstFood().getQuantity()));
                            unitTf7.setText(freezingCompartment1.getFoods().get(0).getUnit());
                            exdDTf7.setText(String.valueOf(freezingCompartment1.getFoods().get(0).getExdDay()));
                            exdMTf7.setText(String.valueOf(freezingCompartment1.getFoods().get(0).getExdMonth()));
                            exdYTF7.setText(String.valueOf(freezingCompartment1.getFoods().get(0).getExdYear()));
                        }

                        if (this.freezingCompartment2.getFoods().isEmpty()==false){
                            nameTf8.setText(freezingCompartment2.getFoods().get(0).getName());
                            quantityTf8.setText(String.valueOf(freezingCompartment2.getFirstFood().getQuantity()));
                            unitTf8.setText(freezingCompartment2.getFoods().get(0).getUnit());
                            exdDTf8.setText(String.valueOf(freezingCompartment2.getFoods().get(0).getExdDay()));
                            exdMTf8.setText(String.valueOf(freezingCompartment2.getFoods().get(0).getExdMonth()));
                            exdYTF8.setText(String.valueOf(freezingCompartment2.getFoods().get(0).getExdYear()));
                        }


                    }
                }


            }
        }




    }

    public void pickOutBtn2(ActionEvent event) {
        int quantity2;
        if (pickOutTf2.getText().isEmpty()){
            Alert al =new Alert(Alert.AlertType.WARNING);
            al.setTitle("ผิดพลาด");
            al.setContentText("กรุณาใส่จำนวนที่ต้องการนำออก");
            al.setHeaderText(null);
            al.showAndWait();
        }
        else{
            quantity2 =  Integer.parseInt(pickOutTf2.getText());
            if(quantity2<=0){
                Alert al =new Alert(Alert.AlertType.WARNING);
                al.setTitle("ผิดพลาด");
                al.setContentText("จำนวนที่ต้องการนำออกผิดพลาด กรุณาใส่ค่าที่มากกว่า 0");
                al.setHeaderText(null);
                al.showAndWait();
            }
            else {
                if (compartment2.getFoods().isEmpty()){
                    nameTf2.clear();
                    quantityTf2.clear();
                    unitTf2.clear();
                    exdDTf2.clear();
                    exdMTf2.clear();
                    exdYTF2.clear();
                }
                else {
                    if (compartment2.getFoods().get(0).getQuantity() - quantity2 < 0){
                        Alert al =new Alert(Alert.AlertType.WARNING);
                        al.setTitle("ผิดพลาด");
                        al.setContentText("จำนวนที่นำออกมากกว่าจำนวนที่มีอยู่ในช่องแช่");
                        al.setHeaderText(null);
                        al.showAndWait();
                    }
                    else {
                        compartment2.pickedOut(quantity2);
                        compartment2.delete();
                        if (compartment2.getFoods().isEmpty()) {
                            nameTf2.clear();
                            quantityTf2.clear();
                            unitTf2.clear();
                            exdDTf2.clear();
                            exdMTf2.clear();
                            exdYTF2.clear();
                        }



                        pickOutTf2.clear();


                        compartment1.sortFood();
                        compartment2.sortFood();
                        compartment3.sortFood();
                        compartment4.sortFood();
                        compartment5.sortFood();
                        compartment6.sortFood();
                        freezingCompartment1.sortFood();
                        freezingCompartment2.sortFood();



                        if (this.compartment1.getFoods().isEmpty()==false){
                            nameTf1.setText(compartment1.getFoods().get(0).getName());
                            quantityTf1.setText(String.valueOf(compartment1.getFirstFood().getQuantity()));
                            unitTf1.setText(compartment1.getFoods().get(0).getUnit());
                            exdDTf1.setText(String.valueOf(compartment1.getFoods().get(0).getExdDay()));
                            exdMTf1.setText(String.valueOf(compartment1.getFoods().get(0).getExdMonth()));
                            exdYTF1.setText(String.valueOf(compartment1.getFoods().get(0).getExdYear()));
                        }


                        if (this.compartment2.getFoods().isEmpty()==false){
                            nameTf2.setText(compartment2.getFoods().get(0).getName());
                            quantityTf2.setText(String.valueOf(compartment2.getFirstFood().getQuantity()));
                            unitTf2.setText(compartment2.getFoods().get(0).getUnit());
                            exdDTf2.setText(String.valueOf(compartment2.getFoods().get(0).getExdDay()));
                            exdMTf2.setText(String.valueOf(compartment2.getFoods().get(0).getExdMonth()));
                            exdYTF2.setText(String.valueOf(compartment2.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment3.getFoods().isEmpty()==false){
                            nameTf3.setText(compartment3.getFoods().get(0).getName());
                            quantityTf3.setText(String.valueOf(compartment3.getFirstFood().getQuantity()));
                            unitTf3.setText(compartment3.getFoods().get(0).getUnit());
                            exdDTf3.setText(String.valueOf(compartment3.getFoods().get(0).getExdDay()));
                            exdMTf3.setText(String.valueOf(compartment3.getFoods().get(0).getExdMonth()));
                            exdYTF3.setText(String.valueOf(compartment3.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment4.getFoods().isEmpty()==false){
                            nameTf4.setText(compartment4.getFoods().get(0).getName());
                            quantityTf4.setText(String.valueOf(compartment4.getFirstFood().getQuantity()));
                            unitTf4.setText(compartment4.getFoods().get(0).getUnit());
                            exdDTf4.setText(String.valueOf(compartment4.getFoods().get(0).getExdDay()));
                            exdMTf4.setText(String.valueOf(compartment4.getFoods().get(0).getExdMonth()));
                            exdYTF4.setText(String.valueOf(compartment4.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment5.getFoods().isEmpty()==false){
                            nameTf5.setText(compartment5.getFoods().get(0).getName());
                            quantityTf5.setText(String.valueOf(compartment5.getFirstFood().getQuantity()));
                            unitTf5.setText(compartment5.getFoods().get(0).getUnit());
                            exdDTf5.setText(String.valueOf(compartment5.getFoods().get(0).getExdDay()));
                            exdMTf5.setText(String.valueOf(compartment5.getFoods().get(0).getExdMonth()));
                            exdYTF5.setText(String.valueOf(compartment5.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment6.getFoods().isEmpty()==false){
                            nameTf6.setText(compartment6.getFoods().get(0).getName());
                            quantityTf6.setText(String.valueOf(compartment6.getFirstFood().getQuantity()));
                            unitTf6.setText(compartment6.getFoods().get(0).getUnit());
                            exdDTf6.setText(String.valueOf(compartment6.getFoods().get(0).getExdDay()));
                            exdMTf6.setText(String.valueOf(compartment6.getFoods().get(0).getExdMonth()));
                            exdYTF6.setText(String.valueOf(compartment6.getFoods().get(0).getExdYear()));
                        }

                        if (this.freezingCompartment1.getFoods().isEmpty()==false){
                            nameTf7.setText(freezingCompartment1.getFoods().get(0).getName());
                            quantityTf7.setText(String.valueOf(freezingCompartment1.getFirstFood().getQuantity()));
                            unitTf7.setText(freezingCompartment1.getFoods().get(0).getUnit());
                            exdDTf7.setText(String.valueOf(freezingCompartment1.getFoods().get(0).getExdDay()));
                            exdMTf7.setText(String.valueOf(freezingCompartment1.getFoods().get(0).getExdMonth()));
                            exdYTF7.setText(String.valueOf(freezingCompartment1.getFoods().get(0).getExdYear()));
                        }

                        if (this.freezingCompartment2.getFoods().isEmpty()==false){
                            nameTf8.setText(freezingCompartment2.getFoods().get(0).getName());
                            quantityTf8.setText(String.valueOf(freezingCompartment2.getFirstFood().getQuantity()));
                            unitTf8.setText(freezingCompartment2.getFoods().get(0).getUnit());
                            exdDTf8.setText(String.valueOf(freezingCompartment2.getFoods().get(0).getExdDay()));
                            exdMTf8.setText(String.valueOf(freezingCompartment2.getFoods().get(0).getExdMonth()));
                            exdYTF8.setText(String.valueOf(freezingCompartment2.getFoods().get(0).getExdYear()));
                        }


                    }
                }


            }
        }
    }

    public void pickOutBtn3(ActionEvent event) {
        int quantity3;
        if (pickOutTf3.getText().isEmpty()){
            Alert al =new Alert(Alert.AlertType.WARNING);
            al.setTitle("ผิดพลาด");
            al.setContentText("กรุณาใส่จำนวนที่ต้องการนำออก");
            al.setHeaderText(null);
            al.showAndWait();
        }
        else{
            quantity3 =  Integer.parseInt(pickOutTf3.getText());
            if(quantity3<=0){
                Alert al =new Alert(Alert.AlertType.WARNING);
                al.setTitle("ผิดพลาด");
                al.setContentText("จำนวนที่ต้องการนำออกผิดพลาด กรุณาใส่ค่าที่มากกว่า 0");
                al.setHeaderText(null);
                al.showAndWait();
            }
            else {
                if (compartment3.getFoods().isEmpty()){
                    nameTf3.clear();
                    quantityTf3.clear();
                    unitTf3.clear();
                    exdDTf3.clear();
                    exdMTf3.clear();
                    exdYTF3.clear();
                }
                else {
                    if (compartment3.getFoods().get(0).getQuantity() - quantity3 < 0){
                        Alert al =new Alert(Alert.AlertType.WARNING);
                        al.setTitle("ผิดพลาด");
                        al.setContentText("จำนวนที่นำออกมากกว่าจำนวนที่มีอยู่ในช่องแช่");
                        al.setHeaderText(null);
                        al.showAndWait();
                    }
                    else {
                        compartment3.pickedOut(quantity3);
                        compartment3.delete();
                        if (compartment3.getFoods().isEmpty()) {
                            nameTf3.clear();
                            quantityTf3.clear();
                            unitTf3.clear();
                            exdDTf3.clear();
                            exdMTf3.clear();
                            exdYTF3.clear();
                        }



                        pickOutTf3.clear();


                        compartment1.sortFood();
                        compartment2.sortFood();
                        compartment3.sortFood();
                        compartment4.sortFood();
                        compartment5.sortFood();
                        compartment6.sortFood();
                        freezingCompartment1.sortFood();
                        freezingCompartment2.sortFood();



                        if (this.compartment1.getFoods().isEmpty()==false){
                            nameTf1.setText(compartment1.getFoods().get(0).getName());
                            quantityTf1.setText(String.valueOf(compartment1.getFirstFood().getQuantity()));
                            unitTf1.setText(compartment1.getFoods().get(0).getUnit());
                            exdDTf1.setText(String.valueOf(compartment1.getFoods().get(0).getExdDay()));
                            exdMTf1.setText(String.valueOf(compartment1.getFoods().get(0).getExdMonth()));
                            exdYTF1.setText(String.valueOf(compartment1.getFoods().get(0).getExdYear()));
                        }


                        if (this.compartment2.getFoods().isEmpty()==false){
                            nameTf2.setText(compartment2.getFoods().get(0).getName());
                            quantityTf2.setText(String.valueOf(compartment2.getFirstFood().getQuantity()));
                            unitTf2.setText(compartment2.getFoods().get(0).getUnit());
                            exdDTf2.setText(String.valueOf(compartment2.getFoods().get(0).getExdDay()));
                            exdMTf2.setText(String.valueOf(compartment2.getFoods().get(0).getExdMonth()));
                            exdYTF2.setText(String.valueOf(compartment2.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment3.getFoods().isEmpty()==false){
                            nameTf3.setText(compartment3.getFoods().get(0).getName());
                            quantityTf3.setText(String.valueOf(compartment3.getFirstFood().getQuantity()));
                            unitTf3.setText(compartment3.getFoods().get(0).getUnit());
                            exdDTf3.setText(String.valueOf(compartment3.getFoods().get(0).getExdDay()));
                            exdMTf3.setText(String.valueOf(compartment3.getFoods().get(0).getExdMonth()));
                            exdYTF3.setText(String.valueOf(compartment3.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment4.getFoods().isEmpty()==false){
                            nameTf4.setText(compartment4.getFoods().get(0).getName());
                            quantityTf4.setText(String.valueOf(compartment4.getFirstFood().getQuantity()));
                            unitTf4.setText(compartment4.getFoods().get(0).getUnit());
                            exdDTf4.setText(String.valueOf(compartment4.getFoods().get(0).getExdDay()));
                            exdMTf4.setText(String.valueOf(compartment4.getFoods().get(0).getExdMonth()));
                            exdYTF4.setText(String.valueOf(compartment4.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment5.getFoods().isEmpty()==false){
                            nameTf5.setText(compartment5.getFoods().get(0).getName());
                            quantityTf5.setText(String.valueOf(compartment5.getFirstFood().getQuantity()));
                            unitTf5.setText(compartment5.getFoods().get(0).getUnit());
                            exdDTf5.setText(String.valueOf(compartment5.getFoods().get(0).getExdDay()));
                            exdMTf5.setText(String.valueOf(compartment5.getFoods().get(0).getExdMonth()));
                            exdYTF5.setText(String.valueOf(compartment5.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment6.getFoods().isEmpty()==false){
                            nameTf6.setText(compartment6.getFoods().get(0).getName());
                            quantityTf6.setText(String.valueOf(compartment6.getFirstFood().getQuantity()));
                            unitTf6.setText(compartment6.getFoods().get(0).getUnit());
                            exdDTf6.setText(String.valueOf(compartment6.getFoods().get(0).getExdDay()));
                            exdMTf6.setText(String.valueOf(compartment6.getFoods().get(0).getExdMonth()));
                            exdYTF6.setText(String.valueOf(compartment6.getFoods().get(0).getExdYear()));
                        }

                        if (this.freezingCompartment1.getFoods().isEmpty()==false){
                            nameTf7.setText(freezingCompartment1.getFoods().get(0).getName());
                            quantityTf7.setText(String.valueOf(freezingCompartment1.getFirstFood().getQuantity()));
                            unitTf7.setText(freezingCompartment1.getFoods().get(0).getUnit());
                            exdDTf7.setText(String.valueOf(freezingCompartment1.getFoods().get(0).getExdDay()));
                            exdMTf7.setText(String.valueOf(freezingCompartment1.getFoods().get(0).getExdMonth()));
                            exdYTF7.setText(String.valueOf(freezingCompartment1.getFoods().get(0).getExdYear()));
                        }

                        if (this.freezingCompartment2.getFoods().isEmpty()==false){
                            nameTf8.setText(freezingCompartment2.getFoods().get(0).getName());
                            quantityTf8.setText(String.valueOf(freezingCompartment2.getFirstFood().getQuantity()));
                            unitTf8.setText(freezingCompartment2.getFoods().get(0).getUnit());
                            exdDTf8.setText(String.valueOf(freezingCompartment2.getFoods().get(0).getExdDay()));
                            exdMTf8.setText(String.valueOf(freezingCompartment2.getFoods().get(0).getExdMonth()));
                            exdYTF8.setText(String.valueOf(freezingCompartment2.getFoods().get(0).getExdYear()));
                        }


                    }
                }


            }
        }
    }

    public void pickOutBtn4(ActionEvent event) {
        int quantity4;
        if (pickOutTf4.getText().isEmpty()){
            Alert al =new Alert(Alert.AlertType.WARNING);
            al.setTitle("ผิดพลาด");
            al.setContentText("กรุณาใส่จำนวนที่ต้องการนำออก");
            al.setHeaderText(null);
            al.showAndWait();
        }
        else{
            quantity4 =  Integer.parseInt(pickOutTf4.getText());
            if(quantity4<=0){
                Alert al =new Alert(Alert.AlertType.WARNING);
                al.setTitle("ผิดพลาด");
                al.setContentText("จำนวนที่ต้องการนำออกผิดพลาด กรุณาใส่ค่าที่มากกว่า 0");
                al.setHeaderText(null);
                al.showAndWait();
            }
            else {
                if (compartment4.getFoods().isEmpty()){
                    nameTf4.clear();
                    quantityTf4.clear();
                    unitTf4.clear();
                    exdDTf4.clear();
                    exdMTf4.clear();
                    exdYTF4.clear();
                }
                else {
                    if (compartment4.getFoods().get(0).getQuantity() - quantity4 < 0){
                        Alert al =new Alert(Alert.AlertType.WARNING);
                        al.setTitle("ผิดพลาด");
                        al.setContentText("จำนวนที่นำออกมากกว่าจำนวนที่มีอยู่ในช่องแช่");
                        al.setHeaderText(null);
                        al.showAndWait();
                    }
                    else {
                        compartment4.pickedOut(quantity4);
                        compartment4.delete();
                        if (compartment4.getFoods().isEmpty()) {
                            nameTf4.clear();
                            quantityTf4.clear();
                            unitTf4.clear();
                            exdDTf4.clear();
                            exdMTf4.clear();
                            exdYTF4.clear();
                        }



                        pickOutTf4.clear();


                        compartment1.sortFood();
                        compartment2.sortFood();
                        compartment3.sortFood();
                        compartment4.sortFood();
                        compartment5.sortFood();
                        compartment6.sortFood();
                        freezingCompartment1.sortFood();
                        freezingCompartment2.sortFood();



                        if (this.compartment1.getFoods().isEmpty()==false){
                            nameTf1.setText(compartment1.getFoods().get(0).getName());
                            quantityTf1.setText(String.valueOf(compartment1.getFirstFood().getQuantity()));
                            unitTf1.setText(compartment1.getFoods().get(0).getUnit());
                            exdDTf1.setText(String.valueOf(compartment1.getFoods().get(0).getExdDay()));
                            exdMTf1.setText(String.valueOf(compartment1.getFoods().get(0).getExdMonth()));
                            exdYTF1.setText(String.valueOf(compartment1.getFoods().get(0).getExdYear()));
                        }


                        if (this.compartment2.getFoods().isEmpty()==false){
                            nameTf2.setText(compartment2.getFoods().get(0).getName());
                            quantityTf2.setText(String.valueOf(compartment2.getFirstFood().getQuantity()));
                            unitTf2.setText(compartment2.getFoods().get(0).getUnit());
                            exdDTf2.setText(String.valueOf(compartment2.getFoods().get(0).getExdDay()));
                            exdMTf2.setText(String.valueOf(compartment2.getFoods().get(0).getExdMonth()));
                            exdYTF2.setText(String.valueOf(compartment2.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment3.getFoods().isEmpty()==false){
                            nameTf3.setText(compartment3.getFoods().get(0).getName());
                            quantityTf3.setText(String.valueOf(compartment3.getFirstFood().getQuantity()));
                            unitTf3.setText(compartment3.getFoods().get(0).getUnit());
                            exdDTf3.setText(String.valueOf(compartment3.getFoods().get(0).getExdDay()));
                            exdMTf3.setText(String.valueOf(compartment3.getFoods().get(0).getExdMonth()));
                            exdYTF3.setText(String.valueOf(compartment3.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment4.getFoods().isEmpty()==false){
                            nameTf4.setText(compartment4.getFoods().get(0).getName());
                            quantityTf4.setText(String.valueOf(compartment4.getFirstFood().getQuantity()));
                            unitTf4.setText(compartment4.getFoods().get(0).getUnit());
                            exdDTf4.setText(String.valueOf(compartment4.getFoods().get(0).getExdDay()));
                            exdMTf4.setText(String.valueOf(compartment4.getFoods().get(0).getExdMonth()));
                            exdYTF4.setText(String.valueOf(compartment4.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment5.getFoods().isEmpty()==false){
                            nameTf5.setText(compartment5.getFoods().get(0).getName());
                            quantityTf5.setText(String.valueOf(compartment5.getFirstFood().getQuantity()));
                            unitTf5.setText(compartment5.getFoods().get(0).getUnit());
                            exdDTf5.setText(String.valueOf(compartment5.getFoods().get(0).getExdDay()));
                            exdMTf5.setText(String.valueOf(compartment5.getFoods().get(0).getExdMonth()));
                            exdYTF5.setText(String.valueOf(compartment5.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment6.getFoods().isEmpty()==false){
                            nameTf6.setText(compartment6.getFoods().get(0).getName());
                            quantityTf6.setText(String.valueOf(compartment6.getFirstFood().getQuantity()));
                            unitTf6.setText(compartment6.getFoods().get(0).getUnit());
                            exdDTf6.setText(String.valueOf(compartment6.getFoods().get(0).getExdDay()));
                            exdMTf6.setText(String.valueOf(compartment6.getFoods().get(0).getExdMonth()));
                            exdYTF6.setText(String.valueOf(compartment6.getFoods().get(0).getExdYear()));
                        }

                        if (this.freezingCompartment1.getFoods().isEmpty()==false){
                            nameTf7.setText(freezingCompartment1.getFoods().get(0).getName());
                            quantityTf7.setText(String.valueOf(freezingCompartment1.getFirstFood().getQuantity()));
                            unitTf7.setText(freezingCompartment1.getFoods().get(0).getUnit());
                            exdDTf7.setText(String.valueOf(freezingCompartment1.getFoods().get(0).getExdDay()));
                            exdMTf7.setText(String.valueOf(freezingCompartment1.getFoods().get(0).getExdMonth()));
                            exdYTF7.setText(String.valueOf(freezingCompartment1.getFoods().get(0).getExdYear()));
                        }

                        if (this.freezingCompartment2.getFoods().isEmpty()==false){
                            nameTf8.setText(freezingCompartment2.getFoods().get(0).getName());
                            quantityTf8.setText(String.valueOf(freezingCompartment2.getFirstFood().getQuantity()));
                            unitTf8.setText(freezingCompartment2.getFoods().get(0).getUnit());
                            exdDTf8.setText(String.valueOf(freezingCompartment2.getFoods().get(0).getExdDay()));
                            exdMTf8.setText(String.valueOf(freezingCompartment2.getFoods().get(0).getExdMonth()));
                            exdYTF8.setText(String.valueOf(freezingCompartment2.getFoods().get(0).getExdYear()));
                        }


                    }
                }


            }
        }
    }

    public void pickOutBtn5(ActionEvent event) {
        int quantity5;
        if (pickOutTf5.getText().isEmpty()){
            Alert al =new Alert(Alert.AlertType.WARNING);
            al.setTitle("ผิดพลาด");
            al.setContentText("กรุณาใส่จำนวนที่ต้องการนำออก");
            al.setHeaderText(null);
            al.showAndWait();
        }
        else{
            quantity5 =  Integer.parseInt(pickOutTf5.getText());
            if(quantity5<=0){
                Alert al =new Alert(Alert.AlertType.WARNING);
                al.setTitle("ผิดพลาด");
                al.setContentText("จำนวนที่ต้องการนำออกผิดพลาด กรุณาใส่ค่าที่มากกว่า 0");
                al.setHeaderText(null);
                al.showAndWait();
            }
            else {
                if (compartment5.getFoods().isEmpty()){
                    nameTf5.clear();
                    quantityTf5.clear();
                    unitTf5.clear();
                    exdDTf5.clear();
                    exdMTf5.clear();
                    exdYTF5.clear();
                }
                else {
                    if (compartment5.getFoods().get(0).getQuantity() - quantity5 < 0){
                        Alert al =new Alert(Alert.AlertType.WARNING);
                        al.setTitle("ผิดพลาด");
                        al.setContentText("จำนวนที่นำออกมากกว่าจำนวนที่มีอยู่ในช่องแช่");
                        al.setHeaderText(null);
                        al.showAndWait();
                    }
                    else {
                        compartment5.pickedOut(quantity5);
                        compartment5.delete();
                        if (compartment5.getFoods().isEmpty()) {
                            nameTf5.clear();
                            quantityTf5.clear();
                            unitTf5.clear();
                            exdDTf5.clear();
                            exdMTf5.clear();
                            exdYTF5.clear();
                        }



                        pickOutTf5.clear();


                        compartment1.sortFood();
                        compartment2.sortFood();
                        compartment3.sortFood();
                        compartment4.sortFood();
                        compartment5.sortFood();
                        compartment6.sortFood();
                        freezingCompartment1.sortFood();
                        freezingCompartment2.sortFood();



                        if (this.compartment1.getFoods().isEmpty()==false){
                            nameTf1.setText(compartment1.getFoods().get(0).getName());
                            quantityTf1.setText(String.valueOf(compartment1.getFirstFood().getQuantity()));
                            unitTf1.setText(compartment1.getFoods().get(0).getUnit());
                            exdDTf1.setText(String.valueOf(compartment1.getFoods().get(0).getExdDay()));
                            exdMTf1.setText(String.valueOf(compartment1.getFoods().get(0).getExdMonth()));
                            exdYTF1.setText(String.valueOf(compartment1.getFoods().get(0).getExdYear()));
                        }


                        if (this.compartment2.getFoods().isEmpty()==false){
                            nameTf2.setText(compartment2.getFoods().get(0).getName());
                            quantityTf2.setText(String.valueOf(compartment2.getFirstFood().getQuantity()));
                            unitTf2.setText(compartment2.getFoods().get(0).getUnit());
                            exdDTf2.setText(String.valueOf(compartment2.getFoods().get(0).getExdDay()));
                            exdMTf2.setText(String.valueOf(compartment2.getFoods().get(0).getExdMonth()));
                            exdYTF2.setText(String.valueOf(compartment2.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment3.getFoods().isEmpty()==false){
                            nameTf3.setText(compartment3.getFoods().get(0).getName());
                            quantityTf3.setText(String.valueOf(compartment3.getFirstFood().getQuantity()));
                            unitTf3.setText(compartment3.getFoods().get(0).getUnit());
                            exdDTf3.setText(String.valueOf(compartment3.getFoods().get(0).getExdDay()));
                            exdMTf3.setText(String.valueOf(compartment3.getFoods().get(0).getExdMonth()));
                            exdYTF3.setText(String.valueOf(compartment3.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment4.getFoods().isEmpty()==false){
                            nameTf4.setText(compartment4.getFoods().get(0).getName());
                            quantityTf4.setText(String.valueOf(compartment4.getFirstFood().getQuantity()));
                            unitTf4.setText(compartment4.getFoods().get(0).getUnit());
                            exdDTf4.setText(String.valueOf(compartment4.getFoods().get(0).getExdDay()));
                            exdMTf4.setText(String.valueOf(compartment4.getFoods().get(0).getExdMonth()));
                            exdYTF4.setText(String.valueOf(compartment4.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment5.getFoods().isEmpty()==false){
                            nameTf5.setText(compartment5.getFoods().get(0).getName());
                            quantityTf5.setText(String.valueOf(compartment5.getFirstFood().getQuantity()));
                            unitTf5.setText(compartment5.getFoods().get(0).getUnit());
                            exdDTf5.setText(String.valueOf(compartment5.getFoods().get(0).getExdDay()));
                            exdMTf5.setText(String.valueOf(compartment5.getFoods().get(0).getExdMonth()));
                            exdYTF5.setText(String.valueOf(compartment5.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment6.getFoods().isEmpty()==false){
                            nameTf6.setText(compartment6.getFoods().get(0).getName());
                            quantityTf6.setText(String.valueOf(compartment6.getFirstFood().getQuantity()));
                            unitTf6.setText(compartment6.getFoods().get(0).getUnit());
                            exdDTf6.setText(String.valueOf(compartment6.getFoods().get(0).getExdDay()));
                            exdMTf6.setText(String.valueOf(compartment6.getFoods().get(0).getExdMonth()));
                            exdYTF6.setText(String.valueOf(compartment6.getFoods().get(0).getExdYear()));
                        }

                        if (this.freezingCompartment1.getFoods().isEmpty()==false){
                            nameTf7.setText(freezingCompartment1.getFoods().get(0).getName());
                            quantityTf7.setText(String.valueOf(freezingCompartment1.getFirstFood().getQuantity()));
                            unitTf7.setText(freezingCompartment1.getFoods().get(0).getUnit());
                            exdDTf7.setText(String.valueOf(freezingCompartment1.getFoods().get(0).getExdDay()));
                            exdMTf7.setText(String.valueOf(freezingCompartment1.getFoods().get(0).getExdMonth()));
                            exdYTF7.setText(String.valueOf(freezingCompartment1.getFoods().get(0).getExdYear()));
                        }

                        if (this.freezingCompartment2.getFoods().isEmpty()==false){
                            nameTf8.setText(freezingCompartment2.getFoods().get(0).getName());
                            quantityTf8.setText(String.valueOf(freezingCompartment2.getFirstFood().getQuantity()));
                            unitTf8.setText(freezingCompartment2.getFoods().get(0).getUnit());
                            exdDTf8.setText(String.valueOf(freezingCompartment2.getFoods().get(0).getExdDay()));
                            exdMTf8.setText(String.valueOf(freezingCompartment2.getFoods().get(0).getExdMonth()));
                            exdYTF8.setText(String.valueOf(freezingCompartment2.getFoods().get(0).getExdYear()));
                        }


                    }
                }


            }
        }


    }

    public void pickOutBtn6(ActionEvent event) {
        int quantity6;
        if (pickOutTf6.getText().isEmpty()){
            Alert al =new Alert(Alert.AlertType.WARNING);
            al.setTitle("ผิดพลาด");
            al.setContentText("กรุณาใส่จำนวนที่ต้องการนำออก");
            al.setHeaderText(null);
            al.showAndWait();
        }
        else{
            quantity6 =  Integer.parseInt(pickOutTf6.getText());
            if(quantity6<=0){
                Alert al =new Alert(Alert.AlertType.WARNING);
                al.setTitle("ผิดพลาด");
                al.setContentText("จำนวนที่ต้องการนำออกผิดพลาด กรุณาใส่ค่าที่มากกว่า 0");
                al.setHeaderText(null);
                al.showAndWait();
            }
            else {
                if (compartment6.getFoods().isEmpty()){
                    nameTf6.clear();
                    quantityTf6.clear();
                    unitTf6.clear();
                    exdDTf6.clear();
                    exdMTf6.clear();
                    exdYTF6.clear();
                }
                else {
                    if (compartment6.getFoods().get(0).getQuantity() - quantity6 < 0){
                        Alert al =new Alert(Alert.AlertType.WARNING);
                        al.setTitle("ผิดพลาด");
                        al.setContentText("จำนวนที่นำออกมากกว่าจำนวนที่มีอยู่ในช่องแช่");
                        al.setHeaderText(null);
                        al.showAndWait();
                    }
                    else {
                        compartment6.pickedOut(quantity6);
                        compartment6.delete();
                        if (compartment6.getFoods().isEmpty()) {
                            nameTf6.clear();
                            quantityTf6.clear();
                            unitTf6.clear();
                            exdDTf6.clear();
                            exdMTf6.clear();
                            exdYTF6.clear();
                        }



                        pickOutTf6.clear();


                        compartment1.sortFood();
                        compartment2.sortFood();
                        compartment3.sortFood();
                        compartment4.sortFood();
                        compartment5.sortFood();
                        compartment6.sortFood();
                        freezingCompartment1.sortFood();
                        freezingCompartment2.sortFood();



                        if (this.compartment1.getFoods().isEmpty()==false){
                            nameTf1.setText(compartment1.getFoods().get(0).getName());
                            quantityTf1.setText(String.valueOf(compartment1.getFirstFood().getQuantity()));
                            unitTf1.setText(compartment1.getFoods().get(0).getUnit());
                            exdDTf1.setText(String.valueOf(compartment1.getFoods().get(0).getExdDay()));
                            exdMTf1.setText(String.valueOf(compartment1.getFoods().get(0).getExdMonth()));
                            exdYTF1.setText(String.valueOf(compartment1.getFoods().get(0).getExdYear()));
                        }


                        if (this.compartment2.getFoods().isEmpty()==false){
                            nameTf2.setText(compartment2.getFoods().get(0).getName());
                            quantityTf2.setText(String.valueOf(compartment2.getFirstFood().getQuantity()));
                            unitTf2.setText(compartment2.getFoods().get(0).getUnit());
                            exdDTf2.setText(String.valueOf(compartment2.getFoods().get(0).getExdDay()));
                            exdMTf2.setText(String.valueOf(compartment2.getFoods().get(0).getExdMonth()));
                            exdYTF2.setText(String.valueOf(compartment2.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment3.getFoods().isEmpty()==false){
                            nameTf3.setText(compartment3.getFoods().get(0).getName());
                            quantityTf3.setText(String.valueOf(compartment3.getFirstFood().getQuantity()));
                            unitTf3.setText(compartment3.getFoods().get(0).getUnit());
                            exdDTf3.setText(String.valueOf(compartment3.getFoods().get(0).getExdDay()));
                            exdMTf3.setText(String.valueOf(compartment3.getFoods().get(0).getExdMonth()));
                            exdYTF3.setText(String.valueOf(compartment3.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment4.getFoods().isEmpty()==false){
                            nameTf4.setText(compartment4.getFoods().get(0).getName());
                            quantityTf4.setText(String.valueOf(compartment4.getFirstFood().getQuantity()));
                            unitTf4.setText(compartment4.getFoods().get(0).getUnit());
                            exdDTf4.setText(String.valueOf(compartment4.getFoods().get(0).getExdDay()));
                            exdMTf4.setText(String.valueOf(compartment4.getFoods().get(0).getExdMonth()));
                            exdYTF4.setText(String.valueOf(compartment4.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment5.getFoods().isEmpty()==false){
                            nameTf5.setText(compartment5.getFoods().get(0).getName());
                            quantityTf5.setText(String.valueOf(compartment5.getFirstFood().getQuantity()));
                            unitTf5.setText(compartment5.getFoods().get(0).getUnit());
                            exdDTf5.setText(String.valueOf(compartment5.getFoods().get(0).getExdDay()));
                            exdMTf5.setText(String.valueOf(compartment5.getFoods().get(0).getExdMonth()));
                            exdYTF5.setText(String.valueOf(compartment5.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment6.getFoods().isEmpty()==false){
                            nameTf6.setText(compartment6.getFoods().get(0).getName());
                            quantityTf6.setText(String.valueOf(compartment6.getFirstFood().getQuantity()));
                            unitTf6.setText(compartment6.getFoods().get(0).getUnit());
                            exdDTf6.setText(String.valueOf(compartment6.getFoods().get(0).getExdDay()));
                            exdMTf6.setText(String.valueOf(compartment6.getFoods().get(0).getExdMonth()));
                            exdYTF6.setText(String.valueOf(compartment6.getFoods().get(0).getExdYear()));
                        }

                        if (this.freezingCompartment1.getFoods().isEmpty()==false){
                            nameTf7.setText(freezingCompartment1.getFoods().get(0).getName());
                            quantityTf7.setText(String.valueOf(freezingCompartment1.getFirstFood().getQuantity()));
                            unitTf7.setText(freezingCompartment1.getFoods().get(0).getUnit());
                            exdDTf7.setText(String.valueOf(freezingCompartment1.getFoods().get(0).getExdDay()));
                            exdMTf7.setText(String.valueOf(freezingCompartment1.getFoods().get(0).getExdMonth()));
                            exdYTF7.setText(String.valueOf(freezingCompartment1.getFoods().get(0).getExdYear()));
                        }

                        if (this.freezingCompartment2.getFoods().isEmpty()==false){
                            nameTf8.setText(freezingCompartment2.getFoods().get(0).getName());
                            quantityTf8.setText(String.valueOf(freezingCompartment2.getFirstFood().getQuantity()));
                            unitTf8.setText(freezingCompartment2.getFoods().get(0).getUnit());
                            exdDTf8.setText(String.valueOf(freezingCompartment2.getFoods().get(0).getExdDay()));
                            exdMTf8.setText(String.valueOf(freezingCompartment2.getFoods().get(0).getExdMonth()));
                            exdYTF8.setText(String.valueOf(freezingCompartment2.getFoods().get(0).getExdYear()));
                        }


                    }
                }


            }
        }
    }

    public void pickOutBtn7(ActionEvent event) {
        int quantity7;
        if (pickOutTf7.getText().isEmpty()){
            Alert al =new Alert(Alert.AlertType.WARNING);
            al.setTitle("ผิดพลาด");
            al.setContentText("กรุณาใส่จำนวนที่ต้องการนำออก");
            al.setHeaderText(null);
            al.showAndWait();
        }
        else{
            quantity7 =  Integer.parseInt(pickOutTf7.getText());
            if(quantity7<=0){
                Alert al =new Alert(Alert.AlertType.WARNING);
                al.setTitle("ผิดพลาด");
                al.setContentText("จำนวนที่ต้องการนำออกผิดพลาด กรุณาใส่ค่าที่มากกว่า 0");
                al.setHeaderText(null);
                al.showAndWait();
            }
            else {
                if (freezingCompartment1.getFoods().isEmpty()){
                    nameTf7.clear();
                    quantityTf7.clear();
                    unitTf7.clear();
                    exdDTf7.clear();
                    exdMTf7.clear();
                    exdYTF7.clear();
                }
                else {
                    if (freezingCompartment1.getFoods().get(0).getQuantity() - quantity7 < 0){
                        Alert al =new Alert(Alert.AlertType.WARNING);
                        al.setTitle("ผิดพลาด");
                        al.setContentText("จำนวนที่นำออกมากกว่าจำนวนที่มีอยู่ในช่องแช่");
                        al.setHeaderText(null);
                        al.showAndWait();
                    }
                    else {
                        freezingCompartment1.pickedOut(quantity7);
                        freezingCompartment1.delete();
                        if (freezingCompartment1.getFoods().isEmpty()) {
                            nameTf7.clear();
                            quantityTf7.clear();
                            unitTf7.clear();
                            exdDTf7.clear();
                            exdMTf7.clear();
                            exdYTF7.clear();
                        }



                        pickOutTf7.clear();


                        compartment1.sortFood();
                        compartment2.sortFood();
                        compartment3.sortFood();
                        compartment4.sortFood();
                        compartment5.sortFood();
                        compartment6.sortFood();
                        freezingCompartment1.sortFood();
                        freezingCompartment2.sortFood();



                        if (this.compartment1.getFoods().isEmpty()==false){
                            nameTf1.setText(compartment1.getFoods().get(0).getName());
                            quantityTf1.setText(String.valueOf(compartment1.getFirstFood().getQuantity()));
                            unitTf1.setText(compartment1.getFoods().get(0).getUnit());
                            exdDTf1.setText(String.valueOf(compartment1.getFoods().get(0).getExdDay()));
                            exdMTf1.setText(String.valueOf(compartment1.getFoods().get(0).getExdMonth()));
                            exdYTF1.setText(String.valueOf(compartment1.getFoods().get(0).getExdYear()));
                        }


                        if (this.compartment2.getFoods().isEmpty()==false){
                            nameTf2.setText(compartment2.getFoods().get(0).getName());
                            quantityTf2.setText(String.valueOf(compartment2.getFirstFood().getQuantity()));
                            unitTf2.setText(compartment2.getFoods().get(0).getUnit());
                            exdDTf2.setText(String.valueOf(compartment2.getFoods().get(0).getExdDay()));
                            exdMTf2.setText(String.valueOf(compartment2.getFoods().get(0).getExdMonth()));
                            exdYTF2.setText(String.valueOf(compartment2.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment3.getFoods().isEmpty()==false){
                            nameTf3.setText(compartment3.getFoods().get(0).getName());
                            quantityTf3.setText(String.valueOf(compartment3.getFirstFood().getQuantity()));
                            unitTf3.setText(compartment3.getFoods().get(0).getUnit());
                            exdDTf3.setText(String.valueOf(compartment3.getFoods().get(0).getExdDay()));
                            exdMTf3.setText(String.valueOf(compartment3.getFoods().get(0).getExdMonth()));
                            exdYTF3.setText(String.valueOf(compartment3.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment4.getFoods().isEmpty()==false){
                            nameTf4.setText(compartment4.getFoods().get(0).getName());
                            quantityTf4.setText(String.valueOf(compartment4.getFirstFood().getQuantity()));
                            unitTf4.setText(compartment4.getFoods().get(0).getUnit());
                            exdDTf4.setText(String.valueOf(compartment4.getFoods().get(0).getExdDay()));
                            exdMTf4.setText(String.valueOf(compartment4.getFoods().get(0).getExdMonth()));
                            exdYTF4.setText(String.valueOf(compartment4.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment5.getFoods().isEmpty()==false){
                            nameTf5.setText(compartment5.getFoods().get(0).getName());
                            quantityTf5.setText(String.valueOf(compartment5.getFirstFood().getQuantity()));
                            unitTf5.setText(compartment5.getFoods().get(0).getUnit());
                            exdDTf5.setText(String.valueOf(compartment5.getFoods().get(0).getExdDay()));
                            exdMTf5.setText(String.valueOf(compartment5.getFoods().get(0).getExdMonth()));
                            exdYTF5.setText(String.valueOf(compartment5.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment6.getFoods().isEmpty()==false){
                            nameTf6.setText(compartment6.getFoods().get(0).getName());
                            quantityTf6.setText(String.valueOf(compartment6.getFirstFood().getQuantity()));
                            unitTf6.setText(compartment6.getFoods().get(0).getUnit());
                            exdDTf6.setText(String.valueOf(compartment6.getFoods().get(0).getExdDay()));
                            exdMTf6.setText(String.valueOf(compartment6.getFoods().get(0).getExdMonth()));
                            exdYTF6.setText(String.valueOf(compartment6.getFoods().get(0).getExdYear()));
                        }

                        if (this.freezingCompartment1.getFoods().isEmpty()==false){
                            nameTf7.setText(freezingCompartment1.getFoods().get(0).getName());
                            quantityTf7.setText(String.valueOf(freezingCompartment1.getFirstFood().getQuantity()));
                            unitTf7.setText(freezingCompartment1.getFoods().get(0).getUnit());
                            exdDTf7.setText(String.valueOf(freezingCompartment1.getFoods().get(0).getExdDay()));
                            exdMTf7.setText(String.valueOf(freezingCompartment1.getFoods().get(0).getExdMonth()));
                            exdYTF7.setText(String.valueOf(freezingCompartment1.getFoods().get(0).getExdYear()));
                        }

                        if (this.freezingCompartment2.getFoods().isEmpty()==false){
                            nameTf8.setText(freezingCompartment2.getFoods().get(0).getName());
                            quantityTf8.setText(String.valueOf(freezingCompartment2.getFirstFood().getQuantity()));
                            unitTf8.setText(freezingCompartment2.getFoods().get(0).getUnit());
                            exdDTf8.setText(String.valueOf(freezingCompartment2.getFoods().get(0).getExdDay()));
                            exdMTf8.setText(String.valueOf(freezingCompartment2.getFoods().get(0).getExdMonth()));
                            exdYTF8.setText(String.valueOf(freezingCompartment2.getFoods().get(0).getExdYear()));
                        }


                    }
                }


            }
        }
    }

    public void pickOutBtn8(ActionEvent event) {
        int quantity8;
        if (pickOutTf8.getText().isEmpty()){
            Alert al =new Alert(Alert.AlertType.WARNING);
            al.setTitle("ผิดพลาด");
            al.setContentText("กรุณาใส่จำนวนที่ต้องการนำออก");
            al.setHeaderText(null);
            al.showAndWait();
        }
        else{
            quantity8 =  Integer.parseInt(pickOutTf8.getText());
            if(quantity8<=0){
                Alert al =new Alert(Alert.AlertType.WARNING);
                al.setTitle("ผิดพลาด");
                al.setContentText("จำนวนที่ต้องการนำออกผิดพลาด กรุณาใส่ค่าที่มากกว่า 0");
                al.setHeaderText(null);
                al.showAndWait();
            }
            else {
                if (freezingCompartment2.getFoods().isEmpty()){
                    nameTf8.clear();
                    quantityTf8.clear();
                    unitTf8.clear();
                    exdDTf8.clear();
                    exdMTf8.clear();
                    exdYTF8.clear();
                }
                else {
                    if (freezingCompartment2.getFoods().get(0).getQuantity() - quantity8 < 0){
                        Alert al =new Alert(Alert.AlertType.WARNING);
                        al.setTitle("ผิดพลาด");
                        al.setContentText("จำนวนที่นำออกมากกว่าจำนวนที่มีอยู่ในช่องแช่");
                        al.setHeaderText(null);
                        al.showAndWait();
                    }
                    else {
                        freezingCompartment2.pickedOut(quantity8);
                        freezingCompartment2.delete();
                        if (freezingCompartment2.getFoods().isEmpty()) {
                            nameTf8.clear();
                            quantityTf8.clear();
                            unitTf8.clear();
                            exdDTf8.clear();
                            exdMTf8.clear();
                            exdYTF8.clear();
                        }



                        pickOutTf8.clear();


                        compartment1.sortFood();
                        compartment2.sortFood();
                        compartment3.sortFood();
                        compartment4.sortFood();
                        compartment5.sortFood();
                        compartment6.sortFood();
                        freezingCompartment1.sortFood();
                        freezingCompartment2.sortFood();



                        if (this.compartment1.getFoods().isEmpty()==false){
                            nameTf1.setText(compartment1.getFoods().get(0).getName());
                            quantityTf1.setText(String.valueOf(compartment1.getFirstFood().getQuantity()));
                            unitTf1.setText(compartment1.getFoods().get(0).getUnit());
                            exdDTf1.setText(String.valueOf(compartment1.getFoods().get(0).getExdDay()));
                            exdMTf1.setText(String.valueOf(compartment1.getFoods().get(0).getExdMonth()));
                            exdYTF1.setText(String.valueOf(compartment1.getFoods().get(0).getExdYear()));
                        }


                        if (this.compartment2.getFoods().isEmpty()==false){
                            nameTf2.setText(compartment2.getFoods().get(0).getName());
                            quantityTf2.setText(String.valueOf(compartment2.getFirstFood().getQuantity()));
                            unitTf2.setText(compartment2.getFoods().get(0).getUnit());
                            exdDTf2.setText(String.valueOf(compartment2.getFoods().get(0).getExdDay()));
                            exdMTf2.setText(String.valueOf(compartment2.getFoods().get(0).getExdMonth()));
                            exdYTF2.setText(String.valueOf(compartment2.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment3.getFoods().isEmpty()==false){
                            nameTf3.setText(compartment3.getFoods().get(0).getName());
                            quantityTf3.setText(String.valueOf(compartment3.getFirstFood().getQuantity()));
                            unitTf3.setText(compartment3.getFoods().get(0).getUnit());
                            exdDTf3.setText(String.valueOf(compartment3.getFoods().get(0).getExdDay()));
                            exdMTf3.setText(String.valueOf(compartment3.getFoods().get(0).getExdMonth()));
                            exdYTF3.setText(String.valueOf(compartment3.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment4.getFoods().isEmpty()==false){
                            nameTf4.setText(compartment4.getFoods().get(0).getName());
                            quantityTf4.setText(String.valueOf(compartment4.getFirstFood().getQuantity()));
                            unitTf4.setText(compartment4.getFoods().get(0).getUnit());
                            exdDTf4.setText(String.valueOf(compartment4.getFoods().get(0).getExdDay()));
                            exdMTf4.setText(String.valueOf(compartment4.getFoods().get(0).getExdMonth()));
                            exdYTF4.setText(String.valueOf(compartment4.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment5.getFoods().isEmpty()==false){
                            nameTf5.setText(compartment5.getFoods().get(0).getName());
                            quantityTf5.setText(String.valueOf(compartment5.getFirstFood().getQuantity()));
                            unitTf5.setText(compartment5.getFoods().get(0).getUnit());
                            exdDTf5.setText(String.valueOf(compartment5.getFoods().get(0).getExdDay()));
                            exdMTf5.setText(String.valueOf(compartment5.getFoods().get(0).getExdMonth()));
                            exdYTF5.setText(String.valueOf(compartment5.getFoods().get(0).getExdYear()));
                        }

                        if (this.compartment6.getFoods().isEmpty()==false){
                            nameTf6.setText(compartment6.getFoods().get(0).getName());
                            quantityTf6.setText(String.valueOf(compartment6.getFirstFood().getQuantity()));
                            unitTf6.setText(compartment6.getFoods().get(0).getUnit());
                            exdDTf6.setText(String.valueOf(compartment6.getFoods().get(0).getExdDay()));
                            exdMTf6.setText(String.valueOf(compartment6.getFoods().get(0).getExdMonth()));
                            exdYTF6.setText(String.valueOf(compartment6.getFoods().get(0).getExdYear()));
                        }

                        if (this.freezingCompartment1.getFoods().isEmpty()==false){
                            nameTf7.setText(freezingCompartment1.getFoods().get(0).getName());
                            quantityTf7.setText(String.valueOf(freezingCompartment1.getFirstFood().getQuantity()));
                            unitTf7.setText(freezingCompartment1.getFoods().get(0).getUnit());
                            exdDTf7.setText(String.valueOf(freezingCompartment1.getFoods().get(0).getExdDay()));
                            exdMTf7.setText(String.valueOf(freezingCompartment1.getFoods().get(0).getExdMonth()));
                            exdYTF7.setText(String.valueOf(freezingCompartment1.getFoods().get(0).getExdYear()));
                        }

                        if (this.freezingCompartment2.getFoods().isEmpty()==false){
                            nameTf8.setText(freezingCompartment2.getFoods().get(0).getName());
                            quantityTf8.setText(String.valueOf(freezingCompartment2.getFirstFood().getQuantity()));
                            unitTf8.setText(freezingCompartment2.getFoods().get(0).getUnit());
                            exdDTf8.setText(String.valueOf(freezingCompartment2.getFoods().get(0).getExdDay()));
                            exdMTf8.setText(String.valueOf(freezingCompartment2.getFoods().get(0).getExdMonth()));
                            exdYTF8.setText(String.valueOf(freezingCompartment2.getFoods().get(0).getExdYear()));
                        }


                    }
                }


            }
        }
    }

    private MyFile file;
    private String name;
    private String type;
    private String unit;
    private int exdDay; //06/05/2999
    private int exdMonth;
    private int exdYear;
    private int quantity;
    private boolean freeze = false;


    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    //getTime() returns the current date in default time zone
    private int toDay = calendar.get(Calendar.DATE);
    //Note: +1 the month for current month
    private int thisMonth = calendar.get(Calendar.MONTH) + 1;
    private int thisYear = calendar.get(Calendar.YEAR);

    public void saveAndCloseBtn(ActionEvent event) {
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

    //

    //

    //เสร็จ
}
