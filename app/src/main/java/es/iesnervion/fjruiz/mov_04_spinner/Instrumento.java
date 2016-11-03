package es.iesnervion.fjruiz.mov_04_spinner;

import android.os.Parcel;
import android.os.Parcelable;

/**************
 * Propiedades
 * ***********
 * Basicas:
 * ID: integer,consultable and modificable
 * Nombre: String,consultable and modificable
 * icon: int, consultable and modificable
 * familia: enum Familia, consultable and modificable
 *
 * Derivadas:
 *
 *
 * Compartidas:
 *
 *
 * Restricciones:
 *
 *
 */

public class Instrumento implements Parcelable {
    private int id;
    private String nombre;
    private Familia familia;
    private int icon;

    public Instrumento() {
        this.id=0;
        this.nombre="Defecto";
        this.familia=Familia.Cuerda;
    }

    public Instrumento(int id, String nombre, Familia familia, int icon) {
        this.id = id;
        this.nombre = nombre;
        this.familia = familia;
        this.icon = icon;
    }

    protected Instrumento(Parcel in) {
        id = in.readInt();
        nombre = in.readString();
        icon = in.readInt();
    }

    public static final Creator<Instrumento> CREATOR = new Creator<Instrumento>() {
        @Override
        public Instrumento createFromParcel(Parcel in) {
            return new Instrumento(in);
        }

        @Override
        public Instrumento[] newArray(int size) {
            return new Instrumento[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    @Override
    public String toString(){
        return nombre;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nombre);
        dest.writeInt(icon);
    }
}
