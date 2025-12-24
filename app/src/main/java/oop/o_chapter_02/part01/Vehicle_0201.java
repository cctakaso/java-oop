package oop.o_chapter_02.part01;

/**
 * 親クラス（スーパークラス）：乗り物
 * 車やトラックに共通する基本的な機能（名前、走る）を定義します。
 */
public class Vehicle_0201 {
    protected String name; // `protected` は子クラスからのアクセスを許可します

    public Vehicle_0201(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(this.name + "が走っています。");
    }
}