package com.example.wearosvoicerecognetion;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.widget.TextView;

import com.example.wearosvoicerecognetion.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends Activity {

    private TextView mTextView;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        startActivityForResult(i,0);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mTextView = binding.text;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && requestCode == RESULT_OK){
            List<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            for (String result : results){
                Log.i("Result",result);

            }
        }
    }
}