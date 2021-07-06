package StringsThirdAssignment;

import edu.duke.*;
public class Part3 {    
    public int findStopCodon(String dna, int startCodon, String stopCodon) {
        int currIndex = dna.indexOf(stopCodon, startCodon + 3);
        while(currIndex != -1) {
            int diff = currIndex - startCodon;
            if(diff % 3 == 0) {
                return currIndex;
            } else {
                currIndex = dna.indexOf(stopCodon, currIndex + 1);
            }
        }
        return dna.length();
    }
    
    public String findGene(String dna, int where) {
        dna = dna.toUpperCase();
        int startIndex = dna.indexOf("ATG", where);
        if(startIndex == -1) {
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int minIndex = Math.min(taaIndex, Math.min(tagIndex, tgaIndex));
        if(minIndex == dna.length()) {
            return "";
        }
        return dna.substring(startIndex, minIndex + 3);
    }
    
    public StorageResource getAllGenes(String dna) {
        int startIndex = 0;
        StorageResource geneList = new StorageResource();
        
        while(true) {
            String currentGene = findGene(dna, startIndex);
            if(currentGene.isEmpty()) {
                break;
            }
            //System.out.println(currentGene);
            geneList.add(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex + 1) + currentGene.length();
        }
        return geneList;
    }
    
    public double cgRatio(String dna) {
        int countC = 0;
        int countG = 0;
        int cIndex = dna.indexOf("C");
        int gIndex = dna.indexOf("G");
        while(true) {
            if(cIndex == -1 && gIndex == -1) {
                break;
            } else {
                if(cIndex != -1) {
                    countC += 1;
                    cIndex = dna.indexOf("C", cIndex + 1);
                }
                if(gIndex != -1) {
                    countG +=1;
                    gIndex = dna.indexOf("G", gIndex + 1);
                }
            }
        }
        return ((double) countC + countG) / dna.length();
    }
    
    public int countCTG(String dna) {
        int startIndex = dna.indexOf("CTG");
        int count = 0;
        while(startIndex != -1) {
            count++;
            startIndex = dna.indexOf("CTG", startIndex + 1);
        }
        return count;
    }
    
    private void processGenes(StorageResource sr) {
        int lengthCount = 0;
        int cgRatioCount = 0;
        int longestLength = Integer.MIN_VALUE;
        
        for (String gene : sr.data()) {
            int currentLength = gene.length();
            double cgRatio = cgRatio(gene);
            
            System.out.println("CG RATIO: " + cgRatio);
            if (currentLength > 60) {
                System.out.println("Longer than 60 characters: " + gene);
                lengthCount++;
            }
            
            if (cgRatio > 0.35) {
                System.out.println("C-G ratio higher than 0.35: " + gene);
                cgRatioCount++;
            }
            
            longestLength = Math.max(longestLength, currentLength);
        }
        
        System.out.println("Total genes: " + sr.size());
        System.out.println("Total gene longer than 60 characters: " + lengthCount);
        System.out.println("Total gene with C-G ratio higher than 0.35: " + cgRatioCount);
        System.out.println("Length of longest dna: " + longestLength);
    }
    
    public void testProcessGenes() {
        FileResource fr = new FileResource("StringsThirdAssignment/GRch38dnapart.fa");
        String dna = fr.asString();
        
        StorageResource geneList = getAllGenes(dna);
        processGenes(geneList);
    }
}