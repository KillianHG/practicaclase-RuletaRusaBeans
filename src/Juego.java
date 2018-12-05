import java.util.ArrayList;
import java.util.Scanner;

public class Juego {

    private Revolver revolver;
    private ArrayList<Jugador> jugadores;
    private boolean todosDisparan;
    private boolean todosMueren;

    public Juego() {
        this.revolver = new Revolver();
        this.jugadores = new ArrayList<>();
    }

    public Revolver getRevolver() {
        return revolver;
    }

    public void setRevolver(Revolver revolver) {
        this.revolver = revolver;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

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
            if (muertos >= jugadores.size()) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void ronda() {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("           Introduce cualquier tecla para continuar a la siguiente ronda");
        System.out.println("-----------------------------------------------------------------------------------");
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
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

    public void inicioJuego() {
        int nJugadores = 99;
        Scanner sc = new Scanner(System.in);
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
            Jugador j = new Jugador(i,nombre, true);
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
    }


}
