package oop.chapter_02.part02;

public class Dog_0202 extends Animal_0202 {
    public Dog_0202(String name) { super(name); }
   
    @Override
    public void cry() {
        System.out.println("ワン！");
    }

    public void wagTail() {
        System.out.println(this.name + "がしっぽを振っている。");
    }
}