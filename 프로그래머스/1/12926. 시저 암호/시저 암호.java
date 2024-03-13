class Solution {
    public String solution(String s, int n) {
        String answer = "";

        char[] s_ = s.toCharArray();
        int result = 0;
        
        for(int i=0; i<s_.length; i++) {
        	char temp = s_[i];

        	if(temp>=65&&temp<=90) {
        		System.out.println("대문자 : "+temp);
        		result = temp+n;
        		
        		if(result>90) {
        			result-=26;
        		}
        		System.out.println("대문자 : "+(char)result);

        	}
        	
        	if(temp>=97&&temp<=122) {
        		System.out.println("소문자 : "+temp);
        		result = temp+n;
        		
        		if(result>122) {
        			result-=26;
        		}
        	}
        	
        	else if(temp == 32){
        		System.out.println("공백 : "+temp);
        		result = 32;
        	}
        	
        	answer += (char)result;

        	
        }

        return answer;
    }
}