package main;

import entidad.Persona;

public class MainPersona {
	public static void main(String[] args) {
		//Creamos un objeto
		new Persona();
		//Creammos otro objeto
		new Persona();
		//En java existe un pequeño programa que se llama el garbage collector, o recolector de basura
		//que eliminara objetos muertos o que no se usen. Un objeto morira cuando no tenga referencias
		//apuntandole
		
		//Creamos una referencia de tipo persona. Una referencia es una variable que guarda
		//la direccion de memoria de donde esta el objeto. Se dice comunmente como "Apunta"
		Persona p1;
		
		//Normalmente van de la mano, la referencia y el objeto
		//El ciclo de vida de un objeto en java es mientras al menos tenga una referencia apuntandole
		Persona p = new Persona();
		p = null;
		
		//el ciclo de vida de una referencia es bloque donde se haya creado hasta el final del bloque
		{
			Persona p2 = new Persona();
		}
		
		//p2 = null;//esto da error, no existe p2
		
		Persona p3 = new Persona();
		p3.nombre = "goku";//donde apunte p3, me cambias el nombre
		p3.edad = 40;//donde apunte p3, me cambias la edad
		
		//p4  apunta al mismo objeto que p3
		Persona p4 = p3;
		
		p4.edad = 55;
		
		System.out.println(p3.edad);//55
		System.out.println(p4.edad);//55
		
		int numero1 = 5;
		int numero2 = numero1;
		
		numero2 = 10;
		
		System.out.println(numero1);
		
		cambiarEdad(p4);
		
		System.out.println(p3.edad);
		System.out.println(p4.edad);
		//77 77
		p3 = null;
		p4 = null;
	}
	
	
	public static void cambiarEdad(Persona p) {
		p.edad = 77;
	}
}
