package com.kkbox.sqa.myapplication;

import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.kkbox.sqa.myapplication.page.KKSubscribePage;
import com.kkbox.sqa.myapplication.page.KKPage;
import com.kkbox.sqa.myapplication.util.TestBuilder;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class SubscribeTest {
    private static KKPage kkbox;

    @BeforeClass
    public static void login() {
        kkbox = new TestBuilder().launch();
    }

    @Before
    public void setup() {
        kkbox = new TestBuilder().launch();
    }

    @Test
    public void testSubscribe() throws UiObjectNotFoundException {
        kkbox.is(KKPage.class).openSubscribe()
                .is(KKSubscribePage.class).clickSubscribe()
                .is(KKSubscribePage.class).scroll("韓語速爆新歌 (每週一更新)")
                .is(KKSubscribePage.class).clickMore()
                .is(KKSubscribePage.class).clickTitle()
                .is(KKSubscribePage.class).clickAdd("0218LIST");
    }
}
