package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginPageController implements Initializable {

    MediaPlayer mediaPlayer;

    @FXML
    private Circle close;

    @FXML
    private Circle mini;

    @FXML
    private Circle circlePlayMusic;

    @FXML
    private Circle circleStopMusic;

    @FXML
    private FontAwesomeIconView fontPlayMusic;

    @FXML
    private FontAwesomeIconView fontStopMusic;


    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXButton btnSignIn;

    @FXML
    private JFXButton btnSignUp;

    @FXML
    void gotoMainPage(ActionEvent event) {
        try{
            Parent root;
            Stage stage = (Stage) btnSignIn.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("sample/AdminPage.fxml"));
            root = fxmlLoader.load();
            stage.close();
            stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(new Scene(root));
            stage.show();
            mediaPlayer.pause();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    void gotoSignUpPage(ActionEvent event) {
        try {
            Parent root;
            Stage stage = (Stage) btnSignUp.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("sample/SignUpPage.fxml"));
            root = fxmlLoader.load();
            stage.close();
            stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(new Scene(root));
            stage.show();
            mediaPlayer.pause();
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    void mini(MouseEvent event) {
        ((Stage) ((Circle) event.getSource()).getScene().getWindow()).setIconified(true);
    }

    @FXML
    void onClose(MouseEvent event) {
        System.exit(0);
    }

    public void musicPlayer(String path){
        Media media = new Media(path);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    int musicCurrentTime = -1;
    @FXML
    void onPlay(MouseEvent event) {
        if (musicCurrentTime == 0){
            musicPlayer("file:///C:/Users/WIN10/IdeaProjects/Salary/src/sample/gik.mp3");
            musicCurrentTime++;
        } else {
            musicCurrentTime--;
            Duration duration = mediaPlayer.getCurrentTime();
            mediaPlayer.seek(duration);
            mediaPlayer.play();
        }
    }

    @FXML
    void onStop(MouseEvent event) {
        mediaPlayer.pause();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        musicPlayer("file:///C:/Users/WIN10/IdeaProjects/Salary/src/sample/gik.mp3");
    }
}
