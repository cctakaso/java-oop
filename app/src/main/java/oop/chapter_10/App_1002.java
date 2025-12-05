package oop.chapter_10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * 第10章 Part 2: テキストI/OとStream連携
 */
public class App_1002 {

    public static void main(String[] args) {
        System.out.println("--- 第10章 Part 2: テキストI/OとStream連携 ---");
        String fileName = "mission_log.txt";

        // --- 1. テキストファイルの書き込み ---
        // ビデオシナリオ解説：`BufferedWriter`と`OutputStreamWriter`を「重ね着」して使う。
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8))) {
   
            writer.write("作戦日誌\n");
            writer.newLine(); // OSに依存しない改行を出力
            writer.write("10/26 14:00 | INFO: 潜入成功\n");
            writer.write("10/26 15:30 | ERROR: 警備システム作動\n");
            writer.write("10/26 15:35 | INFO: 警備システム解除\n");
            writer.write("10/26 18:00 | INFO: 目標確保\n");
            System.out.println("日誌ファイル '" + fileName + "' の書き込み完了。");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // --- 2. 伝統的なテキストファイルの読み込み (whileループ) ---
        System.out.println("\n--- 2. 伝統的な方法での日誌読み込み ---");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
   
            String line;
            // `readLine()`で一行ずつ読み込み、nullになるまでループ
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // --- 3. モダンなファイル処理 (Stream API連携) ---
        // ビデオシナリオ解説：`BufferedReader.lines()`でファイルの中身をStreamとして扱える！
        System.out.println("\n--- 3. Stream APIを使った日誌の分析 ---");
        System.out.println("【重要報告: 'ERROR'を含む行を大文字で抽出】");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
   
            // 1. `.lines()`でStream<String>を取得
            // 2. あとは、おなじみのStream APIで自由に処理！
            reader.lines()
                  .filter(line -> line.contains("ERROR")) // "ERROR"を含む行だけを
                  .map(line -> line.toUpperCase())      // 大文字に変換して
                  .forEach(System.out::println);        // 表示する

        } catch (IOException e) {
            e.printStackTrace();
        }

        // --- 4. さらにモダンな方法 (Files.lines)  ---
        // `java.nio.file.Files`クラスを使うと、1行でStreamを生成できる。
        System.out.println("\n--- 4. Files.lines()を使ったさらにモダンな方法 ---");
        try (Stream<String> lines = Files.lines(Path.of(fileName), StandardCharsets.UTF_8)) {
            long infoCount = lines.filter(line -> line.contains("INFO")).count();
            System.out.println("日誌内の 'INFO' の件数: " + infoCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}