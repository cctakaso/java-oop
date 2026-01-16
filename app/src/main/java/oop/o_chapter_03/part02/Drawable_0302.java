package oop.o_chapter_03.part02;

/**
 * インタフェース：Drawable（描画可能）
 * `interface`は、クラスが実装すべき「機能の契約(ルール)」を定めます。
 * 「描画できる」という機能(`can-do関係`)を表現します。
 */
@FunctionalInterface // 抽象メソッドが一つだけであることを示すアノテーション
public interface Drawable_0302 {
   
    // インタフェース内のメソッドは、自動的に `public abstract` になります。
    void draw();
}