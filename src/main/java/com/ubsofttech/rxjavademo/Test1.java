package com.ubsofttech.rxjavademo;

import android.util.Log;

import rx.functions.Action;
import rx.functions.Action1;

/**
 * Created by Umesh on 12/14/2016.
 */

public class Test1 implements Action1 {
    @Override
    public void call(Object o) {
        Log.d("test1",o.toString());
    }
}
