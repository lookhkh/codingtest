class Solution {
    public String solution(String phone_number) {
        String answer = "";
        
        int length = phone_number.length();
        String lastFourStr = phone_number.substring(length-4);
        
        return "*".repeat(length-4)+lastFourStr;
    }
}