import java.util.Arrays;
public class Q {
    public static double dotProduct(Matrix<Double> m,int i,double[] b){
        if(i<0|| i>=m.nRows()||b.length!=m.nCols()){
            throw new IllegalArgumentException();
        }
        AccFunction<Double,Double> dot_product=(Double x,Double y,Double z)->x+(y*z);
        Accumulator<Double> v=m.<Double>rowScanner(i, dot_product, 0.0);
        for (int j = 0; j < b.length; j++) {
            v.accumulate(b[j]);
        }
        return v.read();
    }

    public static boolean lowerBound(Matrix<Double> m,int j,int b){
        AccFunction<Boolean,Double> lower_bound=(Boolean x,Boolean y,Double z)->x && (z>=b);
        Accumulator<Boolean> v=m.<Boolean> colsScanner(j, lower_bound, true);
        while(!v.isOver()){
            v.accumulate(true);

        }
        return v.read();
    }

}
