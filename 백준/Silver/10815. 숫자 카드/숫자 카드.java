import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static long N;
    static long M;
    static long[] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cardNum = Integer.parseInt(br.readLine());

        int[] cards = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        br.readLine();


        int[] targetNumberList = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] result = Arrays.stream(targetNumberList)
                .map(t -> binarySearch(cards, t) >= 0 ? 1 : 0)
                .toArray();

        StringBuilder b = new StringBuilder();
        for (int i : result) {
            b.append(i+" ");
        }

        System.out.println(b.substring(0, b.length()-1));

    }

    private static int binarySearch(int[] cards, int target) {

        int left = 0;
        int right = cards.length-1;

        while(left <= right){

            int mid = (left+right)/2;
            int cardVal = cards[mid];
            if(cardVal == target) return mid;

            if(cardVal > target) right = mid -1;
            else left = mid + 1;

        }

        return -1;

    }


}