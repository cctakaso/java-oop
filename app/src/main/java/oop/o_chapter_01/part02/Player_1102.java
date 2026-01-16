package oop.o_chapter_01.part02;

/**
 * インナークラス (Inner Class)と外部クラス (Outer Class)
 * 外部クラス: Player
 * プレイヤーキャラクターを表します。
 * RPGのキャラクター(Player)とそのキャラクターだけが持つ
 * 特殊な装備(SpecialArmor)を例に、なぜインナークラスが便利なのかを体感します。
 */
class Player_1101 {
    private String name;
    private int defensePower = 10; // プレイヤーの基本防御力
    private SpecialArmor armor;
    
    public Player_1101(String name) {
        this.name = name;
    }

    public void equipArmor() {
        this.armor = new SpecialArmor();
        armor.equip();
    }

    public void displayPlayerStatus() {
        System.out.println(
            "[" + name + "] の現在の防御力は " + defensePower + " です。"
        );
    }

    /**
     * インナークラス (Inner Class): SpecialArmor
     * ビデオシナリオ解説：
     * インナークラスは、特定のクラス（この場合はPlayer）と密接に結びつき、
     * そのクラスのためだけに存在するヘルパーのような存在です。
     * * メリット：外部クラスの`private`メンバーに直接アクセスできます。
     */
    public class SpecialArmor {
        private String armorName = "聖なる鎧";
        private int armorBonus = 20;

        public void equip() {
            System.out.println(armorName + "を装備した！");
            // インナークラスから、外部クラス(Player)のprivateフィールド `defensePower` に直接アクセス！
            Player_1101.this.defensePower += this.armorBonus;
        }
    }
}