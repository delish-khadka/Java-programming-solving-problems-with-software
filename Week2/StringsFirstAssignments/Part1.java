package StringsFirstAssignments;


/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene(String dna){
        String result = "";
        int startIndex = dna.indexOf("ATG");
        if(dna.indexOf("ATG") == -1){
            return "";
        }
        int stopIndex = dna.indexOf("TAA",startIndex + 3);
        if(dna.indexOf("TAA") == -1){
            return "";
        }
        int a =(startIndex-stopIndex);
        
        if(a%3 == 0){
            return dna.substring(startIndex,stopIndex+3);
        }
        return result;
    }
    
    public void testSimpleGene(){
        String dna1 = "GATACTTAA";
        System.out.println(dna1);
        System.out.println("Gene is:" + findSimpleGene(dna1));
        System.out.println();
        
        String dna2 = "ATGTCCGATTAA";
        System.out.println(dna2);
        System.out.println("Gene is:" + findSimpleGene(dna2));
        System.out.println();
        
        String dna3 = "ATTACTCAT";
        System.out.println(dna3);
        System.out.println("Gene is:" + findSimpleGene(dna3));
        System.out.println();
        
        String dna4 = "ATGTCCTAA";
        System.out.println(dna4);
        System.out.println("Gene is:" + findSimpleGene(dna4));
        System.out.println();
        
        String dna5 = "CGTATGTCGATAA";
        System.out.println(dna5);
        System.out.println("Gene is:" + findSimpleGene(dna5));
        System.out.println();
        
    }
}
