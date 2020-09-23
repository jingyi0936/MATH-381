class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Line {
    Point A;
    Point B;

    public Line(Point A, Point B) {
        this.A = A;
        this.B = B;
    }
}

class EquilateralTriangle {
    Point A;
    Point B;
    Point C;

    public EquilateralTriangle() {
        // Construct a random point somewhere within our plane
        A = new Point(Math.random() * 4.0, Math.random() * 4.0);

        // Generate B which is horizontal to A to construct the Vector AB
        B = new Point((.5 - A.x) / -1, A.y);

        // Now we will Generate C via a 120 degree angle from A - In Radians
        double theta = (Math.PI * 120) / 180;
        C = new Point(A.x + .5 * Math.cos(theta), B.y - .5 * Math.sin(theta));
    }
}