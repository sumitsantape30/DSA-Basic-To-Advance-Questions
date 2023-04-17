Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

The algorithm for myAtoi(string s) is as follows:

Read in and ignore any leading whitespace.
Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
Return the integer as the final result.
			
The range of integers that can be represented using a 32-bit signed integer in computing is from -2,147,483,648 (-2^31) to 2,147,483,647 (2^31 - 1).
This range is because a signed 32-bit integer uses 31 bits for the actual number and 1 bit for the sign (positive or negative).
											     
Note:
										

Only the space character ' ' is considered a whitespace character.
Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 
Example 1:

Input: s = "42"
Output: 42
Explanation: The underlined characters are what is read in, the caret is the current reader position.
Step 1: "42" (no characters read because there is no leading whitespace)
         ^
Step 2: "42" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "42" ("42" is read in)
           ^
The parsed integer is 42.
Since 42 is in the range [-231, 231 - 1], the final result is 42.
Example 2:

Input: s = "   -42"
Output: -42
Explanation:
Step 1: "   -42" (leading whitespace is read and ignored)
            ^
Step 2: "   -42" ('-' is read, so the result should be negative)
             ^
Step 3: "   -42" ("42" is read in)
               ^
The parsed integer is -42.
Since -42 is in the range [-231, 231 - 1], the final result is -42.
Example 3:

Input: s = "4193 with words"
Output: 4193
Explanation:
Step 1: "4193 with words" (no characters read because there is no leading whitespace)
         ^
Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
             ^
The parsed integer is 4193.
Since 4193 is in the range [-231, 231 - 1], the final result is 4193.
 
Code:
      
 class Solution {
    public int myAtoi(String s) {
        int sign = 1;//input string mai sign konsa hai dekhenge fir end mai answer ko uss sign se multiple krdenge
		int n = s.length();
		int result = 0;
		
		//pehle starting mai jo space honge unko ignore krenge
		int i=0;
		while( i < n && s.charAt(i) == ' ')i++;
		
		//starting spaces ke bad ayega sign it can be - or +
		if(i < n && s.charAt(i) == '+') {
			sign = 1;
			i++;
		}else if( i < n && s.charAt(i) == '-') {
			sign = -1;
			i++;
		}
		
		//ab i jis index pe hoga wahase actual number start hoga to dekhenge kya woh range mai hai
		while(i < n && (0 <= s.charAt(i) - '0') && (s.charAt(i) - '0' <= 9)) {
			int digit = s.charAt(i)- '0';
			//ab overflow check karenge
			if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE % 10)) {
				// 
				//yeh conditions true hui means overflow
				return (sign == 1)? Integer.MAX_VALUE: Integer.MIN_VALUE; //agar positive number hai to max number return karo. negative number hai to min value return krdo
				//yaha aaye means overflow hua hai ab dekhenge positive side overflow hua yafir negative. sign=1 hai means negative side overflow hua to return Integer.MIN_VALUE
			}
			
			//aur agar yeh overflow nhi hota hai to digit ko result mai daldo
			result = result*10 + digit;
			i++;
		}
		
		return result*sign;
    }
}                                                                                            

When we divide Integer.MAX_VALUE by 10, we get the maximum value that result can have without overflowing when we add the next digit. 
This is because the maximum value of a digit is 9, so if result is less than Integer.MAX_VALUE / 10, then we know that adding any digit to result will not cause an overflow.

For example, if result is 214748364, which is less than Integer.MAX_VALUE / 10 (i.e., 214748364.7), then we can safely add any digit from 0 to 9 to result 
without causing an overflow. If we add a digit less than or equal to 7, then the result will be less than Integer.MAX_VALUE, and if we add a digit greater 
than 7, then the result will overflow to a value greater than Integer.MAX_VALUE.

On the other hand, if result is equal to Integer.MAX_VALUE / 10, then we need to check the next digit to determine if adding it would cause an overflow. 
This is because the maximum value of the last digit that can be added to result without causing an overflow is 7. If the next digit is less than or equal to 7, 
 then adding it will not cause an overflow, but if it is greater than 7, then adding it will result in an overflow.

Therefore, by checking if result is less than Integer.MAX_VALUE / 10, and also checking the next digit if result is equal to Integer.MAX_VALUE / 10, 
we can determine if adding the next digit will result in an overflow or not, without actually adding the next digit.											     
