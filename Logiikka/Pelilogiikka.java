package Logiikka;

import Sovellus.RistinollaSovellus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.scene.control.Button;

public class Pelilogiikka {

    private String nimi;
    public Vuoro vuoro;
    private Button[][] peliruutu;
    private RistinollaSovellus sovellus;
    private Pelaaja pelaaja;
    private Pelaaja tekoaly;
    private int kierros;
    private ArrayList<int[]> pelattavatKuviot;

    public Pelilogiikka(RistinollaSovellus sovellus) {
        this.vuoro = new Vuoro();
        this.peliruutu = new Button[3][3];
        this.sovellus = sovellus;
        this.pelaaja = new Pelaaja();
        this.tekoaly = new Pelaaja("Pacem");
        this.kierros = 0;

        this.pelattavatKuviot = new ArrayList<>();
        pelattavatKuviot.add(new int[]{0, 1, 2});
        pelattavatKuviot.add(new int[]{3, 4, 5});
        pelattavatKuviot.add(new int[]{6, 7, 8});
        pelattavatKuviot.add(new int[]{0, 3, 6});
        pelattavatKuviot.add(new int[]{1, 4, 7});
        pelattavatKuviot.add(new int[]{2, 5, 8});
        pelattavatKuviot.add(new int[]{0, 4, 8});
        pelattavatKuviot.add(new int[]{2, 4, 6});
    }

    public void asetaPelaajanNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getNimi() {
        return this.nimi;
    }

    public int getKierros() {
        return kierros;
    }
    
    public void seuraavaKierros() {
        this.kierros++;
    }

    public Vuoro getVuoro() {
        return vuoro;
    }    
          
    public void pelaaKierros(Button nappi) {
        vuoro.setVuoro("X");
        nappi.setText(vuoro.getVuoro());

        if (onkoTaysi()) {
            lopeta();
            return;
        }
        if (onkoVoittoa()) {
            voitto();
            return;
        }

        vuoro.seuraavaVuoro();

        tekoalyPelaa();

        if (onkoTaysi()) {
            lopeta();
            return;
        }

        if (onkoVoittoa()) {
            voitto();
            return;
        }
        vuoro.seuraavaVuoro();
        seuraavaKierros();
    }    

    public boolean onkoVoittoa() {
        ArrayList<ArrayList<Button>> pelatut = pelikuviotilanteet();

        for (ArrayList<Button> napit : pelatut) {
            String merkit = "";
            for (Button nappi : napit) {
                merkit += nappi.getText();
            }
            if (merkit.equals("XXX") || merkit.equals("OOO")) {
                return true;
            }
        }
        return false;
    }

    public boolean onkoTaysi() {
        boolean taysi = true;
        for (int y = 0; y < peliruutu.length; y++) {
            for (int x = 0; x < peliruutu[y].length; x++) {
                if (peliruutu[y][x].getText().equals(" ")) {
                    taysi = false;
                    return taysi;
                }
            }
        }
        return taysi;
    }

    public void lisaaNappi(Button nappi, int y, int x) {
        this.peliruutu[y][x] = nappi;
    }

    private void voitto() {
        if (vuoro.getVuoro().equals("X")) {
            pelaaja.lisaaVoitto();
        } else {
            pelaaja.lisaaHavio();

        }
        this.kierros = 0;
        sovellus.asetaInfonakyma();
    }

    private void lopeta() {
        this.kierros = 0;
        sovellus.asetaInfonakyma();
    }

    public String pelaajanVoitot() {
        return "" + this.pelaaja.getVoitot();
    }

    public String pelaajanHaviot() {
        return "" + this.pelaaja.getHaviot();
    }

    private void tekoalyPelaa() {

        ArrayList<ArrayList<Button>> pelikuviot = pelikuviotilanteet();
        for (ArrayList<Button> yksiTilanne : pelikuviot) {
            String merkit = "";
            for (Button nappi : yksiTilanne) {
                merkit += nappi.getText();
            }
            if (merkit.equals("OO ") || merkit.equals(" OO") || merkit.equals("O O")) {
                for (Button tyhjaNappi : yksiTilanne) {
                    if (tyhjaNappi.getText().equals(" ")) {
                        tyhjaNappi.setText("O");
                        return;
                    }
                }
            }
        }
        for (ArrayList<Button> yksiTilanne : pelikuviot) {
            String merkit = "";
            for (Button nappi : yksiTilanne) {
                merkit += nappi.getText();
            }
            if (merkit.equals("XX ") || merkit.equals(" XX") || merkit.equals("X X")) {
                for (Button tyhjaNappi : yksiTilanne) {
                    if (tyhjaNappi.getText().equals(" ")) {
                        tyhjaNappi.setText("O");
                        return;
                    }
                }
            }
        }

        List<Button> pelinRuudut = pelitilanne();
        Collections.shuffle(pelinRuudut);
        for (Button nappi : pelinRuudut) {
            if (nappi.getText().equals(" ")) {
                nappi.setText("O");
                return;
            }
        }
    }

    private List<Button> pelitilanne() {
        List<Button> kuviot = new ArrayList<>();

        for (int y = 0; y < peliruutu.length; y++) {
            for (int x = 0; x < peliruutu[y].length; x++) {
                kuviot.add(peliruutu[y][x]);
            }
        }
        return kuviot;
    }

    private ArrayList<ArrayList<Button>> pelikuviotilanteet() {
        List<Button> pelitilanne = pelitilanne();
        ArrayList<ArrayList<Button>> tahanMennessaPelatutKuviot = new ArrayList<>();

        for (int[] indeksit : this.pelattavatKuviot) {
            ArrayList<Button> lista = new ArrayList<>();
            for (int indeksi : indeksit) {
                lista.add(pelitilanne.get(indeksi));
            }
            tahanMennessaPelatutKuviot.add(lista);
        }
        return tahanMennessaPelatutKuviot;
    }
}
