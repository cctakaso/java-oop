package oop.o_tutorials.traffic_simulation;

import java.util.Random;

/**
 * 交通流シミュレーションのメインロジックを管理するクラス。
 */
public class Simulation {

    /** シミュレーションの舞台となる道路 */
    private final Road road;

    /** シミュレーションを実行する総ステップ数 */
    private final int totalSteps;

    /** 各ステップで新しい車両が生成される確率 (0.0 ~ 1.0) */
    private final double carGenerationProbability;

    private final Random random = new Random();

    /**
     * シミュレーションオブジェクトを生成します。
     *
     * @param road 道路オブジェクト
     * @param totalSteps 総ステップ数
     * @param carGenerationProbability 車両生成確率
     */
    public Simulation(Road road, int totalSteps, double carGenerationProbability) {
        this.road = road;
        this.totalSteps = totalSteps;
        this.carGenerationProbability = carGenerationProbability;
    }

    /**
     * シミュレーションを開始します。
     */
    public void run() {
        for (int step = 0; step < totalSteps; step++) {
            // 新しい車両を確率的に生成
            if (random.nextDouble() < carGenerationProbability) {
                // 道路の先頭に他の車がいない場合のみ生成
                boolean isStartBlocked = false;
                for(Car car : road.getCars()) {
                    if (car.getPosition() == 0) {
                        isStartBlocked = true;
                        break;
                    }
                }
                if (!isStartBlocked) {
                    road.addCar(new Car(0));
                }
            }

            // 道路の状態を更新
            road.update();

            // 道路を描画
            road.draw();

            // シミュレーションを少しだけ一時停止して、視覚的に追えるようにする
            try {
                Thread.sleep(100); // 100ミリ秒待機
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
