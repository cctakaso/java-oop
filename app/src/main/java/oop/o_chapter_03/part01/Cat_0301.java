package oop.o_chapter_03.part01;

public class Cat_0301 extends Animal_0301 {
    public Cat_0301(String name) {
        super(name);
    }
   
    @Override
    public void cry() {
        System.out.println(this.name + "が鳴いた。 ニャー！");
    }
}