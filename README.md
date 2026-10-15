# Sistema de Exportación Financiera

## Descripción

Este proyecto implementa un sistema de exportación de registros financieros hacia distintos destinos, utilizando programación orientada a objetos en Java.

Se emplea una clase abstracta llamada `ExportadorFinanciero`, que centraliza la validación de los registros y permite que cada exportador implemente su propia forma de transformar y enviar los datos.

## Funcionamiento

El programa trabaja con dos tipos de exportadores:

* **ExportadorBancoCentral:** convierte los registros a texto plano, reemplazando las comas por punto y coma. También muestra el progreso porcentual de cada registro enviado.
* **ExportadorAgenciaTributaria:** representa los registros mediante una estructura XML y muestra la cantidad de registros enviados.

Antes de exportar, el sistema comprueba que la lista no sea nula ni esté vacía y que ninguno de sus registros sea nulo o contenga únicamente espacios. Si encuentra un error, cancela la exportación.

## Clases principales

### 1. `ExportadorFinanciero`

Clase abstracta que define la estructura común de los exportadores.

**Atributos:**

* `destino`: nombre del destino de la exportación.

**Métodos principales:**

* `getDestino()`: devuelve el nombre del destino.
* `validarRegistros()`: verifica que los registros sean válidos.
* `exportar()`: valida los datos y, si son correctos, llama al método de exportación correspondiente.
* `exportarDatos()`: método abstracto que cada clase hija implementa según su formato.

El método `exportarDatos()` es `protected` para limitar su acceso directo desde clases externas y favorecer que la exportación se realice mediante el método `exportar()`, que aplica las validaciones.

### 2. `ExportadorBancoCentral`

Hereda de `ExportadorFinanciero` e implementa la exportación en formato de texto plano.

**Características:**

* Utiliza el destino `"Banco Central"`.
* Reemplaza las comas de cada registro por punto y coma.
* Calcula y muestra el porcentaje de progreso.
* Informa cuando finaliza la transferencia.

### 3. `ExportadorAgenciaTributaria`

Hereda de `ExportadorFinanciero` e implementa la representación de los registros en formato XML.

**Características:**

* Utiliza el destino `"Agencia Tributaria"`.
* Genera etiquetas `<declaracion>` y `<registro>`.
* Asigna un identificador numérico a cada registro.
* Informa la cantidad de registros enviados.

**Nota:** el código simula la generación y el envío de XML. No implementa una firma digital real ni una conexión con una agencia tributaria.

### 4. `Main`

Contiene el método principal del programa.

Sus responsabilidades son:

* Crear una lista de exportadores.
* Preparar una lista con tres registros financieros.
* Ejecutar la exportación con datos válidos para ambos destinos.
* Probar el comportamiento del sistema con una lista vacía.

## Ejemplo de funcionamiento

Los registros utilizados son:

* `Activo corriente,450000`
* `Pasivo corriente,210000`
* `Patrimonio neto,240000`

Para el Banco Central, los registros se muestran con punto y coma como separador y con su porcentaje de progreso.

Para la Agencia Tributaria, se muestran dentro de una estructura XML.

Cuando se utiliza una lista vacía, ambos exportadores informan el error y cancelan la operación sin procesar los datos.

## Conceptos de programación utilizados

* **Abstracción:** `ExportadorFinanciero` define una estructura general para los exportadores.
* **Herencia:** los exportadores concretos heredan de la clase abstracta.
* **Polimorfismo:** una lista de tipo `ExportadorFinanciero` permite almacenar y ejecutar distintos tipos de exportadores.
* **Sobrescritura de métodos:** cada clase hija implementa `exportarDatos()` con su propio comportamiento.
* **Encapsulamiento:** se utilizan modificadores de acceso como `protected` y `public`.
* **Validación de datos:** se comprueba la validez de los registros antes de exportarlos.
* **Colecciones:** se utilizan `List`, `ArrayList` y `Arrays.asList()` para administrar los datos.

## Tecnologías utilizadas

* Java
* Programación Orientada a Objetos
* IntelliJ IDEA

## Ejecución

<img width="696" height="752" alt="image" src="https://github.com/user-attachments/assets/8435ce5a-05ce-4c19-bcb6-ff9e687a9bae" />

## Objetivo del ejercicio

Practicar el uso de clases abstractas, herencia y polimorfismo, centralizando las validaciones en una clase base y permitiendo que cada clase derivada implemente una estrategia de exportación diferente.
