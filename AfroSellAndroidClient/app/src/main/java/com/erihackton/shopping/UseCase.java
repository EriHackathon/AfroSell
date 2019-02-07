package com.erihackton.shopping;

/**
 * Created by aelaf on 2/5/19.
 */

public abstract class UseCase<Q extends UseCase.RequestValues,P extends UseCase.ResponseValue,S > {
    private Q mRequestValues;
    private UseCaseCallback<P,S> mUseCaseCallback;

    public Q getmRequestValues() {
        return mRequestValues;
    }

    public void setmRequestValues(Q mRequestValues) {
        this.mRequestValues = mRequestValues;
    }

    public UseCaseCallback<P,S> getmUseCaseCallback() {
        return mUseCaseCallback;
    }

    public void setmUseCaseCallback(UseCaseCallback<P,S> mUseCaseCallback) {
        this.mUseCaseCallback = mUseCaseCallback;
    }
    void run() {
        executeUseCase(mRequestValues);
    }

    protected abstract void executeUseCase(Q requestValues);
    public interface RequestValues{

    }
    public interface ResponseValue{

    }
    public interface  UseCaseCallback<R, S>{
        void onSucess(R response);
        void onError(S err);
    }
}

