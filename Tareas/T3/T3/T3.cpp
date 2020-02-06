#include <iostream>
#include <string>

using namespace std;

class Nodo {
public:
	int carnet;
	string nombre;
	Nodo* sig;
	Nodo(string nombre, int carnet) {
		this->nombre = nombre;
		this->carnet = carnet;
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
	void insertar(string nombre, int carnet) {
		Nodo* nuevo = new Nodo(nombre, carnet);
		nuevo->sig = primero;
		primero = nuevo;
	}
	Nodo *buscar(int carnet) {
		Nodo* aux = primero;
		while (aux->carnet != carnet) {
			aux = aux->sig;
		}
		cout << "Encontrado " + aux->nombre << endl;
		return aux;
	}
	//elimina al primero en la lista
	void eliminar(Nodo *nodo) {
		Nodo* aux = primero;
		while (aux->nombre != nodo->nombre) {
			aux = aux->sig;
		}
		aux->sig = 0;//elimina todos los nodos que siguen
	
	}
	void print() {
		Nodo* aux = primero;
		while (aux->sig != 0) {
			cout << aux->nombre << endl;
			aux = aux->sig;
		}
		cout << aux->nombre << endl;
	}
};
int main()
{
	Lista* lista = new Lista();
	Nodo* nodo = new Nodo("Mishel", 201504893);
	lista->insertar("Lourdes",201602935);
	lista->insertar("Mishel",201504893);
	lista->insertar("Lorenzana",201864783);
	lista->insertar("Ochoa",201754387);
	lista->print();
	lista->buscar(201602935);
	lista->eliminar(nodo);
	lista->print();

	
}