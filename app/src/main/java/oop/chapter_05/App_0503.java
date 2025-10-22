package oop.chapter_05;

import java.util.Arrays; // Arraysクラスをインポート

/**
 * 第5章 Part 3: 配列と列挙型
 */
public class App_0503 {
    public static void main(String[] args) {
        System.out.println("--- 第5章 Part 3: 配列と列挙型 ---");

        // --- 1. 配列 (Array) ---
        // ビデオシナリオ解説：同じ型のデータを、複数まとめて格納できるオブジェクト。
        System.out.println("\n--- 配列 ---");

        // 生成と同時に値を初期化
        String[] partyMembers = {"勇者", "戦士", "魔法使い", "僧侶"};

        // インデックス(0から始まる番号)を使って要素にアクセス
        System.out.println("パーティのリーダーは " + partyMembers[0] + " です。");
        System.out.println("パーティの人数は " + partyMembers.length + " 人です。");

        // 配列の中身をそのまま表示しようとすると...？
        System.out.println("そのまま表示: " + partyMembers); // 謎の文字列が表示される

        // 正しくは `Arrays.toString()` を使う
        System.out.println("Arrays.toString()で表示: " + Arrays.toString(partyMembers));

        // 配列の並び替え
        Arrays.sort(partyMembers);
        System.out.println("名前順に並び替え: " + Arrays.toString(partyMembers));

        // --- 2. 列挙型 (Enum) ---
        // ビデオシナリオ解説：決まった選択肢を安全に扱う仕組み。
        System.out.println("\n--- 列挙型 ---");

        // 列挙型の変数を宣言し、値を代入
        GameDifficulty_0503 currentDifficulty = GameDifficulty_0503.NORMAL;

        // 列挙型の比較は `==` で安全に行える
        if (currentDifficulty == GameDifficulty_0503.NORMAL) {
            System.out.println("現在の難易度は「" + currentDifficulty.getDisplayName() + "」です。");
        }

        // `switch`文との相性が非常に良い
        switch (currentDifficulty) {
            case EASY:
                System.out.println("敵のHPが半分になります。");
                break;
            case NORMAL:
                System.out.println("標準のバランスでゲームを開始します。");
                break;
            case HARD:
                System.out.println("敵が強力になり、獲得経験値が増えます。");
                break;
        }

        // 列挙型の便利なメソッド
        System.out.println("\n--- 全ての難易度を一覧表示 ---");
        for (GameDifficulty_0503 diff : GameDifficulty_0503.values()) {
            System.out.println(
                "定数名: " + diff.name() +
                ", 順番: " + diff.ordinal() +
                ", 表示名: " + diff.getDisplayName()
            );
        }
    }
}