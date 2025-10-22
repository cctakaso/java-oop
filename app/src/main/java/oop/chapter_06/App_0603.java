package oop.chapter_06;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 第6章 Part 3: Map
 */
public class App_0603 {
    public static void main(String[] args) {
        System.out.println("--- 第6章 Part 3: Map ---");

        // --- 1. HashMap ---
        // ビデオシナリオ解説：キーと値のペアを管理する辞書のようなコレクション。
        // <キーの型, 値の型> をジェネリクスで指定する。
        System.out.println("\n--- HashMap（どうぐぶくろ） ---");
        Map<String, Integer> itemPouch = new HashMap<>();

        // `put(キー, 値)` で要素を追加
        itemPouch.put("やくそう", 5);
        itemPouch.put("どくけしそう", 2);
        itemPouch.put("せいすい", 1);

        System.out.println("「やくそう」を拾った！");
        int currentHerbs = itemPouch.get("やくそう");
        itemPouch.put("やくそう", currentHerbs + 1); // 同じキーでputすると値が上書きされる

        // `get(キー)` で値を取得
        System.out.println("現在の「やくそう」の所持数: " + itemPouch.get("やくそう"));
        // 存在しないキーでgetすると `null` が返る
        System.out.println("「せかいじゅのは」の所持数: " + itemPouch.get("せかいじゅのは"));

        // --- 2. Mapのループ処理 ---
        // ビデオシナリオ解説：`keySet()`でキーの一覧(Set)を取得し、それをループさせるのが基本。
        System.out.println("\n【どうぐぶくろの中身】（順序は保証されない）");
        Set<String> itemNames = itemPouch.keySet();
        for (String itemName : itemNames) {
            int quantity = itemPouch.get(itemName);
            System.out.println(" - " + itemName + ": " + quantity + "個");
        }

        // 副読本 p.42: `entrySet()` を使うと、キーと値のペアを同時に取り出せて効率が良い
        System.out.println("\n【どうぐぶくろの中身 (entrySet版)】");
        for (Map.Entry<String, Integer> entry : itemPouch.entrySet()) {
            System.out.println(" - " + entry.getKey() + ": " + entry.getValue() + "個");
        }

        // --- 3. TreeMap ---
        // ビデオシナリオ解説：キーによって自動的にソートされるMap。
        System.out.println("\n--- TreeMap（整理されたどうぐぶくろ） ---");
        Map<String, Integer> sortedPouch = new TreeMap<>();
        sortedPouch.put("やくそう", 6);
        sortedPouch.put("どくけしそう", 2);
        sortedPouch.put("せいすい", 1);

        System.out.println("【整理されたどうぐぶくろの中身】（キーの辞書順）");
        for (String itemName : sortedPouch.keySet()) {
            System.out.println(" - " + itemName + ": " + sortedPouch.get(itemName) + "個");
        }
    }
}