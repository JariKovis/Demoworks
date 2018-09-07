package Sovellus;

import Logiikka.Pelilogiikka;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Infonakyma {

    private Pelilogiikka logiikka;
    private RistinollaSovellus sovellus;
    private Pelinakyma pelinakyma;

    public Infonakyma(RistinollaSovellus sovellus, Pelilogiikka logiikka) {
        this.logiikka = logiikka;
        this.sovellus = sovellus;      
    }

    public Parent getNakyma() {
        Label pelaaja = new Label("Pelaaja: " + logiikka.getNimi());
        pelaaja.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        pelaaja.setTextFill(Color.BLUEVIOLET);
        pelaaja.setPadding(new Insets(20));
        pelaaja.setAlignment(Pos.CENTER);
        
        Label voitot = new Label("voitot");
        voitot.setFont(Font.font("arial", 20));
        Label haviot = new Label("Häviöt");
        haviot.setFont(Font.font("arial", 20));
        Label voitotArvo = new Label(logiikka.pelaajanVoitot());
        voitotArvo.setFont(Font.font("arial", 20));
        Label haviotArvo = new Label(logiikka.pelaajanHaviot());
        haviotArvo.setFont(Font.font("arial", 20));
        
        Button pelaaNappi = new Button("Pelaa");
        pelaaNappi.setFont(Font.font("arial", 20));
        pelaaNappi.setPadding(new Insets(20));
        
        
        pelaaNappi.setOnAction((event) -> {
                        sovellus.asetaPelinakyma();
        });        

        GridPane griddi = new GridPane();
        griddi.add(voitot, 0, 0);
        griddi.add(haviot, 0, 1);
        griddi.add(voitotArvo, 1, 0);
        griddi.add(haviotArvo, 1, 1);
        griddi.setHgap(10);
        griddi.setVgap(10);
        griddi.setAlignment(Pos.CENTER);
        //griddi.setPadding(new Insets(20));        
        
        BorderPane infoasettelu = new BorderPane();
        infoasettelu.setTop(pelaaja);
        BorderPane.setAlignment(pelaaja, Pos.CENTER);
        infoasettelu.setCenter(griddi);
        BorderPane.setAlignment(griddi, Pos.CENTER);
        infoasettelu.setBottom(pelaaNappi);
        BorderPane.setAlignment(pelaaNappi, Pos.CENTER);
        BorderPane.setMargin(pelaaNappi, new Insets(0, 0, 20, 0));

        return infoasettelu;
    }    
    
}
