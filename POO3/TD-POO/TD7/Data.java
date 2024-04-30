public class Data {
    private final static int SIZE = 16;
    private Integer[] array = new Integer[SIZE];

    public Data() {
        for (int i = 0; i < SIZE; i++) {
            array[i] = Integer.valueOf(i);
        }
    }

    private interface DataIterator extends java.util.Iterator<Integer> {
    }

    private class EvenIterator implements DataIterator {
        int i = 0;

        @Override
        public boolean hasNext() {
            return i < SIZE;
        }

        @Override
        public Integer next() {
            Integer retValue = Data.this.array[i];
            i += 2;
            return retValue;
        }
    }

    private void print(DataIterator i) {
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
        System.out.println();
    }

    public void printEven() {
        print(new EvenIterator());
    }

    public void printOdd() {
        class oddIterator implements DataIterator {
            int i = 1;

            @Override
            public boolean hasNext() {
                return i < SIZE;
            }

            @Override
            public Integer next() {
                Integer retValue = Data.this.array[i];
                i += 2;
                return retValue;
            }
        }
        print(new oddIterator());
    }

    public void printBackwards() {
        DataIterator it = new DataIterator() {
            int i = SIZE - 1;

            @Override
            public boolean hasNext() {
                return i >= 0 ;
            }

            @Override
            public Integer next() {
                Integer retValue = array[i];
                i--;
                return retValue;
            }
        };
        print(it);
    }
}
