package oop.o_chapter_11;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自作のカスタムアノテーション
 * ビデオシナリオ解説：
 * `@interface`というキーワードで、新しいアノテーションを定義できます。
 * * --- メタアノテーション ---
 * `@Target`: このアノテーションがどこに付けられるかを限定します。(例: メソッド、クラス)
 * `@Retention`: アノテーションの情報がいつまで保持されるかを決めます。
 * `RUNTIME`は「プログラム実行中まで」を意味し、リフレクションで読み取れるようになります。
 */
@Target({ElementType.TYPE, ElementType.METHOD}) // このアノテーションはクラスとメソッドに付けられる
@Retention(RetentionPolicy.RUNTIME)           // このアノテーションの情報はプログラム実行時まで残る
public @interface ReleaseInfo_1101 {
   
    // このアノテーションが持つことができる「属性」をメソッド形式で定義します。
    String author() default "Unknown";      // 作成者 (デフォルト値付き)
    String version() default "1.0";         // バージョン
    String status() default "In Development"; // 状態
}