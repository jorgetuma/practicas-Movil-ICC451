En este proyecto se implemntaron dos vistas, 
una para un Listview y otra para un Recyclerview.

El listview fue el mas sencillo de implemtar esto pues
se utiliza una lista de Strings que representan las tareas y como adaptador se utliza uno de los que provee la libreria Android.

Para implentar la funcionalidad de eliminar y agregar tarea se utilizan pop-ups en el listview y en el Ryclerview.

El recyclerView fue mas desafiante debido a que se creo un adaptador personalizado para el mismo, ademas de la particularidad de que se debia notificar mediante codigo los cambios realizados a la lista base.
El codigo que se utilizo para implemntar el Recyclerview puede ser reutilizado y expandido  en asignaciones futuras.