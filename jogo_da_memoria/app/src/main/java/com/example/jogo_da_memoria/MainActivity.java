package com.example.jogo_da_memoria;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<Integer> numeros = Arrays.asList(1,2,3,4,5,6);
    public static List<Integer> IDS = Arrays.asList(R.id.button_1,R.id.button_2,R.id.button_3,R.id.button_4,R.id.button_5,R.id.button_6);
    public static List<Integer> cores = Arrays.asList(R.color.red,R.color.green,R.color.purple,R.color.blue,R.color.pink,R.color.yellow);
    public static int cont=0;
    public static ProgressBar progressBar;
    public static  LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progress_bar);
        linearLayout = findViewById(R.id.parent);
        adicionaCores();
        geraSequenciaAleatoria();
        inicializaBotoes();
    }

    public void geraSequenciaAleatoria(){
        Collections.shuffle(numeros);
        System.out.println("Sequência: "+numeros.toString());
    }

    public void inicializaBotoes(){
        Button button;

        for(int id : IDS){

            button = findViewById(id);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (id == IDS.get(numeros.get(cont)-1)){
                        view.setVisibility(View.INVISIBLE);
                        progressBar.incrementProgressBy(16);
                        linearLayout.setBackgroundColor(getResources().getColor(cores.get(numeros.get(cont)-1)));
                        cont++;
                    }else reinicia(view);

                    if(cont==6){
                        venceu();
                        resetaBackgroundColor();
                    }

                }
            });
        }
    }

    public void venceu(){
        Toast.makeText(this, "Parabéns, você venceu",Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.INVISIBLE);
    }


    public void reinicia(View view){
        resetaBotoes();
        geraSequenciaAleatoria();
        resetaProgressBar();
        resetaBackgroundColor();
        cont = 0;
    }

    public void resetaBotoes(){
        for(int id : IDS) findViewById(id).setVisibility(View.VISIBLE);
    }

    public void resetaBackgroundColor(){
        linearLayout.setBackgroundColor(getResources().getColor(R.color.white));
    }

    public void resetaProgressBar(){
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setProgress(0);
    }

    public void adicionaCores(){
        Button button;
        for(int i=0; i<IDS.size(); i++){
            button = findViewById(IDS.get(i));
            button.setBackgroundColor(getResources().getColor(cores.get(i)));
        }
    }

}