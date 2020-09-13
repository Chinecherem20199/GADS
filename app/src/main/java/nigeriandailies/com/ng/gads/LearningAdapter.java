package nigeriandailies.com.ng.gads;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LearningAdapter extends  RecyclerView.Adapter<LearningAdapter.LearningAdapterVH> {


    private List<Skill_IQ_Response> learningResponslist ;
    private Context context;

    public LearningAdapter() {
    }

    public void setData(List<Skill_IQ_Response> learningResponslist) {
        this.learningResponslist = learningResponslist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LearningAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();
        return new LearningAdapter.LearningAdapterVH(LayoutInflater.from(context).inflate(R.layout.learning_leader_display, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull LearningAdapterVH holder, int position) {
        Skill_IQ_Response learningResponse  = learningResponslist.get(position);
        String name = learningResponse.getName();
        String hourse = learningResponse.getScore();
        String country = learningResponse.getCountry();

        holder.name.setText(name);
        holder.hours.setText(hourse);
        holder.country.setText(country);

    }


    @Override
    public int getItemCount() {
        return learningResponslist.size();
    }

    public class LearningAdapterVH extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name;
        TextView hours;
        TextView country;


        public LearningAdapterVH(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.top_skill);
            name = itemView.findViewById(R.id.name2);
            hours = itemView.findViewById(R.id.score);
            country = itemView.findViewById(R.id.country2);


        }
    }
}
