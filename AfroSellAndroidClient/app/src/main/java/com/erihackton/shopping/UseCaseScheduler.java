package com.erihackton.shopping;

/**
 * Created by aelaf on 2/5/19.
 */

public interface UseCaseScheduler {
    void execute(Runnable runnable);
    <V extends UseCase.ResponseValue,S > void notifyResponse(final V Response, final UseCase.UseCaseCallback<V,S> callback);
    <V extends UseCase.ResponseValue,S> void onError(final S err,final UseCase.UseCaseCallback<V,S> callback);

}
