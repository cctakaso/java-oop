package oop.o_chapter_01.part01;

/**
 * RPGキャラクターの「設計図」となるクラス。
 * (章番号_Part番号として Character_0101 と命名)
 * * ビデオシナリオ解説：
 * クラスは、オブジェクトを作るための「設計図」や「雛形」です。
 * この設計図には、キャラクターが持つべき「データ（状態）」と「できること（振る舞い）」を定義します。
 */
public class Character_0101 {

    // --- フィールド (Field) ---
    // オブジェクトが持つデータや状態。「属性」とも呼ばれます。
    // ビデオシナリオ解説：キャラクターの「名前」や「HP」といった"名詞"で表されるものがフィールドです。
    public String name; // 名前
    public int hp;      // ヒットポイント
    public int level;   // レベル

    // --- 静的フィールド (static Field) ---
    // 副読本 p.5
    // `static` が付くと、そのクラスから作られた全インスタンスで共有される一つの変数になります。
    // 個々のキャラクターではなく、「パーティ全体」に共通する情報などに使います。
    public static String partyName = "伝説の勇者たち";

    // --- メソッド (Method) ---
    // オブジェクトができること、「振る舞い」や「操作」。
    // ビデオシナリオ解説：「攻撃する」や「自己紹介する」といった"動詞"で表されるものがメソッドです。

    /**
     * キャラクターの現在のステータスを自己紹介するメソッド
     */
    public void introduce() {
        System.out.println(
            "俺の名前は " + name + "！ " +
            "Lv." + level + ", HP:" + hp
        );
    }

    /**
     * 敵に攻撃するメソッド
     * @param enemyName 攻撃する敵の名前
     */
    public void attack(String enemyName) {
        System.out.println(this.name + "は " + enemyName + " に攻撃した！");
    }
}