
public class Test {
    
public static void main (String[]args){

    Moneta m1 = new Moneta(1, "Un EURO");
    System.out.println(m1);
    
    Moneta m1bis= new Moneta(1, "Un EURO");
    Moneta m2 = new Moneta(2, "Due EURO");
    Moneta m5 = new Moneta(5, "Cinque EURO");
    Moneta m10 = new Moneta(10, "Dieci EURO");
    Moneta m01 = new Moneta(0.1, "Dieci Centesimi di EURO");

    Portamonete p = new Portamonete();
    p.addMoneta(m2);
    p.addMoneta(m1);
    p.addMoneta(m5);
    p.addMoneta(m5);
    p.addMoneta(m1);
    p.addMoneta(m2);
    p.addMoneta(m2);
    p.addMoneta(m1);
    p.addMoneta(m10);
    p.addMoneta(m01);

    System.out.println("\nPortamonete: " + p);

    System.out.println("\nCi sono " +  p.conteggio(m5) + " monete da " + m5.getValore() + " Euro" );
    System.out.print("Dopo l'eliminazione di una moneta da 5 Euro ");
    p.remove(m5);
    System.out.println("ci sono " +  p.conteggio(m5) + " monete da " + m5.getValore() + " Euro\n" );

    System.out.println("\nIn totale nel portamonete ci sono " +  p.getTotale() + " Euro\n" );

    
} //end-main

} //end-Test


