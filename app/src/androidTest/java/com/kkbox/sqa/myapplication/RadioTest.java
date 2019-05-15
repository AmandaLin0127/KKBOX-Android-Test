package com.kkbox.sqa.myapplication;

import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.kkbox.sqa.myapplication.page.KKRadioPage;
import com.kkbox.sqa.myapplication.page.KKPage;
import com.kkbox.sqa.myapplication.util.TestBuilder;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class RadioTest {
    private static KKPage kkbox;

    @BeforeClass
    public static void login() {
        kkbox = new TestBuilder()
                .loginViaEmail("demo1683@kkbox.com", "kkbox_1683")
                .disableTrialMessage()
                .launch();
    }

    @Before
    public void setup() {
        kkbox = new TestBuilder().launch();
    }

    @Test
    public void testRadio() throws UiObjectNotFoundException {
        kkbox.is(KKPage.class).openRadio()
                .is(KKRadioPage.class).openRadio()
                .is(KKRadioPage.class).scroll("渡假中");
    }

}
