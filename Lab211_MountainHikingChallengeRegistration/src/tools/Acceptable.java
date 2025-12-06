/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

/**
 *
 * @author khoac
 */
public interface Acceptable {

    public final String STU_ID_VALID = "^[SsDdQqHhCc][Ee]\\d{6}$";
    public final String NAME_VALID = "^.{2,20}$";
    public final String PHONE_VALID = "^(0[1-9]\\d{8})$";
    public final String VIETTEL_VALID = "^(032|033|034|035|036|037|038|039|098|097|096|086)\\d{7}$";
    public final String VNPT_VALID = "^(081|082|083|084|085|088|091|094)\\d{7}$";
    public final String EMAIL_VALID = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    public final String INTEGER_VALID = "\\d+";

    public static boolean isValid(String data, String pattern) {
        return data.matches(pattern);
    }
}
