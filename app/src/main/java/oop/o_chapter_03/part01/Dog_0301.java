package oop.o_chapter_03.part01;

public class Dog_0301 extends Animal_0301 {
    public Dog_0301(String name) {
        super(name);
    }
   
    // `@Override`アノテーションは、このメソッドが親のメソッドを
    // 上書きする意図があることをコンパイラに伝えます。
    // もしタイプミスなどで正しくオーバーライドできていない場合、エラーで教えてくれます。
    @Override
    public void cry() {
        System.out.println(this.name + "が鳴いた。 ワン！");
    }
}