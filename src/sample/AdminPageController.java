package sample;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AdminPageController implements Initializable {


    MediaPlayer mediaPlayer;
    FXMLLoader fxmlLoader;

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private Circle close;

    @FXML
    private Circle mini;

    @FXML
    private Circle circlePlayMusic;

    @FXML
    private Circle circleStopMusic;

    @FXML
    private FontAwesomeIconView fontStopMusic;

    @FXML
    private FontAwesomeIconView fontPlayMusic;

    @FXML
    private AnchorPane anchorAdminMain;

    @FXML
    private AnchorPane anchorAdmin;

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXDrawer navigationDrawer;

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
        if (musicCurrentTime==0){
            musicPlayer("file:///C:/Users/WIN10/IdeaProjects/Salary/src/sample/gik.mp3");
            musicCurrentTime++;
        } else {
            int i = musicCurrentTime--;
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
        try {
            VBox vBox = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("sample/NavigationVBox.fxml")));
            navigationDrawer.setSidePane(vBox);
            for (Node node: vBox.getChildren()){
                node.addEventHandler(MouseEvent.MOUSE_CLICKED,(event) -> {
                    switch (node.getAccessibleText()){
                        case "HomePage":
                            break;
                        case "PersonalInfo":
                            try {
                                fxmlLoader = new FXMLLoader(getClass().getResource("PersonalInfoAdminPage.fxml"));
                                mainAnchor.getChildren().add(fxmlLoader.load());
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                e.printStackTrace();
                            }
                            break;
                        case "EmployeesInfo":
                            break;
                        case "ConstantFields":
                            break;
                    }
                });
            }
            HamburgerBackArrowBasicTransition hamburgerBackArrowBasicTransition = new HamburgerBackArrowBasicTransition(hamburger);
            hamburgerBackArrowBasicTransition.setRate(-1);
            hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED,(event) -> {
                hamburgerBackArrowBasicTransition.setRate(hamburgerBackArrowBasicTransition.getRate()*(-1));
                hamburgerBackArrowBasicTransition.play();
                if (navigationDrawer.isOpened()){
                    navigationDrawer.close();
                } else {
                    navigationDrawer.open();
                }
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }
}
