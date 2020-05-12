package sample;

import com.jfoenix.controls.*;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpPageController implements Initializable {



    MediaPlayer mediaPlayer;

    @FXML
    private JFXButton btnSignUp;

    @FXML
    private JFXTextField txtFirstName;

    @FXML
    private JFXTextField txtLastName;

    @FXML
    private JFXTextField txtFatherName;

    @FXML
    private JFXTextField txtNationalId;

    @FXML
    private JFXTextField txtPhoneNumber;

    @FXML
    private JFXDatePicker dateBirthday;

    @FXML
    private JFXComboBox<?> comboMaritalStatus;

    @FXML
    private JFXTextField txtChildrenNumber;

    @FXML
    private JFXComboBox<?> comboGender;

    @FXML
    private JFXComboBox<?> comboDegreeOfEducation;

    @FXML
    private JFXComboBox<?> comboStateOfWorkplace;

    @FXML
    private JFXComboBox<?> comboCityOfWorkplace;

    @FXML
    private JFXToggleButton ToggleButtenAdminEmployee;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXPasswordField txtConfirmPassword;

    @FXML
    private JFXButton btnSignIn;

    @FXML
    private Label lblWrongInfo;


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
    public void gotoLoginPageAfterSignUp(ActionEvent actionEvent) {
        if (txtFirstName.getText() == "" || txtLastName.getText() == "" || txtFatherName.getText() == "" || txtChildrenNumber.getText() == "" || txtNationalId.getText() == "" || txtPhoneNumber.getText() == "" || txtPassword.getText() == "" || txtConfirmPassword.getText() == "" || !(txtPassword.getText().equals(txtConfirmPassword.getText()))){
            try {
                Parent root;
                Stage stage = (Stage) btnSignUp.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("sample/LoginPage.fxml"));
                root = fxmlLoader.load();
                mediaPlayer.pause();
                stage.close();
                stage = new Stage();
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(new Scene(root));
                stage.show();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        } else {
            lblWrongInfo.setText("Your information is wrong!");
        }

    }

    @FXML
    public void gotoLoginPage(ActionEvent actionEvent) {
        try {
            Parent root;
            Stage stage = (Stage) btnSignIn.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("sample/LoginPage.fxml"));
            root = fxmlLoader.load();
            mediaPlayer.pause();
            stage.close();
            stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
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

    @FXML
    public void playMusic(MouseEvent mouseEvent) {
    }

    @FXML
    public void stopMusic(MouseEvent mouseEvent) {
    }

    public void myMusicPlayer(String path){
        Media  media = new Media(path);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    int musicCurrentTime = -1;
    @FXML
    public void onPlay(MouseEvent mouseEvent) {
        if (musicCurrentTime==0){
            myMusicPlayer("file:///C:/Users/WIN10/IdeaProjects/Salary/src/sample/gik.mp3");
            musicCurrentTime++;
        } else {
            musicCurrentTime--;
            Duration duration = mediaPlayer.getCurrentTime();
            mediaPlayer.seek(duration);
            mediaPlayer.play();
        }

    }

    @FXML
    public void onStop(MouseEvent mouseEvent) {
        mediaPlayer.pause();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        myMusicPlayer("file:///C:/Users/WIN10/IdeaProjects/Salary/src/sample/gik.mp3");
    }



}
