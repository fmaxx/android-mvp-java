package com.snzflash.network;

import java.util.concurrent.TimeUnit;

import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RxRepositoryBase {

    private static final int BACKEND_MAX_RETRIES = 3;
    private static final int BACKEND_REPEAT_DELAY = 1500;

    RxSchedulers schedulers = new RxSchedulers();

    protected ObservableTransformer applyObservableSchedulers() {
        return upstream -> upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    protected <T> SingleTransformer<T,T> applySingleSchedulers() {
        return single -> single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    protected <T> Single<T> addRetryWhen(Single<T> single) {
        return single
                .retryWhen(throwableFlowable -> throwableFlowable
                        .take(BACKEND_MAX_RETRIES)
                        .delay(BACKEND_REPEAT_DELAY, TimeUnit.MILLISECONDS))
                .compose(applySingleSchedulers());
    }
}
