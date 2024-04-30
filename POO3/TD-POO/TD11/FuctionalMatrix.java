import java.lang.Number;
public class FuctionalMatrix<T extends Number> extends Matrix<T>{
    public FuctionalMatrix(T[][] t) throws InvalidContentException {
        super(t);
    }
    private boolean empty(T v){
        return v.intValue()==0;
    }
    protected boolean checkContent(T[][] t){
        for (int j = 0;j < t[0].length; j++) {
            int not_empty=0;
            for (int i = 0; i < t.length; i++) {
                not_empty++;
            }
            if(not_empty>1){
                return false;
            }
        }
        return true;
    }
    public void contient(T[] t){
        if(t.length!=nCols()){
            throw new IllegalArgumentException();
        }
        for (int j = 0; j < nCols(); j++) {
            Accumulator<T> v=colsScanner(j, (T x,T y,T z)->empty(z)? x : z, t[j]);
            while(!v.isOver()){
                v.accumulate(t[j]);
            }
        
        t[j]=v.read();
    }}
}