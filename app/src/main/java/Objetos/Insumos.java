package Objetos;

import java.util.Arrays;
import java.util.Objects;

public class Insumos
{
    private int id;
    private String[] insumos = {"Mancuernas", "Barras", "Press Banca", "Puching Bag"};
    private int precio[] = {30000, 12000 , 120000 , 45000};



    public Insumos()
    {
    }

    public Insumos(int id, String[] insumos, int[] precio) {
        this.id = id;
        this.insumos = insumos;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getInsumos() {
        return insumos;
    }

    public void setInsumos(String[] insumos) {
        this.insumos = insumos;
    }

    public int[] getPrecio() {
        return precio;
    }

    public void setPrecio(int[] precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Insumos insumos1 = (Insumos) o;
        return id == insumos1.id && Arrays.equals(insumos, insumos1.insumos) && Arrays.equals(precio, insumos1.precio);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id);
        result = 31 * result + Arrays.hashCode(insumos);
        result = 31 * result + Arrays.hashCode(precio);
        return result;
    }

    @Override
    public String toString() {
        return "Insumos{" +
                "id=" + id +
                ", insumos=" + Arrays.toString(insumos) +
                ", precio=" + Arrays.toString(precio) +
                '}';
    }
    //regla de negocio
    public int anadirAdicional(int precio, int adicional)
    {
        return precio + adicional;
    }
}
