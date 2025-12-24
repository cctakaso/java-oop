package oop.o_chapter_02.part02;

/**
 * 第3章 Part 2: 参照とキャスト、Objectクラス
 */
public class App_0202 {
    public static void main(String[] args) {
        System.out.println("--- 第3章 Part 2: 参照とキャスト、Objectクラス ---");

        // 1. アップキャスト (Upcasting)
        // 子クラス(Dog, Cat)のインスタンスを、親クラス(Animal)の型変数に入れる。
        // 「Dog is an Animal」なので、これは安全であり、自動的に行われる。
        Animal_0202 myPet1 = new Dog_0202("ポチ");
        Animal_0202 myPet2 = new Cat_0202("タマ");

        System.out.println("\n--- ペットたちに鳴いてもらおう ---");
        System.out.print(myPet1.name + " -> ");
        myPet1.cry(); // 実体はDogなので「ワン！」

        System.out.print(myPet2.name + " -> ");
        myPet2.cry(); // 実体はCatなので「ニャー！」

        // Animal型の「メガネ」で見ているので、子独自のメソッドは見えない
        // myPet1.wagTail(); // コンパイルエラー！

        // 2. instanceof と ダウンキャスト
        System.out.println("\n--- ペットの正体を確認し、特別な行動をさせる ---");

        // instanceof演算子のパターン・マッチング
        // ダウンキャスト (Downcasting) で、親クラス型変数を子クラス型に変換
        // 「Animal is a Dog」かどうかを確認してからキャストするので安全
        // 下記の明示的キャストの代わりにinstanceof演算子の2番目のオペランドが
        // タイプ・パターンで変更され、この変換のステップが省略できる。
        // Dog_0202 pochi = (Dog_0202) myPet1;
        //
        if (myPet1 instanceof Dog_0202 pochi) {
            System.out.println(myPet1.name + "は犬でした。");
            pochi.wagTail(); // Dog独自のメソッドが呼べる！
        }

        if (myPet2 instanceof Cat_0202 tama) {
            System.out.println(myPet2.name + "は猫でした。");
            tama.hide(); // Cat独自のメソッドが呼べる！
        }

        // 3. Objectクラス
        // `Object`はすべてのクラスの頂点に立つご先祖様
        Object unknown = new Dog_0202("コロ");
        // `System.out.println`は、内部で自動的にそのオブジェクトの`toString()`を呼び出す
        System.out.println("\nObject変数の中身: " + unknown);
    }
}