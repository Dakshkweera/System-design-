# Zomato System Execution Flow

This document explains exactly how data moves and objects are created in the system, starting from the moment you hit "run", right up to the final output on the screen.

## Phase 1: Application Start & Data Setup
**File:** `Main.java`

1. **The Entry Point:** The Java Virtual Machine (JVM) looks for the `main()` method and starts executing line by line.
2. **User Creation:**
   * `new User("U001", "John Doe", "123 Tech Lane")` is called.
   * *Behind the scenes:* The `User` constructor automatically triggers `this.cart = new Cart();`. So, as soon as John Doe is created, he is immediately assigned an empty shopping cart.
3. **Restaurant & Menu Item Creation:**
   * `Restaurant` and `MenuItem` objects are created in memory holding their respective string and double values.
4. **Adding to Cart:**
   * `user.getCart().addItem(pizza, res)` is executed. 
   * The `Cart` checks if it's empty. Since it is, it locks itself to "Pizza Palace" and adds the "Margherita" pizza to its internal `List<MenuItem>`.

---

## Phase 2: Handing over to the Facade
**File:** `Main.java` -> `facade/ZomatoCheckoutFacade.java`

5. **Facade Instantiation:** `ZomatoCheckoutFacade zomato = new ZomatoCheckoutFacade();` creates our complex "orchestrator" object.
6. **Triggering the Checkout:**
   * `zomato.placeOrder(user, new UPI(), new NowOrderFactory());` is called.
   * At this exact moment, we create two new objects "on the fly": a `UPI` strategy object and a `NowOrderFactory` object, and pass them into the facade along with our user.
7. **Screen Output:** The facade begins its work and immediately prints:
   > `--- Starting Checkout for John Doe ---`

---

## Phase 3: The Factory Pattern Process
**File:** `facade/ZomatoCheckoutFacade.java` -> `factories/NowOrderFactory.java`

8. **Order Creation Request:** The facade tells the factory: `factory.createOrder(user)`.
9. **Inside the Factory:**
   * `NowOrderFactory` generates a unique string ID (e.g., "557993c6").
   * It reaches into the user's cart to get the items and the total cost.
   * It decides to create a **`DeliveryOrder`** object (since it's a "now" order) using the user's home address.
   * It returns this fully baked `DeliveryOrder` object back to the Facade.

---

## Phase 4: Setting the Strategy & Payment
**File:** `facade/ZomatoCheckoutFacade.java` -> `models/Order.java` -> `strategies/UPI.java`

10. **Attaching Strategy:** Internal to the Facade, it calls `order.setPaymentStrategy(payment)`. The `DeliveryOrder` we just created now holds a reference to the `UPI` object we passed in step 6.
11. **Processing Payment:** The Facade calls `order.processPayment()`.
12. **Delegation:** The `Order` class doesn't know *how* to pay. It just tells its attached strategy: "Hey, pay this amount".
13. **UPI Execution:** 
    * The code jumps into `UPI.java`'s `pay()` method.
    * **Screen Output:** It prints:
      > `Paid 12.99 using UPI Transaction.`

---

## Phase 5: History & The Singleton
**File:** `facade/ZomatoCheckoutFacade.java` -> `managers/OrderManager.java`

14. **Saving Order:** The Facade does: `OrderManager.getInstance().addOrder(order);`
15. **Singleton Magic:**
    * `OrderManager` checks if it already exists. Since it's the first time we called it, it creates the *one and only* `OrderManager` object in memory.
    * It takes our `DeliveryOrder` and adds it to its internal list.
    * **Screen Output:** It prints:
      > `Order 557993c6 saved to history.`

---

## Phase 6: Final Output & Cleanup
**File:** `facade/ZomatoCheckoutFacade.java`

16. **Getting Order Type:** The Facade wants to know what kind of order was placed. It calls `order.getOrderType()`. Because our factory created a `DeliveryOrder`, this method returns `"DELIVERY to: 123 Tech Lane"`.
17. **Screen Output:** The facade prints:
    > `Order status: DELIVERY to: 123 Tech Lane`
18. **Cleanup:** 
    * The facade clears the cart: `user.getCart().clear()`. The pizza is removed, and the cart is unlocked from the restaurant.
19. **Screen Output:** Finally, it prints:
    > `Cart cleared. Thank you!`
20. **Program End:** The `main` method finishes running, and the application exits.
