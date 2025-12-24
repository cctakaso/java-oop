package oop.o_chapter_03.part01;

/**
 * ゲームキャラクタークラス：オーバーロードを学ぶためのサンプル
 * 同じ`attack`という名前で、引数の数や型が異なるメソッドを複数定義（オーバーロード）しています。
 */
public class GameCharacter_0301 {
    private String name;

    public GameCharacter_0301(String name) {
        this.name = name;
    }

    // 1. 引数なしのattackメソッド
    public void attack() {
        System.out.println(this.name + "の通常攻撃！");
    }

    // 2. 攻撃対象を引数に取るattackメソッド (オーバーロード)
    public void attack(String target) {
        System.out.println(this.name + "は " + target + " に攻撃した！");
    }

    // 3. 攻撃対象と魔法の種類を引数に取るattackメソッド (オーバーロード)
    public void attack(String target, String magic) {
        System.out.println(this.name + "は " + target + " に魔法「" + magic + "」を唱えた！");
    }
}