package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class MenuSelect {
    @FXML
    private Button officeMove;
    @FXML
    private Button relocation;
    @FXML
    private Button maintainCall;
    @FXML
    private Button buildingPlan;
    @FXML
    private Button reportFmo;
    @FXML
    private Button newFurniture;
    @FXML
    private Button veiwLog;
    @FXML
    private Button closebtn;


    public void officeMove(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("officeMove.fxml"));
        Scene scene = new Scene(root,600,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("University of Gugsi : Office Move");
        primaryStage.show();
    }

    public void relocation(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("relocation.fxml"));
        Scene scene = new Scene(root,856,521);
        primaryStage.setScene(scene);
        primaryStage.setTitle("University of Gugsi : view office move");
        primaryStage.show();
    }

    public void maintainCall(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("maintainCall.fxml"));
        Scene scene = new Scene(root,600,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("University of Gugsi : Maintain Call");
        primaryStage.show();
    }

    public void veiwLog(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("viewLog.fxml"));
        Scene scene = new Scene(root,699,414);
        primaryStage.setScene(scene);
        primaryStage.setTitle("University of Gugsi : View Log");
        primaryStage.show();
    }

    public void buildingPlan(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("buildingPlan.fxml"));
        Scene scene = new Scene(root,747,524);
        primaryStage.setScene(scene);
        primaryStage.setTitle("University of Gugsi : Building Plan");
        primaryStage.show();

    }

    public void assestmanagement(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("loginAuth.fxml"));
        Scene scene = new Scene(root,467,305);
        primaryStage.setScene(scene);
        primaryStage.setTitle("University of Gugsi : Authorized Login");
        primaryStage.show();

    }



    public void closebtn(ActionEvent event) {
        System.exit(0);

    }



}
