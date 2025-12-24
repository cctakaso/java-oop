package oop.o_chapter_06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 第6章 Part 1: コレクション事始めとList
 */
public class App_0601 {
    public static void main(String[] args) {
        System.out.println("--- 第6章 Part 1: コレクション事始めとList ---");

        // --- 1. ジェネリクス <> の重要性 ---
        // ビデオシナリオ解説：コレクションが扱う型を< >で指定し、安全性を高める仕組み。
        System.out.println("\n--- ジェネリクス未使用（古い危険な書き方） ---");
        ArrayList dangerousList = new ArrayList();
        dangerousList.add("薬草");
        dangerousList.add(100); // StringだけでなくIntegerも入ってしまう！

        // 取り出す際に、どの型か分からないためキャストが必須で、間違いやすい
        // String item = (String) dangerousList.get(1); // ここで実行時エラーが発生！

        System.out.println("\n--- ジェネリクス使用（現代的で安全な書き方） ---");
        // <String>で「このリストはString専用です」と宣言。
        // 変数の型は親である `List` にするのが一般的。右辺は <> と省略可能。
        List<String> questLog = new ArrayList<>();
        questLog.add("ゴブリンを5匹討伐する");
        // questLog.add(5); // コンパイルエラー！ String以外は入れられない。
        String firstQuest = questLog.get(0); // キャスト不要で安全に取り出せる
        System.out.println("最初のクエスト: " + firstQuest);

        // --- 2. ArrayListの基本的な使い方 ---
        // ビデオシナリオ解説：配列の、柔軟で高機能な進化版。
        System.out.println("\n--- ArrayList（クエスト手帳）の操作 ---");

        // 要素の追加 (add)
        questLog.add("北の洞窟の地図を手に入れる");
        questLog.add("村人に話を聞く");

        System.out.println("現在のクエスト数: " + questLog.size()); // 要素数は .size() で取得

        // ループで全要素を取り出す（拡張for文）
        System.out.println("【現在のクエスト一覧】");
        for (String quest : questLog) {
            System.out.println(" - " + quest);
        }

        // 要素の削除 (remove)
        questLog.remove(0); // 0番目の「ゴブリン討伐」を完了したので削除
        System.out.println("\nクエスト「ゴブリン討伐」を完了！");
        System.out.println("【残りのクエスト一覧】");
        for (String quest : questLog) {
            System.out.println(" - " + quest);
        }

        // --- 3. LinkedListとの違い ---
        // ビデオシナリオ解説：得意・不得意がArrayListと正反対。迷ったらArrayListでOK！
        List<String> linkedList = new LinkedList<>();
        linkedList.add("LinkedListの要素");
        // 使い方はArrayListとほぼ同じだが、内部構造が違う。
        // 途中の要素への追加・削除は高速だが、get(i)でのランダムアクセスは低速。
    }
}