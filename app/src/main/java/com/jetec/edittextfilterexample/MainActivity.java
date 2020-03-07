package com.jetec.edittextfilterexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText = findViewById(R.id.editText);
        editText.setFilters(new InputFilter[]{inputFilter});

    }

    private InputFilter inputFilter = new InputFilter() {
        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            /* source:偵測輸入內容
             start:偵測輸入字的開始點
             end:偵測输入字的结束點
             dest：顯示當前顯示的內容
             dstart:控制光標的開始位置
             dent:控制光標的結束位置*/

            if (dest.length() == 0 && source.equals(".")) {
                return "0.";
            }
            String dValue = dest.toString();
            String[] splitArray = dValue.split("\\.");
            if (splitArray.length > 1) {
                String dotValue = splitArray[1];
                int dp = 3;
                if (dotValue.length() == dp) {
                    return "";
                }
            }
            return null;

        }
    };
    private InputFilter lambdaFilter = (source, start, end, dest, dstart, dend)->{
        return null;

    };
}
