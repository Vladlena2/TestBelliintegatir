/*
����������� ����� ������� ��������-�������� �� ���������� Basket
 */

package Task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Basket{
    void addProduct(String product, int quantity);
    void removeProduct(String product);
    void updateProductQuantity(String product, int quantity);
    void clear();
    List<String> getProducts();
    int getProductQuantity(String product);
}

class Product {
    String name;
    int quantity;

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

}

class MyBasket implements Basket{
    private Product[] array = new Product[10];
    private int size = 0;

    @Override
    public void addProduct(String product, int quantity) {
        Product newProduct = new Product(product, quantity);

        if (size >= array.length){
            array = Arrays.copyOf(array, array.length * 2);
        }

        array[size] = newProduct;
        size++;
    }

    @Override
    public void removeProduct(String product) {
        for (int i = 0; i < size; i++) {
            if (array[i].name.equals(product))
                removeAt(i);
        }
    }

    private void removeAt(int index) {
        checkIndex(index);
        if (size - 1 - index >= 0)
            System.arraycopy(array, index + 1, array, index, size - 1 - index);
        size--;
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        for (int i = 0; i < size; i++) {
            if (array[i].name.equals(product))
                array[i].quantity = quantity;
        }
    }

    @Override
    public void clear() {
        array = new Product[10];
        size = 0;
    }

    @Override
    public List<String> getProducts() {
        var nameProducts = new ArrayList<String>();

        for (int i = 0; i < size; i++) {
            nameProducts.add(array[i].name);
        }

        return nameProducts;
    }

    @Override
    public int getProductQuantity(String product) {
        for (int i = 0; i < size; i++) {
            if (array[i].name.equals(product))
                return array[i].quantity;
        }
        return 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyBasket basket = new MyBasket();

        basket.addProduct("��������", 3);
        basket.addProduct("������", 120);
        basket.addProduct("������", 100);
        basket.addProduct("���������", 0);

        System.out.println("������� " + basket.getProducts());

        basket.removeProduct("������");
        System.out.println("���������� �������: " + basket.getProductQuantity("��������"));
        basket.updateProductQuantity("���������", 23);
        System.out.println("���������� ����������: " + basket.getProductQuantity("���������"));

        System.out.println("������� " + basket.getProducts());

        basket.clear();

        System.out.println("������� " + basket.getProducts());
    }
}

