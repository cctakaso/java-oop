package oop.o_chapter_02.part02;

// すべてのクラスは、私たちが書かなくても `extends Object` を暗黙的に行っています。
public class Animal_0202 /* extends Object */ {
    protected String name;
    public Animal_0202(String name) { this.name = name; }
   
    public void cry() {
        System.out.println("..."); // 動物の一般的な鳴き声
    }

    // ObjectクラスのtoString()メソッドをオーバーライド
    @Override
    public String toString() {
        return "Animal[name=" + this.name + "]";
    }
}