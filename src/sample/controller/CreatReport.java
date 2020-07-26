package sample.controller;
//nazli araki 170503107

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import sample.model.Employee;
import sample.model.equipment;
import sample.model.firma;
import sample.model.mytable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class CreatReport implements Initializable {


    @FXML
    private TextField opadi;
    @FXML
    private TextField evadi;
    @FXML
    private TextField pdid;
    @FXML
    private TextField eqid;
    @FXML
    private TextField cmidd;
    @FXML
    private TextField mtid;
    @FXML
    private TextField liid;
    @FXML
    private TextField difid;


    @FXML
    private TextField Rid;

    @FXML
    private TextField sicak;
    @FXML
    private TextField ktt;
    @FXML
    private TextField Muortami;
    @FXML
    private TextField Mgi;
    @FXML
    private TextField isiis;
    @FXML
    private TextField Rid1;
    @FXML
    private TextField Rid11;
    @FXML
    private TextField Mid111;

    @FXML
    private ComboBox<String> musteriid;

    @FXML
    private ComboBox<String> aktiid;
    @FXML
    private ComboBox<String> ProjeadiTxtId;

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
    private TextField Muayenebolgesiid;
    @FXML
    private TextField  muayeneboboid;

    @FXML
    private TextField offernoTxtId;
    @FXML
    private TextField luxid;
    @FXML
    private TextField yuzeyid;

    @FXML
    private TextField isikid;
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
    @FXML
    private Button toex;

    @FXML
    private Button topdf;

    @FXML
    void toexA(ActionEvent event) throws IOException {
        Workbook workbook=new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("report");

       sheet.addMergedRegion(new CellRangeAddress(1, 1, 2,5));
        Row row0 =sheet.createRow(0);
        row0.createCell(2).setCellValue("MANYETİK PARÇACIK MUAYENE RAPORU");
        sheet.setColumnWidth(0,22 * 260);
        sheet.setColumnWidth(1,22 * 260);
        sheet.setColumnWidth(2,22 * 260);
        sheet.setColumnWidth(3,22 * 260);
        sheet.setColumnWidth(4,22 * 260);
        sheet.setColumnWidth(5,22 * 260);



        Row row =sheet.createRow(2);
        CellStyle style = workbook.createCellStyle();
        CellStyle style1 = workbook.createCellStyle();

        style.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderBottom(BorderStyle.MEDIUM);
        style.setBorderLeft(BorderStyle.MEDIUM);
        style.setBorderRight(BorderStyle.MEDIUM);
        style.setBorderTop(BorderStyle.MEDIUM);

        style1.setBorderBottom(BorderStyle.MEDIUM);
        style1.setBorderLeft(BorderStyle.MEDIUM);
        style1.setBorderRight(BorderStyle.MEDIUM);
        style1.setBorderTop(BorderStyle.MEDIUM );


        row.createCell(0).setCellValue("musteri " );
        row.createCell(1).setCellValue(musteriid.getValue());
        row.getCell(1).setCellStyle(style1);
        row.createCell(2).setCellValue("Muayene Prosedürü");
        row.getCell(2).setCellStyle(style);
        row.setHeight( (short) 600);
        row.getCell(0).setCellStyle(style);
        row.createCell(3).setCellValue(MuayeneproseduruTxtId.getText());
        row.getCell(3).setCellStyle(style1);
        row.createCell(4).setCellValue("Sayfa No " );
        row.getCell(4).setCellStyle(style);
        row.createCell(5).setCellValue(pageTxtId.getText());
        row.getCell(5).setCellStyle(style1);


        Row row1 =sheet.createRow(3);
        row1.createCell(0).setCellValue("Proje Adı " );
        row1.createCell(1).setCellValue(ProjeadiTxtId.getValue());
        row1.setHeight( (short) 600);
        row1.getCell(1).setCellStyle(style1);
        row1.getCell(0).setCellStyle(style);
        row1.createCell(2).setCellValue("Muayenekapsami");
        row1.getCell(2).setCellStyle(style);
        row1.createCell(3).setCellValue(MuayenekapsamiTxtId.getText());
        row1.getCell(3).setCellStyle(style1);
        row1.createCell(4).setCellValue("Rapor No" );
        row1.getCell(4).setCellStyle(style);
        row1.createCell(5).setCellValue(rapornoTxtId.getText());
        row1.getCell(5).setCellStyle(style1);



        Row row2 =sheet.createRow(4);
        row2.createCell(0).setCellValue("Test Yeri" );
        row2.createCell(1).setCellValue(TestyeriTxtId.getText());
        row2.setHeight((short) (600));
        row2.getCell(1).setCellStyle(style1);
        row2.getCell(0).setCellStyle(style);
        row2.createCell(2).setCellValue("resim no");
        row2.getCell(2).setCellStyle(style);
        row2.createCell(3).setCellValue(ResimnoTxtId.getText());
        row2.getCell(3).setCellStyle(style1);
        row2.createCell(4).setCellValue("Rapor Tarihi  " );
        row2.getCell(4).setCellStyle(style);
        row2.createCell(5).setCellValue(Rid.getText());
        row2.getCell(5).setCellStyle(style1);



        Row row3 =sheet.createRow(5);
        row3.createCell(0).setCellValue("Muayene Standardı ");
        row3.createCell(1).setCellValue(MuayenestandardiTxtId.getText());
        row3.setHeight( (short) 600);
        row3.getCell(1).setCellStyle(style1);
        row3.getCell(0).setCellStyle(style);
        row3.createCell(2).setCellValue("yuzey durumu");
        row3.getCell(2).setCellStyle(style);
        row3.createCell(3).setCellValue(yuzeydurumuTxtId.getText());
        row3.getCell(3).setCellStyle(style1);
        row3.createCell(4).setCellValue(" İş Emri No  " );
        row3.getCell(4).setCellStyle(style);
        row3.createCell(5).setCellValue(joboderTxtId.getText());
        row3.getCell(5).setCellStyle(style1);



        Row row4 =sheet.createRow(6);
        row4.createCell(0).setCellValue("Değerlen. Standardı");
        row4.createCell(1).setCellValue(DegerlenstandardiTxtId.getText());
        row4.setHeight( (short) 600);
        row4.getCell(1).setCellStyle(style1);
        row4.getCell(0).setCellStyle(style);
        row4.createCell(2).setCellValue("Muayene Aşaması");
        row4.getCell(2).setCellStyle(style);
        row4.createCell(3).setCellValue(MuayeneasamasicmboId.getValue());
        row4.getCell(3).setCellStyle(style1);
        row4.createCell(4).setCellValue("Teklif No  " );
        row4.getCell(4).setCellStyle(style);
        row4.createCell(5).setCellValue(offernoTxtId.getText());
        row4.getCell(5).setCellStyle(style1);

        sheet.addMergedRegion(new CellRangeAddress(7, 7, 0,5));
        Row row5  =sheet.createRow(7);
        row5.createCell(0).setCellValue("Ekipman Bilgileri/ Equipment Informations");
///////////////////
        Row row6 =sheet.createRow(8);
        row6.createCell(0).setCellValue("Kutup Mesafesi,mm " );
        row6.createCell(1).setCellValue(pdid.getText());
        row6.getCell(1).setCellStyle(style1);
        row6.createCell(2).setCellValue("Muayene Bölgesi ");
        row6.getCell(2).setCellStyle(style);
        row6.setHeight( (short) 600);
        row6.getCell(0).setCellStyle(style);
        row6.createCell(3).setCellValue(Muayenebolgesiid.getText());
        row6.getCell(3).setCellStyle(style1);
        row6.createCell(4).setCellValue("Yüzey Sıcaklığı (ºC) " );
        row6.getCell(4).setCellStyle(style);
        row6.createCell(5).setCellValue(sicak.getText());
        row6.getCell(5).setCellStyle(style1);


        Row row7 =sheet.createRow(9);
        row7.createCell(0).setCellValue("Cihaz " );
        row7.createCell(1).setCellValue(eqid.getText());
        row7.setHeight( (short) 600);
        row7.getCell(1).setCellStyle(style1);
        row7.getCell(0).setCellStyle(style);
        row7.createCell(2).setCellValue("Akım Tipi");
        row7.getCell(2).setCellStyle(style);
        row7.createCell(3).setCellValue(aktiid.getValue());
        row7.getCell(3).setCellStyle(style1);
        row7.createCell(4).setCellValue("Muayene Bölgesindeki Alan Şiddeti, kA/m" );
        row7.getCell(4).setCellStyle(style);
        row7.createCell(5).setCellValue(muayeneboboid.getText());
        row7.getCell(5).setCellStyle(style1);



        Row row8 =sheet.createRow(10);
        row8.createCell(0).setCellValue("MP Taşıyıcı Ortam" );
        row8.createCell(1).setCellValue(cmidd.getText());
        row8.setHeight((short) (600));
        row8.getCell(1).setCellStyle(style1);
        row8.getCell(0).setCellStyle(style);
        row8.createCell(2).setCellValue("Luxmetre/Işık Şiddeti");
        row8.getCell(2).setCellStyle(style);
        row8.createCell(3).setCellValue(luxid.getText());
        row8.getCell(3).setCellStyle(style1);
        row8.createCell(4).setCellValue("Yüzey " );
        row8.getCell(4).setCellStyle(style);
        row8.createCell(5).setCellValue(yuzeyid.getText());
        row8.getCell(5).setCellStyle(style1);



        Row row9 =sheet.createRow(11);
        row9.createCell(0).setCellValue("Mıknatıslama Tekniği ");
        row9.createCell(1).setCellValue(mtid.getText());
        row9.setHeight( (short) 600);
        row9.getCell(1).setCellStyle(style1);
        row9.getCell(0).setCellStyle(style);
        row9.createCell(2).setCellValue("Muayene Ortamı");
        row9.getCell(2).setCellStyle(style);
        row9.createCell(3).setCellValue(Muortami.getText());
        row9.getCell(3).setCellStyle(style1);
      //  row9.createCell(4).setCellValue("Işık Cihazı Tanımı " );
       // row9.getCell(4).setCellStyle(style);
        row9.createCell(5).setCellValue(joboderTxtId.getText());
        row9.getCell(5).setCellStyle(style1);



        Row row11 =sheet.createRow(12);
        row11.createCell(0).setCellValue("UV Işık Şiddeti");
        row11.createCell(1).setCellValue(liid.getText());
        row11.setHeight( (short) 600);
        row11.getCell(1).setCellStyle(style1);
        row11.getCell(0).setCellStyle(style);
        row11.createCell(2).setCellValue("Mıknatıs Giderimi");
        row11.getCell(2).setCellStyle(style);
        row11.createCell(3).setCellValue(Mgi.getText());
        row11.getCell(3).setCellStyle(style1);
        row11.createCell(4).setCellValue("Işık Cihazı Tanımı  " );
        row11.getCell(4).setCellStyle(style);
        row11.createCell(5).setCellValue(isikid.getText());
        row11.getCell(5).setCellStyle(style1);

        Row row22 =sheet.createRow(13);
        row22.createCell(0).setCellValue("Işık mesafesi");
        row22.createCell(1).setCellValue(difid.getText());
        row22.setHeight( (short) 600);
        row22.getCell(1).setCellStyle(style1);
        row22.getCell(0).setCellStyle(style);
        row22.createCell(2).setCellValue("Isıl İşlem");
        row22.getCell(2).setCellStyle(style);
        row22.createCell(3).setCellValue(isiis.getText());
        row22.getCell(3).setCellStyle(style1);
        row22.createCell(4).setCellValue("Kaldırma Testi Tarih / No  " );
        row22.getCell(4).setCellStyle(style);
        row22.createCell(5).setCellValue(ktt.getText());
        row22.getCell(5).setCellStyle(style1);


        FileOutputStream fileOut=new FileOutputStream("report.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
    }

    @FXML
    void topdfA(ActionEvent event) throws IOException {
        String fileName="ee.pdf";
        PDDocument doc=new PDDocument();
        doc.addPage(new PDPage());
        doc.save(fileName);
doc.close();
    }


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
       ObservableList<String> data = mySQLconn.doSelectco();
        musteriid.setItems(data);

        musteriid.setOnAction(event ->
        {
            mySQLconn o2 = new mySQLconn() ;
            o2.doSer(musteriid.getValue()) ;
           TestyeriTxtId.setText(o2.doSer(musteriid.getValue()));
        });



        MuayenestandardiTxtId.setText("TS EN ISO 17638");
        DegerlenstandardiTxtId.setText("TS EN ISO 23278 Class B");
        MuayeneproseduruTxtId.setText("P-101-004");
        pageTxtId.setText("1");
        Muayenebolgesiid.setText("KAYNAK+HAZ");
        luxid.setText("1200 Lux");
        muayeneboboid.setText("3.2 kA/m");
        yuzeyid.setText("TAŞLANMIŞ / GRINDING");


        isikid.setText( "***");
        MuayenekapsamiTxtId.setText("100%");
        MuayenekapsamiTxtId.setOnAction(event -> isInt(MuayenekapsamiTxtId, MuayenekapsamiTxtId.getText()));

        ObservableList<String> list = FXCollections.observableArrayList("untreated", "treated");
        MuayeneasamasicmboId.setItems(list);
        ObservableList<String> listt = FXCollections.observableArrayList("build", "dont");
        ProjeadiTxtId.setItems(listt);
        ObservableList<String> listtt = FXCollections.observableArrayList("ac", "dc");
        aktiid.setItems(listtt);


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


    public void myfun1(ObservableList<equipment> dat) {
        pdid.setText(dat.get(0).getPole_Distance());
        eqid.setText(dat.get(0).getEq_name());
        liid.setText(dat.get(0).getLight_Intensity());
        difid.setText(dat.get(0).getDistanceofLight());
        cmidd.setText(dat.get(0).getCarrier_Medium());
        mtid.setText(dat.get(0).getMag_Tech());
    }

    public void myfun2(ObservableList<Employee> dataa, ObservableList<Employee> dataaa) {

            opadi.setText(dataaa.get(0).getFirstName() +" " + dataaa.get(0).getLastName());

            evadi.setText(dataa.get(0).getFirstName() + " " + dataa.get(0).getLastName());


    }
}

