package com.foslipy.languagetutorial;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

public class HomeFragment extends Fragment {

    View view;
    CardView java, cprogramming, php, ruby;
    String language_selected;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_fragment_layout, container, false);


        java = view.findViewById(R.id.CardView_language_java);
        cprogramming = view.findViewById(R.id.CardView_Language_C);
        php = view.findViewById(R.id.CardView_Language_php);
        ruby = view.findViewById(R.id.CardView_Language_Ruby);

        final RadioButton javaRadioButton = view.findViewById(R.id.java_rb);
        final RadioButton cRadioButton = view.findViewById(R.id.c_rb);
        final RadioButton phpRadioButton = view.findViewById(R.id.php_rb);
        final RadioButton rubyRadioButton = view.findViewById(R.id.Ruby_rb);


        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                javaRadioButton.setChecked(true);
                rubyRadioButton.setChecked(false);
                phpRadioButton.setChecked(false);
                cRadioButton.setChecked(false);
                language_selected="Java";
                Helper.language=language_selected;
            }
        });
        cprogramming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cRadioButton.setChecked(true);
                rubyRadioButton.setChecked(false);
                javaRadioButton.setChecked(false);
                phpRadioButton.setChecked(false);
                language_selected="C Programming";
                Helper.language=language_selected;
            }
        });
        php.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phpRadioButton.setChecked(true);
                rubyRadioButton.setChecked(false);
                javaRadioButton.setChecked(false);
                cRadioButton.setChecked(false);
                language_selected="PHP";
                Helper.language=language_selected;
            }
        });

        ruby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rubyRadioButton.setChecked(true);
                javaRadioButton.setChecked(false);
                phpRadioButton.setChecked(false);
                cRadioButton.setChecked(false);
                language_selected="Ruby";
                Helper.language=language_selected;
            }
        });

        javaRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rubyRadioButton.setChecked(false);
                phpRadioButton.setChecked(false);
                cRadioButton.setChecked(false);
                language_selected="Java";
                Helper.language=language_selected;
            }
        });

        cRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rubyRadioButton.setChecked(false);
                javaRadioButton.setChecked(false);
                phpRadioButton.setChecked(false);
                cRadioButton.setChecked(false);
                language_selected="C Programming";
                Helper.language=language_selected;
            }
        });

        phpRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rubyRadioButton.setChecked(false);
                javaRadioButton.setChecked(false);
                cRadioButton.setChecked(false);
                language_selected="PHP";
                Helper.language=language_selected;
            }
        });

        rubyRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                javaRadioButton.setChecked(false);
                phpRadioButton.setChecked(false);
                cRadioButton.setChecked(false);
                language_selected="Ruby";
                Helper.language=language_selected;
            }
        });

        return view;
    }
}
