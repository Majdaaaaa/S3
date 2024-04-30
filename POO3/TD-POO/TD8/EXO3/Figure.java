package EXO3;
public abstract class Figure {
    private double centreX, centreY;

    public Figure(double x, double y) {
        this.centreX = x;
        this.centreY = y;
    }
    public abstract boolean contient(Figure f);
    public abstract Figure intersection(Figure f);
    public double getCentreX() {
        return centreX;
    }
    public double getCentreY() {
        return centreY;
    }
}