package com.Mookseong.examples.Red_TermProject;

import com.Mookseong.examples.Red_TermProject.Data.XML_Reading;
import com.Mookseong.examples.Red_TermProject.Data.XML_wirte;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main_gui extends Application {
    List song = new ArrayList();

    private Stage primaryStage;

    public static void main(String[] args) {
        File file = new File("Red_List.xml");

        // 파일 존재 여부 판단
        if (!file.isFile()) {
            XML_wirte XML_Wirte = new XML_wirte("test","test");
            XML_Wirte.Wirte();
        }else {
            XML_Reading XML_Reading = new XML_Reading("");
            XML_Reading.start();
        }


        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;

        try {
            XML_Setting();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void XML_Setting()throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));
        primaryStage.setTitle("Red");
        primaryStage.setScene(new Scene(root, 433, 520));
        primaryStage.show();
    }
}
