package oop.chapter_03.part02;

/**
 * Mapクラス：こちらもDrawableインタフェースを実装します。
 * Playerとは親子関係にありませんが、「描画できる」という同じ機能を持ちます。
 */
public class Map_0302 implements Drawable_0302 {
   
    @Override
    public void draw() {
        System.out.println("ゲームのワールドマップを描画します。");
    }
}