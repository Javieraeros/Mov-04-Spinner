package es.iesnervion.fjruiz.mov_04_spinner;

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

public class Instrumentos {
    private int id;
    private String nombre;
    private Familia familia;
    private int icon;

    public Instrumentos() {
        this.id=0;
        this.nombre="Defecto";
        this.familia=Familia.Cuerda;
    }

    public Instrumentos(int id, String nombre,Familia familia, int icon) {
        this.id = id;
        this.nombre = nombre;
        this.familia = familia;
        this.icon = icon;
    }

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
}
