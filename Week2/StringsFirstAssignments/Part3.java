package StringsFirstAssignments;


/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public boolean twoOccurences(String stringa, String stringb){
        int firstIndex = stringb.indexOf(stringa);
        int lastIndex = stringb.lastIndexOf(stringa);
        if(firstIndex != lastIndex){
            return true;
        }
        else{
            return false;
        }
    }
    
    public String lastPart(String stringa, String stringb){
        int index = stringb.indexOf(stringa);
        if (index == -1) {
            return stringb;
        } else {
            return stringb.substring(index + stringa.length());
        }
    }
    
    public void testing(){
        String stringa;
        String stringb;
        
        System.out.println("Testing two occurances");
        System.out.println("======================");
        
        stringa = "by";
        stringb = "A story by abby long";
        System.out.println(stringa + "appears atleast twice in"+stringb+"="+twoOccurences(stringa,stringb));
        
         stringa = "a";
        stringb = "banana";
        System.out.println(stringa + " appears at least twice in " + stringb + " = " + twoOccurences(stringa, stringb));
        
        stringa = "atg";
        stringb = "ctgtatgta";
        System.out.println(stringa + " appears at least twice in " + stringb + " = " + twoOccurences(stringa, stringb));
        
        System.out.println();
        System.out.println("###last part###");
        
        stringa = "an";
        stringb = "banana";
        System.out.println("The part of the string after " + stringa + " in " + stringb + " is " + lastPart(stringa, stringb));
        
        stringa = "zoo";
        stringb = "forest";
        System.out.println("The part of the string after " + stringa + " in " + stringb + " is " + lastPart(stringa, stringb));
    }
}
