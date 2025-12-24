package oop.o_chapter_03.part02;

/**
 * 抽象クラス：Shape（図形）
 * 「図形」という概念は抽象的で、それ単体では面積を計算できません。
 * `is-a関係`（例：円は図形の一種）を表現するのに適しています。
 */
public abstract class Shape_0302 {
   
    // 抽象メソッド
    // `abstract`な`getArea`メソッドは、「図形なら面積を計算できるべきだ」というルールだけを定めます。
    // 具体的な計算方法は、このクラスを継承する子クラスが実装する責任を負います。
    public abstract double getArea();

    // 具象メソッド
    // 抽象クラスは、共通の具体的な処理を持つこともできます。
    public void display() {
        System.out.println("図形の面積は " + getArea() + " です。");
    }
}