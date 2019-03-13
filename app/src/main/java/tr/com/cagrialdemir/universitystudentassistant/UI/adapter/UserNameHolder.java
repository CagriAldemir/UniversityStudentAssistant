package tr.com.cagrialdemir.universitystudentassistant.UI.adapter;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import tr.com.cagrialdemir.universitystudentassistant.BaseMVP.BaseHolder;
import tr.com.cagrialdemir.universitystudentassistant.R;


public class UserNameHolder extends BaseHolder<String> {
    private TextView name;

    public UserNameHolder(View itemView) {
        super(itemView);

        //name = itemView.findViewById(R.id.name);
    }


    @Override
    public void bind(String model) {
        name.setText(model);

        if (getAdapterPosition() % 2 != 0) {
            name.setTextColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark));
        } else {
            name.setTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        }
    }
}
