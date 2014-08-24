package oneHash;
import java.io.*;

public class MyHash {

	public static void main(String[] args) throws Exception {
		int i;	    
		FileInputStream file; 
			
	    HashDescription gather = new HashDescription();
	    try{
	    	file = new FileInputStream("C:\\MyDir\\2.txt");
	    } catch (FileNotFoundException exc){
	    	System.out.println("File not found");
	    	return;
	    }
	    try{
	    	
	    do {
	    i=file.read();
	    if (i != -1) System.out.print((char) i);
	    gather.searchsym((char) i);
	    gather.searchword((char) i,i);
	    gather.searchstr((char) i, i, "oeh");
	    } while (i != -1);
	    }catch (IOException exc) {
	    	System.out.println("Error reading file");
	    }
	    System.out.println();
	    gather.sort(5);
	    System.out.println();
	    gather.resultsym();
	    
	    try{	
	    file.close();
	    }catch (IOException exc) {
	    	System.out.println("Error closing file");
	    }
		


	}
}
