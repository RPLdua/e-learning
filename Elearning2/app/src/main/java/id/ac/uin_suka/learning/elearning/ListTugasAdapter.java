package id.ac.uin_suka.learning.elearning;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListTugasAdapter extends RecyclerView.Adapter<ListTugasAdapter.CategoryViewHolder>{
    private Context context;
    private ArrayList<Tugas> listTugas;

    public ArrayList<Tugas> getListTugas() { return listTugas; }
    public void setListTugas(ArrayList<Tugas> listTugas) {
        this.listTugas = listTugas;
    }

    public ListTugasAdapter(Context context) {
        this.context = context;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tugas, parent, false);
        CategoryViewHolder vHolder = new CategoryViewHolder(itemRow);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {

        holder.tvName.setText(getListTugas().get(position).getName());
        holder.tvRemarks.setText(getListTugas().get(position).getRemarks());

        Glide.with(context)
                .load(getListTugas().get(position).getPhoto())
                .override(55, 55)
                .crossFade()
                .into(holder.imgPhoto);
        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tugasIntent = new Intent(context, DetailTugasActivity.class);
                tugasIntent.putExtra(DetailTugasActivity.EXTRA_ID, "1");
                context.startActivities(new Intent[]{tugasIntent});
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListTugas().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;
        private Button btnDetail;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            btnDetail = (Button)itemView.findViewById(R.id.btn_detail_tugas);
            tvName = (TextView)itemView.findViewById(R.id.tv_nama_dosen);
            tvRemarks = (TextView)itemView.findViewById(R.id.tv_mata_kuliah);
            imgPhoto = (ImageView)itemView.findViewById(R.id.img_item_photo);
        }
    }
}
