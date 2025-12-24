// このクラスは `education.oop.chapter_03.items` パッケージに所属します。
package oop.o_chapter_04.items;


import oop.o_chapter_04.common.GameObject_0401;

/**
 * 子クラス：ポーション
 * `GameObject_0301` を継承し、アクセス修飾子の挙動を確認します。
 */
public class Potion_0401 extends GameObject_0401 {

    public Potion_0401() {
        // 親クラスのコンストラクタを呼び出す
        super("ポーション", 99);
    }

    public void checkAccessFromSubclass() {
        System.out.println("\n--- Potion(別パッケージの子クラス)からのアクセスチェック ---");

        // publicなメンバーにはアクセスできる
        System.out.println("public name: " + this.name);

        // protectedなメンバーには、子クラスなのでパッケージが違ってもアクセスできる
        System.out.println("protected id: " + this.id);

        // package-privateなメンバーには、パッケージが違うのでアクセスできない
        // System.out.println(this.positionX); // この行はコンパイルエラーになります！

        // privateなメンバーには、当然アクセスできない
        // System.out.println(this.isAlive); // この行はコンパイルエラーになります！
    }
}