## Como iniciar esse projeto:

1. Faça o clone deste repositório.
3. Entre na pasta do projeto
4. Rode o comando no seu terminal: docker compose up --build
5. vualá.

### Dicas Adicionais:

- **Certifique-se de que o Docker e Docker Compose estão em execução**: Antes de rodar o comando `docker-compose up --build`, certifique-se de que o Docker está em execução no seu sistema.
- Baixe as coleções do Postman:
- [Categories](https://raw.githubusercontent.com/KainanGB/stoom/master/Stoom%20-%20Categories.json)
- [Products](https://raw.githubusercontent.com/KainanGB/stoom/master/Stoom%20-%20Products.json)
- [Brands](https://raw.githubusercontent.com/KainanGB/stoom/master/Stoom%20-%20Brand.json)
- [Orders](https://raw.githubusercontent.com/KainanGB/stoom/master/Stoom%20-%20Orders.json)

### Implemented Endpoints:

Brand Endpoints
Get all brands:

URL: /api/brands
Method: GET
Query Parameters:
active (boolean): Filter by active status. Default is true.
name (string): Filter by brand name.
page (int): Page number for pagination.
size (int): Page size for pagination. Default is 10.
Get brand by ID:

URL: /api/brands/{id}
Method: GET
Path Variable: id (Long): ID of the brand.
Create a new brand:

URL: /api/brands
Method: POST
Request Body: Brand object.
Update a brand:

URL: /api/brands/{id}
Method: PUT
Path Variable: id (Long): ID of the brand.
Request Body: Brand object.
Delete a brand:

URL: /api/brands/{id}
Method: DELETE
Path Variable: id (Long): ID of the brand.
Category Endpoints
Get all categories:

URL: /api/categories
Method: GET
Query Parameters:
active (boolean): Filter by active status. Default is true.
name (string): Filter by category name.
page (int): Page number for pagination.
size (int): Page size for pagination. Default is 10.
Get category by ID:

URL: /api/categories/{id}
Method: GET
Path Variable: id (Long): ID of the category.
Create a new category:

URL: /api/categories
Method: POST
Request Body: Category object.
Update a category:

URL: /api/categories/{id}
Method: PUT
Path Variable: id (Long): ID of the category.
Request Body: Category object.
Delete a category:

URL: /api/categories/{id}
Method: DELETE
Path Variable: id (Long): ID of the category.
Order Endpoints
Get all orders:

URL: /api/orders
Method: GET
Query Parameters:
page (int): Page number for pagination.
size (int): Page size for pagination. Default is 10.
Get order by ID:

URL: /api/orders/{id}
Method: GET
Path Variable: id (Long): ID of the order.
Create a new order:

URL: /api/orders
Method: POST
Request Body: Order object.
Update an order:

URL: /api/orders/{id}
Method: PUT
Path Variable: id (Long): ID of the order.
Request Body: Order object.
Delete an order:

URL: /api/orders/{id}
Method: DELETE
Path Variable: id (Long): ID of the order.
Product Endpoints
Get all products:

URL: /api/products
Method: GET
Query Parameters:
active (boolean): Filter by active status. Default is true.
Get product by ID:

URL: /api/products/{id}
Method: GET
Path Variable: id (Long): ID of the product.
Create a new product:

URL: /api/products
Method: POST
Request Body: Product object.
Update a product:

URL: /api/products/{id}
Method: PUT
Path Variable: id (Long): ID of the product.
Request Body: Product object.
Delete a product:

URL: /api/products/{id}
Method: DELETE
Path Variable: id (Long): ID of the product.

## Instruções do projeto:

**Seja bem-vindo candidato!**

Como um desenvolvedor Back-End na Stoom uma das maiores responsabilidades que você vai ter é desenvolver funcionalidades e corrigir bugs em sistemas de e-commerce de larga escala que utilizam Spring Boot. Com base nisso, precisamos de sua ajuda para construir a nossa loja Stoom, que deve conter as seguintes funcionalidades:

1. Deve ser desenvolvida uma API de CRUD de produtos
2. Os produtos devem ser enriquecidos com as informações que você julgar relevante para o funcionamento em uma loja, algumas são obrigatórias:
    - Categorias
    - Marca
    - Preços
3. Deve existir um endpoint na API para a busca de produtos que será utilizada na loja
4. Deve existir um endpoint que lista os produtos de uma determinada Marca
5. Deve existir um endpoint que lista os produtos de uma determinada Categoria
6. Produtos podem ser inativados para não aparecerem na busca ou nas listagens sem a necessidade de serem deletados para poderem ser reativados posteriormente
7. Marcas e categorias também podem ser inativados para não aparecerem na loja

**Informações relevantes**:
- Atente-se à todos os pré-requisitos estabelecidos, porém não limite-se a eles, ideias novas ou melhorias são sempre bem-vindas :smiley:
- Você tem total liberdade para fazer qualquer tipo de alteração em qualquer ponto do código (contanto que não alterem a maneira de execução da aplicação)
- Se possível, adicione uma collection do Postman no repositório para conseguirmos testar o código da mesma forma que você
- Boas práticas, legibilidade, testes e performance são alguns dos pontos que serão considerados durante a avaliação

**Boa sorte!**
