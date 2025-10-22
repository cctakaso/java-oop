package oop.chapter_05;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * 第5章 Part 4: 日付と時刻の扱い
 */
public class App_0504 {
    public static void main(String[] args) {
        System.out.println("--- 第5章 Part 4: 日付と時刻の扱い ---");

        // --- 1. 現在の日付・時刻の取得 ---
        // ビデオシナリオ解説：`now()`メソッドで「今」を取得するのが基本。
        System.out.println("\n--- 現在の日付・時刻 ---");
        LocalDateTime now = LocalDateTime.now(); // 日付と時刻
        LocalDate today = LocalDate.now();       // 今日の日付
        LocalTime currentTime = LocalTime.now();   // 今の時刻

        System.out.println("現在の日付と時刻: " + now);
        System.out.println("今日の日付: " + today);
        System.out.println("今の時刻: " + currentTime);

        // --- 2. 情報の取り出し ---
        System.out.println("\n--- 情報の取り出し ---");
        System.out.println("今年は " + now.getYear() + " 年です。");
        System.out.println("今月は " + now.getMonthValue() + " 月です。"); // getMonth()は`SEPTEMBER`のようなEnumを返す
        System.out.println("今日は " + now.getDayOfMonth() + " 日です。");

        // --- 3. 日付の計算（不変性） ---
        // `java.time`のクラスは不変(Immutable)。`plus`や`minus`は新しいオブジェクトを返す。
        System.out.println("\n--- 日付の計算 ---");
        LocalDate threeDaysLater = today.plusDays(3);
        System.out.println("今日の3日後は " + threeDaysLater + " です。");
        System.out.println("`today`自体は変わらない: " + today);

        // --- 4. 日付・時刻のフォーマット（整形） ---
        // ビデオシナリオ解説：`DateTimeFormatter`を使って、人間が見やすい形式に変換します。
        System.out.println("\n--- 日付・時刻のフォーマット ---");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH時mm分ss秒");
        String formattedDateTime = now.format(formatter);
        System.out.println("フォーマット後の日時: " + formattedDateTime);

        // --- 5. 文字列からのパース（解析） ---
        // フォーマットされた文字列を、日付オブジェクトに戻す
        String dateString = "2025/10/31";
        DateTimeFormatter slashFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate halloween = LocalDate.parse(dateString, slashFormatter);
        System.out.println("文字列からパースした日付: " + halloween);

        // --- 6. タイムゾーンを扱うZonedDateTime ---
        // 副読本 p.30
        System.out.println("\n--- タイムゾーンの扱い ---");
        ZonedDateTime tokyoTime = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        ZonedDateTime londonTime = ZonedDateTime.now(ZoneId.of("Europe/London"));
        System.out.println("東京の現在時刻: " + tokyoTime.format(formatter));
        System.out.println("ロンドンの現在時刻: " + londonTime.format(formatter));
    }
}