package oop.o_chapter_07;

/**
 * ログ出力機能を持つクラス。（メソッド参照のデモ用）
 */
public class Logger_0701 {
   
    /**
     * イベントをコンソールにログとして出力する静的(static)メソッド
     * @param message ログに出力するメッセージ
     */
    public static void log(String message) {
        System.out.println("[LOG] " + message);
    }
}