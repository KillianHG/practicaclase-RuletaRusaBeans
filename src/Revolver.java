import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.Serializable;

/**
 * @author Killian Herrera Garcia
 */
public class Revolver implements Serializable {

    private int posicionActual;
    private int posicionBala;

    public Revolver() {
    }

    /**
     * Devuelve la posicion actual del revolver
     * @return
     */
    public int getPosicionActual() {
        return posicionActual;
    }

    /**
     * Modifica la posicion actual del revolver
     * @param posicionActual
     */
    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }

    /**
     * Devuelve la posicion de la bala en el revolver
     * @return
     */
    public int getPosicionBala() {
        return posicionBala;
    }

    /**
     * Modifica la posicion actual de la bala
     * @param posicionBala
     */
    public void setPosicionBala(int posicionBala) {
        this.posicionBala = posicionBala;
    }

    /**
     * Reinicia la posicion actual del revolver y la posicion de la bala a una completamente aleatoria
     */
    public void reiniciarRevolver(){
        posicionActual = (int) Math.floor(Math.random()*6+1);
        posicionBala = (int) Math.floor(Math.random()*6+1);
        System.out.println("-->Revolver recargado<--");
    }

    /**
     * Dispara el revolver, en caso de que ambas posiciones coincidan reiniciara el revolver, en caso de que no la posicion actual avanzara
     * @return false en caso de que haya muerto el jugador y true en caso de que siga vivo (true o false indican si esta vivo o no el jugador)
     */
    public boolean disparar() {
        if (getPosicionActual()==getPosicionBala()) {
            System.out.println(" ha muerto");
            reiniciarRevolver();
            return false;
        } else {
            System.out.println(" se ha salvado");
            siguienteBala();
            return true;
        }
    }

    /**
     * Suma 1 a la posicion actual de la bala en el revolver, en caso de que la posicion actual despues de sumarse sea 7
     * la posicion actual cambia a 1 debido a que el revolver dispone de hasta 6 huecos para las balas
     */
    public void siguienteBala() {
        setPosicionActual(getPosicionActual()+1);
        if (getPosicionActual()==7) {
            setPosicionActual(1);
        }
    }
}
