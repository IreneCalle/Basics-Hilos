package hilos;

public class Hilos extends Thread {

    /*
    Creamos el constructor y le pasamos el nombre
    del subproceso al constructor de la clase thread
     */
    public Hilos(String nombre) {
        super(nombre);
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            System.out.println(getName() + " : " + i);
            try {
                /* 
                Método que nos permite ver la ejecucion del subproceso mas 
                lentamente por consola(util para depuracion del codigo)
                 */
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        
        //CODIGO ASOCIADO A LAS CLASES QUE HEREDAN DE THREAD
        Hilos hiloUno = new Hilos("subproceso 1");
        Hilos hiloDos = new Hilos("subproceso 2");
        hiloUno.setPriority(MAX_PRIORITY);

        // 1º. LANZAMIENTO DE LOS HILOS SIN ESPERAR A OTROS HILOS
        hiloUno.start();
        hiloDos.start();

        // 2º. USO DE JOIN PARA ESPERAR A OTROS HILOS
        /*
        El metodo join permite que el hiloUno, si ha terminado, espere al resto de los hilos para
        terminar el programa
         */
        /*try {
            hiloUno.join();
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }

        hiloDos.start();*/

        // COMO SABER SI UN SUBPROCESO HA TERMINADO
        System.out.println("El hilo 1 esta vivo: " + hiloUno.isAlive());
        System.out.println("El hilo 2 esta vivo: " + hiloDos.isAlive());

        //CODIGO ASOCIADO A LA CLASE QUE IMPLEMENTA RUNNABLE
        /*ClaseRunnable claseRunnable = new ClaseRunnable("Hilo 1", 900);
        Thread thread = new Thread(claseRunnable);
        thread.start();

        new Thread(new ClaseRunnable("Hilo 2", 900)).start();
        new Thread(new ClaseRunnable("Hilo 3", 900)).start();*/
    }
}
