package oop.o_chapter_09.part02;

/**
 * ユーザー情報を保持するシンプルなクラス
 */
public class User_0902 {
    private String id;
    private String name;

    public User_0902(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return this.id; }
    public String getName() { return this.name; }
}