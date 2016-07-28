package snowdream.github.com.mocktest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * Created by snowdream on 16-7-28.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Calc.class})
public class CalcUnitTest {

    @Mock
    private Calc mCalc;


    @Test
    public void testConstruction() {
        assertNotNull(mCalc);
    }

    @Test
    public void testPublicField() {
        assertEquals(mCalc.mPublicField, 0);
        assertEquals(mCalc.mPublicFinalField, 0);
        assertEquals(Calc.mPublicStaticField, 0);
        assertEquals(Calc.mPublicStaticFinalField, 0);

        mCalc.mPublicField = 1;
        Calc.mPublicStaticField = 2;

        assertEquals(mCalc.mPublicField, 1);
        assertEquals(mCalc.mPublicFinalField, 0);
        assertEquals(Calc.mPublicStaticField, 2);
    }

    @Test
    public void testPrivateField() throws IllegalAccessException {
        PowerMockito.mockStatic(Calc.class);

        assertEquals(Whitebox.getField(Calc.class, "mPrivateField").getInt(mCalc), 0);
        assertEquals(Whitebox.getField(Calc.class, "mPrivateFinalField").getInt(mCalc), 0);
        assertEquals(Whitebox.getField(Calc.class, "mPrivateStaticField").getInt(null), 0);
        assertEquals(Whitebox.getField(Calc.class, "mPrivateStaticFinalField").getInt(null), 0);


        Whitebox.setInternalState(mCalc, "mPrivateField", 1);
        Whitebox.setInternalState(Calc.class, "mPrivateStaticField", 1, Calc.class);

        assertEquals(Whitebox.getField(Calc.class, "mPrivateField").getInt(mCalc), 1);
        assertEquals(Whitebox.getField(Calc.class, "mPrivateFinalField").getInt(mCalc), 0);
        assertEquals(Whitebox.getField(Calc.class, "mPrivateStaticField").getInt(null), 1);
        assertEquals(Whitebox.getField(Calc.class, "mPrivateStaticFinalField").getInt(null), 0);
    }

    @Test
    public void testAddPublicMethod() {
        //when
        when(mCalc.addPublic(anyInt(), anyInt()))
                .thenReturn(0)
                .thenReturn(1)
                .thenReturn(2)
                .thenReturn(3)
                .thenReturn(4)
                .thenReturn(5);

        //call method
        for (int i = 0; i < 6; i++) {

            //verify
            assertEquals(mCalc.addPublic(i, i), i);
        }

        //verify
        verify(mCalc, times(6)).addPublic(anyInt(), anyInt());
        verify(mCalc, atLeast(1)).addPublic(anyInt(), anyInt());
        verify(mCalc, atLeastOnce()).addPublic(anyInt(), anyInt());
        verify(mCalc, atMost(6)).addPublic(anyInt(), anyInt());
    }


    @Test
    public void testAddPrivateMethod() throws Exception {
        PowerMockito.mockStatic(Calc.class);

        //when
        PowerMockito.when(mCalc,"addPrivate",anyInt(),anyInt())
                .thenReturn(0)
                .thenReturn(1)
                .thenReturn(2)
                .thenReturn(3)
                .thenReturn(4)
                .thenReturn(5);

        //call method
        for (int i = 0; i < 6; i++) {

            //verify
            assertEquals(Whitebox.invokeMethod(mCalc,"addPrivate",i,i), i);
        }

        //verify static
        PowerMockito.verifyPrivate(mCalc,times(6)).invoke("addPrivate",anyInt(),anyInt());
        PowerMockito.verifyPrivate(mCalc,atLeast(1)).invoke("addPrivate",anyInt(),anyInt());
    }


    @Test
    public void testAddPublicVoidMethod() {
        //when
        doNothing().when(mCalc).voidPublic(anyInt(), anyInt());

        mCalc.voidPublic(anyInt(), anyInt());
        mCalc.voidPublic(anyInt(), anyInt());

        verify(mCalc, atLeastOnce()).voidPublic(anyInt(), anyInt());
        verify(mCalc, atLeast(2)).voidPublic(anyInt(), anyInt());
    }


    @Test
    public void testAddPublicStaicMethod() throws Exception {
        PowerMockito.mockStatic(Calc.class);

        PowerMockito.when(Calc.class, "addPublicStatic", anyInt(), anyInt())
                .thenReturn(0)
                .thenReturn(1)
                .thenReturn(2)
                .thenReturn(3)
                .thenReturn(4)
                .thenReturn(5);


        //call method
        for (int i = 0; i < 6; i++) {

            //verify
            assertEquals(Calc.addPublicStatic(i, i), i);
        }


        //verify static
        PowerMockito.verifyStatic(times(6));
    }


    @Test
    public void testAddPrivateStaicMethod() throws Exception {
        PowerMockito.mockStatic(Calc.class);

        PowerMockito.when(Calc.class, "addPrivateStatic", anyInt(), anyInt())
                .thenReturn(0)
                .thenReturn(1)
                .thenReturn(2)
                .thenReturn(3)
                .thenReturn(4)
                .thenReturn(5);


        //call method
        for (int i = 0; i < 6; i++) {

            //verify
            assertEquals(Whitebox.invokeMethod(Calc.class,"addPrivateStatic",i, i), i);
        }


        //verify static
        PowerMockito.verifyStatic(times(6));
    }

}
