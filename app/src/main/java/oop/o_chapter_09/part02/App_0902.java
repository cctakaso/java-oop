package oop.o_chapter_09.part02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

import oop.o_chapter_09.part01.App_0901;

/**
 * 第9章 Part 2: try-with-resourcesとOptional 〜モダンなエラーハンドリング〜
 */
public class App_0902 {

    public static void main(String[] args) {
        System.out.println("--- 第9章 Part 2: モダンなエラーハンドリング ---");

        // --- 1. try-with-resources ---
        // ビデオシナリオ解説：`finally`での`close()`処理をJavaが自動で行ってくれる便利な構文。
        System.out.println("\n--- 1. try-with-resourcesによるリソース管理 ---");
        java.net.URL url = App_0901.class.getResource("/dummy.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(url.getPath()))) {
            // `try`の( )内で生成したリソース(`br`)は、
            // このブロックを抜けるときに自動で`close()`される。
            System.out.println("ファイルから1行読み込み: " + br.readLine());
            // `finally`ブロックが不要になり、コードが劇的にスッキリ！
        } catch (IOException e) {
            System.out.println("エラー: ファイルの読み書き中に問題が発生しました。");
        }

        // --- 2. OptionalによるNullPointerException対策 ---
        System.out.println("\n--- 2. OptionalによるNPE対策 ---");
        UserDatabase_0902 db = new UserDatabase_0902();

        // --- 従来のnullチェック(Before) ---
        System.out.println("\n[従来のnullチェック]");
        User_0902 user1 = db.findById_old("001"); // 存在するユーザー
        if (user1 != null) {
            System.out.println("見つかりました: " + user1.getName());
        } else {
            System.out.println("見つかりませんでした。");
        }

        User_0902 user99 = db.findById_old("999"); // 存在しないユーザー
        if (user99 != null) {
            System.out.println("見つかりました: " + user99.getName());
        } else {
            System.out.println("ID '999'は見つかりませんでした。");
        }

        // --- Optionalを使ったモダンな書き方(After) ---
        System.out.println("\n[Optionalを使ったモダンな書き方]");

        // 存在するユーザーの場合
        Optional<User_0902> optUser1 = db.findById_modern("001");
        // `ifPresent`：値が存在する場合にのみ、ラムダ式を実行する
        optUser1.ifPresent(u -> System.out.println("見つかりました: " + u.getName()));

        // 存在しないユーザーの場合
        Optional<User_0902> optUser99 = db.findById_modern("999");
        // `orElse`：値が存在すればその値を、なければ（or else）指定したデフォルト値を返す
        User_0902 user = optUser99.orElse(new User_0902("GUEST", "ゲストユーザー"));
        System.out.println("ID '999'を探索。結果: " + user.getName());
    }
}