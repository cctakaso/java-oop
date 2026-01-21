package oop.o_chapter_11;

import java.lang.reflect.Method;

/**
 * 第11章: アノテーション
 * コードに「ラベル」を付け、その情報をプログラムで活用する方法を学びます。
 */
public class App_1101 {

    // @Overrideのデモ用に、簡単な親子クラスを定義
    static class Parent {
        public void showInfo() { System.out.println("I am a parent."); }
    }
    static class Child extends Parent {
        @Override // このアノテーションが、オーバーライドの意図をコンパイラに伝える
        public void showInfo() { System.out.println("I am a child."); }
    }

    @SuppressWarnings("deprecation")
    public static void testOldMethod() {
        LegacyFeature_1101 legacy2 = new LegacyFeature_1101();
        legacy2.oldMethod(); // この呼び出しでは警告が出なくなる
    }

    public static void main(String[] args) {
        System.out.println("--- 第11章: アノテーション ---");

        // --- 1. 標準アノテーションの復習 ---
        System.out.println("\n--- 1. 標準アノテーション ---");

        // @Deprecated: 使用するとコンパイラが警告を出す（IDEでは通常、取り消し線が表示される）
        LegacyFeature_1101 legacy = new LegacyFeature_1101();
        legacy.oldMethod();

        // @SuppressWarnings: コンパイラの警告を意図的に抑制する
        // ビデオシナリオ解説：乱用は危険！警告の理由をよく理解した上で限定的に使いましょう。
        testOldMethod();

        System.out.println("@Override, @Deprecated, @SuppressWarnings を確認しました。");

        // --- 2. カスタムアノテーションとリフレクション ---
        // ビデオシナリオ解説：リフレクションを使い、実行中にクラスやメソッドの情報を読み取る。
        // これがJUnitやSpringなど、モダンなフレームワークの根幹技術です。
        System.out.println("\n--- 2. カスタムアノテーションの読み取り (リフレクション) ---");

        // `NewFeature_1001`クラスの設計情報を取得
        Class<NewFeature_1101> clazz = NewFeature_1101.class;

        // クラス自体に付与されたアノテーションを読み取る
        if (clazz.isAnnotationPresent(ReleaseInfo_1101.class)) {
            ReleaseInfo_1101 classInfo = clazz.getAnnotation(ReleaseInfo_1101.class);
            System.out.println("クラス情報 -> Author: " + classInfo.author() + ", Status: " + classInfo.status());
        }

        System.out.println("\n--- リリースツールがメソッドをスキャン中... ---");
        // クラスに定義された全てのメソッドを調べる
        for (Method method : clazz.getDeclaredMethods()) {
            // メソッドに`ReleaseInfo_1001`アノテーションが付いているかチェック
            if (method.isAnnotationPresent(ReleaseInfo_1101.class)) {
                // アノテーションの情報を取得
                ReleaseInfo_1101 methodInfo = method.getAnnotation(ReleaseInfo_1101.class);

                // アノテーションの属性値に応じて処理を分岐
                if ("Ready for Release".equals(methodInfo.status())) {
                    System.out.println(
                        "✅ [リリース対象] メソッド名: " + method.getName() +
                        " (ver: " + methodInfo.version() + ", author: " + methodInfo.author() + ")"
                    );
                } else {
                    System.out.println(
                        "⚠️ [リリース対象外] メソッド名: " + method.getName() +
                        " (status: " + methodInfo.status() + ")"
                    );
                }
            } else {
                System.out.println("・ [アノテーションなし] メソッド名: " + method.getName());
            }
        }
    }
}