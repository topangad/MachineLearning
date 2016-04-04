package MachineLearning.gradientDescent;

import java.util.*;

class GradientDescent  {
   private List<Point> points;
   
   class Point {
      double x,y;
      
      public Point(int x, int y) {
         this.x = x;
         this.y = y;
      }     
   }   
   
   class linearHypothesis {
      // h(x) = ax + b
      double slope, yint;
      
      public linearHypothesis ( double a, double b ) {
         this.slope = a;
         this.yint = b;
      }
   }
   
   public linearHypothesis getLineOfBestFit() {
      
   }   
}