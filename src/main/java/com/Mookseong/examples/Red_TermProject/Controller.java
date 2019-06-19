package com.Mookseong.examples.Red_TermProject;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private ImageView Play_Btn;
    @FXML private Label Title;

    private boolean PlayImg = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Title.setText("음악을 재생해주시기 바랍니다.");
        Play_Btn.setOnMouseClicked(new EventHandler<Event>() {
            public void handle(Event Evnet) {
                Controller.this.handlePlay();
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
            YoutubeDownLoad();
            Play_Btn.setImage(new Image(getClass().getResourceAsStream("/images/Play.png")));
            System.out.println("노래를 재생합니다.");
            PlayImg = true;
        }
    }

    private void YoutubeDownLoad(){

    }
}
