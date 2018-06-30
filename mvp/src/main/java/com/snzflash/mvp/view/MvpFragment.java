package com.snzflash.mvp.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.snzflash.di.components.AppComponent;
import com.snzflash.mvp.interfaces.IView;

abstract class MvpFragment extends Fragment implements IView {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies(getMvpApplication().getAppComponent());
    }

    @Override
    public void onDestroy() {
        beforeDestroy();
        super.onDestroy();
    }

    @Override
    public MvpApplication getMvpApplication() {
        return null;
    }

    @Override
    public void showMessage(String message) {
        Toast toast = Toast.makeText(this.getActivity(), message, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void showMessage(int messageResId) {
        String message = getString(messageResId);
        showMessage(message);
    }

    abstract void injectDependencies(AppComponent appComponent);

    abstract void beforeDestroy();
}
