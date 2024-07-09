# commerce-java

### Entities 
Tengo 4 entidades, Clients, products, invoices e invoicesDetalle
Client
product
invoice
invoiceDetalle



### Repositories ()
Se utilizan para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre las entidades.
ClientsRepository
productsRepository
invoicesRepository
invoicesDetalleRepository

### Services
Esto nos ayuda a separar la lógica de negocio de la lógica de acceso a datos y la lógica de la interfaz de usuario, lo que mejora la organización del código y facilita su mantenimiento y prueba

ClientsService
InvoiceDetallesService
InvoiceService
ProductsService

### Controllers
Responsables de manejar las solicitudes HTTP (GET, POST, PUT, DELETE, etc.) que llegan a la aplicación y de devolver las respuestas adecuadas.
ClientsController
InvoiceDetallesController
InvoicesController
ProductsController
