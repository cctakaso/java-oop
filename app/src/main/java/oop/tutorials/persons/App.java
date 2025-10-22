/**
 * クラス概念を学ぶためのメインクラス
 * <p>
 * 人物（Parson）クラスを使用した、チュートリアルアプリケーションです。
 * </p>
 * @author Takashi Ogisawa
 * @since 2025/09/01
 * Copyright(c) 2025 Takashi Ogisawa All rights reserved.
 */
package oop.tutorials.persons;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello Persons!");
        Parson taro = new Parson("Taro", 25);
        System.out.println(taro.getName() + "さんは" + taro.getAge() + "歳です。");
        Parson hanako = new Parson("Hanako", 20);
        System.out.println(hanako.getName() + "さんは" + hanako.getAge() + "歳です。");
    }
}
