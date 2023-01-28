package com.example.alcohol.extensions;

import android.view.View;

public class Extensions {
    public static void visible (View v) {
        v.setVisibility(View.VISIBLE);
    }

    public static void gone (View v) {
        v.setVisibility(View.GONE);
    }

    public static void invisible (View v) {
        v.setVisibility(View.INVISIBLE);
    }
}
