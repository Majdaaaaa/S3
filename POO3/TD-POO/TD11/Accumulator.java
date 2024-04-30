public interface Accumulator<S> {
    public void accumulate(S e); // accumule

    public S read(); // lis

    public boolean isOver(); // dis quand c fini
}