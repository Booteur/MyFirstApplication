package com.horizon.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ConvertActivity extends AppCompatActivity{
    private TextView title_tv;
    private EditText value_et;
    private RadioGroup type_conversion_rg;
    private RadioButton euro2dinar_rb;
    private RadioButton dinar2euro_rd;
    private Button convert_bt;
    private TextView resutlat_conversion;
    private  Button quitter_bt;

    public TextView getTitle_tv() {
        return title_tv;
    }

    public EditText getValue_et() {
        return value_et;
    }

    public RadioGroup getType_conversion_rg() {
        return type_conversion_rg;
    }

    public RadioButton getEuro2dinar_rb() {
        return euro2dinar_rb;
    }

    public RadioButton getDinar2euro_rd() {
        return dinar2euro_rd;
    }

    public Button getConvert_bt() {
        return convert_bt;
    }

    public TextView getResutlat_conversion() {
        return resutlat_conversion;
    }

    public Button getQuitter_bt() {
        return quitter_bt;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        //on fait reference aux composants graphiques (View) avec les objets Java:

        title_tv=findViewById(R.id.title_tv);
        value_et=findViewById(R.id.value_et);
        type_conversion_rg=findViewById(R.id.type_conversion_rg);
        euro2dinar_rb=findViewById(R.id.euro2dinar_rb);
        dinar2euro_rd=findViewById(R.id.dinar2euro_rd);
        convert_bt=findViewById(R.id.convert_bt);
        resutlat_conversion=findViewById(R.id.resutlat_conversion);
        quitter_bt=findViewById(R.id.quitter_bt);

        //On programme l'action click pour les deux boutons qui peuvent etre executé sur le bouton converter et quitter
        //dans ce cas , on a utilisé une définition d'une classe soit nommé ou bien anonyme
        //Qui implements l'interface View.OnclickListener:MyOnClickListener
        /*
        convert_bt.setOnClickListener(new MyOnClickListener(this){

                                      });*/

        convert_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double resultat=0;   // c'est une variable primitive
                double val=0;
                //View est le composant graphique qui a reçu l'action
                if(view.getId()==convert_bt.getId())
                {
                    //On ecrit ici le code d'execution de la conversion
                    //les etapes
                    //1-On recupere
                    try {
                        val = Double.parseDouble(value_et.getText().toString());
                    } catch (NumberFormatException e) {
                        Toast.makeText(ConvertActivity.this,
                                "Please give a numeric value",Toast.LENGTH_LONG).show();
                        return;
                    }

                    //2-Savoir quel estv le bouton radio qui a été selectionné
                    //Si un bouton a été selectionné , on calcule le resultat
                    //sinon , on affiche un message d'erreur via une notification
                    if(euro2dinar_rb.isChecked()==true){
                        resultat = val * 3.4;

                    }
                    else{
                        if (dinar2euro_rd.isChecked()==true){
                            resultat = val / 3.4;
                        }
                        else {
                            Toast.makeText(ConvertActivity.this,
                                    "Please select one choice",Toast.LENGTH_LONG).show();
                            return;
                        }
                    }
                    resutlat_conversion.setText(resultat+"");
                }
                if(view.getId()==quitter_bt.getId()){
                    System.exit(0);
                }
            }

        });

        quitter_bt.setOnClickListener(new MyOnClickListener(this));
    }

}