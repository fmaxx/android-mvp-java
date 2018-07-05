package com.snzflash.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.snzflash.di.components.AppComponent;
import com.snzflash.mvp.interfaces.IView;

import butterknife.ButterKnife;

abstract public class MvpActivity extends AppCompatActivity implements IView {


    @Override
    public MvpApplication getMvpApplication() {
        return (MvpApplication) getApplication();
    }

    @Override
    public void showMessage(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void showMessage(int messageResId) {
        String message = getString(messageResId);
        showMessage(message);
    }

    abstract protected void initViews();

    @Override
    public void onStop() {
        beforeStop();
        super.onStop();
    }

    abstract protected void beforeStop();

    abstract protected void injectDependencies(AppComponent appComponent);
}
