Feature: Product - Store
  @testStore
  Scenario Outline: Validación del precio de un producto
    Given estoy en la página de la tienda
    When hago clic en el botón Iniciar sesión
    And me logueo con mi usuario "<correo>" y clave "<password>"
    And navego a la categoría "<category>" y subcategoría "<subcategory>"
    And agrego 2 unidades del primer producto al carrito
    Then valido en el pop-up la confirmación del producto agregado
    And valido en el pop-up que el monto total sea calculado correctamente
    When finalizo la compra
    Then valido el título de la página del carrito
    And vuelvo a validar el cálculo de precios en el carrito

    Examples:
      | correo                   | password   | category | subcategory |
      | kvegavilca@gmail.com     | Prueba@@111 | clothes  | men         |
      | kvegavilca@gmail.com     | Prueba@@1   | clothes  | men         |
      | kvegavilca@gmail.com     | Prueba@@111 | autos    | freno       |
