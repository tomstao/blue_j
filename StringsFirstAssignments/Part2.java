
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    String findSimpleGene(String dna, String startCodon, String stopCodon)
    {   
        
        dna = dna.toUpperCase();
        String target = "";
        int indexOfBegin = dna.indexOf(startCodon);
        int indexOfEnd= dna.indexOf(stopCodon,indexOfBegin + 3);
        int geneExists = indexOfEnd - indexOfBegin;
        if (indexOfBegin != -1 & indexOfEnd!= -1 & geneExists % 3 == 0)
        {
            target = dna.substring(indexOfBegin,indexOfEnd + 3);
            return target;
        } else return"";
    }
    
    void testSimpleGene()
    {   
       String startCodon = "ATG";
       String stopCodon = "TAA";
       String noATG = "GTCAcGTtGgAGCTTAGC";
       String noTAA = "ATGCCGaCGTCCGGAACCT";
       String noTAAOrATG = "GcGTTggCCTAGCCTGACG";
       String mutipleOf3 = "GGATGcccTaACGGAATC";
       String notMultOf3 = "AATGACCGtAA";
       System.out.println("The DNA segment is: " +
       findSimpleGene(noATG, startCodon, stopCodon));
       System.out.println("The DNA segment is: " +
       findSimpleGene(noTAA, startCodon, stopCodon));
       System.out.println("The DNA segment is: " +
       findSimpleGene(noTAAOrATG, startCodon, stopCodon));
       System.out.println("The DNA segment is: " +
       findSimpleGene(mutipleOf3, startCodon, stopCodon));
       System.out.println("The DNA segment is: " +
       findSimpleGene(notMultOf3, startCodon, stopCodon));
    };
}
