package oop.chapter_09.part01;

/**
 * 自作の例外クラス（カスタム例外）
 * `Exception`クラスを継承することで、独自の例外を定義できます。
 * これは「チェック例外」として扱われます。
 */
public class InvalidAgeException_0901 extends Exception {
    public InvalidAgeException_0901(String message) {
        // 親クラスであるExceptionのコンストラクタを呼び出し、エラーメッセージを設定
        super(message);
    }
}