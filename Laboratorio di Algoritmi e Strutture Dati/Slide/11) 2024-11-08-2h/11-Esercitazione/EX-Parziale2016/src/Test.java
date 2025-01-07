import java.util.*;

public class Test {
    
public static void main (String[]args){

    Soccorso lista = new Soccorso();
    lista.ingresso("bbb", 0);
    lista.ingresso("ddd", 1);
    lista.ingresso("aaa", 1);
    lista.ingresso("ccc", 2);
    lista.ingresso("sss", 0);
    lista.ingresso("qqq", 2);
    // stampa la lista	
    System.out.println("Lista di pazienti:\n" + lista);


    lista.cambio("bbb", 2);
    System.out.println("\nModifica la priorita del paziente bbb in 2:");
    System.out.println(lista);  // Notare che "bbb" preserva l'ordine di arrivo

    System.out.println("\nDimissione: " + lista.dimissione()); 

}

}

