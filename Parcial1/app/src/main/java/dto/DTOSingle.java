package dto;

import com.google.gson.annotations.SerializedName;
import entity.Producto;

import java.io.Serializable;

public class DTOSingle implements Serializable {

    @SerializedName("data")
    public Producto data;

    public DTOSingle(Producto data) {
        this.data = data;
    }

}
