package hes.wallis.mark;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CorrectMark {

    static public Double PbPressed(Button Pb, EditText mark){
        Double grade;
        String s = mark.getText().toString();
        if(!s.equals("")){
            Pb.setVisibility(View.GONE);
            mark.setEnabled(false);
            grade = Double.parseDouble(s);
            if(grade>6){
                mark.setText("6");
                grade = 6.0;
            }
            Marks.writeOnMemorize(String.valueOf(Pb.getId()), grade);
            return grade;
        }
        return null;
    }

}
