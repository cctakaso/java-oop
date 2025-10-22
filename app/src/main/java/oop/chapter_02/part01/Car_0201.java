package oop.chapter_02.part01;

/**
 * 子クラス（サブクラス）：乗用車
 * `extends` で Vehicle_0104 を継承します。「Car is a Vehicle」の関係です。
 */
public class Car_0201 extends Vehicle_0201 {
    private int numberOfSeats; // 乗車定員

    public Car_0201(String name, int seats) {
        // `super()` を使い、必ず親クラスのコンストラクタを最初に呼び出します。
        super(name); // 親のコンストラクタに名前を渡す
        this.numberOfSeats = seats;
    }

    // 親の`run`メソッドを上書き（オーバーライド）
    @Override
    public void run() {
        System.out.print(this.name + "が乗客を乗せて");
        // `super.` を使って親の元のメソッドを呼び出すことができます。
        super.run();
    }
   
    public void displayInfo() {
        System.out.println("車種: " + this.name + ", 定員: " + this.numberOfSeats + "名");
    }
}