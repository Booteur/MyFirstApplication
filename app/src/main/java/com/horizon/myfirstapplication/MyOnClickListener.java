package com.horizon.myfirstapplication;

import android.view.View;
import android.widget.Toast;

public class MyOnClickListener implements View.OnClickListener {

        ConvertActivity currentActivity;


        public MyOnClickListener(ConvertActivity currentActivity) {
        this.currentActivity = currentActivity;
    }

    @Override
    //On implements la methode onClick
    public void onClick(View view) {
        double resultat=0;   // c'est une variable primitive
        double val=0;
        //View est le composant graphique qui a reçu l'action
        if(view.getId()==currentActivity.getConvert_bt().getId())
            {
        //On ecrit ici le code d'execution de la conversion
            //les etapes
            //1-On recupere
            try {
                val = Double.parseDouble(currentActivity.getValue_et().getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(currentActivity,
                        "Please give a numeric value",Toast.LENGTH_LONG).show();
                return;
            }

        //2-Savoir quel est le bouton radio qui a été selectionné
            //Si un bouton a été selectionné , on calcule le resultat
            //sinon , on affiche un message d'erreur via une notification

            if(currentActivity.getEuro2dinar_rb().isChecked()==true){
               resultat = val * 3.4;

            }
            else{
                if (currentActivity.getDinar2euro_rd().isChecked()==true){
                    resultat = val / 3.4;
                }
                else {
                    Toast.makeText(currentActivity,
                            "Please select one choice",Toast.LENGTH_LONG).show();
                    return;
                }
            }
            currentActivity.getResutlat_conversion().setText(resultat+"");
        }
        if(view.getId()==currentActivity.getQuitter_bt().getId()){
            System.exit(0);
        }
    }
}
