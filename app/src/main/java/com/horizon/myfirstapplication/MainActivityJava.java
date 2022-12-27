package com.horizon.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivityJava extends AppCompatActivity implements View.OnClickListener{

    private  LinearLayout myLayout;
    private TextView title_tv;
    private EditText value_et;
    private RadioGroup type_conversion_rg;
    private RadioButton euro2dinar_rb;
    private RadioButton dinar2euro_rd;
    private Button convert_bt;
    private TextView resutlat_conversion;
    private  Button quitter_bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //creation du layout (viewgroup) de la vue:
        LinearLayout myLayout = new LinearLayout(this);
        myLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        myLayout.setLayoutParams(layoutParams);
        myLayout.setBackgroundColor(Color.GRAY);

        //Creation des differentes view (composants graphiques) de l'interface
        title_tv = new TextView(this);
        title_tv.setText(R.string.title_lab);
        title_tv.setTextSize(30);
        title_tv.setTextAlignment(ViewGroup.TEXT_ALIGNMENT_CENTER);
        title_tv.setTextAlignment(ViewGroup.TEXT_ALIGNMENT_CENTER);
        value_et = new EditText(this);
        value_et.setHint(R.string.insert);
        type_conversion_rg = new RadioGroup(this);
        euro2dinar_rb = new RadioButton(this);
        euro2dinar_rb.setText(R.string.euro2dinar_lab);
        dinar2euro_rd = new RadioButton(this);
        dinar2euro_rd.setText(R.string.dinar2euro_lab);
        //ajouter les deux boutons à leur conteneru ( ViewGroup )type_conversion_rg
        type_conversion_rg.addView(euro2dinar_rb);
        type_conversion_rg.addView(dinar2euro_rd);
        convert_bt = new Button(this);
        convert_bt.setText(R.string.convert_lab);
        convert_bt.setTextColor(Color.YELLOW);
        convert_bt.setBackgroundColor(Color.BLUE);
        //creation de la zone d'affichage du resultat
        resutlat_conversion = new TextView(this);
        resutlat_conversion.setText(R.string.resultat_lab);
        //creation du bouton quitter
        quitter_bt= new Button(this);
        quitter_bt.setText(R.string.quitter_lab);
        //on ajoute les differentes views crées dans le layout principale
        myLayout.addView(title_tv);
        myLayout.addView(value_et);
        myLayout.addView(type_conversion_rg);
        myLayout.addView(convert_bt);
        myLayout.addView(resutlat_conversion);
        myLayout.addView(quitter_bt);
        //affichage de la vue associée à l'activité
        setContentView(myLayout);

    }

    @Override
    public void onClick(View v) {

    }
}
