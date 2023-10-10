package dto;

import androidx.lifecycle.MutableLiveData;
import com.google.gson.annotations.SerializedName;
import entity.Producto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DTO implements Serializable {
    @SerializedName("id")
    public int id;
    @SerializedName("title")
    public String nombre;
@SerializedName("description")
    public String descripcion;
@SerializedName("price")
    public float precio;
@SerializedName("discountPercentage")
    public float descuento;
@SerializedName("rating")
    public float rating;
@SerializedName("brand")
    public String marca;
@SerializedName("category")
    public  String categoria;
@SerializedName("stock")
    public int stock;
@SerializedName("thumbnail")
public String imagen;

    @SerializedName("products")
    public List<Producto> data;

    public DTO(int id, String nombre, String descripcion, float precio, float descuento, float rating, String marca, String categoria, int stock,String imagen, List<Producto> data) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.descuento = descuento;
        this.rating = rating;
        this.marca = marca;
        this.categoria = categoria;
        this.stock = stock;
        this.imagen = imagen;
        this.data = data;
    }

    public List<Producto> getData() {
        return data;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
