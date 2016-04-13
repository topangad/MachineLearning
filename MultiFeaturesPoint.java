package MachineLearning;
import java.util.ArrayList;

//Data Type for linear regression with multiple variables
public class MultiFeaturesPoint {
   //Values for features x0, x1, x2, ... xN
   //Pre: x0 = 1
   private ArrayList<Double> featureValues;
   
   public MultiFeaturesPoint(ArrayList<Double> val) {
      this.featureValues = new ArrayList<Double>(val);
   }
   
   public void appendVal(double val) {
      this.featureValues.add(new Double(val));
   }
   
   public double at(int index) {
      return this.featureValues.get(index).doubleValue();
   }
}