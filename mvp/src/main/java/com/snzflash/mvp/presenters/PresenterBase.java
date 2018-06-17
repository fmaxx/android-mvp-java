package com.snzflash.mvp.presenters;

import com.snzflash.mvp.interfaces.IPresenter;
import com.snzflash.mvp.interfaces.IView;

public abstract class PresenterBase<V extends IView> implements IPresenter<V> {
    protected V view;

    public PresenterBase(V view) {
        this.view = view;
    }

    @Override
    public void onViewAttached() {

    }

    @Override
    public void onViewDetached() {

    }

    @Override
    public void takeView(V view) {
        this.view = view;
        onViewAttached();
    }

    @Override
    public void dropView() {
        view = null;
        onViewDetached();
    }
}
