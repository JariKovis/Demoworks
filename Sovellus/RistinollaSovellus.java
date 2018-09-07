package Sovellus;

import Logiikka.Pelilogiikka;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Petri Palmu
 */
public class RistinollaSovellus extends Application {

    private Pelilogiikka pelilogiikka;
    private Stage window;
    private Aloitusnakyma aloitusnakyma;
    private Infonakyma infonakyma;
    private Pelinakyma pelinakyma;

    @Override
    public void init() throws Exception {
        this.pelilogiikka = new Pelilogiikka(this);
        this.pelinakyma = new Pelinakyma(this, pelilogiikka);
        this.infonakyma = new Infonakyma(this, pelilogiikka);
        this.aloitusnakyma = new Aloitusnakyma(this, pelilogiikka);       
    }

    @Override
    public void start(Stage window) throws Exception {
       this.window = window;
        // luodaan pohja asetteluille
        window.setMinWidth(400);
        window.setMinHeight(300);

        Scene scene = new Scene(aloitusnakyma.getNakyma(), 400, 300);
        window.setScene(scene);
        window.show();

    }

    public void changeScene(Parent newWindow) {
        this.window.getScene().setRoot(newWindow);
    }
    
    public void asetaInfonakyma() {
        this.window.getScene().setRoot(infonakyma.getNakyma());
    }
    
    public void asetaPelinakyma() {
        this.window.getScene().setRoot(pelinakyma.getNakyma());
    }

    public static void main(String[] args) {
        launch(RistinollaSovellus.class);
    }

    
}
