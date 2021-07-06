package StringsSecondAssignment;


/**
 * Write a description of ThreeStopCodon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ThreeStopCodon {
    public int findStopCodon(String dnaStr, int startIndex, String stopCodon){
        //find stop codon starting from (stratindex + 3), currIndex
        int currIndex= dnaStr.indexOf(stopCodon,startIndex+3);
        //as long as currIndex is not equal to -1
        while(currIndex != -1){
            //check if currIndex-startIndex is a multiple of 3
            //if so currIndex is answer return it
            //if not update currIndex, looking for stop codon starting from currIndex+1
            //if we exit loop, we didnt find stopcodon
            //so return dnaStr.length
            int diff = currIndex- startIndex;
            if(diff%3==0){
                return currIndex;
            }
            else{
                currIndex = dnaStr.indexOf(stopCodon, currIndex +1);
            }     
        }
        return dnaStr.length(); 
    }
    /*
    public String findGene(String dna){
        //find first occurence of "ATG",startIndex
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1){
            return "";
        }
        int taaIndex = findStopCodon(dna,startIndex,"TAA");
        int tagIndex = findStopCodon(dna.startIndex,"TAG");
        int tgaIndex = findStopCodon(dna.startIndex,"TGA");
        int temp = Math.min(taaIndex,tagIndex);
        int minIndex = Math.min(temp,tgaIndex);
        if (minIndex == dna.length()){
            return "";
        }
        //if startIndex is -1,return ""
        //use taaIndex to store findStopCodon(dna,startIndex+3)
        //use tagIndex to store findStopCodon(dna,startIndex+3)
        //use tgaIndex to store findStopCodon(dna,startIndex+3)
        //store in minIndex the smallest of these three
        //if minIndex is dna.length()?nothing found,
        //otherwise answer is text from startIndex to stopIndex
        return dna.substring(startIndex,minIndex+3);
    }*/
}
