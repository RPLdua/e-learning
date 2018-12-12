package id.ac.uin_suka.learning.elearning.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import id.ac.uin_suka.learning.elearning.R;
import id.ac.uin_suka.learning.elearning.model.MakulItem;

public class MakulAdapter extends RecyclerView.Adapter<MakulAdapter.MViewHolder> {
    private Context context;
    List<MakulItem> makulItems;

    public MakulAdapter(Context context, List<MakulItem> makulItems){
        this.context = context;
        this.makulItems = makulItems;
    }

    @NonNull
    @Override
    public MViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_makul, viewGroup, false);
        MViewHolder viewHolder = new MViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MViewHolder mViewHolder, int pos) {
        final MakulItem makulItem = makulItems.get(pos);
        mViewHolder.tvDosen.setText(makulItem.getNim());
        mViewHolder.tvMakul.setText(makulItem.getMakul());
        mViewHolder.tvMhs.setText(makulItem.getId());

        mViewHolder.btnDtl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Maaf! Belum tersedia.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return makulItems.size();
    }


    public static class MViewHolder extends RecyclerView.ViewHolder{
        TextView tvDosen, tvMakul, tvMhs;
        Button btnDtl;

        public MViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDosen = itemView.findViewById(R.id.tv_makul_dosenX);
            tvMakul = itemView.findViewById(R.id.tv_makul_makul);
            tvMhs = itemView.findViewById(R.id.tv_makul_mhsX);
            btnDtl = itemView.findViewById(R.id.ButtonDtlMakul);
        }
    }
}
