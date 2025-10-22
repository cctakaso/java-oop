package oop.chapter_09.part01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 第9章 Part 1: try-catch-finally 〜伝統的なエラーハンドリング〜
 */
public class App_0901 {

    // 4. `throws`キーワード：このメソッドは`InvalidAgeException`を投げる可能性がある、と宣言
    public static void checkAge(int age) throws InvalidAgeException_0901 {
        if (age < 0) {
            // 3. `throw`キーワード：意図的に例外インスタンスを「投げる」
            throw new InvalidAgeException_0901("年齢に負の値は設定できません。");
        }
        System.out.println(age + "歳は有効な年齢です。");
    }

    public static void main(String[] args) {
        System.out.println("--- 第9章 Part 1: try-catch-finally ---");

        // --- 1. try-catch ---
        // ビデオシナリオ解説：例外が発生するかもしれない危険な処理を安全に実行する構文。
        System.out.println("\n--- 1. try-catchによる例外処理 ---");
        try {
            System.out.println("try: 存在しないファイルを読み込みます...");
            FileReader reader = new FileReader("存在しないファイル.txt"); // ここで例外が発生！
            System.out.println("try: この行は実行されません。"); // 例外発生後、即catchへ飛ぶ
        } catch (FileNotFoundException e) {
            // `try`ブロックで`FileNotFoundException`が発生した場合に、このブロックが実行される
            System.out.println("catch: ファイルが見つかりませんでした。プログラムは続行します。");
        }
        System.out.println("try-catchブロックの外：プログラムはクラッシュせずにここまで到達しました。");


        // --- 2. finally ---
        // ビデオシナリオ解説：例外の有無に関わらず「必ず最後に実行される」後片付け処理。
        System.out.println("\n--- 2. finallyによる後片付け ---");
        BufferedReader br = null; // `try`の外で宣言しないと`finally`から見えない
        try {
            // このデモでは、ファイルは存在するものとします（事前に作成してください）
            br = new BufferedReader(new FileReader("dummy.txt"));
            System.out.println("try: ファイルを開きました。");
            // ...ここで何らかの処理...
            // わざと例外を発生させてみる
            if (true) { throw new IOException("読み込み中に問題が発生！"); }
        } catch (IOException e) {
            System.out.println("catch: " + e.getMessage());
        } finally {
            System.out.println("finally: 後片付け処理を実行します。");
            if (br != null) {
                try {
                    br.close(); // close()自体も例外を投げる可能性がある
                    System.out.println("finally: ファイルを閉じました。");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // --- 3 & 4. throw と throws ---
        System.out.println("\n--- 3, 4. throw/throwsによる例外の送出と処理 ---");
        try {
            checkAge(25);
            checkAge(-10); // この呼び出しで例外が投げられる
        } catch (InvalidAgeException_0901 e) {
            System.out.println("catch: カスタム例外をキャッチしました -> " + e.getMessage());
        }

        // --- 5. チェック例外 vs 非チェック例外 ---
        System.out.println("\n--- 5. チェック例外と非チェック例外 ---");
        // 5a. チェック例外 (Checked Exception)
        // `FileReader`は`FileNotFoundException`(チェック例外)を投げる可能性がある。
        // そのため、コンパイラは`try-catch`か`throws`を「強制」する。書かないとコンパイルエラー。
        System.out.println("チェック例外: FileReaderのように、コンパイラが対処を強制する例外。");

        // 5b. 非チェック例外 (Unchecked Exception)
        // `NullPointerException`や`ArrayIndexOutOfBoundsException`など。
        // これらはプログラマのバグが原因なので、コンパイラは`try-catch`を強制しない。
        // 「備える」のではなく「バグを直せ」というメッセージ。
        String text = null;
        // text.length(); // この行を実行すると、`NullPointerException`でプログラムがクラッシュする！
        System.out.println("非チェック例外: NullPointerExceptionのように、プログラマのバグが原因の例外。");
    }
}