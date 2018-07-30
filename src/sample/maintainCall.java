package sample;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.format.DateTimeFormatter;

public class maintainCall {
    @FXML
    private TextField maintainStaffID;
    @FXML
    private TextField maintainRoonID;
    @FXML
    private DatePicker maintainDate;
    @FXML
    private TextField maintainwork;



    public void maintainsubmit(ActionEvent actionEvent) {
        MongoClient mongoClient = DbAuth.mongoclient();
        @SuppressWarnings("deprecation")
        DB db = mongoClient.getDB("cw3pp1");
        DBCollection col = db.getCollection("maintancecCall");
        BasicDBObject document = new BasicDBObject();
        document.put("staffid", maintainStaffID.getText());
        document.put("room", maintainRoonID.getText());
        document.put("date", maintainDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        document.put("work to do", maintainwork.getText());
        col.insert(document);
        new Alert(Alert.AlertType.INFORMATION,"Successfully requested !!!").showAndWait();
        System.out.println("submitted !!!");
        mongoClient.close();
    }
}
