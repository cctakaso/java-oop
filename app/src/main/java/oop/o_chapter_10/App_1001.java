package oop.o_chapter_10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * 第10章 Part 1: ファイル操作とバイナリI/O
 */
public class App_1001 {

    public static void main(String[] args) {
        System.out.println("--- 第10章 Part 1: ファイル操作とバイナリI/O ---");

        // --- 1. Fileクラスによるファイル操作 ---
        // ビデオシナリオ解説：Fileクラスはファイルの中身ではなく、「パス情報（住所）」を扱うオブジェクト。
        System.out.println("\n--- 1. 秘密のフォルダとファイルの操作 ---");

        // 操作対象のディレクトリ（フォルダ）とファイルを指定
        File secretDir = new File("mission_files");
        File secretFile = new File(secretDir, "report.txt");

        try {
            // ディレクトリが存在するかチェックし、なければ作成
            if (!secretDir.exists()) {
                secretDir.mkdir(); // mkdirs()なら親フォルダもまとめて作れる
                System.out.println("ディレクトリ '" + secretDir.getName() + "' を作成しました。");
            }

            // ファイルが存在するかチェックし、なければ作成
            if (!secretFile.exists()) {
                secretFile.createNewFile();
                System.out.println("ファイル '" + secretFile.getName() + "' を作成しました。");
            }
   
            // ファイルの情報を表示
            System.out.println("ファイル名: " + secretFile.getName());
            System.out.println("絶対パス: " + secretFile.getAbsolutePath());
            System.out.println("これはファイルですか？: " + secretFile.isFile());
            System.out.println("これはディレクトリですか？: " + secretFile.isDirectory());

        } catch (IOException e) {
            System.out.println("エラー: ファイル操作中に問題が発生しました。");
            e.printStackTrace();
        }

        // --- 2. バイナリI/Oによるファイルコピー ---
        // ビデオシナリオ解説：あらゆるデータを生の「バイト列」として扱う、I/Oの基本。
        System.out.println("\n--- 2. 暗号化ファイル(バイナリ)のコピー ---");

        // このデモを実行する前に、"source.bin"という名前で何か適当なファイル
        // (画像ファイルやテキストファイルなど)をプロジェクトフォルダに作成してください。

        // try-with-resources文で、`in`と`out`が自動的に閉じられる
        try (FileInputStream in = new FileInputStream("source.bin");
             FileOutputStream out = new FileOutputStream("destination.bin")) {
   
            byte[] buffer = new byte[1024]; // 1KBのバッファ(一時的な入れ物)を用意
            int len;

            System.out.println("ファイルのコピーを開始します...");
            // in.read(buffer)で読み込み、読み込んだバイト数がlenに入る。-1になるまでループ。
            // この while 文はJavaのI/O処理における定型句（イディオム）です。
            while ((len = in.read(buffer)) != -1) {
                // 読み込んだlenバイト分だけを書き込む
                out.write(buffer, 0, len);
            }
            System.out.println("ファイルのコピーが完了しました -> destination.bin");

        } catch (FileNotFoundException e) {
            System.out.println("エラー: コピー元のファイル 'source.bin' が見つかりません。");
        } catch (IOException e) {
            System.out.println("エラー: ファイルのコピー中に問題が発生しました。");
            e.printStackTrace();
        }

        // --- 後片付け ---
        System.out.println("\n--- 訓練終了、証拠隠滅 ---");
        if (secretFile.exists()) {
            secretFile.delete();
            System.out.println("ファイル '" + secretFile.getName() + "' を削除しました。");
        }
        if (secretDir.exists()) {
            secretDir.delete();
            System.out.println("ディレクトリ '" + secretDir.getName() + "' を削除しました。");
        }
    }
}