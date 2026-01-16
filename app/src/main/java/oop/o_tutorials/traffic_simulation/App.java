package oop.o_tutorials.traffic_simulation;

/**
 * 交通流シミュレーションアプリケーションのエントリーポイント。
 */
public class App {

    /**
     * アプリケーションのメインメソッド。
     * @param args コマンドライン引数（未使用）
     */
    public static void main(String[] args) {
        // 1. シミュレーションの基本設定
        final int roadLength = 50; // 道路の長さ
        final int simulationSteps = 500; // シミュレーションの総ステップ数
        final double carGenProb = 0.3; // 各ステップでの車両生成確率

        // 2. 道路オブジェクトの生成
        Road road = new Road(roadLength);

        // 3. 信号機オブジェクトを生成し、道路に追加
        // 道路の中間あたりに、30ステップごとに切り替わる信号を設置
        TrafficLight light1 = new TrafficLight(roadLength / 2, TrafficLightState.GREEN, 30);
        road.addTrafficLight(light1);

        // 4. シミュレーションオブジェクトを生成
        Simulation simulation = new Simulation(road, simulationSteps, carGenProb);

        System.out.println("Traffic Flow Simulation Start!");
        System.out.println("Road Length: " + roadLength + ", Steps: " + simulationSteps);
        System.out.println("Press Ctrl+C to stop.");

        // 5. シミュレーションの実行
        simulation.run();

        System.out.println("\nSimulation Finished.");
    }
}
