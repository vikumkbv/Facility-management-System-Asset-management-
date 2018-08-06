package sample;

import com.mongodb.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class officeMove implements Initializable {
    @FXML
    private TextField Staff_Id;
    @FXML
    private TextField current_room;
    @FXML
    private TextField move_room;
    @FXML
    private RadioButton officeMoveRadioIN;
    @FXML
    private RadioButton officeMoveRadioOut;
    @FXML
    private ComboBox<String> itemToMove;
    @FXML
    private DatePicker office_move_date;
    @FXML
    private Button office_move_submit;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

       this.searchItems();
    }

    public void searchItems(){
        ObservableList <String> typesArr = FXCollections.observableArrayList();
        MongoClient mongoClient = DbAuth.mongoclient();
        @SuppressWarnings("deprecation")
        DB db = mongoClient.getDB("cw3pp1");
        DBCollection col = db.getCollection("items");

        DBCursor cursor = col.find();
        System.out.println(cursor.toString());
        while (cursor.hasNext()) {

            BasicDBObject obj1 = (BasicDBObject) cursor.next();
            System.out.println(obj1.toString());
            String types =  obj1.getString("name");
            typesArr.add(types.toString());
            itemToMove.setItems(typesArr);
        }
        mongoClient.close();
    }

    public void office_move_submit(ActionEvent actionEvent) {
        boolean move =  officeMoveRadioOut.isSelected() ? true : false;
        MongoClient mongoClient = DbAuth.mongoclient();
        @SuppressWarnings("deprecation")
        DB db = mongoClient.getDB("cw3pp1");
        DBCollection col = db.getCollection("officeMove");
        BasicDBObject document = new BasicDBObject();
        document.put("staffid", Staff_Id.getText());
        document.put("currentroom", current_room.getText());
        document.put("moveroom", move_room.getText());
        document.put("item", itemToMove.getValue());
        document.put("movetype", move);
        document.put("date", office_move_date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        col.insert(document);
        new Alert (Alert.AlertType.INFORMATION,"Successfully requested !!!").showAndWait();
        System.out.println("submitted !!!");
        mongoClient.close();
    }

}
