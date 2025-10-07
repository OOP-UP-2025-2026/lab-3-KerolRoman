package org.example.task2;

public class Order {
    private long id;
    private String customer;

    public Order(long id, String customer) {
        this.id = id;
        this.customer = customer;
    }

    public String formOrderBill(Cart cart) {
        StringBuilder builder = new StringBuilder();
        builder.append("Order number ").append(this.id)
                .append(" for customer ").append(this.customer)
                .append("\n------------------\n");

        for (Item item : cart.getItems()) {
            builder.append("Item id: ").append(item.getId())
                    .append(" | Name: ").append(item.getName())
                    .append(" | Price: ").append(item.getPrice())
                    .append("\n");
        }

        builder.append("------------------\n");
        builder.append("Total sum: ").append(cart.getTotalSum());

        return builder.toString();
    }
}