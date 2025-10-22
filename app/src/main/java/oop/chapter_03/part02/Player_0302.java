package oop.chapter_03.part02;

/**
 * Playerクラス：Drawableインタフェースを実装(implements)します。
 */
public class Player_0302 implements Drawable_0302 {
    private String name;
    public Player_0302(String name) { this.name = name; }

    // 契約(Drawable_0202)に従い、drawメソッドを必ず実装します。
    @Override
    public void draw() {
        System.out.println("プレイヤー '" + this.name + "' を画面に描画します。");
    }
}