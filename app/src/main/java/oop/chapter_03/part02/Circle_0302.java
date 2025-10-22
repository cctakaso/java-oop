package oop.chapter_03.part02;

/**
 * 具象クラス：Circle（円）
 * 抽象クラス Shape_0202 を継承し、`getArea`メソッドの具体的な計算方法を実装します。
 */
public class Circle_0302 extends Shape_0302 {
    private double radius; // 半径

    public Circle_0302(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return this.radius * this.radius * Math.PI;
    }
}