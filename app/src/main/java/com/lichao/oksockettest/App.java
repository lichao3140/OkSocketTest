package com.lichao.oksockettest;

import android.app.Application;

import com.vilyever.logger.Logger;
import com.vilyever.logger.LoggerDisplay;

/**
 * Created by ChaoLi on 2019/3/15 0015 - 0:01
 * Email: lichao3140@gmail.com
 * Version: v1.0
 */
public class App extends Application {
    final App self = this;

    @Override
    public void onCreate() {
        super.onCreate();

        LoggerDisplay.initialize(this);
        LoggerDisplay.setDisplayLogTag(Logger.DefaultTag);
    }
}
