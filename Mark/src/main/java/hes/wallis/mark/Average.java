package hes.wallis.mark;

import static hes.wallis.mark.R.id;
import static hes.wallis.mark.R.layout;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Average extends ConstraintLayout {

    TextView averageName;
    public EditText outputMark;
    //public Double mark;
    private String key;

    public Average(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        layoutInflater.inflate(layout.average, this);

        averageName = findViewById(id.AverageName);
        outputMark = findViewById(id.AverageMark);
        outputMark.setHint("average");
        outputMark.setEnabled(false);
    }


    public String WriteMark(View view, Double mark){
        String line = getTag(view);
        String parent = getTag(averageName.getRootView());
        key = parent + line;
        String setName = "";
        for (int i = 0; i <line.length(); i++) {
            if (line.charAt(i) == '_'){
                setName += ' ';
            } else {
                setName += line.charAt(i);
            }
        }
        averageName.setText(setName);
        outputMark.setText(Marks.toText(key));
        outputMark.setText(mark.toString());
        return key;
    }

    static String getTag(View view) {
        String s = view.getResources().getResourceName(view.getId());
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '/'){
                return s.substring(i+1);
            }
        }
        return null;
    }
}
