package id.ac.uin_suka.learning.elearning.apihelper;

import id.ac.uin_suka.learning.elearning.model.ResponseDetailTugas;
import id.ac.uin_suka.learning.elearning.model.ResponseTugas;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BaseApiService {

    @GET("semuatugas")
    Call<ResponseTugas> getSemuaTugas();

    @GET("detailtugas/{id}")
    Call<ResponseDetailTugas> getDetailTugas(@Path("id") String id);

    // Fungsi ini untuk memanggil API http://musya11.000webhostapp.com/apimhs/login.php
    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseBody> loginRequest(@Field("username") String email,
                                    @Field("password") String password);

    // Fungsi ini untuk memanggil API http://musya11.000webhostapp.com/apimhs/register.php
    @FormUrlEncoded
    @POST("register.php")
    Call<ResponseBody> registerRequest(@Field("nama") String nama,
                                       @Field("email") String email,
                                       @Field("password") String password);
}
