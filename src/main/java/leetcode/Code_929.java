package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: nj
 * @date: 2020-05-03 14:43
 * @version: 0.0.1
 */
public class Code_929 {


    /**
     *
     * Every email consists of a local name and a domain name, separated by the @ sign.
     *
     * For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
     *
     * Besides lowercase letters, these emails may contain '.'s or '+'s.
     *
     * If you add periods ('.') between some characters in the local name part of an email address, mail sent
     * there will be forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com"
     * and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)
     *
     * If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain
     * emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does
     * not apply for domain names.)
     *
     * It is possible to use both of these rules at the same time.
     *
     * Given a list of emails, we send one email to each address in the list.  How many different addresses actually
     * receive mails?
     *
     *
     *
     * Example 1:
     *
     * Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
     * Output: 2
     * Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
     *
     *
     * Note:
     *
     * 1 <= emails[i].length <= 100
     * 1 <= emails.length <= 100
     * Each emails[i] contains exactly one '@' character.
     * All local and domain names are non-empty.
     * Local names do not start with a '+' character.
     *
     *
     *
     */


    public static int numUniqueEmails(String[] emails) {


        Set<String> email = new HashSet<>();
        for(String str : emails){
            String[] arr = str.split("@");
            email.add(arr[0].split("\\+")[0].replaceAll("\\.", "")+"@" + arr[1]);
        }
//        System.out.println(email.toString());
        return email.size();



    }

    /**
     *
     * 没有直接拆分为数组，一般情况下，尽量获取下标index然后进行subStr操作
     *
     */
    public int numUniqueEmails1(String[] emails) {
        Set<String> seen = new HashSet();
        for (String email : emails) {
            int i = email.indexOf('@');
            String local = email.substring(0, i);
            String rest = email.substring(i);
            if (local.contains("+")) {
                local = local.substring(0, local.indexOf('+'));
            }
            // Note: one should escape the specific character '.',
            // since it is treated as a regex expression.
            local = local.replaceAll("\\.", "");
            seen.add(local + rest);
        }

        return seen.size();
    }


    public static void main(String[] args) {

        String[] str = {"test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(str));
    }




}