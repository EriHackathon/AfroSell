package com.erihackton.shopping;

import android.util.Log;

/**
 * Created by aelaf on 2/5/19.
 */

public class UseCaseHandler {
    public static final String TAG = "UseCaseHandler";
    private static UseCaseHandler INSTANCE;
    public static UseCaseHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UseCaseHandler(new UseCaseThreadPoolScheduler());
        }
        return INSTANCE;
    }
    private final UseCaseScheduler mUseCaseScheduler;
    public UseCaseHandler(UseCaseScheduler useCaseScheduler){
        mUseCaseScheduler = useCaseScheduler;
    }
    public <T extends UseCase.RequestValues,R extends UseCase.ResponseValue,S> void execute(final UseCase<T,R,S> useCase, T values, UseCase.UseCaseCallback<R,S> callback){
        Log.d(TAG, "execute: ");
        useCase.setmRequestValues(values);
        useCase.setmUseCaseCallback(new UiCallbackWrapper(callback,this));
        //off UI thread work
        mUseCaseScheduler.execute(new Runnable() {
            @Override
            public void run() {
                useCase.run();
            }
        });
    }

    public<V extends UseCase.ResponseValue,S> void notifyResponse(final V response,final UseCase.UseCaseCallback<V,S> useCaseCallback){
        mUseCaseScheduler.notifyResponse(response,useCaseCallback);
    }

    public <S,V extends UseCase.ResponseValue> void notifyError(S err,final UseCase.UseCaseCallback<V,S> useCaseCallback){
        mUseCaseScheduler.onError(err,useCaseCallback);
    }

    private static final class UiCallbackWrapper<V extends UseCase.ResponseValue,S> implements
            UseCase.UseCaseCallback<V,S>{

        private final UseCase.UseCaseCallback<V,S> mCallback;
        private final UseCaseHandler mUseCaseHandler;
        public UiCallbackWrapper(UseCase.UseCaseCallback<V,S> callback,
                                 UseCaseHandler useCaseHandler) {
            mCallback = callback;
            mUseCaseHandler = useCaseHandler;
        }

        @Override
        public void onSucess(V response) {
            mUseCaseHandler.notifyResponse(response,mCallback);
        }

        @Override
        public void onError(S err) {
            mUseCaseHandler.notifyError(err,mCallback);
        }

    }
}
