package sample;

import com.mongodb.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class LoginAssetManage {
    @FXML
    private TextField AuthStaffID;
    @FXML
    private PasswordField AuthPassword;
    @FXML
    private Button Authloginbtn;

    public void Authloginbtn(ActionEvent actionEvent) throws Exception {

        if(AuthStaffID.getText() == null | AuthStaffID.getText().trim().isEmpty() && AuthPassword.getText() == null | AuthPassword.getText().trim().isEmpty() )
        {
            new Alert(Alert.AlertType.WARNING,"Nothing entered. please Enter your Staff ID and Password").showAndWait();
        }else {


            MongoClient mongoClient = DbAuth.mongoclient();
            @SuppressWarnings("deprecation")
            DB db = mongoClient.getDB("cw3pp1");
            DBCollection col = db.getCollection("logindataAuth");
            System.out.println(col.toString());
            BasicDBObject userFindQuery = new BasicDBObject();
            ArrayList<BasicDBObject> obj = new ArrayList<>();


            obj.add(new BasicDBObject("staffid", AuthStaffID.getText()));
            obj.add(new BasicDBObject("pword", AuthPassword.getText()));
            userFindQuery.put("$and", obj);

            DBCursor cursor = col.find(userFindQuery);

            System.out.println(cursor);

            boolean loginpass = false;


            while (cursor.hasNext()) {
                loginpass = true;
                BasicDBObject obj1 = (BasicDBObject) cursor.next();


            }

            if (loginpass) {

                Stage primaryStage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                Pane root = null;
                try {

                    root = loader.load(getClass().getResource("LoginAssetManage.fxml").openStream());
                } catch (IOException e) {

                    e.printStackTrace();
                }


                Scene scene = new Scene(root, 600, 400);
                primaryStage.setScene(scene);
                primaryStage.setTitle("University of Gugsi : Authorized menu");
                primaryStage.show();

                new Alert(Alert.AlertType.INFORMATION, "Congratulations Login Successful !!!").showAndWait();
            } else {
                new Alert(Alert.AlertType.ERROR, "### Incorrect Staff ID or Password.Please Try again !!!").showAndWait();

            }


        }

    }

    public void AuthofficeMove(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Authrelocation.fxml"));
        Scene scene = new Scene(root,856,521);
        primaryStage.setScene(scene);
        primaryStage.setTitle("University of Gugsi : Authorized relocation");
        primaryStage.show();

    }

    public void newFurniture(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("newFurniture.fxml"));
        Scene scene = new Scene(root,600,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("University of Gugsi : Add New Furniture");
        primaryStage.show();
    }

    public void reportFmo(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("reportFmo.fxml"));
        Scene scene = new Scene(root,747,524);
        primaryStage.setScene(scene);
        primaryStage.setTitle("University of Gugsi : FMO report generator");
        primaryStage.show();
    }

}
