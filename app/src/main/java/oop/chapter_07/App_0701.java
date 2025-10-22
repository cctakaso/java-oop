package oop.chapter_07;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 第7章: 関数型インタフェースとラムダ式
 * 無名クラス、ラムダ式、メソッド参照という記述方法の進化を学びます。
 */
public class App_0701 {

    /**
     * 指定されたイベントハンドラを実行するメソッド
     * @param eventName イベント名
     * @param handler 実行するイベント処理の実体
     */
    public static void triggerEvent(String eventName, EventHandler_0701 handler) {
        System.out.print("イベント発生: " + eventName + " -> ");
        handler.handle(eventName);
    }

    public static void main(String[] args) {
        System.out.println("--- 第7章: 関数型インタフェースとラムダ式 ---");

        // --- 1. 無名クラス (ビフォー) ---
        // ビデオシナリオ解説：やりたいことは`handle`メソッドの中身だけなのに、お決まりの記述が多い。
        System.out.println("\n--- 1. 無名クラスによる実装 ---");
        EventHandler_0701 anonymousHandler = new EventHandler_0701() {
            @Override
            public void handle(String eventName) {
                System.out.println("無名クラスがイベントを処理しました。");
            }
        };
        triggerEvent("処理開始", anonymousHandler);

        // --- 2. ラムда式 (アフター) ---
        // ビデオシナリオ解説：無名クラスの冗長な部分を削ぎ落とし、本質だけを記述する。
        // (引数リスト) -> { 処理本体 }
        System.out.println("\n--- 2. ラムダ式による実装 ---");
        EventHandler_0701 lambdaHandler = (eventName) -> {
            System.out.println("ラムダ式が「" + eventName + "」イベントを処理しました。");
        };
        triggerEvent("データ保存", lambdaHandler);

        // --- ラムダ式の省略記法 ---
        // ビデオシナリオ解説：特定の条件でさらに短く書くことができます。
        System.out.println("\n--- ラムダ式の省略記法 ---");
        // 処理が1行だけの場合、`{}`と`;`を省略できる
        EventHandler_0701 singleLineLambda = (eventName) -> System.out.println("省略形のラムダ式が処理。");
        triggerEvent("描画更新", singleLineLambda);

        // --- 3. メソッド参照 (究極の省略形) ---
        // ビデオシナリオ解説：ラムダ式の処理が「すでにあるメソッドを呼び出すだけ」の場合に使える。
        // クラス名::メソッド名
        System.out.println("\n--- 3. メソッド参照による実装 ---");
        // `(eventName) -> Logger_0601.log(eventName)` というラムダ式と等価です。
        EventHandler_0701 methodRefHandler = Logger_0701::log;
        triggerEvent("処理完了", methodRefHandler);

        // --- 補足：標準で用意されている関数型インタフェース  ---
        System.out.println("\n--- 補足: 標準の関数型インタフェース ---");

        // Predicate<T>: T型を受け取り、booleanを返す (例: 条件判定)
        Predicate<String> isLongText = (text) -> text.length() > 10;
        System.out.println("'JavaScript'は10文字より長いですか？ -> " + isLongText.test("JavaScript")); // false

        // Function<T, R>: T型を受け取り、R型を返す (例: 値の変換)
        Function<String, Integer> wordLengthCounter = (text) -> text.length();
        System.out.println("'Java'の文字数は？ -> " + wordLengthCounter.apply("Java")); // 4
    }
}