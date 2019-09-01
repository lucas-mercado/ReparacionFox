package app.lemfox.reparacion;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Inicio extends AppCompatActivity {
    private CalendarView fechas;
    private TextView txt_fecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //obtener fecha
        fechas = (CalendarView) findViewById(R.id.c_calendario);
        //obtener textview
        txt_fecha = (TextView) findViewById(R.id.l_fecha);
        //utilizar textview y le asigno la fecha selecionada
        fechas.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String fecha = dayOfMonth+"/"+month+"/"+year;
                txt_fecha.setText(fecha);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void recepcion(View v){
        if(!txt_fecha.getText().toString().equals("Fecha")) {
            Intent in = new Intent(this, Reparacion.class);
            in.putExtra("getFecha", txt_fecha.getText().toString());
            startActivity(in);
        }
        else
            Toast.makeText(this,"No a selecionado una fecha ",Toast.LENGTH_SHORT).show();
    }

}
