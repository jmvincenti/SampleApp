package com.jmvincenti.sample.base;

/**
 * Created by jmvincenti on 29/04/2017.
 */

public interface BaseContract {
    interface BaseViewContract {
    }

    interface BasePresenterContract {
        void subscribe();
        void unsubscribe();
    }
}
