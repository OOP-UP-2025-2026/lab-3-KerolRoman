public class Box {
    private double l;
    private double w;
    private double h;

    public Box(double l, double w, double h) {
        setL(l);
        setW(w);
        setH(h);
    }

    private void setL(double l) {
        if (l <= 0) {
            throw new IllegalArgumentException("Довжина повинна бути більше нуля!");
        }
        this.l = l;
    }

    private void setW(double w) {
        if (w <= 0) {
            throw new IllegalArgumentException("Ширина повинна бути більше нуля!");
        }
        this.w = w;
    }

    private void setH(double h) {
        if (h <= 0) {
            throw new IllegalArgumentException("Висота повинна бути більше нуля!");
        }
        this.h = h;
    }

    public double getSurfaceArea() {
        return 2 * (l * w + l * h + w * h);
    }

    public double getLateralSurfaceArea() {
        return 2 * l * h + 2 * w * h;
    }

    public double getVolume() {
        return l * w * h;
    }

    public static void main(String[] args) {
        Box box = new Box(3, 4, 5);
        System.out.printf("Площа поверхні: %.2f%n", box.getSurfaceArea());
        System.out.printf("Площа бічної поверхні: %.2f%n", box.getLateralSurfaceArea());
        System.out.printf("Об’єм: %.2f%n", box.getVolume());
    }
}
