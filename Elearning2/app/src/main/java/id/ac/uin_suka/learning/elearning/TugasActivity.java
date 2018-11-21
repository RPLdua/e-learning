package id.ac.uin_suka.learning.elearning;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class TugasActivity extends Fragment {
    private RecyclerView rvCategory;
    private ArrayList<Tugas> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tugas, container, false);
        rvCategory = (RecyclerView) view.findViewById(R.id.rv_category);
        ListTugasAdapter listTugasAdapter = new ListTugasAdapter(getContext());
        listTugasAdapter.setListTugas(list);
        rvCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvCategory.setAdapter(listTugasAdapter);

        return view;

    }

    @Override
    public void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
