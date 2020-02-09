/**
 * Coursework 3, ay 2011/2012
 * Author: Emilio Tuosto
 */

public class MyString{

    private int theInt = 0;
    private String theString = "";

    public MyString(int theInt, String theString){
	this.theInt = theInt>0?theInt:1;
	this.theString = (!(theString==null))?theString:".";
    }

    public MyString(String theString, int theInt){
	this.theInt = theInt;
	this.theString = theString;
    }

    public MyString(String theString){
	this.theString = theString;
    }

    public MyString(int theInt){
	this.theInt = theInt;
    }

    public int getInt(){ return theInt; }
    public String getString(){ return theString; }

    public void setInt(int theInt) { this.theInt = theInt; }
    public void setString(String theString) { this.theString = theString;}

}