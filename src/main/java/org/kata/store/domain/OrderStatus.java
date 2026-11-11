package org.kata.store.domain;

/*
 * Estados por los que pasa un pedido, en este orden:
 *
 *   DRAFT -> PROCESSED -> DISPATCHED -> DELIVERED
 *
 * Requisitos (escribe primero el test de cada uno):
 *   - Un pedido nuevo siempre empieza en DRAFT.
 *   - Solo se puede avanzar al estado siguiente: no se puede saltar un estado ni retroceder.
 *   - DELIVERED es el estado final: un pedido entregado no puede cambiar de estado.
 *
 * Pista: decide tú dónde vive la regla de "cuál es el siguiente estado" (aquí, en Order o en un servicio)
 * y deja que los tests te guíen.
 */
public enum OrderStatus {
    DRAFT,
    PROCESSED,
    DISPATCHED,
    DELIVERED
}
