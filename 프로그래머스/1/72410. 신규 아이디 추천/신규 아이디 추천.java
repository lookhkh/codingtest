class Solution {
    public String solution(String new_id) {
        String answer = "";
    
        
        //1단계 대문자 -> 소문자로
        new_id = new_id.toLowerCase();
        
        
        //2단계 -> 정규표현식을 활용한 특수문자 제거
        String id = "";
		for(int i = 0; i < new_id.length(); i++) {
			char ch = new_id.charAt(i);

			if(ch >= 'a' && ch <= 'z') {
				id += String.valueOf(ch);
			} else if(ch >= '0' && ch <= '9') {
				id += String.valueOf(ch);
			} else if(ch == '.' || ch == '-' || ch == '_') {
				id += String.valueOf(ch);
			}
		}
		
		new_id = id;
        
		
		//3단계 -> 중복된 마침표 하나로 줄이기.
		String regEx = "[\\.]+";
		new_id = new_id.replaceAll(regEx, ".");
		
		
		//4단계 -
		
		if(new_id.startsWith(".")) {
			new_id = new_id.substring(1);
		}
		
		if(new_id.endsWith(".")) {
			new_id = new_id.substring(0, new_id.length()-1);
		}
		
       
		//5단계
		
		if(new_id.length()==0) {
			new_id = "a";
		}
		
		//6단계
		
		if(new_id.length()>=16) {
			new_id = new_id.substring(0, 15);
			if(new_id.endsWith(".")) {
				new_id = new_id.substring(0,14);
			}
		}
		
		//7단계
		
		if(new_id.length()<=2) {
			while(new_id.length()!=3) {
				new_id+=new_id.charAt(new_id.length()-1);
			}
		}
		
        


        
        
        
        
        return new_id;
    
}
        
        
        
    }