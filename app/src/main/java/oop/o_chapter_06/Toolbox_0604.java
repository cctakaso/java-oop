package oop.o_chapter_06;

/**
 * 自分で作るジェネリッククラス
 * @param <T> このツールボックスが格納できる「道具」の型
 */
public class Toolbox_0604<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return this.item;
    }

    public boolean hasItem() {
        return this.item != null;
    }
}