package com.example.exercicio_button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    androidx.constraintlayout.widget.ConstraintLayout back;
    Button button_1;
    Button button_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        back = findViewById(R.id.parent);
        button_1 = findViewById(R.id.button_create);
        button_2 = new Button(MainActivity.this);

    }

    public void create_new_button(View view){
        int id = 2;

        if(findViewById(id)==null)
        {

            LinearLayout.LayoutParams positionParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            //positionParams.setMargins(15, 15, 15, 0);

            button_2.setText("button 2");
            button_2.setId(id);
            back.addView(button_2,positionParams);

            button_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.setVisibility(v.INVISIBLE);
                }
            });

            button_2.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    day_of_the_week();
                    return true;
                }
            });
        }
        else
            button_2.setVisibility(View.VISIBLE);
    }

    public void day_of_the_week(){
        Calendar calendar = Calendar.getInstance();
        Toast.makeText(this, search_day(calendar.get(Calendar.DAY_OF_WEEK)), Toast.LENGTH_SHORT).show();
    }

    public String search_day(int dia){
        String dias[] = {"DOMINGO","SEGUNDA","TERÇA","QUARTA","QUINTA","SEXTA","SÁBADO"};
        return dias[dia-1];
    }
}