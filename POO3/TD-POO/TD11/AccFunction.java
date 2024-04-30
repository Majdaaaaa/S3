public interface AccFunction<S, T> {
    public S apply(S acc, S ext, T donnee);

}
