package Database;

public class TD {
    private static ShowData d = new ShowData();

    public static void main(String[] args) throws ClassNotFoundException {
        String show = d.show(1);
        System.out.println(show);
    }
}
