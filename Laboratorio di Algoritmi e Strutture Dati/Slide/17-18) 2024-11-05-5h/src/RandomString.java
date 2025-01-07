import java.util.*;

public class RandomString {
	
// Generazione casuale di una stringa
	public String randomString(int length) {
		String ssource = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz";  
		char[] src = ssource.toCharArray();
		char[] buf = new char[length];
		for(int i = 0; i < length; i++)
			buf[i] = src[new Random().nextInt(src.length)];
		return new String(buf);
	} 

}
