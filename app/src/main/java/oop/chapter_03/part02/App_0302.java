package oop.chapter_03.part02;

/**
 * 第3章 Part 2: 抽象クラスとインタフェース
 * ポリモーフィズムを支える「抽象化」の概念を、2つのツールを通じて学びます。
 */
public class App_0302 {
    public static void main(String[] args) {
        System.out.println("--- 第3章 Part 2: 抽象化 ---");

        // --- 抽象クラス (is-a関係: 〜は〜の一種である) ---
        System.out.println("\n--- 抽象クラスのデモ ---");

        // Shape_0202 shape = new Shape_0202(); // コンパイルエラー！抽象クラスは未完成な設計図なのでnewできない。

        // Shape_0202型の配列に、具体的な図形(Circle, Rectangle)を入れる
        Shape_0302[] shapes = {
            new Circle_0302(10.0),      // 円は図形の一種 (Circle is a Shape)
            new Rectangle_0302(5.0, 8.0) // 長方形は図形の一種 (Rectangle is a Shape)
        };

        // 各図形の`display`メソッドを呼び出す
        for (Shape_0302 s : shapes) {
            // 同じ `s.display()` という呼び出しでも、
            // 実体がCircleかRectangleかによって、内部で呼び出される`getArea()`が変わり、結果が変わる。
            s.display();
        }

        // --- インタフェース (can-do関係: 〜ができる) ---
        System.out.println("\n--- インタフェースのデモ ---");

        // `Drawable_0202`（描画できるもの）を実装したオブジェクトの配列
        Drawable_0302[] drawables = {
            new Player_0302("勇者"),
            new Map_0302()
        };

        // `drawOnScreen`メソッドは、相手がPlayerかMapかを知らなくても、
        // 「Drawableである(描画できる)」ことさえ知っていれば、`draw()`メソッドを呼び出せる。
        // これもポリモーフィズムの力です。
        for (Drawable_0302 item : drawables) {
            drawOnScreen(item);
        }
    }
   
    /**
     * Drawableインタフェースを実装したオブジェクトなら、何でも描画できるメソッド
     */
    public static void drawOnScreen(Drawable_0302 item) {
        System.out.print("描画命令: ");
        item.draw();
    }
}