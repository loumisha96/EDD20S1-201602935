#include <iostream>
#include <string>

using namespace std;

class Nodo {
public:
	string dato;
	Nodo* sig;
	Nodo(string dato) {
		this->dato = dato;
		this->sig = 0;
	};
};
class Lista {
public:
	Nodo* primero;
	Lista() {
		this->primero = 0;
	}
	bool vacia() {
		return primero == 0;
	}
	void insertar(string dato) {
		Nodo* nuevo = new Nodo(dato);
		nuevo->sig = primero;
		primero = nuevo;
	}
	Nodo *buscar(string dato) {
		Nodo* aux = new Nodo(dato);
		aux = primero;
		while (aux->dato != dato) {
			aux = aux->sig;
		}
		return aux;
	}
	//elimina al primero en la lista
	void eliminar() {
		Nodo* aux = primero;
		primero = aux->sig;
		aux->sig = 0;
	
	}
};
int main()
{
	Lista* lista = new Lista();
	lista->insertar("Lourdes");
	lista->insertar("Mishel");
	lista->insertar("Lorenzana");
	lista->insertar("Ochoa");
	lista->buscar("Mishel");
	lista->eliminar();

	
}