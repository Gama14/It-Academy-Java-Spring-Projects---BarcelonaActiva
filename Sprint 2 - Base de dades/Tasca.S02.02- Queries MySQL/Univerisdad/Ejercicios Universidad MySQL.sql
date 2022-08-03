SELECT apellido1, apellido2, nombre FROM persona WHERE tipo="alumno" ORDER BY apellido1, apellido2, nombre ASC;
SELECT nombre, apellido1, apellido2 FROM persona WHERE tipo="alumno" AND telefono IS NULL;
SELECT nombre, apellido1, apellido2 FROM persona WHERE tipo="alumno" AND fecha_nacimiento LIKE "%1999%";
SELECT nombre, apellido1, apellido2 FROM persona WHERE tipo="profesor" AND telefono IS NULL AND nif LIKE "%K";
SELECT nombre FROM asignatura WHERE cuatrimestre=1 AND curso=3 AND id_grado=7;
SELECT apellido1, apellido2, persona.nombre, departamento.nombre FROM persona, departamento WHERE tipo="profesor" ORDER BY apellido1, apellido2, persona.nombre ASC;
SELECT asignatura.nombre, anyo_inicio, anyo_fin FROM asignatura,curso_escolar,persona WHERE nif="26902806M";
SELECT DISTINCT departamento.nombre FROM departamento, asignatura, profesor,grado WHERE grado.id=4 AND grado.id = asignatura.id_grado AND asignatura.id_profesor= profesor.id_profesor AND profesor.id_departamento= departamento.id; 
SELECT DISTINCT nombre, apellido1, apellido2 FROM persona, alumno_se_matricula_asignatura, curso_escolar WHERE persona.id= id_alumno AND id_curso_escolar=curso_escolar.id AND anyo_inicio=2018;

SELECT departamento.nombre AS departamento, apellido1, apellido2, persona.nombre FROM persona LEFT JOIN profesor ON persona.id= id_profesor LEFT JOIN departamento ON departamento.id=profesor.id_departamento ORDER BY departamento.nombre, apellido1,apellido2, persona.nombre ASC;
SELECT persona.nombre, departamento.nombre FROM persona RIGHT JOIN profesor ON profesor.id_profesor= persona.id LEFT JOIN departamento ON profesor.id_departamento=departamento.id WHERE id_departamento IS NULL;
SELECT departamento.nombre FROM persona RIGHT JOIN profesor ON profesor.id_profesor= persona.id RIGHT JOIN departamento ON profesor.id_departamento=departamento.id WHERE id_profesor IS NULL;
SELECT persona.nombre, asignatura.nombre FROM persona RIGHT JOIN profesor ON profesor.id_profesor= persona.id LEFT JOIN asignatura ON profesor.id_profesor= asignatura.id_profesor WHERE asignatura.id_profesor IS NULL ;
SELECT persona.nombre, asignatura.nombre FROM persona RIGHT JOIN profesor ON profesor.id_profesor= persona.id RIGHT JOIN asignatura ON profesor.id_profesor= asignatura.id_profesor WHERE profesor.id_profesor IS NULL ;
SELECT DISTINCT departamento.nombre, asignatura.nombre FROM departamento LEFT JOIN profesor ON departamento.id= profesor.id_departamento LEFT JOIN asignatura ON profesor.id_profesor= asignatura.id_profesor WHERE curso IS NULL;

SELECT COUNT(*) FROM persona WHERE tipo="alumno";
SELECT COUNT(*) FROM persona WHERE tipo="alumno" AND fecha_nacimiento LIKE "%1999%";
SELECT departamento.nombre, COUNT(*) AS numero_profes FROM profesor, departamento  WHERE profesor.id_departamento= departamento.ID GROUP BY departamento.nombre ORDER BY COUNT(*) DESC;
SELECT departamento.nombre, COUNT(profesor.id_profesor) AS numero_profes FROM profesor RIGHT JOIN departamento ON profesor.id_departamento=departamento.id GROUP BY departamento.nombre;
SELECT grado.nombre, COUNT(asignatura.id) AS numero_asignaturas FROM grado LEFT JOIN asignatura ON grado.id = asignatura.id_grado GROUP BY grado.nombre ORDER BY COUNT(*) DESC;
SELECT grado.nombre, COUNT(asignatura.id) AS numero_asignaturas FROM grado INNER JOIN asignatura ON grado.id = asignatura.id_grado GROUP BY grado.nombre HAVING COUNT(asignatura.id)>40;
SELECT grado.nombre, asignatura.tipo AS tipo_asignatura, SUM(creditos) AS suma_creditos FROM grado INNER JOIN asignatura ON grado.id=asignatura.id_grado GROUP BY tipo, grado.nombre;
SELECT curso_escolar.anyo_inicio, COUNT(alumno_se_matricula_asignatura.id_alumno) AS numero_de_matriculados FROM curso_escolar LEFT JOIN alumno_se_matricula_asignatura ON curso_escolar.id = alumno_se_matricula_asignatura.id_curso_escolar GROUP BY anyo_inicio;
SELECT persona.id, persona.nombre, apellido1, apellido2, COUNT(asignatura.nombre) AS numero_asignaturas FROM persona RIGHT JOIN profesor ON persona.id = profesor.id_profesor LEFT JOIN asignatura ON profesor.id_profesor= asignatura.id_profesor GROUP BY persona.id ORDER BY COUNT(asignatura.nombre) DESC;
SELECT * FROM persona WHERE tipo="alumno" ORDER BY fecha_nacimiento ASC LIMIT 1;
SELECT  persona.nombre FROM persona RIGHT JOIN profesor ON persona.id = profesor.id_profesor INNER JOIN departamento ON profesor.id_departamento = departamento.id LEFT JOIN asignatura ON profesor.id_profesor=asignatura.id_profesor WHERE asignatura.id_profesor IS NULL;
