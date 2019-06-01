package search_in_array;

import java.util.*;

public class Knapsak {
    public static void main(String[] args) {
        Item item1 = new Item(12,4);
        Item item2 = new Item(2,2);
        Item item3 = new Item(2,2);
        Item item4 = new Item(1,1);
        Item item5 = new Item(1,2);
        Item item6 = new Item(4,10);
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);

        System.out.println(doKnapsak(16, items));
    }

    private static List<Item> doKnapsak(int totalWeight, List<Item> items){
        Map<Integer, List<Item>> itemsPerTotalWeight = new HashMap<>();
        for (int i = 0; i < items.size(); i++) {
            List<Item> currentItems = new ArrayList<>();
            int weightCount = items.get(i).getWeight();
            int priceCount = items.get(i).getPrice();
            currentItems.add(items.get(i));
            for (int j = 0; j < items.size(); j++) {
                if(i==j){
                    continue;
                }
                weightCount += items.get(j).getWeight();
                priceCount += items.get(j).getPrice();
                currentItems.add(items.get(j));
                if(weightCount==totalWeight){
                    itemsPerTotalWeight.put(priceCount, currentItems);
                    break;
                }
            }
        }
        Integer index = itemsPerTotalWeight.keySet().stream().max(Integer::compareTo).orElse(0);
        return itemsPerTotalWeight.get(index);
    }

    static class Item{
        private int weight;
        private int price;

        public Item(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "weight=" + weight +
                    ", price=" + price +
                    '}';
        }
    }
}
