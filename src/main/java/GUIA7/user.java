package GUIA7;

public class user {
    String id;
    String name;
    String last_name;
    String mail;
    String celphone;

    public user(String id,String name, String last_name, String mail, String celphone) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.mail = mail;
        this.celphone = celphone;
    }

    user(String name, String last_name, String mail, String celphone) {
        //To change body of generated methods, choose Tools | Templates.
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setCelphone(String celphone) {
        this.celphone = celphone;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getMail() {
        return mail;
    }

    public String getCelphone() {
        return celphone;
    }
}
