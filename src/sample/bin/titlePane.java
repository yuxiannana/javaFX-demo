package sample.bin;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class titlePane {

    private static double oldStageX;
    private static double oldStageY;
    private static double oldScreenX;
    private static double oldScreenY;
    public static double hBoxHeight=20;
    public static HBox titlePane(Stage primaryStage){
        HBox hBox=new HBox();
        hBox.setLayoutX(30);
        hBox.setLayoutY(0);
        hBox.setSpacing(10);
        hBox.setPrefWidth(1152);
        hBox.setPrefHeight(20);
        hBox.setStyle("-fx-background-color:#ff90b7;");
        hBox.getChildren().addAll();
//        hBox.setPadding(new Insets(0,100,0,0));
        hBox.setLayoutX(0);
        hBox.setOpacity(0.7);

        //设置图标
        Image iconImg=new Image("file:src/sample/bin/icon.png");
        ImageView icon=new ImageView();
        icon.setFitWidth(30);
        icon.setFitHeight(30);
        icon.setImage(iconImg);
        hBox.setMargin(icon,new Insets(0,0,0,0));
        hBox.setSpacing(50);
        //设置标题
        Label label = new Label("淦淦淦淦");
        label.setOpacity(0.8);
//        label.setFont(label.getFont().c);
//        label.setPrefHeight(20);

//        label.setFont(Font.font("Times New Roman",15));
//        label.setTextFill(Paint.valueOf("blue"));
//        label.setStyle("-fx-font-family: 'Times New Roman';"+
//                        "-fx-font-size: 15;"+
//                "-fx-font-weight: 10000");
        label.setStyle("-fx-font-weight: bold");
        hBox.setMargin(label,new Insets(10,0,0,0));

        //设置关闭按钮
        Button close=new Button();
        Image image_close=new Image("file:src/sample/bin/close.png");
        ImageView imageView_close=new ImageView(image_close);
        close.setGraphic(imageView_close);
        close.setPrefHeight(hBoxHeight);
        close.setPrefWidth(hBoxHeight);
        imageView_close.setFitHeight(hBoxHeight);
        imageView_close.setFitWidth(image_close.getWidth()/image_close.getHeight()*hBoxHeight);
        close.setStyle("-fx-background-color: rgb(255,144,183);");
        hBox.setSpacing(500);
//        close.setTranslateX(sample.demo.getPrimaryStageWidth()-(image_close.getWidth()/image_close.getHeight()*hBoxHeight)*2);
        System.out.println(sample.demo.getPrimaryStageWidth()-(image_close.getWidth()/image_close.getHeight()*hBoxHeight)-600);
//        close.setTranslateX(1010);
        System.out.println(close.getLayoutX());




        hBox.getChildren().addAll(icon,label,close);
        /**
         * 窗口移动板块
         * */
        hBox.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                oldStageX = primaryStage.getX();
                oldStageY = primaryStage.getY();
                oldScreenX = mouseEvent.getScreenX();
                oldScreenY = mouseEvent.getScreenY();

            }
        });
        hBox.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                primaryStage.setX(mouseEvent.getScreenX() - oldScreenX + oldStageX);
                primaryStage.setY(mouseEvent.getScreenY() - oldScreenY + oldStageY);

            }
        });

        /**
         *窗口关闭板块
         * */


        return hBox;
    }
}
