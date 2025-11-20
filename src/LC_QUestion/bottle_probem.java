package LC_QUestion;

public class bottle_probem {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalbottles = numBottles;

        while(numBottles >= numExchange) {
            int drinkbottle = numBottles / numExchange;
            int emptybottle = numBottles % numExchange;

            totalbottles = totalbottles + drinkbottle;
            numBottles = drinkbottle + emptybottle;
        }
        return totalbottles;
    }

    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int totalbottles = numBottles;
        int emptybottle = numBottles;
        numBottles = 0;
        while(emptybottle >= numExchange){
            emptybottle = emptybottle - numExchange;
            numBottles += 1;
            numExchange += 1;
        }
        totalbottles += numBottles;
        return totalbottles;
    }
}
