package oop.chapter_02.part02;

public class Cat_0202 extends Animal_0202 {
    public Cat_0202(String name) { super(name); }

    @Override
    public void cry() {
        System.out.println("ニャー！");
    }

    public void hide() {
        System.out.println(this.name + "が箱の中に隠れた。");
    }
}