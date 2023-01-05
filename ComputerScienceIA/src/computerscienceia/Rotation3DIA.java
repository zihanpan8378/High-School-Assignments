/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.AmbientLight;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.Light;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.INSERT;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import static javax.accessibility.AccessibleTableModelChange.INSERT;
import javax.swing.JOptionPane;
import javax.swing.Timer;
//import static org.apache.derby.iapi.sql.StatementType.INSERT;
//import static org.apache.derby.impl.sql.compile.SQLParserConstants.INSERT;

/**
 *
 * @author 44869
 */
public class Rotation3DIA extends Application {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 500;
    Board b = new Board();
    Game g = new Game(b, new Players(01, ""), new Players(02, ""));

    //Tracks drag starting point for x and y
    private double anchorX, anchorY;
    //Keep track of current angle for x and y
    private double anchorAngleX = 0;
    private double anchorAngleY = 0;
    //Update these after drag. Using JavaFX property to bind with object
    private final DoubleProperty angleX = new SimpleDoubleProperty(0);
    private final DoubleProperty angleY = new SimpleDoubleProperty(0);
    //Prepare X and Y axis rotation transformation obejcts
    private Rotate xRotate;
    private Rotate yRotate;

    //https://www.youtube.com/watch?v=HLx1ySEVAgQ
    Connection myconObj = null;
    Statement mystatObj = null;
    ResultSet myresObj = null;
    ResultSetMetaData mymeta = null;
    boolean user1 = false, user2 = false;

    //Create a box
    Box[][][] boxs = new Box[3][3][3];
    Box[][][] location = new Box[3][3][3];
    //Prepare transformable Group container
    SmartGroup group = new SmartGroup();
    SmartGroup locationGroup = new SmartGroup();

    //Create Material
    PhongMaterial material = new PhongMaterial();
    PhongMaterial diffuseMap1 = new PhongMaterial();
    PhongMaterial diffuseMap2 = new PhongMaterial();
    PhongMaterial select = new PhongMaterial();
    PhongMaterial[][][] black = new PhongMaterial[3][3][3];
    PhongMaterial[][][] red = new PhongMaterial[3][3][3];
    PhongMaterial[][][] blue = new PhongMaterial[3][3][3];
    PhongMaterial[][][] blackS = new PhongMaterial[3][3][3];
    PhongMaterial[][][] redS = new PhongMaterial[3][3][3];
    PhongMaterial[][][] blueS = new PhongMaterial[3][3][3];

    Label lblHint = new Label(g.getNowPlayer().getName() + "'s turn");
    Label lblUser1 = new Label("Player 1");
    Label lblUser2 = new Label("Player 2");
    Label lblTitle = new Label("3D Tic-Tac-Toe");
    Label lblUsername1 = new Label("Username");
    Label lblPassword1 = new Label("Password");
    Label lblIncorrect1 = new Label("Incorrect username or password");
    Label lblUsername2 = new Label("Username");
    Label lblPassword2 = new Label("Password");
    Label lblIncorrect2 = new Label("Incorrect username or password");
    Label lblSignup = new Label("Sign-up");
    Label lblSignupUsername = new Label("Username");
    Label lblSignupPassword = new Label("Password");
    Label lblSignupConfirmPassword = new Label("Confirming\npassword");
    Label lblIncorrectS = new Label("The passwords is not the same");
    Label lblTopThree = new Label("Top five players");

    Image imaCorrect = new Image(getClass().getResourceAsStream("/images/correct.png"));
    ImageView imageView1 = new ImageView();
    ImageView imageView2 = new ImageView();

    Button btnEnterLogin1 = new Button("Enter");
    Button btnEnterLogin2 = new Button("Enter");
    Button btnSignup = new Button("Sign up");
    Button btnSignupEnter = new Button("Enter");
    Button btnSignupBack = new Button("Back");
    Button btnMiddleCell = new Button("Click the middle cell");
    Button btnResult = new Button();
    Button btnQuit = new Button("Quit");

    TextField txtUsername1 = new TextField("");
    TextField txtUsername2 = new TextField("");
    TextField txtSignupUsername = new TextField("");
    PasswordField txtSignupPassword = new PasswordField();
    PasswordField txtSignupConfirmPassword = new PasswordField();
    PasswordField txtPassword1 = new PasswordField();
    PasswordField txtPassword2 = new PasswordField();

    TableView table = new TableView();
    TableColumn colRank = new TableColumn("rank");
    TableColumn colUsername = new TableColumn("username");
    TableColumn colWins = new TableColumn("wins");
    TableColumn colLosses = new TableColumn("losses");

    ColorPicker colorPicker = new ColorPicker();
    String value1;
    String value2;

    Timer timer;
    double time = 0;

    ProgressBar progressBar = new ProgressBar(1);

    Group game = new Group();
    Group login = new Group();
    Group signup = new Group();
    Group result = new Group();

    Stage stage;

    Scene senLogin;
    Scene senGame;
    Scene senSignup;
    Scene senResult;

    AmbientLight light = new AmbientLight();

    /**
     * pre: none. post: initialize the GUI.
     */
    public Rotation3DIA() {
        connectWithDatabase();
        setupScenes();
        setupGame();
    }

    /**
     * pre: none. post: setup the GUI features
     */
    public void setupScenes() {
        lblTitle.getTransforms().add(new Translate(220, 40));
        lblTitle.setFont(Font.font(null, FontWeight.BOLD, 50));
        lblTitle.setTextFill(Color.BISQUE);
        lblUser1.getTransforms().add(new Translate(150, 120));
        lblUser1.setFont(Font.font(null, FontWeight.BOLD, 30));
        lblUser1.setTextFill(Color.ANTIQUEWHITE);
        lblUser2.getTransforms().add(new Translate(530, 120));
        lblUser2.setFont(Font.font(null, FontWeight.BOLD, 30));
        lblUser2.setTextFill(Color.ANTIQUEWHITE);
        lblUsername1.getTransforms().add(new Translate(75, 193));
        lblUsername1.setFont(Font.font(null, FontWeight.BOLD, 15));
        lblUsername1.setTextFill(Color.ANTIQUEWHITE);
        lblPassword1.getTransforms().add(new Translate(75, 295));
        lblPassword1.setFont(Font.font(null, FontWeight.BOLD, 15));
        lblPassword1.setTextFill(Color.ANTIQUEWHITE);
        txtUsername1.getTransforms().add(new Translate(160, 190));
        txtPassword1.getTransforms().add(new Translate(160, 290));
        lblIncorrect1.getTransforms().add(new Translate(100, 340));
        lblIncorrect1.setTextFill(Color.ANTIQUEWHITE);
        lblIncorrect1.setVisible(false);
        lblUsername2.getTransforms().add(new Translate(475, 193));
        lblUsername2.setFont(Font.font(null, FontWeight.BOLD, 15));
        lblUsername2.setTextFill(Color.ANTIQUEWHITE);
        lblPassword2.getTransforms().add(new Translate(475, 295));
        lblPassword2.setFont(Font.font(null, FontWeight.BOLD, 15));
        lblPassword2.setTextFill(Color.ANTIQUEWHITE);
        txtUsername2.getTransforms().add(new Translate(560, 190));
        txtPassword2.getTransforms().add(new Translate(560, 290));
        lblIncorrect2.getTransforms().add(new Translate(500, 340));
        lblIncorrect2.setTextFill(Color.ANTIQUEWHITE);
        lblIncorrect2.setVisible(false);

        lblSignup.getTransforms().add(new Translate(320, 55));
        lblSignup.setFont(Font.font(null, FontWeight.BOLD, 30));
        lblSignup.setTextFill(Color.ANTIQUEWHITE);
        lblSignupUsername.getTransforms().add(new Translate(250, 153));
        lblSignupUsername.setFont(Font.font(null, FontWeight.BOLD, 15));
        lblSignupUsername.setTextFill(Color.ANTIQUEWHITE);
        lblSignupPassword.getTransforms().add(new Translate(250, 230));
        lblSignupPassword.setFont(Font.font(null, FontWeight.BOLD, 15));
        lblSignupPassword.setTextFill(Color.ANTIQUEWHITE);
        lblSignupConfirmPassword.getTransforms().add(new Translate(250, 300));
        lblSignupConfirmPassword.setFont(Font.font(null, FontWeight.BOLD, 15));
        lblSignupConfirmPassword.setTextFill(Color.ANTIQUEWHITE);
        lblIncorrectS.getTransforms().add(new Translate(300, 350));
        lblIncorrectS.setTextFill(Color.ANTIQUEWHITE);
        lblIncorrectS.setVisible(false);
        txtSignupUsername.getTransforms().add(new Translate(350, 150));
        txtSignupPassword.getTransforms().add(new Translate(350, 225));
        txtSignupConfirmPassword.getTransforms().add(new Translate(350, 305));
        colorPicker.getTransforms().add(new Translate(550, 150));

        lblHint.getTransforms().add(new Translate(75, 75));
        lblHint.setFont(Font.font(null, FontWeight.BOLD, 15));
        lblHint.setTextFill(Color.ANTIQUEWHITE);
        lblTopThree.getTransforms().add(new Translate(280, 50));
        lblTopThree.setFont(Font.font(null, FontWeight.BOLD, 30));
        lblTopThree.setTextFill(Color.ANTIQUEWHITE);

        imageView1.setImage(imaCorrect);
        imageView1.getTransforms().add(new Translate(140, 190));
        imageView1.setVisible(false);
        imageView2.setImage(imaCorrect);
        imageView2.getTransforms().add(new Translate(520, 190));
        imageView2.setVisible(false);

        btnEnterLogin1.getTransforms().add(new Translate(185, 370));
        btnEnterLogin1.setOnAction(e -> btnEnter1());
        btnEnterLogin1.setMinWidth(75);
        btnEnterLogin2.getTransforms().add(new Translate(585, 370));
        btnEnterLogin2.setOnAction(e -> btnEnter2());
        btnEnterLogin2.setMinWidth(75);
        btnSignup.getTransforms().add(new Translate(375, 420));
        btnSignup.setOnAction(e -> switchScene(senSignup));
        btnSignup.setMinWidth(75);
        btnSignupEnter.getTransforms().add(new Translate(300, 400));
        btnSignupEnter.setOnAction(e -> btnSignupEnter(
                txtSignupUsername.getText(),
                txtSignupPassword.getText(),
                txtSignupConfirmPassword.getText(),
                colorPicker.getValue().toString()));
        btnSignupEnter.setMinWidth(75);
        btnSignupBack.getTransforms().add(new Translate(420, 400));
        btnSignupBack.setOnAction(e -> switchScene(senLogin));
        btnSignupBack.setMinWidth(75);
        btnResult.setOnAction(e -> switchScene(senResult));
        btnResult.setVisible(false);
        btnResult.getTransforms().add(new Translate(300, 450));
        btnQuit.getTransforms().add(new Translate(360, 350));
        btnQuit.setOnAction(e -> Platform.exit());
        btnQuit.setMinWidth(75);

        progressBar.getTransforms().add(new Translate(-3, 490));
        progressBar.setMaxSize(806, 15);
        progressBar.setMinSize(806, 15);

        setTable();

        login.getChildren().addAll(lblUser1);
        login.getChildren().add(lblUser2);
        login.getChildren().add(lblTitle);
        login.getChildren().add(lblUsername1);
        login.getChildren().add(lblPassword1);
        login.getChildren().add(lblUsername2);
        login.getChildren().add(lblPassword2);
        login.getChildren().add(lblIncorrect1);
        login.getChildren().add(lblIncorrect2);
        login.getChildren().add(btnEnterLogin1);
        login.getChildren().add(btnEnterLogin2);
        login.getChildren().add(txtUsername1);
        login.getChildren().add(txtPassword1);
        login.getChildren().add(txtUsername2);
        login.getChildren().add(txtPassword2);
        login.getChildren().add(btnSignup);
        login.getChildren().add(imageView1);
        login.getChildren().add(imageView2);
        signup.getChildren().add(lblSignup);
        signup.getChildren().add(lblSignupUsername);
        signup.getChildren().add(lblSignupPassword);
        signup.getChildren().add(lblSignupConfirmPassword);
        signup.getChildren().add(lblIncorrectS);
        signup.getChildren().add(btnSignupEnter);
        signup.getChildren().add(btnSignupBack);
        signup.getChildren().add(txtSignupUsername);
        signup.getChildren().add(txtSignupPassword);
        signup.getChildren().add(txtSignupConfirmPassword);
        signup.getChildren().add(colorPicker);
        game.getChildren().add(lblHint);
        game.getChildren().add(group);
        game.getChildren().add(btnResult);
        game.getChildren().add(light);
        game.getChildren().add(progressBar);
        result.getChildren().add(table);
        result.getChildren().add(btnQuit);
        result.getChildren().add(lblTopThree);
    }

    /**
     * pre: none. post: setup the game board on senGame
     */
    public void setupGame() {
        //Applying wooden texture
        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/images/white.jpg")));
        select.setDiffuseMap(new Image(getClass().getResourceAsStream("/images/w.jpg")));
        diffuseMap1.setDiffuseColor(null);
        diffuseMap2.setDiffuseColor(null);

        //initialize cells
        for (int i = 0; i < boxs.length; i++) {
            for (int j = 0; j < boxs[0].length; j++) {
                for (int k = 0; k < boxs[0][0].length; k++) {
                    boxs[i][j][k] = new Box(50, 50, 50);
                    //Apply material for the box
                    boxs[i][j][k].setMaterial(material);
                    boxs[i][j][k].setOpacity(0.0001);
                    //Add all the components
                    group.getChildren().add(boxs[i][j][k]);
                }
            }
        }
        setLocationGroup();
        for (int i = 0; i < location.length; i++) {
            for (int j = 0; j < location[0].length; j++) {
                for (int k = 0; k < location[0][0].length; k++) {
                    location[i][j][k] = new Box(50, 0.1, 50);
                    //Apply material for the box
                    location[i][j][k].setMaterial(black[i][j][k]);
                    location[i][j][k].setOpacity(0.0001);
                    //Add all the components
                    locationGroup.getChildren().add(location[i][j][k]);
                }
            }
        }

        translateBoxes(boxs, 70, 70, 70);
        translateBoxes(location, 50, 150, 50);

        game.getChildren().add(locationGroup);

        //Add both transformation to the container
        group.getTransforms().addAll(
                xRotate = new Rotate(30, Rotate.X_AXIS),
                yRotate = new Rotate(30, Rotate.Y_AXIS)
        );

        xRotate.angleProperty().bind(angleX);
        yRotate.angleProperty().bind(angleY);
        angleX.set(anchorAngleX + 30);
        anchorAngleX = angleX.get();
        angleY.set(anchorAngleY + 30);
        anchorAngleY = angleY.get();

        //Move to center of the screen
        group.translateXProperty().set(WIDTH / 2);
        group.translateYProperty().set(HEIGHT / 2);
        group.translateZProperty().set(-270);
        locationGroup.translateXProperty().set(750);
        locationGroup.translateYProperty().set(HEIGHT / 2);
        locationGroup.translateZProperty().set(300);
        locationGroup.getTransforms().addAll(new Rotate(40, Rotate.X_AXIS));

    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        Camera camLogin = new PerspectiveCamera();
        Camera camGame = new PerspectiveCamera();
        Camera camSignup = new PerspectiveCamera();
        Camera camResult = new PerspectiveCamera();

        //Create new scene with depth buffer enabled
        senLogin = new Scene(login, WIDTH, HEIGHT, true);
        senLogin.setFill(Color.GREEN);
        senLogin.setCamera(camLogin);
        senSignup = new Scene(signup, WIDTH, HEIGHT, true);
        senSignup.setFill(Color.GREEN);
        senSignup.setCamera(camSignup);
        senGame = new Scene(game, WIDTH, HEIGHT, true);
        senGame.setFill(Color.GREEN);
        senGame.setCamera(camGame);
        senResult = new Scene(result, WIDTH, HEIGHT, true);
        senResult.setFill(Color.GREEN);
        senResult.setCamera(camResult);

        //Add mouse control and meyboard control (two methods)
        initMouseControl(group, senGame);
        initKeyboardControl(group, senGame);

        primaryStage.setTitle("3D Tic-Tac-Toe");
        primaryStage.setScene(senLogin);
        primaryStage.show();
    }

    /**
     * pre: any keys is pressed. post: move the board forward or backward, or
     * rotate the cube
     *
     * @param group is the group of cells
     * @param scene is secGame
     */
    private void initKeyboardControl(SmartGroup group, Scene scene) {
        xRotate.angleProperty().bind(angleX);
        yRotate.angleProperty().bind(angleY);

        scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            //Process according to the key pressed.
            switch (event.getCode()) {
                case Q://Move the group farer
                    group.translateZProperty().set(group.getTranslateZ() + 100);
                    break;
                case E://Move the group closer
                    group.translateZProperty().set(group.getTranslateZ() - 100);
                    break;
                case S:
                    angleX.set(anchorAngleX - 10);
                    anchorAngleX = angleX.get();
                    break;
                case W:
                    angleX.set(anchorAngleX - (-10));
                    anchorAngleX = angleX.get();
                    break;
                case A:
                    angleY.set(anchorAngleY - 10);
                    anchorAngleY = angleY.get();
                    break;
                case D:
                    angleY.set(anchorAngleY - (-10));
                    anchorAngleY = angleY.get();
                    break;
            }
        });
    }

    /**
     * pre: there is a mouse events (click, drag, scroll). post: move the board
     * forward or backward, or rotate the cube
     *
     * @param group is the group of cells
     * @param scene is secGame
     * https://www.genuinecoder.com/javafx-3d-tutorial-introduction/
     */
    private void initMouseControl(SmartGroup group, Scene scene) {
        //Bind Double property angleX/angleY with corresponding transformation. 
        //When we update angleX / angleY, the transform will also be auto updated.
        xRotate.angleProperty().bind(angleX);
        yRotate.angleProperty().bind(angleY);

        //Listen for mouse press -- Drag start with a click
        scene.setOnMousePressed(event -> {
            //Save start points
            anchorX = event.getSceneX();
            anchorY = event.getSceneY();
        });

        //Listen for drag
        scene.setOnMouseDragged(event -> {
            //event.getSceneY() gives current Y value. 
            //Find how much far away it is from saved anchorY point.
            angleX.set(anchorAngleX - (anchorY - event.getSceneY()));
            angleY.set(anchorAngleY + (anchorX - event.getSceneX()));
        });

        //Listen for release -- Drag end with release
        scene.setOnMouseReleased(event -> {
            //Save current rotation angle
            anchorAngleX = angleX.get();
            anchorAngleY = angleY.get();
        });

        //Listen for scroll - move along z-axis
        scene.addEventHandler(ScrollEvent.SCROLL, event -> {
            //Get how much scroll was done in Y axis.
            double delta = event.getDeltaY();
            if (!((group.getTranslateZ() <= -500 && delta < 0)
                    || (group.getTranslateZ() >= 200 && delta > 0))) {
                //Add it to the Z-axis location.
                group.translateZProperty().set(group.getTranslateZ() + delta);
            }
        });

        //Listen for double click - select the cell
        scene.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 && g.getWinner() == null) {
                timerReset();
                for (int i = 0; i < boxs.length; i++) {
                    for (int j = 0; j < boxs[0].length; j++) {
                        for (int k = 0; k < boxs[0][0].length; k++) {
                            if (event.getTarget() == boxs[i][j][k]) {
                                if (g.click(new Boxes(i, j, k)) == true) {
                                    if (g.getNowPlayer().getID() == g.getPlayer1().getID()) {
                                        boxs[i][j][k].setMaterial(diffuseMap1);
                                        location[i][j][k].setMaterial(redS[i][j][k]);
                                    } else if (g.getNowPlayer().getID() == g.getPlayer2().getID()) {
                                        boxs[i][j][k].setMaterial(diffuseMap2);
                                        location[i][j][k].setMaterial(blueS[i][j][k]);
                                    }
                                    lblHint.setText(g.getNowPlayer().getName() + "'s tern");
                                    if (g.getWinner() != null) {
                                        btnResult.setVisible(true);
                                        btnResult.setText(g.getWinner().getName() + " wins! --> Go to result page");
                                        lblHint.setVisible(false);
                                        updateDatabase();
                                        setTable();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

        scene.setOnMouseMoved(event -> {
            for (int i = 0; i < boxs.length; i++) {
                for (int j = 0; j < boxs.length; j++) {
                    for (int k = 0; k < boxs.length; k++) {
                        if (event.getTarget() == boxs[i][j][k]) {
                            if (g.b.boxes[i][j][k].getPlayer() == 0) {
                                location[i][j][k].setMaterial(blackS[i][j][k]);
                                boxs[i][j][k].setMaterial(select);
                            }
                            if (g.b.boxes[i][j][k].getPlayer() == 2) {
                                location[i][j][k].setMaterial(redS[i][j][k]);
                            }
                            if (g.b.boxes[i][j][k].getPlayer() == 1) {
                                location[i][j][k].setMaterial(blueS[i][j][k]);
                            }
                        }
                        if (event.getTarget() != boxs[i][j][k]) {
                            if (g.b.boxes[i][j][k].getPlayer() == 0) {
                                location[i][j][k].setMaterial(black[i][j][k]);
                                boxs[i][j][k].setMaterial(material);
                            }
                            if (g.b.boxes[i][j][k].getPlayer() == 2) {
                                location[i][j][k].setMaterial(red[i][j][k]);
                            }
                            if (g.b.boxes[i][j][k].getPlayer() == 1) {
                                location[i][j][k].setMaterial(blue[i][j][k]);
                            }
                        }
                    }
                }
            }

        });
    }

    /**
     * pre: none. post: close the present scene, and display another scene
     *
     * @param scene is the scene that would be switched to
     */
    public void switchScene(Scene scene) {
        stage.setScene(scene);
        stage.show();
    }

    /**
     * pre: btnEnter1 is clicked. post: check the username and password in the
     * textFields above, if both correct, switch to secGame
     */
    private void btnEnter1() {
        boolean check = check(txtUsername1.getText(), txtPassword1.getText());
        if (check == true && !(txtUsername1.getText().equals(txtUsername2.getText()))) {
            imageView1.setVisible(true);
            lblUsername1.setVisible(false);
            lblPassword1.setVisible(false);
            btnEnterLogin1.setVisible(false);
            txtUsername1.setVisible(false);
            txtPassword1.setVisible(false);
            lblIncorrect1.setVisible(false);
            user1 = check;
            value1 = getColor(txtUsername1.getText());
        } else {
            txtPassword1.setText("");
            lblIncorrect1.setVisible(true);
        }
        setPlayers();
    }

    /**
     * pre: btnEnter2 is clicked. post: check the username and password in the
     * textFields above, if both correct, switch to secGame
     */
    private void btnEnter2() {
        boolean check = check(txtUsername2.getText(), txtPassword2.getText());
        if (check == true && !(txtUsername1.getText().equals(txtUsername2.getText()))) {
            imageView2.setVisible(true);
            lblUsername2.setVisible(false);
            lblPassword2.setVisible(false);
            btnEnterLogin2.setVisible(false);
            txtUsername2.setVisible(false);
            txtPassword2.setVisible(false);
            lblIncorrect2.setVisible(false);
            user2 = check;
            value2 = getColor(txtUsername2.getText());
        } else {
            txtPassword2.setText("");
            lblIncorrect2.setVisible(true);
        }
        setPlayers();
    }

    /**
     * pre: both the players entered correct username and password. post: set
     * the Players object in Game class according the username
     */
    public void setPlayers() {
        if (user1 == true && user2 == true) {
            g = new Game(b, new Players(01, txtUsername1.getText()), new Players(02, txtUsername2.getText()));
            lblHint.setText(g.getNowPlayer().getName() + "'s turn");
            switchScene(senGame);
            diffuseMap1.setDiffuseColor(Color.valueOf(value2));
            diffuseMap2.setDiffuseColor(Color.valueOf(value1));
        }
        setTimer();

    }

    /**
     * pre: btnSignupEnter is clicked. post: check the password and confirmed
     * password in the textFields above, if they are same, save the new username
     * and password into the database and switch to secGame from
     *
     * @param un is the typed username
     * @param pw is the typed password
     * @param cPw is the retyped password
     * https://www.youtube.com/watch?v=CITiIS0OL1k
     */
    private void btnSignupEnter(String un, String pw, String cPw, String clr) {
        boolean match = false;
        String[] usernames = new String[100];
        String[] colors = new String[100];
        int count = 0;
        try {
            myresObj = mystatObj.executeQuery("Select * from Zihan.USERINFORMATION");
            while (myresObj.next() == true) {
                String userName = myresObj.getString(1);
                usernames[count] = userName;
                String color = myresObj.getString(6);
                colors[count] = color;
                count++;
                for (int i = 0; i < count; i++) {
                    System.out.println(usernames[i]);
                    if (un.equals(usernames[i]) || clr.equals(color)) {
                        match = true;
                        break;
                    }
                }
            }
        } catch (SQLException e) {
        }
        if (match == true) {
            txtSignupPassword.setText("");
            txtSignupConfirmPassword.setText("");
            lblIncorrectS.setText("User already exist or color is already choosen");
            lblIncorrectS.setVisible(true);
        } else if (pw.equals(cPw) && !(txtSignupPassword.getText().equals("")) && !(txtSignupUsername.getText().equals(""))) {
            try {
                myresObj = mystatObj.executeQuery("Select * from Zihan.USERINFORMATION");
                PreparedStatement st = myconObj.prepareStatement(
                        "insert into userinformation(username, password, totalWins, totalLosses, winRate, color)values(?,?,?,?,?,?)");
                st.setString(1, un);
                st.setString(2, pw);
                st.setInt(3, 0);
                st.setInt(4, 0);
                st.setInt(5, 0);
                st.setString(6, clr);
                int a = st.executeUpdate();
                if (a > 0) {
                    System.out.println("Row Update");
                }
            } catch (SQLException e) {
            }
            txtSignupUsername.setText("");
            txtSignupPassword.setText("");
            txtSignupConfirmPassword.setText("");
            lblIncorrectS.setVisible(false);
            switchScene(senLogin);
        } else {
            lblIncorrectS.setText("the comfirmed passwords should be the same");
            txtSignupPassword.setText("");
            txtSignupConfirmPassword.setText("");
            lblIncorrectS.setVisible(true);
        }
    }

    /**
     * pre: there is a winner of the game. post: change the numbers in wins and
     * losses columns in the database.
     */
    private void updateDatabase() {
        try {
            myresObj = mystatObj.executeQuery("Select * from Zihan.USERINFORMATION");
            if (g.getWinner().ID == g.getPlayer1().ID) {
                while (myresObj.next()) {
                    if (myresObj.getString(1).equals(txtUsername1.getText())) {
                        int a = myresObj.getInt(3) + 1;
                        myresObj.updateInt(3, a);
                    }
                    if (myresObj.getString(1).equals(txtUsername2.getText())) {
                        int a = myresObj.getInt(4) + 1;
                        myresObj.updateInt(4, a);
                    }
                    myresObj.updateRow();

                }
            } else if (g.getWinner().ID == g.getPlayer2().ID) {
                while (myresObj.next()) {
                    if (myresObj.getString(1).equals(txtUsername1.getText())) {
                        int a = myresObj.getInt(4) + 1;
                        myresObj.updateInt(4, a);
                    }
                    if (myresObj.getString(1).equals(txtUsername2.getText())) {
                        int a = myresObj.getInt(3) + 1;
                        myresObj.updateInt(3, a);
                    }
                    myresObj.updateRow();
                }
            }
            myresObj.beforeFirst();
        } catch (SQLException e) {
        }
    }

    /**
     * pre: the database is updated. post: create a table of top players for
     * displaying
     *
     * @ https://www.w3cschool.cn/java/javafx-tableview.html
     */
    private void setTable() {
        HBox hb = new HBox();
        hb.setSpacing(3);
        ObservableList<Account> data = FXCollections.observableArrayList();

        colUsername.setMinWidth(100);
        colUsername.setCellValueFactory(
                new PropertyValueFactory<>("username"));

        colWins.setMinWidth(100);
        colWins.setCellValueFactory(
                new PropertyValueFactory<>("wins"));

        colLosses.setMinWidth(100);
        colLosses.setCellValueFactory(
                new PropertyValueFactory<>("Losses"));

        int count = 0;
        try {
            myresObj = mystatObj.executeQuery("Select * from Zihan.USERINFORMATION");
            while (myresObj.next() == true) {
                count++;
                String username = myresObj.getString(1);
                int wins = myresObj.getInt(3);
                int losses = myresObj.getInt(4);
                data.add(new Account(username, wins, losses));
            }
        } catch (SQLException e) {

        }

        table.setItems(data);
        table.getColumns().addAll(colUsername, colWins, colLosses);
        table.setMaxSize(8000, 153);
        table.setTableMenuButtonVisible(false);

        colWins.setSortType(TableColumn.SortType.DESCENDING);
        table.getSortOrder().add(colWins);
        colUsername.setSortable(false);
        colWins.setSortable(true);
        colLosses.setSortable(false);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(table, hb);
        table.getTransforms().add(new Translate(250 / 2, 100 / 2));
        result.getChildren().add(vbox);
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * pre: the database exist. post: connect with the database from
     * https://www.youtube.com/watch?v=HLx1ySEVAgQ
     */
    public void connectWithDatabase() {
        try {
            myconObj = DriverManager.getConnection("jdbc:derby://localhost:1527/3DTic-Tac-Toe", "Zihan", "Pzhwl0207!");
            mystatObj = myconObj.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException e) {
        }
    }

    /**
     * pre: a database is connected. post: check whether the informations in the
     * textFields are correct
     *
     * @param un is the typed username
     * @param pw is the typed password
     * @return whether the username and password match with the database from
     * https://www.youtube.com/watch?v=HLx1ySEVAgQ
     */
    public boolean check(String un, String pw) {
        boolean match = false;
        try {
            myresObj = mystatObj.executeQuery("Select * from Zihan.USERINFORMATION");
            while (myresObj.next() == true) {
                String userName = myresObj.getString(1);
                String password = myresObj.getString(2);

                if (un.equals(userName) && pw.equals(password)) {
                    match = true;
                    break;
                }
            }
        } catch (SQLException e) {
        }
        return match;
    }

    public String getColor(String un) {
        try {
            myresObj = mystatObj.executeQuery("Select * from Zihan.USERINFORMATION");
            while (myresObj.next() == true) {
                String userName = myresObj.getString(1);
                if (un.equals(userName)) {
                    String value = myresObj.getString(6);
                    return value;
                }
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public void timerReset() {
        if (time == 0) {
            timer.start();
        } else {
            timer.stop();
            time = 0;
            progressBar.setProgress(1);
            timer.start();
        }

    }

    public void setTimer() {
        timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (btnResult.isVisible() == true) {
                    timer.stop();
                    progressBar.setVisible(false);
                } else if (time < 10000) {
                    time++;
                    progressBar.setProgress(1 - time / 10000);
                } else if (time == 10000) {
                    timer.stop();
                    time = 0;
                    g.switchPlayer();
                    progressBar.setProgress(1);
                    timer.start();
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            lblHint.setText(g.getNowPlayer().getName() + "'s turn");
                        }
                    });
                }
            }
        });

    }

    /**
     * pre: all the 27 cells are generated. post: move the cells to the correct
     * position to have a big cube
     *
     * @param boxs is an 3D array of the 27 cells
     * @param x, y, and z are the distance the cell is going to be translated
     */
    public void translateBoxes(Box[][][] boxs, int x, int y, int z) {
        boxs[0][0][0].getTransforms().add(new Translate(-x, y, z));
        boxs[0][0][1].getTransforms().add(new Translate(0, y, z));
        boxs[0][0][2].getTransforms().add(new Translate(x, y, z));
        boxs[0][1][0].getTransforms().add(new Translate(-x, y, 0));
        boxs[0][1][1].getTransforms().add(new Translate(0, y, 0));
        boxs[0][1][2].getTransforms().add(new Translate(x, y, 0));
        boxs[0][2][0].getTransforms().add(new Translate(-x, y, -z));
        boxs[0][2][1].getTransforms().add(new Translate(0, y, -z));
        boxs[0][2][2].getTransforms().add(new Translate(x, y, -z));

        boxs[1][0][0].getTransforms().add(new Translate(-x, 0, z));
        boxs[1][0][1].getTransforms().add(new Translate(0, 0, z));
        boxs[1][0][2].getTransforms().add(new Translate(x, 0, z));
        boxs[1][1][0].getTransforms().add(new Translate(-x, 0, 0));
        boxs[1][1][1].getTransforms().add(new Translate(0, 0, 0));
        boxs[1][1][2].getTransforms().add(new Translate(x, 0, 0));
        boxs[1][2][0].getTransforms().add(new Translate(-x, 0, -z));
        boxs[1][2][1].getTransforms().add(new Translate(0, 0, -z));
        boxs[1][2][2].getTransforms().add(new Translate(x, 0, -z));

        boxs[2][0][0].getTransforms().add(new Translate(-x, -y, z));
        boxs[2][0][1].getTransforms().add(new Translate(0, -y, z));
        boxs[2][0][2].getTransforms().add(new Translate(x, -y, z));
        boxs[2][1][0].getTransforms().add(new Translate(-x, -y, 0));
        boxs[2][1][1].getTransforms().add(new Translate(0, -y, 0));
        boxs[2][1][2].getTransforms().add(new Translate(x, -y, 0));
        boxs[2][2][0].getTransforms().add(new Translate(-x, -y, -z));
        boxs[2][2][1].getTransforms().add(new Translate(0, -y, -z));
        boxs[2][2][2].getTransforms().add(new Translate(x, -y, -z));
    }

    /**
     * pre: all the 27 flat cells are generated. post: move the flat cells to
     * the correct position to have the three layers on the side and set the
     * diffuse map image for each of then according to the colors and numbers
     *
     */
    public void setLocationGroup() {
        for (int i = 0; i < black.length; i++) {
            for (int j = 0; j < black[0].length; j++) {
                for (int k = 0; k < black[0][0].length; k++) {
                    black[i][j][k] = new PhongMaterial();
                    red[i][j][k] = new PhongMaterial();
                    blue[i][j][k] = new PhongMaterial();
                    blackS[i][j][k] = new PhongMaterial();
                    redS[i][j][k] = new PhongMaterial();
                    blueS[i][j][k] = new PhongMaterial();
                }
            }
        }

        black[0][2][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b1.jpg")));
        black[0][2][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b2.jpg")));
        black[0][2][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b3.jpg")));
        black[0][1][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b4.jpg")));
        black[0][1][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b5.jpg")));
        black[0][1][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b6.jpg")));
        black[0][0][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b7.jpg")));
        black[0][0][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b8.jpg")));
        black[0][0][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b9.jpg")));

        black[1][2][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b10.jpg")));
        black[1][2][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b11.jpg")));
        black[1][2][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b12.jpg")));
        black[1][1][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b13.jpg")));
        black[1][1][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b14.jpg")));
        black[1][1][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b15.jpg")));
        black[1][0][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b16.jpg")));
        black[1][0][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b17.jpg")));
        black[1][0][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b18.jpg")));

        black[2][2][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b19.jpg")));
        black[2][2][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b20.jpg")));
        black[2][2][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b21.jpg")));
        black[2][1][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b22.jpg")));
        black[2][1][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b23.jpg")));
        black[2][1][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b24.jpg")));
        black[2][0][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b25.jpg")));
        black[2][0][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b26.jpg")));
        black[2][0][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b27.jpg")));

        red[0][2][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r1.jpg")));
        red[0][2][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r2.jpg")));
        red[0][2][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r3.jpg")));
        red[0][1][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r4.jpg")));
        red[0][1][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r5.jpg")));
        red[0][1][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r6.jpg")));
        red[0][0][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r7.jpg")));
        red[0][0][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r8.jpg")));
        red[0][0][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r9.jpg")));

        red[1][2][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r10.jpg")));
        red[1][2][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r11.jpg")));
        red[1][2][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r12.jpg")));
        red[1][1][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r13.jpg")));
        red[1][1][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r14.jpg")));
        red[1][1][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r15.jpg")));
        red[1][0][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r16.jpg")));
        red[1][0][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r17.jpg")));
        red[1][0][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r18.jpg")));

        red[2][2][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r19.jpg")));
        red[2][2][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r20.jpg")));
        red[2][2][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r21.jpg")));
        red[2][1][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r22.jpg")));
        red[2][1][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r23.jpg")));
        red[2][1][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r24.jpg")));
        red[2][0][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r25.jpg")));
        red[2][0][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r26.jpg")));
        red[2][0][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r27.jpg")));

        blue[0][2][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u1.jpg")));
        blue[0][2][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u2.jpg")));
        blue[0][2][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u3.jpg")));
        blue[0][1][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u4.jpg")));
        blue[0][1][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u5.jpg")));
        blue[0][1][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u6.jpg")));
        blue[0][0][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u7.jpg")));
        blue[0][0][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u8.jpg")));
        blue[0][0][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u9.jpg")));

        blue[1][2][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u10.jpg")));
        blue[1][2][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u11.jpg")));
        blue[1][2][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u12.jpg")));
        blue[1][1][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u13.jpg")));
        blue[1][1][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u14.jpg")));
        blue[1][1][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u15.jpg")));
        blue[1][0][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u16.jpg")));
        blue[1][0][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u17.jpg")));
        blue[1][0][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u18.jpg")));

        blue[2][2][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u19.jpg")));
        blue[2][2][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u20.jpg")));
        blue[2][2][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u21.jpg")));
        blue[2][1][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u22.jpg")));
        blue[2][1][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u23.jpg")));
        blue[2][1][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u24.jpg")));
        blue[2][0][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u25.jpg")));
        blue[2][0][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u26.jpg")));
        blue[2][0][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u27.jpg")));

        blackS[0][2][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b1 copy.jpg")));
        blackS[0][2][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b2 copy.jpg")));
        blackS[0][2][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b3 copy.jpg")));
        blackS[0][1][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b4 copy.jpg")));
        blackS[0][1][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b5 copy.jpg")));
        blackS[0][1][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b6 copy.jpg")));
        blackS[0][0][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b7 copy.jpg")));
        blackS[0][0][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b8 copy.jpg")));
        blackS[0][0][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b9 copy.jpg")));

        blackS[1][2][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b10 copy.jpg")));
        blackS[1][2][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b11 copy.jpg")));
        blackS[1][2][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b12 copy.jpg")));
        blackS[1][1][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b13 copy.jpg")));
        blackS[1][1][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b14 copy.jpg")));
        blackS[1][1][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b15 copy.jpg")));
        blackS[1][0][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b16 copy.jpg")));
        blackS[1][0][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b17 copy.jpg")));
        blackS[1][0][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b18 copy.jpg")));

        blackS[2][2][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b19 copy.jpg")));
        blackS[2][2][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b20 copy.jpg")));
        blackS[2][2][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b21 copy.jpg")));
        blackS[2][1][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b22 copy.jpg")));
        blackS[2][1][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b23 copy.jpg")));
        blackS[2][1][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b24 copy.jpg")));
        blackS[2][0][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b25 copy.jpg")));
        blackS[2][0][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b26 copy.jpg")));
        blackS[2][0][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/b27 copy.jpg")));

        redS[0][2][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r1 copy.jpg")));
        redS[0][2][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r2 copy.jpg")));
        redS[0][2][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r3 copy.jpg")));
        redS[0][1][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r4 copy.jpg")));
        redS[0][1][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r5 copy.jpg")));
        redS[0][1][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r6 copy.jpg")));
        redS[0][0][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r7 copy.jpg")));
        redS[0][0][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r8 copy.jpg")));
        redS[0][0][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r9 copy.jpg")));

        redS[1][2][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r10 copy.jpg")));
        redS[1][2][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r11 copy.jpg")));
        redS[1][2][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r12 copy.jpg")));
        redS[1][1][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r13 copy.jpg")));
        redS[1][1][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r14 copy.jpg")));
        redS[1][1][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r15 copy.jpg")));
        redS[1][0][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r16 copy.jpg")));
        redS[1][0][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r17 copy.jpg")));
        redS[1][0][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r18 copy.jpg")));

        redS[2][2][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r19 copy.jpg")));
        redS[2][2][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r20 copy.jpg")));
        redS[2][2][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r21 copy.jpg")));
        redS[2][1][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r22 copy.jpg")));
        redS[2][1][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r23 copy.jpg")));
        redS[2][1][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r24 copy.jpg")));
        redS[2][0][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r25 copy.jpg")));
        redS[2][0][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r26 copy.jpg")));
        redS[2][0][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/r27 copy.jpg")));

        blueS[0][2][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u1 copy.jpg")));
        blueS[0][2][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u2 copy.jpg")));
        blueS[0][2][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u3 copy.jpg")));
        blueS[0][1][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u4 copy.jpg")));
        blueS[0][1][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u5 copy.jpg")));
        blueS[0][1][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u6 copy.jpg")));
        blueS[0][0][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u7 copy.jpg")));
        blueS[0][0][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u8 copy.jpg")));
        blueS[0][0][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u9 copy.jpg")));

        blueS[1][2][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u10 copy.jpg")));
        blueS[1][2][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u11 copy.jpg")));
        blueS[1][2][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u12 copy.jpg")));
        blueS[1][1][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u13 copy.jpg")));
        blueS[1][1][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u14 copy.jpg")));
        blueS[1][1][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u15 copy.jpg")));
        blueS[1][0][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u16 copy.jpg")));
        blueS[1][0][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u17 copy.jpg")));
        blueS[1][0][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u18 copy.jpg")));

        blueS[2][2][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u19 copy.jpg")));
        blueS[2][2][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u20 copy.jpg")));
        blueS[2][2][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u21 copy.jpg")));
        blueS[2][1][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u22 copy.jpg")));
        blueS[2][1][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u23 copy.jpg")));
        blueS[2][1][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u24 copy.jpg")));
        blueS[2][0][0].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u25 copy.jpg")));
        blueS[2][0][1].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u26 copy.jpg")));
        blueS[2][0][2].setDiffuseMap(new Image(getClass().getResourceAsStream("/images/u27 copy.jpg")));
    }

    /**
     * from https://www.genuinecoder.com/javafx-3d-tutorial-introduction/
     */
    class SmartGroup extends Group {

        Rotate r;
        Transform t = new Rotate();

        void rotateByX(int ang) {
            r = new Rotate(ang, Rotate.X_AXIS);
            t = t.createConcatenation(r);
            this.getTransforms().clear();
            this.getTransforms().addAll(t);
        }

        void rotateByY(int ang) {
            r = new Rotate(ang, Rotate.Y_AXIS);
            t = t.createConcatenation(r);
            this.getTransforms().clear();
            this.getTransforms().addAll(t);
        }
    }

    class CountDown {

        int count = 10;
        String cdText;

        public void beginCountDown() {
            cdText = String.valueOf(count);
            if (count > 0) {
                count--;
            } else {
                cdText = "Time is up";
            }
        }

        public int getCount() {
            return count;
        }

        public String getCdText() {
            return cdText;
        }

    }

}
