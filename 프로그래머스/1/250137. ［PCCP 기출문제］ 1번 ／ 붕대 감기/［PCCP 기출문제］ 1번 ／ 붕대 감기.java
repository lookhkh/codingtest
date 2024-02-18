class Solution {
  public int solution(int[] bandage, int health, int[][] attacks) {
         int needTime = bandage[0];
        int heal = bandage[1];
        int plusHeal = bandage[2];

        int curHealth = health;
        int successCnt = 1;

        int attackIdx = 0;

        for(int second = 1; second <= 1000 && attackIdx < attacks.length; second++){
            int[] attack = attacks[attackIdx];
            if(attack[0] == second){
                attackIdx++;
                curHealth-= attack[1];
                successCnt = 0;
                if(curHealth <= 0 ) return -1;
            }else{
                successCnt++;
                curHealth+=heal;
                if(successCnt == needTime){
                    curHealth+=plusHeal;
                    successCnt = 0;
                }
                if(curHealth > health) curHealth = health;

            }
        }


        return curHealth;
    }
}