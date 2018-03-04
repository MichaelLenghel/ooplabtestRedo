package ie.dit;

import java.util.ArrayList;
import java.io.*;
// import java.io.IOException;
// import java.io.BufferedReader;
// import java.io.FileReader;

public class TuneBook
{
	ArrayList<Tune> tunes = new ArrayList<Tune>();

	public TuneBook(String fileName)
	{
		loadTunes(fileName);
	}

	public void loadTunes(String fileName)
	{
		 // Adapted from: https://docs.oracle.com/javase/tutorial/essential/io/charstreams.html
        BufferedReader inputStream = null;
        //Need to initialise it or compiler moans
        Tune t = null;
        String notation = "";
        try 
        {
            inputStream = new BufferedReader(new FileReader(fileName));
            
            String l;
            while ((l = inputStream.readLine()) != null) 
            {	
            	if (l.contains("X:")) 
            	{
            		t = new Tune(); 
            		tunes.add(t);
                    notation = "";
            		//Passing the integer from a string
            		t.setX(Integer.parseInt(l.substring(2)));
            	}//end if
                if(l.contains("T:"))
                {
                    //Only set the alternative title if there already is a title
                    if (t.getTitle() == null) 
                    {
                        t.setTitle(l.substring(2, l.length()));
                    }
                    else
                    {
                        t.setAltTitle(l.substring(2, l.length()));
                    }
                }//end if
                //Ensures that it wont add to notation when tune hasn't been started from x
                if(t != null)
                {
                    if (l.equals("")) 
                    {
                        t.setNotation(notation);
                        notation = "";   
                    } 
                    else
                    {
                        notation += l + "\n";
                    }
                }

            }//end while
        }
        catch (IOException e)
        {
            e.printStackTrace();
        } 
        finally 
        {
            if (inputStream != null) 
            {
                try
                {
                    inputStream.close();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
	}

    public Tune findTune(String title)
    {
        for(Tune t: tunes)
        {
            //Checks all the titles
            if (t.getTitle().contains(title)) 
            {
                 return t;    
            }
        }
        return null; 
    }

	public String toString()
	{
		StringBuffer sb = new StringBuffer();
        for(Tune t:tunes)
        {
            sb.append(t + "\n");
        }

        return sb.toString();
	}

	public static void main(String[] args)
	{
		TuneBook tb = new TuneBook("hnj0.abc");
		System.out.println(tb);

		 Tune t = tb.findTune("Scotsman over the Border");
		 t.play();
	}
	
}