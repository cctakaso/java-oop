package oop.o_chapter_01.part01;

/**
 * 第1章 Part 1: クラスとインスタンス
 * 設計図(クラス)から、実際に動くキャラクター(インスタンス)を生み出し、冒険を始めましょう！
 */
public class App_0101 {

    public static void main(String[] args) {
        System.out.println("--- 第1章 Part 1: クラスとインスタンス ---");
        System.out.println("冒険の書を開きました。");

        // --- インスタンス化 (Instantiation) ---
        // `new` キーワードを使い、Character_0101という「設計図」から、
        // `hero` と `warrior` という2人の「実体（インスタンス）」を生み出します。
        // ビデオシナリオ解説：設計図は一つでも、赤い車、青い車...とたくさんの実体を作れるのと同じです。

        // 1. 勇者(hero)インスタンスを生成
        Character_0101 hero = new Character_0101();

        // 2. heroインスタンスのフィールド（状態）に具体的な値を設定
        hero.name = "アベル";
        hero.hp = 120;
        hero.level = 5;

        // 3. 戦士(warrior)インスタンスを生成
        // `hero` と `warrior` は、同じ設計図から生まれましたが、全く別の存在です。
        Character_0101 warrior = new Character_0101();

        // 4. warriorインスタンスのフィールドに値を設定
        warrior.name = "ベス";
        warrior.hp = 150;
        warrior.level = 4;

        System.out.println("\n新たな仲間が加わった！");

        // 5. それぞれのインスタンスのメソッド（振る舞い）を呼び出す
        hero.introduce();
        warrior.introduce();

        System.out.println("\n魔物が現れた！");
        hero.attack("スライム");
        warrior.attack("ゴブリン");

        // 6. 静的(static)フィールドへのアクセス
        // `static`なフィールドは、インスタンスではなくクラスに紐づきます。
        // 「クラス名.フィールド名」でアクセスするのが一般的です。
        System.out.println("\n我々のパーティ名は「" + Character_0101.partyName + "」だ！");
    }
}
