// このクラスは `education.oop.chapter_03` パッケージに所属します。
package oop.chapter_04;

import oop.chapter_04.common.GameManager_0401;
import oop.chapter_04.common.GameObject_0401;
import oop.chapter_04.items.Potion_0401;

/**
 * 第4章: パッケージとアクセス修飾子
 * フォルダ分けされたクラスを`import`して使い、各メンバーへのアクセス範囲を検証します。
 */
public class App_0401 {
    public static void main(String[] args) {
        System.out.println("--- 第4章: パッケージとアクセス修飾子 ---");

        // --- 1. 無関係な外部パッケージからのアクセス ---
        System.out.println("\n--- App_0301(外部)からGameObjectのメンバーへのアクセスチェック ---");
        GameObject_0401 obj = new GameObject_0401("宝箱", 1);

        // `public` なメンバーにのみアクセス可能
        System.out.println("public name: " + obj.name);
        // obj.id;          // protected なのでエラー
        // obj.positionX;   // package-private なのでエラー
        // obj.isAlive;     // private なのでエラー

        // --- 2. 同一パッケージ内のクラスからのアクセス ---
        GameManager_0401 manager = new GameManager_0401();
        manager.checkAccess(obj);

        // --- 3. 別パッケージの子クラスからのアクセス ---
        Potion_0401 potion = new Potion_0401();
        potion.checkAccessFromSubclass();
    }
}