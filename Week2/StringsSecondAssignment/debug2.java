package StringsSecondAssignment;


/**
 * Write a description of debug2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class debug2 {
    public void findAbc(String input){
       int index = input.indexOf("abc");
       while (true){
           if (index == -1 || index >= input.length() - 3){
               break;
           }
           System.out.println("Before:" +index);
           String found = input.substring(index+1, index+4);
           System.out.println(found);
           index = input.indexOf("abc",index+3);
           System.out.println(index);
       }
   }

   public void test(){
       //findAbc("abcd");
       findAbc("abcabcabcabca");
   }
}
