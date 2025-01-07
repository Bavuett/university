/* Termine contenuto in un'espressione algebrica ad una variabile
 * Esempi:  5x^6, 12.5 x^3, -2 x^7, 3 
 * Possono essere rappresentati come coppie (coefficiente, esponente)
 * (5,6), (12.5,3), (-2,7), (3,0)
 */

public class Termine implements Comparable<Termine> {
  // 5x^6 --> (<coeff> x^<exp>) --> (5,6)
   private double coeff;
   private int exp;
     

   public Termine () { this (0,0); }

   public Termine(double coeff) { this (coeff,0); }

   public Termine(int exp) { this (1,exp); }

   public Termine(double coeff, int exp) { 
 	this.coeff = coeff;
	this.exp = exp;
   }	


   public double getCoeff(){ return coeff; }
   public int getExp(){ return exp; }

   public void setCoeff(double coeff){ this.coeff = coeff; }
   public void setExp(int exp){ this.exp = exp; }
   public void setTermine(double coeff, int exp) {
	this.coeff = coeff;
	this.exp = exp;
   }

   @Override
   public boolean equals( Object obj ) {
	    if (obj == null || ! (obj instanceof Termine)) return false;
	    Termine x = (Termine) obj;
            return coeff == x.coeff && exp == x.exp;
   }

   @Override
   public String toString( )
   {
       String s = String.valueOf(coeff);
       if (exp == 1) s = s + "x";
       else if (exp > 1) s = s + "x^" + String.valueOf(exp) + " " ; 
	   return s;
	   //return coeff + "x^" + exp + " " ; 
   }

   @Override
   public int compareTo( Termine x ) {
	if (exp < x.exp) return -1;   
	else if (exp > x.exp) return 1;
	// esponenti uguali
	if (coeff < x.coeff) return -1;
	else if (coeff > x.coeff) return 1;
	return 0;
   }


} // end-class