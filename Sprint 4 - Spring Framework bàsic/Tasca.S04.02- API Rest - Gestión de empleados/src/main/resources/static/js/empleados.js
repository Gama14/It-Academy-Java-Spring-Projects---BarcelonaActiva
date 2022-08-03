// Call the dataTables jQuery plugin
$(document).ready(function() {

   cargarEmpleados();
  $('#empleados').DataTable();
});


async function cargarEmpleados(){
 const request = await fetch('api/empleados', {
    method: 'GET',
    headers: {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
    }
  });
   const empleados = await request.json();


   let listadoHtml = '';
     for (let empleado of empleados){
     let botonEliminar = '<a td:href="#" onclick="eliminarEmpleado('+empleado.id+')" class="btn btn-danger">Delete</a>';


     let empleadoHtml = '<tr><td>'+empleado.nombre+'</td><td>'
                        +empleado.apellido+'</td><td>'+empleado.cargo+
                        '</td><td>'+empleado.salario+'</td><td>'+empleado.id+
                        '</td><td>'+botonEliminar+'</td></tr>'
       listadoHtml += empleadoHtml;
     }

     document.querySelector ('#empleados tbody').outerHTML = listadoHtml;
}
async function eliminarEmpleado (id){

 if(!confirm('Desea eliminar este usuario?')){
    return;
 }

 const request = await fetch('api/empleados' + id,{
    method: 'DELETE',
    headers: {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
    }
  });
  location.reload();
}

