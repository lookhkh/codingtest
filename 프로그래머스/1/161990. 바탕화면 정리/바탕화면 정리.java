class Solution {
   public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        String[][] arr = new String[wallpaper.length][wallpaper[0].length()];
        for (int i = 0; i < wallpaper.length; i++) {
            String next = wallpaper[i];
            String[] split = next.split("");
            for (int i1 = 0; i1 < split.length; i1++) {
                arr[i][i1] = split[i1];
            }
        }

        int mostLeft = Integer.MAX_VALUE;
        int mostTop = Integer.MAX_VALUE;
        int mostBottom = Integer.MIN_VALUE;
        int mostRight = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                String val = arr[i][j];
                if(val.equals("#")){
                    mostTop = Integer.min(mostTop, i);
                    mostLeft = Integer.min(mostLeft, j);
                    mostBottom = Integer.max(mostBottom, i);
                    mostRight = Integer.max(mostRight, j);
                }
            }
        }

        answer[0] = mostTop;
        answer[1] = mostLeft;
        answer[2] = mostBottom+1;
        answer[3] = mostRight+1;

        return answer;
    }
}