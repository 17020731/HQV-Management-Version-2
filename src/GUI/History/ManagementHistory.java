package GUI.History;

import Database.DataClass;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

public class ManagementHistory {

    @FXML
    private JFXButton close, minimize;
    @FXML
    private JFXButton vang, ngoaite, other;

    @FXML
    private FlowPane muaFlPane, banFlPane;
    @FXML
    private ScrollPane muaScPane, banScPane;

    @FXML private AnchorPane headBought, headSell;

    @FXML private DatePicker date;

    @FXML private JFXCheckBox allBox, goldBox, currencyBox, otherBox;


    @FXML
    public void handleAction(ActionEvent event){
        if(event.getTarget() == close) {
            Stage stage = (Stage) close.getScene().getWindow();
            stage.close();
        }
        else if(event.getTarget() == minimize){
            Stage stage = (Stage) close.getScene().getWindow();
            stage.setIconified(true);
        }
        else if(event.getTarget() == vang ){
            banFlPane.getChildren().clear();
            muaFlPane.getChildren().clear();
            allBox.setSelected(false);
            goldBox.setSelected(true);
            currencyBox.setSelected(false);
            otherBox.setSelected(false);
            updateHistory("SELECT * FROM orders WHERE status = 'Sell' and code LIKE 'GOL%';", banFlPane, banScPane);
            updateHistory("SELECT * FROM orders WHERE status = 'Bought' and code LIKE 'GOL%';", muaFlPane, muaScPane);
        }
        else if(event.getTarget() == ngoaite){
            allBox.setSelected(false);
            goldBox.setSelected(false);
            currencyBox.setSelected(true);
            otherBox.setSelected(false);
            banFlPane.getChildren().clear();
            muaFlPane.getChildren().clear();
            updateHistory("SELECT * FROM orders WHERE status = 'Sell' and code LIKE 'CUR%';", banFlPane, banScPane);
            updateHistory("SELECT * FROM orders WHERE status = 'Bought' and code LIKE 'CUR%';", muaFlPane, muaScPane);
        }
        else if(event.getTarget() == other){
            allBox.setSelected(false);
            goldBox.setSelected(false);
            currencyBox.setSelected(false);
            otherBox.setSelected(true);
            banFlPane.getChildren().clear();
            muaFlPane.getChildren().clear();
            updateHistory("SELECT * FROM orders WHERE status = 'Sell' and code LIKE 'OTH%';", banFlPane, banScPane);
            updateHistory("SELECT * FROM orders WHERE status = 'Bought' and code LIKE 'OTH%';", muaFlPane, muaScPane);
        }
    }

    String goldCheck, currencyCheck, otherCheck;
    @FXML void handleCheckBox(ActionEvent event){
        if(goldBox.isSelected()) { goldCheck = "'GOL%'";} else {goldCheck = "''";}
        if(currencyBox.isSelected())  { currencyCheck = "'CUR%'"; } else currencyCheck = "''";
        if(otherBox.isSelected())  { otherCheck = "'OTH%'";} else otherCheck = "''";


        banFlPane.getChildren().clear();
        muaFlPane.getChildren().clear();
        updateHistory("SELECT * FROM orders WHERE status = 'Sell' and (code LIKE "+goldCheck+" or code LIKE"+ currencyCheck+ "or code LIKE "+otherCheck +")", banFlPane, banScPane);
        updateHistory("SELECT * FROM orders WHERE status = 'Bought' and (code LIKE "+goldCheck+" or code LIKE"+ currencyCheck+ "or code LIKE "+otherCheck +")", muaFlPane, muaScPane);

        if (allBox.isSelected()) {
            goldBox.setSelected(false);
            currencyBox.setSelected(false);
            otherBox.setSelected(false);

            banFlPane.getChildren().clear();
            muaFlPane.getChildren().clear();
            updateHistory("SELECT * FROM orders WHERE status = 'Sell';", banFlPane, banScPane);
            updateHistory("SELECT * FROM orders WHERE status = 'Bought';", muaFlPane, muaScPane);
        }
    }
    public Label formatData(String text, int x, int y){
        Label label = new Label(text);
        label.setPrefSize(x, y);
        label.setFont(Font.font("System", FontPosture.ITALIC, 13));
        label.setLayoutX(0);
        label.setLayoutY(35);
        label.setTextFill(Color.WHITE);
        label.setAlignment(Pos.CENTER);
        label.setStyle("-fx-border-color: white");
        return label;
    }
    //TODO: update Lịch giao dịch cho sản phẩm Vàng
    public void updateHistory(String query, FlowPane fl, ScrollPane sc){
        try {
            DataClass data = new DataClass();
            ArrayList<ArrayList<Object>> arr = data.getRequest(query, 11);
            for(int i = 0; i < arr.size(); i++){
                AnchorPane pane = new AnchorPane();
                pane.setPrefSize(1112, 30);
                HBox inside = new HBox();
                inside.setPrefSize(1112,30);

                Label label1 = formatData(arr.get(i).get(0).toString(),108,33);
                Label label2 = formatData(arr.get(i).get(1).toString(),171,33);
                Label label3 = formatData(arr.get(i).get(4).toString(),118,33);
                Label label4 = formatData(arr.get(i).get(5).toString(),191,33);
                Label label5 = formatData(arr.get(i).get(6).toString(),105,33);
                Label label6 = formatData(arr.get(i).get(7).toString(),105,33);
                Label label7 = formatData(arr.get(i).get(8).toString(),109,33);
                Label label8 = formatData(arr.get(i).get(9).toString(), 92,33);
                Label label9 = formatData(arr.get(i).get(10).toString(),113,33);

                inside.getChildren().addAll(label1, label2, label3, label4, label5, label6, label7, label8, label9);
                pane.getChildren().addAll(inside);
                pane.setStyle("-fx-background-color: #d65764");
                if(arr.get(i).get(3).equals("Card"))
                    pane.setStyle("-fx-background-color: #dd8a42");
                fl.getChildren().add(pane);
                sc.setContent(fl);
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Lịch sử giao dịch rỗng");
        } catch (NumberFormatException e){
            System.out.println("Lỗi định dạng!");
        }
    }

    //TODO: Setup cho lịch
    public static final LocalDate NOW_LOCAL_DATE (){
        String date = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(date , formatter);
        return localDate;
    }



    @FXML
    public void initialize(){
        date.setValue(NOW_LOCAL_DATE());
        date.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(date.getValue().toString());
                banFlPane.getChildren().clear();
                muaFlPane.getChildren().clear();
                updateHistory("SELECT * FROM orders WHERE status = 'Sell' and date = '" + date.getValue().toString()+"';", banFlPane, banScPane);
                updateHistory("SELECT * FROM orders WHERE status = 'Bought' and date = '" + date.getValue().toString()+"';", banFlPane, banScPane);
            }
        });

        updateHistory("SELECT * FROM orders WHERE status = 'Sell';", banFlPane, banScPane);
        updateHistory("SELECT * FROM orders WHERE status = 'Bought';", muaFlPane, muaScPane);
    }
}
