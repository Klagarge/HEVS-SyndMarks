package hes.wallis.mark;

import static hes.wallis.mark.R.id;
import static hes.wallis.mark.R.layout;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class PointLine extends ConstraintLayout {

    TextView name;
    EditText inputMark;
    public Button pbCheck;
    Button pbDiscard;
    Double mark;
    private String key;
    private int points;

    public PointLine(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        layoutInflater.inflate(layout.markline, this);


        name = findViewById(id.name);
        inputMark = findViewById(id.mark);
        pbCheck = findViewById(id.check);
        pbDiscard = findViewById(id.discard);
        inputMark.setHint("points");
        //pbDiscard.setVisibility(INVISIBLE);

        //inputMark.setFilters(new InputFilter[] {new TestIfMark()});

        pbCheck.setOnClickListener(v -> {
            mark = Marks.PbPressedPoints(key, pbCheck, pbDiscard, inputMark);
            refresh(v);
        });

        pbDiscard.setOnClickListener(v -> {
            inputMark.setEnabled(true);
            inputMark.setText("");
            Marks.writeOnMemorize(key, 0.0);
            pbDiscard.setVisibility(GONE);
            pbCheck.setVisibility(VISIBLE);
            refresh(v);
        });
    }

    private void refresh(View v){
        SubjectFragment myFragment = androidx.fragment.app.FragmentManager.findFragment(v);
        myFragment.refresh();
    }

    String createTag(View view){
        String line = getTag(view);
        String parent = getTag(name.getRootView());
        key = parent + line;
        String setName = "";
        for (int i = 0; i <line.length(); i++) {
            if (line.charAt(i) == '_'){
                setName += ' ';
            } else {
                setName += line.charAt(i);
            }
        }
        name.setText(setName);
        inputMark.setText(Marks.toText(key));
        if(!inputMark.getText().toString().equals("point")){
            mark = Marks.PbPressedPoints(key, pbCheck, pbDiscard, inputMark);
            //Log.i("DebugHER", "mark");
        }
        if(!inputMark.getText().toString().equals("")) {
            pbDiscard.setVisibility(VISIBLE);
            //Log.i("DebugHER", "empty");
        }
        return key;
    }
    String createTag(View view, int pts){
        createTag(view);
        points = pts;
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
