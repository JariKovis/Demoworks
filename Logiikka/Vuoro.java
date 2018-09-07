
package Logiikka;


public class Vuoro {
    private String vuoro;

    public Vuoro() {
        this.vuoro = "X";
    }
    
    public void seuraavaVuoro() {
        if (this.vuoro.equals("X")) {
            this.setVuoro("O");
        } else {
            this.setVuoro("X");
        }
    }
    
    public void setVuoro(String merkki) {
        this.vuoro = merkki;
    }

    public String getVuoro() {
        return vuoro;
    }

    @Override
    public String toString() {
        return this.vuoro;
    }
    
    
}
