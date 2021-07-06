package StringsThirdAssignment;
import edu.duke.*;
public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int currIndex = dna.indexOf(stopCodon, startIndex);
        while(currIndex != -1){
            if((currIndex - startIndex)%3 == 0){
                return currIndex;
            }
            else{
                currIndex = dna.indexOf(stopCodon, currIndex+1);
            }
        }
        return dna.length();
    }
    
    public String findGene(String dna, int start){
        int startIndex = dna.indexOf("ATG",start);
        if(startIndex == -1){
            return "";
        }
        int taaIndex = findStopCodon(dna,startIndex,"TAA");
        int tagIndex = findStopCodon(dna,startIndex,"TAG");
        int tgaIndex = findStopCodon(dna,startIndex,"TGA");
        int minIndex = Math.min(taaIndex, Math.min(tagIndex,tgaIndex));
        if(minIndex == dna.length()){
            return "";
        }
        else{
            return dna.substring(startIndex,minIndex+3);
        }
    }
    
    public void printAllGenes(String dna){
        int startIndex = 0;
        while(true){
            String currentGene = findGene(dna,startIndex);
            if(currentGene.isEmpty()){
                break;
            }
            System.out.println(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
    }
    
    public StorageResource getAllGenes(String dna){
        int start = 0;
        StorageResource sr = new StorageResource();
        while(true){
            String gene = findGene(dna,start);
            if(gene.isEmpty()){
                break;
            }
            sr.add(gene);
            start = dna.indexOf(gene,start) + gene.length();
        }
        return sr;
    }
    
    public void testFindStopCodon() {
        String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
        
        int index = findStopCodon(dna, 0, "TAA");
        System.out.println("Index = " + index);
        
        index = findStopCodon(dna, 9, "TAA");
        System.out.println("Index = " + index);
                
        index = findStopCodon(dna, 1, "TAA");
        System.out.println("Index = " + index);
                
        index = findStopCodon(dna, 0, "TAG");
        System.out.println("Index = " + index);
    }
    
    public void testFindGene() {
        String dna = "GTTAATGTAGCTTAAACCTTTAAAGCAAGGCACTGAAAATGCCTAGATGA";
        System.out.println("Gene: " + findGene(dna, 0));
        
        dna = "GTGAGCTCACTCCATAGACACAAAGGTTTGGTCCTGGCCTTCTTATTAGT";
        System.out.println("Gene: " + findGene(dna, 0));
        
        dna = "TTTCAGTGAGCTTACACATGCAAGTATCCGCGCGCCAGTGAAAATGCCCT";
        System.out.println("Gene: " + findGene(dna, 0));
        
        dna = "TCAAATCATTACTGACCATAAAGGAGCGGGTATCAAGCACACACCTATGT";
        System.out.println("Gene: " + findGene(dna, 0));
        
        dna = "AGCTCACAACACCTTGCTTAGCCACACCCCCACGGGATACAGCAGTGATA";
        System.out.println("Gene: " + findGene(dna, 0));
    }
    
    public void testGetAllGenes(){
        String dna = "ATGATCTAATTTATGCTGCAACGGTGAAGA";
        StorageResource geneList = getAllGenes(dna);
        
        System.out.println("Testing getAllGenes on " + dna);
        for(String gene : geneList.data()) {
            System.out.println("Gene: " + gene);
        }
    }
}
