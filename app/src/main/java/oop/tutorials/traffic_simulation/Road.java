package oop.tutorials.traffic_simulation;
import java.util.ArrayList;
import java.util.List;

/**
 * シミュレーションの舞台となる道路を表すクラス。
 * 車両や信号機の管理、道路状況の描画を行います。
 */
public class Road {

    /** 道路の長さ */
    private final int length;

    /** 道路上の車両リスト */
    private final List<Car> cars;

    /** 道路上の信号機リスト */
    private final List<TrafficLight> lights;

    /**
     * 道路オブジェクトを生成します。
     *
     * @param length 道路の長さ
     */
    public Road(int length) {
        this.length = length;
        this.cars = new ArrayList<>();
        this.lights = new ArrayList<>();
    }

    /**
     * 道路に車両を追加します。
     * @param car 追加する車両
     */
    public void addCar(Car car) {
        cars.add(car);
    }

    /**
     * 道路に信号機を追加します。
     * @param light 追加する信号機
     */
    public void addTrafficLight(TrafficLight light) {
        lights.add(light);
    }

    /**
     * 道路上のすべての車両と信号機の状態を1ステップ更新します。
     */
    public void update() {
        // 信号機の状態を更新
        for (TrafficLight light : lights) {
            light.update();
        }

        // 車両の位置を更新
        for (Car car : cars) {
            int nextPosition = car.getPosition() + 1;
            if (isPositionClear(nextPosition)) {
                car.move();
            }
        }

        // 道路の終点に達した車両を削除
        cars.removeIf(car -> car.getPosition() >= length);
    }

    /**
     * 指定された位置が進めるかどうかを判定します。
     * @param position 判定する位置
     * @return 進行可能な場合はtrue, そうでない場合はfalse
     */
    private boolean isPositionClear(int position) {
        // 他の車両がいるかチェック
        for (Car car : cars) {
            if (car.getPosition() == position) {
                return false;
            }
        }

        // 信号機があるかチェック
        for (TrafficLight light : lights) {
            if (light.getPosition() == position && light.getState() == TrafficLightState.RED) {
                return false;
            }
        }

        return true;
    }

    /**
     * 現在の道路状況をコンソールに描画します。
     */
    public void draw() {
        char[] roadView = new char[length];
        for (int i = 0; i < length; i++) {
            roadView[i] = '_';
        }

        // 信号機の描画
        for (TrafficLight light : lights) {
            if (light.getPosition() < length) {
                roadView[light.getPosition()] = (light.getState() == TrafficLightState.GREEN) ? 'G' : 'R';
            }
        }

        // 車両の描画
        for (Car car : cars) {
            if (car.getPosition() < length) {
                roadView[car.getPosition()] = 'C';
            }
        }

        System.out.print(new String(roadView) + "\r");
    }

    /**
     * 道路上の車両リストを取得します。
     * @return 車両のリスト
     */
    public List<Car> getCars() {
        return cars;
    }
}
