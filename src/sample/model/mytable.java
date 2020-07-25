package sample.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public  class mytable {

    private final SimpleStringProperty serial_no;
    private TextField weld;
    private TextField test_length;
    private TextField welding_process;
    private TextField thickness;
    private TextField diameter;
    private TextField defect_type;
    private TextField defect_loc;
    private ComboBox result;

    public mytable(String serial_no, String weld, String test_length, String welding_process, String thickness, String diameter, String defect_type, String defect_loc, ObservableList dat1) {
        this.serial_no = new SimpleStringProperty(serial_no);
        this.weld = new TextField(weld);
        this.test_length = new TextField(test_length);
        this.welding_process = new TextField(welding_process);
        this.thickness = new TextField(thickness);
        this.diameter = new TextField(diameter);
        this.defect_type = new TextField(defect_type);
        this.defect_loc = new TextField(defect_loc);
        this.result = new ComboBox(dat1);
    }

    public String getSerial_no() {
        return serial_no.get();
    }
    public void setserial_no(String serial_no) {
        this.serial_no.set(serial_no);
    }

    public TextField getWeld() {
        return weld;
    }
    public void setweld(TextField weld) {
        this.weld=weld;
    }

    public TextField getTest_length() { return test_length; }
    public void settest_length(TextField test_length) { this.test_length=test_length; }

    public TextField getWelding_process() { return welding_process; }
    public void setwelding_process(TextField welding_process) { this.welding_process=welding_process; }

    public TextField getThickness() { return thickness; }
    public void setthickness(TextField thickness) { this.thickness=thickness; }

    public TextField getDiameter() { return diameter; }
    public void setdiameter(TextField diameter) { this.diameter=diameter; }

    public TextField getDefect_type() { return defect_type; }
    public void setdefect_type(TextField defect_type) { this.defect_type=defect_type; }

    public TextField getDefect_loc() { return defect_loc; }
    public void setdefect_loc(TextField defect_loc) { this.defect_loc=defect_loc; }

    public ComboBox getResult() { return result; }
    public void setresult(ComboBox result) { this.result=result; }
}