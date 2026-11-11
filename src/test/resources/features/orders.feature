# Extra opcional: escenarios de Cucumber del registro de pedidos.
#
# Quita los "#" del ejemplo y adáptalo a tu API. Cada frase necesita su step en org.kata.store.cucumber.
#
# Feature: Registro de pedidos
#
#   Scenario: Un pedido nuevo empieza en borrador
#     Given un usuario con id 1 llamado "Ana" "García"
#     When el usuario 1 crea un pedido de 50.0 euros
#     Then el pedido está en estado "DRAFT"
#
#   Scenario Outline: El pedido avanza por sus estados
#     Given un pedido en estado "<actual>"
#     When avanzo el pedido
#     Then el pedido está en estado "<siguiente>"
#
#     Examples:
#       | actual     | siguiente  |
#       | DRAFT      | PROCESSED  |
#       | PROCESSED  | DISPATCHED |
#       | DISPATCHED | DELIVERED  |
