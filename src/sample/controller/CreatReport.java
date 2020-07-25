package sample.controller;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import sample.model.mytable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class CreatReport implements Initializable {

    @FXML
    private TextField Rid;
    @FXML
    private TextField Rid1;
    @FXML
    private TextField Rid11;
    @FXML
    private TextField Mid111;

    @FXML
    private TextField MusteriTxtId;

    @FXML
    private TextField ProjeadiTxtId;

    @FXML
    private TextField TestyeriTxtId;

    @FXML
    private TextField MuayenestandardiTxtId;

    @FXML
    private TextField DegerlenstandardiTxtId;

    @FXML
    private TextField MuayeneproseduruTxtId;

    @FXML
    private TextField MuayenekapsamiTxtId;

    @FXML
    private TextField ResimnoTxtId;

    @FXML
    private TextField yuzeydurumuTxtId;

    @FXML
    private ComboBox<String> MuayeneasamasicmboId;

    @FXML
    private TextField pageTxtId;

    @FXML
    private TextField rapornoTxtId;

    @FXML
    private TextField joboderTxtId;

    @FXML
    private TextField offernoTxtId;
    @FXML
    private ImageView imageView;
    @FXML
    private ImageView imageView2;
    @FXML
    private CheckBox cb1;

    @FXML
    private CheckBox cb2;

    @FXML
    private TableView<mytable> table1 = new TableView<mytable>();


    private boolean isInt(TextField input, String mes) {
        try {
            int Mukapsami = Integer.parseInt(input.getText());

            System.out.println("input is " + Mukapsami);
            if (1 <= Mukapsami && Mukapsami <= 100) {
                input.setText(Mukapsami + "%");
                return true;
            } else {
                input.setText("");

                return false;
            }
        } catch (NumberFormatException e) {

            System.out.println("errorrrrr " + mes);
            input.setText("");

            return false;
        }

    }
    public void myfun(String text ,String text1 ){
       // System.out.println("hhh"+text);

        Rid.setText(text);
        Rid1.setText(text);
        Rid11.setText(text);
        Mid111.setText(text1);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        MuayenekapsamiTxtId.setText("100%");
        MuayenekapsamiTxtId.setOnAction(event -> isInt(MuayenekapsamiTxtId, MuayenekapsamiTxtId.getText()));

        ObservableList<String> list = FXCollections.observableArrayList("untreated", "treated");
        MuayeneasamasicmboId.setItems(list);

        Image image = null;
        try {
            image = new Image(new FileInputStream("C:\\Users\\3bira\\Desktop\\6.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        imageView.setImage(image);
        Image image2 = null;
        try {
            image2 = new Image(new FileInputStream("C:\\Users\\3bira\\Desktop\\66.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        imageView2.setImage(image2);


        table1.setEditable(true);
        ObservableList<mytable> dat = FXCollections.observableArrayList(
                new mytable("2", "", "", "", "", "", "", "", FXCollections.observableArrayList("OK", "RED"))
        );

        TableColumn Serial_noco = new TableColumn("Serial no");
        Serial_noco.setCellValueFactory(new PropertyValueFactory<mytable, String>("serial_no"));

        TableColumn weldco = new TableColumn("weld/piece no");
        weldco.setMinWidth(100);
        weldco.setCellValueFactory(new PropertyValueFactory<mytable, String>("weld"));

        TableColumn test_lengthco = new TableColumn("test length");
        test_lengthco.setMinWidth(100);
        test_lengthco.setCellValueFactory(new PropertyValueFactory<mytable, String>("test_length"));

        TableColumn welding_processco = new TableColumn("welding process");
        welding_processco.setMinWidth(100);
        welding_processco.setCellValueFactory(new PropertyValueFactory<mytable, String>("welding_process"));

        TableColumn thicknessco = new TableColumn("thickness");
        thicknessco.setMinWidth(100);
        thicknessco.setCellValueFactory(new PropertyValueFactory<mytable, String>("thickness"));

        TableColumn diameterco = new TableColumn("diameter");
        diameterco.setCellValueFactory(new PropertyValueFactory<mytable, String>("diameter"));

        TableColumn defect_typeco = new TableColumn("defect type");
        defect_typeco.setCellValueFactory(new PropertyValueFactory<mytable, String>("defect_type"));

        TableColumn defect_locco = new TableColumn("defect loc.");
        defect_locco.setCellValueFactory(new PropertyValueFactory<mytable, String>("defect_loc"));

        TableColumn resultco = new TableColumn("result");
        resultco.setCellValueFactory(new PropertyValueFactory<mytable, String>("result"));

        table1.setItems(dat);

        table1.getColumns().addAll(Serial_noco
                , weldco, test_lengthco, welding_processco,
                thicknessco, diameterco, defect_typeco, defect_locco, resultco
        );
    }
}

