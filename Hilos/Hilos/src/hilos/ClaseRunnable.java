package hilos;

/**
 *
 * Clase que implementa la interfaz Runnable
 */
public class ClaseRunnable implements Runnable {

    private final String nombreHilo;

    public ClaseRunnable(String nombre) {
        this.nombreHilo = nombre;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            System.out.println(nombreHilo + " : " + i);
            try {
                Thread.sleep(100);//tiempo que se usa para darla oportunidad a otros subprocesos a ejecutarse
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }

}
