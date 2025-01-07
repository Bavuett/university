//PARZIALE 2019 

public class ex2 {
	
	//soluzione sul posto
	public static <T> void inverti (T[] array) {
		int len = array.length;
		for (int i=0; i< len/2; i++) {
			//swap
			T temp = array[i];
			array[i] = array[len-i-1];
			array[len-i-1] = temp;
			
		}
	}
	
	// VARIANTE (non sul posto)
	public static <T> T[] inverti2 (T[] array) {
		int len = array.length;
		T temp[] = array.clone(); 
		for (int i=0; i< len; i++) 
			temp[i] = array[len-i-1];
		return temp;
	}
	
	
	public static void main(String[] args) {
		// ver 1
		Integer x[] = {0,1,2,3,4,5,6,7,8,9};
		for(Integer i: x) System.out.print(i + " ");
		inverti(x);
		System.out.println();
		for(Integer i: x) System.out.print(i + " ");
		
		//ver2
		System.out.println();
		Integer y[] = inverti2(x);
		for(Integer i: y) System.out.print(i + " ");
		
	}

}
