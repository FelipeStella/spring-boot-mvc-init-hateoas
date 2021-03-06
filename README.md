# Spring HATEOAS

Spring HATEOAS fornece algumas APIs para facilitar a criação de representações REST que seguem o princípio HATEOAS ao trabalhar com Spring e especialmente Spring MVC. O principal problema que ele tenta resolver é a criação de links e montagem de representação.

# Filtro de servlet

Um filtro é um objeto que é chamado no pré-processamento e pós-processamento de uma solicitação.
É usado principalmente para realizar tarefas de filtragem, como conversão, registro, compressão, criptografia e descriptografia, validação de entrada, etc.

# Conversão Objeto Java -> Json

No Java existem algumas bibliotecas para fazer conversão Java <-> JSON, dentre elas: Jackson, Jettison e Gson.
O Spring por padrão utiliza o Jackson, mas é possível substituir por essas outras, caso você queira.

# Binding de requisição HTTP

Consiste em mapear atributos em requisições HTTP para objetos ou mapas. A forma como isso é feito depende do framework.

JSF por exemplo usa tags especiais como `<h:inputText/>:`

`<h:inputText value="#{userController.username}" />`

<p> O exemplo acima iria mapear o campo no HTML com um atributo String username na classe UserController.

Frameworks como Spring MVC ou compatíveis com JAX-RS geralmente mapeiam cada parâmetro da requisição diretamente para um atributo
  
# MockMVC
  
MockMvcé definido como um ponto de entrada principal para o teste Spring MVC do lado do servidor. Os testes com MockMvcsituam-se entre os testes de unidade e de integração.
