package ContainerTrade;

import java.util.*;

public class ContainerTrade {

}
class ShippingYard {
    // ClientId -> ContainterType -> amount
    private Map<Integer, Map<String, Integer>> containerMap;
    OrderBook orderBook;

    public ShippingYard() {
        this.containerMap = new HashMap<>();
        this.orderBook = new OrderBook();
    }

    public void addContainer(int clientId, String containerType, int amount) {
        Map<String, Integer> clientContainerMap = containerMap.getOrDefault(clientId, new HashMap<>());
        clientContainerMap.put(containerType, clientContainerMap.getOrDefault(containerType, 0) + amount);
    }

    public void removeContainer(int clientId, String containerType, int amount) {
        if (!containerMap.containsKey(clientId)) throw new RuntimeException(" Client doesn't exist");
        Map<String, Integer> clientContainerMap = containerMap.get(clientId);
        if (!clientContainerMap.containsKey(containerType)) throw new RuntimeException(" Container type doesn't exist");
        if (amount > clientContainerMap.get(containerType) - amount) throw new RuntimeException(" Cannot remove more than balance ");
        clientContainerMap.put(containerType, clientContainerMap.get(containerType) - amount);
    }

    public void executeSell(int clientId, String containerType, int amount) {
        if (!orderBook.getBuyOrders().containsKey(clientId)) throw new RuntimeException(" Client doesn't exist");
        Map<String,PriorityQueue<Order>> clientBuyOrder = orderBook.getSellOrders().get(clientId);
        PriorityQueue<Order> pq = clientBuyOrder.get(containerType);
        Order order = pq.poll();
        removeContainer(clientId, containerType, order.getAmount());
    }
}

class Order {
    private int amount;
    private double price;

    public Order(int amount, double price) {
        this.amount = amount;
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }
}

class OrderBook {
    private Map<Integer, Map<String,PriorityQueue<Order>>> buyOrders;
    private Map<Integer, Map<String,PriorityQueue<Order>>> sellOrders;

    public OrderBook() {
        this.buyOrders = new HashMap<>();
        this.sellOrders = new HashMap<>();
    }

    public void addBuyOrder(int clientId, String containerType, int amount, double price) {
        if (!buyOrders.containsKey(clientId)) throw new RuntimeException(" Client doesn't exist");
        Map<String, PriorityQueue<Order>> clientBuyOrder = buyOrders.get(clientId);
        if (!clientBuyOrder.containsKey(containerType)) throw new RuntimeException(" Container type doesn't exist");
        PriorityQueue<Order> pq = clientBuyOrder.getOrDefault(containerType,
                new PriorityQueue<>((o1, o2) -> {return (int) (o1.getAmount() / o1.getPrice() - o2.getAmount() / o2.getPrice());}));
        pq.offer(new Order(amount, price));
        clientBuyOrder.put(containerType, pq);
        buyOrders.put(clientId, clientBuyOrder);
    }

    public void addSellOrder(int clientId, String containerType, int amount, double price) {
        if (!sellOrders.containsKey(clientId)) throw new RuntimeException(" Client doesn't exist");
        Map<String, PriorityQueue<Order>> clientSellOrder = sellOrders.get(clientId);
        if (!clientSellOrder.containsKey(containerType)) throw new RuntimeException(" Container type doesn't exist");
        PriorityQueue<Order> pq = clientSellOrder.getOrDefault(containerType,
                new PriorityQueue<>((o1, o2) -> {return (int) (o2.getAmount() / o2.getPrice() - o1.getAmount() / o1.getPrice());}));
        pq.offer(new Order(amount, price));
        clientSellOrder.put(containerType, pq);
        sellOrders.put(clientId, clientSellOrder);
    }

    public Map<Integer, Map<String,PriorityQueue<Order>>> getBuyOrders() {
        return this.buyOrders;
    }

    public Map<Integer, Map<String,PriorityQueue<Order>>> getSellOrders() {
        return this.sellOrders;
    }
}


