# fundamentos_entrega2
Este manual describe el funcionamiento de dos archivos Java: `GenerateInfoFiles.java` y `SalesReportGenerator.java`. Estos archivos son parte del sistema de generación de archivos de información y de informes de ventas basados en datos de aleatorios almacenados en archivos. 

# Members
## Leidy Julieth Cruz Cruz
## Sandra Milena Fernandez Roa
## Oscar Giobani Clavijo Gutiérrez
## Flavio Cesar Fonseca
## Felipe Moreno Caro 

### Versión en Español

#### GenerateInfoFiles.java

Este archivo contiene una clase llamada `GenerateInfoFiles`, que se encarga de generar archivos de información requeridos para una aplicación. Algunas de las funciones principales de esta clase son:

- `main`: Este método principal genera aleatoriamente la cantidad de productos, la cantidad de vendedores y la cantidad de registros de ventas por vendedor. Luego, utiliza otros métodos de la clase para generar los archivos de información necesarios.
- `deleteSalesFiles`: Borra todos los archivos de ventas existentes en el directorio actual.
- `loadNamesFromFile`: Lee nombres desde un archivo y los retorna como una lista de cadenas.
- `createProductsFile`: Genera un archivo con información de productos, incluyendo un ID, nombre y precio para cada producto.
- `createSalesmenInfoFile`: Genera un archivo con información de los vendedores, incluyendo un ID, nombre, apellido y cantidad de ventas para cada vendedor. También crea archivos de ventas individuales para cada vendedor.
- `createSalesFile`: Genera un archivo de registro de ventas para un vendedor específico, incluyendo un ID de vendedor, un ID de producto y un valor de venta para cada venta.

#### SalesReportGenerator.java

Este archivo contiene una clase llamada `SalesReportGenerator`, que se encarga de generar informes de ventas basados en los datos almacenados en archivos de ventas. Algunas de las funciones principales de esta clase son:

- `main`: Este método principal llama a otros métodos de la clase para generar informes de ventas para vendedores y productos.
- `generateSalesmenReport`: Genera un informe de ventas para vendedores, incluyendo las ventas totales para cada vendedor.
- `generateProductsReport`: Genera un informe de ventas para productos, incluyendo las ventas totales y el valor promedio de venta para cada producto.
- `calculateTotalSales`: Calcula las ventas totales a partir de un archivo de ventas dado.

### Manual de Funcionamiento del Código

Relacionamos el funcionamiento de los dos archivos Java: `GenerateInfoFiles.java` y `SalesReportGenerator.java`. A continuación, se detalla cómo funciona cada archivo, seguido de ejemplos de los archivos que genera el sistema.

---

### GenerateInfoFiles.java

Este archivo contiene una clase llamada `GenerateInfoFiles`, que se encarga de generar archivos de información requeridos para una aplicación.

#### Funcionamiento:

1. **Generacion aleatoria de datos**:
   - Al ejecutar el programa, se genera aleatoriamente la cantidad de productos, la cantidad de vendedores y la cantidad de registros de ventas por vendedor.

2. **Generación de Archivos**:
   - Una vez generados los valores, el programa genera automáticamente dos archivos:
     - **products_info.txt**: Contiene información sobre los productos, incluyendo un ID, nombre y precio para cada producto.
     - **salesmen_info.txt**: Contiene información sobre los vendedores, incluyendo un ID, nombre, apellido y cantidad de ventas para cada vendedor. También crea archivos de ventas individuales para cada vendedor.

#### Ejemplo de Archivo Generado (products_info.txt):

```
ID, NombreProducto, Precio
Pdto_00001, Producto1, 472
Pdto_00002, Producto2, 508
Pdto_00003, Producto3, 488
```

#### Ejemplo de Archivo Generado (salesmen_info.txt):

```
ID, Nombre, Apellido, Ventas
1, John, Doe, 53
2, Jane, Smith, 71
3, Michael, Johnson, 65
```

---

### SalesReportGenerator.java

Este archivo contiene una clase llamada `SalesReportGenerator`, que se encarga de generar informes de ventas basados en los datos almacenados en archivos de ventas.

#### Funcionamiento:

1. **Generación de Informes**:
   - El programa automáticamente lee los archivos de ventas de los vendedores y calcula las ventas totales para cada vendedor y para cada producto.
   - Luego, genera dos informes en formato CSV:
     - **salesmen_report.csv**: Contiene un informe de ventas para los vendedores, incluyendo el nombre de cada vendedor y sus ventas totales.
     - **products_report.csv**: Contiene un informe de ventas para los productos, incluyendo el ID del producto, la cantidad vendida, el valor promedio de venta y las ventas totales.

#### Ejemplo de Archivo Generado (salesmen_report.csv):

```
Nombre, Ventas
Jane Smith, 1830
John Doe, 1725
Michael Johnson, 1596
```

#### Ejemplo de Archivo Generado (products_report.csv):

```
Producto, Cantidad, Valor Promedio, Ventas Totales
Pdto_00002, 24, 437, 10498
Pdto_00003, 21, 411, 8635
Pdto_00001, 19, 494, 9385
```

---
 
#delivery_fundamentals2
This manual describes the operation of two Java files: `GenerateInfoFiles.java` and `SalesReportGenerator.java`. These files are part of the system for generating information files and sales reports based on random data stored in files.

### English version

#### GenerateInfoFiles.java

This file contains a class called `GenerateInfoFiles`, which is responsible for generating information files required for an application. Some of the main functions of this class are:

- `main`: This main method randomly generates the number of products, the number of sellers, and the number of sales records per seller. Then, it uses other methods of the class to generate the necessary information files.
- `deleteSalesFiles`: Delete all existing sales files in the current directory.
- `loadNamesFromFile`: Reads names from a file and returns them as a list of strings.
- `createProductsFile`: Generates a file with product information, including an ID, name and price for each product.
- `createSalesmenInfoFile`: Generates a file with seller information, including an ID, first name, last name, and sales amount for each seller. It also creates individual sales files for each salesperson.
- `createSalesFile`: Generates a sales record file for a specific seller, including a seller ID, a product ID, and a sales value for each sale.

#### SalesReportGenerator.java

This file contains a class called `SalesReportGenerator`, which is responsible for generating sales reports based on data stored in sales files. Some of the main functions of this class are:

- `main`: This main method calls other methods of the class to generate sales reports for sellers and products.
- `generateSalesmenReport`: Generates a sales report for sellers, including the total sales for each seller.
- `generateProductsReport`: Generates a sales report for products, including total sales and average sales value for each product.
- `calculateTotalSales`: Calculates total sales from a given sales file.

### Code Operation Manual

We relate the operation of the two Java files: `GenerateInfoFiles.java` and `SalesReportGenerator.java`. Below is a breakdown of how each file works, followed by examples of the files the system generates.

---

### GenerateInfoFiles.java

This file contains a class called `GenerateInfoFiles`, which is responsible for generating information files required for an application.

#### Functioning:

1. **Random data generation**:
    - When running the program, the number of products, the number of sellers and the number of sales records per seller are randomly generated.

2. **File Generation**:
    - Once the values are generated, the program automatically generates two files:
      - **products_info.txt**: Contains information about the products, including an ID, name and price for each product.
      - **salesmen_info.txt**: Contains information about sellers, including an ID, first name, last name, and sales amount for each seller. It also creates individual sales files for each salesperson.

#### Example of Generated File (products_info.txt):

```
ID, ProductName, Price
Pdto_00001, Product1, 472
Pdto_00002, Product2, 508
Pdto_00003, Product3, 488
```

#### Example of Generated File (salesmen_info.txt):

```
ID, First Name, Last Name, Sales
1, John, Doe, 53
2, Jane, Smith, 71
3, Michael, Johnson, 65
```

---

### SalesReportGenerator.java

This file contains a class called `SalesReportGenerator`, which is responsible for generating sales reports based on data stored in sales files.

#### Functioning:

1. **Report Generation**:
    - The program automatically reads the sellers' sales files and calculates the total sales for each seller and for each product.
    - Then, generate two reports in CSV format:
      - **salesmen_report.csv**: Contains a sales report for salespeople, including the name of each salesperson and their total sales.
      - **products_report.csv**: Contains a sales report for products, including product ID, quantity sold, average sales value, and total sales.

#### Example Generated File (salesmen_report.csv):

```
Name, Sales
Jane Smith, 1830
John Doe, 1725
Michael Johnson, 1596
```

#### Example of Generated File (products_report.csv):

```
Product, Quantity, Average Value, Total Sales
Pdto_00002, 24, 437, 10498
Pdto_00003, 21, 411, 8635
Pdto_00001, 19, 494, 9385
```

---
