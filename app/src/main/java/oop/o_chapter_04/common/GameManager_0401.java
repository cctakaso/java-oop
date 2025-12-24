// 1. package宣言：このクラスが `education.oop.chapter_03.common` パッケージに所属することを示します。
package oop.o_chapter_04.common;

/**
 * ゲーム全体を管理するクラス。
 * `GameObject_0301` と同じパッケージに所属し、`package-private`の挙動を確認します。
 */
public class GameManager_0401 {

    public void checkAccess(GameObject_0401 obj) {
        System.out.println("\n--- GameManager(同一パッケージ)からのアクセスチェック ---");

        // publicなメンバーにはアクセスできる
        System.out.println("public name: " + obj.name);

        // protectedなメンバーには、同じパッケージなのでアクセスできる
        System.out.println("protected id: " + obj.id);

        // package-privateなメンバーにも、同じパッケージなのでアクセスできる
        System.out.println("package-private positionX: " + obj.positionX);

        // privateなメンバーにはアクセスできない
        // System.out.println(obj.isAlive); // コンパイルエラー！
    }
}