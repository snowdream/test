package snowdream.github.com.mocktest;

import android.app.Application;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.MediumTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;


import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@MediumTest
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentationTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("snowdream.github.com.mocktest", appContext.getPackageName());

        Context context = Mockito.mock(Context.class);
        assertNotNull(context);

        when(context.getApplicationContext()).thenReturn(appContext);
        Context appContext1 = context.getApplicationContext();

        assertNotNull(appContext1);
        assertEquals("snowdream.github.com.mocktest", appContext.getPackageName());
    }
}