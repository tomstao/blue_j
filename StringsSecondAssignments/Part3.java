
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
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
        
        public int countGenes(String dna)
        {   
            int start = 0;
            int times = 0;
            while(true)
            {   
                String currStr = findGene(dna,start);
                if(currStr== "") break;
                times += 1;
                start = dna.indexOf(currStr) + currStr.length();
            };
            
            
            return times;
        };
        
        void testConutGenes()
        {
            String dna = "ATGAAATGAATGCCCTAGATGTTTTAAATGCGCTGA";
            
            System.out.println(countGenes(dna));
        };
}
