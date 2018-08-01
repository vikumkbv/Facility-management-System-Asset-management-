package sample;

import com.mongodb.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Loginmanagement {

    @FXML
    private Label lbs;
    @FXML
    private TextField uname;
    @FXML
    private PasswordField pword;
    @FXML
    private Button login;

    public void login(ActionEvent event) throws Exception {
        if(uname.getText() == null | uname.getText().trim().isEmpty())
        {
            new Alert(Alert.AlertType.WARNING,"please Enter your Username").showAndWait();
        }
        if(pword.getText() == null | pword.getText().trim().isEmpty())
        {
            new Alert(Alert.AlertType.WARNING,"please Enter your Password").showAndWait();
        }
        if(uname.getText() == null | uname.getText().trim().isEmpty() && pword.getText() == null | pword.getText().trim().isEmpty() )
        {
            new Alert(Alert.AlertType.WARNING,"Nothing entered. please Enter your Username and Password").showAndWait();
        }else {
            //mongo connect

            MongoClient mongoClient = DbAuth.mongoclient();
            @SuppressWarnings("deprecation")
            DB db = mongoClient.getDB("cw3pp1");
            DBCollection col = db.getCollection("logindata");
            System.out.println(col.toString());
            BasicDBObject userFindQuery = new BasicDBObject();
            ArrayList<BasicDBObject> obj  = new ArrayList<>();

            obj.add(new BasicDBObject("uname" ,uname.getText()));
            obj.add(new BasicDBObject("pword" , pword.getText()));
            userFindQuery.put("$and", obj);

            DBCursor cursor = col.find(userFindQuery);
            System.out.println(cursor);

            boolean loginpass = false;

            while (cursor.hasNext()) {
                loginpass = true;
                BasicDBObject obj1 = (BasicDBObject) cursor.next();
            }
            if(loginpass) {
                ((Node)event.getSource()).getScene().getWindow().hide();
                Stage primaryStage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                Pane root = null;
                try {
                    root = loader.load(getClass().getResource("menuRep.fxml").openStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                assert root != null;
                primaryStage.setScene(new Scene(root));
                primaryStage.setTitle("University of Gugsi : Main menu");
                primaryStage.initStyle(StageStyle.UNDECORATED);
                primaryStage.show();
                new Alert (Alert.AlertType.INFORMATION,"Congratulations Login Successful !!!").showAndWait();
            }
            else {
                new Alert (Alert.AlertType.ERROR,"### Incorrect User Name or Password.Please Try again !!!").showAndWait();
            }
        }
    }

    public void closebtn(ActionEvent event) {
        System.exit(0);

    }
    }


