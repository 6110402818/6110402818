package Refrigerator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.*;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;

public class RefrigeratorAddController {
    private String name;
    private String type;
    private String unit;
    private int exdDay; //06/05/2999
    private int exdMonth;
    private int exdYear;
    private int quantity;
    private boolean freeze = false; // true = ต้องแช่เย็นเท่านั้น false = แช่ช่องใดก็ได้

    private MyFile file;

    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    //getTime() returns the current date in default time zone
    private int toDay = calendar.get(Calendar.DATE);
    //Note: +1 the month for current month
    private int thisMonth = calendar.get(Calendar.MONTH) + 1;
    private int thisYear = calendar.get(Calendar.YEAR);


//    DoorController doorController = new DoorController();
//    public RefrigeratorAddController(DoorController doorController) {
//        this.doorController = doorController;
//    }

    Compartment compartment1 = new Compartment();
    Compartment compartment2 = new Compartment();
    Compartment compartment3 = new Compartment();
    Compartment compartment4= new Compartment();
    Compartment compartment5 = new Compartment();
    Compartment compartment6 = new Compartment();

    FreezingCompartment freezingCompartment1 = new FreezingCompartment();
    FreezingCompartment freezingCompartment2 = new FreezingCompartment();

    public RefrigeratorAddController() {
    }

    public void setCompartment1(Compartment compartment1) {
        this.compartment1 = compartment1;
    }

    public void setCompartment2(Compartment compartment2) {
        this.compartment2 = compartment2;
    }

    public void setCompartment3(Compartment compartment3) {
        this.compartment3 = compartment3;
    }

    public void setCompartment4(Compartment compartment4) {
        this.compartment4 = compartment4;
    }

    public void setCompartment5(Compartment compartment5) {
        this.compartment5 = compartment5;
    }

    public void setCompartment6(Compartment compartment6) {
        this.compartment6 = compartment6;
    }

    public void setFreezingCompartment1(FreezingCompartment freezingCompartment1) {
        this.freezingCompartment1 = freezingCompartment1;
    }

    public void setFreezingCompartment2(FreezingCompartment freezingCompartment2) {
        this.freezingCompartment2 = freezingCompartment2;
    }

    @FXML private TextField nameTf,typeTf,unitTf,exdDTf,exdMTf,exdYTF,quantityTf;
    @FXML private CheckBox frezzOnlyCheck;
    @FXML private ImageView photo;
    @FXML
    AnchorPane pane;



    @FXML
    public void initialize() {
        String fs = File.separator;
//        file = new MyFile(System.getProperty("user.dir")+ fs +"resources" + fs + "files", "data.txt");

        file = new MyFile(System.getProperty("user.dir")+ fs +"resources" + fs + "files", "RefrigeratorData.csv");

//        System.out.println("test2");
//        System.out.println(this.compartment1.getFoods());
//        System.out.println(this.compartment1);
//        System.out.println(compartment1);

//        photo = new ImageView(new Image("images/cats.jpg"));
//        photo.setX(104);
//        photo.setY(450);
//        photo.setFitHeight(166);
//        photo.setFitWidth(195);
//        pane.getChildren().add(photo);

    }

    public void freezeOnly(ActionEvent actionEvent) throws IOException{
        if (frezzOnlyCheck.isSelected()){
            freeze = true;
        }else{
            freeze = false;
        }
    }


    public void imageBtn(ActionEvent actionEvent) {

    }



    public void addBtn1(ActionEvent event) throws IOException{
        name = nameTf.getText();
        type = typeTf.getText();
        unit = unitTf.getText();
        exdDay = Integer.parseInt(exdDTf.getText());
        exdMonth = Integer.parseInt(exdMTf.getText());
        exdYear = Integer.parseInt(exdYTF.getText());
        quantity = Integer.parseInt(quantityTf.getText());
        Food food = new Food(name,type,unit,exdDay,exdMonth,exdYear,quantity,freeze);


        if (frezzOnlyCheck.isSelected()){
            freeze = true;
        }else{
            freeze = false;
        }

        if (freeze==true){
            Alert al =new Alert(Alert.AlertType.WARNING);
            al.setTitle("ผิดพลาด");
            al.setContentText("ไม่สามารถแช่ช่องธรรมดาได้ กรุณาแช่ช่องแช่แข็ง");
            al.setHeaderText(null);
            al.showAndWait();
        }
        else {
            if (this.compartment1.getFoods().isEmpty()){
                this.compartment1.addFood(food);
                file.append("compartment1"+","+ name + "," + type + "," + unit + "," + exdDay + "," + exdMonth + "," + exdYear + "," + quantity + "," + freeze + "," + toDay + "," + thisMonth + "," + thisYear);
                file.append(System.lineSeparator());
                file.save();

//                System.out.println(compartment1);


                nameTf.clear(); typeTf.clear(); unitTf.clear();
                exdDTf.clear(); exdMTf.clear(); exdYTF.clear(); quantityTf.clear();

                Button b = (Button)event.getSource();
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
            else {
                if (food.equals(this.compartment1.getFoods().get(0))){
                    this.compartment1.addFood(food);
                    file.append("compartment1"+","+ name + "," + type + "," + unit + "," + exdDay + "," + exdMonth + "," + exdYear + "," + quantity + "," + freeze + "," + toDay + "," + thisMonth + "," + thisYear);
                    file.append(System.lineSeparator());
                    file.save();

//                    System.out.println(compartment1);

                    nameTf.clear(); typeTf.clear(); unitTf.clear();
                    exdDTf.clear(); exdMTf.clear(); exdYTF.clear(); quantityTf.clear();

                    Button b = (Button)event.getSource();
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
                else {
                    Alert al =new Alert(Alert.AlertType.WARNING);
                    al.setTitle("ผิดพลาด");
                    al.setContentText("ของที่ท่านต้องการแช่ไม่ตรงประเภทกับของในช่องแช่ กรุณาแช่ช่องอื่น");
                    al.setHeaderText(null);
                    al.showAndWait();
                }
            }

        }

    }

    public void addBtn2(ActionEvent event) throws IOException{
        name = nameTf.getText();
        type = typeTf.getText();
        unit = unitTf.getText();
        exdDay = Integer.parseInt(exdDTf.getText());
        exdMonth = Integer.parseInt(exdMTf.getText());
        exdYear = Integer.parseInt(exdYTF.getText());
        quantity = Integer.parseInt(quantityTf.getText());
        Food food = new Food(name,type,unit,exdDay,exdMonth,exdYear,quantity,freeze);


        if (frezzOnlyCheck.isSelected()){
            freeze = true;
        }else{
            freeze = false;
        }

        if (freeze==true){
            Alert al =new Alert(Alert.AlertType.WARNING);
            al.setTitle("ผิดพลาด");
            al.setContentText("ไม่สามารถแช่ช่องธรรมดาได้ กรุณาแช่ช่องแช่แข็ง");
            al.setHeaderText(null);
            al.showAndWait();
        }
        else {
            if (this.compartment2.getFoods().isEmpty()){
                this.compartment2.addFood(food);
                file.append("compartment2"+","+ name + "," + type + "," + unit + "," + exdDay + "," + exdMonth + "," + exdYear + "," + quantity + "," + freeze + "," + toDay + "," + thisMonth + "," + thisYear);
                file.append(System.lineSeparator());
                file.save();




                nameTf.clear(); typeTf.clear(); unitTf.clear();
                exdDTf.clear(); exdMTf.clear(); exdYTF.clear(); quantityTf.clear();

                Button b = (Button)event.getSource();
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
            else {
                if (food.equals(this.compartment2.getFoods().get(0))){
                    this.compartment2.addFood(food);
                    file.append("compartment2"+","+ name + "," + type + "," + unit + "," + exdDay + "," + exdMonth + "," + exdYear + "," + quantity + "," + freeze + "," + toDay + "," + thisMonth + "," + thisYear);
                    file.append(System.lineSeparator());
                    file.save();



                    nameTf.clear(); typeTf.clear(); unitTf.clear();
                    exdDTf.clear(); exdMTf.clear(); exdYTF.clear(); quantityTf.clear();

                    Button b = (Button)event.getSource();
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
                else {
                    Alert al =new Alert(Alert.AlertType.WARNING);
                    al.setTitle("ผิดพลาด");
                    al.setContentText("ของที่ท่านต้องการแช่ไม่ตรงประเภทกับของในช่องแช่ กรุณาแช่ช่องอื่น");
                    al.setHeaderText(null);
                    al.showAndWait();
                }
            }

        }
    }

    public void addBtn3(ActionEvent event) throws IOException{
        name = nameTf.getText();
        type = typeTf.getText();
        unit = unitTf.getText();
        exdDay = Integer.parseInt(exdDTf.getText());
        exdMonth = Integer.parseInt(exdMTf.getText());
        exdYear = Integer.parseInt(exdYTF.getText());
        quantity = Integer.parseInt(quantityTf.getText());
        Food food = new Food(name,type,unit,exdDay,exdMonth,exdYear,quantity,freeze);


        if (frezzOnlyCheck.isSelected()){
            freeze = true;
        }else{
            freeze = false;
        }

        if (freeze==true){
            Alert al =new Alert(Alert.AlertType.WARNING);
            al.setTitle("ผิดพลาด");
            al.setContentText("ไม่สามารถแช่ช่องธรรมดาได้ กรุณาแช่ช่องแช่แข็ง");
            al.setHeaderText(null);
            al.showAndWait();
        }
        else {
            if (this.compartment3.getFoods().isEmpty()){
                this.compartment3.addFood(food);
                file.append("compartment3"+","+ name + "," + type + "," + unit + "," + exdDay + "," + exdMonth + "," + exdYear + "," + quantity + "," + freeze + "," + toDay + "," + thisMonth + "," + thisYear);
                file.append(System.lineSeparator());
                file.save();




                nameTf.clear(); typeTf.clear(); unitTf.clear();
                exdDTf.clear(); exdMTf.clear(); exdYTF.clear(); quantityTf.clear();

                Button b = (Button)event.getSource();
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
            else {
                if (food.equals(this.compartment3.getFoods().get(0))){
                    this.compartment3.addFood(food);
                    file.append("compartment3"+","+ name + "," + type + "," + unit + "," + exdDay + "," + exdMonth + "," + exdYear + "," + quantity + "," + freeze + "," + toDay + "," + thisMonth + "," + thisYear);
                    file.append(System.lineSeparator());
                    file.save();



                    nameTf.clear(); typeTf.clear(); unitTf.clear();
                    exdDTf.clear(); exdMTf.clear(); exdYTF.clear(); quantityTf.clear();

                    Button b = (Button)event.getSource();
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
                else {
                    Alert al =new Alert(Alert.AlertType.WARNING);
                    al.setTitle("ผิดพลาด");
                    al.setContentText("ของที่ท่านต้องการแช่ไม่ตรงประเภทกับของในช่องแช่ กรุณาแช่ช่องอื่น");
                    al.setHeaderText(null);
                    al.showAndWait();
                }
            }

        }
    }

    public void addBtn4(ActionEvent event) throws IOException{
        name = nameTf.getText();
        type = typeTf.getText();
        unit = unitTf.getText();
        exdDay = Integer.parseInt(exdDTf.getText());
        exdMonth = Integer.parseInt(exdMTf.getText());
        exdYear = Integer.parseInt(exdYTF.getText());
        quantity = Integer.parseInt(quantityTf.getText());
        Food food = new Food(name,type,unit,exdDay,exdMonth,exdYear,quantity,freeze);


        if (frezzOnlyCheck.isSelected()){
            freeze = true;
        }else{
            freeze = false;
        }

        if (freeze==true){
            Alert al =new Alert(Alert.AlertType.WARNING);
            al.setTitle("ผิดพลาด");
            al.setContentText("ไม่สามารถแช่ช่องธรรมดาได้ กรุณาแช่ช่องแช่แข็ง");
            al.setHeaderText(null);
            al.showAndWait();
        }
        else {
            if (this.compartment4.getFoods().isEmpty()){
                this.compartment4.addFood(food);
                file.append("compartment4"+","+ name + "," + type + "," + unit + "," + exdDay + "," + exdMonth + "," + exdYear + "," + quantity + "," + freeze + "," + toDay + "," + thisMonth + "," + thisYear);
                file.append(System.lineSeparator());
                file.save();




                nameTf.clear(); typeTf.clear(); unitTf.clear();
                exdDTf.clear(); exdMTf.clear(); exdYTF.clear(); quantityTf.clear();

                Button b = (Button)event.getSource();
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
            else {
                if (food.equals(this.compartment4.getFoods().get(0))){
                    this.compartment4.addFood(food);
                    file.append("compartment4"+","+ name + "," + type + "," + unit + "," + exdDay + "," + exdMonth + "," + exdYear + "," + quantity + "," + freeze + "," + toDay + "," + thisMonth + "," + thisYear);
                    file.append(System.lineSeparator());
                    file.save();



                    nameTf.clear(); typeTf.clear(); unitTf.clear();
                    exdDTf.clear(); exdMTf.clear(); exdYTF.clear(); quantityTf.clear();

                    Button b = (Button)event.getSource();
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
                else {
                    Alert al =new Alert(Alert.AlertType.WARNING);
                    al.setTitle("ผิดพลาด");
                    al.setContentText("ของที่ท่านต้องการแช่ไม่ตรงประเภทกับของในช่องแช่ กรุณาแช่ช่องอื่น");
                    al.setHeaderText(null);
                    al.showAndWait();
                }
            }

        }
    }

    public void addBtn5(ActionEvent event) throws IOException{
        name = nameTf.getText();
        type = typeTf.getText();
        unit = unitTf.getText();
        exdDay = Integer.parseInt(exdDTf.getText());
        exdMonth = Integer.parseInt(exdMTf.getText());
        exdYear = Integer.parseInt(exdYTF.getText());
        quantity = Integer.parseInt(quantityTf.getText());
        Food food = new Food(name,type,unit,exdDay,exdMonth,exdYear,quantity,freeze);


        if (frezzOnlyCheck.isSelected()){
            freeze = true;
        }else{
            freeze = false;
        }

        if (freeze==true){
            Alert al =new Alert(Alert.AlertType.WARNING);
            al.setTitle("ผิดพลาด");
            al.setContentText("ไม่สามารถแช่ช่องธรรมดาได้ กรุณาแช่ช่องแช่แข็ง");
            al.setHeaderText(null);
            al.showAndWait();
        }
        else {
            if (this.compartment5.getFoods().isEmpty()){
                this.compartment5.addFood(food);
                file.append("compartment5"+","+ name + "," + type + "," + unit + "," + exdDay + "," + exdMonth + "," + exdYear + "," + quantity + "," + freeze + "," + toDay + "," + thisMonth + "," + thisYear);
                file.append(System.lineSeparator());
                file.save();




                nameTf.clear(); typeTf.clear(); unitTf.clear();
                exdDTf.clear(); exdMTf.clear(); exdYTF.clear(); quantityTf.clear();

                Button b = (Button)event.getSource();
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
            else {
                if (food.equals(this.compartment5.getFoods().get(0))){
                    this.compartment5.addFood(food);
                    file.append("compartment5"+","+ name + "," + type + "," + unit + "," + exdDay + "," + exdMonth + "," + exdYear + "," + quantity + "," + freeze + "," + toDay + "," + thisMonth + "," + thisYear);
                    file.append(System.lineSeparator());
                    file.save();



                    nameTf.clear(); typeTf.clear(); unitTf.clear();
                    exdDTf.clear(); exdMTf.clear(); exdYTF.clear(); quantityTf.clear();

                    Button b = (Button)event.getSource();
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
                else {
                    Alert al =new Alert(Alert.AlertType.WARNING);
                    al.setTitle("ผิดพลาด");
                    al.setContentText("ของที่ท่านต้องการแช่ไม่ตรงประเภทกับของในช่องแช่ กรุณาแช่ช่องอื่น");
                    al.setHeaderText(null);
                    al.showAndWait();
                }
            }

        }
    }

    public void addBtn6(ActionEvent event) throws IOException{
        name = nameTf.getText();
        type = typeTf.getText();
        unit = unitTf.getText();
        exdDay = Integer.parseInt(exdDTf.getText());
        exdMonth = Integer.parseInt(exdMTf.getText());
        exdYear = Integer.parseInt(exdYTF.getText());
        quantity = Integer.parseInt(quantityTf.getText());
        Food food = new Food(name,type,unit,exdDay,exdMonth,exdYear,quantity,freeze);


        if (frezzOnlyCheck.isSelected()){
            freeze = true;
        }else{
            freeze = false;
        }

        if (freeze==true){
            Alert al =new Alert(Alert.AlertType.WARNING);
            al.setTitle("ผิดพลาด");
            al.setContentText("ไม่สามารถแช่ช่องธรรมดาได้ กรุณาแช่ช่องแช่แข็ง");
            al.setHeaderText(null);
            al.showAndWait();
        }
        else {
            if (this.compartment6.getFoods().isEmpty()){
                this.compartment6.addFood(food);
                file.append("compartment6"+","+ name + "," + type + "," + unit + "," + exdDay + "," + exdMonth + "," + exdYear + "," + quantity + "," + freeze + "," + toDay + "," + thisMonth + "," + thisYear);
                file.append(System.lineSeparator());
                file.save();




                nameTf.clear(); typeTf.clear(); unitTf.clear();
                exdDTf.clear(); exdMTf.clear(); exdYTF.clear(); quantityTf.clear();

                Button b = (Button)event.getSource();
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
            else {
                if (food.equals(this.compartment6.getFoods().get(0))){
                    this.compartment6.addFood(food);
                    file.append("compartment6"+","+ name + "," + type + "," + unit + "," + exdDay + "," + exdMonth + "," + exdYear + "," + quantity + "," + freeze + "," + toDay + "," + thisMonth + "," + thisYear);
                    file.append(System.lineSeparator());
                    file.save();



                    nameTf.clear(); typeTf.clear(); unitTf.clear();
                    exdDTf.clear(); exdMTf.clear(); exdYTF.clear(); quantityTf.clear();

                    Button b = (Button)event.getSource();
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
                else {
                    Alert al =new Alert(Alert.AlertType.WARNING);
                    al.setTitle("ผิดพลาด");
                    al.setContentText("ของที่ท่านต้องการแช่ไม่ตรงประเภทกับของในช่องแช่ กรุณาแช่ช่องอื่น");
                    al.setHeaderText(null);
                    al.showAndWait();
                }
            }

        }
    }

    public void addBtn7(ActionEvent event) throws IOException{
        name = nameTf.getText();
        type = typeTf.getText();
        unit = unitTf.getText();
        exdDay = Integer.parseInt(exdDTf.getText());
        exdMonth = Integer.parseInt(exdMTf.getText());
        exdYear = Integer.parseInt(exdYTF.getText());
        quantity = Integer.parseInt(quantityTf.getText());
        Food food = new Food(name,type,unit,exdDay,exdMonth,exdYear,quantity,freeze);


        if (frezzOnlyCheck.isSelected()){
            freeze = true;
        }else{
            freeze = false;
        }

            if (this.freezingCompartment1.getFoods().isEmpty()){
                this.freezingCompartment1.addFood(food);
                file.append("freezer1"+","+ name + "," + type + "," + unit + "," + exdDay + "," + exdMonth + "," + exdYear + "," + quantity + "," + freeze + "," + toDay + "," + thisMonth + "," + thisYear);
                file.append(System.lineSeparator());
                file.save();




                nameTf.clear(); typeTf.clear(); unitTf.clear();
                exdDTf.clear(); exdMTf.clear(); exdYTF.clear(); quantityTf.clear();

                Button b = (Button)event.getSource();
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
            else {
                if (food.equals(this.freezingCompartment1.getFoods().get(0))){
                    this.freezingCompartment1.addFood(food);
                    file.append("freezer1"+","+ name + "," + type + "," + unit + "," + exdDay + "," + exdMonth + "," + exdYear + "," + quantity + "," + freeze + "," + toDay + "," + thisMonth + "," + thisYear);
                    file.append(System.lineSeparator());
                    file.save();



                    nameTf.clear(); typeTf.clear(); unitTf.clear();
                    exdDTf.clear(); exdMTf.clear(); exdYTF.clear(); quantityTf.clear();

                    Button b = (Button)event.getSource();
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
                else {
                    Alert al =new Alert(Alert.AlertType.WARNING);
                    al.setTitle("ผิดพลาด");
                    al.setContentText("ของที่ท่านต้องการแช่ไม่ตรงประเภทกับของในช่องแช่ กรุณาแช่ช่องอื่น");
                    al.setHeaderText(null);
                    al.showAndWait();
                }
            }


    }

    public void addBtn8(ActionEvent event) throws IOException{
        name = nameTf.getText();
        type = typeTf.getText();
        unit = unitTf.getText();
        exdDay = Integer.parseInt(exdDTf.getText());
        exdMonth = Integer.parseInt(exdMTf.getText());
        exdYear = Integer.parseInt(exdYTF.getText());
        quantity = Integer.parseInt(quantityTf.getText());
        Food food = new Food(name,type,unit,exdDay,exdMonth,exdYear,quantity,freeze);


        if (frezzOnlyCheck.isSelected()){
            freeze = true;
        }else{
            freeze = false;
        }

        if (this.freezingCompartment2.getFoods().isEmpty()){
            this.freezingCompartment2.addFood(food);
            file.append("freezer2"+","+ name + "," + type + "," + unit + "," + exdDay + "," + exdMonth + "," + exdYear + "," + quantity + "," + freeze + "," + toDay + "," + thisMonth + "," + thisYear);
            file.append(System.lineSeparator());
            file.save();




            nameTf.clear(); typeTf.clear(); unitTf.clear();
            exdDTf.clear(); exdMTf.clear(); exdYTF.clear(); quantityTf.clear();

            Button b = (Button)event.getSource();
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
        else {
            if (food.equals(this.freezingCompartment2.getFoods().get(0))){
                this.freezingCompartment2.addFood(food);
                file.append("freezer2"+","+ name + "," + type + "," + unit + "," + exdDay + "," + exdMonth + "," + exdYear + "," + quantity + "," + freeze + "," + toDay + "," + thisMonth + "," + thisYear);
                file.append(System.lineSeparator());
                file.save();



                nameTf.clear(); typeTf.clear(); unitTf.clear();
                exdDTf.clear(); exdMTf.clear(); exdYTF.clear(); quantityTf.clear();

                Button b = (Button)event.getSource();
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
            else {
                Alert al =new Alert(Alert.AlertType.WARNING);
                al.setTitle("ผิดพลาด");
                al.setContentText("ของที่ท่านต้องการแช่ไม่ตรงประเภทกับของในช่องแช่ กรุณาแช่ช่องอื่น");
                al.setHeaderText(null);
                al.showAndWait();
            }
        }
    }


    public void backBtn(ActionEvent event) throws IOException{
//        Parent connector = (Parent) FXMLLoader.load(this.getClass().getResource("RefrigeratorCompartment.fxml"));
//        Scene scene = new Scene(connector);
//        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();

        Button b = (Button)event.getSource();
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
