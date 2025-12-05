package oop.chapter_05;

import java.util.Random;
//import java.util.concurrent.ThreadLocalRandom; // Randomクラスを使うためにインポート

/**
 * 第5章 Part 1: 基本型とラッパークラス、数値の扱い
 */
public class App_0501 {

    public static void main(String[] args) {
        System.out.println("--- 第5章 Part 1: 基本型とラッパークラス、数値の扱い ---");

        // --- 1. 基本型 (Primitive Types) ---
        // Java言語に元から組み込まれている基本的なデータ型。非常に高速に動作します。
        int a = 10;
        double b = 3.14;
        boolean c = true;

        // --- 2. ラッパークラス (Wrapper Classes) ---
        // ビデオシナリオ解説：基本型を綺麗な箱（オブジェクト）に入れて、便利な機能（メソッド）を付けたもの。
        // 基本型とラッパークラス間の変換は、Javaが自動で行います（オートボクシング／アンボクシング）。

        // 基本型(int)からラッパークラス(Integer)へ自動変換（オートボクシング）
        Integer aWrapper = a;

        // ラッパークラスから基本型へ自動変換（オートアンボクシング）
        int aPrimitive = aWrapper;

        System.out.println("基本型のint: " + aPrimitive);
        System.out.println("ラッパークラスのInteger: " + aWrapper);

        // ラッパークラスはオブジェクトなので、`null`（空っぽ）を代入できる
        Integer nullableInteger = null;
        System.out.println("nullのラッパークラス: " + nullableInteger);
        // int nonNullableInt = null; // 基本型にnullは代入できず、コンパイルエラーになる

        // ラッパークラスが持つ便利なメソッドの例
        String numberStr = "123";
        int parsedInt = Integer.parseInt(numberStr); // 文字列をint型に変換
        System.out.println("文字列\"" + numberStr + "\"をパースした結果: " + parsedInt);

        // --- 3. Mathクラス ---
        // ビデオシナリオ解説：数値計算に役立つ便利な道具箱。`new` せずに直接使えます。
        System.out.println("\n--- 魔法の計算(Mathクラス) ---");
        System.out.println("-100の絶対値: " + Math.abs(-100));
        System.out.println("5と10のうち大きい方: " + Math.max(5, 10));
        System.out.println("3.14を四捨五入: " + Math.round(3.14));
        System.out.println("3.14の小数点以下を切り上げ: " + Math.ceil(3.14));

        // --- 4. Randomクラス ---
        // ビデオシナリオ解説：ランダムな数（乱数）を作り出すための道具。
        System.out.println("\n--- 運命のサイコロ(Randomクラス) ---");

        // 4a. お手軽な方法: Math.random()
        // 0.0以上、1.0未満のdouble値を返す
        double randomDouble = Math.random();
        //double randomDouble = ThreadLocalRandom.current().nextDouble();
        // 現在のスレッドから独立した隔離された乱数ジェネレータ。 
        // Mathクラスによって使用されるグローバルなRandomジェネレータと同様に、
        // ThreadLocalRandomは、それ以外では変更できない内部的に生成されたシードで初期化されます。 
        // 該当する場合、並行プログラム内の共有されたRandomオブジェクトではなくThreadLocalRandomを使用すれば、
        // 通常、発生するオーバーヘッドや競合がはるかに少なくなります。
        System.out.println("Math.random()の結果: " + randomDouble);

        // 4b. 高機能な方法: java.util.Randomクラス（こちらが推奨）
        Random randomGenerator = new Random();

        // 6面のサイコロを振る (0〜5の乱数を生成し、それに1を足す)
        int diceRoll = randomGenerator.nextInt(6) + 1;
        System.out.println("サイコロを振った！ " + diceRoll + " の目が出た！");
    }
}