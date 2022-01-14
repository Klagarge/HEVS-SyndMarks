package hes.wallis.mark;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Marks extends MainActivityRank {

    String key;
    public Average avg;
    private int maxPoints;

    public Marks(View view){
        MarkLine foo = (MarkLine) view;
        key = foo.createTag(view);
    }
    public Marks(View view, int pts){
        PointLine foo = (PointLine) view;
        key = foo.createTag(view, pts);
        maxPoints = pts;
    }

    public Marks(View view, Double mark){
        avg = (Average) view;
        key = avg.WriteMark(view, mark);
    }

    public Double GetMark(){
        return getFromMemorize(key);
    }

    static public Double aroundDemi(Double x) {
        return (Double) (Math.round(x*2.0) / 2.0);
    }
    static public Double aroundDemiDixie(Double x) {
        return (Double) (Math.round(x*20.0) / 20.0);
    }
    static public Double aroundDixie(Double x) {
        return (Double) (Math.round(x*10.0) / 10.0);
    }
    static public Double around2Dixie(Double x) {
        return (Double) (Math.round(x*100.0) / 100.0);
    }

    static Double PbPressed(String key, Button check, Button discard, EditText mark){
        Double grade;
        String s = mark.getText().toString();
        if(!s.equals("")){
            check.setVisibility(View.GONE);
            mark.setEnabled(false);
            discard.setVisibility(View.VISIBLE);
            grade = Double.parseDouble(s);
            if(grade > 6.0){
                mark.setText("6");
                grade = 6.0;
            }
            writeOnMemorize(key, grade);
            return grade;
        } else {
            discard.setVisibility(View.GONE);
        }
        return null;
    }
    static Double PbPressedPoints(String key, Button check, Button discard, EditText mark){
        Double grade;
        String s = mark.getText().toString();
        if(!s.equals("")){
            check.setVisibility(View.GONE);
            mark.setEnabled(false);
            discard.setVisibility(View.VISIBLE);
            grade = Double.parseDouble(s);
            writeOnMemorize(key, grade);
            return grade;
        } else {
            discard.setVisibility(View.GONE);
        }
        return null;
    }

    public static Double getFromMemorize(String key){
        int i = (int) (MainActivityRank.marks.getFloat(key, 0)*10);
        Double d = ((double) i)/10;
        //Log.i("DebugHER", "key: " + key);
        //Log.i("DebugHER", "get: " + d.toString());
        return d;
    }

    static void writeOnMemorize(String key, Double n){
        MainActivityRank.editorMarks.putFloat(key, n.floatValue());
        MainActivityRank.editorMarks.commit();
        //Log.i("DebugHER", "key: " + key);
        //Log.i("DebugHER", "write: " + n.toString());
    }

    static String toText(String key){
        Double n = getFromMemorize(key);
        String s = n.toString();
        if (n > 0.0){
            return s;
        }
        return null;
    }
}
