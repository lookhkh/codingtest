class Solution {
      public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int answerIdx = 0;
        for (String target : targets) {
            boolean result = true;
            int total = 0;
            String[] split = target.split("");
            for (String ch : split) {
                
                int min = Integer.MAX_VALUE;
                for (String key : keymap) {
                    int idx = key.indexOf(ch)+1;
                    if (idx != 0) min = Integer.min(min, idx);
                }
                if (min != Integer.MAX_VALUE) total += min;
                if(min == Integer.MAX_VALUE) {
                    result = false;
                }
            }
                
            answer[answerIdx++] = result ? total: -1;
        }
        return answer;
    }
}