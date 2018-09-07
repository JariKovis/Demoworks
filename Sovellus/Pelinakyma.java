package Sovellus;

import Logiikka.Pelilogiikka;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Pelinakyma {

    private RistinollaSovellus sovellus;
    private Pelilogiikka logiikka;

    public Pelinakyma(RistinollaSovellus sovellus, Pelilogiikka logiikka) {
        this.sovellus = sovellus;
        this.logiikka = logiikka;
    }

    public Parent getNakyma() {
        BorderPane peliasettelu = new BorderPane();
        GridPane nappiasettelu = new GridPane();
        nappiasettelu.setAlignment(Pos.CENTER);
        
        Label kierros = new Label("Kierros " + logiikka.getKierros() + ", vuoro " + logiikka.getVuoro());
        kierros.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        nappiasettelu.setVgap(10);
        nappiasettelu.setHgap(10);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button nappi = new Button(" ");
                nappiasettelu.add(nappi, i, j);
                logiikka.lisaaNappi(nappi, i, j);
                nappi.setFont(Font.font("Monospaced", 40));

                nappi.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        if (nappi.getText().equals(" ")) {
                            logiikka.pelaaKierros(nappi);
                            kierros.setText("Kierros " + logiikka.getKierros() + ", vuoro " + logiikka.getVuoro());
                        }
                    }
                });
            }
        }
        
        peliasettelu.setTop(kierros);
        BorderPane.setAlignment(kierros, Pos.CENTER);
        peliasettelu.setCenter(nappiasettelu);
        // BorderPane.setAlignment(nappiasettelu, Pos.CENTER);

        return peliasettelu;
    }

}
