/**
 * Parsonクラス
 * <p>
 * 人物を表現するクラスのチュートリアルです。
 * </p>
 * @author Takashi Ogisawa
 * @since 2025/09/01
 * Copyright(c) 2025 Takashi Ogisawa All rights reserved.
 */
package oop.o_tutorials.persons;

public class Parson {
  String name;  // 名前
  int age;      // 年齢

  // コンストラクタ
  public Parson(String name, int age) {
    this.name = name;
    this.age = age;
  }

  // ゲッター
  public String getName() { return name; }
  public int getAge() { return age; }
}
