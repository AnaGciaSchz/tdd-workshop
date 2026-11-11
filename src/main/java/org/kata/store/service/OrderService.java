package org.kata.store.service;

/*
 * TODO: Registro de pedidos.
 *
 * Requisitos (escribe primero el test de cada uno):
 *   - Crear un pedido para un usuario: queda en estado DRAFT.
 *   - No se puede crear un pedido para un usuario que no existe: se lanza una excepción.
 *   - No se puede crear un pedido con precio menor o igual que 0: se lanza una excepción.
 *   - Avanzar un pedido al siguiente estado (DRAFT -> PROCESSED -> DISPATCHED -> DELIVERED).
 *   - No se puede saltar un estado, retroceder ni cambiar un pedido entregado: se lanza una excepción.
 *
 * Pista: recibe UserRepository y OrderRepository por constructor.
 *   - Stub: when(userRepository.existsById(...)).thenReturn(false) para probar el usuario inexistente.
 *   - Mock: verify(orderRepository).save(...) para comprobar que el pedido se guarda.
 */
public class OrderService {
}
