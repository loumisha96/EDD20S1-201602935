# Especificación Informal
 **Moneda:** CrearMoneda, Transeferir, TrasferirFrom

 **Descripción:** Se crean monedas que pertenecen a la clase, que luego pueden ser transferidas del monedero a una persona, o de una persona a otra

 **Operaciones:**

 * CrearMoneda(nombre, valor)devuelve(moneda)
   -efecto: crea moneda nueva
 * Transferir(IDdueño, cant)devuelve()
   - requerimiento: cantMonedero > 0
   - modifica: cant
   - efecto: El IDdueño recibe cant de monedas y el monedero disminuye
 * TransferirFrom(IDdueño1, IDdueño2, cant)
   - requerimiento: cant de IDdueño1>0
   - modifica: cant
   - efecto: IDdueño1 transfiere cant de monedas a IDdueño2, cant de IDdueño1 disminuye y cant de IDdueño2 aumenta
    


