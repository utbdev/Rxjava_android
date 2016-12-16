package com.ubsofttech.rxjavademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*for string*/
        Observable<String> stringObservable = Observable.just("Umesh1");

        //  Test stringObserver=new Test();
        Test1 stringObserver = new Test1();

        Subscription subscription = stringObservable.subscribe(stringObserver);
        subscription.unsubscribe();


        /*for intger array*/

        Observable<Integer> integerObservable = Observable.from(new Integer[]{1, 2, 3, 4, 5});
        Test2 test2 = new Test2();
        Subscription subscription1 = integerObservable.subscribe(test2);


        integerObservable = integerObservable.map(new Func1<Integer, Integer>() {
            @Override
            public Integer call(Integer integer) {
                return integer * integer;
            }
        });

        subscription1 = integerObservable.subscribe(test2);
        integerObservable.skip(2)
                .filter(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        return integer % 2 == 0;
                    }
                });

        /*Asynch task*/

        Observable<String> stringObservable1=Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try{
                    String data=fetchData("http://www.google.com");
                    subscriber.onNext(data);
                    subscriber.onCompleted();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        stringObservable1.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        //view.setText(view.getText() + "\n" + s);
                        Log.d("View",s);
                    }
                });

    }



    private String fetchData(String s) {
        return s;
    }
}
