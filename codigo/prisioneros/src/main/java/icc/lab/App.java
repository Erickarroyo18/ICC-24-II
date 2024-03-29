package icc.lab;

import icc.lab.modelos.Carcel;

/**
 * Esta clase es la que se encarga de correr el programa
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Carcel carcel = new Carcel();
        carcel.resolverProblema();
    }
}
