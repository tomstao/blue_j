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
        int numPoints = 0;
       
        for(Point point : s.getPoints())
        {
            numPoints = numPoints + 1;

        }
        
        
        return numPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double averageLength = getPerimeter(s) / getNumPoints(s);
        
        return averageLength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double tempDist = 0;
        Point prevPt = s.getLastPoint();
        for(Point currPt: s.getPoints())
        {
            double currDist = prevPt.distance(currPt);
            if(currDist >= tempDist)
            {
                tempDist = currDist;
            }
        }

        return tempDist;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double largestX = 0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints())
        {
            if(currPt.getX() >= largestX)
            {
                largestX = currPt.getX();
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largestPeri = 0;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles())
        {   
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if(getPerimeter(s) >= largestPeri){
                largestPeri = getPerimeter(s);
            }
            
        }
        return largestPeri;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        double largest =  getLargestPerimeterMultipleFiles();

        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles())
        {   
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if(largest == getPerimeter(s))
            {
                temp = f;
            }
            
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int points = getNumPoints(s);
        System.out.println("perimeter = " + length);
        System.out.println("points = " + points);
        System.out.println("average length = " + getAverageLength(s));
        System.out.println("the largest side is: " + getLargestSide(s));
        System.out.println("the largest X is: " + getLargestX(s));
        testPerimeterMultipleFiles();
        testFileWithLargestPerimeter();
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double result = getLargestPerimeterMultipleFiles();
        
        System.out.println("The largset perimeter in files : " + result);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        System.out.println("The name of largest file: " +
        getFileWithLargestPerimeter());
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
        pr.testPerimeter();
    }
}
