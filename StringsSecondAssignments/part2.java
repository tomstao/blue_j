
/**
 * Write a description of part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class part2 {
    int howMany(String a, String b)
    {   
        int times = 0;
        int start = 0;
        while(true)
        {   
            int currIndex = b.indexOf(a,start);
            if(currIndex == -1) break;
            times += 1;
            start = currIndex + a.length();
        };
        
        return times;
    };
    
    void testHowMany()
    {
        String sample = "ATGAAATGAATGCCCTAGATGTTTTAAATGCGCTGA";
        String segment = "ATG";
        System.out.println(howMany(segment, sample));
    };

}
