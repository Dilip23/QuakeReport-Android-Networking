package quakereport.model.remote;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {

    @POST("http://192.168.1.4:3000" +
            "/wearer_details")
    @FormUrlEncoded
    Call<POST> savePost(@Field("user_id") String user_id);


}
