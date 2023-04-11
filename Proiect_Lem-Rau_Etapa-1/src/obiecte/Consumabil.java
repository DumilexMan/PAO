package obiecte;

public class Consumabil extends Obiect{
//va vindeca jucatorul
    private int puncte;

    public Consumabil(int puncte) {
        this.puncte = puncte;
    }

    public void setPuncte(int puncte) {
        this.puncte = puncte;
    }

    public int getPuncte() {
        return puncte;
    }
}
