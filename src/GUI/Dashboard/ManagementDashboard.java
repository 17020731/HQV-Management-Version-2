package GUI.Dashboard;

import Effect.Animation;
import BackEnd.NewWin;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class ManagementDashboard {

    NewWin win = new NewWin();
    Animation notice = new Animation();
    @FXML
    private JFXButton minimize, close;
    @FXML
    private Pane vangta, vangtay, ngoaite, thanhtoan, lichsu, doanhthu;
    @FXML
    private AnchorPane test;
    @FXML
    public void handleAction(ActionEvent event){
        if(event.getTarget() == minimize){
            Stage stage = (Stage) minimize.getScene().getWindow();
            stage.setIconified(true);
        }
        else if (event.getTarget() == close){
            Stage stage = (Stage) close.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void initialize(){
        vangta.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Stage stage = (Stage) close.getScene().getWindow();
                    stage.close();
                    win.makeWindow(new Stage(), "/GUI/Management/ManagementFrame.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        vangta.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                notice.fade(vangta);
            }
        });
        vangtay.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Stage stage = (Stage) close.getScene().getWindow();
                    stage.close();
                    win.makeWindow(new Stage(), "/GUI/Management/ManagementFrame.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        vangtay.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                notice.fade(vangtay);
            }
        });
        ngoaite.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Stage stage = (Stage) close.getScene().getWindow();
                    stage.close();
                    win.makeWindow(new Stage(), "/GUI/Management/ManagementFrame.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        ngoaite.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                notice.fade(ngoaite);
            }
        });
        thanhtoan.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Stage stage = (Stage) close.getScene().getWindow();
                    stage.close();
                    win.makeWindow(new Stage(), "/GUI/Payment/payment.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thanhtoan.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                notice.fade(thanhtoan);
            }
        });
        lichsu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Stage stage = (Stage) close.getScene().getWindow();
                    stage.close();
                    win.makeWindow(new Stage(), "/GUI/History/history.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        lichsu.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                notice.fade(lichsu);
            }
        });
        doanhthu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Stage stage = (Stage) close.getScene().getWindow();
                    stage.close();
                    win.makeWindow(new Stage(), "/GUI/Revenue/revenue.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        doanhthu.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                notice.fade(doanhthu);
            }
        });
    }

}
