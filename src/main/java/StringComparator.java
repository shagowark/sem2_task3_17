import java.util.Comparator;

public class StringComparator implements Comparator<String> {
    public int compare(String str1, String str2) {
        return Integer.compare(str2.length(), str1.length());
    }
}
