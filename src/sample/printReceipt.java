package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Formatter;

public class printReceipt {

    @FXML
    private Button backbtn;

    @FXML
    private Label printfirstname;

    @FXML
    private Label printlastname;

    @FXML
    private Label printage;

    @FXML
    private Label printcity;

    @FXML
    private Label printnicpass;

    @FXML
    private Label select;

    @FXML
    private Label occupieddate;


    @FXML
    private Button printbtn;

    @FXML
    void printText(ActionEvent event) throws FileNotFoundException {

        LocalDateTime dateTime= LocalDateTime.now();
        Formatter file;

        file=new Formatter("src/sample/Receipt");
        file.format("%s%n%n","---***** Receipt *****---");        //print values into receipt
        file.format("%s%s%n","Patients' First Name    : ",printfirstname.getText());
        file.format("%s%s%n","Patients' Last Name     : ",printlastname.getText());
        file.format("%s%s%n","Patients' Age           : ",printage.getText());
        file.format("%s%s%n","Patients' City          : ",printcity.getText());
        file.format("%s%s%n","Patients' NIC           : ",printnicpass.getText());
        file.format("%s%s%n%n","Vaccination Requested   : ",select.getText());
        file.format("%s%s%n","Occupied Date and Time  : ",dateTime);


        file.close();

    }

    @FXML
    void toHome(ActionEvent event) throws IOException {
        Parent root;
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Login.fxml"));
        root=loader.load();
        Stage window=(Stage) backbtn.getScene().getWindow();
        window.setTitle("Receipt");
        window.setScene(new Scene(root,600,600));
        window.show();


    }

    public void setTextLable(String firstname,String lastname,String age,String city,String nicorpass,String vaccine ){

        printfirstname.setText(firstname);
        printlastname.setText(lastname);
        printage.setText(age);
        printcity.setText(city);
        printnicpass.setText(nicorpass);
        select.setText(vaccine);

        LocalDateTime dateTime= LocalDateTime.now();
        occupieddate.setText(dateTime.toString());

    }

}
