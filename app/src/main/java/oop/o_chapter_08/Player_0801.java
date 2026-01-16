package oop.o_chapter_08;

/**
 * プレイヤーを表すシンプルなデータクラス（レコードとして定義）
 * Java 14以降で導入された`record`は、データを保持することだけを目的としたクラスを
 * 非常に簡潔に記述するための仕組みです。
 * コンストラクタやゲッター、toString()などが自動で生成されます。
 */
public record Player_0801(String name, String job, int experience) {
}