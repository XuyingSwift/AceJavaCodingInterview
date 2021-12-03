package main.Leetcode.Strings;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses929 {
    public static void main(String[] args) {
        /*
        * 1: For each email present in emails array:
        *   iterate overt the characters in the mail and append each character to the local name if it not '.';
        *   if the character is '+', do not append the character and break out the loop
        *
        * 2: find the domain name using reverse traversal in the given email and append it to the string formed till now
        *       after clean the email insert it into to hashset
        * 3: return the size of hashset
        *
        * */
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        int result = numUniqueEmails(emails);
        System.out.println(result);

        /*
        * 1. for each email present in emails array:
        *   split the string into two parts. by @
        *   split the local email by "+", since we do not need the part after + let the first part the be local name
        *   remove all .
        *   insert it to hash set
        *
        * */

        System.out.println(getNums(emails));

    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            StringBuilder cleanMail = new StringBuilder();

            for (int i = 0; i<email.length(); i++) {
                char currentChar = email.charAt(i);

                if (currentChar == '+' || currentChar == '@') {
                    break;
                }

                if (currentChar != '.') {
                    cleanMail.append(currentChar);
                }
            }

            StringBuilder domainName = new StringBuilder();
            for (int i = email.length()-1; i>=0; i--) {
                char currentChar = email.charAt(i);
                domainName.append(currentChar);
                if (currentChar == '@') {
                    break;
                }
            }

            domainName = domainName.reverse();
            cleanMail.append(domainName);
            uniqueEmails.add(cleanMail.toString());

        }
        return  uniqueEmails.size();
    }

    public static int getNums(String[] emails) {
        HashSet<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            String[] parts = email.split("@");
            String[] local = parts[0].split("\\+");
            uniqueEmails.add(local[0].replace(".", "") + "@" + parts[1]);
        }

        return uniqueEmails.size();
    }
}
