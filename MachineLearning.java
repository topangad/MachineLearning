package MachineLearning;

import java.util.*;

import java.awt.Color;
import java.io.IOException;

import java.awt.geom.*;
import javax.swing.*;

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
   
   //y = mx + b abbr = mxb, returns the derivative of the cost function
   //evaluated at J( theta1, theta2)s
   public double CostFunctionLeastSquares(
      List<Point> points,
      linearHypothesis mxb,
      int derivativeParams
   ){   
      double sum = 0;
      int numTrainingExamples = points.size();

      for ( int i = 0 ; i < numTrainingExamples; i ++ ) {
         double yprime, x, y;
         x = points.get(i).x;
         y = points.get(i).y;
         
         switch( derivativeParams ) {
            case 1:
               yprime = (mxb.evalAt(x) - y) ; 
               sum += yprime;
               break;
            case 2:
               yprime = (mxb.evalAt(x) - y)*x;
               sum+= yprime;
               break;
            default:
               yprime = mxb.evalAt(x) - y;
               sum += yprime*yprime;
         }
      }

      sum = sum/(2*numTrainingExamples);
      
      // if case 1 or 2, fomula for derivaive calculations is 1/m instead of 1/2m     
      return ( derivativeParams != 0 ) ? sum*2 : sum ;
   }
   
   public linearHypothesis getLineOfBestFit(double theta1, double theta2) {
   
      double alpha = 0.3; //rate of convergence
      double theta1new = 4000, theta2new = 4000;
      boolean skipFirst = true;
      
      while (!skipFirst && theta1new - theta1 < 0.0005){
         if(skipFirst) {
            skipFirst = false;
         }
      
         linearHypothesis mxb = new linearHypothesis( theta1, theta2);
         
         double derivativeCostFunctionO1 = CostFunctionLeastSquares(this.points,mxb, 1);
         double derivativeCostFunctionO2 = CostFunctionLeastSquares(this.points,mxb, 2);                  

         theta1new = theta1 - alpha*derivativeCostFunctionO1;
         theta2new = theta2 - alpha*derivativeCostFunctionO2;
         
         //update linear hypothesis parameters and cost function minimization
         theta1 = theta1new;
         theta2 = theta2new;
      }
      
      return new linearHypothesis(theta1new, theta2new) ;
   }
   
   public static void main( String [] args) {
      Plot plot = Plot.plot(Plot.plotOpts().
				title("Gradient Descent Algorithm with 1 Var").
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
        
        //run the default java applet
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new GraphingData());
        f.setSize(400,400);
        f.setLocation(200,200);
        f.setVisible(true);
   }   
}