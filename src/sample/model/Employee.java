package sample.model;

import javafx.beans.property.SimpleStringProperty;

public  class Employee {

    private final SimpleStringProperty id;
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty userName;
    private final SimpleStringProperty jobTitle;
    private final SimpleStringProperty password;

    public Employee(String i, String fName, String lName, String us, String jt,String p) {
        this.id = new SimpleStringProperty(i);
        this.firstName = new SimpleStringProperty(fName);
        this.lastName = new SimpleStringProperty(lName);
        this.userName = new SimpleStringProperty(us);
        this.jobTitle = new SimpleStringProperty(jt);
        this.password = new SimpleStringProperty(p);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String fName) {
        firstName.set(fName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String fName) {
        lastName.set(fName);
    }

    public String getId() {
        return id.get();
    }

    public void setId(String gg) {
        id.set(gg);
    }

    public String getUserName() {
        return userName.get();
    }

    public void setUserName(String unn) {
        userName.set(unn);
    }

    public String getJobTitle() {
        return jobTitle.get();
    }

    public void setJobTitle(String jo) {
        jobTitle.set(jo);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String jo) {
        password.set(jo);
    }
}
