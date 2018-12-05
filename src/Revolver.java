import org.omg.CORBA.PUBLIC_MEMBER;

public class Revolver {

    private int posicionActual;
    private int posicionBala;

    public Revolver() {
        this.posicionActual = (int) Math.floor(Math.random()*6+1);
        this.posicionBala = (int) Math.floor(Math.random()*6+1);
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }

    public int getPosicionBala() {
        return posicionBala;
    }

    public void setPosicionBala(int posicionBala) {
        this.posicionBala = posicionBala;
    }

    public void reiniciarRevolver(){
        posicionActual = (int) Math.floor(Math.random()*6+1);
        posicionBala = (int) Math.floor(Math.random()*6+1);
        System.out.println("-->Revolver reseteado<--");
    }

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

    public void siguienteBala() {
        setPosicionActual(getPosicionActual()+1);
        if (getPosicionActual()==7) {
            setPosicionActual(1);
        }
    }
}
