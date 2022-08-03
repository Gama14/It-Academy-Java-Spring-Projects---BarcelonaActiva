$(document).ready(function() {
        //on ready

});


async function updateEmpleado(id){
 empleado.Nombre = document.getElementById('txtNombre').value
 empleado.Apellido = document.getElementById('txtApellido').value
 empleado.Cargo = document.getElementById('txtCargo').value
 empleado.Salario = document.getElementById('txtSalario').value
 }
 const request = await fetch('api/empleados'+ id, {
    method: 'PUT',
    headers: {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
    },
    body: JSON.stringify(empleado)
  });

}