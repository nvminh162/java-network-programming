/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b08_producter_consumer;

import java.util.ArrayList;

/**
 *
 * @author nvmin
 */
public class Buffer {
    //Kha nang chua toi da
    private int capacity;
    // Danh sach san pham
    private ArrayList<Integer> products = new ArrayList<>();

    public Buffer(int capacity) {
        this.capacity = capacity;
    }
    
    public void addProduct(int product, int producterId) {
        System.out.println(">>>>----------------------------");
        System.out.println("NSX: "+ producterId + "đã thêm sản phẩm "+product);
        products.add(product);
        System.out.println("SL tồn: "+ products.size());
    }
    
    public void removeProduct(int consumerId) {
        System.out.println("<<<<------------------------------");
        System.out.println("Khách hàng "+ consumerId + "đã mua sản phẩm" + products.get(0));
        products.remove(0);
        System.out.println("SL tồn: "+ products.size());
    }
    
    public int getSize() {
        return this.products.size();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    
}
