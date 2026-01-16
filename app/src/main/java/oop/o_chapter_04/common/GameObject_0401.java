// 1. package宣言：このクラスが `education.oop.chapter_03.common` パッケージに所属することを示します。
package oop.o_chapter_04.common;

/**
 * ゲーム世界のあらゆるオブジェクトの親となる基底クラス（スーパークラス）。
 * 4つのアクセス修飾子をすべて含み、公開範囲の違いを学びます。
 */
public class GameObject_0401 {
    // --- 4つのアクセス修飾子を持つフィールド ---

    // 1. public: どこからでもアクセス可能 (🌐 公園)
    public String name;

    // 2. protected: 同じパッケージか、別パッケージの子クラスからアクセス可能 (👨‍👩‍👧‍👦 家族+親戚)
    protected int id;

    // 3. (指定なし/package-private): 同じパッケージからのみアクセス可能 (🏡 町内会)
    int positionX;

    // 4. private: このクラスの中からしかアクセスできない (🔒 自分の部屋)
    private boolean isAlive;

    public GameObject_0401(String name, int id) {
        this.name = name;
        this.id = id;
        this.positionX = 0; // 初期位置
        this.isAlive = true;  // 生成時は生存
    }

    // privateなフィールドに外部から安全にアクセスするためのpublicメソッド
    public boolean checkIsAlive() {
        return this.isAlive;
    }

    // このクラスの内部でのみ使用するprivateメソッド
    private void internalProcessing() {
        System.out.println("  (" + this.name + "の内部処理を実行しました)");
    }

    // publicなメソッドからprivateなメソッドを呼び出す
    public void update() {
        System.out.println(this.name + "の状態を更新します。");
        internalProcessing();
    }
}