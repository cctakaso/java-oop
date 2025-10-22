package oop.chapter_03.part02;

/**
 * 具象クラス：Rectangle（長方形）
 */
public class Rectangle_0302 extends Shape_0302 {
    private double width;  // 幅
    private double height; // 高さ

    public Rectangle_0302(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return this.width * this.height;
    }
}