import java.util.*;

public class Province {
 
  private static Map<String, String> province = new HashMap<>(); //Provincia-Regione
 
  public static void main(String[ ] args) {
	province.put("L'Aquila", "Abruzzo");
	province.put("Pescara", "Abruzzo");
	province.put("Roma", "Lazio2");
	province.put("Firenze", "Toscana");
	province.put("Viterbo", "Lazio");
    province.put("Milano", "Lombardia");
    province.put("Cagliari", "Sardegna");
    province.put("Sassari", "Sardegna");
    
    if (province.containsKey("Roma")) 
	  System.out.println("Roma si trova in: " + province.get("Roma"));
    province.replace("Roma", "Lazio");  //rimpiazza il valore solo se la chiave esiste in mappa
    //province.put("Roma", "Lazio");
	System.out.println("Roma si trova in: " + province.get("Roma"));

  
  System.out.println("\nCoppie in HashMap:\n" + province);
  System.out.println("Size: " + province.size());
  System.out.println("\nProvince in HashMap: " + province.keySet());
  System.out.println("\nRegioni in HashMap: " + province.values() );
  
  
  TreeMap<String, String> capoluoghiOrd = new TreeMap<String, String> (province);
  System.out.println("\nCoppie ordinate in TreeMap:\n" + capoluoghiOrd);
  System.out.println("\nProvince ordinate in TreeMap: " + capoluoghiOrd.keySet());
  System.out.println("\nRegioni in TreeMap: " + capoluoghiOrd.values() );
  
  
  }
}