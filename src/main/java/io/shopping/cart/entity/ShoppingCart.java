package io.shopping.cart.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.akkaserverless.javasdk.eventsourcedentity.EventSourcedEntityContext;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;

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
    return CartEntity.CartState.getDefaultInstance();
  }

  @Override
  public Effect<Empty> addItem(CartEntity.CartState state, CartApi.AddLineItem command) {
    return reject(state, command).orElse(handle(state, command));
  }

  @Override
  public Effect<Empty> changeItem(CartEntity.CartState state, CartApi.ChangeLineItem command) {
    return reject(state, command).orElse(handle(state, command));
  }

  @Override
  public Effect<Empty> removeItem(CartEntity.CartState state, CartApi.RemoveLineItem command) {
    return reject(state, command).orElse(handle(state, command));
  }

  @Override
  public Effect<Empty> checkoutCart(CartEntity.CartState state, CartApi.CheckoutShoppingCart command) {
    return reject(state, command).orElse(handle(state, command));
  }

  @Override
  public Effect<Empty> shippedCart(CartEntity.CartState state, CartApi.ShippedShoppingCart command) {
    return reject(state, command).orElse(handle(state, command));
  }

  @Override
  public Effect<Empty> deliveredCart(CartEntity.CartState state, CartApi.DeliveredShoppingCart command) {
    return reject(state, command).orElse(handle(state, command));
  }

  @Override
  public Effect<Empty> deleteCart(CartEntity.CartState state, CartApi.DeleteShoppingCart command) {
    return reject(state, command).orElse(handle(state, command));
  }

  @Override
  public Effect<CartApi.ShoppingCart> getCart(CartEntity.CartState state, CartApi.GetShoppingCart command) {
    return reject(state, command).orElse(handle(state, command));
  }

  @Override
  public CartEntity.CartState itemAdded(CartEntity.CartState state, CartEntity.ItemAdded event) {
    return Cart
        .fromState(state)
        .handle(event)
        .toState();
  }

  @Override
  public CartEntity.CartState itemChanged(CartEntity.CartState state, CartEntity.ItemChanged event) {
    return Cart
        .fromState(state)
        .handle(event)
        .toState();
  }

  @Override
  public CartEntity.CartState itemRemoved(CartEntity.CartState state, CartEntity.ItemRemoved event) {
    return Cart
        .fromState(state)
        .handle(event)
        .toState();
  }

  @Override
  public CartEntity.CartState cartCheckedOut(CartEntity.CartState state, CartEntity.CartCheckedOut event) {
    return Cart
        .fromState(state)
        .handle(event)
        .toState();
  }

  @Override
  public CartEntity.CartState cartShipped(CartEntity.CartState state, CartEntity.CartShipped event) {
    return Cart
        .fromState(state)
        .handle(event)
        .toState();
  }

  @Override
  public CartEntity.CartState cartDelivered(CartEntity.CartState state, CartEntity.CartDelivered event) {
    return Cart
        .fromState(state)
        .handle(event)
        .toState();
  }

  @Override
  public CartEntity.CartState cartDeleted(CartEntity.CartState state, CartEntity.CartDeleted event) {
    return Cart
        .fromState(state)
        .handle(event)
        .toState();
  }

  private Optional<Effect<Empty>> reject(CartEntity.CartState state, CartApi.AddLineItem command) {
    if (state.getCheckedOutUtc().getSeconds() > 0) {
      return Optional.of(effects().error("Shopping cart is already checked out"));
    }
    if (state.getDeletedUtc().getSeconds() > 0) {
      return Optional.of(effects().error("Shopping cart is deleted"));
    }
    if (command.getCustomerId().isEmpty()) {
      return Optional.of(effects().error("Customer ID is required"));
    }
    if (command.getProductId().isEmpty()) {
      return Optional.of(effects().error("Product ID is required"));
    }
    if (command.getProductName().isEmpty()) {
      return Optional.of(effects().error("Product name is required"));
    }
    if (command.getQuantity() <= 0) {
      return Optional.of(effects().error("Quantity must be greater than 0"));
    }
    return Optional.empty();
  }

  private Optional<Effect<Empty>> reject(CartEntity.CartState state, CartApi.ChangeLineItem command) {
    return Optional.empty();
  }

  private Optional<Effect<Empty>> reject(CartEntity.CartState state, CartApi.RemoveLineItem command) {
    return Optional.empty();
  }

  private Optional<Effect<Empty>> reject(CartEntity.CartState state, CartApi.CheckoutShoppingCart command) {
    return Optional.empty();
  }

  private Optional<Effect<Empty>> reject(CartEntity.CartState state, CartApi.ShippedShoppingCart command) {
    return Optional.empty();
  }

  private Optional<Effect<Empty>> reject(CartEntity.CartState state, CartApi.DeliveredShoppingCart command) {
    return Optional.empty();
  }

  private Optional<Effect<Empty>> reject(CartEntity.CartState state, CartApi.DeleteShoppingCart command) {
    return Optional.empty();
  }

  private Optional<Effect<CartApi.ShoppingCart>> reject(CartEntity.CartState state, CartApi.GetShoppingCart command) {
    if (state.getCartId().isEmpty()) {
      return Optional.of(effects().error("Shopping cart is empty"));
    }
    return Optional.empty();
  }

  private Effect<Empty> handle(CartEntity.CartState state, CartApi.AddLineItem command) {
    return effects()
        .emitEvent(event(state, command))
        .thenReply(newState -> Empty.getDefaultInstance());
  }

  private Effect<Empty> handle(CartEntity.CartState state, CartApi.ChangeLineItem command) {
    return effects()
        .emitEvent(event(state, command))
        .thenReply(newState -> Empty.getDefaultInstance());
  }

  private Effect<Empty> handle(CartEntity.CartState state, CartApi.RemoveLineItem command) {
    return effects()
        .emitEvent(event(state, command))
        .thenReply(newState -> Empty.getDefaultInstance());
  }

  private Effect<Empty> handle(CartEntity.CartState state, CartApi.CheckoutShoppingCart command) {
    return effects()
        .emitEvent(event(state, command))
        .thenReply(newState -> Empty.getDefaultInstance());
  }

  private Effect<Empty> handle(CartEntity.CartState state, CartApi.ShippedShoppingCart command) {
    return effects()
        .emitEvent(event(state, command))
        .thenReply(newState -> Empty.getDefaultInstance());
  }

  private Effect<Empty> handle(CartEntity.CartState state, CartApi.DeliveredShoppingCart command) {
    return effects()
        .emitEvent(event(state, command))
        .thenReply(newState -> Empty.getDefaultInstance());
  }

  private Effect<Empty> handle(CartEntity.CartState state, CartApi.DeleteShoppingCart command) {
    return effects()
        .emitEvent(event(state, command))
        .thenReply(newState -> Empty.getDefaultInstance());
  }

  private Effect<CartApi.ShoppingCart> handle(CartEntity.CartState state, CartApi.GetShoppingCart command) {
    return effects().reply(toApi(state));
  }

  private static CartEntity.ItemAdded event(CartEntity.CartState state, CartApi.AddLineItem command) {
    var lineItem = CartEntity.LineItem
        .newBuilder()
        .setProductId(command.getProductId())
        .setProductName(command.getProductName())
        .setQuantity(command.getQuantity())
        .build();
    return CartEntity.ItemAdded.newBuilder()
        .setCartId(command.getCartId())
        .setCustomerId(command.getCustomerId())
        .setLineItem(lineItem)
        .build();
  }

  private static CartEntity.ItemChanged event(CartEntity.CartState state, CartApi.ChangeLineItem command) {
    return null;
  }

  private static CartEntity.ItemRemoved event(CartEntity.CartState state, CartApi.RemoveLineItem command) {
    return null;
  }

  private static CartEntity.CartCheckedOut event(CartEntity.CartState state, CartApi.CheckoutShoppingCart command) {
    return null;
  }

  private static CartEntity.CartShipped event(CartEntity.CartState state, CartApi.ShippedShoppingCart command) {
    return null;
  }

  private static CartEntity.CartDelivered event(CartEntity.CartState state, CartApi.DeliveredShoppingCart command) {
    return null;
  }

  private static CartEntity.CartDeleted event(CartEntity.CartState state, CartApi.DeleteShoppingCart command) {
    return null;
  }

  private static CartApi.ShoppingCart toApi(CartEntity.CartState state) {
    return CartApi.ShoppingCart
        .newBuilder()
        .setCartId(state.getCartId())
        .setCustomerId(state.getCustomerId())
        .setCheckedOutUtc(toUtc(state.getCheckedOutUtc()))
        .setShippedUtc(toUtc(state.getShippedUtc()))
        .setDeliveredUtc(toUtc(state.getDeliveredUtc()))
        .setDeletedUtc(toUtc(state.getDeletedUtc()))
        .addAllLineItems(toApi(state.getLineItemsList()))
        .build();
  }

  private static List<CartApi.LineItem> toApi(List<CartEntity.LineItem> lineItems) {
    return lineItems.stream().map(
        lineItem -> CartApi.LineItem
            .newBuilder()
            .setProductId(lineItem.getProductId())
            .setProductName(lineItem.getProductName())
            .setQuantity(lineItem.getQuantity())
            .build())
        .collect(Collectors.toList());
  }

  private static String toUtc(Timestamp timestamp) {
    if (timestamp.getSeconds() == 0) {
      return "";
    }
    var dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    return dateFormat.format(new Date(timestamp.getSeconds() * 1000 + timestamp.getNanos() / 1000000));
  }

  static class Cart {
    CartEntity.CartState state;
    final Map<String, CartEntity.LineItem> lineItems = new LinkedHashMap<>();

    public Cart(CartEntity.CartState state) {
      this.state = state;
      state.getLineItemsList().forEach(lineItem -> lineItems.put(lineItem.getProductId(), lineItem));
    }

    static Cart fromState(CartEntity.CartState state) {
      return new Cart(state);
    }

    Cart handle(CartEntity.ItemAdded event) {
      lineItems.computeIfPresent(event.getLineItem().getProductId(),
          (productId, lineItem) -> lineItem
              .toBuilder()
              .setQuantity(lineItem.getQuantity() + event.getLineItem().getQuantity())
              .build());
      lineItems.computeIfAbsent(event.getLineItem().getProductId(),
          productId -> CartEntity.LineItem
              .newBuilder()
              .setProductId(event.getLineItem().getProductId())
              .setProductName(event.getLineItem().getProductName())
              .setQuantity(event.getLineItem().getQuantity())
              .build());
      state = state.toBuilder()
          .setCartId(event.getCartId())
          .setCustomerId(event.getCustomerId())
          .clearLineItems()
          .addAllLineItems(lineItems.values())
          .build();
      return this;
    }

    Cart handle(CartEntity.ItemChanged event) {
      return this;
    }

    Cart handle(CartEntity.ItemRemoved event) {
      return this;
    }

    Cart handle(CartEntity.CartCheckedOut event) {
      return this;
    }

    Cart handle(CartEntity.CartShipped event) {
      return this;
    }

    Cart handle(CartEntity.CartDelivered event) {
      return this;
    }

    Cart handle(CartEntity.CartDeleted event) {
      return this;
    }

    CartEntity.CartState toState() {
      return state;
    }
  }
}
