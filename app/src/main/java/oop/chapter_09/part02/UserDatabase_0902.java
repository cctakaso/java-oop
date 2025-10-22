package oop.chapter_09.part02;

import java.util.Map;
import java.util.Optional;

/**
 * ユーザー情報を管理する、擬似的なデータベースクラス
 */
public class UserDatabase_0902 {
    // ユーザーIDとユーザー名のペアをMapで管理
    private final Map<String, String> userMap = Map.of(
        "001", "Alice",
        "002", "Bob"
    );

    /**
     * 従来の、nullを返す可能性のあるメソッド
     * @param id ユーザーID
     * @return 見つかればUserオブジェクト、見つからなければnull
     */
    public User_0902 findById_old(String id) {
        String name = userMap.get(id);
        if (name != null) {
            return new User_0902(id, name);
        }
        return null;
    }

    /**
     * モダンな、Optionalを返すメソッド
     * ビデオシナリオ解説：
     * `Optional<User>`という戻り値の型を見るだけで、「Userが見つからない可能性がある」
     * ということが、呼び出し元に明確に伝わります。
     * @param id ユーザーID
     * @return Userが入っているかもしれない「箱」(Optional)
     */
    public Optional<User_0902> findById_modern(String id) {
        String name = userMap.get(id);
        // `Optional.ofNullable`は、中身がnullかもしれない場合に使用します。
        // `name`がnullなら空のOptional、nullでなければ`name`を持つUserが入ったOptionalを返します。
        return Optional.ofNullable(name)
            .map(n -> new User_0902(id, n));
    }
}