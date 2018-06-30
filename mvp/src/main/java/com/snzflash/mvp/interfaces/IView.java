package com.snzflash.mvp.interfaces;

import android.app.Application;

import com.snzflash.mvp.view.MvpApplication;

public interface IView {

    MvpApplication getMvpApplication();
    void showMessage(String message);
    void showMessage(int resourceId);
}
