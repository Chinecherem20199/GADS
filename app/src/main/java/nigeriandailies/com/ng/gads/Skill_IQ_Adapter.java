package nigeriandailies.com.ng.gads;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Skill_IQ_Adapter extends RecyclerView.Adapter<Skill_IQ_Adapter.UserAdapterVH> {
    private List<Skill_IQ_Response> userResponslist ;
    private Context context;


    public Skill_IQ_Adapter() {
    }

    public void setData(List<Skill_IQ_Response> userResponslist) {
        this.userResponslist = userResponslist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new Skill_IQ_Adapter.UserAdapterVH(LayoutInflater.from(context).inflate(R.layout.skill_iq_leader_display, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapterVH holder, int position) {
        Skill_IQ_Response skillIQResponse = userResponslist.get(position);
        String name = skillIQResponse.getName();
        String hourse = skillIQResponse.getScore();
        String country = skillIQResponse.getCountry();

        holder.name.setText(name);
        holder.hours.setText(hourse);
        holder.country.setText(country);


    }

    @Override
    public int getItemCount() {
        return userResponslist.size();
    }

    public class UserAdapterVH extends RecyclerView.ViewHolder {
         ImageView imageView;
        TextView name;
        TextView hours;
        TextView country;


        public UserAdapterVH(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.top_learners);
            name = itemView.findViewById(R.id.name);
            hours = itemView.findViewById(R.id.hours);
            country = itemView.findViewById(R.id.country);
        }
    }
}
