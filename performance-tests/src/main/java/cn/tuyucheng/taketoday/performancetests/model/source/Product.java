package cn.tuyucheng.taketoday.performancetests.model.source;

import java.math.BigDecimal;

public class Product {
   String description;
   boolean available;
   private BigDecimal price;
   private int quantity;
   private String name;
   private RefundPolicy refundPolicy;

   public Product() {
   }

   public Product(BigDecimal price, int quantity, String name, String description, boolean available, RefundPolicy refundPolicy) {
      this.price = price;
      this.quantity = quantity;
      this.name = name;
      this.description = description;
      this.available = available;
      this.refundPolicy = refundPolicy;
   }

   public BigDecimal getPrice() {
      return price;
   }

   public void setPrice(BigDecimal price) {
      this.price = price;
   }

   public int getQuantity() {
      return quantity;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public boolean isAvailable() {
      return available;
   }

   public void setAvailable(boolean available) {
      this.available = available;
   }

   public RefundPolicy getRefundPolicy() {
      return refundPolicy;
   }

   public void setRefundPolicy(RefundPolicy refundPolicy) {
      this.refundPolicy = refundPolicy;
   }
}