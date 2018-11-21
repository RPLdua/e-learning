package id.ac.uin_suka.learning.elearning;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static android.content.Context.MODE_PRIVATE;

public class AkunFragment extends Fragment {

    Button btnLogout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_akun, container, false);
        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        SharePrefManager sharePrefManager = new SharePrefManager(getContext());
        btnLogout = (Button)view.findViewById(R.id.btn_logout);

        btnLogout.setOnClickListener((v)->{
            sharePrefManager.saveSPBoolean(SharePrefManager.SP_SUDAH_LOGIN, false);
            startActivity(new Intent(getActivity(), LoginActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            getActivity().finish();
        });

    }
}