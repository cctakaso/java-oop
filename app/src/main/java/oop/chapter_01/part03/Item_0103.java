package oop.chapter_01.part03;

/**
 * お店の「商品」を表すクラス（コンストラクタ実装版）
 */
public class Item_0103 {
    private String name;
    private int price;
   
    // --- コンストラクタ (Constructor) ---
    // `new` される時に自動で呼ばれる初期化専用の特別なメソッド。
    // ルール1: 名前はクラス名と全く同じ。
    // ルール2: 戻り値は書かない。

    /**
     * 引数なしのコンストラクタ（デフォルトコンストラクタ）
     * ビデオシナリオ解説：
     * もし私たちがコンストラクタを一つも書かなかった場合、Javaが目に見えない形で
     * この中身が空のコンストラクタを自動で用意してくれます。
     */
    public Item_0103() {
        System.out.println("【LOG】引数なしコンストラクタが呼ばれました。");
        this.name = "（商品名未設定）";
        this.price = 0;
    }

    /**
     * 商品名と価格を引数で受け取るコンストラクタ
     * ビデオシナリオ解説：
     * これを1つでも定義すると、Javaはデフォルトコンストラクタを自動で作ってくれなくなります！
     * @param name 商品名
     * @param price 価格
     */
    public Item_0103(String name, int price) {
        System.out.println("【LOG】引数付きコンストラクタが呼ばれました！");
        this.name = name;
        this.price = (price < 0) ? 0 : price; // 価格がマイナスなら0にする
    }
   
    /**
     * 商品情報を表示するメソッド
     */
    public void displayInfo() {
        System.out.println("商品名: " + this.name);
        System.out.println("価格: " + this.price + "円");
    }
}