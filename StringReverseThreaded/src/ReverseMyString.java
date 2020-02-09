/**
 * Coursework 3, ay 2011/2012
 * Author: Emilio Tuosto
 */


public class ReverseMyString{

    private MyString theString;
    public ReverseMyString(MyString theString){ this.theString = theString; }

    // Note: the method 'transform' is inefficient, but this is immaterial for this coursework.

    public String transform() {
	String s   = theString.getString();
	int    i   = theString.getInt();
	int    l   = s.length();
	int    cl  = l / i;
	String res = "";
	if(cl>0){
	    int r = l%i;
	    res = s.substring(l - r, l);
	    for(int j=1; j<=cl; j++){
		res = res + s.substring( l - r - i*j , l - r - i*(j-1) );
	    }
	}
	else res = s;
	return res;
    }
}

