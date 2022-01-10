package hes.wallis.mark;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Marks extends MainActivityRank {

    String key;
    public Average avg;

    public Marks(View view){
        MarkLine foo = (MarkLine) view;
        key = foo.createTag(view);
    }

    public Marks(View view, Double mark){
        avg = (Average) view;
        key = avg.WriteMark(view, mark);
    }

    public Double GetMark(){
        return getFromMemorize(key);
    }

    static public double aroundDemi(double x) {
        return (double) (Math.round(x*2.0) / 2.0);
    }
    static public double aroundDixie(double x) {
        return (double) (Math.round(x*10.0) / 10.0);
    }
    static public double around2Dixie(double x) {
        return (double) (Math.round(x*20.0) / 20.0);
    }

    static Double PbPressed(String key, Button check, Button discard, EditText mark){
        Double grade;
        String s = mark.getText().toString();
        if(!s.equals("")){
            check.setVisibility(View.GONE);
            mark.setEnabled(false);
            discard.setVisibility(View.VISIBLE);
            grade = Double.parseDouble(s);
            if(grade>6){
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

    public static Double PbPressed(Button Pb, EditText mark){
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
            writeOnMemorize(MarkLine.getTag(Pb), grade);
            return grade;
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
        Log.i("DebugHER", "key: " + key);
        Log.i("DebugHER", "write: " + n.toString());
    }

    public static String toHing(Button button, String def){
        Double n = getFromMemorize(MarkLine.getTag(button));
        String s = n.toString();
        if (n > 0.0){
            return s;
        }
        return def;
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
