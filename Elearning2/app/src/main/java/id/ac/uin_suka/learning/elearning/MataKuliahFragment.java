package id.ac.uin_suka.learning.elearning;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.ac.uin_suka.learning.elearning.adapter.MakulAdapter;
import id.ac.uin_suka.learning.elearning.apihelper.BaseApiService;
import id.ac.uin_suka.learning.elearning.apihelper.UtilsApi;
import id.ac.uin_suka.learning.elearning.model.MakulItem;
import id.ac.uin_suka.learning.elearning.model.ResponseMakul;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MataKuliahFragment extends Fragment {
    RecyclerView rview;

    //ProgressBar bar;
    MataKuliahFragment mContext;
    List<MakulItem> makulItems = new ArrayList<>();
    MakulAdapter makulAdapter;
    BaseApiService mApiService;

    SharePrefManager sharePrefManager;

    String nim,sem;
    int tahun;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_mata_kuliah, container, false);

        View view = inflater.inflate(R.layout.fragment_mata_kuliah, container, false);
        getActivity().setTitle("Mata Kuliah");
        rview = view.findViewById(R.id.rv_makul_list);

        mContext = this;
        mApiService = UtilsApi.getAPIService();

        makulAdapter = new MakulAdapter(getActivity(), makulItems);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rview.setLayoutManager(mLayoutManager);
        rview.setItemAnimator(new DefaultItemAnimator());

//        nim = sharePrefManager.getSPEmail();
//        sem = sharePrefManager.getSpSemester();
//        tahun = sharePrefManager.getTahunAjaran();
//
//        if (tahun == 0 ){
//            Calendar calendar = Calendar.getInstance();
//            tahun = calendar.get(Calendar.YEAR);
//            int bulan = calendar.get(Calendar.MONTH);
//            if (bulan > 6 ){
//                sem = "ganjil";
//            }
//        }

        getMakulList();

        return  view;
    }

    private void getMakulList() {
        //bar.setVisibility(View.VISIBLE);
        mApiService.getMakul("16650035","2018","ganjil").enqueue(new Callback<ResponseMakul>() {
            @Override
            public void onResponse(Call<ResponseMakul> call, Response<ResponseMakul> response) {
                if (response.isSuccessful()){
                    if (response.body() == null){
                        Toast.makeText(getActivity(), "ini null", Toast.LENGTH_SHORT).show();
                    } else {
                        //bar.setVisibility(View.GONE);
                        Toast.makeText(getActivity(), "mengambil data", Toast.LENGTH_SHORT).show();
                        final List<MakulItem> makulItems = response.body().getListmakul();
                        rview.setAdapter(new MakulAdapter(getActivity(), makulItems));
                        makulAdapter.notifyDataSetChanged();
                    }

                } else {
                    //bar.setVisibility(View.GONE);
                    Toast.makeText(getActivity(), "Tidak sukses mengambil data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseMakul> call, Throwable t) {
                //bar.setVisibility(View.GONE);
                Toast.makeText(getActivity(), "Koneksi bermasalah ", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext =this;
    }
}
