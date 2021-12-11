package sample.tools;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
/**
 * @author yuxian qq1316474469
 * @param
 *
 *
 * */

public class test extends Application {

    Button btnscene1, btnscene2;
    Label lblscene1, lblscene2;
    FlowPane pane1, pane2;
    Scene scene1, scene2;
    Stage newStage,thestage,primaryStage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        thestage = primaryStage;
        //参数转存 方法外可使用
        //创建组件
        btnscene1 = new Button("Click to go to Other Scene");
        btnscene2 = new Button("Click to go back to First Scene");
        btnscene1.setOnAction(e -> ButtonClicked(e));
        btnscene2.setOnAction(e -> ButtonClicked(e));
        lblscene1 = new Label("Scene 1");
        lblscene2 = new Label("Scene 2");
        //创建面板
        pane1 = new FlowPane();
        pane2 = new FlowPane();
        pane1.setHgap(20);
        pane2.setVgap(10);
        //set background color of each Pane
        pane1.setStyle("-fx-background-color:tan;-fx-padding:10px;");
        pane2.setStyle("-fx-background-color:red;-fx-padding:10px;");
        //组件加入面板
        pane1.getChildren().addAll(lblscene1, btnscene1);
        pane2.getChildren().addAll(lblscene2, btnscene2);
        //make 2 scenes from 2 panes
        scene1 = new Scene(pane1, 200, 100);
        scene2 = new Scene(pane2, 200, 100);
        //创建另一个stage
         newStage = new Stage();
        newStage.setScene(scene2);
        //指定 stage 的模式
        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.setTitle("Pop up window");

        thestage.setTitle("Hello World!");
        thestage.setScene(scene1);
        thestage.setMinWidth(300);
        thestage.show();
    }

    public void ButtonClicked(ActionEvent e) {
        if (e.getSource() == btnscene1){
            thestage.hide();
            newStage.showAndWait();
            thestage.show();

        }

        else
            newStage.close();
    }
}
