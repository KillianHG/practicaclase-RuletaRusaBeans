public class Jugador {

    private int id;
    private String nombre;
    private boolean vivo;

    public Jugador(int id, String nombre, boolean vivo) {
        this.id = id;
        this.nombre = nombre;
        this.vivo = vivo;
    }

    public void disparar (Revolver r) {

    }

    public boolean isVivo() {
        return vivo;
    }
}
