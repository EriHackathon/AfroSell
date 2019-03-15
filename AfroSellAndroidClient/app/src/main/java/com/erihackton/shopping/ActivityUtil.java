package com.erihackton.shopping;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.text.SimpleDateFormat;

import retrofit2.http.DELETE;

/**
 * Created by aelaf on 2/5/19.
 */

public class ActivityUtil {
    public static void addFragmentToActivity (@NonNull FragmentManager fragmentManager,
                                              @NonNull Fragment fragment, int frameId) {


        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(frameId, fragment);

        transaction.commit();
    }
}
