
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    Boolean twoOccurrences(String a,String b)
    {   Boolean occurred = false;
        if(b.indexOf(a) != -1 && b.indexOf(a,b.indexOf(a) + a.length() ) != -1)
        {
            occurred = true;
            System.out.println(a + " occurred twice!");
        } else System.out.println(a + " didn't occurr twice!");
        
        return occurred;
    };
    
    
    void testing()
    {   
        String Occurrences1 = "by";
        String Occurrences2 = "A story by Abby Long";
        String pairA1= "atg";
        String pairA2 = "ctgtatgta";
        twoOccurrences(Occurrences1,Occurrences2);
        twoOccurrences(pairA1,pairA2);
        System.out.println("The string after an is " +
        lastPart("an","banana"));
        System.out.println("The string after zoo is " + 
        lastPart("zoo","forest"));
    };
    
    String lastPart(String a, String b)
    {
        if(b.indexOf(a) != -1)
        {
            return b.substring(b.indexOf(a) + a.length(), b.length());
        }
        
        return b;
    };
}

