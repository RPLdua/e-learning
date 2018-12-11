package id.ac.uin_suka.learning.elearning;

import android.app.ProgressDialog;
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

import id.ac.uin_suka.learning.elearning.apihelper.BaseApiService;
import id.ac.uin_suka.learning.elearning.apihelper.UtilsApi;
import id.ac.uin_suka.learning.elearning.model.ResponseTugas;
import id.ac.uin_suka.learning.elearning.model.SemuatugasItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TugasActivity extends Fragment {
    private RecyclerView rvCategory;
    private ArrayList<Tugas> list;

    ProgressDialog loading;
    TugasActivity mContext;
    List<SemuatugasItem> semuatugasItemList = new ArrayList<>();
    ListTugasAdapter tugasAdapter;
    BaseApiService mApiService;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tugas, container, false);
        getActivity().setTitle("Tugas");
        rvCategory = (RecyclerView) view.findViewById(R.id.rv_category);

        mContext =this;
        mApiService = UtilsApi.getAPIService();

        tugasAdapter = new ListTugasAdapter(getActivity(), semuatugasItemList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvCategory.setLayoutManager(mLayoutManager);
        rvCategory.setItemAnimator(new DefaultItemAnimator());

//        if(tugasAdapter.getItemCount() == tugasAdapter.getLocalCount()){
//            Toast.makeText(getActivity(), "Sama", Toast.LENGTH_SHORT).show();
//        } else {
//            tugasAdapter.setListTugas(List<SemuatugasItem> semuatugasItemList);
//        }

        getResultListTugas();

//        rvCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
//        rvCategory.setAdapter(listTugasAdapter);

        return view;

    }

    private void getResultListTugas() {
        loading = ProgressDialog.show(getActivity(), null, "Harap tunggu...", true, false);
        mApiService.getSemuaTugas().enqueue(new Callback<ResponseTugas>() {
            @Override
            public void onResponse(Call<ResponseTugas> call, Response<ResponseTugas> response) {
                if (response.isSuccessful()){
                    loading.dismiss();

                    final List<SemuatugasItem> semuatugasItems = response.body().getSemuatugas();
                    rvCategory.setAdapter(new ListTugasAdapter(getActivity(), semuatugasItems));
                    tugasAdapter.notifyDataSetChanged();
                } else {
                    loading.dismiss();
                    Toast.makeText(getActivity(), "Gagal mengambil data tugas", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseTugas> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(getActivity(), "Koneksi bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext =this;

        list = new ArrayList<>();
        list.addAll(TugasData.getListData());
    }

//    private void showRecyclerList(){
//        rvCategory.setLayoutManager(new LinearLayoutManager(this));
//        ListTugasAdapter listTugasAdapter = new ListTugasAdapter(this);
//        listTugasAdapter.setListTugas(list);
//        rvCategory.setAdapter(listTugasAdapter);
//    }
}
