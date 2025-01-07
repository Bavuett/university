/**
  * Realizzare una classe Moneta, i cui esemplari hanno un nome (nome della moneta, es: “Due euro”)
  * ed un valore (valore della moneta: es: 2). Si considera la valuta fissata in Euro. 
  * Fornire uno o più costruttori ed i metodi getNome/setNome e GetValore/setNome, per ispezionare/modificare
  * rispettivamente il nome ed il valore della moneta corrente.
  * Lo studente estenda opportunamente la classe con altri metodi.
------------------------------------------------------------------------------------------------------------------*/

public class Moneta implements Comparable<Moneta> {
    private String nome;
    private double valore;
    
    public Moneta(){
        nome=""; valore=0;
    }

    public Moneta (double valore, String nome){
        this.nome=nome;
        this.valore=valore;
        System.out.println ( "Creata moneta da " + this.valore + " Euro"); 
    }

    public String getNome(){ return this.nome;}
    public double getValore () { return this.valore;}
    public void setNome(String nome){this.nome=nome;}
    public void setValore(double valore){this.valore=valore;}
    

    @Override    
    public int compareTo(Moneta altra){
            if (altra.valore == this.valore) return 0;
            else if (altra.valore < this.valore) return 1;
                 else return -1;
    }  

  
   public void printInfo(){
	System.out.println(this.getValore()  + " Euro ");
   }

   @Override 
   public String toString(){
 	return (this.getValore()  + " Euro ");
   }

   @Override 
   public boolean equals(Object obj){
	if (obj == null) return false;
        if (!(obj instanceof Moneta)) return false;
        Moneta m = (Moneta) obj; 
        return m.valore == this.valore;
   }

}