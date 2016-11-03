package es.iesnervion.fjruiz.mov_04_spinner;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String[] familias={"Selecciona",
            Familia.Cuerda.toString(),
            Familia.Percusión.toString(),
            Familia.Viento.toString()};

    private Instrumento tambor=new Instrumento(1,"Tambor",Familia.Percusión,R.drawable.defecto);
    private Instrumento selecciona=new Instrumento(0,"Selecciona",Familia.Cuerda,R.drawable.defecto);
    private Instrumento[] percusion={selecciona,tambor};

    private Instrumento[] viento={selecciona,tambor};

    private Instrumento[] cuerda={selecciona,tambor};

    private Instrumento[] vacio={selecciona};

    //Necesario porque lo uso en dos métodos diferentes
    private Spinner familia;
    private Spinner instrumentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        familia=(Spinner) findViewById(R.id.familia);
        instrumentos= (Spinner) findViewById(R.id.instrumentos);

        familia.setOnItemSelectedListener(this);
        instrumentos.setOnItemSelectedListener(this);

        ArrayAdapter<String> aaFamilia=new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,familias);

        aaFamilia.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        familia.setAdapter(aaFamilia);


        /**
         * Intentar guardar los instrumentos en ficheros
         */
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ArrayAdapter<Instrumento> aaInstrumento = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,vacio);
        //No usar view, porque devuelve la fila pulsada, no el spinner!!
        switch (parent.getId()){
            case R.id.familia:
                switch (position){
                    //Te selecciona el primero por defecto
                    //Por lo que el primero tiene que ser uno vacío
                    case 0:
                        break;
                    case 1:
                        aaInstrumento=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,cuerda);
                        break;
                    case 2:
                        aaInstrumento=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,percusion);
                        break;
                    case 3:
                        aaInstrumento=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,viento);
                        break;
                }
                aaInstrumento.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                instrumentos.setAdapter(aaInstrumento);
                break;
            case R.id.instrumentos:
                switch (position){
                    case 0:
                        break;
                    case 1:
                        Intent info=new Intent(this,Foto.class);
                        Instrumento instrumentoSeleccionado=(Instrumento) aaInstrumento.getItem(position);
                        info.putExtra("instrumento",instrumentoSeleccionado);
                        startActivity(info);
                        break;
                }

                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
