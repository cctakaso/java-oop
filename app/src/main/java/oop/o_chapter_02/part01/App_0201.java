package oop.o_chapter_02.part01;

/**
 * 第2章 Parnt 1: 継承
 * `extends` と `super` を使い、クラスの機能を再利用・拡張する方法を学びます。
 */
public class App_0201 {
    public static void main(String[] args) {
        System.out.println("--- 第2章 Parnt 1: 継承 ---");

        // 子クラス`Car_0104`のインスタンスを生成
        Car_0201 myCar = new Car_0201("セダン", 5);
        System.out.println("\n[マイカーの情報]");
        myCar.displayInfo();
        myCar.run(); // Carでオーバーライドされたrunメソッドが呼ばれる

        // 子クラス`Truck_0104`のインスタンスを生成
        Truck_0201 myTruck = new Truck_0201("2tトラック", 2000);
        System.out.println("\n[トラックの情報]");
        myTruck.load(); // Truck独自のメソッド
        myTruck.run();  // 親であるVehicleから受け継いだrunメソッドがそのまま呼ばれる
    }
}