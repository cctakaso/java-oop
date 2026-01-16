package oop.o_tutorials.traffic_simulation;
/**
 * 道路上を移動する車両を表すクラス。
 */
public class Car {

    /** 車両の現在位置 */
    private int position;

    /**
     * 車両オブジェクトを生成します。
     *
     * @param position 初期位置
     */
    public Car(int position) {
        this.position = position;
    }

    /**
     * 車両を1ステップ前進させます。
     */
    public void move() {
        this.position++;
    }

    /**
     * 車両の現在位置を取得します。
     * @return 現在位置
     */
    public int getPosition() {
        return position;
    }
}
