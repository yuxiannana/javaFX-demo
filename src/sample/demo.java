package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.IOException;


public class demo extends Application {
    Stage primaryStage,inputWindow;
    Scene scene,inputScene;
    Button button1;
    Group root,inputRoot;
    HBox hBox1;
    TextField textFieldInfo;
    TextArea textAreaInfo;
    public static double primaryStageWidth=1152,primaryStageHeight;

    @Override

    public void start(Stage primaryStage) throws Exception {
        this.primaryStage=primaryStage;
//首先创建Group
         root =new Group();
         root.setStyle("-fx-background-color: rgb(149,156,255);");
//创建幕布，将root放进去
         scene = new Scene(root);
//设置启动配置
        this.primaryStage.setScene(scene);
        this.primaryStage.setWidth(1152);
        this.primaryStage.setHeight(648);
        this.primaryStage.setTitle("淦淦淦淦");
        this.primaryStage.getIcons().add(new Image("file:src/sample/bin/icon.png"));
        ImageCursor mouse=new ImageCursor(new Image("file:src/sample/bin/mouse.png"));
        scene.setCursor(mouse);
        primaryStage.initStyle(StageStyle.UNDECORATED);

        primaryStage.setResizable(true);




        inputRoot=new Group();
        inputScene=new Scene(inputRoot);
        inputWindow=new Stage();
        inputWindow.setScene(inputScene);

         button1=new Button("设置");
//         button1.setStyle("-fx-background-color:  transparent;");
        button1.setStyle("-fx-background-color: rgba(255, 255, 255, 1);"+
                "-fx-effect: dropshadow(gaussian, #ff90b7, 50, 0, 0, 0);");
        button1.setStyle("-fx-background-color:  transparent;");
        button1.setStyle("fx-box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);");
        button1.setOpacity(0.8);
        button1.setPrefSize(50,30);
        button1.setLayoutX(0);
        button1.setLayoutY(30);
        //按钮设置事件
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("1");
                String cmdpath="";
                String cmd="";
                try {
//                    inputWindow.show();
//                    primaryStage.hide();
                    sample.bin.sets.sets().show();
                    String config=sample.tools.fileReader.fileReader(new File("src/config.ini"));
                    System.out.println(config);
                } catch (IOException e) {
                    e.printStackTrace();
                }

//                sample.tools.cmdrun.runCmd(cmdpath,cmd);
            }
        });

        //设置水平组件
        hBox1=sample.bin.titlePane.titlePane(primaryStage);
//        hBox1.setStyle("-fx-opacity: 0.999;");

        //配置日志输出文本域
        textAreaInfo = new TextArea();
        textAreaInfo.setEditable(false);
//        textAreaInfo.setMouseTransparent(true);
        textAreaInfo.appendText("???" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n434" +
                "\n46464" +
                "\n4656" +
                "\n464" +
                "\n465" +
                "\n464" +
                "6");
        textAreaInfo.getLength();
        textAreaInfo.getText();
        textAreaInfo.setCursor(mouse);
        textAreaInfo.setId("idTextArea");// you can set also control id in fxml file



        System.out.println(textAreaInfo.getCursor());
        System.out.println(textAreaInfo.getLength());
//        textAreaInfo.setStyle("-fx-background-color: transparent");

        textAreaInfo.setStyle("-fx-font-size: 30;"+
                "-fx-opacity: 0.8;"+
                "-fx-background-color: transparent");

        System.out.println(textAreaInfo.getScene());
        System.out.println(        textAreaInfo.getParent()
        );


        Image image =new Image("file:src/sample/tools/ba41a32b219e4b40ad055bbb52935896.jpg");
        ImageView imageView=new ImageView();
        imageView.setFitWidth(this.primaryStage.getWidth());
        imageView.setFitHeight(this.primaryStage.getHeight());
        imageView.setImage(image);
//        imageView.setOpacity(0.8);
        imageView.setStyle("-fx-opacity: 0.9;");//0.4为透明度，越小越透


        root.getChildren().addAll(imageView,hBox1,button1);




        this.primaryStage.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
//                System.out.println(primaryStage.getHeight());
                imageView.setFitHeight(primaryStage.getHeight());
            }
        });
        this.primaryStage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                imageView.setFitWidth(primaryStage.getWidth());
                hBox1.setPrefWidth(primaryStage.getWidth());

            }
        });
        this.primaryStage.xProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                System.out.println(t1);
            }
        });

//设置窗体可见
        System.out.println(button1.getTranslateX());
        this.primaryStage.show();
//        textAreaInfo.setId("textAreaInfo");// you can set also control id in fxml file
//        textAreaInfo.getScene().lookup("#textAreaInfo .content").setCursor(mouse);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void setPrimaryStageWidth(double primaryStageWidth_new) {
        primaryStageWidth = primaryStageWidth_new;
    }

    public static double getPrimaryStageWidth() {
        return primaryStageWidth;
    }
}
