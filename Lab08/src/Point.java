public final class Point {
    public final double x;
    public final double y;
    public final double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String toString() {
        return x + ", " + y + ", " + z;
    }

    public boolean equals(Object other) {
        return other instanceof Point
                && ((Point) other).x == this.x
                && ((Point) other).y == this.y
                && ((Point) other).z == this.z;
    }
//
//    public int hashCode() {
//        int result = 17;
//        result = result * 31 + x;
//        result = result * 31 + y;
//        result = result * 31 + z;
//        return result;
//    }

}