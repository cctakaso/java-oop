package oop.o_tutorials.traffic_simulation;

/**
 * 道路に設置される信号機を表すクラス。
 */
public class TrafficLight {

    /** 信号機の設置位置 */
    private int position;

    /** 現在の信号機の状態 (GREEN or RED) */
    private TrafficLightState state;

    /** 信号機の状態が切り替わるまでの時間（シミュレーションステップ数） */
    private final int cycle;

    /** 内部カウンター。状態が切り替わるまでの時間を計るために使用 */
    private int counter;

    /**
     * 信号機オブジェクトを生成します。
     *
     * @param position 道路上の設置位置
     * @param initialState 初期状態
     * @param cycle 状態が切り替わるまでのステップ数
     */
    public TrafficLight(int position, TrafficLightState initialState, int cycle) {
        this.position = position;
        this.state = initialState;
        this.cycle = cycle;
        this.counter = cycle;
    }

    /**
     * 信号機の状態を1ステップ更新します。
     * カウンターを減らし、0になったら状態を切り替えてカウンターをリセットします。
     */
    public void update() {
        counter--;
        if (counter <= 0) {
            if (state == TrafficLightState.GREEN) {
                state = TrafficLightState.RED;
            } else {
                state = TrafficLightState.GREEN;
            }
            counter = cycle;
        }
    }

    /**
     * 信号機の現在の状態を取得します。
     * @return 現在の信号機の状態
     */
    public TrafficLightState getState() {
        return state;
    }

    /**
     * 信号機の設置位置を取得します。
     * @return 道路上の設置位置
     */
    public int getPosition() {
        return position;
    }
}
