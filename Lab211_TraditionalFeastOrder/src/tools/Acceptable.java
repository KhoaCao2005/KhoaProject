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

    public final String CODE_VALID = "^[CGK]\\d{4}$";
    public final String NAME_VALID = "^.{2,25}$";
    public final String PHONE_VALID = "^(0[1-9]\\d{8})$";
    public final String EMAIL_VALID = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

    public static boolean isValid(String data, String pattern) {
        return data.matches(pattern);
    }
}
