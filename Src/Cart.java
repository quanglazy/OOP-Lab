package Src;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("Đĩa đã được thêm: " + disc.getTitle());
        } else {
            System.out.println("Giỏ hàng gần đầy!");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                found = true;
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("Đĩa đã được xóa: " + disc.getTitle());
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy đĩa trong giỏ hàng.");
        }
    }

    public double totalCost() {
        double totalCost = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            totalCost += itemsOrdered[i].getCost();
        }
        return totalCost;
    }

    public void printCart() {
        System.out.println("Giỏ hàng hiện tại có " + qtyOrdered + " đĩa:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println("- " + itemsOrdered[i].getTitle() + ": " + itemsOrdered[i].getCost());
        }
        System.out.println("Tổng chi phí: " + totalCost());
    }
}
