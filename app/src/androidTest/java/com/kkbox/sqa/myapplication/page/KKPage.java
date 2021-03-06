package com.kkbox.sqa.myapplication.page;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.Until;

public class KKPage {
    protected static final String APP_PACKAGE = "com.skysoft.kkbox.android";
    protected static final int LAUNCH_TIMEOUT = 10000;
    protected static final int TIMEOUT = 5000;
    protected UiDevice device;

    // UI Selector
    public static final BySelector SEARCH_BUTTON = By.res(APP_PACKAGE, "menu_global_search");
    public static final BySelector SETTING_BUTTON = By.clazz("android.widget.ImageButton");

    public KKPage(UiDevice device) {
        this.device = device;

        // Wait for the app to appear
        this.device.wait(Until.hasObject(By.pkg(APP_PACKAGE).depth(0)), LAUNCH_TIMEOUT);
    }

    public KKSearchPage openSearch() {
        this.device.wait(Until.findObject(SEARCH_BUTTON), TIMEOUT).click();

        return new KKSearchPage(this.device);
    }

    public KKFindPage openFind() {

        return new KKFindPage(this.device);
    }

    public KKSettingPage openSetting() {
        this.device.wait(Until.findObject(SETTING_BUTTON), TIMEOUT).click();

        return new KKSettingPage(this.device);
    }

    public KKRadioPage openRadio() {
        this.device.wait(Until.findObject(SETTING_BUTTON), TIMEOUT).click();

        return new KKRadioPage(this.device);
    }

    public KKSubscribePage openSubscribe() {

        return new KKSubscribePage(this.device);
    }

    public <T extends KKPage> T is(Class<T> type) {
        if (type.isInstance(this)) {
            return type.cast(this);
        } else {
            throw new InvalidPageException("Invalid page type. Expected: " + type.getSimpleName() + ", but got: " + this.getClass().getSimpleName());
        }
    }

    public static class InvalidPageException extends RuntimeException {

        public InvalidPageException(final String message) {
            super(message);
        }
    }
}