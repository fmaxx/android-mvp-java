package com.snzflash.mvp.interfaces;

public interface IPresenter<V extends IView> {

    // lifecycle
    void onViewAttached();
    void onViewDetached();

    void takeView(V view);
    void dropView();

}
