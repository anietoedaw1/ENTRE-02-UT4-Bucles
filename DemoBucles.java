import java.util.Random;
/**
 *    @author - Antonio Nieto
 */
public class DemoBucles
{
    private final char ASTERISCO = '*';
    private final char ESPACIO = ' ';
    private Random generador;

    /**
     * Constructor  
     */
    public DemoBucles()
    {
        generador = new Random();
    }

    /**
     * Calcular la mayor potencia de 2 que es menor o igual a numero
     * Asumimos numero > 0
     * 
     * Si numero = 7 devuelve 4             numero = 8 devuelve 8
     *    numero = 19 devuelve 16           numero = 32 devuelve 32
     *    numero = 74 devuelve 64           numero = 1 devuelve 1
     *    numero = 190 devuelve 128
     *    
     *  Usa bucles while
     */
    public int mayorPotencia2(int numero) {
        // int mayorPotencia = 1;
        // while (mayorPotencia < numero) {
        // mayorPotencia *= 2;
        // }
        // return mayorPotencia/2;
        // int n = 1;
        // int resultado = 0;
        // while(i <= numero){
        // i *= 2;
        // resultado++;;
        // }
        // return resultado;

        int exponente = 0;

        while((int)Math.pow(2,exponente)< numero){

            exponente++;}

        if ((int)Math.pow(2,exponente)==numero){

            return (int)Math.pow(2,exponente);}
        else{
            exponente--;
            return (int)Math.pow(2,exponente);}
    }

    /**
     * Escribir numero como suma de potencias de 2 
     * tal como indica el enunciado (Se asume numero > 0)
     * 
     * Todos los valores se muestran en pantalla fomateados a 6 posiciones 
     * y ajustados a la derecha
     * 
     * Hay que usar el método anterior - 
     * Utiliza bucles while
     * 
     *  77 =    64     8     4     1
     * 215 =   128    64    16     4     2     1
     *  18 =    16     2
     *  64 =    64
     */
    public void escribirSumaPotencias(int numero) {
        int potencia = mayorPotencia2(numero);
        int sumatorio = 0;
        while(sumatorio != numero){
            int resto = numero - potencia;
            sumatorio+=potencia;
            System.out.printf("%6d = %6d",numero,potencia);
            while(resto != 0) {
                sumatorio+=mayorPotencia2(resto);
                System.out.printf("%6d",mayorPotencia2(resto));
                resto-=mayorPotencia2(resto);

            }
        }

    }

    /**
     * Generar aleatorios entre 0 y 255
     * y escribir cada aleatorio como suma de potencias de 2
     * Parar al salir el 255 o despues de generar n aleatorios
     * (ver enunciado)
     * 
     * Hay que usar el método anterior
     * 
     * Utiliza bucles while
     * 
     */
    public void generarAleatorios(int n) {
        System.out.println();
        int aleatorio = generador.nextInt(256);
        int i = 1;
       
        while(aleatorio != 255 && i <= n){
            aleatorio = generador.nextInt(256);
            escribirSumaPotencias(aleatorio);   
            System.out.println();
            i++;
        }
    }

    /**
     *  Escribe en pantalla caracter n veces en la misma línes
     *  
     *  Usa bucles for
     */
    public void escribirCaracter(int n, char caracter)
    {
        for(int veces = 1;veces <= n;veces++){
            System.out.printf("%c",caracter); 

        }
    }

    /**
     *  Genera la figura tal como muestra el enunciado 
     *  con ayuda del método anterior
     *  
     *   Usa bucles for
     */
    public  void mostrarEscalera(int escalones, int alto, int ancho) {
        System.out.println();
        // for(int contador = 0; contador < escalones; contador++){
        // if(contador > 0){
        // for (int i = 0; i < alto; i++){
        // escribirCaracter(ancho * i,ESPACIO);
        // }
        // }
        // for (int x = 0; x < alto;x++){
        // escribirCaracter(ancho,ASTERISCO);
        // } 
        // }
        for(int cantidad = 0;cantidad < escalones;cantidad++){

            for(int veces = 1;veces <= alto;veces++){
                //int veces = 0;
                //while(veces < numero){
                escribirCaracter(ancho * cantidad, ESPACIO);escribirCaracter(ancho, ASTERISCO);
                System.out.println();
                //veces++;
            }
        }
    }
}