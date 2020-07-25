package sample.model;

import javafx.beans.property.SimpleStringProperty;

public class firma {
    private  SimpleStringProperty Costumer;
    private  SimpleStringProperty Project_name;
    private  SimpleStringProperty il_ilce;
    private  SimpleStringProperty job_order_no;
    private  SimpleStringProperty offer_no;

    public firma(String c, String p, String il, String j, String o) {
        this.Costumer =new SimpleStringProperty(c);
        this.Project_name =new SimpleStringProperty(p);
        this.il_ilce =new SimpleStringProperty(il);
        this.job_order_no =new SimpleStringProperty(j);
        this.offer_no =new SimpleStringProperty(o);
    }

    public String getCostumer() {
        return Costumer.get();
    }
    public void setCostumer(String co) {
        Costumer.set(co);
    }
    public String getProject_name() {
        return Project_name.get();
    }
    public void setProject_name(String po) {
        Project_name.set(po);
    }
    public String getIl_ilce() {
        return il_ilce.get();
    }
    public void setIl_ilce(String io) {
        il_ilce.set(io);
    }
    public String getJob_order_no() {
        return job_order_no.get();
    }
    public void setJob_order_no(String job) {
        job_order_no.set(job);
    }
    public String getOffer_no() {
        return offer_no.get();
    }
    public void setOffer_no(String oo) {
        offer_no.set(oo);
    }

}
