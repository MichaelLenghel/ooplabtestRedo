package ie.dit;

public class Tune implements player 
{
	int x;
	String title = null;
	String altTitle = null;
	String notation = null;

	//Getter methods
	public int getX()
	{
		return x;
	}

	public String getTitle()
	{
		return title;
	}

	public String getaltTitle()
	{
		return altTitle;
	}

	public String getNotation()
	{
		return notation;
	}

	//Setter methods
	public void setX(int x)
	{
		this.x = x;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setAltTitle(String altTitle)
	{
		this.altTitle = altTitle;
	}  

	public void setNotation(String notation)
	{
		this.notation = notation;
	}  

	public void play()
	{
		System.out.println(notation);
	}

	//for prints :)
	public String toString()
    {
    	if (altTitle == null) 
    	{
    		return " " + x + ", " + title;
    	}
    	else
    	{
    		return " " + x + ", " + title + 
        	", " +  altTitle;
    	}
    }


}