package api;

import dto.DTO;
import dto.DTOSingle;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIInterface {

    @GET("products")
    Call<DTO> findAll();

   @GET("products/{id}")
    Call<DTOSingle> find(@Path("id") int id);


}
