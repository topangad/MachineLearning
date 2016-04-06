package MachineLearning;

import java.util.*;

import java.awt.Color;
import java.io.IOException;

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
      // h(x) = mx + b
      public double m, b;
      
      public linearHypothesis ( double a, double b ) {
         this.m = a;
         this.b = b;
      }
      
      public double evalAt( double x ) {
         return this.m * x + this.b;
      }
   }
   
   class CostFunction {
      double theta1, theta2;
      
      public CostFunction() {
         this.theta1 = 0;
         this.theta2 = 0;        
      }
      
      public void minimizeParams() {
         //TODO: find min value for which we get a line of best fit
      }
   }
   
   public GradientDescent (List<Point> points) {
      this.points = points;
   }
   
   public double CostFunctionLeastSquares(List<Point> points, linearHypothesis mxb) {
      double sum = 0;
      int numTrainingExamples = points.size();

      for ( int i = 0 ; i < numTrainingExamples; i ++ ) {
         double yprime = mxb.evalAt(points.get(i).x) - points.get(i).y;
         sum += yprime*yprime;
      }

      sum = sum/(2*numTrainingExamples);
      return sum;
   }
   
   public linearHypothesis getLineOfBestFit() {
      for ( int i = 0 ; i < this.points.size() ; i ++ ) {
         
      }
      return new linearHypothesis( 8 , 8 );
   }
   
   public static void main( String [] args) {
      Plot plot = Plot.plot(Plot.plotOpts().
				title("Hello World").
				legend(Plot.LegendFormat.BOTTOM)).
			xAxis("x", Plot.axisOpts().
				range(0, 5)).
			yAxis("y", Plot.axisOpts().
				range(0, 5)).
			series("Data", Plot.data().
				xy(1, 2).
				xy(3, 4),
				Plot.seriesOpts().
					marker(Plot.Marker.DIAMOND).
					markerColor(Color.GREEN).
					color(Color.BLACK));
   }   
}