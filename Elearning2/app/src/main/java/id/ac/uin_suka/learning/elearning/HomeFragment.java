package id.ac.uin_suka.learning.elearning;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ipaulpro.afilechooser.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

import id.ac.uin_suka.learning.elearning.adapter.StatusAdapter;
import id.ac.uin_suka.learning.elearning.apihelper.BaseApiService;
import id.ac.uin_suka.learning.elearning.apihelper.UtilsApi;
import id.ac.uin_suka.learning.elearning.model.ResponseStatus;
import id.ac.uin_suka.learning.elearning.model.StatusItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;

public class HomeFragment extends Fragment {
    RecyclerView recyclerView;

    ProgressDialog loading;
    HomeFragment mContext;
    List<StatusItem> statusItems = new ArrayList<>();
    StatusAdapter statusAdapter;
    BaseApiService mApiService;

    TextView tvFile;
    Button btnAttc;
    private final int REQUEST_CHOOSER = 1234;

//    public static Fragment newInstance() {
//        HomeFragment fragment = new HomeFragment();
//        return  fragment;
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        getActivity().setTitle("Home");
        recyclerView = view.findViewById(R.id.rv_status);

        mContext =this;
        mApiService = UtilsApi.getAPIService();

        statusAdapter = new StatusAdapter(getActivity(), statusItems);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        tvFile = view.findViewById(R.id.tv_file_status);
        btnAttc = view.findViewById(R.id.status_att_file);
        btnAttc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getContent = FileUtils.createGetContentIntent();
                Intent intent = Intent.createChooser(getContent, "Pilih file");
                startActivityForResult(intent, REQUEST_CHOOSER);
            }
        });

        getStatusList();


        return view;
    }

    private void getStatusList() {
        //loading = ProgressDialog.show(getActivity(), null, "Mengambil data...", true, false);

        String nim = SharePrefManager.SP_EMAIL;
        mApiService.getStatus("16650035").enqueue(new Callback<ResponseStatus>() {
            @Override
            public void onResponse(Call<ResponseStatus> call, Response<ResponseStatus> response) {
                if (response.isSuccessful()){
                    //loading.dismiss();
                    final List<StatusItem> statusItems = response.body().getStatus();
                    recyclerView.setAdapter(new StatusAdapter(getActivity(), statusItems));
                    statusAdapter.notifyDataSetChanged();
                } else  {
                    //loading.dismiss();
                    Toast.makeText(getActivity(), "Gagal mengambil data ", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseStatus> call, Throwable t) {
                //loading.dismiss();
                Toast.makeText(getActivity(), "Koneksi bermasalah ", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case REQUEST_CHOOSER:
                if (resultCode == RESULT_OK){
                    final Uri uri = data.getData();
                    final String path =FileUtils.getPath(getActivity(), uri);
                    tvFile.setText(path);
                } else {
                    tvFile.setText("Gagal mengambil file");
                }
        }
    }
}