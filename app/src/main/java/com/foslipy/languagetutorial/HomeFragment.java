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
    CardView java, cprogramming, php, ruby, c_plus, c_sharp, perl, python, swift, xml;
    String language_selected;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_fragment_layout, container, false);

        language_selected = "Java";
        Helper.language = language_selected;

        cprogramming = view.findViewById(R.id.CardView_Language_C);
        c_plus = view.findViewById(R.id.CardView_Language_C_Pls);
        c_sharp = view.findViewById(R.id.CardView_Language_C_sharp);
        java = view.findViewById(R.id.CardView_language_java);
        perl = view.findViewById(R.id.CardView_Language_Perl);
        php = view.findViewById(R.id.CardView_Language_php);
        python = view.findViewById(R.id.CardView_Language_Python);
        ruby = view.findViewById(R.id.CardView_Language_Ruby);
        swift = view.findViewById(R.id.CardView_Language_Swift);
        xml = view.findViewById(R.id.CardView_Language_xml);


        final RadioButton cRadioButton = view.findViewById(R.id.c_rb);
        final RadioButton c_plsRadioButton = view.findViewById(R.id.c_pls_rb);
        final RadioButton c_sharpRadioButton = view.findViewById(R.id.C_sharp_rb);
        final RadioButton javaRadioButton = view.findViewById(R.id.java_rb);
        final RadioButton perlRadioButton = view.findViewById(R.id.Perl_rb);
        final RadioButton phpRadioButton = view.findViewById(R.id.php_rb);
        final RadioButton pythonRadioButton = view.findViewById(R.id.Python_rb);
        final RadioButton rubyRadioButton = view.findViewById(R.id.Ruby_rb);
        final RadioButton swiftRadioButton = view.findViewById(R.id.Swift_rb);
        final RadioButton xmlRadioButton = view.findViewById(R.id.xml_rb);





        cprogramming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cRadioButton.setChecked(true);
                c_plsRadioButton.setChecked(false);
                c_sharpRadioButton.setChecked(false);
                javaRadioButton.setChecked(false);
                perlRadioButton.setChecked(false);
                phpRadioButton.setChecked(false);
                pythonRadioButton.setChecked(false);
                rubyRadioButton.setChecked(false);
                swiftRadioButton.setChecked(false);
                xmlRadioButton.setChecked(false);
                language_selected = "C Programming";
                Helper.language = language_selected;
            }
        });

        c_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cRadioButton.setChecked(false);
                c_plsRadioButton.setChecked(true);
                c_sharpRadioButton.setChecked(false);
                javaRadioButton.setChecked(false);
                perlRadioButton.setChecked(false);
                phpRadioButton.setChecked(false);
                pythonRadioButton.setChecked(false);
                rubyRadioButton.setChecked(false);
                swiftRadioButton.setChecked(false);
                xmlRadioButton.setChecked(false);
                language_selected = "C++";
                Helper.language = language_selected;
            }
        });

        c_sharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cRadioButton.setChecked(false);
                c_plsRadioButton.setChecked(false);
                c_sharpRadioButton.setChecked(true);
                javaRadioButton.setChecked(false);
                perlRadioButton.setChecked(false);
                phpRadioButton.setChecked(false);
                pythonRadioButton.setChecked(false);
                rubyRadioButton.setChecked(false);
                swiftRadioButton.setChecked(false);
                xmlRadioButton.setChecked(false);
                language_selected = "C#";
                Helper.language = language_selected;
            }
        });

        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cRadioButton.setChecked(false);
                c_plsRadioButton.setChecked(false);
                c_sharpRadioButton.setChecked(false);
                javaRadioButton.setChecked(true);
                perlRadioButton.setChecked(false);
                phpRadioButton.setChecked(false);
                pythonRadioButton.setChecked(false);
                rubyRadioButton.setChecked(false);
                swiftRadioButton.setChecked(false);
                xmlRadioButton.setChecked(false);
                language_selected = "Java";
                Helper.language = language_selected;
            }
        });

        perl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cRadioButton.setChecked(false);
                c_plsRadioButton.setChecked(false);
                c_sharpRadioButton.setChecked(false);
                javaRadioButton.setChecked(false);
                perlRadioButton.setChecked(true);
                phpRadioButton.setChecked(false);
                pythonRadioButton.setChecked(false);
                rubyRadioButton.setChecked(false);
                swiftRadioButton.setChecked(false);
                xmlRadioButton.setChecked(false);
                language_selected = "Perl";
                Helper.language = language_selected;
            }
        });
        php.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cRadioButton.setChecked(false);
                c_plsRadioButton.setChecked(false);
                c_sharpRadioButton.setChecked(false);
                javaRadioButton.setChecked(false);
                perlRadioButton.setChecked(false);
                phpRadioButton.setChecked(true);
                pythonRadioButton.setChecked(false);
                rubyRadioButton.setChecked(false);
                swiftRadioButton.setChecked(false);
                xmlRadioButton.setChecked(false);
                language_selected = "PHP";
                Helper.language = language_selected;
            }
        });

        python.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cRadioButton.setChecked(false);
                c_plsRadioButton.setChecked(false);
                c_sharpRadioButton.setChecked(false);
                javaRadioButton.setChecked(false);
                perlRadioButton.setChecked(false);
                phpRadioButton.setChecked(false);
                pythonRadioButton.setChecked(true);
                rubyRadioButton.setChecked(false);
                swiftRadioButton.setChecked(false);
                xmlRadioButton.setChecked(false);
                language_selected = "Python";
                Helper.language = language_selected;
            }
        });

        ruby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cRadioButton.setChecked(false);
                c_plsRadioButton.setChecked(false);
                c_sharpRadioButton.setChecked(false);
                javaRadioButton.setChecked(false);
                perlRadioButton.setChecked(false);
                phpRadioButton.setChecked(false);
                pythonRadioButton.setChecked(false);
                rubyRadioButton.setChecked(true);
                swiftRadioButton.setChecked(false);
                xmlRadioButton.setChecked(false);
                language_selected = "Ruby";
                Helper.language = language_selected;
            }
        });

        swift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cRadioButton.setChecked(false);
                c_plsRadioButton.setChecked(false);
                c_sharpRadioButton.setChecked(false);
                javaRadioButton.setChecked(false);
                perlRadioButton.setChecked(false);
                phpRadioButton.setChecked(false);
                pythonRadioButton.setChecked(false);
                rubyRadioButton.setChecked(false);
                swiftRadioButton.setChecked(true);
                xmlRadioButton.setChecked(false);
                language_selected = "Swift";
                Helper.language = language_selected;
            }
        });

        xml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cRadioButton.setChecked(false);
                c_plsRadioButton.setChecked(false);
                c_sharpRadioButton.setChecked(false);
                javaRadioButton.setChecked(false);
                perlRadioButton.setChecked(false);
                phpRadioButton.setChecked(false);
                pythonRadioButton.setChecked(false);
                rubyRadioButton.setChecked(false);
                swiftRadioButton.setChecked(false);
                xmlRadioButton.setChecked(true);
                language_selected = "XML";
                Helper.language = language_selected;
            }
        });










        cRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cRadioButton.setChecked(true);
                c_plsRadioButton.setChecked(false);
                c_sharpRadioButton.setChecked(false);
                javaRadioButton.setChecked(false);
                perlRadioButton.setChecked(false);
                phpRadioButton.setChecked(false);
                pythonRadioButton.setChecked(false);
                rubyRadioButton.setChecked(false);
                swiftRadioButton.setChecked(false);
                xmlRadioButton.setChecked(false);
                language_selected = "C Programming";
                Helper.language = language_selected;
            }
        });

        c_plsRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cRadioButton.setChecked(false);
                c_plsRadioButton.setChecked(true);
                c_sharpRadioButton.setChecked(false);
                javaRadioButton.setChecked(false);
                perlRadioButton.setChecked(false);
                phpRadioButton.setChecked(false);
                pythonRadioButton.setChecked(false);
                rubyRadioButton.setChecked(false);
                swiftRadioButton.setChecked(false);
                xmlRadioButton.setChecked(false);
                language_selected = "C++";
                Helper.language = language_selected;
            }
        });

        c_sharpRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cRadioButton.setChecked(false);
                c_plsRadioButton.setChecked(false);
                c_sharpRadioButton.setChecked(true);
                javaRadioButton.setChecked(false);
                perlRadioButton.setChecked(false);
                phpRadioButton.setChecked(false);
                pythonRadioButton.setChecked(false);
                rubyRadioButton.setChecked(false);
                swiftRadioButton.setChecked(false);
                xmlRadioButton.setChecked(false);
                language_selected = "C#";
                Helper.language = language_selected;
            }
        });

        javaRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cRadioButton.setChecked(false);
                c_plsRadioButton.setChecked(false);
                c_sharpRadioButton.setChecked(false);
                javaRadioButton.setChecked(true);
                perlRadioButton.setChecked(false);
                phpRadioButton.setChecked(false);
                pythonRadioButton.setChecked(false);
                rubyRadioButton.setChecked(false);
                swiftRadioButton.setChecked(false);
                xmlRadioButton.setChecked(false);
                language_selected = "Java";
                Helper.language = language_selected;
            }
        });

        perlRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cRadioButton.setChecked(false);
                c_plsRadioButton.setChecked(false);
                c_sharpRadioButton.setChecked(false);
                javaRadioButton.setChecked(false);
                perlRadioButton.setChecked(true);
                phpRadioButton.setChecked(false);
                pythonRadioButton.setChecked(false);
                rubyRadioButton.setChecked(false);
                swiftRadioButton.setChecked(false);
                xmlRadioButton.setChecked(false);
                language_selected = "Perl";
                Helper.language = language_selected;
            }
        });

        phpRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cRadioButton.setChecked(false);
                c_plsRadioButton.setChecked(false);
                c_sharpRadioButton.setChecked(false);
                javaRadioButton.setChecked(false);
                perlRadioButton.setChecked(false);
                phpRadioButton.setChecked(true);
                pythonRadioButton.setChecked(false);
                rubyRadioButton.setChecked(false);
                swiftRadioButton.setChecked(false);
                xmlRadioButton.setChecked(false);
                language_selected = "PHP";
                Helper.language = language_selected;
            }
        });

        pythonRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cRadioButton.setChecked(false);
                c_plsRadioButton.setChecked(false);
                c_sharpRadioButton.setChecked(false);
                javaRadioButton.setChecked(false);
                perlRadioButton.setChecked(false);
                phpRadioButton.setChecked(false);
                pythonRadioButton.setChecked(true);
                rubyRadioButton.setChecked(false);
                swiftRadioButton.setChecked(false);
                xmlRadioButton.setChecked(false);
                language_selected = "Python";
                Helper.language = language_selected;
            }
        });

        rubyRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cRadioButton.setChecked(false);
                c_plsRadioButton.setChecked(false);
                c_sharpRadioButton.setChecked(false);
                javaRadioButton.setChecked(false);
                perlRadioButton.setChecked(false);
                phpRadioButton.setChecked(false);
                pythonRadioButton.setChecked(false);
                rubyRadioButton.setChecked(true);
                swiftRadioButton.setChecked(false);
                xmlRadioButton.setChecked(false);
                language_selected = "Ruby";
                Helper.language = language_selected;
            }
        });

        swiftRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cRadioButton.setChecked(false);
                c_plsRadioButton.setChecked(false);
                c_sharpRadioButton.setChecked(false);
                javaRadioButton.setChecked(false);
                perlRadioButton.setChecked(false);
                phpRadioButton.setChecked(false);
                pythonRadioButton.setChecked(false);
                rubyRadioButton.setChecked(false);
                swiftRadioButton.setChecked(true);
                xmlRadioButton.setChecked(false);
                language_selected = "Swift";
                Helper.language = language_selected;
            }
        });

        xmlRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cRadioButton.setChecked(false);
                c_plsRadioButton.setChecked(false);
                c_sharpRadioButton.setChecked(false);
                javaRadioButton.setChecked(false);
                perlRadioButton.setChecked(false);
                phpRadioButton.setChecked(false);
                pythonRadioButton.setChecked(false);
                rubyRadioButton.setChecked(false);
                swiftRadioButton.setChecked(false);
                xmlRadioButton.setChecked(true);
                language_selected = "XML";
                Helper.language = language_selected;
            }
        });

        return view;
    }
}
