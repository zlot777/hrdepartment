package logic;

/**
 * Created by Администратор on 01.02.2015.
 */
public class Search {

    public static String replace(String str) {
        str = str.replace('*', '%');
        str = str.replace('?', '_').trim();
        return str;
    }

}
