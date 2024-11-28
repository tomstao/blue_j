
/**
 * Write a description of Part1 here.
 * Find all the valid genes with three possible codons.
 * @author (Tao Su) 
 * @version (a version number or a date)
 * Nov/ 27/ 2024
 */
public class Part1 {
        int findStopCodon(String dna, int startIndex, String stopCodon){
        if(startIndex == -1) return dna.length();
        int indexOfStop = dna.indexOf(stopCodon, startIndex + 3);
        while(indexOfStop != -1)
        {
        int lengthTest = (indexOfStop - startIndex) % 3;
        if( lengthTest == 0){
            
            return indexOfStop;
        }
        else indexOfStop = dna.indexOf(stopCodon, indexOfStop + 1);
        ;}
         return dna.length();
        }
    
        void testShortcut(String gene){
            int indexStart = gene.indexOf("ATG");
            String stopCodon = "TGA";
            System.out.println("The length of \"" + gene + "\"is" +
            gene.length() + ": " +
            findStopCodon(gene, indexStart
            , stopCodon ));
        
        };
        
        public void testFindeStopCodon ()
        {
            String noStopCodon = "ATGCGTAGGCAT";
            String noStart = "TGTACATGTGA";
            String noStopr2 = "ATGCCGTTTGGA";
            String validGene = "GGGATGCCCTGA";
             
            testShortcut(noStopCodon);
            testShortcut(noStart);
            testShortcut(noStopr2);
            testShortcut(validGene);
            
        };
        
        public void testFindGene()
        {   
            String noATG = "CGTACCCGTTACGCGTACGTTTACC";
            String oneStop = "GCTATGGGCTAGCCTAG";
            String multiStop = "TACATGCCCTGATAGGGTAA";
            String noStop = "AATGCCCGGGTTT";
            String multiATG = "ATGCCCTAGATGCCCTAAATGCCC";
            printTest(noATG);
            printTest(oneStop);
            printTest(multiStop);
            printTest(noStop);
            printTest(multiATG);
        };
        
        void printTest(String gene)
        {
            if(findGene(gene,0) == "")
            {
                System.out.println("There is no valid DNA strand!");
            } else System.out.println("The DNA segement in " + gene + " is"
            + findGene(gene,0) + " !");
        };
        
        public String findGene(String gene, int start)
        {   
            int startIndex = gene.indexOf("ATG", start);
            if(startIndex == -1) return "";
            int stopIndexTAA = findStopCodon(gene, startIndex, "TAA");
            int stopIndexTAG = findStopCodon(gene, startIndex, "TAG");
            int stopIndexTGA = findStopCodon(gene, startIndex, "TGA");
            int temp = Math.min(stopIndexTAA,stopIndexTAG);
            int minIndex = Math.min(temp,stopIndexTGA);
            if(minIndex == gene.length()) return "";
            
            return gene.substring(startIndex, minIndex + 3);
        };
        
        public void printAllGenes(String dna)
        {   
            int start = 0;
            while(true)
            {   
                String currStr = findGene(dna,start);
                if(currStr== "") break;
                System.out.println(findGene(dna,start));
                start = dna.indexOf(currStr) + currStr.length();
            };
            
        };
        
        void testPrinAll()
        {
            String multiple = "ATGAAATGAATGCCCTAGATGTTTTAAATGCGCTGA";
            printAllGenes(multiple);
        };
        
}
