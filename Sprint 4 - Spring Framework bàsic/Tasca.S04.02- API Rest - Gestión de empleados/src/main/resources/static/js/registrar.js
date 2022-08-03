
$(document).ready(function() {
        //on ready

});


async function registrarEmpleado(){
 let datos ={};
 datos.nombre = document.getElementById('txtNombre').value
 datos.apellido = document.getElementById('txtApellido').value
 datos.cargo = document.getElementById('txtCargo').value
 datos.salario = document.getElementById('txtSalario').value

 const request = await fetch('api/empleados', {
    method: 'POST',
    headers: {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });

}
