package com.ubsofttech.rxjavademo;

import android.util.Log;

import rx.Observer;

/**
 * Created by Umesh on 12/14/2016.
 */

public class Test implements Observer {
    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(Object o) {
        Log.d("test",o.toString());
    }
}
