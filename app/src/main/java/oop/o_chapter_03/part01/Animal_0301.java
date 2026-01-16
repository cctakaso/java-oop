package oop.o_chapter_03.part01;

/**
 * 親クラス(スーパークラス)：Animal
 * 動物の基本的な振る舞いを定義します。
 */
public class Animal_0301 {
    protected String name;

    public Animal_0301(String name) {
        this.name = name;
    }

    // 動物の一般的な鳴き声
    public void cry() {
        System.out.println(this.name + "が鳴いた。 ... ");
    }
}