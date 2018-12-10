import java.io.Serializable;

/**
 * @author Killian Herrera Garcia
 */
public class Jugador implements Serializable {

    private int id;
    private String nombre;
    private boolean vivo = true;

    public Jugador() {

    }

    /**
     * Devuelve la id del jugador
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Modifica la id del jugador
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del jugador
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre del jugador
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el estado del jugador (true si esta vivo, false si no lo esta)
     * @return
     */
    public boolean isVivo() {
        return vivo;
    }

    /**
     *
     * @param vivo
     */
    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    /**
     * El jugador se dispara, el atributo del jugador es true en caso de que al disparar se salve y false si ha muerto
     * @param r
     */
    public void disparar(Revolver r) {
        System.out.print(nombre);
        vivo=r.disparar();
    }
}
