//Java program to execute various stream methods
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
class Product{
	int id;
	String name;
	float price;
	Product(int id, String name, float price){
		this.id = id;  
        this.name = name;  
        this.price = price;  
	}
	 public int getId() {  
        return id;  
    }  
    public String getName() {  
        return name;  
    }  
	public float getPrice() {  
        return price;  
    }  
}
class Main {
	static BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
	public static void main(String args[]) throws IOException {
	List<Product> productsList = new ArrayList<Product>(); 
	 	productsList.add(new Product(1,"HP Laptop",25000f));  
        productsList.add(new Product(2,"Dell Laptop",30000f));  
        productsList.add(new Product(3,"Lenevo Laptop",28000f));  
        productsList.add(new Product(4,"Sony Laptop",28000f));  
        productsList.add(new Product(5,"Apple Laptop",90000f)); 
		
		Product maxp = productsList.stream().max((p1,p2)->p1.price > p2.price ? 1: -1).get();
		System.out.println(maxp.price);
		
		long count = productsList.stream().filter(p -> p.price < 30000).count();
		System.out.println(count);
		
		Set<Product> set = productsList.stream().filter(p -> p.price < 80000 && p.price > 25000)
		.collect(Collectors.toSet());
		System.out.println(set);
		//output -> [Product@10f87f48, Product@6f496d9f, Product@723279cf]
		
		Set<Float> pset = productsList.stream().filter(p -> p.price < 80000 && p.price > 25000)
		.map(p -> p.price)
		.collect(Collectors.toSet());
		System.out.println(pset);
		//output [30000.0, 28000.0]		
		
		 Map<Integer,String> productMap = productsList.stream()  
            .collect(Collectors.toMap(Product::getId, Product::getName));  
              
        System.out.println(productMap); 
		
		float totalPrice = productsList.stream()  
                    .map(p->p.price)  
                    .reduce(0.0f,(sum, price)->sum+price);   // way 1 -sum price  
        System.out.println(totalPrice);   
		
		Float totalPrice2 = productsList.stream()  
                .map(p->p.price)  // map needed to get price
                .reduce(0.0f,Float::sum);   // way 2 - method of Float class  
        System.out.println(totalPrice2);
		
		double totalPrice3 = productsList.stream()  //map not needed
                        .collect(Collectors.summingDouble(p->p.price)); //way 3 - Collectors summingDouble  
        System.out.println(totalPrice3);  
	}
}
