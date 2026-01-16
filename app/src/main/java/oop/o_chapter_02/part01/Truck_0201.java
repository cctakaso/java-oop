package oop.o_chapter_02.part01;

/**
 * 子クラス（サブクラス）：トラック
 */
public class Truck_0201 extends Vehicle_0201 {
    private int payloadCapacity; // 積載量(kg)

    public Truck_0201(String name, int capacity) {
        super(name);
        this.payloadCapacity = capacity;
    }
   
    // Truckクラス独自のメソッド
    public void load() {
        System.out.println(this.name + "に" + this.payloadCapacity + "kgの荷物を積みました。");
    }
}