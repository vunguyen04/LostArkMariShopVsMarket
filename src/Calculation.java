public class Calculation {
    public float goldPerItem(int goldPer95Crystal, int amountMariItem, int mariCost){
        float crystalPerOne;
        float mariCostToGold;

        crystalPerOne = (float) mariCost / amountMariItem;
        mariCostToGold = (float) ((goldPer95Crystal * crystalPerOne) / 95);
        return mariCostToGold;

    }
}
