package com.ubsofttech.rxjavademo;

import android.util.Log;

import rx.functions.Action1;

/**
 * Created by Umesh on 12/14/2016.
 */

public class Test2 implements Action1 {
    @Override
    public void call(Object o) {
        Log.d("Array",o.toString());
    }
}
