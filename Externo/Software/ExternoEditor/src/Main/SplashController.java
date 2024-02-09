package Main;

import javafx.animation.RotateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SplashController implements Initializable {
    @FXML
    private Circle c1;
    @FXML
    private Circle c2;
    @FXML
    private Circle c3;


    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        setRotate(c1, 360, 10);
        setRotate(c2, 180, 15);
        setRotate(c3, 145, 20);

        new SplashScreen().start();
    }

    private void setRotate(Circle c, int angle, int duration)
    {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(duration), c);

        rotateTransition.setAutoReverse(true);
        rotateTransition.setByAngle(angle);
        rotateTransition.setRate(3);
        rotateTransition.setCycleCount(10);
        rotateTransition.play();
    }
}
