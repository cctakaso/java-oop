package oop.chapter_05;

import java.util.Arrays; // Arrays.toString() を使うためにインポート

/**
 * 第5章 Part 2: 文字列の操作
 */
public class App_0502 {
    public static void main(String[] args) {
        System.out.println("--- 第5章 Part 2: 文字列の操作 ---");

        // --- 1. Stringの重要特性: 不変(Immutable) ---
        // ビデオシナリオ解説：一度作成したStringオブジェクトの中身は、絶対に変更できません。
        System.out.println("\n--- 文字列の不変性 ---");
        String s1 = "Java";
        String s2 = s1; // s2はs1と同じ "Java" オブジェクトを指す
        System.out.println("s1とs2は同じオブジェクトを指している？ -> " + (s1 == s2)); // true

        s1 = s1 + " Gold"; // "Java Gold" という「新しい」オブジェクトが作られ、s1がそれを指すようになる

        System.out.println("変更後のs1: " + s1);
        System.out.println("元のs2: " + s2); // s2は元の "Java" を指したまま
        System.out.println("s1とs2は同じオブジェクトを指している？ -> " + (s1 == s2)); // false

        // --- 2. 最大の罠！ `==` と `equals()` の違い ---
        // ビデオシナリオ解説：文字列の「中身」を比較したいときは、必ず.equals()を使う！
        System.out.println("\n--- `==` と `equals()` の違い ---");
        String strA = "ABC";
        String strB = new String("ABC"); // new を使うと、必ず新しいオブジェクトが作られる

        System.out.println("equals()で比較 (中身は同じ？): " + strA.equals(strB)); // true
        System.out.println("== で比較 (モノとして同じ？): " + (strA == strB));   // false

        // --- 3. 便利なStringメソッド ---
        System.out.println("\n--- 便利なStringメソッド ---");
        String message = "  Hello, Java World!  ";
        System.out.println("元のメッセージ: '" + message + "'");
        System.out.println("長さ: " + message.length());
        System.out.println("大文字に変換: " + message.toUpperCase());
        System.out.println("前後の空白を除去: '" + message.trim() + "'");
        System.out.println("JavaをPythonに置換: " + message.replace("Java", "Python"));
        System.out.println("7文字目から11文字目までを抽出: " + message.trim().substring(7, 12));
        System.out.println("'World'で終わるか？: " + message.trim().endsWith("World!"));

        // splitメソッド
        String csv = "リンゴ,ゴリラ,ラッパ";
        String[] words = csv.split(",");
        System.out.println("splitで分割: " + Arrays.toString(words));

        // String.joinメソッド
        String joined = String.join("-", words);
        System.out.println("joinで結合: " + joined);

        // --- 4. StringBuilder ---
        // ビデオシナリオ解説：ループの中で `+` で文字列連結を繰り返すと、非常に効率が悪い。
        // 可変(Mutable)な `StringBuilder` を使うのがセオリー。
        System.out.println("\n--- StringBuilderによる効率的な文字列連結 ---");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append("ド"); // append()メソッドで効率的に追加
        }
        sb.append("ラえもん");
        String result = sb.toString(); // 最後にStringに変換
        System.out.println(result);
    }
}