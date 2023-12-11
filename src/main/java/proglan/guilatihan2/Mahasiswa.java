package proglan.guilatihan2;
import javafx.beans.property.SimpleStringProperty;

public class Mahasiswa {
    private final SimpleStringProperty name;
    private final SimpleStringProperty nim;
    private final SimpleStringProperty email;

    public Mahasiswa (String name, String nim, String email){
        this.name = new SimpleStringProperty(name);
        this.nim = new SimpleStringProperty(nim);
        this.email = new SimpleStringProperty(email);
    }

    public String getName(){
        return name.get();
    }

    public void setName (String fName){
        name.set(fName);
    }

    public String getNim(){
        return nim.get();
    }

    public void setNim (String fName){
        nim.set(fName);
    }

    public String getEmail(){
        return email.get();
    }

    public void setEmail (String fName){
        email.set(fName);
    }
}