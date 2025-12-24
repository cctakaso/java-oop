package oop.o_chapter_06;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App_0604 {

    // 2. 境界ワイルドカード
    // `List<? extends Number>` と書くことで、`Number`とその子クラス(Integer, Doubleなど)の
    // リストなら何でも受け取れる、柔軟なメソッドになります。
    public static double sumOfList(List<? extends Number> list) {
        double sum = 0.0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("--- 第6章 Part 4: ジェネリクスの深掘りと便利機能 ---");

        // --- 1. 自作ジェネリッククラス ---
        System.out.println("\n--- 自作ジェネリッククラス ---");
        // String専用のツールボックス
        Toolbox_0604<String> stringToolbox = new Toolbox_0604<>();
        stringToolbox.setItem("ハンマー");
        System.out.println("道具箱の中身: " + stringToolbox.getItem());

        // Integer専用のツールボックス
        Toolbox_0604<Integer> intToolbox = new Toolbox_0604<>();
        intToolbox.setItem(100);
        System.out.println("道具箱の中身: " + intToolbox.getItem());


        // --- 2. 境界ワイルドカードのデモ ---
        System.out.println("\n--- 境界ワイルドカード ---");
        List<Integer> intList = List.of(1, 2, 3, 4, 5);
        List<Double> doubleList = List.of(1.1, 2.2, 3.3);

        System.out.println("Integerリストの合計: " + sumOfList(intList));
        System.out.println("Doubleリストの合計: " + sumOfList(doubleList));


        // --- 3. 不変コレクション ---
        // ビデオシナリオ解説：`List.of()` などで、中身を変更できない安全なコレクションを簡単に作れる。
        System.out.println("\n--- 不変コレクション ---");

        List<String> starterKit = List.of("やくそう", "どくけしそう", "キメラのつばさ");
        System.out.println("冒険の初期装備: " + starterKit);

        try {
            // 不変リストに要素を追加しようとすると、実行時エラー(UnsupportedOperationException)が発生！
            starterKit.add("てつのやり");
        } catch (UnsupportedOperationException e) {
            System.out.println("エラー: 不変コレクションは変更できません！");
        }

        Set<String> uniqueSkills = Set.of("剣術", "魔法", "盗む");
        Map<String, String> capitalCities = Map.of("日本", "東京", "フランス", "パリ");
        System.out.println("ユニークスキル: " + uniqueSkills);
        System.out.println("首都: " + capitalCities);
    }
}