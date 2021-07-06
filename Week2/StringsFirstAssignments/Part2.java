package StringsFirstAssignments;


/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene(String dna, String startCodon,String stopCodon){
        String result = "";
        int startIndex = dna.toUpperCase().indexOf(startCodon);
        int stopIndex = dna.toUpperCase().indexOf(stopCodon,startIndex+3);
        if(startIndex == -1){
            return "";
        }
        if (stopIndex == -1){
            return "";
        }
        int a =(startIndex-stopIndex);
        
        if(a%3 == 0){
            return dna.substring(startIndex,stopIndex+3);
        }
        return result;
    }
    
    public void testSimpleGene(){
        String startCodon = "ATG";
        String stopCodon = "TAA";
        
        // DNA with no ATG
        String dna = "ATCTAACATC";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna, startCodon,stopCodon));
        
        // DNA with no TAA
        dna = "ATTATCATGTTA";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna, startCodon, stopCodon));
        
        // DNA with no “ATG” and “TAA”
        dna = "ATTAGTGTA";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna, startCodon, stopCodon));
        
        // DNA with ATG, TAA and the substring between them is not a multiple of 3
        dna = "GAAATGGATAGTAA";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna, startCodon, stopCodon));
        
        // DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene)
        dna = "TAAGATATGGTGAAGTAA";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna, startCodon, stopCodon));
        
        dna = "ATGGGTTAAGTC";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna, startCodon, stopCodon));
        
        dna = "gatgctataat";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna, startCodon, stopCodon));
        
    }
}
