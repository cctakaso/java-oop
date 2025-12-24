package oop.o_chapter_01.part03;

/**
 * 第1章 Part 3: コンストラクタとガベージコレクション(GC)
 * `new` の瞬間に「準備万端」なインスタンスを作る方法を学びます。
 */
public class App_0103 {

    public static void main(String[] args) {
        System.out.println("--- 第1章 Part 3: コンストラクタ ---");
        System.out.println("お店を開店します。商品を陳列しましょう。");

        // 1. 引数付きコンストラクタを使用
        // `new` の一行で、インスタンスの生成と初期化が同時に完了します。
        System.out.println("\n--- ポーションを陳列 ---");
        Item_0103 potion = new Item_0103("ポーション", 50);
        potion.displayInfo();

        // 2. もう一つの商品を陳列
        System.out.println("\n--- 剣を陳列 ---");
        Item_0103 sword = new Item_0103("ひのきのぼう", 120);
        sword.displayInfo();

        // 3. 引数なしコンストラクタを使用
        // Item_0103クラスに引数なしコンストラクタが明示的に定義されているため、この呼び出しが可能です。
        System.out.println("\n--- 見切品を陳列 ---");
        Item_0103 unknownItem = new Item_0103();
        unknownItem.displayInfo();

        // --- ガベージコレクション (GC) ---
        // ビデオシナリオ解説：
        // Javaでは、`potion` や `sword` のような使われなくなったインスタンスは、
        // ガベージコレクション(GC)という仕組みが自動的に検出し、メモリから解放してくれます。
        // プログラマが明示的にインスタンスを破棄する必要はありません。
    }
}