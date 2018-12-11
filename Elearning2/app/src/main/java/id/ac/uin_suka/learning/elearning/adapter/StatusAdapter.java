package id.ac.uin_suka.learning.elearning.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import id.ac.uin_suka.learning.elearning.R;
import id.ac.uin_suka.learning.elearning.model.StatusItem;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.MyViewHolder> {
    private Context context;
    List<StatusItem> listStatus;

    public StatusAdapter(Context context, List<StatusItem> listStatus){
        this.context = context;
        this.listStatus = listStatus;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_status, viewGroup, false);
        MyViewHolder vHolder = new MyViewHolder(itemRow);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int pos) {
        final StatusItem statusItem = listStatus.get(pos);
        holder.tvNama.setText(statusItem.getId());
        holder.tvNim.setText(statusItem.getNim());
        holder.tvTgl.setText(statusItem.getTgl());
        holder.tvStatus.setText(statusItem.getIsiStatus());
        holder.btnLike.setText(statusItem.getLike());

    }

    @Override
    public int getItemCount() {
        return listStatus.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvNama, tvNim, tvTgl, tvStatus;
        ImageView imgMhs;
        Button btnLike, btnKomen, btnFile;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.statusNamaMhs);
            tvNim = itemView.findViewById(R.id.statusProdi);
            tvTgl = itemView.findViewById(R.id.statusTgl);
            tvStatus = itemView.findViewById(R.id.statusIsi);
            btnLike = itemView.findViewById(R.id.buttonLike);
            btnKomen = itemView.findViewById(R.id.buttonComment);
            btnFile = itemView.findViewById(R.id.buttonDL);
            imgMhs = itemView.findViewById(R.id.photoMhs);
        }
    }
}
