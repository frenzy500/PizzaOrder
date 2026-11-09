package com.example.pizzaorder;

import android.app.Activity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class RG {
    public static String RGtext(Activity activity, int radioGroupId) {
        RadioGroup rgSize = activity.findViewById(radioGroupId);
        int selectedId = rgSize.getCheckedRadioButtonId();
        if (selectedId == -1) {
            return "";
        }
        RadioButton selectedRadioButton = activity.findViewById(selectedId);
        return selectedRadioButton.getText().toString();
    }
}