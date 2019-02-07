package com.erihackton.shopping;

/**
 * Created by aelaf on 2/5/19.
 */

public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
}
