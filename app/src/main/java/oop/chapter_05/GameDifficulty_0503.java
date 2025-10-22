package oop.chapter_05;

/**
 * ゲームの難易度を表す列挙型(Enum)
 * ビデオシナリオ解説：
 * `EASY`, `NORMAL`, `HARD` という決まった選択肢だけを安全に扱うための特別なデータ型です。
 */
public enum GameDifficulty_0503 {
    // 選択肢となる定数を列挙する
    EASY("やさしい", 1),
    NORMAL("ふつう", 2),
    HARD("むずかしい", 3);

    // 副読本 p.39：列挙型は、フィールドやコンストラクタ、メソッドを持つことができる
    private final String displayName;
    private final int level;

    // コンストラクタはprivateにするのがルール
    private GameDifficulty_0503(String displayName, int level) {
        this.displayName = displayName;
        this.level = level;
    }

    // 表示名を取得するメソッド
    public String getDisplayName() {
        return this.displayName;
    }
   
    // 難易度レベルを取得するメソッド
    public int getLevel() {
        return this.level;
    }
}