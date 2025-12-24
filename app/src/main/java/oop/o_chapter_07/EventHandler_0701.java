package oop.o_chapter_07;

/**
 * 関数型インタフェース (Functional Interface)
 * ビデオシナリオ解説：
 * ラムダ式を記述するためには、実装すべき「抽象メソッドが一つだけ」というルールを持つ
 * このようなインタフェースが必要です。
 *
 * `@FunctionalInterface`アノテーションは、このインタフェースが関数型インタフェースの
 * ルールに従っているかをコンパイラにチェックさせるための目印です。
 */
@FunctionalInterface
public interface EventHandler_0701 {
    // このインタフェースが持つ、唯一の抽象メソッド
    void handle(String eventName);
}