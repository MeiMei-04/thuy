/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uliti;

/**
 *
 * @author Hieu
 */
public class validate {

    public static boolean Validate(String[] str, int n) {
        int isnull = 0;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                if (str[i].equals("") || str[i] == null) {
                    isnull++;
                }
            }
        }
        if (isnull > 0) {
            Dialog.messnotnull("Còn Trống " + isnull + " ô chưa nhập");
            return false;
        }
        return true;
    }
}
