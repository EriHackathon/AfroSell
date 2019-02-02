package erihackton.com.aelaf.erishopclient;

import android.util.Log;

/**
 * Created by aelaf on 1/29/19.
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
    public <T extends UseCase.RequestValues,R extends UseCase.ResponseValue> void execute(final UseCase<T,R> useCase, T values, UseCase.UseCaseCallback<R> callback){
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

    public<V extends UseCase.ResponseValue> void notifyResponse(final V response,final UseCase.UseCaseCallback<V> useCaseCallback){
        mUseCaseScheduler.notifyResponse(response,useCaseCallback);
    }

    public <V extends UseCase.ResponseValue> void notifyError(final UseCase.UseCaseCallback<V> useCaseCallback){
        mUseCaseScheduler.onError(useCaseCallback);
    }

    private static final class UiCallbackWrapper<V extends UseCase.ResponseValue> implements
            UseCase.UseCaseCallback<V>{

        private final UseCase.UseCaseCallback<V> mCallback;
        private final UseCaseHandler mUseCaseHandler;
        public UiCallbackWrapper(UseCase.UseCaseCallback<V> callback,
                                 UseCaseHandler useCaseHandler) {
            mCallback = callback;
            mUseCaseHandler = useCaseHandler;
        }

        @Override
        public void onSucess(V response) {
            mUseCaseHandler.notifyResponse(response,mCallback);
        }

        @Override
        public void onError() {
            mUseCaseHandler.notifyError(mCallback);
        }
    }
}
