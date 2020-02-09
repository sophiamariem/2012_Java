/**
 * Coursework 3, ay 2011/2012
 * Author: Emilio Tuosto
 */


public class MergeWithMyString{

    private MyString theString;
    private String aString;

    public MergeWithMyString(MyString theString, String aString){
	this.theString = theString;
	this.aString = aString;
    }

    public String transform() throws Exception {
	String s   = theString.getString();
	int    i   = theString.getInt();
	int    l   = s.length();
	return aString+s;
    }
}