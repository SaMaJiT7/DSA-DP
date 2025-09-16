public class card_common {
    public int score(String[] cards, char x) {
        int count = 0;
        for(int i = 0; i < cards.length-1; i++){
            String s1 = cards[i];
            String s2 = cards[i+1];
            if(s1.equals(s2)){
                i++;
            }
            else{
                String charAsString = String.valueOf(x);
                if(s1.contains(charAsString)&&s2.contains(charAsString)){
                    count = count + 1;
                }
                i++;
            }
        }
        return count;
    }
}
