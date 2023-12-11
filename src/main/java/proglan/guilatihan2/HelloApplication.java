package proglan.guilatihan2;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloApplication extends Application{
    private TableView table = new TableView();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage){
        Scene scene = new Scene(new Group());

        stage.setTitle("Test TableView");
        stage.setWidth(450);
        stage.setHeight(550);

        final Label label = new Label("Daftar Mahasiswa");
        label.setFont(new Font("Arial", 30));

        table.setEditable(true);

        TableColumn nameCol = new TableColumn("Nama");
        TableColumn nimCol = new TableColumn("NIM");
        TableColumn emailCol = new TableColumn("Email");

        table.getColumns().addAll(nameCol, nimCol, emailCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(8);
        vbox.setPadding(new Insets(20, 10, 10, 10));

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        final ObservableList<Mahasiswa> data = FXCollections.observableArrayList(
                new Mahasiswa("Megumi", "2022", "Megumi.mail"),
                new Mahasiswa("Fushiguro", "2022", "Fushiguro.mail")
        );

        nameCol.setCellValueFactory(
                new PropertyValueFactory<Mahasiswa, String>("name")
        );

        nimCol.setCellValueFactory(
                new PropertyValueFactory<Mahasiswa, String>("nim")
        );

        emailCol.setCellValueFactory(
                new PropertyValueFactory<Mahasiswa, String>("email")
        );

        table.setItems(data);

        final TextField addName = new TextField();
        addName.setMaxWidth(nameCol.getPrefWidth());
        addName.setPromptText("Nama Mahasiswa");

        final TextField addNim = new TextField();
        addNim.setMaxWidth(nimCol.getPrefWidth());
        addNim.setPromptText("NIM");

        final TextField addEmail = new TextField();
        addEmail.setMaxWidth(nameCol.getPrefWidth());
        addEmail.setPromptText("Email");

        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.add(new Mahasiswa(
                        addName.getText(),
                        addNim.getText(),
                        addEmail.getText()
                ));
                addName.clear();
                addNim.clear();
                addEmail.clear();
            }
        });

        final HBox hboxInput = new HBox();
        hboxInput.getChildren().addAll(addName, addNim, addEmail, addButton);
        hboxInput.setSpacing(10);

        vbox.getChildren().addAll(label, table, hboxInput);

        stage.setScene(scene);
        stage.show();
    }
}