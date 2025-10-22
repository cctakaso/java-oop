package oop.chapter_11;

/**
 * 古い機能を持つクラス。（@Deprecated のデモ用）
 */
public class LegacyFeature_1101 {
   
    /**
     * ビデオシナリオ解説：
     * `@Deprecated`は「非推奨」を意味します。
     * 「このメソッドは古いので、新しい方法を使ってください」と他の開発者に伝えるためのラベルです。
     */
    @Deprecated
    public void oldMethod() {
        System.out.println("これは古いメソッドです。");
    }

    public void newMethod() {
        System.out.println("こちらが新しいメソッドです。");
    }
}