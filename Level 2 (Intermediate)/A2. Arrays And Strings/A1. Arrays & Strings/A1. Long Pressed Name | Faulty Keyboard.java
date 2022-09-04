Range Addition

Link: https://leetcode.com/problems/long-pressed-name/

Code:
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        
        if( name.length() > typed.length())return false;
        
        int i=0;
        int j=0;
        
        while( i < name.length() && j < typed.length()){
            //jab i and j same rahenge to aage badhenge
            
            if( name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
               
                //aur agar equal nhi hai to ekbar name mai jakar pichla character bhi check krlo types ke current character se
            }else if( i> 0 && name.charAt(i-1) == typed.charAt(j)){ 
                //i-1 access krne se pehle make sure ki i valid haii nhito indexoutofbound exception ayega
                j++; //agar yeh equal hai to sirf j++ hoga coz usne jyada type krliya faulty keyboard ki wajah se
                
            }else{
                // agar dono false hai to matlab wrong typing ki hai so return false
                return false;
            
            }
            
        }
        
        //enge case 2
        while( j < typed.length()){ //jabtak j valid hai tabtak chalte rahiye aur i-1 ko dekhte rahiye, agar equal hai to aage badhte rho nhito return false
            
            if( name.charAt(i-1) != typed.charAt(j))return false; //agar equal nhi hai to return krdo false otherwise sirf j ko karo j++
            j++;
        }
               
        //edge case 3, return krte waqt dhyan rakhe i mera khatam nhi hua hai abhi to return false
        return i < name.length() ? false: true;
        
    }
}
