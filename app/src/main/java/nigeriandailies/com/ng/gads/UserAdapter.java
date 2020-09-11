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

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserAdapterVH> {
    private List<UserResponse> userResponslist ;
    private Context context;


    public UserAdapter() {
    }

    public void setData(List<UserResponse> userResponslist) {
        this.userResponslist = userResponslist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new UserAdapter.UserAdapterVH(LayoutInflater.from(context).inflate(R.layout.learning_leader_display, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapterVH holder, int position) {
        UserResponse userResponse = userResponslist.get(position);
        String name = userResponse.getName();
        int hourse = userResponse.getHours();
        String country = userResponse.getCountry();

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
