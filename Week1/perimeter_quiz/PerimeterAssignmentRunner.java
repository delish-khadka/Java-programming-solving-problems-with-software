package perimeter_quiz;

import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int count = 0;
        for(Point p : s.getPoints()){
            count = count +1;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double count = getNumPoints(s);
        double perimeter = getPerimeter(s);
        double avgLength = perimeter/count;
        return avgLength;
    }

    public double getLargestSide(Shape s) {
        double largestSize = 0;
        Point lastPoint = s.getLastPoint();
        for(Point currentPoint: s.getPoints()){
           double currDist = lastPoint.distance(currentPoint);
           if(currDist > largestSize){
               largestSize = currDist;
           }
           lastPoint = currentPoint;
        }
        return largestSize;
    }

    public double getLargestX(Shape s) {
        double largestX = 0;
        Point lastPoint = s.getLastPoint();
        for(Point currentPoint: s.getPoints()){
            double newPoint = currentPoint.getX();
            if(newPoint>largestX){
                largestX = newPoint;
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perim = getPerimeter(s); 
            if(perim>largestPerim){
                largestPerim= perim;
            }
        }
        return largestPerim;
    }

    public String getFileWithLargestPerimeter() {
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        File largestFile = null;   
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perim = getPerimeter(s); 
            if(perim>largestPerim){
                largestPerim= perim;
                largestFile = f;
            }
        }
        return largestFile.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("The perimeter of the shape is = " + length);
        System.out.println("The number of points of the shape is = " + getNumPoints(s));
        System.out.println("Average length of the shape is " + getAverageLength(s));
        System.out.println("The largest side of the shape is " + getLargestSide(s));
        System.out.println("The largest X of the shape is " + getLargestX(s));
    }
    
    public void testPerimeterMultipleFiles() {
        System.out.println("The largest perimeter of multiple files are: " + getLargestPerimeterMultipleFiles());             
    }

    public void testFileWithLargestPerimeter() {
        System.out.println("The file with the largest perimeter is: " + getFileWithLargestPerimeter()); 
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        
        System.out.println("First assignment");
        pr.testPerimeter();
        
        System.out.println("Second assignment");
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
