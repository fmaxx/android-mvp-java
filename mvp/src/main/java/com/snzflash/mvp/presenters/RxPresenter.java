package com.snzflash.mvp.presenters;

import com.snzflash.mvp.interfaces.IView;

import io.reactivex.disposables.CompositeDisposable;

public class RxPresenter <V extends IView> extends PresenterBase<V> {
    protected CompositeDisposable subscriptions;

    public RxPresenter(V view) {
        super(view);
        subscriptions = new CompositeDisposable();
    }
}
