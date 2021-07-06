package perimeter_quiz;


/**
 * Write a description of NewBah here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewBah {

	public static void main(String[] arg) 
	{ 
		{ 
			int[] marks = { 125, 132, 95, 116, 110 }; 
			
			int highest_marks = maximum(marks); 
			System.out.println("The highest score is " + highest_marks); 
		} 
	} 
	public static int maximum(int[] numbers) 
	{ 
		int maxSoFar = numbers[0]; 
		
		// for each loop 
		for (int  i : numbers) 
		{ 
			if (i > maxSoFar) 
			{ 
				maxSoFar = i; 
			} 
		} 
	return maxSoFar; 
	} 

}
