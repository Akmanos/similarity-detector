import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SimilarityUtilities {
	/**
	 * Returns the set of non-empty lines contained in a text, trimmed of
	 * leading and trailing whitespace.
	 * 
	 * @param text
	 * @return the trimmed set of lines
	 */
	public static Set<String> trimmedLines(String text) {
		Set<String> n = new TreeSet<String>();
		
		if(text.isEmpty()) {
			return n;
		}
		
		else if(text.equals(" ")) {
			return n;
		}
		
		else if(text.equals(null)) {
			return n;
		}
		
		String[] txt = text.split("\n");
		
		for(int i=0; i<txt.length; i++) {			
			if(txt[i].equals("") || txt[i].isEmpty()) {
				txt[i]=null;
			}
			
			if(txt[i].contains("\n")) {
				txt[i].replaceAll("\n", "");
			}
			
			txt[i].replaceAll("  ", " ");
			
			if(!txt[i].isEmpty() && txt[i] !=null && !txt[i].equals(null)) {
				n.add(txt[i]);
			}
		}

		return n;
	}

	/**
	 * Returns a list of words in the text, in the order they appeared in the text, 
	 * converted to lowercase.
	 * 
	 * Words are defined as a contiguous sequence of letters and numbers.
	 *
	 * @param text
	 * @return a list of lowercase words
	 */
	public static List<String> asLowercaseWords(String text) {
		List<String> n = new ArrayList<String>();
		
		if(text.isEmpty()) {
			return n;
		}
		
		else if(text.equals(" ")) {
			return n;
		}
		
		else if(text.equals(null)) {
			return n;
		}
		
		else {
			String temp=text;
			temp.replaceAll("\n", "");
			temp.replaceAll("  ", " ");
			
			if(!temp.isEmpty()) {
				String[] b = text.split("\n");
					
				for(int i=0; i<b.length; i++) {
						b[i].replaceAll("\n", "");
						b[i].replaceAll("  ", "");
						b[i].replaceAll(" ", "");
						b[i].replaceAll("[^a-zA-Z]+", "");
						n.add(b[i]);
					
					}
				}
			for(int i=0; i<n.size(); i++) {
				if(n.get(i).equals("") || n.get(i).isEmpty() || n.get(i).equals(" ")) {
					n.remove(i);
				}
	
			}
			}
		
		return n;
	}

	/**
	 * Returns the line-based similarity of two texts.
	 * 
	 * The line-based similarity is the Jaccard index between each text's line
	 * set.
	 * 
	 * A text's line set is the set of trimmed lines in that text, as defined by
	 * trimmedLines.
	 * 
	 * @param text1
	 *            a text
	 * @param text2
	 *            another text
	 * @return
	 */
	public static double lineSimilarity(String text1, String text2) {
		return -1.0;
	}

	/**
	 * Returns the line-based similarity of two texts.
	 * 
	 * The line-based similarity is the Jaccard index between each text's line
	 * set.
	 * 
	 * A text's line set is the set of trimmed lines in that text, as defined by
	 * trimmedLines, less the set of trimmed lines from the templateText. Removes
	 * the template text from consideration after trimming lines, not before.
	 * 
	 * @param text1
	 *            a text
	 * @param text2
	 *            another text
	 * @param templateText
	 *            a template, representing things the two texts have in common
	 * @return
	 */
	public static double lineSimilarity(String text1, String text2, String templateText) {
		return -1.0;
	}

	/**
	 * Returns a set of strings representing the shingling of the given length
	 * of a list of words.
	 * 
	 * A shingling of length k of a list of words is the set of all k-shingles
	 * of that list.
	 * 
	 * A k-shingle is the concatenation of k adjacent words.
	 * 
	 * For example, a 3-shingle of the list: ["a" "very" "fine" "young" "man"
	 * "I" "know"] is the set: {"averyfine" "veryfineyoung" "fineyoungman"
	 * "youngmanI" "manIknow"}.
	 * 
	 * @param words
	 * @param shingleLength
	 * @return 
	 */
	public static Set<String> shingle(List<String> words, int shingleLength) {
		Set<String> n = new HashSet<String>();
		if(!words.isEmpty() && words.size()>0) {
			if(words.size()>1 && shingleLength>1) {
				for(int i=0; i<words.size()-shingleLength; i++) {
					int j=0;
					String temp="";
					
					while(j<shingleLength-1 || j%shingleLength==1 && j<words.size()) {
						temp+=words.get(j);
						j++;
						
						if(j == shingleLength ) {
							n.add(temp);
							temp="";
						}
					}
					
				}
				
				if(shingleLength==1) {
					n.addAll(words);
				}
			}
			
			else if(words.size()==1) {
				n.addAll(words);
			}
		}

		return n;
	}

	/**
	 * Returns the shingled word similarity of two texts.
	 * 
	 * The shingled word similarity is the Jaccard index between each text's
	 * shingle set.
	 * 
	 * A text's shingle set is the set of shingles (of the given length) for the
	 * entire text, as defined by shingle and asLowercaseWords, 
	 * less the shingle set of the templateText. Removes the templateText 
	 * from consideration after shingling, not before.
	 * 
	 * @param text1
	 * @param text2
	 * @param templateText
	 * @param shingleLength
	 * @return
	 */
	public static double shingleSimilarity(String text1, String text2, String templateText, int shingleLength) {
		return -1.0;
	}
}
