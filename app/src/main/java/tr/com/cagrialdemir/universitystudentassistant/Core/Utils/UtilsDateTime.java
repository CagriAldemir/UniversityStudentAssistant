package tr.com.cagrialdemir.universitystudentassistant.Core.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class UtilsDateTime {

    public static String dateToString(Date mDate) {
        return dateToString(mDate, "yyyy-mm-dd hh:mm:ss");
    }

    public static String dateToString(Date mDate, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.getDefault());
        return sdf.format(mDate);
    }

    public static Date stringToDate(String mStringDate) {
        return stringToDate(mStringDate, "yyyy-mm-dd hh:mm:ss");
    }

    public static Date stringToDate(String mStringDate, String pattern) {
        try {
            Date mDate = new SimpleDateFormat(pattern, Locale.getDefault()).parse(mStringDate);
            return mDate;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
