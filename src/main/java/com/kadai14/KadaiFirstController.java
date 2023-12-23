package com.kadai14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

    @GetMapping("/")
    public String index() {
        return "Hello SpringBoot!";
    }

    /* 指定日の曜日を表示するメソッド */
    @GetMapping("/dayofweek/{val1}")
    public String dispDayOfWeek(@PathVariable String val1) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        try {
            Date date = sdf.parse(val1);
            // Calendarインスタンスを取得
            Calendar calendar = Calendar.getInstance();
            // DateをCalendarにセット
            calendar.setTime(date);

            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

            // 対応する曜日の文字列を結果として返す
            switch (dayOfWeek) {
                case Calendar.SUNDAY:    return "Sunday";
                case Calendar.MONDAY:    return "Monday";
                case Calendar.TUESDAY:   return "Tueday";
                case Calendar.WEDNESDAY: return "Wednesday";
                case Calendar.THURSDAY:  return "Thursday";
                case Calendar.FRIDAY:    return "Friday";
                case Calendar.SATURDAY:  return "Saturday";
            }
        } catch(ParseException e) {
            e.printStackTrace();
        }

        return "";
    }

    // 四則演算結果の表示文字列を返す
    static String DispResult(int res) {
        return "実行結果:" + res;
    }

    /* 四則演算メソッド（int型を超える入力は考慮しない） */
    // 足し算
    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 + val2;

        return DispResult(res);
    }

    // 引き算
    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 - val2;

        return DispResult(res);
    }

    // 掛け算
    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 * val2;

        return DispResult(res);
    }

    // 割り算
    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 / val2;

        return DispResult(res);
    }

}
