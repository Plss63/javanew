package oneHash;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class HashDescription {
		private String word="";
		private OutputStreamWriter myfile;
		private String output="";
		
		HashMap<Character, Integer> statisticsym = new HashMap<Character, Integer>();
		TreeMap<String, Integer> statisticword = new TreeMap<String, Integer>();
		
		
		
		/**поиск символов
		 * 
		 * @param ch
		 */
		public void searchsym (char ch) {
			ch = Character.toLowerCase(ch);
			if (statisticsym.containsKey(ch) ==true ) statisticsym.put(ch, statisticsym.get(ch)+1);
			else statisticsym.put(ch, 1);
		}
		
		/**
		 * return symbol table
		 */
		public void resultsym () {
			System.out.println(statisticsym.entrySet());
	    }
		
		/**поиск слов
		 * 
		 * @param ch
		 * @param a
		 */
		public void searchword(char ch,int a) {
			ch = Character.toLowerCase(ch);
			if (ch ==' '){
				if (word == "") return;
				if (word != ""){
					if (statisticword.containsKey(word) ==true ) {statisticword.put(word, statisticword.get(word)+1);word="";}
				else {statisticword.put(word, 1); word="";}
				}
			}
			if (ch !=' '){
				word=word+ch;
				if (a == -1){
					if (statisticword.containsKey(word) ==true ) {statisticword.put(word, statisticword.get(word)+1);word="";}
					else {statisticword.put(word, 1); word="";}
				}
			}
	 	}
		
		/**вывод слов
		 * 
		 */
		public void resultword () {
			System.out.println(statisticword.entrySet());
	    }
		
		/**поиск максимального и минимального слова
		 * 
		 * @return max and min word 
		 */
		String wordmaxmin () {
			String smin="",smax="";
			Iterator<Entry<String, Integer>> itr = statisticword.entrySet().iterator();
			Entry<String, Integer> entry = (Entry<String, Integer>) itr.next();
			smin = entry.getKey();
			smax = entry.getKey();
			while(itr.hasNext()) {
				entry = itr.next();
			    String key = entry.getKey();
			    if (key.length() >= smax.length()) smax = key;
			    if (key.length() < smin.length()) smin = key;
			}
			return "max word: " + smax + "; min word: " + smin;
			}
		
		/**сортировка слов по значению
		 * 
		 * @param n
		 * 
		 * @return n elements
		 */
		public void sort(int n){
			List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(statisticword.entrySet());
			Collections.sort(list, new Comparator<Entry<String, Integer>>(){
				  public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
					    return e2.getValue().compareTo(e1.getValue());
					  }

		});
			for (int i = 0; i < n; i++) {
				   System.out.print(" " + list.get(i));
				}
			
		}
		
		/**поиск подстроки и удаление
		 * 
		 * @param ch (symbol)
		 * @param i (number)
		 * @param str (symbol in string)
		 * @throws IOException
		 * @throws IOException
		 * @return file 3.txt 
		 */
		public void searchstr(char ch, int i,String str) throws IOException, IOException{
			if (i != -1) {
				if (str.indexOf(ch) != -1) output = output+ch;
			}
			else {
				try{
				myfile = new OutputStreamWriter( new FileOutputStream("C:\\MyDir\\3.txt"),"cp866");
				}catch(FileNotFoundException exc){
					System.out.println("Error opening output file");
				}
				try{
					myfile.write(output);
				}catch(IOException exc){
					System.out.println("Error write");
				}
				
				try{
					myfile.close();
				}catch(IOException exc){
					System.out.println("Error closing output file");
				}
				
			}
			
		}
		
		
	}
