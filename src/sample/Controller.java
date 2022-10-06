package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;

    @FXML
    private TextField age;

    @FXML
    private TextField city;

    @FXML
    private TextField nicpass;

    @FXML
    private ComboBox<String> select;

    @FXML
    private Button receiptbtn;

    private String InputText;


    @FXML
    void next(ActionEvent event) throws IOException {

        //get values from TextFields

        String fnameText= firstname.getText();      //initialize firstname to the program
        String surnameText= lastname.getText();     //initialize firstname to the program
        String ageText=age.getText();       //initialize age to the program
        String cityText= city.getText();        //initialize city to the program
        String nicText= nicpass.getText();      //initialize nic or passport number to the program



        Parent root;
        FXMLLoader loader =new FXMLLoader(getClass().getResource("printreceipt.fxml"));
        root=loader.load();
        printReceipt receipt=loader.getController(); //create controller
        receipt.setTextLable(fnameText,surnameText,ageText,cityText,nicText,InputText);

        //show printreceipt.fxml file
        Stage window=(Stage)receiptbtn.getScene().getWindow();
        window.setTitle("Receipt");
        window.setScene(new Scene(root,600,600));
        window.show();


    }

    @FXML
    void vaccinetype(ActionEvent event) {       //vaccine type select function
        InputText=select.getSelectionModel().getSelectedItem().toString();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {        //vaccine selection

        ObservableList <String> list= FXCollections.observableArrayList("AstraZeneca","Pfizer","Sinopharm");
        select.setItems(list);

    }
    public void clickc(){       //clear button function
        firstname.setText("");
        lastname.setText("");
        age.setText("");
        city.setText("");
        nicpass.setText("");
    }
}
