package sample;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.format.DateTimeFormatter;

public class newFurniture {
    @FXML
    private TextField AssestRoom;
    @FXML
    private TextField AssestName;
    @FXML
    private TextField AssestMadeout;
    @FXML
    private TextField AssestCost;
    @FXML
    private DatePicker AssestPurDate;
    @FXML
    private TextField AssestSupplier;
    @FXML
    private TextField AssestBarcode;
    @FXML
    private TextField AssestSerial;


    public void submitAssets(ActionEvent actionEvent) {
        MongoClient mongoClient = DbAuth.mongoclient();
        @SuppressWarnings("deprecation")
        DB db = mongoClient.getDB("cw3pp1");
        DBCollection col = db.getCollection("furnitureassests");
        BasicDBObject document = new BasicDBObject();
        document.put("roomID", AssestRoom.getText());
        document.put("itemName", AssestName.getText());
        document.put("madeOut", AssestMadeout.getText());
        document.put("cost", AssestCost.getText());
        document.put("purchaseDate", AssestPurDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        document.put("supplier", AssestSupplier.getText());
        document.put("Barcode", AssestBarcode.getText());
        document.put("SerialNo", AssestSerial.getText());

        col.insert(document);
        new Alert(Alert.AlertType.INFORMATION,"Successfully added !!!").showAndWait();
        System.out.println("submitted !!!");
        mongoClient.close();
    }
}
