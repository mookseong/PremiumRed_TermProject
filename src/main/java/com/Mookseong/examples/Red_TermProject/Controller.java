package com.Mookseong.examples.Red_TermProject;

import com.sun.xml.internal.bind.v2.TODO;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private ImageView Play_Btn;
    @FXML private ImageView back_Btn;
    @FXML private ImageView next_Btn;
    @FXML private Button list;
    @FXML private Label Title;

    private boolean PlayImg = false;
    private Popup popup = new Popup();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Title.setText("음악을 재생해주시기 바랍니다.");
        Play_Btn.setOnMouseClicked((EventHandler<Event>) Evnet -> Controller.this.handlePlay());
        back_Btn.setOnMouseClicked((EventHandler<Event>) Evnet -> Controller.this.handleback());
        next_Btn.setOnMouseClicked((EventHandler<Event>) Evnet -> Controller.this.handlenext());


        list.setOnAction(event -> {
            if(popup.isShowing()){
                popup.hide();
            }else {
                final Window window = list.getScene().getWindow();
                popup.setWidth(100);
                popup.setHeight(300);

                final double x = window.getX()
                        + list.localToScene(0, 0).getX()
                        + list.getScene().getX()
                        ;
                final double y = window.getY()
                        + list.localToScene(0, 0).getY()
                        + list.getScene().getY()
                        + list.getHeight();

                popup.getContent().clear();
                popup.show(window, x, y);
            }


                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/fxml/Download.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("My New Stage Title");
                    stage.setScene(new Scene(root, 450, 450));
                    stage.show();
                    // Hide this current window (if this is what you want)
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
        });

    }

    private void handlePlay(){
        if (PlayImg) {
            Play_Btn.setImage(new Image(getClass().getResourceAsStream("/images/pause.png")));
            System.out.println("일시 정지합니다.");
            PlayImg = false;
        }
        else{
            //YoutubeDownLoad("","");
            Play_Btn.setImage(new Image(getClass().getResourceAsStream("/images/Play.png")));
            System.out.println("노래를 재생합니다.");
            PlayImg = true;
        }
    }
    private boolean backb = true;
    private void handleback(){
        if(backb) {
            System.out.println("처음 재생합니다.");
            PlayImg = false;
        }else {
            System.out.println("이전곡 재생합니다.");
            PlayImg = true;

        }

    }
    private void handlenext(){
        System.out.println("다음곡 재생합니다.");
    }
    // ex: http://www.youtube.com/watch?v=Nj6PFaDmp6c
    // ex: "/Users/limseongmuk/Downloads"
}
