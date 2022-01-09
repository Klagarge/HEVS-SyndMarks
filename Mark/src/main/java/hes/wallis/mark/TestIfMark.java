package hes.wallis.mark;

import android.text.InputFilter;
import android.text.Spanned;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestIfMark implements InputFilter {

    Pattern mPattern;

    public TestIfMark() {
        mPattern=Pattern.compile("[1-6](\\.[0-9]{0,1})?");
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        Matcher matcher=mPattern.matcher(dest.toString()+source);
        if(!matcher.matches())
            return "";
        return null;
    }

}
