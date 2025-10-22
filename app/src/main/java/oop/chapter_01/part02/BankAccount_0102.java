package oop.chapter_01.part02;

/**
 * 銀行口座クラス（カプセル化適用版）
 * 重要なデータである `balance`（残高）を `private` で隠蔽し、
 * 安全な手続き（メソッド）を通してのみ操作できるようにします。
 * * ビデオシナリオ解説：
 * あなたのお金（預金）でも、金庫から直接掴み取ることはできません。
 * 必ず「銀行員」という正規の窓口を通して手続きしますよね。これがカプセル化です。
 */
public class BankAccount_0102 {

    // 1. フィールドを `private` にして外部から隠蔽する
    // `private` 修飾子が付いたメンバーは、そのクラスの内部からしかアクセスできません。
    private String ownerName; // 口座名義人
    private long balance;     // 残高

    // --- セッター (Setter) ---
    // フィールドに値を「設定(set)」するための `public` な窓口。
    public void setOwnerName(String ownerName) {
        // `this.ownerName` の `this` は「このインスタンス自身」を指すキーワード。
        // フィールドの`name`と引数の`name`を区別するために使います。
        this.ownerName = ownerName;
    }
   
    // `balance` には直接値を設定するセッターを用意しない。
    // なぜなら、「残高を自由に書き換える」操作は現実の銀行には存在しないから。
    // 代わりに、より現実に即した操作（入金・出金）をメソッドとして用意する。

    // --- ゲッター (Getter) ---
    // フィールドの値を「取得(get)」するための `public` な窓口。
    public String getOwnerName() {
        return this.ownerName;
    }

    public long getBalance() {
        return this.balance;
    }

    // --- 公開された操作メソッド ---

    /**
     * 入金するメソッド
     * @param amount 入金額
     */
    public void deposit(long amount) {
        // セッターの真価！不正な値のチェックができます。
        if (amount > 0) {
            this.balance = this.balance + amount;
            System.out.println(amount + "円を入金しました。現在の残高: " + this.balance + "円");
        } else {
            System.out.println("エラー: 0円以下の入金はできません。");
        }
    }

    /**
     * 出金するメソッド
     * @param amount 出金額
     */
    public void withdraw(long amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance = this.balance - amount;
            System.out.println(amount + "円を出金しました。現在の残高: " + this.balance + "円");
        } else {
            System.out.println("エラー: 出金額が不正か、残高が不足しています。");
        }
    }
}