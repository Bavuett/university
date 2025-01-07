import java.util.*; 

public class Cellulare { 

    private double carica = 0; 
    private int numeroChiamate = 0; 
    double minTotali = 0.0; 
    private ArrayList<Chiamata> elencoChiamate = new ArrayList<>(); 

    public Cellulare(double unaCarica) { 
        this.carica = unaCarica; 
    } 

    public void ricarica(double unaRicarica) { this.carica += unaRicarica; } 

    public void chiama(String numeroTel, Date inizioDataOra, int sec) { 

        elencoChiamate.add(new Chiamata(numeroTel, inizioDataOra, sec / 60.0)); 
        carica -= sec * (0.15 / 60.0);
        minTotali += sec / 60.0;
        numeroChiamate++; 
    } 

    public double totaleChiamate() { 
     /*   double totale = 0.0; 
        for(Chiamata c : elencoChiamate) { 
            totale += c.getDurata(); 
        } 
        return totale; 
      */
     return minTotali;	
    } 

    public ArrayList<Chiamata> getSottoelenco (String numeroTel) { 
        ArrayList<Chiamata> sottoElenco = new ArrayList<Chiamata>(); 
        for(Chiamata c : elencoChiamate) { 
            if(c.getNumTel().equals(numeroTel)) 
                sottoElenco.add(c); 
        } 
        return sottoElenco; 

    } 

    public ArrayList<Chiamata> getElencoOrdinatoPerDataOraCresc() { 
        ArrayList<Chiamata> ordinato = new ArrayList<Chiamata>(this.elencoChiamate); 
        Collections.sort(ordinato); 
        return ordinato; 

    } 

    public ArrayList<Chiamata> getElencoOrdinatoPerDataOraDecr() { 
        ArrayList<Chiamata> ordinato = new ArrayList<Chiamata>(this.elencoChiamate); 
        Collections.sort(ordinato, new Comparator<Chiamata>() { 
            @Override 
            public int compare(Chiamata c1, Chiamata c2) { 
                return c2.compareTo(c1); 
            } 
        }); 
        return ordinato; 
    } 

    public ArrayList<Chiamata> getElencoOrdinatoPerNumero() { 
        ArrayList<Chiamata> ordinato = new ArrayList<Chiamata>(this.elencoChiamate); 
        Collections.sort(ordinato, new Comparator<Chiamata>() { 
            @Override 
            public int compare(Chiamata c1, Chiamata c2) { 
                return c1.getNumTel().compareTo(c2.getNumTel()); 
            } 
        }); 
        return ordinato; 
    } 

    public ArrayList<Chiamata> getElencoOrdinatoPerDurata() { 
        ArrayList<Chiamata> ordinato = new ArrayList<>(this.elencoChiamate); 
        Collections.sort(ordinato, new Comparator<Chiamata>() { 
            @Override 
            public int compare(Chiamata c1, Chiamata c2) { 
                final double DELTA = 0.0001; 
                if(c1.getDurata() - c2.getDurata() > DELTA) return 1; 
                if(c1.getDurata() - c2.getDurata() < DELTA) return -1; 
                return 0; 
            } 
        }); 
        return ordinato; 
    } 

    public double getCarica() { return carica; } 

    public int getNumeroChiamate() { return numeroChiamate; } 

    public ArrayList<Chiamata> getElencoChiamate() { return elencoChiamate; } 

} 