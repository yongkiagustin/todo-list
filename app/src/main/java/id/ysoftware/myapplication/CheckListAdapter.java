package id.ysoftware.myapplication;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import id.ysoftware.myapplication.databinding.ItemChecklistBinding;

public class CheckListAdapter extends RecyclerView.Adapter<CheckListAdapter.VH> {
    ArrayList<DataChecklistModel> datalist = new ArrayList<>();
    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(
                ItemChecklistBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        DataChecklistModel checklistModel = datalist.get(position);
        holder.binding.name.setText(checklistModel.name);
    }



    @Override
    public int getItemCount() {
        return datalist.size();
    }
    static class VH extends RecyclerView.ViewHolder{
        ItemChecklistBinding binding;

        public VH(@NonNull ItemChecklistBinding itemChecklistBinding){
            super(itemChecklistBinding.getRoot());
            binding = itemChecklistBinding;
        }
    }

}
