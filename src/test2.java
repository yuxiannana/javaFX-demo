import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.awt.*;

public class test2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws InterruptedException {
        Group root =new Group();
        StackPane backpane = new StackPane ();
        backpane.setStyle("-fx-background-image: url(" + "file:src/sample/tools/QQ截图20211211003350.png" + "); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: stretch;" +
                "-fx-background-color:  transparent;");
        Image image =new Image("file:src/sample/tools/ba41a32b219e4b40ad055bbb52935896.jpg");
        ImageView imageView=new ImageView();
        imageView.setFitWidth(500);
        imageView.setFitHeight(500);
        imageView.setImage(image);

        Scene scene1=new Scene(backpane);
        imageView.setStyle("-fx-opacity: 0.4;");
//        root.getChildren().addAll(backpane,imageView);

        Scene scene=new Scene(root);
        Button b1=new Button();
        root.getChildren().addAll(b1,backpane);

        scene.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                System.out.println(primaryStage.getHeight());
                imageView.setFitHeight(primaryStage.getHeight());
            }
        });
        primaryStage.setScene(scene);
        Thread.sleep(1000);
//        primaryStage.setScene(scene1);
        primaryStage.show();


    }
}
