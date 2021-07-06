package StringsSecondAssignment;


/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int currIndex= dna.indexOf(stopCodon, startIndex +3);
        while(currIndex != -1){
            int diff = currIndex - startIndex;
            if(diff % 3 == 0){
                return currIndex;
            }
            else{
                currIndex = dna.indexOf(stopCodon, currIndex+1);
            }
        }
        return dna.length();
    }
    
    public void testFindStopCodon(){
        String dna = "123456TAAabcdeTAA";
        int stop= findStopCodon(dna, 0, "TAA");
        if(stop != 6){
            System.out.println("error in 6");
        } 
        
        stop = findStopCodon(dna, 4, "TAA");
        if(stop != dna.length())
        {
            System.out.println("error in 5");
        }
        
        stop = findStopCodon(dna, 5, "TAA");
        if(stop != 14)
        {
            System.out.println("error in 17");
        }
        System.out.println("Test finished");
    }
    
    public String findGene(String dna) {
        int firstOccur= dna.indexOf("ATG");
        if(firstOccur != -1)
        {
            int taaIndex = findStopCodon(dna, firstOccur + 3, "TAA");
            int tgaIndex = findStopCodon(dna, firstOccur + 3, "TGA");
            int tagIndex = findStopCodon(dna, firstOccur + 3, "TAG");
            int minIndex = Math.min(taaIndex, Math.min(tgaIndex, tagIndex));
            if(minIndex == dna.length()){
                return "";
            }
            else{
                return dna.substring(firstOccur,minIndex+3);
            }
        }
        else{
            return "";
        }
    }
    
    public void testFindGene(){
        String dna = "abcdefghiTAA";
        System.out.println("DNA is:" + dna);
        String gene = findGene(dna);
        System.out.println("gene is: " +gene);
        System.out.println();
        
        dna = "abcATGghijkl";
        System.out.println("DNA is:" + dna);
        gene = findGene(dna);
        System.out.println("gene is: " +gene);
        System.out.println();
        
        dna = "abcATGghiTAG";
        System.out.println("DNA is:" + dna);
        gene = findGene(dna);
        System.out.println("gene is: " +gene);
        System.out.println();
        
        dna = "abcATGghijTAAklTGA";
        System.out.println("DNA is:" + dna);
        gene = findGene(dna);
        System.out.println("gene is: " +gene);
        System.out.println();
        
        dna = "abcATGghijkl";
        System.out.println("DNA is:" + dna);
        gene = findGene(dna);
        System.out.println("gene is: " +gene);
        System.out.println();
        
        dna = "abcATGghijklTGAoneTAG";
        System.out.println("DNA is:" + dna);
        gene = findGene(dna);
        System.out.println("gene is: " +gene);
        System.out.println();
    }
    
    /*Write the void method printAllGenes that has one String parameter dna, 
    representing a string of DNA. In this method you should repeatedly find genes and print each one until there are no more genes. Hint: remember you learned a while(true) loop and break.  */ 
    
    public void printAllGenes(String dna){ 
    String gene=findGene(dna);
    while (true){
        if(gene.isEmpty()){
            break;
        }
        else{
            System.out.println(gene);
            dna=dna.substring(dna.indexOf(gene)+gene.length());
            gene=findGene(dna);
        }
    }
    }
    
    public void testPrintAllGenes(){
        String dna = "ATGabcTAAabcdATGxyzTGAaaATGabcaTAGabTGA";
        printAllGenes(dna);
        
    }
}
