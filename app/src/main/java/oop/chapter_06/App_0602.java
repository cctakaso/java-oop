package oop.chapter_06;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 第6章 Part 2: SetとIterator
 */
public class App_0602 {
    public static void main(String[] args) {
        System.out.println("--- 第6章 Part 2: SetとIterator ---");

        // --- 1. HashSet ---
        // ビデオシナリオ解説：重複を許さず、順序も保証しない。追加・検索が非常に高速。
        System.out.println("\n--- HashSet（習得した魔法スキル） ---");
        Set<String> magicSkills = new HashSet<>();

        magicSkills.add("ファイア");
        magicSkills.add("サンダー");
        magicSkills.add("ヒール");
        System.out.println("新しい魔法を3つ覚えた！");

        System.out.println("再度「ファイア」の魔法書を読んだ...");
        boolean added = magicSkills.add("ファイア"); // 重複した要素を追加しようとすると、falseが返され無視される

        System.out.println("追加に成功したか？: " + added);
        System.out.println("現在のスキル数: " + magicSkills.size()); // 3のまま
        System.out.println("「ヒール」は覚えているか？: " + magicSkills.contains("ヒール"));

        System.out.println("【習得スキル一覧】（順序は保証されない）");
        for (String skill : magicSkills) {
            System.out.println(" - " + skill);
        }

        // --- 2. TreeSet ---
        // ビデオシナリオ解説：重複を許さず、要素が常に自動でソートされる。
        System.out.println("\n--- TreeSet（自動で整理される魔法書） ---");
        Set<String> sortedMagicSkills = new TreeSet<>();
        sortedMagicSkills.add("ザラキ");
        sortedMagicSkills.add("メラ");
        sortedMagicSkills.add("ホイミ");

        System.out.println("【整理された魔法書一覧】（自動でソートされる）");
        for (String skill : sortedMagicSkills) {
            System.out.println(" - " + skill);
        }

        // --- 3. Iterator ---
        // ビデオシナリオ解説：ループの途中で安全に要素を削除するための公式な道具。
        System.out.println("\n--- Iterator（魔法を忘れる） ---");
        System.out.println("忘れたい魔法: 「サンダー」");

        // ループ中にコレクションから要素を削除する
        // for (String skill : magicSkills) {
        //     if (skill.equals("サンダー")) {
        //         magicSkills.remove(skill); // NG! ConcurrentModificationExceptionの原因になる
        //     }
        // }

        // 正しい方法: Iteratorを使う
        Iterator<String> iterator = magicSkills.iterator();
        while (iterator.hasNext()) { // 次に要素がある限りループ
            String skill = iterator.next(); // 次の要素を取得
            if (skill.equals("サンダー")) {
                iterator.remove(); // Iteratorのremove()メソッドで安全に削除
                System.out.println("「サンダー」を忘れました。");
            }
        }

        System.out.println("【現在の習得スキル一覧】");
        System.out.println(magicSkills);
    }
}