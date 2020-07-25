package sample.model;

import javafx.beans.property.SimpleStringProperty;

public class equipment {
    private  SimpleStringProperty id;

    private SimpleStringProperty Pole_Distance;
    private SimpleStringProperty Eq_name;
    private SimpleStringProperty Carrier_Medium;
    private SimpleStringProperty Mag_Tech;
    private SimpleStringProperty Light_Intensity;
    private SimpleStringProperty DistanceofLight;

    public equipment(String p, String e, String c, String m, String l, String d,String i) {
        this.id = new SimpleStringProperty(i);

        this.Pole_Distance = new SimpleStringProperty(p);
        this.Eq_name =new SimpleStringProperty(e);
        this.Carrier_Medium =new SimpleStringProperty(c);
        this.Mag_Tech =new SimpleStringProperty(m);
        this.Light_Intensity =new SimpleStringProperty(l);
        this.DistanceofLight =new SimpleStringProperty(d);
    }
    public String getPole_Distance() {
        return Pole_Distance.get();
    }
    public void setPole_Distance(String i) {
        Pole_Distance.set(i);
    }
    public String getEq_name() {
        return Eq_name.get();
    }
    public void setEq_name(String co) {
        Eq_name.set(co);
    }
    public String getCarrier_Medium() {
        return Carrier_Medium.get();
    }
    public void setCarrier_Medium(String po) {
        Carrier_Medium.set(po);
    }
    public String getMag_Tech() {
        return Mag_Tech.get();
    }
    public void setMag_Tech(String io) {
        Mag_Tech.set(io);
    }
    public String getLight_Intensity() {
        return Light_Intensity.get();
    }
    public void setLight_Intensity(String job) {
        Light_Intensity.set(job);
    }
    public String getDistanceofLight() {
        return DistanceofLight.get();
    }
    public void setDistanceofLight(String oo) {
        DistanceofLight.set(oo);
    }
    public String getId() {
        return id.get();
    }

    public void setId(String gg) {
        id.set(gg);
    }
}
