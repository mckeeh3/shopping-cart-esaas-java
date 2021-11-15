package io.shopping.cart.entity;

import com.akkaserverless.javasdk.eventsourcedentity.EventSourcedEntity;
import com.akkaserverless.javasdk.eventsourcedentity.EventSourcedEntity.Effect;
import com.akkaserverless.javasdk.eventsourcedentity.EventSourcedEntityContext;
import com.google.protobuf.Empty;
import io.shopping.cart.CartApi;

// This class was initially generated based on the .proto definition by Akka Serverless tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

/** An event sourced entity. */
public class ShoppingCart extends AbstractShoppingCart {

  @SuppressWarnings("unused")
  private final String entityId;

  public ShoppingCart(EventSourcedEntityContext context) {
    this.entityId = context.entityId();
  }

  @Override
  public CartEntity.CartState emptyState() {
    throw new UnsupportedOperationException("Not implemented yet, replace with your empty entity state");
  }

  @Override
  public Effect<Empty> addItem(CartEntity.CartState currentState, CartApi.AddLineItem addLineItem) {
    return effects().error("The command handler for `AddItem` is not implemented, yet");
  }

  @Override
  public Effect<Empty> changeItem(CartEntity.CartState currentState, CartApi.ChangeLineItem changeLineItem) {
    return effects().error("The command handler for `ChangeItem` is not implemented, yet");
  }

  @Override
  public Effect<Empty> removeItem(CartEntity.CartState currentState, CartApi.RemoveLineItem removeLineItem) {
    return effects().error("The command handler for `RemoveItem` is not implemented, yet");
  }

  @Override
  public Effect<Empty> checkoutCart(CartEntity.CartState currentState, CartApi.CheckoutShoppingCart checkoutShoppingCart) {
    return effects().error("The command handler for `CheckoutCart` is not implemented, yet");
  }

  @Override
  public Effect<Empty> shippedCart(CartEntity.CartState currentState, CartApi.ShippedShoppingCart shippedShoppingCart) {
    return effects().error("The command handler for `ShippedCart` is not implemented, yet");
  }

  @Override
  public Effect<Empty> deliveredCart(CartEntity.CartState currentState, CartApi.DeliveredShoppingCart deliveredShoppingCart) {
    return effects().error("The command handler for `DeliveredCart` is not implemented, yet");
  }

  @Override
  public Effect<Empty> deleteCart(CartEntity.CartState currentState, CartApi.DeleteShoppingCart deleteShoppingCart) {
    return effects().error("The command handler for `DeleteCart` is not implemented, yet");
  }

  @Override
  public Effect<CartApi.ShoppingCart> getCart(CartEntity.CartState currentState, CartApi.GetShoppingCart getShoppingCart) {
    return effects().error("The command handler for `GetCart` is not implemented, yet");
  }

  @Override
  public CartEntity.CartState itemAdded(CartEntity.CartState currentState, CartEntity.ItemAdded itemAdded) {
    throw new RuntimeException("The event handler for `ItemAdded` is not implemented, yet");
  }
  @Override
  public CartEntity.CartState itemChanged(CartEntity.CartState currentState, CartEntity.ItemChanged itemChanged) {
    throw new RuntimeException("The event handler for `ItemChanged` is not implemented, yet");
  }
  @Override
  public CartEntity.CartState itemRemoved(CartEntity.CartState currentState, CartEntity.ItemRemoved itemRemoved) {
    throw new RuntimeException("The event handler for `ItemRemoved` is not implemented, yet");
  }
  @Override
  public CartEntity.CartState cartCheckedOut(CartEntity.CartState currentState, CartEntity.CartCheckedOut cartCheckedOut) {
    throw new RuntimeException("The event handler for `CartCheckedOut` is not implemented, yet");
  }
  @Override
  public CartEntity.CartState cartShipped(CartEntity.CartState currentState, CartEntity.CartShipped cartShipped) {
    throw new RuntimeException("The event handler for `CartShipped` is not implemented, yet");
  }
  @Override
  public CartEntity.CartState cartDelivered(CartEntity.CartState currentState, CartEntity.CartDelivered cartDelivered) {
    throw new RuntimeException("The event handler for `CartDelivered` is not implemented, yet");
  }
  @Override
  public CartEntity.CartState cartDeleted(CartEntity.CartState currentState, CartEntity.CartDeleted cartDeleted) {
    throw new RuntimeException("The event handler for `CartDeleted` is not implemented, yet");
  }

}
