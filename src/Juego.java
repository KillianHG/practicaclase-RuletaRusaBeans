import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Killian Herrera Garcia
 */
public class Juego implements Serializable {

    private Revolver revolver;
    private ArrayList<Jugador> jugadores;
    private boolean todosDisparan;
    private boolean todosMueren;

    public Juego() {
    }

    /**
     * Devuelve el estado del revolver
     * @return
     */
    public Revolver getRevolver() {
        return revolver;
    }
    /**
     * Modifica el revolver
     * @param revolver
     */
    public void setRevolver(Revolver revolver) {
        this.revolver = revolver;
    }

    /**
     * Devuelve la lista de jugadores
     * @return
     */
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
    /**
     * Modifica la lista de jugadores
     * @param jugadores
     */
    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    /**
     * Comprueba si el juego se ha terminado segun el tipo de juego que se ha decidido
     * @return true si la partida ha acabado, false si no lo ha hecho aun.
     */
    public boolean finJuego(){
        if (!todosMueren) {
            for (int i = 0; i < jugadores.size(); i++) {
                if (!jugadores.get(i).isVivo()) {
                    System.out.println("Juego terminado");
                    return true;
                }
            }
            return false;
        } else {
            int muertos = 0;
            for (int i = 0; i < jugadores.size(); i++) {
                if (!jugadores.get(i).isVivo()) {
                    muertos++;
                }
            }
            if (muertos >= jugadores.size()-1) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * Se juega una ronda
     */
    public void ronda() {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("                           La ronda va a comenzar");
        System.out.println("-----------------------------------------------------------------------------------");
        if (todosDisparan) {
            for (int i = 0; i < jugadores.size(); i++) {
                if (jugadores.get(i).isVivo()) {
                    jugadores.get(i).disparar(revolver);
                } else {
                    continue;
                }
            }
        } else {
            for (int i = 0; i < jugadores.size(); i++) {
                if (jugadores.get(i).isVivo()) {
                    jugadores.get(i).disparar(revolver);
                } else {
                    continue;
                }
                if (!jugadores.get(i).isVivo()) {
                    System.out.println("Ronda terminada defunción de --" + jugadores.get(i).getNombre() + "--");
                    break;
                }
            }
        }

    }


    /**
     * Crea un nuevo juego de ruleta rusa, te deja escoger el numero de participantes hasta un maximo de 6,
     * luego les asignas un nombre a cada uno de ellos y te permite escoger el modo de juego que quieras de ruleta rusa asi como el formato de ronda.
     * Modos de juego: el juego acaba cuando al menos un jugador ha muerto o el juego acaba cuando queda uno o ningun jugador vivo
     * Tipo de ronda: todos los jugadores se disparan independientemente de lo ocurrido en la ronda o en caso de que algun jugador muera se acaba la ronda
     */
    public void inicioJuego() {
        int nJugadores = 99;
        Scanner sc = new Scanner(System.in);
        this.jugadores = new ArrayList<>();
        while (nJugadores < 1 || nJugadores > 7) {
            System.out.print("Introduce el numero de jugadores (minimo 1 maximo 6): ");
            nJugadores = sc.nextInt();

            if (nJugadores <1) {
                System.out.println("Se necesita almenos un jugador");
            } else if (nJugadores > 6) {
                System.out.println("La partida no puede tener mas de 6 jugadores");
            }
        }
        for (int i = 1; i <= nJugadores; i++) {
            System.out.print("Introduce el nombre del jugador " + i + ": ");
            String nombre = sc.next();
            Jugador j = new Jugador();
            j.setId(i);
            j.setNombre(nombre);
            jugadores.add(j);
        }
        int tipoRonda = 3;
        while (tipoRonda < 1 || tipoRonda > 2) {
            System.out.println("Como quieres que sean las rondas: ");
            System.out.println("1 - Todos los jugadores se disparan sin importar si alguien ha muerto antes (en caso de muerte se vuelven a generar las posiciones del revolver)");
            System.out.println("2 - Cuando algun jugador muere se para la ronda");
            tipoRonda = sc.nextInt();
            if (tipoRonda < 1 || tipoRonda > 2) {
                System.out.println("Por favor, introduce un valor valido");
            }
        }
        if (tipoRonda == 1) {
            todosDisparan = true;
        } else {
            todosDisparan = false;
        }

        tipoRonda = 3; //reutilizo la variable tipoRonda
        while (tipoRonda < 1 || tipoRonda > 2) {
            System.out.println("Cuando quieres que acabe la partida: ");
            System.out.println("1 - La partida acaba en el momento que al menos un jugador en la ronda muere");
            System.out.println("2 - La partida acaba cuando solo queda una persona viva (o ninguno en caso de que todos mueran en la misma ronda)");
            tipoRonda = sc.nextInt();
            if (tipoRonda < 1 || tipoRonda > 2) {
                System.out.println("Por favor, introduce un valor valido");
            }
        }
        if (tipoRonda == 1) {
            todosMueren = false;
        } else {
            todosMueren = true;
        }
        this.revolver = new Revolver();
        revolver.reiniciarRevolver();
        System.out.println("La partida esta lista para comenzar");
    }


}
