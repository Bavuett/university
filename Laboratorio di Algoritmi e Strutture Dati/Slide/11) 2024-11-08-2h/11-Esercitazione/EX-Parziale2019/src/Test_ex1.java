public class Test_ex1
{
    public static void main(String[] args)
    {
        new Test_ex1().run();
    } // method main

    public void run() {
    	Cliente c1 = new Cliente("Anne", "BBBBBBB", "Roma"),
    		    c2 = new Cliente ("Smith", "AAAAAAA", "Siena"), 
    		    c3 = new Cliente ("Jones", "ZZZZZZZ", "Torino"),
    			c4 = new Cliente ("CCCCCCC");
    	
        Archivio a = new Archivio();
        a.insert("T523", c1);
        a.insert("T345", c3);
        a.insert("T444", c2);
        a.insert("T400", c3);
        a.insert("T500", c4);

    System.out.println("Archivio:\n" + a);
          
   
    a.insert2("T345", c1); 
    System.out.println("Insert T345, (Anne, BBBBBBB, Roma)");
    System.out.println("Archivio:\n" + a);
    
    a.delete("T345");
    System.out.println("Cancella T345");
    System.out.println("Archivio:\n" + a);
    
    a.sort_byCF();
    System.out.println("Ordina per CF");
    System.out.println("Archivio:\n" + a);
    
    a.sort_byTarga();
    System.out.println("Ordina per Targa");
    System.out.println("Archivio:\n" + a);
    
    Archivio roma = a.archivio_byCitta("Roma");
    System.out.println("Roma:\n" + roma);
    
    Archivio unk = a.archivio_byCitta("unknown");
    System.out.println("Città di residenza sconosciuta:\n" + unk);

    } // method run

} // class 