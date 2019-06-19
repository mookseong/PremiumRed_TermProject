package GUI;

import Data.XML_Reading;
import Data.XML_wirte;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML public ImageView Play_Btn;
    @FXML private Label Title;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Title.setText("음악이 재생해주시기 바랍니다.");
        Play_Btn.setOnMouseClicked((EventHandler<Event>) evnet -> handlePlay());
    }

    private void handlePlay(){
        System.out.println("이미지를 클릭하셨습니다");
    }
}
