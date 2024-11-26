import edu.duke.*;
/**
 * Write a description of Part4 here.
 * 
 * @author (Tao Su) 
 * @version (a version number or a date)
 */
public class Part4 {
    void youtubeFinder(URLResource ur )
    {   
        int counter = 0;
        for(String s : ur.words())
        {
            String temp = s.toLowerCase();
            if(temp.indexOf("youtube.com") != -1) {
                    counter += 1;
                System.out.println("The URL" + counter + "is: " + s.substring(s.indexOf("\"",
                s.lastIndexOf("\"",temp.indexOf("youtube.com") + 11))));

            }
            
            
        };
    };
    
    void testing()
    {
        URLResource ur = 
        new URLResource("https://www.dukelearntoprogram.com/course2/data/manylinks.html");
        //System.out.println("The URL is: " + youtubeFinder(ur));
        youtubeFinder(ur);
    };
}
