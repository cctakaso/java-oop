package oop.o_chapter_03.part01;

/**
 * 第3章 Part 1: オーバーロードとオーバーライド
 * ポリモーフィズム（多態性）の2つの主要な実現方法を学びます。
 */
public class App_0301 {
    public static void main(String[] args) {
        System.out.println("--- 第3章 Part 1: ポリモーフィズム ---");

        // --- オーバーロード (Overload) ---
        // ビデオシナリオ解説：同じ「攻撃」という目的でも、やり方が色々あるイメージ。
        // 渡す引数の形に応じて、Javaが賢く適切なメソッドを選んでくれます。
        System.out.println("\n--- オーバーロードのデモ ---");
        GameCharacter_0301 hero = new GameCharacter_0301("勇者");
        hero.attack();
        hero.attack("ドラゴン");
        hero.attack("ドラゴン", "メラゾーマ");

        // --- オーバーライド (Override) と ポリモーフィズム ---
        // ビデオシナリオ解説：リモコンの「再生ボタン」と同じ！
        // 同じ「鳴いて！」という命令でも、相手（実体）によって振る舞いが変わります。
        System.out.println("\n--- オーバーライドとポリモーフィズムのデモ ---");

        // 変数の型はすべて親クラスの`Animal_0201`に統一。
        // しかし、中身の実体はそれぞれ `Dog_0201` と `Cat_0201`。
        Animal_0301 myPet1 = new Dog_0301("ポチ");
        Animal_0301 myPet2 = new Cat_0301("タマ");

        // 配列にまとめて、同じ命令 `cry()` を実行してみる
        Animal_0301[] pets = { myPet1, myPet2 };

        for (Animal_0301 pet : pets) {
            // `pet.cry()` という全く同じ呼び出し方をしているにも関わらず、
            // Javaは変数の「中身の実体」をちゃんと見て、
            // それぞれのクラスでオーバーライドされた正しいメソッドを呼び出してくれます。
            pet.cry();
        }
    }
}