package obiecte;

public class Armura extends Obiect{
    private int rezistenta;

    public Armura(int rezistenta) {
        this.rezistenta = rezistenta;
    }

    public void setRezistenta(int rezistenta) {
        this.rezistenta = rezistenta;
    }

    public int getRezistenta() {
        return rezistenta;
    }
}
