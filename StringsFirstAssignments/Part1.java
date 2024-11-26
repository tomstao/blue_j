
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    
    String findSimpleGene(String dna)
    {
        String gene = "";
        int indexOfATG = dna.indexOf("ATG");
        int indexOfTAA = dna.indexOf("TAA",indexOfATG + 3);
        int geneExists = indexOfTAA - indexOfATG;
        if (indexOfATG != -1 & indexOfTAA != -1 & geneExists % 3 == 0)
        {
            gene = dna.substring(indexOfATG,indexOfTAA + 3);
            return gene;
        } else return"";
    }
    
    void testSimpleGene()
    {
       String noATG = "GTCACGTTGGAGCTTAGC";
       String noTAA = "ATGCCGACGTCCGGAACCT";
       String noTAAOrATG = "GCGTTGGCCTAGCCTGACG";
       String mutipleOf3 = "GGATGCCCTAACGGAATC";
       String notMultOf3 = "AATGACCGTAA";
       System.out.println("The DNA segment is: " + findSimpleGene(noATG));
       System.out.println("The DNA segment is: " + findSimpleGene(noTAA));
       System.out.println("The DNA segment is: " + findSimpleGene(noTAAOrATG));
       System.out.println("The DNA segment is: " + findSimpleGene(mutipleOf3));
       System.out.println("The DNA segment is: " + findSimpleGene(notMultOf3));
    };
    
}
