package Sovellus;

import Logiikka.Pelilogiikka;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class Aloitusnakyma {

    private final RistinollaSovellus sovellus;   
    private final Pelilogiikka logiikka;

    public Aloitusnakyma(RistinollaSovellus sovellus, Pelilogiikka logiikka) {
        this.sovellus = sovellus;        
        this.logiikka = logiikka;
    }

    public Parent getNakyma() {

        VBox vBoksi = new VBox();

        Label tervetuloa = new Label("Tervetuloa!");
        tervetuloa.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        tervetuloa.setTextFill(Color.BLUEVIOLET);

        Button aloitusnappi = new Button("Aloita");
        aloitusnappi.setFont(Font.font("arial", 20));

        Label nimi = new Label("Mikä on nimesi? ");
        nimi.setFont(Font.font("Arial", 20));

        TextField nimikentta = new TextField();
        nimikentta.setMaxWidth(100);

        vBoksi.getChildren().addAll(nimi, nimikentta);
        vBoksi.setAlignment(Pos.CENTER);
        vBoksi.setPadding(new Insets(10));
        vBoksi.setSpacing(10);

        BorderPane aloitusasettelu = new BorderPane();
        aloitusasettelu.setCenter(vBoksi);
        
        aloitusasettelu.setTop(tervetuloa);
        BorderPane.setAlignment(tervetuloa, Pos.CENTER);
        
        aloitusasettelu.setBottom(aloitusnappi);
        BorderPane.setAlignment(aloitusnappi, Pos.CENTER);
        BorderPane.setMargin(aloitusnappi, new Insets(0, 0, 20, 0));

        aloitusnappi.setOnAction((ActionEvent event) -> {
            
            if (!nimikentta.getText().isEmpty()) {              
            logiikka.asetaPelaajanNimi(nimikentta.getText());
            sovellus.asetaInfonakyma();
            }
        });

        return aloitusasettelu;
    }

}
