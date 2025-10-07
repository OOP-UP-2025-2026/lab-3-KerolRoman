package org.example.task2;

import java.util.Arrays;

public class Cart {
    private Item[] contents;
    private int index;

    public Cart(int capacity) {
        this.contents = new Item[capacity];
        this.index = 0;
    }

    public void add(Item item) {
        if (this.index < this.contents.length) {
            this.contents[this.index++] = item;
        } else {
            System.out.println("Cart is full!");
        }
    }

    public void removeById(long id) {
        for (int i = 0; i < this.index; i++) {
            if (this.contents[i].getId() == id) {
                // зсуваємо елементи вліво
                for (int j = i; j < this.index - 1; j++) {
                    this.contents[j] = this.contents[j + 1];
                }
                this.contents[--this.index] = null;
                System.out.println("Item with id " + id + " removed.");
                return;
            }
        }
        System.out.println("Item with id " + id + " not found.");
    }

    public double getTotalSum() {
        double sum = 0;
        for (int i = 0; i < this.index; i++) {
            sum += this.contents[i].getPrice();
        }
        return sum;
    }

    public Item[] getItems() {
        return Arrays.copyOf(this.contents, this.index);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Cart contents:\n");
        for (int i = 0; i < this.index; i++) {
            builder.append(this.contents[i]).append("\n");
        }
        return builder.toString();
    }
}