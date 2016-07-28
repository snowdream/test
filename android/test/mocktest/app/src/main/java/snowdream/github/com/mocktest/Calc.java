package snowdream.github.com.mocktest;

/**
 * for test
 * <p/>
 * Created by snowdream on 16-7-28.
 */
public class Calc {
    private int mPrivateField;

    private final int mPrivateFinalField = 0;

    private static int mPrivateStaticField = 0;

    private static final int mPrivateStaticFinalField = 0;

    public int mPublicField;

    public final int mPublicFinalField = 0;

    public static int mPublicStaticField = 0;

    public static final int mPublicStaticFinalField = 0;

    public void voidPublic(int a, int b) {
        return;
    }

    public int addPublic(int a, int b) {
        return a + b;
    }

    private int addPrivate(int a, int b) {
        return a + b;
    }

    public static int addPublicStatic(int a, int b) {
        return a + b;
    }

    private static int addPrivateStatic(int a, int b) {
        return a + b;
    }
}
