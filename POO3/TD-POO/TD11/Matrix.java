import java.awt.Dimension;

public class Matrix<T> {
    private T[][] data;

    protected boolean checkContent(T[][] data) { // mieux pour que les sous classes puissent l'utiliser
        return true;
    }

    public Matrix(T[][] t) throws InvalidContentException {
        if (!checkContent(t))
            throw new InvalidContentException(); // on peut mettre un message
        if (t.length == 0 || t[0].length == 0)
            throw new IllegalArgumentException();
        this.data = t;
    }

    public int nRows() {
        return data.length;
    }

    public int nCols() {
        return data[0].length;
    }

    // MatrixScanner est un Accumulator
    public <S> Accumulator<S> rowScanner(int i, AccFunction<S, T> f, S initAcc) {
        return new MatrixScanner<>(i, 0, 0, 1, f, initAcc); // on peut mettre un this
    }

    public <S> Accumulator<S> colsScanner(int j, AccFunction<S, T> f, S initAcc) {
        return new MatrixScanner<>(0, j, 1, 0, f, initAcc);
    }

    private class MatrixScanner<S> implements Accumulator<S> {
        private S acc; // valeur accumulé
        private int i; // coordonées de l'element actuellement lu
        private int j;
        private int di;
        private int dj;
        private AccFunction<S, T> f;

        private boolean checkIndex(int i, int j) {
            return !(i < 0 || j < 0 || i >= nRows() || j >= nCols());
        }

        public MatrixScanner(int i, int j, int di, int dj, AccFunction<S,T> f, S acc) {
            if (!checkIndex(i, j)) {
                throw new IllegalArgumentException();
            }
            this.i = i;
            this.j = j;
            this.di = di;
            this.dj = dj;
            this.f = f;
            this.acc = acc;
        }

        @Override
        public void accumulate(S e) {
            if(checkIndex(i, j)){
                acc=f.apply(acc,e,data[i][j]);
                i+=di;
                j+=dj;
            }
        }


        @Override
        public S read() {
            return acc;
        }

        @Override
        public boolean isOver() {
            return (i >= nRows() || j >= nCols());
        }
    }

}
