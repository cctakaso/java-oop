package oop.o_chapter_01.part02;

/**
 * 第1章 Part 2: カプセル化
 * `private` でデータを守り、`public` なメソッドで安全に操作する方法を学びます。
 */
public class App_0102 {

    public static void main(String[] args) {
        System.out.println("--- 第1章 Part 2: カプセル化 ---");

        System.out.println("--- ゲッター／セッター ---");

        BankAccount_0102 myAccount = new BankAccount_0102();

        // 公開されたセッターで口座名義人を設定
        myAccount.setOwnerName("Taro Suzuki");

        System.out.println(myAccount.getOwnerName() + "さんの口座を開設しました。");

        // フィールドへの直接アクセスはコンパイルエラーになる！
        // myAccount.balance = 1000000; // 不正な操作はコンパイル段階で防がれる！

        System.out.println("\n--- 預金の操作 ---");
        // 必ず `deposit` や `withdraw` といった正規のメソッド（窓口）を通して操作する
        myAccount.deposit(50000);
        myAccount.withdraw(12000);

        System.out.println("\n--- 不正な操作を試みる ---");
        myAccount.deposit(-5000); // メソッド内のチェック機能が働き、不正な操作は実行されない
        myAccount.withdraw(999999); // 残高不足でこれも実行されない

        // 最終的な残高は、ゲッターで安全に取得する
        System.out.println("\n最終残高照会: " + myAccount.getBalance() + "円");

        System.out.println("\n--- インナークラス ---");

        // 1. まず、外部クラスのインスタンスを生成する
        Player_1101 hero = new Player_1101("勇者");

        // 2. 外部クラスのインスタンスを使って、インナークラスのインスタンスを生成する
        Player_1101.SpecialArmor holyArmor = hero.new SpecialArmor();

        // 3. インナークラスのメソッドを呼び出す
        holyArmor.equip();
        holyArmor.displayPlayerStatus();

      }
}