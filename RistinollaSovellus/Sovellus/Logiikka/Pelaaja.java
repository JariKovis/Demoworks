
package Logiikka;


public class Pelaaja {
    private String nimi;
    private int voitot;
    private int haviot;

    public Pelaaja() {
        this.nimi = "";
        this.voitot = 0;
        this.haviot = 0;
    }
    
    public Pelaaja(String nimi) {
        this.nimi = nimi;
        this.voitot = 0;
        this.haviot = 0;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }    
    
    public int getHaviot() {
        return haviot;
    }

    public int getVoitot() {
        return voitot;
    }

    public void lisaaVoitto() {
        this.voitot++;
    }

    public void lisaaHavio() {
        this.haviot++;
    }
    
    
}
