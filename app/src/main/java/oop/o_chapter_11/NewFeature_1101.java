package oop.o_chapter_11;

/**
 * 新しい機能を持つクラス。カスタムアノテーションが付与されています。
 */
@ReleaseInfo_1101(author = "Alice", status = "Reviewed")
public class NewFeature_1101 {

    @ReleaseInfo_1101(author = "Bob", version = "1.1", status = "Ready for Release")
    public void readyMethod() {
        System.out.println("このメソッドはリリース準備完了です。");
    }

    @ReleaseInfo_1101(author = "Alice", status = "In Development")
    public void wipMethod() { // WIP = Work In Progress (作業中)
        System.out.println("このメソッドはまだ開発中です。");
    }

    public void unannotatedMethod() {
        System.out.println("このメソッドにはアノテーションが付いていません。");
    }
}