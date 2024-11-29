import edu.duke.*;

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
            //printAllGenes(multiple);
            for(String s : getAllGenes(multiple).data())
            {
                System.out.println(s);
                System.out.println("The cg ratio is: " + cgRatio(s));
            };
        };
        public StorageResource getAllGenes(String dna)
        {   StorageResource sr = new StorageResource();
            int start = 0;
            while(true)
            {   
                String currStr = findGene(dna,start);
                if(currStr== "") break;
                sr.add(currStr);
                start = dna.indexOf(currStr) + currStr.length();
            };
            return sr;
        };
        
        public float cgRatio(String dna)
        {
                float cgCounter = 0;
                dna = dna.toUpperCase();
                for(int i =0; i < dna.length(); i ++)
                {
                    String character = dna.substring(i, i + 1);
                    if(character.equals("C") || character.equals("G")) 
                    cgCounter += 1;
                };
                
                float cgRat = cgCounter / dna.length();
                return cgRat;
        };
        
        public void processGenes (StorageResource sr)
        {
            int nineChar = 0;
            int hRatioCount = 0;
            int longest = 0;
            for(String s : sr.data())
            {
                if(s.length() > 60)
                {  nineChar += 1;
                   System.out.println(s + " is longer than 60 characters.");
                    
                }
                
                if(cgRatio(s) > 0.35)
                {   
                    hRatioCount += 1;
                    System.out.println(s + " C-G ratio is higher than 3.5.");
                
                };
                
                if(s.length() >= longest) longest = s.length();
                
            };
            System.out.println(nineChar + 
            " of DNA strands that are longer than 60 characters.");
            System.out.println(hRatioCount +
            " DNA strands' C-G ratio are higher than 0.35.");
            System.out.println("The longest DNA strand has " + longest +
            " characters.");
        
        };
        
        public void testProcessGenes()
        {   
            //String testGene = "ATGAAATGAATGCCCTAGATGTTTTAAATGCGCTGA";
            /*String testGene = "ATGCCCGGGTAAATGTTTTAGTAG";
            String testGene2 = "ATGCCGTAGATGTTTAAATGAACTGA";
            String testGene3 = "ATGCGCCGTAAATGTAGTAG";
            String testGene4 = "ATGTTTTAAATGAAATTGA";
            String testGene5 = "ATGCCGGGTTTAAATGAAATGAATGCGTAG";
            StorageResource test = getAllGenes(testGene);
            processGenes(test);
            test = getAllGenes(testGene2);
            processGenes(test);
            test = getAllGenes(testGene3);
            processGenes(test);
            test = getAllGenes(testGene4);
            processGenes(test);
            test = getAllGenes(testGene5);
            processGenes(test); */
            //String testGene5 = "ATGCCGGGTTTAAATGAAATGAATGCGTAG";
            //StorageResource test = getAllGenes(testGene5);
            //processGenes(test);
            FileResource fr = new FileResource("brca1line.fa");
            String dna = fr.asString().toUpperCase();
            System.out.println(dna);
            StorageResource test = getAllGenes(dna); 
               
            //System.out.println(findGene(dna,0));
            
            processGenes(test);
            
        };
}
