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

    private Instrumento selecciona=new Instrumento(0,"Selecciona",Familia.Cuerda,R.drawable.defecto);

    private Instrumento tambor=new Instrumento(1,"Tambor",Familia.Percusión,R.drawable.tambor);
    private Instrumento piano=new Instrumento(2,"Piano",Familia.Percusión,R.drawable.piano);
    private Instrumento triangulo=new Instrumento(3,"Triangulo",Familia.Percusión,R.drawable.triangulo);

    private Instrumento violin=new Instrumento(4,"Violín",Familia.Cuerda,R.drawable.violin);
    private Instrumento viola=new Instrumento(5,"Viola",Familia.Cuerda,R.drawable.viola);
    private Instrumento violonchelo=new Instrumento(6,"Violonchelo",Familia.Cuerda,R.drawable.violonchelo);
    private Instrumento contrabajo=new Instrumento(7,"Contrabajo",Familia.Cuerda,R.drawable.contrabajo);
    private Instrumento guitarra=new Instrumento(8,"Guitarra",Familia.Cuerda,R.drawable.guitarra);

    private Instrumento saxofon=new Instrumento(9,"Saxofón",Familia.Viento,R.drawable.saxofon);
    private Instrumento clarinete=new Instrumento(10,"Clarinete",Familia.Viento,R.drawable.clarinete);
    private Instrumento trompeta=new Instrumento(11,"Trompeta",Familia.Viento,R.drawable.trompeta);
    private Instrumento trombon=new Instrumento(12,"Trombón",Familia.Viento,R.drawable.trombon);
    private Instrumento oboe=new Instrumento(13,"Oboe",Familia.Viento,R.drawable.oboe);



    private Instrumento[] percusion={selecciona,tambor,piano,triangulo};

    private Instrumento[] cuerda={selecciona,violin,viola,violonchelo,contrabajo,guitarra};

    private Instrumento[] viento={selecciona,saxofon,clarinete,trompeta,trombon,oboe};

    private Instrumento[] vacio={selecciona};



    private ArrayAdapter<Instrumento> aaInstrumento;
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
        //No usar view, porque devuelve la fila pulsada, no el spinner!!
        switch (parent.getId()){
            case R.id.familia:
                switch (position){
                    //Te selecciona el primero por defecto
                    //Por lo que el primero tiene que ser uno vacío
                    case 0:
                        aaInstrumento = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,vacio);
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
                    default:
                        Intent info=new Intent(this,Foto.class);
                        Instrumento instrumentoSeleccionado=aaInstrumento.getItem(position);
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
