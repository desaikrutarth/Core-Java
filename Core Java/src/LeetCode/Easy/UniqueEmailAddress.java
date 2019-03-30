package LeetCode.Easy;

import java.util.HashSet;
/*
Every email consists of a local name and a domain name, separated by the @ sign.
For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
Besides lowercase letters, these emails may contain '.'s or '+'s.
If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.
	For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)
If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered,
 	for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)
It is possible to use both of these rules at the same time.
Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails? 

Example 1:

Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
Output: 2
Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
 */
public class UniqueEmailAddress
{
	public static int numUniqueEmails(String[] emails)
	{
		HashSet<String> seen = new HashSet<>();
        for (String email: emails)
        {
            int i = email.indexOf('@');
            String local = email.substring(0, i);
            String rest = email.substring(i);
            if (local.contains("+"))
                local = local.substring(0, local.indexOf('+'));
            local = local.replaceAll("\\.", "");
            seen.add(local + rest);
        }
        return seen.size();
    }
	
	/*public static int numUniqueEmails(String[] emails)
	{
		HashSet<String> set = new HashSet<>();
        for(String email : emails)
        {
        	StringBuilder sb = new StringBuilder();
        	for(int i=0; i<email.length(); i++)
        	{
        		char ch = email.charAt(i);
        		if(ch == '@')
        		{
        			String substring = email.substring(i, email.length());
        			sb.append(substring);
        			break;
        		}
        		else if(ch == '+')
        		{
        			int pos = email.indexOf('@', i);
        			i=pos-1;
        		}
        		else if(ch == '.')
        			continue;
        		else
        			sb.append(ch);
        	}
        	set.add(sb.toString());
        }
        return set.size();
    }*/

	public static void main(String[] args)
	{
		String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		System.out.println(numUniqueEmails(emails));
	}
}
