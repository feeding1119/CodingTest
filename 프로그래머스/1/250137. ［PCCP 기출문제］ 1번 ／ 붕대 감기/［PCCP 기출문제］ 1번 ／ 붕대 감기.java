class Solution {
    static int lastTime,hp,maxHp;
    static int healCurrentTime, currentTime,attackIndex  = 0;
    
    static int healCastingTime,healPlus,healPerSecond;
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        hp = health;
        maxHp = health;
        lastTime = attacks[attacks.length-1][0];
        
        healCastingTime = bandage[0];
        healPerSecond = bandage[1];
        healPlus = bandage[2];
        
        
        while(currentTime <= lastTime){
            
            if(attacks[attackIndex][0] == currentTime){
                attackedMonster(attacks);
                
                if(isDeath()) break;
            }else{
                usingBandage();
            }
            
          
            currentTime++;
        }

        return hp;
    }
    
    public void usingBandage(){
        healingPerSecond();
        
        if(++healCurrentTime == healCastingTime) healingPlus();

    }
    
    public void healingPerSecond(){
        hp += healPerSecond;
        checkMaxHp();
    }
    
    public void healingPlus(){
        healCurrentTime = 0;
        hp += healPlus;
        checkMaxHp();
    }
    
    public void checkMaxHp(){
        if(hp>maxHp) hp=maxHp;
    }
    
    public boolean isDeath(){
        if(hp<=0) {
            hp = -1;
            return true;
        }
        return false;
    }
    
    public void attackedMonster(int[][] attacks){
        hp -= attacks[attackIndex++][1];
        healCurrentTime = 0;
    }
}