package oop.o_chapter_08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 第8章: ストリーム API (Stream API)
 * ラムダ式を最大限に活用し、コレクションのデータを宣言的かつ流れるように処理する方法を学びます。
 */
public class App_0801 {

    public static void main(String[] args) {
        System.out.println("--- 第8章: ストリーム API (Stream API) ---");

        // --- 準備：プレイヤーのリストを作成 ---
        List<Player_0801> party = Arrays.asList(
            new Player_0801("アリス", "魔法使い", 75),
            new Player_0801("ボブ", "戦士", 45),
            new Player_0801("キャロル", "僧侶", 80),
            new Player_0801("デイブ", "戦士", 50),
            new Player_0801("イブ", "魔法使い", 95)
        );

        System.out.println("\n--- 元のデータ（プレイヤーリスト） ---");
        for (Player_0801 p : party) {
            System.out.println(p);
        }

        // --- 課題：「経験値50以上の魔法使い」の名前を大文字にして、新しいリストに格納する ---

        // --- 1. 従来のforループによる書き方 (ビフォー) ---
        System.out.println("\n--- 1. 従来のforループによる処理 ---");
        List<String> highexperienceWizards_for = new ArrayList<>();
        for (Player_0801 p : party) {
            if (p.job().equals("魔法使い") && p.experience() >= 50) {
                highexperienceWizards_for.add(p.name().toUpperCase());
            }
        }
        System.out.println("結果: " + highexperienceWizards_for);

        // --- 2. Stream APIによる書き方 (アフター) ---
        // ビデオシナリオ解説：工場の組立ラインのように、処理を連結していきます。
        System.out.println("\n--- 2. Stream APIによる処理 ---");

        List<String> highExperienceWizards_stream = party.stream() // ① 生成: ベルトコンベアを起動

            // --- ② 中間処理 (Intermediate Operations) ---
            // ビデオシナリオ解説：ライン上の作業ステーション。複数連結できます。
            .filter(p -> p.job().equals("魔法使い")) // 絞り込み(品質検査): 「魔法使い」だけを通す
            .filter(p -> p.experience() >= 50)               // 絞り込み(品質検査): 「経験値50以上」だけを通す
            .sorted((p1, p2) -> Integer.compare(p2.experience(), p1.experience())) // 中間処理の追加: 経験値降順で並び替え
            .map(p -> p.name().toUpperCase())           // 変換(塗装): Playerオブジェクトを「大文字の名前(String)」に変換

            // --- ③ 終端処理 (Terminal Operation) ---
            // ビデオシナリオ解説：ラインの終点で完成品を箱詰めするイメージ。
            .collect(Collectors.toList());              // 結果を新しいListにまとめる

        System.out.println("結果: " + highExperienceWizards_stream);


        System.out.println("\n--- reduce: 合計値を計算する終端処理 ---");
        // reduce: 合計値を計算
        // `reduce`は、ストリームの要素を一つずつ取り出し、演算を繰り返して一つの結果にまとめます。
        // ビデオシナリオ解説：
        // (0, 1500) -> 1500
        // (1500, 1200) -> 2700
        // (2700, 1800) -> 4500  という流れです。

        // `reduce(初期値, (累積値, 要素) -> 新しい累積値)`
        int totalExperience = party.stream()
            .map(player -> player.experience()) // プレイヤーの経験値(Integer)のストリームに変換
            .reduce(0, (subtotal, experience) -> subtotal + experience);

        System.out.println("パーティの総経験値: " + totalExperience);

        // メソッド参照を使うとさらに簡潔に書けます
        int totalExperience2 = party.stream()
            .mapToInt(player -> player.experience()) // IntStreamを使うとより効率的
            .sum(); // sum()はreduceの一種です

        System.out.println("パーティの総経験値 (sum()を使用): " + totalExperience2);

        // --- reduceで最も名前が長いプレイヤーを探す ---
        party.stream()
            .reduce((p1, p2) -> p1.name().length() > p2.name().length() ? p1 : p2)
            .ifPresent(p -> System.out.println("最も名前が長いプレイヤー: " + p.name()));

        System.out.println("\n--- 補足: その他の便利な終端処理 ---");
        // forEach: 各要素に対して処理を実行
        System.out.print("経験値80以上のプレイヤー名: ");
        party.stream()
            .filter(p -> p.experience() >= 80)
            .forEach(p -> System.out.print(p.name() + " "));
        System.out.println();

        // count: 条件に合う要素の数を数える
        long warriorCount = party.stream()
            .filter(p -> "戦士".equals(p.job()))
            .count();
        System.out.println("戦士の人数: " + warriorCount + "人");

        // findFirst: 最初に見つかった要素を取得 (Optionalで返される)
        // Optionalは、nullかもしれない値を安全に扱うための箱です（第9章で詳解）。
        party.stream()
            .filter(p -> p.experience() < 50)
            .findFirst()
            .ifPresent(p -> System.out.println("最初に見つかった経験値50未満のプレイヤー: " + p));

    }
}