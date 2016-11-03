package es.iesnervion.fjruiz.mov_04_spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Foto extends AppCompatActivity {

    Instrumento seleccionado;
    Bundle datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);

        datos = getIntent().getExtras();
        seleccionado = (Instrumento) datos.getParcelable("equipo");

        ImageView imagen=(ImageView) findViewById(R.id.foto);
        imagen.setImageResource(seleccionado.getIcon());

    }
}
