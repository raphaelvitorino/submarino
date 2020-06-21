Feature: Submarino

  Scenario: Adicionar um produto no carrinho
    Given O usuário acessa o site do submarino
    When Pesquisar por um produto
    Then O produto deve aparecer na tela
    And Adicionar o produto no carrinho
    Then O produto deve ser adicionado no carrinho